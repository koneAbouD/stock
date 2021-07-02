package com.stock.repository.produit;

import com.stock.repository.categorie.Categorie;
import com.stock.repository.entree.Entree;
import com.stock.repository.sortir.Sortir;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Produit {

    @Id
    private Long id;
    private String reference;
    private String description;
    private float prixAchat;
    private float prixVente;
    private int quantiteStockMin;
    private String codebarre;
    @ManyToOne
    private Categorie categorie;
    @ManyToOne
    private Entree entree;
    @ManyToOne
    private Sortir sortir;
}
