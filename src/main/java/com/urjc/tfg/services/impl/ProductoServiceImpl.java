package com.urjc.tfg.services.impl;

import com.urjc.tfg.models.entity.Producto;
import com.urjc.tfg.models.repository.IProductoRepository;
import com.urjc.tfg.services.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    public final IProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
