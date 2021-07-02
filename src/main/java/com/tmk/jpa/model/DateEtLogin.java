package com.tmk.jpa.model;

import javax.persistence.Embeddable;
import java.time.Instant;

/**
 * Objet de gestion d'un couple (date,login).
 * Utilisé pour tracer les dates de créations et de modifications des objets dans le SI.
 */
@Embeddable
public class DateEtLogin {

    private Instant date;

    private String login;

    public DateEtLogin() {
        super();
    }

    public DateEtLogin(String login, Instant date) {
        super();
        this.login = login;
        this.date = date;
    }

    public Instant getDate() {
        return date;
    }

    public String getLogin() {
        return login;
    }

    /**
     * Permet de modifier l'objet en affectant une date et en login.
     *
     * @param date la date que l'on souhaite affecter.
     * @param login le login que l'on veut affecter.
     */
    public void update(Instant date, String login) {
        this.date = date;
        this.login = login;
    }
}