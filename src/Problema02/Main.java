// ===== Main.java para el Problema 2 con estructura final =====
package Problema02;

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

        String rutaBruto = "C:/Lab2/Grupo_03/Reporte_Ganancias_Brutas.txt";
        String rutaEquipos = "C:/Lab2/Grupo_03/equipos.txt";

        File archivoBruto = new File(rutaBruto);
        File archivoEquipos = new File(rutaEquipos);

        // Verificar existencia de archivos requeridos
        boolean archivosExisten = true;

        if (!archivoBruto.exists()) {
            System.out.println("No se encuentra el archivo: " + archivoBruto.getName());
            archivosExisten = false;
        }

        if (!archivoEquipos.exists()) {
            System.out.println("No se encuentra el archivo: " + archivoEquipos.getName());
            archivosExisten = false;
        }

        if (!archivosExisten) {
            System.out.println("\nFinalizando ejecución. Verifique los archivos requeridos.");
            return; // Detener ejecución
        }

        //elimina el archivo de reporte_resultados.txt si existe
        File antiguo = new File("C:/Lab2/Grupo_03/reporte_resultados.txt");

            try{
                if (antiguo.exists()) {
                    if (antiguo.delete()) {
                        System.out.println(antiguo.getName() + " eliminado correctamente");
                    }
                }else {
                    System.out.println("No existe el archivo " + antiguo.getName());
                }
            }catch (SecurityException e) {
                System.out.println("No se puede eliminar el archivo por permisos de seguridad.");
            }


        // crear archivo nuevo y vacío, luego insertar registros
        String ruta2="C:/Lab2/Grupo_03/Reporte_Ganancias_Brutas.txt";

        System.out.println();
        try {
            if (archivoBruto.createNewFile()) {
                System.out.println("Archivo '" + archivoBruto.getName() + "' creado con éxito, en " + archivoBruto.getAbsolutePath() + ".");
                System.out.print("¿Deseas escribir los datos en el archivo? (si/no): ");
                String s = sc.nextLine().toLowerCase().trim();

                if (s.equals("si")) {
                    try {
                        Texto.insertarRegistros(new FileWriter(archivoBruto));
                    } catch (IOException e) {
                        System.out.println("Ocurrió un error al escribir en el archivo.");
                    }
                }

            } else {
                System.out.println("Ya existe el archivo " + archivoBruto.getName());
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }


        //imprime la ruta del txt
        System.out.println();
        System.out.println("Ruta del archivo:");
        System.out.println(archivoBruto.getAbsolutePath());

        //lee e imprime los datos dentro del archivo en consola
        Path path = Paths.get(ruta2);

        System.out.println();
        System.out.println("Datos del archivo:");
        Files.lines(path).forEach(System.out::println);


        // Paso 3: separa el arraylist
        ArrayList<Bruto> brutos = new ArrayList<>();

        try{
            File archivo2 = new File(ruta2);
            Scanner lector = new Scanner(archivo2);

            if (lector.hasNextLine()){
                lector.nextLine();
            }

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String categoria = partes[2];
                double precio = Double.parseDouble(partes[3]);
                int cantidad = Integer.parseInt(partes[4]);
                double subtotal = Double.parseDouble(partes[5]);
                double ganancia = Double.parseDouble(partes[6]);

                Bruto b = new Bruto(id, nombre, categoria, precio, cantidad, subtotal, ganancia);
                brutos.add(b);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        // Paso 4: Generar archivos de salida
        try {
            FileWriter csv = new FileWriter("C:/Lab2/Grupo_03/Reporte_Ganancias_Netas.csv");
            FileWriter tab = new FileWriter("C:/Lab2/Grupo_03/Reporte_Ganancias_Netas_Tabulado.csv");

            csv.write("ID;Nombre;Categoria;Precio;Cantidad;Subtotal;Ganancia;GananciaNeta\n");
            tab.write("ID\tNombre\tCategoria\tPrecio\tCantidad\tSubtotal\tGanancia\tGananciaNeta\n");

            for (Bruto b : brutos) {
                csv.write(String.format("%d;%s;%s;%.2f;%d;%.2f;%.2f;%.2f\n",
                        b.id, b.nombre, b.categoria, b.precio, b.cantidad,
                        b.subtotal, b.ganancia, b.getGananciaNeta()));

                tab.write(String.format("%d\t%s\t%s\t%.2f\t%d\t%.2f\t%.2f\t%.2f\n",
                        b.id, b.nombre, b.categoria, b.precio, b.cantidad,
                        b.subtotal, b.ganancia, b.getGananciaNeta()));
            }

            csv.write("\nResumen por categoría (Ganancia Neta):\n");
            tab.write("\nResumen por categoría (Ganancia Neta):\n");

            double[] totales = Bruto.getTotalesPorCategoria();
            csv.write(String.format("Electronica: %.2f\nMuebles Oficina: %.2f\nHerramientas: %.2f\nRopa: %.2f\n",
                    totales[0], totales[1], totales[2], totales[3]));
            tab.write(String.format("Electronica:\t%.2f\nMuebles Oficina:\t%.2f\nHerramientas:\t%.2f\nRopa:\t%.2f\n",
                    totales[0], totales[1], totales[2], totales[3]));

            csv.close();
            tab.close();
            System.out.println();
            System.out.println("Archivos generados exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al generar archivos de salida: " + e.getMessage());
        }
    }
}
