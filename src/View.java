import java.sql.SQLOutput;
import java.util.Scanner;

public class View {
    private static Scanner scan;

    public static void deteccionIdioma(int idioma){
        switch (idioma){
            case 1:
                System.out.println("IDIOMA DETECTADO: INGLES");
                break;
            case 2:
                System.out.println("IDIOMA DETECTADO: ESPAÑOL");
                break;
            case 3:
                System.out.println("IDIOMA DETECTADO: FRANCES");
                break;
            default:
                System.out.println("IDIOMA NO DETECTADO");
        }
    }
    public static int MainMenu(){
        int op = 0;
        boolean boo = true;
        do{
            System.out.println("Ingrese una opción:");
            System.out.println("1. Traducir texto al Inglés");
            System.out.println("2. Traducir texto al Español");
            System.out.println("3. Traducir texto al Francés");
            System.out.println("4. Mostrar relaciones");
            System.out.println("5. Salir");
            System.out.println("-->");
            try{
                scan = new Scanner(System.in);
                op = scan.nextInt();
                boo = false;
            } catch (Exception e){
                System.out.println("Ingrese una opción válida.");
                System.out.println("");
            }
        } while (boo);
        return op;
    }
}
