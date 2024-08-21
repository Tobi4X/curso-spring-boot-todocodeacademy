package com.saldoya.prueba.db.DB_API.service;

import com.saldoya.prueba.db.DB_API.DTO.PersonaEditar;
import com.saldoya.prueba.db.DB_API.model.Persona;
import com.saldoya.prueba.db.DB_API.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersonaRepository persoRepository;

    @Override
    public List<Persona> getPersona() {
        return persoRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        persoRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return persoRepository.findById(id).orElse(null);
    }

    @Override
    public Persona updatePersona(PersonaEditar personaEditar) {
        //Extraigo los datos del DTO
        Long id = personaEditar.getId();
        Persona persona = personaEditar.getPersona();

        //Llamo al metodo buscar y una vez seleccionada la persona le seteo los datos nuevos
        Persona per = this.findPersona(id);
        per.setNombre(persona.getNombre());
        per.setApellido(persona.getApellido());
        per.setEdad(persona.getEdad());

        //Actualizo los datos de la persona en la base de datos
        persoRepository.save(per);
        return per;
    }
}
