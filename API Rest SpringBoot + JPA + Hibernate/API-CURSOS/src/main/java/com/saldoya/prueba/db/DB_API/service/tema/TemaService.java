package com.saldoya.prueba.db.DB_API.service.tema;

import com.saldoya.prueba.db.DB_API.DTO.CrearTema;
import com.saldoya.prueba.db.DB_API.DTO.TemaEdit;
import com.saldoya.prueba.db.DB_API.model.Curso;
import com.saldoya.prueba.db.DB_API.model.Tema;
import com.saldoya.prueba.db.DB_API.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService{
    @Autowired
    private ITemaRepository temaRepo;

    @Override
    public void crearTema(Tema tema) {
        temaRepo.save(tema);
    }

    public Tema getTema(Long id){
        return temaRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarTema(TemaEdit temaEdit) {
        Tema original = this.getTema(temaEdit.getId());
        Tema nuevo = temaEdit.getTema();


        original.setNombre(nuevo.getNombre());
        original.setDescripcion(nuevo.getDescripcion());

        temaRepo.save(original);
    }
}
