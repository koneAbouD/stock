package com.tmk.jpa.model;

import com.tmk.utils.SecurityUtils;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.time.Instant;
import java.util.Objects;

/**
 * Classe parente de tous les objets du domaine managés par JPA.<br/>
 * Elle implémente notamment un comportement par défaut sur les méthodes equals() et hashcode() pertinent pour des objets JPA.
 *
 * @see @Entity
 */
@MappedSuperclass
public abstract class AbstractEntity implements JpaConstants {

    @Version
    protected long version;


    public AbstractEntity() {
        super();
    }

    public boolean isNew() {
        return getId() == null;
    }

    /**
     * Id de l'entité.
     *
     * @return Id de l'entité.
     */
    public abstract Long getId();

    public long getVersion() {
        return version;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (this.getClass().isAssignableFrom(o.getClass())) {
            AbstractEntity e = (AbstractEntity) o;
            // On se base sur les champs @Id si ils sont non null
            if (getId() != null && e.getId() != null) {
                return Objects.equals(getId(), e.getId());
            }

            return equalsOnOtherFields(e);
        }

        return false;
    }

    /**
     * Méthode appelée lorsque l'égalité sur l'id est fausse.<br/>
     * Permet de tester éventuellement d'autres champs pour l'égalité.<br/>
     * Par défaut, vérifie simplement l'égalité au sens de Object.<br/>
     * On garantit que other est non null en entrant dans cette méthode.
     *
     * @param other
     * @return
     */
    protected boolean equalsOnOtherFields(AbstractEntity other) {
        return super.equals(other);
    }

    @Override
    public int hashCode() {
        // On se base sur le champ @Id si il est non null, sinon implémentation par défaut
        return getId() != null ? getId().hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s{id=%s}", getClass().getSimpleName(), getId());
    }
}