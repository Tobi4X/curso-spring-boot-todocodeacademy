package com.saldoya.prueba.db.DB_API.controller;

import com.saldoya.prueba.db.DB_API.DTO.MascotaDuenio;
import com.saldoya.prueba.db.DB_API.model.Duenio;
import com.saldoya.prueba.db.DB_API.model.Mascota;
import com.saldoya.prueba.db.DB_API.model.filtros.FilterMascotaRaza;
import com.saldoya.prueba.db.DB_API.service.duenio.DuenioService;
import com.saldoya.prueba.db.DB_API.service.mascota.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VeterinariaController {
    @Autowired
    private MascotaService mascotaService;
    @Autowired
    private DuenioService duenioService;

    @PostMapping("/crear/mascota")
    public String crearMascota(@RequestBody Mascota mascota) {
        mascotaService.altaMascota(mascota);
        return "Mascota creada";
    }

    @DeleteMapping("/eliminar/mascota")
    public String eliminarMascota(@RequestBody Long id) {
        mascotaService.bajaMascota(id);
        return "Mascota eliminada";
    }

    @PutMapping("/modificar/mascota")
    public String modificarMascota(@RequestBody Mascota mascota, @RequestParam Long id) {
        mascotaService.modificaMascota(mascota, id);
        return "Mascota modificada";
    }

    @GetMapping("/obtener/mascota")
    public Mascota obtenerMascota(@RequestParam Long id) {
        return mascotaService.buscarMascota(id);
    }

    @GetMapping("obtener/lista-mascotas")
    public List<Mascota> listaMascotas() {
        return mascotaService.listaMascota();
    }

    @GetMapping("/obtener/mascotas-filtradas")
    public List<Mascota> obtenerMascotas(@RequestBody FilterMascotaRaza filtro){
        return mascotaService.filtrarMascotasPorRaza(filtro);
    }

    @GetMapping("/obtener/mascota-y-duenio")
    public MascotaDuenio obtenerMascotaDuenio(@RequestParam Long id){
        return  mascotaService.buscarMascotaDuenio(id);
    }

    @PostMapping("/crear/duenio")
    public String crearDuenio(@RequestBody Duenio duenio) {
        duenioService.altaDuenio(duenio);
        return "Duenio creado";
    }

    @DeleteMapping("/eliminar/duenio")
    public String eliminarDuenio(@RequestBody Long id) {
        duenioService.bajaDuenio(id);
        return "Duenio eliminado";
    }

    @PutMapping("/modificar/duenio")
    public String modificarDuenio(@RequestBody Duenio duenio, @RequestParam Long id) {
        duenioService.modificarDuenio(duenio, id);
        return "Duenio modificado";
    }

    @GetMapping("/obtener/duenio")
    public Duenio obtenerDuenio(@RequestParam Long id) {
        return duenioService.buscarDuenio(id);
    }



}
