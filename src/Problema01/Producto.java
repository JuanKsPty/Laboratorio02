package Problema01;

public class Producto {
    int id;
    String nombre;
    String categoria;
    double precio;
    int cantidad;

    static double subtotalElectronica = 0, gananciaElectronica = 0;
    static double subtotalMuebles = 0, gananciaMuebles = 0;
    static double subtotalHerramientas = 0, gananciaHerramientas = 0;
    static double subtotalRopa = 0, gananciaRopa = 0;
    static double subtotalLibros = 0, gananciaLibros = 0;
    static double subtotalCocina = 0, gananciaCocina = 0;

    public Producto(int id, String nombre, String categoria, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;

        double subtotal = obtenerSubtotal();
        double ganancia = getGanancia();

        if (categoria.equalsIgnoreCase("Electronica")) {
            subtotalElectronica += subtotal;
            gananciaElectronica += ganancia;
        } else if (categoria.equalsIgnoreCase("Muebles Oficina")) {
            subtotalMuebles += subtotal;
            gananciaMuebles += ganancia;
        } else if (categoria.equalsIgnoreCase("Herramientas")) {
            subtotalHerramientas += subtotal;
            gananciaHerramientas += ganancia;
        } else if (categoria.equalsIgnoreCase("Ropa")) {
            subtotalRopa += subtotal;
            gananciaRopa += ganancia;
        } else if (categoria.equalsIgnoreCase("Libros")) {
            subtotalLibros += subtotal;
            gananciaLibros += ganancia;
        } else if (categoria.equalsIgnoreCase("Cocina")) {
            subtotalCocina += subtotal;
            gananciaCocina += ganancia;
        }
    }

    public double obtenerSubtotal() {
        return precio * cantidad;
    }

    public double getGanancia() {
        double porcentaje = 0;

        if (categoria.equalsIgnoreCase("Electronica")) {
            porcentaje = 0.20;
        } else if (categoria.equalsIgnoreCase("Muebles Oficina")) {
            porcentaje = 0.18;
        } else if (categoria.equalsIgnoreCase("Herramientas")) {
            porcentaje = 0.12;
        } else if (categoria.equalsIgnoreCase("Ropa")) {
            porcentaje = 0.10;
        } else if (categoria.equalsIgnoreCase("Libros")) {
            porcentaje = 0.08;
        } else if (categoria.equalsIgnoreCase("Cocina")) {
            porcentaje = 0.15;
        }

        return obtenerSubtotal() * porcentaje;
    }
}
