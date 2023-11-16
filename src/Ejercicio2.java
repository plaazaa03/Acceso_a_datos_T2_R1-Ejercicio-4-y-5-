import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args){
   Scanner scanner = new Scanner(System.in);
   System.out.println("Introduzca la ruta de directorio: ");
   String directorio = scanner.nextLine();

        File file = new File(directorio);
        if (file.exists() && file.isDirectory()) {
            String[] ficheros = file.list();
            for (String fichero : ficheros) {
                File archivo = new File(file.getAbsolutePath() + File.separator + fichero);
                if (archivo.isDirectory()) {
                    System.out.println(fichero + " - Es un directorio");
                } else {
                    System.out.println(fichero + " - Es un fichero");
                }
            }
        } else {
            System.out.println("El directorio no existe o no es válido");
        }
    }
}