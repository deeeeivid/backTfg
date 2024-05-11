package com.urjc.tfg.services.impl;

import com.urjc.tfg.models.entity.*;
import com.urjc.tfg.models.repository.IGeneroMusicalRepository;
import com.urjc.tfg.models.repository.IRangoEdadRepository;
import com.urjc.tfg.models.repository.IReservaRepository;
import com.urjc.tfg.models.repository.ITipoEventoRepository;
import com.urjc.tfg.services.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<Reserva> findAll() {
        return iReservaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Reserva> findAll(Pageable pageable) {
        return iReservaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva findById(Long id) {
        return iReservaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Reserva guardar(Reserva reserva) {
        return iReservaRepository.save(reserva);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Reserva reserva = this.findById(id);
        if (reserva != null) {
            iReservaRepository.deleteById(id);
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
