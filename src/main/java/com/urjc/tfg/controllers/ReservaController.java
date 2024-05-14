package com.urjc.tfg.controllers;

import com.urjc.tfg.models.entity.Reserva;
import com.urjc.tfg.models.entity.ReservaPendiente;
import com.urjc.tfg.services.IReservaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@Slf4j
@RequestMapping("/api")
public class ReservaController {

    private IReservaService iReservaService;


    @GetMapping("/reservas")
    public ResponseEntity<List<Reserva>> mostrarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(iReservaService.findAll());
    }

    @GetMapping("/reservas/page/{page}")
    public ResponseEntity<Page<Reserva>> index(@PathVariable Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(iReservaService.findAll(PageRequest.of(page, 4)));
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {

        Reserva reserva;
        Map<String, Object> response = new HashMap<>();

        try {
            reserva = iReservaService.findById(id);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la bbdd");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (reserva == null) {
            response.put("mensaje", "La reserva ID: ".concat(id.toString().concat(" no existe en la bbdd")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(reserva);
    }

    @PostMapping("/reservas")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Reserva> confirmar(@Valid @RequestBody ReservaPendiente reservaPendiente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iReservaService.guardar(reservaPendiente));
    }


    @DeleteMapping("/reservas/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {

            iReservaService.eliminar(id);

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

}
