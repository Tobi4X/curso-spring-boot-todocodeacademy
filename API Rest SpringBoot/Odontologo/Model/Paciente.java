package com.saldoya.prueba.Odontologo.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter @Setter
public class Paciente {
    private int id;
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Paciente() {
    }

    public Paciente(int id, int dni, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad(){
        Period edad = Period.between(this.fechaNacimiento, LocalDate.now());
        return edad.getYears();
    }
}
