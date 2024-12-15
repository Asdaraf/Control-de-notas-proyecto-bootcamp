package com.edutecno.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PromedioServiceImpTest {

    @Test
    public void calcularPromedioTest() {

        PromedioServiceImp promedioServiceImp = new PromedioServiceImp();

        // Datos de prueba
        List<Double> notas = List.of(5.0, 6.0, 7.0, 8.0, 9.0);

        // Llamar al metodo a testear
        Double promedio = promedioServiceImp.calcularPromedio(notas);

        // Verificar el resultado
        assertEquals(7.0, promedio);
    }
}