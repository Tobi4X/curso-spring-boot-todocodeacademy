package com.example.demo.model.filtro.producto;

import com.example.demo.model.Producto;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class FaltaStock implements FilterProducto{
    private int stockMinimo;

    public FaltaStock(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    @Override
    public boolean find(Producto p) {
        return p.getCantidadDisponible() > stockMinimo;
    }
}
