package com.stock.repository.entree;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Entree {

    @Id
    private Long id;
    private Date date;
    private int quantite;
    private String Description;
}
