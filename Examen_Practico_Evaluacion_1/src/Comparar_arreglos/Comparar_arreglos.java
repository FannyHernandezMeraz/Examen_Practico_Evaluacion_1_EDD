
package Comparar_arreglos;

import java.util.Scanner;

/**
 * @author 21550292, 21550332
 */
public class Comparar_arreglos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        Scanner s = new Scanner(System.in);
        boolean a = true;
        
        System.out.println("Introduce los valores del ARREGLO 1");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = s.nextInt();
        }
        
        System.out.println("Introduce los valores del ARREGLO 2");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = s.nextInt();
        }
        
        imp(arr1);
        System.out.println("");
        imp(arr2);
        
        for (int i = 0; i < 10; i++) {
            if (arr1[i] == arr2[i]) {
                a = true;
            } else {
               a = false; 
            }
        }
        if (a == true) {
            System.out.println("\nAmbos arreglos son iguales");
        } else {
            System.out.println("\nLos arreglos no son iguales");
        }
    }
    public static void imp(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
    }
}
