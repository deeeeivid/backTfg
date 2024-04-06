package com.urjc.tfg.controllers;

import com.urjc.tfg.models.entity.Usuario;
import com.urjc.tfg.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("user")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @GetMapping("/obtener")
    public ResponseEntity<Usuario> obtenerUsuario(@RequestParam String username) {
        return ResponseEntity.ok(usuarioService.getUsuario(username));
    }
}
