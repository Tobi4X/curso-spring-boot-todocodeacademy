package com.saldoya.prueba.db.DB_API.model.filtros;

import com.saldoya.prueba.db.DB_API.model.Tema;

public interface Filter {
    boolean find(Tema tema);
}
