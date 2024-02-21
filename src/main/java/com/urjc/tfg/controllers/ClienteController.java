package com.urjc.tfg.controllers;

import com.urjc.tfg.models.entity.Cliente;
import com.urjc.tfg.models.services.IClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteController {

    private IClienteService iClienteService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return iClienteService.findAll();
    }
}
