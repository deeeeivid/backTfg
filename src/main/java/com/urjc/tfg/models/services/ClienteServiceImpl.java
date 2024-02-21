package com.urjc.tfg.models.services;

import com.urjc.tfg.models.dao.IClienteRepository;
import com.urjc.tfg.models.entity.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private IClienteRepository iClienteRepository;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) iClienteRepository.findAll();
    }
}
