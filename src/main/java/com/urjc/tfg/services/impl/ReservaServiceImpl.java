package com.urjc.tfg.services.impl;

import com.urjc.tfg.models.entity.GeneroMusical;
import com.urjc.tfg.models.entity.RangoEdad;
import com.urjc.tfg.models.entity.Reserva;
import com.urjc.tfg.models.entity.TipoEvento;
import com.urjc.tfg.models.repository.IGeneroMusicalRepository;
import com.urjc.tfg.models.repository.IRangoEdadRepository;
import com.urjc.tfg.models.repository.IReservaRepository;
import com.urjc.tfg.models.repository.ITipoEventoRepository;
import com.urjc.tfg.services.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements IReservaService {

    private final IReservaRepository iReservaRepository;
    private final ITipoEventoRepository iTipoEventoRepository;
    private final IGeneroMusicalRepository iGeneroMusicalRepository;
    private final IRangoEdadRepository iRangoEdadRepository;

    @Override
    @Transactional
    public Reserva save(Reserva reserva) {
        return iReservaRepository.save(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoEvento> findAllTiposEventos() {
        return (List<TipoEvento>) iTipoEventoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<GeneroMusical> findAllGenerosMusicales() {
        return (List<GeneroMusical>) iGeneroMusicalRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<RangoEdad> findAllRangoEdades() {
        return (List<RangoEdad>) iRangoEdadRepository.findAll();
    }
}
