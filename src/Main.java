import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static BinarySearchTree Ingles = new BinarySearchTree();
    public static BinarySearchTree Espanol = new BinarySearchTree();
    public static BinarySearchTree Frances = new BinarySearchTree();
    public static String Globaltexto = "";
    public static void main(String[] args) {
        // Leer archivo de asociaciones y guardarlo en un arbol
        Reader("src/diccionario.txt",false);

        // Leer texto y guardarlo
        Reader("src/texto.txt",true);

        // separa las palabras del texto
        String[] textoAr = Globaltexto.split(" ");

        // se deshace del punto final si hay
        if(textoAr[textoAr.length-1].charAt(textoAr[textoAr.length-1].length()-1) =='.'){
            String tem = textoAr[textoAr.length-1].substring(0, textoAr[textoAr.length-1].length()-1);
            textoAr[textoAr.length-1]=tem;
        }

        // se ejecuta el menu
        boolean boo = true;
        do{
            // detecta el idioma
            int idioma = detectarIdioma(textoAr);
            View.deteccionIdioma(idioma);
            switch (View.MainMenu()){
                case 1: //Traducir a Ingles
                    if(idioma == 2){ //Español a Ingles
                        System.out.println(Traductor.traducir(Espanol,textoAr,0));
                    } else if (idioma == 3){ // Frances a Ingles
                        System.out.println(Traductor.traducir(Frances,textoAr,0));
                    } else{ // Ingles a Ingles
                        System.out.println("Ingles a Ingles: "+Globaltexto);
                    }
                    break;
                case 2: // al español
                    if(idioma == 0 || idioma == 1){ //Ingles a Español
                        System.out.println(Traductor.traducir(Ingles,textoAr,0));
                    } else if (idioma == 3){ // Frances a Español
                        System.out.println(Traductor.traducir(Frances,textoAr,1));
                    } else{ // Español a Español
                        System.out.println("Español a Español: "+Globaltexto);
                    }
                    break;
                case 3: // al Frances
                    if(idioma == 0 || idioma == 1){ //Ingles a Frances
                        System.out.println(Traductor.traducir(Ingles,textoAr,1));
                    } else if (idioma == 2){ // Español a Frances
                        System.out.println(Traductor.traducir(Espanol,textoAr,1));
                    } else{ // Frances a Frances
                        System.out.println("Frances a Frances: "+Globaltexto);
                    }
                    break;
                case 4:
                    Ingles.printAsociaciones();
                    break;
                default:
                    boo = false;
            }
        } while(boo);
    }

    // método que lee el archivo
    public static void Reader(String archivo, boolean texto){
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            if(texto){ // si es el texto, lo guarda
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    Globaltexto = line;
                }
            } else{ // si es el diccionario, lo guarda para los arboles establecidos
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

    // detecta el idioma y regresa un entero
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