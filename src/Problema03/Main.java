package Problema03;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        File lab2 = new File("C://Lab2");
        File historico = new File(lab2, "Historico");
        File reporteOriginal = new File("C://Lab2/Grupo_03/Reporte_Ganancias_Netas.csv");

        if (!historico.exists()) {
            if (historico.mkdirs()) {
                System.out.println("Carpeta 'Historico' creada con éxito.");
            } else {
                System.out.println("No se pudo crear la carpeta 'Historico'.");
            }
        } else {
            System.out.println("Ya existe la carpeta 'Historico'.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        String fechaActual = LocalDate.now().format(formatter);
        String nombreArchivo = "Historico_" + fechaActual + ".csv";

        File archivoDestino = new File(historico, nombreArchivo);

        try {
            if (!reporteOriginal.exists()) {
                System.out.println("Error: El archivo Reporte_Ganancias_Netas.csv no se encuentra.");
                return;
            }

            if (archivoDestino.exists()) {
                File archivoDuplicado = new File(historico, "Historico_" + fechaActual + "_duplicado.csv");
                archivoDestino.renameTo(archivoDuplicado);
                System.out.println("Archivo existente renombrado como: " + archivoDuplicado.getName());
            }

            Files.copy(reporteOriginal.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado como: " + archivoDestino.getName());

            System.out.println("\nLista de archivos en la carpeta Historico:");
            File[] archivos = historico.listFiles();
            if (archivos != null) {
                for (File f : archivos) {
                    System.out.printf("Nombre: %s | Tamaño: %d bytes | Modificado: %s\n",
                            f.getName(), f.length(), new Date(f.lastModified()));
                }
            }

        } catch (IOException e) {
            System.out.println("Error en la manipulación de archivos:");
            e.printStackTrace();
        }
    }
}
