package com.urjc.tfg.models.services;

import com.urjc.tfg.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();

}
