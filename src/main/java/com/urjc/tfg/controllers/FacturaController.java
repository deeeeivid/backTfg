package com.urjc.tfg.controllers;

import com.urjc.tfg.models.entity.Factura;
import com.urjc.tfg.services.IFacturaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@Slf4j
@RequestMapping("/api")
public class FacturaController {

    private IFacturaService facturaService;

    @GetMapping("/facturas/{id}")
    public ResponseEntity<Factura> show(@PathVariable Long id) {
        return ResponseEntity.ok(facturaService.findById(id));
    }

    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facturaService.deleteById(id);
    }

}
