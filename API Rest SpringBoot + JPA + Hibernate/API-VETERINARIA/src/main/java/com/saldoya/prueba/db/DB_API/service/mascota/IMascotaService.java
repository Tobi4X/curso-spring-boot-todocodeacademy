package com.saldoya.prueba.db.DB_API.service.mascota;

import com.saldoya.prueba.db.DB_API.DTO.MascotaDuenio;
import com.saldoya.prueba.db.DB_API.model.Mascota;
import com.saldoya.prueba.db.DB_API.model.filtros.FilterMascotaRaza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMascotaService {
    void altaMascota(Mascota mascota);
    void bajaMascota(Long id);
    void modificaMascota(Mascota mascota, Long id);
    List<Mascota> listaMascota();
    List<Mascota> filtrarMascotasPorRaza(FilterMascotaRaza filtro);
    Mascota buscarMascota(Long id);
    MascotaDuenio buscarMascotaDuenio(Long id);
}
