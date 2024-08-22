package com.example.demo.service.producto;

import com.example.demo.model.Producto;
import com.example.demo.model.filtro.producto.FilterProducto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductoService {
    void crearProducto(Producto producto);
    void eliminarProducto(Long id);
    void actualizarProducto(Producto producto);
    List<Producto> listarProductos();
    Producto buscarProductoPorId(Long id);
    List<Producto> filtrarProducto(FilterProducto filtrarProducto);
    List<Producto> productosDeVenta(Long idVenta);
}
