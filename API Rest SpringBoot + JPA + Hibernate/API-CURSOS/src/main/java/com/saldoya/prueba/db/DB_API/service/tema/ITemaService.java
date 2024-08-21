package com.saldoya.prueba.db.DB_API.service.tema;

import com.saldoya.prueba.db.DB_API.DTO.CrearTema;
import com.saldoya.prueba.db.DB_API.DTO.TemaEdit;
import com.saldoya.prueba.db.DB_API.model.Tema;
import org.springframework.stereotype.Service;

@Service
public interface ITemaService {
    void crearTema(Tema tema);
    void actualizarTema(TemaEdit temaEdit);
    Tema getTema(Long id);
}
