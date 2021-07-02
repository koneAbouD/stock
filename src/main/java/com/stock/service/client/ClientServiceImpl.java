package com.stock.service.client;

import com.stock.repository.client.Client;
import com.stock.repository.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> listClients() {
        return clientRepository.listerEnList();
    }

    @Override
    public void saveAll(List<Client> clients) {
        clients.forEach(clientRepository::save);
    }

    @Override
    public void save(Client client) {
        this.clientRepository.save(client);
    }
}