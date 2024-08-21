package com.saldoya.prueba.service;

import com.saldoya.prueba.model.Basquetbolista;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasquetbolistaService {
    public double obtenerPromedioAlturas(List<Basquetbolista> basquetbolistas) {
        double promedio = 0;
        for (Basquetbolista b : basquetbolistas) {
            promedio += b.getEstatura();
        }
        promedio /= basquetbolistas.size();
        return promedio;
    }
}
