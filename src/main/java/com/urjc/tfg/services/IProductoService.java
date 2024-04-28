package com.urjc.tfg.services;

import com.urjc.tfg.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findByNombre(String nombre);

}
