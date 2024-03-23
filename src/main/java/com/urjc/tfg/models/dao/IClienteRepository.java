package com.urjc.tfg.models.dao;

import com.urjc.tfg.models.entity.Cliente;
import com.urjc.tfg.models.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("FROM Region")
    List<Region> findAllRegiones();

}
