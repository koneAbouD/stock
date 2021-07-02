package com.stock.service.client;

import com.stock.repository.client.Client;

import java.util.Collection;
import java.util.List;

public interface ClientService {
    public List<Client> listClients();
    public void saveAll(List<Client> clients);
    public void save(Client client);
}
