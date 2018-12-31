

package fragmentocompiladorjava_alas;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * 
 */
public class FragmentoCompiladorJava_ALAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //probarAnalizadorLexico("src/fragmentocompiladorjava_alas/codigofuente.fjl",false);
        //probarAnalizadorSintactico("src/fragmentocompiladorjava_alas/codigofuente.fjl",true);
        //probarAnalizadorSemantico("src/fragmentocompiladorjava_alas/codigofuente.fjl");
        probarGeneradorDeCodigoIntermedio("src/fragmentocompiladorjava_alas/codigofuente.fjl");
        Diccionario Dic = new Diccionario();
        Diccionario.main(args);
    }
    public static void probarAnalizadorLexico(String directorio,boolean mostrarSoloErrores)
    {
        try{
            CodigoFuente cf = new CodigoFuente(directorio);
            AnalizadorLexico al = new AnalizadorLexico(cf.getLineas());
            String bufferError = "";
            Tokens t;
            while((t=al.siguienteToken())!=Tokens.EOT)
                if(!mostrarSoloErrores)
                    if(t==Tokens.ERROR&&al.getTokenActual().getToken().length()==1)
                        bufferError+=al.getTokenActual().getToken();
                    else
                    {
                        if(bufferError.length()>0)
                        {
                            System.out.println("\""+bufferError+"\" es ERROR");
                            bufferError = "";
                        }
                        System.out.println("\""+al.getTokenActual().getToken()+"\" es "+t);
                    }
        }catch(FileNotFoundException exc){
            System.err.println("No se encontró el archivo con el código fuente.");
        }catch(IOException exc){
            System.err.println("Hubo un error durante la lectura del archivo con el código fuente.");
        }
    }
    public static void probarAnalizadorSintactico(String directorio,boolean mostrarArbol)
    {
        try{
            CodigoFuente cf = new CodigoFuente(directorio);
            AnalizadorLexico al = new AnalizadorLexico(cf.getLineas());
            AnalizadorSintactico as = new AnalizadorSintactico(al);
            ArbolSintactico arsi = as.analizarSintaxis();
            if(mostrarArbol)
                System.out.println("\033[34m"+arsi.toString()+"\033[30m");
        }catch(FileNotFoundException exc){
            System.err.println("No se encontró el archivo con el código fuente.");
        }catch(IOException exc){
            System.err.println("Hubo un error durante la lectura del archivo con el código fuente.");
        }
    }
    public static void probarAnalizadorSemantico(String directorio)
    {
        try{
            CodigoFuente cf = new CodigoFuente(directorio);
            AnalizadorLexico al = new AnalizadorLexico(cf.getLineas());
            AnalizadorSintactico as = new AnalizadorSintactico(al);
            AnalizadorSemantico anse = new AnalizadorSemantico(as);
            anse.analizarSemantica();
        }catch(FileNotFoundException exc){
            System.err.println("No se encontró el archivo con el código fuente.");
        }catch(IOException exc){
            System.err.println("Hubo un error durante la lectura del archivo con el código fuente.");
        }
    }
    public static void probarGeneradorDeCodigoIntermedio(String directorio)
    {
        try{
            CodigoFuente cf = new CodigoFuente(directorio);
            AnalizadorLexico al = new AnalizadorLexico(cf.getLineas());
            AnalizadorSintactico as = new AnalizadorSintactico(al);
            AnalizadorSemantico anse = new AnalizadorSemantico(as);
            GeneradorDeCodigoIntermedio gci = new GeneradorDeCodigoIntermedio(anse);
            gci.generarCodigoIntermedio((directorio.substring(0, directorio.length()-3)+"cpp"));
        }catch(FileNotFoundException exc){
            System.err.println("No se encontró el archivo con el código fuente.");
        }catch(IOException exc){
            System.err.println("Hubo un error durante la lectura del archivo con el código fuente.");
        }
    }
}
