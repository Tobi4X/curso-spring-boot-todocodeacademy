package com.saldoya.prueba.db.DB_API.DTO;

import com.saldoya.prueba.db.DB_API.model.Persona;
import lombok.Getter;

@Getter
public class PersonaEditar {
    private Long id;
    private Persona persona;
}
