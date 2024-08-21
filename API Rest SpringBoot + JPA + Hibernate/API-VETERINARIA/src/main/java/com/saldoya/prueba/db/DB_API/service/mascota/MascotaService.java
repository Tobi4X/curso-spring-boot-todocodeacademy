package com.saldoya.prueba.db.DB_API.service.mascota;

import com.saldoya.prueba.db.DB_API.DTO.MascotaDuenio;
import com.saldoya.prueba.db.DB_API.model.Duenio;
import com.saldoya.prueba.db.DB_API.model.Mascota;
import com.saldoya.prueba.db.DB_API.model.filtros.FilterMascotaRaza;
import com.saldoya.prueba.db.DB_API.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService {
    @Autowired
    private IMascotaRepository mascotaRepository;

    @Override
    public void altaMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void bajaMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public void modificaMascota(Mascota mascota, Long id) {
        Mascota old = this.buscarMascota(id);

        String nombre = mascota.getNombre();
        String raza = mascota.getRaza();
        String especie = mascota.getEspecie();
        String color = mascota.getColor();
        Duenio duenio = mascota.getDuenio();

        if(nombre != null) old.setNombre(nombre);
        if(raza != null) old.setRaza(raza);
        if(especie != null) old.setEspecie(especie);
        if(color != null) old.setColor(color);
        if(duenio != null) old.setDuenio(duenio);

        mascotaRepository.save(old);

    }

    @Override
    public List<Mascota> listaMascota() {
        return mascotaRepository.findAll();
    }

    @Override
    public List<Mascota> filtrarMascotasPorRaza(FilterMascotaRaza filtro) {
        List<Mascota> lista = this.listaMascota();
        List<Mascota> resultado = new ArrayList<Mascota>();
        for (Mascota mascota : lista) {
            if (filtro.find(mascota)) resultado.add(mascota);
        }
        return resultado;
    }

    @Override
    public Mascota buscarMascota(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @Override
    public MascotaDuenio buscarMascotaDuenio(Long id) {
        MascotaDuenio mascotaDuenio = new MascotaDuenio();

        Mascota mascota = this.buscarMascota(id);
        Duenio duenio = mascota.getDuenio();

        mascotaDuenio.setNombreMascota(mascota.getNombre());
        mascotaDuenio.setRaza(mascota.getRaza());
        mascotaDuenio.setEspecie(mascota.getEspecie());
        mascotaDuenio.setNombreDuenio(duenio.getNombre());
        mascotaDuenio.setAppelidoDuenio(duenio.getApellido());

        return mascotaDuenio;
    }
}
