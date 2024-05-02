package com.urjc.tfg.controllers;

import com.urjc.tfg.models.entity.Factura;
import com.urjc.tfg.models.entity.Producto;
import com.urjc.tfg.services.IFacturaService;
import com.urjc.tfg.services.IProductoService;
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
public class FacturaController {

    private IFacturaService facturaService;

    private IProductoService productoService;

    @GetMapping("/facturas/{id}")
    public ResponseEntity<Factura> show(@PathVariable Long id) {
        return ResponseEntity.ok(facturaService.findById(id));
    }

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura) {
        return facturaService.save(factura);
    }

    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facturaService.deleteById(id);
    }

    @GetMapping("/facturas/filtrar-productos/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> filtrarProductos(@PathVariable String nombre) {
        return productoService.findByNombre(nombre);
    }

}
