package com.stock.repository.client;

import com.tmk.jpa.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface ClientRepository extends CrudRepository {

    Map<String, Client> rechercherParNom(List<String> noms);
}
