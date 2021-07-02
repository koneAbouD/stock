package com.stock.repository.client;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Client> getClazz() {
        return Client.class;
    }

    @Override
    public Map<String, Client> rechercherParNom(List<String> noms) {

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = builder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);

        criteriaQuery.select(root).where(root.get("nom").in(noms));

        TypedQuery<Client> typedQuery = entityManager.createQuery(criteriaQuery);

        return typedQuery.getResultStream()
                .collect(Collectors.toMap(Client::getNom, Function.identity()));
    }
}
