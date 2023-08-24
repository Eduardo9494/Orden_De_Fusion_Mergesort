package sesion1_tarea;

import java.util.Scanner;

import java.io.*;



public class MergeSort {
    void mergeSort(int a[], int I, int D) {
        if (I < D) { 
            int m = (I + D) / 2;
            mergeSort(a, I, m); //// Llamada recursiva para ordenar la mitad izquierda
            mergeSort(a, m + 1, D); // Llamada recursiva para ordenar la mitad derecha
            int b[] = new int[D - I + 1], iz = I, de = m + 1, pa = 0; // Se crea un nuevo arreglo b ,,cantidad de elementos en el subarreglo,,utilizada para rastrear la posición actual en el arreglo b
            while (pa < b.length) b[pa++] = de > D | (iz <= m & a[iz] < a[de]) ? a[iz++] : a[de++]; //longitud del arreglo b
            System.arraycopy(b, 0, a, I, b.length); //copia los elementos del arreglo
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("INGRESE LA CANTIDAD DE NUMEROS: ");
        n = scanner.nextInt();
        int arr[] = new int[n]; //crea un nuevo arreglo de enteros llamado arr

        System.out.println("INGRESE LOS NUMEROS UNO POR UNO: ");
        for (int i = 0; i < n; i++) { //En cada iteración, el valor de i aumenta en 1.
            arr[i] = scanner.nextInt();
        }

        MergeSort mergeSort = new MergeSort(); //Crea una nueva instancia de la clase 
        mergeSort.mergeSort(arr, 0, arr.length - 1); //llama al metodo merge short ,,,el arreglo arr que se va a ordenar, el índice izquierdo 0

        System.out.println("LOS NUMEROS ORDENADOS CON MENRGE SORT SON:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        scanner.close();
    }
}