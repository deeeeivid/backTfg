package com.urjc.tfg.services;

import com.urjc.tfg.models.entity.Reserva;
import com.urjc.tfg.models.entity.ReservaPendiente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReservaService {

    List<Reserva> findAll();

    Page<Reserva> findAll(Pageable pageable);

    Reserva findById(Long id);

    Reserva guardar(ReservaPendiente reserva);

    void eliminar(Long id);

}
