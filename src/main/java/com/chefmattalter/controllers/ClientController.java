package com.chefmattalter.controllers;

import com.chefmattalter.models.Client;
import com.chefmattalter.models.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@RequestParam long id) {
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
