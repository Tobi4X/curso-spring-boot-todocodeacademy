package com.example.demo.service.venta;

import com.example.demo.dto.MayorVentaDTO;
import com.example.demo.dto.ResumenVentasDTO;
import com.example.demo.model.Venta;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IVentaService {
    void realizarVenta(Venta venta);
    void eliminarVenta(Long idVenta);
    void actualizarVenta(Venta venta);
    List<Venta> listarVentas();
    Venta buscarVentaPorId(Long id);
    ResumenVentasDTO resumenVentasDia(LocalDate fecha);
    MayorVentaDTO obtenerMayorVenta();
}
