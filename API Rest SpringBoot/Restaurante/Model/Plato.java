package com.saldoya.prueba.Restaurante.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class Plato {
    private static Map<Integer, Plato> platos = new HashMap<>();
    private int numero;
    private String nombre;
    private Double precio;
    private String descripcion;

    public Plato() {
    }

    public Plato(int numero, String nombre, Double precio, String descripcion) {
        this.numero = numero;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        Plato.platos.put(this.numero, this);
    }

    public static Plato getPlato(Integer num) {
        return platos.get(num);
    }

    @Override
    public String toString() {
        return "Plato{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
