public class Traductor {
    public static String traducir(BinarySearchTree asociacion, String[] texto, int pos){
        String resultado = "";
        for(String st: texto){
            if(asociacion.search(st)!=null){
                resultado+=" "+asociacion.search(st).split(",")[pos];
            } else{
                resultado+=" *"+st+"*";
            }
        }
        return resultado;
    }

}
