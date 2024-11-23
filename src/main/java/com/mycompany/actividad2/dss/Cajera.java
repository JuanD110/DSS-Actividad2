/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad2.dss;
import com.mycompany.actividad2.dss.ClienteProducto;
import com.mycompany.actividad2.dss.Producto;
import java.util.List;

public class Cajera {
    private String nombre;

    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Procesa la compra de un cliente.
     *
     * Este método itera sobre los productos del cliente, calcula el subtotal por producto,
     * el total de la compra y permite el procesamiento simultáneo de múltiples cajeras.
     *
     * @param cliente Cliente cuya compra será procesada
     */
    public void procesarCompra(ClienteProducto cliente) {
        System.out.println("Cajera " + nombre + " comienza a procesar la compra del cliente " + cliente.getNombre());
        long inicio = System.currentTimeMillis(); // Tiempo de inicio de la compra

        // Procesar productos y calcular el total de la compra
        double totalCompra = iterarProductos(cliente.getProductos());

        long fin = System.currentTimeMillis(); // Tiempo de finalización de la compra

        // Mostrar resultados
        System.out.println("Cajera " + nombre + " ha terminado de procesar la compra del cliente " + cliente.getNombre());
        System.out.printf("Total de la compra: %.2f%n", totalCompra);
        System.out.println("Tiempo total de procesamiento: " + convertirSegundos(fin - inicio) + " segundos\n");
    }

    /**
     * Itera sobre la lista de productos del cliente y calcula el subtotal por producto.
     *
     * Este método imprime los detalles de cada producto procesado, incluyendo nombre,
     * precio, cantidad, subtotal y tiempo de procesamiento.
     *
     * @param productos Lista de productos del cliente
     * @return El total de la compra del cliente
     */
    private double iterarProductos(List<Producto> productos) {
        float total = 0; // Total acumulado de la compra
        for (Producto producto : productos) {
            long inicioProducto = System.currentTimeMillis(); // Tiempo de inicio del procesamiento del producto

            procesarProducto(); // Simular el procesamiento del producto

            long finProducto = System.currentTimeMillis(); // Tiempo de finalización del procesamiento del producto
            float subtotal = producto.getPrecio() * producto.getCantidad(); // Calcular el subtotal del producto
            total += subtotal; // Acumular el total de la compra

            // Imprimir detalles del producto
            System.out.printf("Producto: %s, Precio: %.2f, Cantidad: %d, Subtotal: %.2f, Tiempo: %.2f segundos%n",
                    producto.getNombre(), producto.getPrecio(), producto.getCantidad(), subtotal, (finProducto - inicioProducto) / 1000.0);
        }
        return total; // Retornar el total de la compra
    }

    /**
     * Simula el tiempo de procesamiento de un producto.
     *
     * Este método utiliza un tiempo fijo de 1 segundo para cada producto.
     */
    private void procesarProducto() {
        try {
            Thread.sleep(1000); // Simula 1 segundo de procesamiento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error procesando el producto: " + e.getMessage());
        }
    }

    /**
     * Convierte un tiempo en milisegundos a segundos y lo formatea con dos decimales.
     *
     * @param milisegundos Tiempo en milisegundos
     * @return Tiempo convertido a segundos como una cadena formateada
     */
    private String convertirSegundos(long milisegundos) {
        return String.format("%.2f", milisegundos / 1000.0); // Dividir por 1000 y formatear a 2 decimales
    }
}
