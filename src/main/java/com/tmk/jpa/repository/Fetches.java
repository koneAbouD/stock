package com.tmk.jpa.repository;

import javax.persistence.criteria.JoinType;
import javax.persistence.metamodel.Attribute;

public class Fetches {

    private Fetches() {
        // Utility class
    }

    /**
     * Crée une FetchOperation avec une jointure de type {@link JoinType#INNER}.
     *
     * @param attribute l'attribut sur lequel sera effectué le fetch.
     * @param nestedAttributes les attributs relatifs à attribute sur lesquels seront successivement effectués les fetchs. (Optionnel).
     */
    public static <T> FetchOperation<T> fetch(Attribute<? super T, ?> attribute, Attribute<?, ?>... nestedAttributes) {
        return fetch(FetchOperation.DEFAULT_JOIN, attribute, nestedAttributes);
    }

    /**
     * Crée une FetchOperation.
     *
     * @param joinType le type de jointure.
     * @param attribute l'attribut sur lequel sera effectué le fetch.
     * @param nestedAttributes les attributs relatifs à attribute sur lesquels seront successivement effectués les fetchs. (Optionnel).
     */
    public static <T> FetchOperation<T> fetch(JoinType joinType, Attribute<? super T, ?> attribute, Attribute<?, ?>... nestedAttributes) {
        return new FetchOperation.FetchOperationBuilder(joinType, attribute)
                .addAttributes(nestedAttributes)
                .build();
    }

    /**
     * Crée une FetchOperation en partant d'une autre FetchOperation et en ajoutant des attributs en partant de la feuille de parentFetchOperation.
     * Le type de jointure est celui de parentFetchOperation.
     *
     * @param parentFetchOperation la FetchOperation parente.
     * @param nestedAttributes les attributs à fetcher supplémentaires en partant du dernier attribut de parentFetchOperation.
     * @param <T> le type de donnée.
     * @return la FetchOperation correspondante.
     */
    public static <T> FetchOperation<T> fetch(FetchOperation<T> parentFetchOperation, Attribute<?, ?>... nestedAttributes) {
        return new FetchOperation.FetchOperationBuilder(parentFetchOperation.getJoinType(), parentFetchOperation.getFirstAttribute())
                .addAttributes(parentFetchOperation.getNestedAttributes())
                .addAttributes(nestedAttributes)
                .build();
    }

    /**
     * Crée une FetchOperation en partant d'une autre FetchOperation et en ajoutant des attributs en partant de la feuille de parentFetchOperation.
     *
     * @param joinType le type de jointure.
     * @param parentFetchOperation la FetchOperation parente.
     * @param nestedAttributes les attributs à fetcher supplémentaires en partant du dernier attribut de parentFetchOperation.
     * @param <T> le type de donnée.
     * @return la FetchOperation correspondante.
     */
    public static <T> FetchOperation<T> fetch(JoinType joinType, FetchOperation<T> parentFetchOperation, Attribute<?, ?>... nestedAttributes) {
        return new FetchOperation.FetchOperationBuilder(joinType, parentFetchOperation.getFirstAttribute())
                .addAttributes(parentFetchOperation.getNestedAttributes())
                .addAttributes(nestedAttributes)
                .build();
    }

    /**
     * Crée une FetchOperation à partir d'un attribut et de nestedAttributes.
     * Le type de jointure est celui de nestedFetchOperation.
     *
     * @param attribute l'attribut sur lequel sera effectué le fetch.
     * @param nestedAttributes les attributs relatifs à attribute sur lesquels seront successivement effectués les fetchs. (Optionnels)
     * @param nestedFetchOperation ses attributs sont ajoutés aux nested attributes.
     * @param <T> le type de donnée.
     * @return la FetchOperation correspondante.
     */
    public static <T> FetchOperation<T> fetch(Attribute<T, ?> attribute, Attribute<?, ?>[] nestedAttributes, FetchOperation<?> nestedFetchOperation) {
        return new FetchOperation.FetchOperationBuilder(nestedFetchOperation.getJoinType(), attribute)
                .addAttributes(nestedAttributes)
                .addAttributes(nestedFetchOperation.getAttributes())
                .build();
    }

    /**
     * Crée une FetchOperation à partir d'un attribut et de nestedAttributes.
     *
     * @param joinType le type de jointure.
     * @param attribute l'attribut sur lequel sera effectué le fetch.
     * @param nestedAttributes les attributs relatifs à attribute sur lesquels seront successivement effectués les fetchs. (Optionnels)
     * @param nestedFetchOperation ses attributs sont ajoutés aux nested attributes.
     * @param <T> le type de donnée.
     * @return la FetchOperation correspondante.
     */
    public static <T> FetchOperation<T> fetch(JoinType joinType, Attribute<T, ?> attribute, Attribute<?, ?>[] nestedAttributes, FetchOperation<?> nestedFetchOperation) {
        return new FetchOperation.FetchOperationBuilder(joinType, attribute)
                .addAttributes(nestedAttributes)
                .addAttributes(nestedFetchOperation.getAttributes())
                .build();
    }
}
