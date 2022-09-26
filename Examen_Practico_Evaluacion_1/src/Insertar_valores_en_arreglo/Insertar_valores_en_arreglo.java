package Insertar_valores_en_arreglo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 21550292, 21550332
 */
public class Insertar_valores_en_arreglo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arreglo = new int[15];
        for (int i = 0; i < 15; i++) {
            System.out.print("Ingresa un valor: ");
            int num = s.nextInt();
            arreglo[i] = num;
            //Arrays.sort(arreglo);
            contarOcupados(num, arreglo);
            System.out.println(Arrays.toString(arreglo));
        }
    }

    public static void contarOcupados(int v, int[] arr) {
        //contar lugares ocupados
        int c = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                c = i + 1;
                break;
            }
        }
        //busqueda binaria
        int indice = Arrays.binarySearch(arr, 0, c, v);
        if (indice == 0) {//si encuentra el valor en la posicion 0
            System.arraycopy(arr, 0, arr, 1, arr.length - 1);
            arr[0] = v;
        } else { //regresa una posicion negativa si no halla el valor
            int p = indice < 0 ? -indice - 1 : indice; //si no encuentra la valirable se inserta en la posicion -indice-1, si la encuentra tmb se pone
            System.arraycopy(arr, p, arr, p + 1, arr.length - p - 1); //mueve el arreglo a la derecha y deja el ultimo elemento x el tamaño
            arr[p] = v;
        }
        // en la salida sale dos veces el valor que ingresa, en la posicion correcta y despues del ultimo elemento pero no hallamos como cambiar eso :/
    }
}
