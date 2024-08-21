package com.saldoya.prueba.db.DB_API.model.filtros;

import com.saldoya.prueba.db.DB_API.model.Mascota;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FilterMascotaRaza implements FilterMascota {
    private String raza;

    public FilterMascotaRaza() {
    }

    public FilterMascotaRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public boolean find(Mascota mascota) {
        return mascota.getRaza().toLowerCase().equals(raza.toLowerCase());
    }

}
