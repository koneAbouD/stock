package com.stock.controleur;

import com.stock.repository.client.Client;
import com.stock.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ws/")
public class ClientControleur {

    private final ClientService clientService;

    @Autowired
    public ClientControleur(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> clients(){
        return this.clientService.listClients();
    }

    @PostMapping("/clients")
    public void enregistreClients(@RequestBody List<Client> clients){
        this.clientService.saveAll(clients);
    }

    @PutMapping("/client")
    @CrossOrigin
    public void enregistre(@RequestBody Client client){
        this.clientService.save(client);
    }

    @GetMapping("/bonjour")
    public String bonjour(){
        return "bonjour à tous !";
    }
}
