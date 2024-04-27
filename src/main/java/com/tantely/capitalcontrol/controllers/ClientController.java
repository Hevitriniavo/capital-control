package com.tantely.capitalcontrol.controllers;

import com.tantely.capitalcontrol.dtos.ClientResponse;
import com.tantely.capitalcontrol.services.ClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public List<ClientResponse> getAllClient(){
        return List.of();
    }
}
