package com.saldoya.prueba.db.DB_API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idDuenio;
    private String dni;
    private String nombre;
    private String apellido;
    private String celular;
    @OneToMany(mappedBy = "duenio")
    private List<Mascota> mascotas;

    public Duenio() {
    }

    public Duenio(Long id, String dni, String nombre, String apellido, String celular) {
        this.idDuenio = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Duenio{" +
                "id=" + idDuenio +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
