package com.saldoya.prueba.db.DB_API.controller;

import com.saldoya.prueba.db.DB_API.DTO.PersonaEditar;
import com.saldoya.prueba.db.DB_API.model.Persona;
import com.saldoya.prueba.db.DB_API.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/traer-personas")
    public List<Persona> traerPersonas() {
        System.out.println("ok");
        return personaService.getPersona();
    }

    @PostMapping("/guardar-persona")
    public void guardarPersona(@RequestBody Persona persona) {
        personaService.savePersona(persona);
    }

    @DeleteMapping("/eliminar-persona")
    public void eliminarPersona(@RequestParam Long id){
        personaService.deletePersona(id);
    }

    @GetMapping ("/buscar")
    public Persona buscarPersona(@RequestParam Long id){
        Persona persona = personaService.findPersona(id);
        return persona;
    }

    @PutMapping("/editar-persona")
    public Persona editarPersona(@RequestBody PersonaEditar personaEditar) {
        return personaService.updatePersona(personaEditar);
    }

}
