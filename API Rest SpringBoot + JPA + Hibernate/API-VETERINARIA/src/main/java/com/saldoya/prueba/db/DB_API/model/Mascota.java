package com.saldoya.prueba.db.DB_API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @ManyToOne
    @JoinColumn(name = "idDuenio")
    private Duenio duenio;

    public Mascota() {

    }

    public Mascota(Long id_mascota, String nombre, String especie, String raza, String color, Duenio duenio) {
        this.idMascota = id_mascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id_mascota=" + idMascota +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", color='" + color + '\'' +
                ", duenio=" + duenio +
                '}';
    }
}
