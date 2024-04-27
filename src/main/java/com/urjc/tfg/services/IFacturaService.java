package com.urjc.tfg.services;

import com.urjc.tfg.models.entity.Factura;

public interface IFacturaService {

    Factura findById(Long id);

    Factura save(Factura factura);

    void deleteById(Long id);

}
