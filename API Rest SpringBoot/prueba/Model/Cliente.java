package com.saldoya.prueba.Prueba.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;

    public Cliente(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
