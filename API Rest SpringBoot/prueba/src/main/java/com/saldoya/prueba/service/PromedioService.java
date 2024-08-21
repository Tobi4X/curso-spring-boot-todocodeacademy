package com.saldoya.prueba.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromedioService {
    public double promedioNotas(double nota1, double nota2, double nota3){
        return (nota1+nota2+nota3)/3;
    }
}
