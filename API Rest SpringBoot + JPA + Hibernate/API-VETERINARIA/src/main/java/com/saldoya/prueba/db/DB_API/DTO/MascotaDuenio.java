package com.saldoya.prueba.db.DB_API.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaDuenio {
    private String nombreMascota;
    private String especie;
    private String raza;
    private String nombreDuenio;
    private String appelidoDuenio;

    public MascotaDuenio() {
    }
}
