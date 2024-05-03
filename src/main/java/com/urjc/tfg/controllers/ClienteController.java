package com.urjc.tfg.controllers;

import com.urjc.tfg.models.entity.Cliente;
import com.urjc.tfg.models.entity.Region;
import com.urjc.tfg.models.repository.IClienteRepository;
import com.urjc.tfg.services.IClienteService;
import com.urjc.tfg.services.IUploadFileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@Slf4j
@RequestMapping("/api")
public class ClienteController {

    private IClienteService iClienteService;
    private IUploadFileService iUploadFileService;
    private IClienteRepository iClienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> index() {
        return iClienteService.findAll();
    }

    @GetMapping("/clientes/page/{page}")
    public Page<Cliente> index(@PathVariable Integer page) {
        return iClienteService.findAll(PageRequest.of(page, 5));
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Cliente cliente;
        Map<String, Object> response = new HashMap<>();

        try {
            cliente = iClienteService.findById(id);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la bbdd");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (cliente == null) {
            response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la bbdd")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/clientes")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
        Cliente clienteNuevo;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream().map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            clienteNuevo = iClienteService.save(cliente);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la bbdd");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente se ha creado con éxito!");
        response.put("cliente", clienteNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {

        Cliente clienteActual = iClienteService.findById(id);
        Cliente clienteMod;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream().map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (clienteActual == null) {
            response.put("mensaje", "Error: No se pudo editar el cliente ID: ".concat(id.toString().concat(" no existe en la bbdd")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {

            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setEmail(cliente.getEmail());
            clienteActual.setCreateAt(cliente.getCreateAt());
            clienteActual.setRegion(cliente.getRegion());

            clienteMod = iClienteRepository.save(clienteActual);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar en la bbdd");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente se ha modificado con éxito!");
        response.put("cliente", clienteMod);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/clientes/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {

            Cliente cliente = iClienteService.findById(id);
            String nombreFotoAnterior = cliente.getFoto();

            iUploadFileService.eliminar(nombreFotoAnterior);

            iClienteService.delete(id);

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

    @PostMapping("/clientes/upload")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<?> upload(@RequestParam(value = "archivo") MultipartFile archivo, @RequestParam("id") Long id) {
        Map<String, Object> response = new HashMap<>();

        Cliente cliente = iClienteService.findById(id);

        if (!archivo.isEmpty()) {
            String nombreArchivo;
            try {
                nombreArchivo = iUploadFileService.guardar(archivo);
            } catch (IOException e) {
                response.put("mensaje", "Error al subir la imagen ");
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreFotoAnterior = cliente.getFoto();

            iUploadFileService.eliminar(nombreFotoAnterior);

            cliente.setFoto(nombreArchivo);

            iClienteService.save(cliente);

            response.put("cliente", cliente);
            response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {

        Resource recurso = null;
        try {
            recurso = iUploadFileService.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

        return new ResponseEntity<>(recurso, cabecera, HttpStatus.OK);

    }

    @GetMapping("/clientes/regiones")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Region> listarRegiones() {
        return iClienteService.findAllRegiones();
    }
}
