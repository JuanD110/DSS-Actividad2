/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad2.dss;


import java.util.Arrays;
import com.mycompany.actividad2.dss.ClienteProducto;
import com.mycompany.actividad2.dss.Producto;

/**
 * Clase principal que simula el proceso de cobro en un supermercado.
 */
public class SupermercadoSimulacion {
    public static void main(String[] args) {
        // Crear clientes y productos
        ClienteProducto cliente1 = new ClienteProducto("Juan", Arrays.asList(
                new Producto("Arroz", 2500, 1),
                new Producto("Frijoles", 3500, 2),
                new Producto("Leche", 3000, 1)
        ));

        ClienteProducto cliente2 = new ClienteProducto("Ana", Arrays.asList(
                new Producto("Pan", 2000, 2),
                new Producto("Huevos", 10000, 1),
                new Producto("Carne", 12000, 2)
        ));

        ClienteProducto cliente3 = new ClienteProducto("Luis", Arrays.asList(
                new Producto("Azúcar", 2500, 1),
                new Producto("Aceite", 8000, 1)
        ));

        Cajera cajera1 = new Cajera("Laura");
        Cajera cajera2 = new Cajera("Andrea");

        // Opción para elegir si usar hilos o no
        boolean usarHilos = false; // Cambiar a 'false' para ejecutar sin hilos

        if (usarHilos) {
            // Ejecutar con hilos
            System.out.println("Ejecutando con hilos...");
            long inicioSimulacion = System.currentTimeMillis();

            Thread hilo1 = new Thread(() -> cajera1.procesarCompra(cliente1));
            Thread hilo2 = new Thread(() -> cajera2.procesarCompra(cliente2));
            Thread hilo3 = new Thread(() -> cajera1.procesarCompra(cliente3)); // Cajera 1 nuevamente

            hilo1.start();
            hilo2.start();
            hilo3.start();

            try {
                hilo1.join();
                hilo2.join();
                hilo3.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error en la simulación: " + e.getMessage());
            }

            long finSimulacion = System.currentTimeMillis();
            System.out.println("Tiempo total de la simulación con hilos: " + (finSimulacion - inicioSimulacion) + " ms");
        } else {
            // Ejecutar sin hilos (secuencial)
            System.out.println("Ejecutando sin hilos...");
            long inicioSimulacion = System.currentTimeMillis();

            cajera1.procesarCompra(cliente1);
            cajera2.procesarCompra(cliente2);
            cajera1.procesarCompra(cliente3);

            long finSimulacion = System.currentTimeMillis();
            System.out.println("Tiempo total de la simulación sin hilos: " + (finSimulacion - inicioSimulacion) + " ms");
        }
    }
}
