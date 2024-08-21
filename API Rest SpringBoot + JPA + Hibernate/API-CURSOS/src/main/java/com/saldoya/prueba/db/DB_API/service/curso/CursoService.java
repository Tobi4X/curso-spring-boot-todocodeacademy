package com.saldoya.prueba.db.DB_API.service.curso;

import com.saldoya.prueba.db.DB_API.DTO.CursoEdit;
import com.saldoya.prueba.db.DB_API.model.Curso;
import com.saldoya.prueba.db.DB_API.model.Tema;
import com.saldoya.prueba.db.DB_API.model.filtros.Filter;
import com.saldoya.prueba.db.DB_API.model.filtros.FilterNombre;
import com.saldoya.prueba.db.DB_API.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService implements ICursoService{

    @Autowired
    private ICursoRepository cursoRepo;

    @Override
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public void crearCurso(Curso curso) {
        cursoRepo.save(curso);
    }

    @Override
    public Curso getCurso(Long id) {
        return cursoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Tema> getTemas(Long id) {
        return cursoRepo.findById(id).get().getListaDeTemas();
    }

    @Override
    public void actualizarCurso(CursoEdit cursoEdit) {
        Curso original = this.getCurso(cursoEdit.getId());
        Curso nuevo = cursoEdit.getCurso();

        original.setNombre(nuevo.getNombre());
        original.setModalidad(nuevo.getModalidad());
        original.setFecha_finalizacion(nuevo.getFecha_finalizacion());
        if(nuevo.getListaDeTemas() != null) original.setListaDeTemas(nuevo.getListaDeTemas());

        cursoRepo.save(original);
    }

    @Override
    public void eliminarCurso(Long id) {
        cursoRepo.deleteById(id);
    }

    @Override
    public List<Tema> filtrarTemas(Long id, FilterNombre filtro) {
        List<Tema> lista = this.getTemas(id);
        List<Tema> filtrados = new ArrayList<>();
        for (Tema tema : lista) {
            if(filtro.find(tema)) filtrados.add(tema);
        }
        return filtrados;
    }

    @Override
    public void agregarTema(Long id, Tema tema) {
        Curso cur = this.getCurso(id);
        cur.getListaDeTemas().add(tema);
        cursoRepo.save(cur);
    }
}
