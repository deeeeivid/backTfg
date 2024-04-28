package com.urjc.tfg.models.repository;

import com.urjc.tfg.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductoRepository extends CrudRepository<Producto, Long> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
