package com.urjc.tfg.services.Impl;

import com.urjc.tfg.models.entity.Factura;
import com.urjc.tfg.models.repository.IFacturaRepository;
import com.urjc.tfg.services.IFacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements IFacturaService {

    public final IFacturaRepository facturaRepository;

    @Override
    @Transactional(readOnly = true)
    public Factura findById(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }
}
