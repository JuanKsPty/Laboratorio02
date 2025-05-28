package Problema01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        File dirLab2 = new File("C://Lab2");
        File dirGrupo = new File("C://Lab2/Grupo_03");
        File nuevoArchivo = new File("C://Lab2/Grupo_03/equipos.txt");

        if (!dirLab2.exists()) {
            dirLab2.mkdir();
            System.out.println("Carpeta 'Lab2' creada con éxito.");
        } else {
            System.out.println("Ya existe la carpeta 'Lab2'.");
        }

        if (!dirGrupo.exists()) {
            dirGrupo.mkdir();
            System.out.println("Carpeta 'Grupo_3' creada con éxito.");
        } else {
            System.out.println("Ya existe la carpeta 'Grupo_3'.");
        }

        try {
            if (nuevoArchivo.createNewFile()) {
                System.out.println("Archivo '" + nuevoArchivo.getName() + "' creado con éxito, en " + nuevoArchivo.getAbsolutePath() + ".");
                System.out.print("¿Deseas escribir los datos en el archivo? (si/no): ");
                String s = sc.nextLine().toLowerCase().trim();

                if (s.equals("si")) {
                    try {
                        GenerarTxt.escribirTexto(new FileWriter(nuevoArchivo));
                    } catch (IOException e) {
                        System.out.println("Ocurrió un error al escribir en el archivo.");
                        e.printStackTrace();
                    }
                }

            } else {
                System.out.println("Ya existe el archivo 'equipos.txt'.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }


        //imprime la ruta del txt
        String ruta = "C:\\Lab2\\Grupo_03\\equipos.txt";

        System.out.println();
        System.out.println("Ruta del archivo actual:");
        System.out.println(nuevoArchivo.getAbsolutePath());


        //lee e imprime los datos
        Path path = Paths.get(ruta);

        System.out.println();
        System.out.println("Datos del archivo:");
        Files.lines(path).forEach(System.out::println);


        //detecta si tenemos permisos
        System.out.println();
        if (nuevoArchivo.canRead()) {
            System.out.println(nuevoArchivo.getName() + " tiene permisos de lectura");
        } else {
            System.out.println(nuevoArchivo.getName() + " NO tiene permisos de lectura");
        }

        if (nuevoArchivo.canWrite()) {
            System.out.println(nuevoArchivo.getName() + " tiene permisos de escritura");
        } else {
            System.out.println(nuevoArchivo.getName() + " NO tiene permisos de escritura");
        }

        if (nuevoArchivo.canExecute()) {
            System.out.println(nuevoArchivo.getName() + " tiene permisos de ejecución");
        } else {
            System.out.println(nuevoArchivo.getName() + " NO tiene permisos de ejecución");

        }

        //separa las columnas
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            File archivo = new File(ruta);
            Scanner lector = new Scanner(archivo);

            if (lector.hasNextLine()) {
                lector.nextLine();
            }

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");

                if (partes.length >= 5) {
                    int id = Integer.parseInt(partes[0].trim());
                    String nombre = partes[1].trim();
                    String categoria = partes[2].trim();
                    double precio = Double.parseDouble(partes[3].trim());
                    int cantidad = Integer.parseInt(partes[4].trim());

                    Producto p = new Producto(id, nombre, categoria, precio, cantidad);
                    productos.add(p);
                }
            }

            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        //crea el archivo de salida
        String salida = "C:\\Lab2\\Grupo_03\\reporte_resultados.txt";
        try {
            FileWriter escritor = new FileWriter(salida);

            escritor.write("\n");
            escritor.write("ID, Nombre, Categoria, Precio, Cantidad, Subtotal, Ganancia\n");
            for (Producto p : productos) {
                escritor.write(p.id + "," + p.nombre + "," + p.categoria + "," +
                        String.format("%.2f", p.precio) + "," + p.cantidad + "," +
                        String.format("%.2f", p.obtenerSubtotal()) + "," +
                        String.format("%.2f", p.getGanancia()) + "\n");
            }


            escritor.write("\n");
            escritor.write(String.format("%-4s %-25s %-20s %-10s %-10s %-12s %-10s\n",
                    "ID", "Nombre", "Categoría", "Precio", "Cantidad", "Subtotal", "Ganancia"));

            for (Producto p : productos) {
                escritor.write(String.format("%-4d %-25s %-20s %-10.2f %-10d %-12.2f %-10.2f\n",
                        p.id, p.nombre, p.categoria, p.precio, p.cantidad,
                        p.obtenerSubtotal(), p.getGanancia()));
            }

            escritor.write("\n");
            escritor.write("Resumen: " + "\n");
            for (Producto p : productos) {
                escritor.write(String.format("Electronica     → Subtotal: %.2f | Ganancia: %.2f\n", p.subtotalElectronica, p.gananciaElectronica));
                escritor.write(String.format("Muebles Oficina → Subtotal: %.2f | Ganancia: %.2f\n", p.subtotalMuebles, p.gananciaMuebles));
                escritor.write(String.format("Herramientas    → Subtotal: %.2f | Ganancia: %.2f\n", p.subtotalHerramientas, p.gananciaHerramientas));
                escritor.write(String.format("Ropa            → Subtotal: %.2f | Ganancia: %.2f\n", p.subtotalRopa, p.gananciaRopa));
                escritor.write(String.format("Libros          → Subtotal: %.2f | Ganancia: %.2f\n", p.subtotalLibros, p.gananciaLibros));
                escritor.write(String.format("Cocina          → Subtotal: %.2f | Ganancia: %.2f\n", p.subtotalCocina, p.gananciaCocina));
                break;
            }

            escritor.close();

            System.out.println();
            System.out.println("Archivo de resultados creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo:" + e.getMessage());
        }
    }
}

