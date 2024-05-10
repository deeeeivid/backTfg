package com.urjc.tfg.models.repository;

import com.urjc.tfg.models.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {

}
