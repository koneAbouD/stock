package com.stock.repository.commandeClient;

import com.stock.repository.client.Client;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = CommandeClient.TABLE_NAME)
public class CommandeClient {

    public static final String TABLE_NAME = "commande_client";

    @Id
    private Long id;
    private String code;
    private String designation;
    private Date date;
    private float totalHT;
    private float tva;
    private float totalTTC;

    @JoinColumn(name = "client_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

}
