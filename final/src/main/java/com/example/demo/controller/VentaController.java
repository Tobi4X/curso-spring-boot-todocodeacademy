package com.example.demo.controller;

import com.example.demo.dto.MayorVentaDTO;
import com.example.demo.dto.ResumenVentasDTO;
import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.example.demo.service.venta.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta) {
        ventaService.realizarVenta(venta);
        return "Venta creado correctamente";
    }

    @DeleteMapping("/ventas/eliminar/{idVenta}")
    public String eliminarVenta(@PathVariable Long idVenta) {
        ventaService.eliminarVenta(idVenta);
        return "Venta eliminado correctamente";
    }

    @PutMapping("/ventas/editar")
    public String editarVenta(@RequestBody Venta venta) {
        ventaService.actualizarVenta(venta);
        return "Venta editado correctamente";
    }

    @GetMapping("/ventas")
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @GetMapping("/ventas/{codigoVenta}")
    public Venta buscarVentaPorId(@PathVariable Long codigoVenta) {
        return ventaService.buscarVentaPorId(codigoVenta);
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> buscarProductoDeVenta(@PathVariable Long codigo_venta) {
        Venta venta = ventaService.buscarVentaPorId(codigo_venta);
        if (venta != null) {
            return venta.getListaProductos();
        }
        return null;
    }

    @GetMapping("/ventas/{fecha_venta}")
    public ResumenVentasDTO resumenVenta(@PathVariable LocalDate fecha_venta) {
        return ventaService.resumenVentasDia(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public MayorVentaDTO mayorVenta() {
        return ventaService.obtenerMayorVenta();
    }
    
}
