package com.edutecno.vistas;

import com.edutecno.utilities.Utility;

import java.util.Scanner;

abstract public class MenuTemplate {

    Scanner s = new Scanner(System.in);

    public abstract void exportarDatos();
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();
    public void iniciarMenu() {
        int opcion;
        do {
            String menu = """
                    ===== MENÚ PRINCIPAL =====
                    1. Crear Alumno
                    2. Listar Alumnos
                    3. Agregar Materias
                    4. Agregar Notas
                    5. Exportar Datos
                    6. Salir
                    =======================
                    Ingrese una opción:""";

            System.out.println(menu);
            opcion = s.nextInt();
            s.nextLine();

            switch (opcion) {
                case 1 -> crearAlumno();
                case 2 -> listarAlumnos();
                case 3 -> agregarMateria();
                case 4 -> agregarNotaPasoUno();
                case 5 -> exportarDatos();
                case 6 -> terminarPrograma();
                default -> Utility.mostrarMensaje("Opción no válida. Intente nuevamente");
            }

        } while (opcion != 6);
    }
}
