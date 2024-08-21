package com.example.demo.dto;

import com.example.demo.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ResumenVentasDTO {
    private double MontoTotal;
    private int cantidadTotalDeProductos;
    private List<Producto> productos;
}
