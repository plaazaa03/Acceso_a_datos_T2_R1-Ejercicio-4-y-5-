import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("============MENU DE OPCIONES=============");
            System.out.println("1. Crear un nuevo Directorio.");
            System.out.println("2. Crear un fichero vacío.");
            System.out.println("3. Listar el contenido de un fichero o directorio.");
            System.out.println("4. Renombrar un fichero o un directorio.");
            System.out.println("5. Borrar un fichero o un directorio.");
            System.out.println("6. Introducir una cadena de texto en un fichero.");
            System.out.println("7. Añadir texto a un fichero existente.");
            System.out.println("8. Salir del programa.");
            System.out.println("Introduce una opción (1-8): ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    CrearDirectorio(scanner);
                    break;
                case 2:
                    CrearFichero(scanner);
                    break;
                case 3:
                    ListarContenido(scanner);
                    break;
                case 4:
                    Renombrar(scanner);
                    break;
                case 5:
                    Borrar(scanner);
                    break;
                case 6:
                    IntroducirCadena(scanner);
                    break;
                case 7:
                    AñadirTextoFichero(scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del menu");
                    break;
                default:
                    System.out.println("Opcion invalida. Usa un numero del 1 al 8.");
                    break;
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static void CrearDirectorio(Scanner scanner) {
        System.out.println("Introduce la ruta del directorio:");
        String rutaDirectorio = scanner.next();
        File file = new File(rutaDirectorio);
        if (file.mkdir()) {
            System.out.println("El directorio ha sido creado");
        } else {
            System.out.println("El directorio no ha sido creado");
        }
    }

    private static void CrearFichero(Scanner scanner) throws IOException {
        try {
            System.out.println("Introduce la ruta:");
            String rutaFichero = scanner.next();
            File file = new File(rutaFichero);

            if (file.exists()) {
                System.out.println("El fichero ya existe.");
            } else {
                if (file.createNewFile()) {
                    System.out.println("El fichero ha sido creado.");
                } else {
                    System.out.println("El fichero no ha sido creado.");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void ListarContenido(Scanner scanner) { //Funciona
        System.out.println("Introduce la ruta del directorio:");
        String rutaDirectorio = scanner.next();
        File file = new File(rutaDirectorio);
        if (file.isDirectory()) {
            String[] contenido = file.list();
            if (contenido != null) {
                for (String elemento : contenido) {
                    System.out.println(elemento);
                }
            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("La ruta no corresponde a un directorio.");
        }
    }

    private static void Renombrar(Scanner scanner) { //Funciona
        System.out.println("Introduce la ruta y nombre del archivo a renombrar:");
        String rutaArchivo = scanner.next();
        File file = new File(rutaArchivo);
        if (file.exists()) {
            System.out.println("Introduce la nueva ruta y nombre del archivo:");
            String nuevaRuta = scanner.next();
            File nuevoArchivo = new File(nuevaRuta);
            if (file.renameTo(nuevoArchivo)) {
                System.out.println("El archivo ha sido renombrado");
            } else {
                System.out.println("El archivo no ha sido renombrado");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    private static void Borrar(Scanner scanner) { //Funciona
        System.out.println("Introduce la ruta y nombre del archivo o directorio a borrar:");
        String rutaArchivo = scanner.next();
        File file = new File(rutaArchivo);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("El archivo o directorio ha sido borrado");
            } else {
                System.out.println("El archivo o directorio no ha podido ser eliminado");
            }
        } else {
            System.out.println("El archivo o directorio no existe.");
        }
    }

    private static void IntroducirCadena(Scanner scanner) { //Funciona
        try {
            System.out.println("Introduce la ruta y nombre del fichero:");
            String rutaFichero = scanner.next();
            scanner.nextLine();
            System.out.println("Introduce la cadena de texto:");
            String texto = scanner.nextLine();

            try (FileWriter writer = new FileWriter(rutaFichero)) {
                writer.write(texto);
            }

            System.out.println("La cadena de texto ha sido introducida en el fichero correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void AñadirTextoFichero(Scanner scanner) throws IOException { //Funciona
        System.out.println("Introduce la ruta y nombre del fichero:");
        String rutaFichero = scanner.next();
        scanner.nextLine();
        System.out.println("Introduce el texto a añadir:");
        String texto = scanner.nextLine();
        FileWriter writer = new FileWriter(rutaFichero, true);
        writer.write(texto);
        writer.close();
        System.out.println("El texto ha sido añadido al fichero correctamente.");
    }
}