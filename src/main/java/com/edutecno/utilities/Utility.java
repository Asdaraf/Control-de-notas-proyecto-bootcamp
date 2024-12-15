package com.edutecno.utilities;

import java.util.Scanner;

// Clase para agregar metodos de utilidad
public class Utility {



    // Limpia el scanner
    public static void limpiarScanner(Scanner scanner) {
        scanner.nextLine();
    }

    // Muestra mensaje con formato
    public static void mostrarMensaje(String mensaje) {
        System.out.println("================================");
        System.out.println(mensaje);
        System.out.println("================================");
    }

    // Limpia la pantalla de la consola
    public static void limpiarPantalla() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
