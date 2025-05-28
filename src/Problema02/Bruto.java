// ===== Clase Bruto.java =====
package Problema02;

public class Bruto {
    public int id;
    public String nombre;
    public String categoria;
    public double precio;
    public int cantidad;
    public double subtotal;
    public double ganancia;

    static double gananciaNetaElectronica = 0;
    static double gananciaNetaMuebles = 0;
    static double gananciaNetaHerramientas = 0;
    static double gananciaNetaRopa = 0;

    public Bruto(int id, String nombre, String categoria, double precio, int cantidad, double subtotal, double ganancia) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.ganancia = ganancia;

        double neta = getGananciaNeta();

        if (categoria.equalsIgnoreCase("Electronica")) {
            gananciaNetaElectronica += neta;
        } else if (categoria.equalsIgnoreCase("Muebles Oficina")) {
            gananciaNetaMuebles += neta;
        } else if (categoria.equalsIgnoreCase("Herramientas")) {
            gananciaNetaHerramientas += neta;
        } else if (categoria.equalsIgnoreCase("Ropa")) {
            gananciaNetaRopa += neta;
        }
    }

    public double getImpuesto() {
        return ganancia * 0.07;
    }

    public double getComision() {
        return ganancia * 0.05;
    }

    public double getGananciaNeta() {
        return ganancia - getImpuesto() - getComision();
    }

    public static double[] getTotalesPorCategoria() {
        return new double[] {
                gananciaNetaElectronica,
                gananciaNetaMuebles,
                gananciaNetaHerramientas,
                gananciaNetaRopa
        };
    }
}
