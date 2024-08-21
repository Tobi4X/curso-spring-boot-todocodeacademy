package com.saldoya.prueba.db.DB_API.service.duenio;

import com.saldoya.prueba.db.DB_API.model.Duenio;
import com.saldoya.prueba.db.DB_API.model.Mascota;
import com.saldoya.prueba.db.DB_API.repository.IDuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService implements IDuenioService{
    @Autowired
    private IDuenioRepository duenioRepository;

    @Override
    public void altaDuenio(Duenio duenio) {
        duenioRepository.save(duenio);
    }

    @Override
    public void bajaDuenio(Long id) {
        duenioRepository.deleteById(id);
    }

    @Override
    public void modificarDuenio(Duenio duenio, Long id) {
        Duenio old = this.buscarDuenio(id);

        String nombre = duenio.getNombre();
        String apellido = duenio.getApellido();
        String dni = duenio.getDni();
        String celular = duenio.getCelular();
        List<Mascota> mascotas = duenio.getMascotas();

        if(nombre != null) old.setNombre(nombre);
        if(apellido != null) old.setApellido(apellido);
        if(dni != null) old.setDni(dni);
        if(celular != null) old.setCelular(celular);
        if(mascotas != null) old.setMascotas(mascotas);

        duenioRepository.save(old);

    }

    @Override
    public List<Duenio> listarDuenio() {
        return duenioRepository.findAll();
    }

    @Override
    public Duenio buscarDuenio(Long id) {
        return duenioRepository.findById(id).orElse(null);
    }
}
