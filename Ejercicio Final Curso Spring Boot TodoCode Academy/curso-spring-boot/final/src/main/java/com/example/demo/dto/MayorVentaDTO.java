package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MayorVentaDTO {
    private Long codigoVenta;
    private double montoTotal;
    private int cantProductos;
    private String nombreCliente;
    private String apellidoCLiente;
}
