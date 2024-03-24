package com.urjc.tfg.models.dao;

import com.urjc.tfg.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
