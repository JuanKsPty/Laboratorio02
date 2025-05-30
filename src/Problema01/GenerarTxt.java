package Problema01;

import java.io.FileWriter;
import java.io.IOException;

    public class GenerarTxt {
        public static void escribirTexto(FileWriter fw) throws IOException {
            try {
                fw.write("id,nombre,categoria,precio,cantidad\n"
                        + "1,Monitor,Electronica,120.00,3\n"
                        + "2,Teclado,Electronica,30.00,6\n"
                        + "3,Mouse,Electronica,25.00,8\n"
                        + "4,Impresora,Electronica,200.00,2\n"
                        + "5,Router,Electronica,80.00,5\n"
                        + "6,Camara Web,Electronica,45.00,7\n"
                        + "7,Altavoz,Electronica,60.00,4\n"
                        + "8,Disco Duro,Electronica,90.00,3\n"
                        + "9,USB,Electronica,15.00,20\n"
                        + "10,SSD,Electronica,150.00,6\n"
                        + "11,Silla, Muebles Oficina,75.00,10\n"
                        + "12,Escritorio, Muebles Oficina,150.00,5\n"
                        + "13,Lampara, Muebles Oficina,40.00,12\n"
                        + "14,Archivador, Muebles Oficina,60.00,4\n"
                        + "15,Estanteria, Muebles Oficina,90.00,3\n"
                        + "16,Taburete, Muebles Oficina,35.00,9\n"
                        + "17,Cajonera, Muebles Oficina,80.00,7\n"
                        + "18,Soporte Monitor, Muebles Oficina,25.00,15\n"
                        + "19,Alfombrilla, Muebles Oficina,10.00,18\n"
                        + "20,Organizador, Muebles Oficina,20.00,14\n"
                        + "21,Martillo, Herramientas,25.00,15\n"
                        + "22,Destornillador, Herramientas,15.00,20\n"
                        + "23,Taladro, Herramientas,80.00,6\n"
                        + "24,Sierra, Herramientas,60.00,7\n"
                        + "25,Llave Inglesa, Herramientas,40.00,12\n"
                        + "26,Cinta Métrica, Herramientas,10.00,18\n"
                        + "27,Pinzas, Herramientas,20.00,13\n"
                        + "28,Alicates, Herramientas,15.00,16\n"
                        + "29,Cincel, Herramientas,18.00,14\n"
                        + "30,Espátula, Herramientas,8.00,22\n"
                        + "31,Camiseta, Ropa,15.00,25\n"
                        + "32,Pantalon, Ropa,30.00,20\n"
                        + "33,Chaqueta, Ropa,60.00,12\n"
                        + "34,Zapatos, Ropa,50.00,15\n"
                        + "35,Gorra, Ropa,12.00,30\n"
                        + "36,Calcetines, Ropa,5.00,50\n"
                        + "37,Guantes, Ropa,10.00,35\n"
                        + "38,Bufanda, Ropa,15.00,22\n"
                        + "39,Cinturon, Ropa,20.00,18\n"
                        + "40,Sombrero, Ropa,25.00,12\n"
                        + "41,Libro, Libros,20.00,40\n"
                        + "42,Cuaderno, Libros,3.00,100\n"
                        + "43,Manual, Libros,25.00,35\n"
                        + "44,Revista, Libros,7.00,60\n"
                        + "45,Enciclopedia, Libros,50.00,10\n"
                        + "46,Diccionario, Libros,30.00,15\n"
                        + "47,Atlas, Libros,40.00,8\n"
                        + "48,Novela, Libros,18.00,50\n"
                        + "49,Comic, Libros,12.00,80\n"
                        + "50,Ensayo, Libros,22.00,25\n"
                        + "51,Cafetera, Cocina,100.00,8\n"
                        + "52,Microondas, Cocina,150.00,5\n"
                        + "53,Licuadora, Cocina,80.00,7\n"
                        + "54,Hervidor, Cocina,40.00,10\n"
                        + "55,Olla, Cocina,35.00,15\n"
                        + "56,Sartén, Cocina,45.00,12\n"
                        + "57,Tostadora, Cocina,30.00,9\n"
                        + "58,Batidora, Cocina,50.00,6\n"
                        + "59,Exprimidor, Cocina,25.00,11\n"
                        + "60,Cuchillo, Cocina,15.00,20\n"
                        + "61,Monitor 4K,Electronica,300.00,2\n"
                        + "62,Teclado Mecanico,Electronica,70.00,4\n"
                        + "63,Mouse Inalambrico,Electronica,40.00,10\n"
                        + "64,Impresora Laser,Electronica,220.00,3\n"
                        + "65,Router WiFi6,Electronica,130.00,5\n"
                        + "66,Camara IP,Electronica,90.00,6\n"
                        + "67,Altavoz Bluetooth,Electronica,75.00,7\n"
                        + "68,Disco Duro Externo,Electronica,110.00,4\n"
                        + "69,USB 3.0,Electronica,20.00,30\n"
                        + "70,SSD NVMe,Electronica,180.00,5\n"
                        + "71,Silla Ejecutiva, Muebles Oficina,130.00,6\n"
                        + "72,Escritorio Grande, Muebles Oficina,200.00,4\n"
                        + "73,Lampara LED, Muebles Oficina,55.00,9\n"
                        + "74,Archivador Metalico, Muebles Oficina,100.00,3\n"
                        + "75,Estanteria de Madera, Muebles Oficina,120.00,5\n"
                        + "76,Taburete Ajustable, Muebles Oficina,50.00,7\n"
                        + "77,Cajonera con Ruedas, Muebles Oficina,110.00,4\n"
                        + "78,Soporte para Laptop, Muebles Oficina,35.00,12\n"
                        + "79,Alfombrilla Grande, Muebles Oficina,18.00,20\n"
                        + "80,Organizador de Escritorio, Muebles Oficina,28.00,15\n"
                        + "81,Martillo de Acero, Herramientas,35.00,10\n"
                        + "82,Destornillador Magnetico, Herramientas,25.00,18\n"
                        + "83,Taladro Inalambrico, Herramientas,110.00,5\n"
                        + "84,Sierra Circular, Herramientas,85.00,6\n"
                        + "85,Set Llave Inglesa, Herramientas,55.00,8\n"
                        + "86,Cinta Métrica de 10m, Herramientas,15.00,20\n"
                        + "87,Pinzas de Precisión, Herramientas,30.00,12\n"
                        + "88,Alicates Multiusos, Herramientas,25.00,14\n"
                        + "89,Cincel para Madera, Herramientas,22.00,16\n"
                        + "90,Espátula de Acero, Herramientas,12.00,25\n"
                        + "91,Camiseta Algodón, Ropa,18.00,30\n"
                        + "92,Pantalon Jeans, Ropa,40.00,18\n"
                        + "93,Chaqueta Impermeable, Ropa,70.00,10\n"
                        + "94,Zapatos Deportivos, Ropa,65.00,12\n"
                        + "95,Gorra Deportiva, Ropa,15.00,25\n"
                        + "96,Calcetines Deportivos, Ropa,8.00,40\n"
                        + "97,Guantes de Lana, Ropa,12.00,28\n"
                        + "98,Bufanda de Algodón, Ropa,20.00,22\n"
                        + "99,Cinturon de Cuero, Ropa,30.00,18\n"
                        + "100,Sombrero de Paja, Ropa,35.00,14\n"
                        + "101,Libro de Cocina, Libros,25.00,30\n"
                        + "102,Cuaderno A5, Libros,4.00,120\n"
                        + "103,Manual de Jardinera, Libros,28.00,18\n"
                        + "104,Revista de Ciencia, Libros,9.00,40\n"
                        + "105,Enciclopedia Universal, Libros,60.00,8\n"
                        + "106,Diccionario Español, Libros,35.00,14\n"
                        + "107,Atlas Geográfico, Libros,45.00,10\n"
                        + "108,Novela de Aventuras, Libros,20.00,50\n"
                        + "109,Comic Superheroes, Libros,15.00,70\n"
                        + "110,Ensayo Filosófico, Libros,25.00,22\n"
                        + "111,Cafetera Express, Cocina,120.00,7\n"
                        + "112,Microondas Digital, Cocina,180.00,5\n"
                        + "113,Licuadora Profesional, Cocina,90.00,6\n"
                        + "114,Hervidor Electrico, Cocina,50.00,11\n"
                        + "115,Olla a Presión, Cocina,40.00,14\n"
                        + "116,Sartén Antiadherente, Cocina,55.00,10\n"
                        + "117,Tostadora de Pan, Cocina,40.00,8\n"
                        + "118,Batidora Manual, Cocina,60.00,5\n"
                        + "119,Exprimidor Manual, Cocina,30.00,13\n"
                        + "120,Cuchillo Chef, Cocina,25.00,22\n");
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Archivo escrito correctamente.");
        }
    }

