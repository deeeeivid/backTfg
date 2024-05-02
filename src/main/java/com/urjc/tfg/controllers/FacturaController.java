package com.urjc.tfg.controllers;

import com.urjc.tfg.models.entity.Factura;
import com.urjc.tfg.models.entity.Producto;
import com.urjc.tfg.services.IFacturaService;
import com.urjc.tfg.services.IProductoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@Slf4j
@RequestMapping("/api")
public class FacturaController {

    private IFacturaService facturaService;

    private IProductoService productoService;

    @GetMapping("/facturas/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Factura> show(@PathVariable Long id) {
        return ResponseEntity.ok(facturaService.findById(id));
    }

    @PostMapping("/facturas")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura) {
        return facturaService.save(factura);
    }

    @DeleteMapping("/facturas/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facturaService.deleteById(id);
    }

    @GetMapping("/facturas/filtrar-productos/{nombre}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> filtrarProductos(@PathVariable String nombre) {
        return productoService.findByNombre(nombre);
    }

}
