package com.urjc.tfg.services.Impl;

import com.urjc.tfg.models.entity.Usuario;
import com.urjc.tfg.models.repository.IUsuarioRepository;
import com.urjc.tfg.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository repository;

    public Usuario getUsuario(String username) {
        Optional<Usuario> usuario = repository.findByUsername(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("User not found " + username);
        }
        return usuario.get();
    }
}

