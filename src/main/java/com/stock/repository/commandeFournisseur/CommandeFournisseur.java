package com.stock.repository.commandeFournisseur;

import com.stock.repository.fournisseur.Fournisseur;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = CommandeFournisseur.TABLE_NAME)
public class CommandeFournisseur {

    public static final String TABLE_NAME = "commande_fournisseur";

    @Id
    private Long id;
    private String code;
    private String designation;
    private Date date;
    private float totalHT;
    private float tva;
    private float totalTTC;

    @JoinColumn(name = "fournisseur_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Fournisseur fournisseur;
}
