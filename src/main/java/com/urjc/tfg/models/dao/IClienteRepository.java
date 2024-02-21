package com.urjc.tfg.models.dao;

import com.urjc.tfg.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {
}
