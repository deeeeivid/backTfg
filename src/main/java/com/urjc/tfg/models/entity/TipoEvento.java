package com.urjc.tfg.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "tipo_eventos")
public class TipoEvento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoEvento", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

}
