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
    public ResponseEntity<Reserva> crear(@Valid @RequestBody Reserva reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iReservaService.guardar(reserva));
    }

    @GetMapping("/reservas/tipos-eventos")
    public ResponseEntity<List<TipoEvento>> listarTiposEventos() {
        return ResponseEntity.status(HttpStatus.CREATED).body(iReservaService.findAllTiposEventos());
    }

    @GetMapping("/reservas/generos-musicales")
    public ResponseEntity<List<GeneroMusical>> listarGenerosMusicales() {
        return ResponseEntity.status(HttpStatus.CREATED).body(iReservaService.findAllGenerosMusicales());
    }

    @GetMapping("/reservas/rango-edades")
    public ResponseEntity<List<RangoEdad>> listarRangoEdades() {
        return ResponseEntity.status(HttpStatus.CREATED).body(iReservaService.findAllRangoEdades());
    }
}
