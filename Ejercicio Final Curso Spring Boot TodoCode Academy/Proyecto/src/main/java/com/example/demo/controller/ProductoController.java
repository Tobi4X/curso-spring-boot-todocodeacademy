package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.model.filtro.producto.FaltaStock;
import com.example.demo.model.filtro.producto.FilterProducto;
import com.example.demo.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return "Producto creado correctamente";
    }

    @DeleteMapping("/productos/eliminar/{idCLiente}")
    public String eliminarProducto(@PathVariable Long idProducto) {
        productoService.eliminarProducto(idProducto);
        return "Producto eliminado correctamente";
    }

    @PutMapping("/productos/editar")
    public String editarProducto(@RequestBody Producto producto) {
        productoService.actualizarProducto(producto);
        return "Producto editado correctamente";
    }

    @GetMapping()
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/productos/{idProducto}")
    public Producto buscarProductoPorId(@PathVariable Long idProducto) {
        return productoService.buscarProductoPorId(idProducto);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> buscarProductoPorFaltaStock() {
        List<Producto> productos = new ArrayList<>(productoService.filtrarProducto(new FaltaStock(5)));
        return productos;
    }

}
