package com.saldoya.prueba.db.DB_API.DTO;

import com.saldoya.prueba.db.DB_API.model.Tema;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CrearTema {
    private Tema tema;
    private Long id_curso;
}
