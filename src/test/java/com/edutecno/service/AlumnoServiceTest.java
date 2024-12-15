package com.edutecno.service;

import com.edutecno.models.Alumno;
import com.edutecno.models.Materia;
import com.edutecno.models.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AlumnoServiceTest {

    AlumnoService alumnoService;
    //AlumnoService alumnoServiceMock;
    Materia matematicas;
    Materia lenguaje;
    Alumno mapu;
    Map<String, Alumno> listaAlumnosMock = new HashMap<>();


    //Scanner scannerMock;

    @BeforeEach
    void setUp() {
        alumnoService = new AlumnoService();
      //  alumnoServiceMock = mock(AlumnoService.class);
        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);
        mapu = new Alumno("12345678-9", "Mapu", "Mapuche", "Mapu 123");
        listaAlumnosMock.put(mapu.getRut(), mapu);

        alumnoService.crearAlumno(mapu);


        //scannerMock = Mockito.mock(Scanner.class);
    }

    /**
     * Prueba unitaria para el método crearAlumno() de la clase AlumnoService.
     *
     * Este método verifica que el método crearAlumno() de AlumnoService
     * funcione correctamente al agregar un nuevo alumno.
     */
    @Test
    void crearAlumnoTest() {

        // Verifica que el método crearAlumno() retorne true al agregar el alumno 'mapu'
        assertTrue(alumnoService.crearAlumno(mapu));

    }

    @Test
    void agregarMateriaTest() {

        mapu.getMaterias().add(matematicas);
        mapu.getMaterias().add(lenguaje);

        // Verifica que el método agregarMateria() retorne true al agregar la materia 'matematicas' al alumno 'mapu'
        assertTrue(alumnoService.agregarMateria(mapu.getRut(), matematicas));

        // Verifica que el método agregarMateria() retorne true al agregar la materia 'lenguaje' al alumno 'mapu'
        assertTrue(alumnoService.agregarMateria(mapu.getRut(), lenguaje));

        // Verifica que el método agregarMateria() retorne false al agregar la materia 'matematicas' al alumno 'mapu'
        assertFalse(alumnoService.agregarMateria(mapu.getRut(), matematicas));

        // Verifica que el método agregarMateria() retorne false al agregar la materia 'lenguaje' al alumno 'mapu'
        assertFalse(alumnoService.agregarMateria(mapu.getRut(), lenguaje));
    }

    @Test
    void materiasPorAlumnosTest() {

        // Verifica que el método materiasPorAlumnos() retorne una lista de materias al buscar las materias del alumno 'mapu'
        assertNotNull(alumnoService.materiasPorAlumnos(mapu.getRut()));

        // Verifica que el método materiasPorAlumnos() retorne null al buscar las materias del alumno 'mapu'
        assertNull(alumnoService.materiasPorAlumnos("12345678-0"));
    }

    @Test
    void listarAlumnosTest() {

            // Verifica que el método obtenerListaAlumnos() retorne un Map con el alumno 'mapu'
            assertEquals(listaAlumnosMock, alumnoService.obtenerListaAlumnos());
    }
}