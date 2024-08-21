package com.saldoya.prueba.db.DB_API.service.duenio;

import com.saldoya.prueba.db.DB_API.model.Duenio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDuenioService {
    void altaDuenio(Duenio duenio);
    void bajaDuenio(Long id);
    void modificarDuenio(Duenio duenio, Long id);
    List<Duenio> listarDuenio();
    Duenio buscarDuenio(Long id);
}
