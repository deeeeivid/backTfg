package com.urjc.tfg.services;

import com.urjc.tfg.models.entity.GeneroMusical;
import com.urjc.tfg.models.entity.RangoEdad;
import com.urjc.tfg.models.entity.ReservaPendiente;
import com.urjc.tfg.models.entity.TipoEvento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReservaPendienteService {


    Page<ReservaPendiente> findAll(Pageable pageable);

    ReservaPendiente findById(Long id);

    ReservaPendiente guardar(ReservaPendiente reserva);

    void eliminar(Long id);

    List<TipoEvento> findAllTiposEventos();

    List<GeneroMusical> findAllGenerosMusicales();

    List<RangoEdad> findAllRangoEdades();


}
