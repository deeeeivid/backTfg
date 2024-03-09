package com.urjc.tfg.models.dao;

import com.urjc.tfg.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
