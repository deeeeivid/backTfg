package com.urjc.tfg.controllers;

import com.urjc.tfg.models.entity.GeneroMusical;
import com.urjc.tfg.models.entity.RangoEdad;
import com.urjc.tfg.models.entity.Reserva;
import com.urjc.tfg.models.entity.TipoEvento;
import com.urjc.tfg.services.IReservaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@Slf4j
@RequestMapping("/api")
public class ReservaController {

    private IReservaService iReservaService;

    @PostMapping("/reservas")
    public ResponseEntity<Reserva> create(@Valid @RequestBody Reserva reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iReservaService.save(reserva));
    }

    @GetMapping("/reservas/tipos-eventos")
    public List<TipoEvento> listarTiposEventos() {
        return iReservaService.findAllTiposEventos();
    }

    @GetMapping("/reservas/generos-musicales")
    public List<GeneroMusical> listarGenerosMusicales() {
        return iReservaService.findAllGenerosMusicales();
    }

    @GetMapping("/reservas/rango-edades")
    public List<RangoEdad> listarRangoEdades() {
        return iReservaService.findAllRangoEdades();
    }
}
