package com.saldoya.prueba.db.DB_API.DTO;

import com.saldoya.prueba.db.DB_API.model.Curso;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CursoEdit {
    private Long id;
    private Curso curso;

    public CursoEdit() {
    }

    public CursoEdit(Long id, Curso curso) {
        this.id = id;
        this.curso = curso;
    }
}
