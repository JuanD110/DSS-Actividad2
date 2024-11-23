/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad2.dss;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un producto que puede ser comprado por un cliente.
 */
class Producto {
    private String nombre; // Nombre del producto
    private float precio; // Precio del producto
    private int cantidad;
     // Tiempo que tarda en procesarse en milisegundos

    /**
     * Constructor para inicializar un producto.
     *
     * @param nombre             Nombre del producto.
     * @param precio             Precio del producto.
     * @param cantidad
     */
    public Producto(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto.
     */
    public float getPrecio() {
        return precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Obtiene el tiempo de procesamiento del producto.
     *
     * @return Tiempo en milisegundos.
     */
    
}
