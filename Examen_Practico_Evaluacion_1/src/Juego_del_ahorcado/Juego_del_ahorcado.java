package Juego_del_ahorcado;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 21550292, 21550332
 */
public class Juego_del_ahorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // arreglo de caracteres bidimensional con las palabras del juego
        char[][] hangman = {{'a', 'z', 'u', 'l'},
        {'b', 'e', 'c', 'e', 'r', 'r', 'o'},
        {'d', 'i', 'a'},
        {'c', 'r', 'o', 'm', 'o'},
        {'g', 'a', 't', 'o'}};
        // declaracion de variables
        int intentos = 0, c = 0, y = 0, left = 0; // num de intentos, c para si quiere seguir jugando, y para el dowhile del juego, left son intentos que quedan
        String guess = "", progreso = ""; // guess -> letra que adivina, progreso -> concatena las letras que va 
        char letra = ' '; // char para comparacion luego
        int r = (int) (Math.random() * 4); // genera un numero random para elegir la palabra al azar segun su posicion en el arreglo
        char[] word = hangman[r]; // la palabra sera igual a la del indice del numero random

        do {
            System.out.println("*~~~~~~~~ AHORCADO ~~~~~~~~*");
            while (intentos <= 4) {
                progreso += guess; // concatena las letras adivinadas
                System.out.println(r); // imprime la posicion elegida del arreglo
                for (int i = 0; i < word.length; i++) { // imprime las casillas vacias (numero de letras)
                    System.out.print("[ ]");
                }
                System.out.println("\nSabes la palabra?: \n1.Si  0.No");
                y = s.nextInt(); // se almacena la respuesta del usuario

                switch (y) { 
                    case 1:// si conoce la palabra
                        System.out.print("Escribe la palabra: ");
                        guess = s.next(); // almacena la palabra completa
                        // si la palabra inicial es igual a la adivinada 
                        if (Arrays.equals(word, guess.toCharArray())) { // se convierte guess a arreglo de caracteres para comparar con word
                            System.out.println("Ganaste ^_^");
                        } else { // si no
                            System.out.println("Perdiste :(");
                            break;
                        }
                        break;

                    case 0: // si no conoce la palabra
                        do {
                            System.out.print("Que letra quieres buscar?: ");
                            guess = s.next(); // almacena la letra que ingresa el usuario
                            letra = guess.charAt(0);  // la letra se convierte a char
                            /*for (int i = 0; i < word.length; i++) {
                                if (guess.charAt(i) == letra) {
                                    guess = guess.replaceAll("[ ]", "[_]");
                                }
                            }*/
                            for (int i = 0; i < word.length; i++) {
                                if (word[i] == letra) { // si el caracter en el indice i es igual a letra
                                    System.out.print("[" + letra + "]"); // se imprime letra
                                } else {
                                    System.out.print("[ ]"); // si no, se imprime vacio
                                }
                            }
                            /*for (int i = 0; i < word.length; i++) {
                                if (letra == word[i]) {
                                    System.out.println(" ");
                                }
                            }
                             */
                            if (progreso.toCharArray().equals(Arrays.toString(word))) { // si el progreso es igual a la palabra
                                System.out.println("\nAdivinaste la palabra '\'^^/");
                            } else if (Arrays.toString(word).contains(guess)) { // si word contiene la letra adivinada
                                System.out.println(progreso);
                            } else { // si no es igual, o si la letra no esta en esa palabra
                                System.out.println("Esa letra no existe");
                                intentos++; // cuenta el intento
                                left = 4 - intentos; // intentos que quedan
                                System.out.println("Te quedan " + (left) + " oportunidades");
                            }
                        } while (left > 0); // se juega mientras los intentos que quedan sean mayor a cero
                        break;
                    default:
                        System.out.println("Entrada no valida");
                        break;
                }
            }

            System.out.println("Quieres seguir jugando? \n1.Si   0.No");
            c = s.nextInt(); // almacena la respuesta del usuario
        } while (c > 0); // sigue jugando mientras que el usuario ponga un valor mayor a 0
    }

}
