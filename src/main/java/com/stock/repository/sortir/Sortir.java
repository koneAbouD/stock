package com.stock.repository.sortir;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Sortir {

    @Id
    private Long id;
    private Date date;
    private int quantite;
    private String Description;
}
