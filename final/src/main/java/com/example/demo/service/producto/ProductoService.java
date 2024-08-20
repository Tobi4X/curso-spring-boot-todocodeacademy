package com.example.demo.service.producto;

import com.example.demo.model.Producto;
import com.example.demo.model.filtro.producto.FilterProducto;
import com.example.demo.repository.IProductoRepository;
import com.example.demo.service.venta.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRepository;
    @Autowired
    private VentaService ventaService;

    @Override
    public void crearProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        Producto productoActualizar = this.buscarProductoPorId(producto.getCodigoProducto());

        productoActualizar.setNombre(producto.getNombre());
        productoActualizar.setCosto(producto.getCosto());
        productoActualizar.setMarca(producto.getMarca());
        productoActualizar.setCantidadDisponible(producto.getCantidadDisponible());

        productoRepository.save(productoActualizar);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> filtrarProducto(FilterProducto filtro) {
        List<Producto> productosFiltrados = new ArrayList<>();

        for(Producto p : productosFiltrados)
            if(filtro.find(p))
                productosFiltrados.add(p);

        return productosFiltrados;
    }

    @Override
    public List<Producto> productosDeVenta(Long idVenta) {
        return ventaService.buscarVentaPorId(idVenta).getListaProductos();
    }
}
