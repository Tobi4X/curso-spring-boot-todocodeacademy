package com.saldoya.prueba.db.DB_API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_curso;
    private String nombre;
    private String modalidad;
    private LocalDate fecha_finalizacion;
    @OneToMany
    private List<Tema> listaDeTemas;

    public Curso() {

    }
    public Curso(Long id_curso, String nombre, String modalidad, LocalDate fecha_finalizacion) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.fecha_finalizacion = fecha_finalizacion;
        this.listaDeTemas = new ArrayList<Tema>();
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id_curso=" + id_curso +
                ", nombre='" + nombre + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", fecha_finalizacion=" + fecha_finalizacion +
                ", listaDeTemas=" + listaDeTemas +
                '}';
    }
}
