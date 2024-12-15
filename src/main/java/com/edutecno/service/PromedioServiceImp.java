package com.edutecno.service;

import java.util.List;

public class PromedioServiceImp {

    public Double calcularPromedio(List<Double> notas) {
        double promedio = 0;
        int cantNotas = notas.size();
        double sumNotas = 0;
        for (double nota : notas) {
            sumNotas += nota;
        }
        promedio = sumNotas/cantNotas;
        return promedio;
    }
}
