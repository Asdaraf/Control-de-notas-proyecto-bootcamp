package com.edutecno.vistas;

import com.edutecno.models.Alumno;
import com.edutecno.models.Materia;
import com.edutecno.models.MateriaEnum;
import com.edutecno.service.AlumnoService;
import com.edutecno.service.ArchivoService;
import com.edutecno.utilities.Utility;

import java.util.List;
import java.util.Scanner;

public class Menu extends MenuTemplate{

    private AlumnoService alumnoServicio = new AlumnoService();
    private ArchivoService archivoService = new ArchivoService();
    private final Scanner s = new Scanner(System.in);


    @Override
    public void exportarDatos() {
        System.out.println("=== Exportar Datos ===");

        System.out.println("Ingrese la ruta donde se encuentra el archivo notas.csv");
        String ruta = s.nextLine();
        archivoService.exportarDatos(alumnoServicio.obtenerListaAlumnos(), ruta);
        System.out.println("Datos exportados correctamente");
    }

    @Override
    public void crearAlumno() {
        System.out.println("Ingrese RUT del alumno");
        String rut = s.nextLine();
        System.out.println("Ingrese nombre del alumno");
        String nombre = s.nextLine();

        System.out.println("Ingrese apellido del alumno");
        String apellido = s.nextLine();

        System.out.println("Ingrese direccion del alumno");
        String direccion = s.nextLine();

        Alumno alumnoNuevo = new Alumno(rut, nombre, apellido, direccion);
        boolean resultado = alumnoServicio.crearAlumno(alumnoNuevo);
        System.out.println("Alumno creado correctamente");
    }

    @Override
    public void agregarMateria() {

        System.out.println("=== Agregar materia ===");
        s.nextLine();

        System.out.println("Ingrese el rut del alumno:");
        String rutAlumno = s.nextLine();

        System.out.println("""
                    Seleccione una materia:
                    1. Matematicas
                    2. Lenguaje
                    3. Ciencias
                    4. Historia
                """);
        int materiaOpcion = s.nextInt();

        MateriaEnum materiaEnum;

        do {
            materiaEnum = switch (materiaOpcion) {
                case 1 -> MateriaEnum.MATEMATICAS;
                case 2 -> MateriaEnum.LENGUAJE;
                case 3 -> MateriaEnum.CIENCIA;
                case 4 -> MateriaEnum.HISTORIA;
                default -> null;
            };
        } while (materiaEnum == null);

        Materia materia = new Materia(materiaEnum);
        alumnoServicio.agregarMateria(rutAlumno, materia);

    }

    @Override
    public void agregarNotaPasoUno() {

        System.out.println("=== Agregar nota ===");
        s.nextLine();

        System.out.println("Ingrese el rut del alumno");
        String rutAlumno = s.nextLine();

        Alumno alumno = alumnoServicio.obtenerAlumnoPorRut(rutAlumno);
        if (alumno == null) {
            System.out.println("Alumno no encontrado");
            return;
        }

        List<Materia> materias = alumno.getMaterias();
        if (materias == null || materias.isEmpty()) {
            System.out.println("El alumno no tiene materias registradas");
            return;
        }

        System.out.println("El alumno tiene las siguientes materias:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println((i + 1) + ". " + materias.get(i).getNombre());
        }

        System.out.print("Seleccione una materia: ");
        int materiaOpcion = s.nextInt() - 1;

        System.out.print("Ingrese nota: ");
        double nota = s.nextDouble();

        materias.get(materiaOpcion).getNotas().add(nota);

        System.out.println("Nota agregada a " + materias.get(materiaOpcion).getNombre());

        List<Double> notasPrueba = materias.get(materiaOpcion).getNotas();

        for (double notaPrueba : notasPrueba) {
            System.out.println(notaPrueba);

        }

    }

    @Override
    public void listarAlumnos() {
        alumnoServicio.listarAlumnos();
    }

    @Override
    public void terminarPrograma() {

    }
}
