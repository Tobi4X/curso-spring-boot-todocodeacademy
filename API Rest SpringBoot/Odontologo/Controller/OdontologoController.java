package com.saldoya.prueba.Odontologo.Controller;

import com.saldoya.prueba.Odontologo.Model.Paciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OdontologoController {

    @GetMapping("/traer-pacientes")
    public List<Paciente> traerPacientes() {
        Paciente pas1 = new Paciente(1, 12345678, "Juan", "Pérez", LocalDate.of(1980, 1, 15));
        Paciente pas2 = new Paciente(2, 87654321, "Ana", "Gómez", LocalDate.of(1992, 3, 22));
        Paciente pas3 = new Paciente(3, 11223344, "Carlos", "López", LocalDate.of(1985, 5, 10));
        Paciente pas4 = new Paciente(4, 44332211, "Marta", "Fernández", LocalDate.of(1978, 7, 30));
        Paciente pas5 = new Paciente(5, 55667788, "Luis", "Martínez", LocalDate.of(1990, 11, 25));
        Paciente pas6 = new Paciente(6, 99887766, "Laura", "Díaz", LocalDate.of(1983, 2, 5));
        Paciente pas7 = new Paciente(7, 33445566, "José", "Rodríguez", LocalDate.of(1975, 9, 18));
        Paciente pas8 = new Paciente(8, 77889900, "María", "García", LocalDate.of(1995, 6, 12));
        Paciente pas9 = new Paciente(9, 11224455, "Ricardo", "Sánchez", LocalDate.of(1988, 8, 20));
        Paciente pas10 = new Paciente(10, 66778899, "Sofía", "Mendoza", LocalDate.of(1993, 10, 3));

        List<Paciente> pacientes = new ArrayList<Paciente>();
        pacientes.add(pas1);
        pacientes.add(pas2);
        pacientes.add(pas3);
        pacientes.add(pas4);
        pacientes.add(pas5);
        pacientes.add(pas6);
        pacientes.add(pas7);
        pacientes.add(pas8);
        pacientes.add(pas9);
        pacientes.add(pas10);

        return pacientes;
    }

    @GetMapping("/traer-pacientes-menores")
    public List<Paciente> traerPacientesMenores() {
        Paciente pas1 = new Paciente(1, 12345678, "Juan", "Pérez", LocalDate.of(1980, 1, 15));
        Paciente pas2 = new Paciente(2, 87654321, "Ana", "Gómez", LocalDate.of(1992, 3, 22));
        Paciente pas3 = new Paciente(3, 11223344, "Carlos", "López", LocalDate.of(1985, 5, 10));
        Paciente pas4 = new Paciente(4, 44332211, "Marta", "Fernández", LocalDate.of(2015, 7, 30));
        Paciente pas5 = new Paciente(5, 55667788, "Luis", "Martínez", LocalDate.of(1990, 11, 25));
        Paciente pas6 = new Paciente(6, 99887766, "Laura", "Díaz", LocalDate.of(1983, 2, 5));
        Paciente pas7 = new Paciente(7, 33445566, "José", "Rodríguez", LocalDate.of(2020, 9, 18));
        Paciente pas8 = new Paciente(8, 77889900, "María", "García", LocalDate.of(1995, 6, 12));
        Paciente pas9 = new Paciente(9, 11224455, "Ricardo", "Sánchez", LocalDate.of(2013, 8, 20));
        Paciente pas10 = new Paciente(10, 66778899, "Sofía", "Mendoza", LocalDate.of(1993, 10, 3));

        List<Paciente> pacientes = new ArrayList<Paciente>();
        pacientes.add(pas1);
        pacientes.add(pas2);
        pacientes.add(pas3);
        pacientes.add(pas4);
        pacientes.add(pas5);
        pacientes.add(pas6);
        pacientes.add(pas7);
        pacientes.add(pas8);
        pacientes.add(pas9);
        pacientes.add(pas10);


        List<Paciente> menores = new ArrayList<>();
        for(Paciente p: pacientes) {
            if(p.getEdad() < 18){
                menores.add(p);
            }
        }

        return menores;
    }
}
