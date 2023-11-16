import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        File file = new File("VerInf.java");
        System.out.println("====================================");
        System.out.println("Nombre del fichero: "+file.getName());
        System.out.println("Ruta: "+file.getPath());
        System.out.println("Ruta absoluta: " +file.getAbsolutePath());
        System.out.println("Se puede escribir: "+file.canWrite());
        System.out.println("Se puede leer: "+file.canRead());
        System.out.println("Tamaño: "+file.length());
        System.out.println("Es un directorio: "+file.isDirectory());
        System.out.println("Es un fichero: "+file.isFile());
        System.out.println("=======================================");

    }
}
