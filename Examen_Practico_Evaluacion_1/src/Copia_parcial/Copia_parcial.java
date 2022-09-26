package Copia_parcial;

import java.util.Scanner;

/**
 * @author 21550292, 21550332
 */
public class Copia_parcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arreglo = new int[15];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 20) + 1;
        }
        imp(arreglo);

        int ini, fin, c = 0;
        Scanner num = new Scanner(System.in);
        System.out.println("\n¿Desde qué posición inicial desea copiar?");
        ini = num.nextInt();

        System.out.println("Hasta que posición final");
        fin = num.nextInt();

        int[] copia = new int[fin - ini];
        for (int i = 0; i < arreglo.length; i++) {
            if (i >= ini && i <= fin) {
                if (arreglo[i] % 2 == 0) {
                    copia[c] = arreglo[i];
                    c++;
                }
            }
        }
        imp(copia);
    }

    public static void imp(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
    }
}
