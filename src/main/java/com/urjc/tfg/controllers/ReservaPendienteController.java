package com.urjc.tfg.controllers;

import com.urjc.tfg.models.entity.GeneroMusical;
import com.urjc.tfg.models.entity.RangoEdad;
import com.urjc.tfg.models.entity.ReservaPendiente;
import com.urjc.tfg.models.entity.TipoEvento;
import com.urjc.tfg.services.IReservaPendienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@Slf4j
@RequestMapping("/api")
public class ReservaPendienteController {

    private IReservaPendienteService iReservaPendienteService;

    @GetMapping("/reservas/pendientes/page/{page}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Page<ReservaPendiente>> index(@PathVariable Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(iReservaPendienteService.findAll(PageRequest.of(page, 4)));
    }

    @GetMapping("/reservas/pendientes/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {

        ReservaPendiente reservaPendiente;
        Map<String, Object> response = new HashMap<>();

        try {
            reservaPendiente = iReservaPendienteService.findById(id);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la bbdd");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (reservaPendiente == null) {
            response.put("mensaje", "La reserva ID: ".concat(id.toString().concat(" no existe en la bbdd")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(reservaPendiente);
    }


    @PostMapping("/reservas/pendientes")
    public ResponseEntity<?> crear(@Valid @RequestBody ReservaPendiente reserva, BindingResult result) {
        ReservaPendiente reservaNueva;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream().map(err -> " El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            reservaNueva = iReservaPendienteService.guardar(reserva);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la bbdd");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La reserva se ha creado con éxito!");
        response.put("cliente", reservaNueva);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @DeleteMapping("/reservas/pendientes/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {

            iReservaPendienteService.eliminar(id);

            response.put("mensaje", "El cliente se ha eliminado con éxito!");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar de la bbdd");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("mensaje", "Error: No se pudo eliminar el cliente ID: ".concat(id.toString().concat(" no existe en la bbdd")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reservas/tipos-eventos")
    public ResponseEntity<List<TipoEvento>> listarTiposEventos() {
        return ResponseEntity.status(HttpStatus.OK).body(iReservaPendienteService.findAllTiposEventos());
    }

    @GetMapping("/reservas/generos-musicales")
    public ResponseEntity<List<GeneroMusical>> listarGenerosMusicales() {
        return ResponseEntity.status(HttpStatus.OK).body(iReservaPendienteService.findAllGenerosMusicales());
    }

    @GetMapping("/reservas/rango-edades")
    public ResponseEntity<List<RangoEdad>> listarRangoEdades() {
        return ResponseEntity.status(HttpStatus.OK).body(iReservaPendienteService.findAllRangoEdades());
    }

}
