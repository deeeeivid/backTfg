package com.urjc.tfg.models.services;

import com.urjc.tfg.models.dao.IClienteRepository;
import com.urjc.tfg.models.entity.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private IClienteRepository iClienteRepository;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) iClienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return iClienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return iClienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            iClienteRepository.deleteById(id);
        }else {
            throw new RuntimeException();
        }
    }
}
