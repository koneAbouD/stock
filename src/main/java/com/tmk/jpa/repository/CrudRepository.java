package com.tmk.jpa.repository;

import com.tmk.jpa.model.AbstractEntity;
import com.tmk.utils.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.tmk.utils.CollectionUtils.isNullOrEmpty;

public interface CrudRepository<T extends AbstractEntity> {

    /**
     * Le nom par défaut de l'attribut id.
     */
    String ID_ATTRIBUTE_NAME = "id";

    EntityManager getEntityManager();

    Class<T> getClazz();

    default T save(T entity) {
        if (entity.isNew()) {
            getEntityManager().persist(entity);
            return entity;
        }
        else {
            return getEntityManager().merge(entity);
        }
    }

    default TypedQuery<T> listerQueryImpl(QueryOptions<T>... queryOptions) {
        Optional<QueryOptions<T>> optionsOpt = queryOptions != null && queryOptions.length > 0 ? Optional.of(queryOptions[0]) : Optional.empty();

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getClazz());
        Root<T> root = query.from(getClazz());

        optionsOpt.ifPresent(options -> options.applyFetchOperations(root));

        TypedQuery<T> typedQuery = getEntityManager().createQuery(query);

        optionsOpt.ifPresent(options -> options.applyHints(typedQuery));

        return typedQuery;
    }

    default Stream<T> lister(QueryOptions<T>... queryOptions) {
        return listerQueryImpl(queryOptions).getResultStream().distinct();
    }

    default List<T> listerEnList(QueryOptions<T>... queryOptions) {
        return listerQueryImpl(queryOptions).getResultList().stream().distinct().collect(Collectors.toList());
    }

    default Optional<T> findByImpl(long id, QueryOptions<T>... queryOptions) {
        Optional<QueryOptions<T>> optionsOpt = queryOptions != null && queryOptions.length > 0 ? Optional.of(queryOptions[0]) : Optional.empty();

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getClazz());
        Root<T> root = query.from(getClazz());

        optionsOpt.ifPresent(options -> options.applyFetchOperations(root));

        query.where(builder.equal(root.get(ID_ATTRIBUTE_NAME), id));

        TypedQuery<T> typedQuery = getEntityManager().createQuery(query);

        optionsOpt.ifPresent(options -> options.applyHints(typedQuery));

        // avec les FetchOperations, il se peut que le résultat retourné soit démultiplié
        // dans tous les cas, on ne retourne que le 1er élément
        Supplier<Stream<T>> results = () -> typedQuery.getResultStream();
        if (!results.get().findAny().isPresent()) {
            if (optionsOpt.isPresent() && optionsOpt.get().isObligatoire()) {
               // throw entiteNonTrouveeParId(id);
            }
            return Optional.empty();
        }
        return results.get().findFirst();
    }

    default Optional<T> findById(long id, QueryOptions<T>... queryOptions) {
        return findByImpl(id, queryOptions);
    }

    default Map<Long, T> findByIds(Collection<Long> ids, QueryOptions<T>... queryOptions) {
        if (isNullOrEmpty(ids)) {
            return Collections.emptyMap();
        }

        Optional<QueryOptions<T>> optionsOpt = queryOptions != null && queryOptions.length > 0 ? Optional.of(queryOptions[0]) : Optional.empty();

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getClazz());
        Root<T> root = query.from(getClazz());

        optionsOpt.ifPresent(options -> options.applyFetchOperations(root));

        query.where(root.get(ID_ATTRIBUTE_NAME).in(ids));

        TypedQuery<T> typedQuery = getEntityManager().createQuery(query);

        optionsOpt.ifPresent(options -> options.applyHints(typedQuery));

        // avec les FetchOperations, il se peut que le résultat retourné soit démultiplié
        // dans tous les cas, on ne retourne que le 1er élément
        Set<T> results = typedQuery.getResultStream().collect(Collectors.toSet());
        if (optionsOpt.isPresent() && optionsOpt.get().isObligatoire() && ids.size() != results.size()) {
            //Collection<Long> differences = CollectionUtils.subtract(ids, results.stream().map(T::getId).collect(Collectors.toSet()));
            //throw entitesNonTrouveesParIds(differences);
        }
        return results.stream().collect(Collectors.toMap(T::getId, Function.identity()));
    }

    default T findByIdObligatoire(long id, QueryOptions<T>... queryOptions) {
        Optional<T> entityOpt = findByImpl(id, queryOptions);
        return entityOpt.orElseThrow(() -> null);
    }

    /*default EntiteNonConnueException entiteNonTrouveeParId(long id) {
        return new EntiteNonConnueException("Aucun résultat trouvé pour l'id %s", id);
    }

    default EntiteNonConnueException entitesNonTrouveesParIds(Collection<Long> ids) {
        return new EntiteNonConnueException("Aucun résultat trouvé pour les ids %s", ids.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }*/

    default void delete(long entityId) {
        Optional.ofNullable(getEntityManager().find(getClazz(), entityId))
                .ifPresent(getEntityManager()::remove);
    }

    default void delete(T entity) {
        getEntityManager().remove(entity);
    }

    default void flush() {
        getEntityManager().flush();
    }

    default void flushAndClear() {
        getEntityManager().flush();
        getEntityManager().clear();
    }
}
