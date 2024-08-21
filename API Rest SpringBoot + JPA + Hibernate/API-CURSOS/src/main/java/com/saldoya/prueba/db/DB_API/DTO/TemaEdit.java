package com.saldoya.prueba.db.DB_API.DTO;

import com.saldoya.prueba.db.DB_API.model.Tema;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TemaEdit {
    private Long id;
    private Tema tema;
}
