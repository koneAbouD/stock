package com.tmk.jpa.repository;

import javax.persistence.criteria.FetchParent;
import javax.persistence.metamodel.Attribute;

/**
 * Exception lancée lorsqu'il est impossible de créer les fetchs avec {@link FetchBuilder}.
 */
public class FetchBuilderException extends RuntimeException {

    /**
     * Crée une exception.
     *
     * @param fetchParent le parent sur lequel est effectué le fetch.
     * @param attribute l'attribut qu'il est impossible de fetcher à partir du fetchParent.
     */
    public FetchBuilderException(FetchParent<?, ?> fetchParent, Attribute<?, ?> attribute) {
        super(String.format("Impossible d'effectuer le fetch de l'attribut %s à partir de %s",
                attribute.getName(),
                fetchParent));
    }
}
