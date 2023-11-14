import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

       //Crear fichero 1
        System.out.println("Introduce el nombre del primer fichero: ");
        String nombreFichero1 = scanner.nextLine();
        //Crear fichero 2
        System.out.println("Introduce el nombre del segundo fichero: ");
        String nombreFichero2 = scanner.nextLine();
        //Crear fichero resultante
        System.out.println("Introduce el nombre del fichero resultante: ");
        String nombreFicheroResultado = scanner.nextLine();

        //Metodo para mezclar los ficheros
        mezclarFicheros(nombreFichero1, nombreFichero2, nombreFicheroResultado);

        System.out.println("Ficheros mezclados.");

        scanner.close();
    }

    private static void mezclarFicheros(String nombreFichero1, String nombreFichero2, String nombreFicheroResultado) throws IOException {
        //Leemos el fichero1 y el fichero2, y escribimos en el fichero resultante
        try (BufferedReader reader1 = new BufferedReader(new FileReader(nombreFichero1));
             BufferedReader reader2 = new BufferedReader(new FileReader(nombreFichero2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFicheroResultado))) {

            //Leer lineas
            String linea1 = reader1.readLine();
            String linea2 = reader2.readLine();

            while (linea1 != null || linea2 != null) {
                if (linea1 != null) {
                    writer.write(linea1);
                    writer.newLine();
                    linea1 = reader1.readLine();
                }
                if (linea2 != null) {
                    writer.write(linea2);
                    writer.newLine();
                    linea2 = reader2.readLine();
                }
            }
        }
    }
}
