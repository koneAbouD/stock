package com.stock.repository.ligne_commande;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class LigneCommande {

    @Id
    private Long id;
    private float prixUnitaire;
    private int quantite;
    private float totalHT;
    private float tva;
    private float totalTTC;
}
