package com.stock.repository.client;

import com.tmk.jpa.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = Client.TABLE_NAME)
@Access(AccessType.FIELD)
public class Client extends AbstractEntity {

    public static final String TABLE_NAME = "client";

    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String adresseLivraison;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }
}
