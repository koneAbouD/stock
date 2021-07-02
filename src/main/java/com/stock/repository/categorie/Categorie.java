package com.stock.repository.categorie;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Categorie {
    @Id
    private Long id;
    private String designation;
}
