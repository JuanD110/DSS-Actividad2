/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad2.dss;

import java.util.List;

/**
 * Representa un cliente del supermercado.
 */
class ClienteProducto {
    private String nombre; // Nombre del cliente
    private List<Producto> productos; // Lista de productos que el cliente comprará

    /**
     * Constructor para inicializar un cliente.
     *
     * @param nombre    Nombre del cliente.
     * @param productos Lista de productos del cliente.
     */
    public ClienteProducto(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la lista de productos que el cliente comprará.
     *
     * @return Lista de productos.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Calcula el costo total de todos los productos del cliente.
     *
     * @return Costo total de la compra.
     */
    public double calcularCostoTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}