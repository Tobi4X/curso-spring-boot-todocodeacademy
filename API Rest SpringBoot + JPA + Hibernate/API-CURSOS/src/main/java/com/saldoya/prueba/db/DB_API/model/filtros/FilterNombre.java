package com.saldoya.prueba.db.DB_API.model.filtros;

import com.saldoya.prueba.db.DB_API.model.Tema;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FilterNombre implements Filter {
    private String nombre;
    public FilterNombre() {
    }

    @Override
    public boolean find(Tema tema) {
        return tema.getNombre().toLowerCase().contains(nombre.toLowerCase());
    }
}
