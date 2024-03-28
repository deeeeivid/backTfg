package com.urjc.tfg.services.Impl;

import com.urjc.tfg.models.entity.Cliente;
import com.urjc.tfg.models.entity.Region;
import com.urjc.tfg.models.repository.IClienteRepository;
import com.urjc.tfg.models.repository.IRegionRepository;
import com.urjc.tfg.services.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository iClienteRepository;
    private final IRegionRepository iRegionRepository;

    @Override
    public List<Cliente> findAll() {
        return iClienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return iClienteRepository.findAll(pageable);
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
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return (List<Region>) iRegionRepository.findAll();
    }
}
