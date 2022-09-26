package Borrar_valores_en_arreglo;

import java.util.Scanner;

/**
 * @author 21550292, 21550332
 */
public class Borrar_valores_en_arreglo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int c = 0;
        int[] arreglo = new int[15];
        for (int i = 0; i < arreglo.length; i++) {
            int r = (int) (Math.random() * 100) + 1;
            if (r > 0) {
                arreglo[i] = r;
            }
        }
        imprimir(arreglo);
        System.out.println("\n ¿Qué número desea eliminar?");
        int del = s.nextInt();
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == del) {
                arreglo[i] = 0;
            }
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != 0) {
                arreglo[c++] = arreglo[i];
            }
        }
        while (c < arreglo.length) {
            arreglo[c++] = 0;
        }
        imprimir(arreglo);
    }

    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
    }
}
