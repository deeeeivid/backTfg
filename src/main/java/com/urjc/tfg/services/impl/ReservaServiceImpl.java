package com.urjc.tfg.services.impl;

import com.urjc.tfg.models.entity.Reserva;
import com.urjc.tfg.models.entity.ReservaPendiente;
import com.urjc.tfg.models.repository.IReservaRepository;
import com.urjc.tfg.services.IReservaService;
import com.urjc.tfg.utils.mappers.ReservaMapper;
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
    public Reserva guardar(ReservaPendiente reservaPendiente) {
        Reserva reserva = ReservaMapper.reservaPendienteToReserva(reservaPendiente);
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

}
