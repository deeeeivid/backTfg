package com.urjc.tfg.services.impl;

import com.urjc.tfg.models.entity.GeneroMusical;
import com.urjc.tfg.models.entity.RangoEdad;
import com.urjc.tfg.models.entity.ReservaPendiente;
import com.urjc.tfg.models.entity.TipoEvento;
import com.urjc.tfg.models.repository.*;
import com.urjc.tfg.services.IReservaPendienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaPendienteServiceImpl implements IReservaPendienteService {

    private final IReservaPendienteRepository iReservaPendienteRepository;
    private final ITipoEventoRepository iTipoEventoRepository;
    private final IGeneroMusicalRepository iGeneroMusicalRepository;
    private final IRangoEdadRepository iRangoEdadRepository;


    @Override
    @Transactional(readOnly = true)
    public Page<ReservaPendiente> findAll(Pageable pageable) {
        return iReservaPendienteRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public ReservaPendiente findById(Long id) {
        return iReservaPendienteRepository.findById(id).orElse(null);
    }


    @Override
    @Transactional
    public ReservaPendiente guardar(ReservaPendiente reserva) {
        return iReservaPendienteRepository.save(reserva);
    }


    @Override
    @Transactional
    public void eliminar(Long id) {
        ReservaPendiente reserva = this.findById(id);
        if (reserva != null) {
            iReservaPendienteRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
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
