package com.saldoya.prueba.db.DB_API.service.curso;

import com.saldoya.prueba.db.DB_API.DTO.CursoEdit;
import com.saldoya.prueba.db.DB_API.model.Curso;
import com.saldoya.prueba.db.DB_API.model.Tema;
import com.saldoya.prueba.db.DB_API.model.filtros.FilterNombre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICursoService {
    void crearCurso(Curso curso);
    Curso getCurso(Long id);
    List<Curso> getCursos();
    void actualizarCurso(CursoEdit cursoEdit);
    void eliminarCurso(Long id);
    List<Tema> getTemas(Long id);
    List<Tema> filtrarTemas(Long id, FilterNombre filtro);
    void agregarTema(Long id, Tema tema);
}
