package com.urjc.tfg.utils.mappers;

import com.urjc.tfg.models.entity.Reserva;
import com.urjc.tfg.models.entity.ReservaPendiente;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservaMapper {


    public static Reserva reservaPendienteToReserva(ReservaPendiente reservaPendiente) {
        if (reservaPendiente == null) {
            return null;
        }

        Reserva reserva = new Reserva();

        reserva.setId(reservaPendiente.getId());
        reserva.setNombre(reservaPendiente.getNombre());
        reserva.setApellido(reservaPendiente.getApellido());
        reserva.setEmail(reservaPendiente.getEmail());
        reserva.setFechaEvento(reservaPendiente.getFechaEvento());
        reserva.setUbicacion(reservaPendiente.getUbicacion());
        reserva.setObservacion(reservaPendiente.getObservacion());
        reserva.setTipoEvento(reservaPendiente.getTipoEvento());
        reserva.setGeneroMusical(reservaPendiente.getGeneroMusical());
        reserva.setRangoEdad(reservaPendiente.getRangoEdad());

        return reserva;
    }
}
