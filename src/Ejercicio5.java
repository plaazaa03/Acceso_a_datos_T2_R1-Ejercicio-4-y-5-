import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Fichero que vamos a crear
        System.out.println("Introduce el nombre del fichero: ");
        String nombreFichero = scanner.nextLine();

        escribirEnFichero(nombreFichero, scanner);

        leerYMostrarFichero(nombreFichero);

        scanner.close();
    }

    private static void escribirEnFichero(String nombreFichero, Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {
            System.out.println("Introduce 20 líneas de texto: ");

            //Leer las 20 lineas del texto.
            for (int i = 0; i < 20; i++) {
                String linea = scanner.nextLine();
                writer.write(linea);
                writer.newLine();
            }

            System.out.println("Líneas de texto escritas en el fichero correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerYMostrarFichero(String nombreFichero) {
        try {

            } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
