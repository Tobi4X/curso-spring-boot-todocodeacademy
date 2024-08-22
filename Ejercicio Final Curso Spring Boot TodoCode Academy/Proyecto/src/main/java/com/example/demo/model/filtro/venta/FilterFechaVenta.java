package com.example.demo.model.filtro.venta;

import com.example.demo.model.Venta;

import java.time.LocalDate;

public class FilterFechaVenta implements FilterVenta{
    LocalDate fechaVenta;

    public FilterFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public boolean find(Venta venta) {
        return venta.getFechaVenta().compareTo(fechaVenta) == 0;
    }
}
