package com.example.demo.service;

import com.example.demo.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductoService {
    void crearProducto();
    void eliminarProducto();
    void actualizarProducto();
    List<Producto> listarProductos();
    Producto buscarProductoPorId(Long id);
    List<Producto> faltaDeStock(int cantidadMinima);
    List<Producto> productosDeVenta(Long idVenta);
}
