package com.saldoya.prueba.db.DB_API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_tema;
    private String nombre;
    private String descripcion;

    public Tema() {
    }

    public Tema(Long id, String nombre, String descripcion) {
        this.id_tema = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
