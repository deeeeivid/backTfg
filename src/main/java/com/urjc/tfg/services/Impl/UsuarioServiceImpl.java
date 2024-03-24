package com.urjc.tfg.services.Impl;

import com.urjc.tfg.models.dao.IUsuarioRepository;
import com.urjc.tfg.models.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.slf4j.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    private final IUsuarioRepository iUsuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioRepository.findByUsername(username);

        if (usuario == null) {
            logger.error("Error en el login: no existe el usuario '" + username + "'en el sistema");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '" + username + "'en el " +
                    "sistema");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(),
                true, true, true, authorities);
    }
}
