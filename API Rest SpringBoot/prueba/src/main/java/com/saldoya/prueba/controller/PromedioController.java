package com.saldoya.prueba.controller;

import com.saldoya.prueba.model.Basquetbolista;
import com.saldoya.prueba.service.AreaService;
import com.saldoya.prueba.service.BasquetbolistaService;
import com.saldoya.prueba.service.PromedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PromedioController {

    @Autowired
    private PromedioService promedioService;
    @GetMapping("/promedio")
    public String obtenerPromedio(@RequestParam int nota1, @RequestParam int nota2, @RequestParam int nota3) {
        return "El promedio de las tres notas es " + promedioService.promedioNotas(nota1, nota2, nota3);
    }

    @Autowired
    private BasquetbolistaService basquetbolistaService;
    @PostMapping("/jugadores")
    public String getPromedioEstaturas(@RequestBody List<Basquetbolista> basquetbolistas){
        return "El promedio de estaturas es : " + basquetbolistaService.obtenerPromedioAlturas(basquetbolistas);
    }

    @Autowired
    private AreaService areaService;
    @GetMapping("/area")
    public String calcularArea(@RequestParam double base, @RequestParam double altura){
        return "El area es de : " + areaService.calcularArea(base, altura);
    }
}
