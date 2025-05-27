import Clases.GenerarTxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problema1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File dirLab2 = new File("C://Lab2");
        File dirGrupo = new File("C://Lab2/Grupo_3");
        File file = new File("C://Lab2/Grupo_3/equipos.txt");
        File reporteFinal = new File("C://Lab2/Grupo_3/reporte_final.txt");

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
            if (file.createNewFile()) {
                System.out.println("Archivo '" + file.getName() + "' creado con éxito, en " + file.getAbsolutePath() + ".");
            } else {
                System.out.println("Ya existe el archivo 'equipos.txt'.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }

        System.out.print("¿Deseas escribir los datos en el archivo? (si/no): ");
        String s = sc.nextLine().toLowerCase().trim();

        if (s.equals("si")) {
            try {
                GenerarTxt.escribirTexto(new FileWriter(file));
            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir en el archivo.");
                e.printStackTrace();
            }
        }

        // Acumuladores por categoría
        double subtotalElectronica = 0, gananciaElectronica = 0;
        double subtotalAccesorios = 0, gananciaAccesorios = 0;
        double subtotalRedes = 0, gananciaRedes = 0;

        // Acumuladores generales
        double totalVenta = 0;
        double gananciaTotal = 0;

        try {
            Scanner myReader = new Scanner(file);
            if (myReader.hasNextLine()) myReader.nextLine(); // Saltar encabezado

            System.out.println("ID\tNombre\t\tCategoría\tPrecio\tCantidad\tSubtotal\tGanancia");

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if (data.isEmpty()) continue;

                String[] parts = data.split(",");

                String id = parts[0].trim();
                String nombre = parts[1].trim();
                String categoria = parts[2].trim();
                double precio = Double.parseDouble(parts[3].trim());
                int cantidad = Integer.parseInt(parts[4].trim());

                double subtotal = precio * cantidad;
                double ganancia = 0;

                if (categoria.equalsIgnoreCase("Electronica")) {
                    ganancia = subtotal * 0.20;
                    subtotalElectronica += subtotal;
                    gananciaElectronica += ganancia;
                } else if (categoria.equalsIgnoreCase("Accesorios")) {
                    ganancia = subtotal * 0.10;
                    subtotalAccesorios += subtotal;
                    gananciaAccesorios += ganancia;
                } else if (categoria.equalsIgnoreCase("Redes")) {
                    ganancia = subtotal * 0.15;
                    subtotalRedes += subtotal;
                    gananciaRedes += ganancia;
                }

                totalVenta += subtotal;
                gananciaTotal += ganancia;

                System.out.printf("%s\t%-10s\t%-10s\t%.2f\t%d\t\t%.2f\t\t%.2f\n",
                        id, nombre, categoria, precio, cantidad, subtotal, ganancia);
            }
            myReader.close();

            // RESUMEN CONSOLA
            System.out.println("\nRESUMEN POR CATEGORÍA:");
            System.out.printf("Electrónica - Subtotal: %.2f | Ganancia: %.2f\n", subtotalElectronica, gananciaElectronica);
            System.out.printf("Accesorios  - Subtotal: %.2f | Ganancia: %.2f\n", subtotalAccesorios, gananciaAccesorios);
            System.out.printf("Redes       - Subtotal: %.2f | Ganancia: %.2f\n", subtotalRedes, gananciaRedes);

            System.out.println("\nTOTAL GENERAL:");
            System.out.printf("Total Ventas: %.2f\n", totalVenta);
            System.out.printf("Ganancia Total: %.2f\n", gananciaTotal);

        } catch (FileNotFoundException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }

        // Reporte Final
        try (
                Scanner reader = new Scanner(file);
                FileWriter fw = new FileWriter(reporteFinal)
        ) {
            if (reader.hasNextLine()) reader.nextLine(); // Saltar encabezado

            fw.write("id,nombre,categoria,precio,cantidad,subtotal,ganancia\n");

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                String id = parts[0].trim();
                String nombre = parts[1].trim();
                String categoria = parts[2].trim();
                double precio = Double.parseDouble(parts[3].trim());
                int cantidad = Integer.parseInt(parts[4].trim());

                double subtotal = precio * cantidad;
                double ganancia = 0;

                if (categoria.equalsIgnoreCase("Electronica")) {
                    ganancia = subtotal * 0.20;
                } else if (categoria.equalsIgnoreCase("Accesorios")) {
                    ganancia = subtotal * 0.10;
                } else if (categoria.equalsIgnoreCase("Redes")) {
                    ganancia = subtotal * 0.15;
                }

                fw.write(String.format("%s,%s,%s,%.2f,%d,%.2f,%.2f\n",
                        id, nombre, categoria, precio, cantidad, subtotal, ganancia));
            }

            // Segunda sección con tabulaciones
            fw.write("\nID\tNombre\tCategoría\tPrecio\tCantidad\tSubtotal\tGanancia\n");

            Scanner readerTab = new Scanner(file);
            if (readerTab.hasNextLine()) readerTab.nextLine();

            while (readerTab.hasNextLine()) {
                String line = readerTab.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                String id = parts[0].trim();
                String nombre = parts[1].trim();
                String categoria = parts[2].trim();
                double precio = Double.parseDouble(parts[3].trim());
                int cantidad = Integer.parseInt(parts[4].trim());

                double subtotal = precio * cantidad;
                double ganancia = 0;

                if (categoria.equalsIgnoreCase("Electronica")) {
                    ganancia = subtotal * 0.20;
                } else if (categoria.equalsIgnoreCase("Accesorios")) {
                    ganancia = subtotal * 0.10;
                } else if (categoria.equalsIgnoreCase("Redes")) {
                    ganancia = subtotal * 0.15;
                }

                fw.write(String.format("%s\t%s\t%s\t%.2f\t%d\t%.2f\t%.2f\n",
                        id, nombre, categoria, precio, cantidad, subtotal, ganancia));
            }
            readerTab.close();

            // Resumen final
            fw.write("\nResumen por categoría:\n");
            fw.write(String.format("Electrónica - Subtotal: %.2f | Ganancia: %.2f\n", subtotalElectronica, gananciaElectronica));
            fw.write(String.format("Accesorios  - Subtotal: %.2f | Ganancia: %.2f\n", subtotalAccesorios, gananciaAccesorios));
            fw.write(String.format("Redes       - Subtotal: %.2f | Ganancia: %.2f\n", subtotalRedes, gananciaRedes));
            fw.write(String.format("\nTotal General de Ventas: %.2f\n", totalVenta));
            fw.write(String.format("Ganancia Total: %.2f\n", gananciaTotal));

            System.out.println("Archivo 'reporte_final.txt' generado correctamente.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el reporte final.");
            e.printStackTrace();
        }
    }
}
