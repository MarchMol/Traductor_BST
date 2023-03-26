import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static BinarySearchTree Ingles = new BinarySearchTree();
    public static BinarySearchTree Espanol = new BinarySearchTree();
    public static BinarySearchTree Frances = new BinarySearchTree();
    public static String Globaltexto = "";
    public static void main(String[] args) {

        // Leer archivo de asociaciones y guardarlo en un arbol
        Reader("src/diccionario.txt",false);
        Reader("src/texto.txt",true);
        boolean boo = true;
        do{
            String[] textoAr;
            switch (View.MainMenu()){
                case 1: //Ingles
                    textoAr = Globaltexto.split(" ");
                    View.deteccionIdioma(detectarIdioma(textoAr));
                    break;
                case 2: // al español
                    textoAr = Globaltexto.split(" ");
                    View.deteccionIdioma(detectarIdioma(textoAr));
                    break;
                case 3: // al frances
                    textoAr = Globaltexto.split(" ");
                    View.deteccionIdioma(detectarIdioma(textoAr));
                    break;
                case 4:
                    Ingles.printAsociaciones();
                    break;
                default:
                    boo = false;
            }
        } while(boo);
    }

    public static void Reader(String archivo, boolean texto){
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            if(texto){
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    Globaltexto = line;
                }
            } else{
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    String[] tem = line.split(",");
                    Ingles.insert(tem[0],tem[1]+","+tem[2]);
                    Espanol.insert(tem[1],tem[0]+","+tem[2]);
                    Frances.insert(tem[2],tem[0]+","+tem[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int detectarIdioma(String[] textoAr){
        for (String st: textoAr){
            if(Ingles.search(st)!=null){
                return 1;
            } else if (Espanol.search(st)!=null) {
                return 2;
            } else if (Frances.search(st)!=null) {
                return 3;
            }
        }
        return 0;
    }

}