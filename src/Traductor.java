public class Traductor {
    public static String traducir(BinarySearchTree asociacion, String[] texto, int pos){
        String resultado = "";
        // Recorre el array dado
        for(String st: texto){
            if(asociacion.search(st)!=null){ // si encuentra la traducción la concatena al resultado
                resultado+=" "+asociacion.search(st).split(",")[pos];
            } else{ // si no, concatena la original entre asteriscos
                resultado+=" *"+st+"*";
            }
        }
        return resultado;
    }

}
