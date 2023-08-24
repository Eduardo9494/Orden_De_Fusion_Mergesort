/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mergesort;

/**
 *
 * @author Alumno
 */
//Definimos una nueva clase llamada "MergeSort"
public class MergeSort {
    
    //define un método llamado "mergesort"  que es estático , mi parametro "a"
    static void mergeSort(int[] a, int i, int d) {
        
        //es una condicional de para la fucion que "i" es izquierda y "d" que es derecha  
        if (i < d) { 
           
            int m = (i + d) / 2;
            
            mergeSort(a, i, m);
            mergeSort(a, m + 1, d);
            
            int n = d - i + 1, j = i, k = m + 1, l = 0;
            
            int[] t = new int[n];
            
            while (l < n) t[l++] = j > m || (k <= d && a[j] > a[k]) ? a[k++] : a[j++]; 
            
            System.arraycopy(t, 0, a, i, n);
        }
    }

    public static void main(String[] args) {
        
        int[] arr = {31, 4, 88, 2, 4, 2, 42};
        
        //"arrays.tostring" convierte un arreglo en una cadena de texto legible para mejorar la comprensión y la capacidad de depuración.
        System.out.println("Lista original: " + java.util.Arrays.toString(arr));  
        
        //Se llama al método mergeSort para ordenar el arreglo arr desde el índice 0 hasta el último índice.
        mergeSort(arr, 0, arr.length - 1);
        
        System.out.println("Lista ordenada: " + java.util.Arrays.toString(arr));
    }
}
