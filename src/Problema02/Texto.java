package Problema02;

import java.io.FileWriter;
import java.io.IOException;

public class Texto {
    public static void insertarRegistros(FileWriter escri) throws IOException {
        try {
            escri.write("id,nombre,categoria,precio,cantidad\n" +
                    "1,Monitor,Electronica,120.00,3,360.00,72.00\n" +
                    "2,Teclado,Electronica,30.00,6,180.00,36.00\n" + "3,Router,Electronica,80.00,5,400.00,80.00\n" +
                    "4,SSD,Electronica,150.00,6,900.00,180.00\n" +
                    "5,Camara IP,Electronica,90.00,6,540.00,108.00\n" +
                    "6,Silla,Muebles Oficina,75.00,10,750.00,135.00\n" +
                    "7,Lampara,Muebles Oficina,40.00,12,480.00,86.40\n" +
                    "8,Estanteria,Muebles Oficina,90.00,3,270.00,48.60\n" +
                    "9,Cajonera,Muebles Oficina,80.00,7,560.00,100.80\n" +
                    "10,Cajonera con Ruedas,Muebles Oficina,110.00,4,440.00,79.20\n" +
                    "11,Martillo,Herramientas,25.00,15,375.00,45.00\n" +
                    "12,Taladro,Herramientas,80.00,6,480.00,57.60\n" +
                    "13,Cinta Metrica,Herramientas,10.00,18,180.00,21.60\n" +
                    "14,Cincel,Herramientas,18.00,14,252.00,30.24\n" +
                    "15,Espatula de Acero,Herramientas,12.00,25,300.00,36.00\n" +
                    "16,Camiseta,Ropa,15.00,25,375.00,37.50\n" +
                    "17,Chaqueta,Ropa,60.00,12,720.00,72.00\n" +
                    "18,Calcetines,Ropa,5.00,50,250.00,25.00\n" +
                    "19,Cinturon,Ropa,20.00,18,360.00,36.00\n" +
                    "20,Gorra Deportiva,Ropa,15.00,25,375.00,37.50\n");

            escri.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo escrito correctamente.");
    }
}

