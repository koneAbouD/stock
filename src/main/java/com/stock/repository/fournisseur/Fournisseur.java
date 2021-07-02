package com.stock.repository.fournisseur;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Fournisseur {

    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
}
