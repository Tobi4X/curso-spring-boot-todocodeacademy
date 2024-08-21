package com.saldoya.prueba.db.DB_API.controller;

import com.saldoya.prueba.db.DB_API.DTO.CrearTema;
import com.saldoya.prueba.db.DB_API.DTO.CursoEdit;
import com.saldoya.prueba.db.DB_API.DTO.TemaEdit;
import com.saldoya.prueba.db.DB_API.model.Curso;
import com.saldoya.prueba.db.DB_API.model.Tema;
import com.saldoya.prueba.db.DB_API.model.filtros.FilterNombre;
import com.saldoya.prueba.db.DB_API.service.curso.CursoService;
import com.saldoya.prueba.db.DB_API.service.tema.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @Autowired
    private TemaService temaService;

    @PostMapping("/crear-curso")
    public String crearCurso(@RequestBody Curso curso) {
        cursoService.crearCurso(curso);
        return "Curso creada correctamente";
    }

    @GetMapping("/traer-cursos")
    public List<Curso> traerCursos() {
        return cursoService.getCursos();
    }

    @PutMapping("modificar-curso")
    public String editarCurso(@RequestBody CursoEdit cursoEdit) {
        cursoService.actualizarCurso(cursoEdit);
        return "Curso editado correctamente";
    }

    @GetMapping("/traer-temas-de-curso")
    public List<Tema> traerTemasDeCurso(@RequestParam Long id) {
        return cursoService.getTemas(id);
    }

    @GetMapping("/traer-temas-filtrados")
    public List<Tema> traerTemasFiltrados(@RequestParam Long id, @RequestBody FilterNombre filter) {
        return cursoService.filtrarTemas(id, filter);
    }

    @PostMapping("/crear-tema")
    public String crearTema(@RequestBody CrearTema temaCrear) {
        temaService.crearTema(temaCrear.getTema());
        cursoService.agregarTema(temaCrear.getId_curso(), temaCrear.getTema());
        return "Tema creada correctamente";
    }

    @PutMapping("/modificar-tema")
    public String modificarTema(@RequestBody TemaEdit temaEdit) {
        temaService.actualizarTema(temaEdit);
        return "Tema modificado correctamente";
    }

}
