package com.edutecno.service;

import com.edutecno.models.Alumno;
import com.edutecno.models.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArchivoService {

    private List<Alumno> alumnosACargar = new ArrayList<>();
    private PromedioServiceImp promedioServiceImp = new PromedioServiceImp();

    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ruta + "/promedios.txt", true))) {
            for (Alumno alumno : alumnos.values()) {
                bufferedWriter.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre() + " " + alumno.getApellido() + "\n");
                for (Materia materia : alumno.getMaterias()) {
                    bufferedWriter.write("Materia: " + materia.getNombre() + " - Promedio: " + promedioServiceImp.calcularPromedio(materia.getNotas()));
                }
            }
        }
        catch (IOException e) {
            System.err.println("Error al exportar los datos: " + e.getMessage());
        }
    }
}
