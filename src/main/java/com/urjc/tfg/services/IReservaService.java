package com.urjc.tfg.services;

import com.urjc.tfg.models.entity.GeneroMusical;
import com.urjc.tfg.models.entity.RangoEdad;
import com.urjc.tfg.models.entity.Reserva;
import com.urjc.tfg.models.entity.TipoEvento;

import java.util.List;

public interface IReservaService {

    Reserva save(Reserva reserva);

    List<TipoEvento> findAllTiposEventos();

    List<GeneroMusical> findAllGenerosMusicales();

    List<RangoEdad> findAllRangoEdades();

}
