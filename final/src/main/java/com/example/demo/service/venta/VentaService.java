package com.example.demo.service.venta;

import com.example.demo.dto.MayorVentaDTO;
import com.example.demo.dto.ResumenVentasDTO;
import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.example.demo.model.filtro.venta.FilterFechaVenta;
import com.example.demo.model.filtro.venta.FilterVenta;
import com.example.demo.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public void realizarVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public void eliminarVenta(Long idVenta) {
        ventaRepository.deleteById(idVenta);
    }

    @Override
    public void actualizarVenta(Venta venta) {
        Venta ventaActualizar = this.buscarVentaPorId(venta.getCodigoVenta());

        ventaActualizar.setFechaVenta(venta.getFechaVenta());
        ventaActualizar.setTotal(venta.getTotal());
        ventaActualizar.setListaProductos(venta.getListaProductos());
        ventaActualizar.setUnCLiente(venta.getUnCLiente());

        ventaRepository.save(ventaActualizar);
    }

    @Override
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta buscarVentaPorId(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public ResumenVentasDTO resumenVentasDia(LocalDate fecha) {
        List<Venta> ventas = this.filtrarVentas(new FilterFechaVenta(fecha));
        List<Producto> productos = new ArrayList<>();
        ResumenVentasDTO resumenVentasDTO = new ResumenVentasDTO();
        double total = 0;

        for (Venta venta : ventas) {
            total += venta.getTotal();
            productos.addAll(venta.getListaProductos());
        }

        resumenVentasDTO.setCantidadTotalDeProductos(ventas.size());
        resumenVentasDTO.setMontoTotal(total);
        resumenVentasDTO.setProductos(productos);

        return resumenVentasDTO;
    }

    public List<Venta> filtrarVentas(FilterVenta filtro){
        List<Venta> ventas = this.listarVentas();
        List<Venta> ventasFiltradas = new ArrayList<>();

        for(Venta v : ventas)
            if (filtro.find(v))
                ventasFiltradas.add(v);

        return ventasFiltradas;
    }

    @Override
    public MayorVentaDTO obtenerMayorVenta() {
        List<Venta> ventas = this.listarVentas();
        Venta mayorVenta = new Venta();
        mayorVenta.setTotal(0.00);

        for(Venta v : ventas)
            if (v.getTotal() > mayorVenta.getTotal())
                mayorVenta = v;

        MayorVentaDTO mayorVentaDTO = new MayorVentaDTO();
        mayorVentaDTO.setCodigoVenta(mayorVenta.getCodigoVenta());
        mayorVentaDTO.setMontoTotal(mayorVenta.getTotal());
        mayorVentaDTO.setCantProductos(mayorVenta.getListaProductos().size());
        mayorVentaDTO.setNombreCliente(mayorVenta.getUnCLiente().getNombre());
        mayorVentaDTO.setApellidoCLiente(mayorVenta.getUnCLiente().getApellido());

        return mayorVentaDTO;
    }
}
