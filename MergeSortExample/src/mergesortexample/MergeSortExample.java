/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mergesortexample;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class MergeSortExample {

    public static void mergeSort(int[] arr, int izqui, int derech) {
        if (izqui < derech) {
            int mitad = izqui + (derech - izqui) / 2;
            
            mergeSort(arr, izqui, mitad);
            mergeSort(arr, mitad + 1, derech);
            
            merge(arr, izqui, mitad, derech);
        }
    }

    public static void merge(int[] arr, int izqui, int mitad, int derech) {
        int numero_1 = mitad - izqui + 1;
        int numero_2 = derech - mitad;
        
        int[] leftArray = new int[numero_1];
        int[] rightArray = new int[numero_2];
        
        for (int i = 0; i < numero_1; i++) {
            leftArray[i] = arr[izqui + i];
        }
        for (int j = 0; j < numero_2; j++) {
            rightArray[j] = arr[mitad + 1 + j];
        }
        
        int i = 0, j = 0, k = izqui;
        while (i < numero_1 && j < numero_2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < numero_1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < numero_2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        System.out.print("Ingresa el número de elementos que vas a poner: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Ingresa los números uno por uno:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();
        //aqui eliminas 
        HashSet<Integer> uniqueSet = new HashSet<>();
        ArrayList<Integer> uniqueList = new ArrayList<>();

        for (int num : arr) {
            if (!uniqueSet.contains(num)) {
                uniqueSet.add(num);
                uniqueList.add(num);
            }
        }

        // Convertir la lista de números únicos a un arreglo
        int[] uniqueArr = new int[uniqueList.size()];
        for (int i = 0; i < uniqueList.size(); i++) {
            uniqueArr[i] = uniqueList.get(i);
        }

        System.out.println("Numeros únicos antes de ordenar:");
        for (int num : uniqueArr) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort(uniqueArr, 0, uniqueArr.length - 1);

        System.out.println("Numeros únicos después de ordenar:");
        for (int num : uniqueArr) {
            System.out.print(num + " ");
        }
        
    }
    
}

