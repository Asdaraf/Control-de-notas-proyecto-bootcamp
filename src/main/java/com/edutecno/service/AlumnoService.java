package com.edutecno.service;

import com.edutecno.models.Alumno;
import com.edutecno.models.Materia;
import com.edutecno.utilities.Utility;

import java.util.*;

public class AlumnoService {

    private Map<String, Alumno> listaAlumnos = new HashMap<>();
    private Scanner s = new Scanner(System.in);

    public boolean crearAlumno(Alumno alumno) {

        // pedir los datos del alumno


        // Validar si el alumno ya existe
        if (listaAlumnos.containsKey(alumno.getRut())) {
            System.out.println("Error: Ya existe un alumno con ese RUT");
            return false;
        }


        // Agregar al Map usando el rut como clave
        listaAlumnos.put(alumno.getRut(), alumno);

        return true;
    }

    public boolean agregarMateria(String rutAlumno, Materia currentMate) {

        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            if (alumno.getMaterias().stream().anyMatch(materia -> materia.getNombre().equals(currentMate.getNombre()))) {
                System.out.println("Materia ya registrada");
                return false;
            } else {
                alumno.getMaterias().add(currentMate);
                System.out.println("Materia agregada exitosamente");
                return true;
            }
        } else {
            System.out.println("Alumno no encontrado");
            return false;
        }
    }

    public List<Materia> materiasPorAlumnos(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            List<Materia> materias = alumno.getMaterias();
            if (materias.isEmpty()) {
                System.out.println("Alumno no tiene materias registradas");
                return null;
            }
            return materias;
        } else {
            System.out.println("Alumno no encontrado");
            return null;
        }
    }

    public Map<String, Alumno> obtenerListaAlumnos() {
        return listaAlumnos;
    }

    public Map<String, Alumno> listarAlumnos() {
        System.out.println("\n=== LISTA DE ALUMNOS ===");
        for (Alumno alumno : listaAlumnos.values()) {
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            System.out.println("------------------------");
            System.out.println("Materias");
            // hacer foreach para cada materia y nota
            List<Materia> materias = materiasPorAlumnos(alumno.getRut());
            for (Materia materia : materias) {
                System.out.println("    " + materia.getNombre());
                System.out.println("        Notas:");
                for (int j = 0; j < materia.getNotas().size(); j++) {
                    System.out.println("        " + materia.getNotas().get(j));
                }
            }
            System.out.println("========");
        }
        return listaAlumnos;
    }

    public Alumno obtenerAlumnoPorRut(String rutAlumno) {
        return listaAlumnos.get(rutAlumno);
    }
}
