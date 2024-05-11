package com.urjc.tfg.services;

import com.urjc.tfg.models.entity.GeneroMusical;
import com.urjc.tfg.models.entity.RangoEdad;
import com.urjc.tfg.models.entity.Reserva;
import com.urjc.tfg.models.entity.TipoEvento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReservaService {

    List<Reserva> findAll();

    Page<Reserva> findAll(Pageable pageable);

    Reserva findById(Long id);

    Reserva guardar(Reserva reserva);

    void eliminar(Long id);

    List<TipoEvento> findAllTiposEventos();

    List<GeneroMusical> findAllGenerosMusicales();

    List<RangoEdad> findAllRangoEdades();

}
