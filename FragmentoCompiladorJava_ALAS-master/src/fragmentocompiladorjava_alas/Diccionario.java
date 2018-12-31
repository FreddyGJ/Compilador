package fragmentocompiladorjava_alas;
import javax.swing.JOptionPane;

/**
 *
 * @author Galvez & Rivers
 */
public class Diccionario {
    public static void main(String[] args) {
        String simbolo = JOptionPane.showInputDialog("Ingrese un simbolo: ");
        String simbolos [] = {"=", "+", "-", "*", "/", "%", "<", ">", "&&", "||"};
        String input;
        
        input = simbolo;
        boolean b = true;

        do {
            for (int a = 0; a <= 9; a++) {
                if (input.equals(simbolos[a])) {

                    if (input.equals("=")) {
                        System.out.println("Signo significa ASIGNACION");
                        b = false;
                        break;

                    } else if (input.equals("+")) {
                        System.out.println("Signo significa SUMA");
                        b = false;
                        break;

                    } else if (input.equals("-")) {
                        System.out.println("Signo significa RESTA");
                        b = false;
                        break;

                    } else if (input.equals("*")) {
                        System.out.println("Signo significa MULTIPLICACION");
                        b = false;
                        break;
                    } else if (input.equals("/")) {
                        System.out.println("Signo significa DIVISION");
                        b = false;
                        break;
                    } else if (input.equals("<")) {
                        System.out.println("Signo significa MENOR QUE");
                        b = false;
                        break;
                    } else if (input.equals(">")) {
                        System.out.println("Signo significa MAYOR QUE");
                        b = false;
                        break;
                    } else if (input.equals("%")) {
                        System.out.println("Signo significa MODULO");
                        b = false;
                        break;
                    } else if (input.equals("&&")) {
                        System.out.println("Signo significa AND");
                        b = false;
                        break;
                    } else if (input.equals("||")) {
                        System.out.println("Signo significa OR");
                        b = false;
                        break;
                    }
                }
                else{
                b = false;
                }
            }
        } while(b == true);
    }
}
