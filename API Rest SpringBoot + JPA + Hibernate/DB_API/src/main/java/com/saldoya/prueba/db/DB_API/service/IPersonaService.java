package com.saldoya.prueba.db.DB_API.service;

import com.saldoya.prueba.db.DB_API.DTO.PersonaEditar;
import com.saldoya.prueba.db.DB_API.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {
    List<Persona> getPersona();
    void savePersona(Persona persona);
    void deletePersona(Long id);
    Persona findPersona(Long id);
    Persona updatePersona(PersonaEditar personaEditar);
}
