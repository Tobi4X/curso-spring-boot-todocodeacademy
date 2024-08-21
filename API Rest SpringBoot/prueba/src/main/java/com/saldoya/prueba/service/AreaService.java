package com.saldoya.prueba.service;

import org.springframework.stereotype.Service;

@Service
public class AreaService {
    public double calcularArea(double base, double altura){
        return (base*altura)/2;
    }
}
