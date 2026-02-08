/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ed260demosort;

/**
 *
 * @author Lucero Gutierrez
 */
public class ED260DEMOSORT {
    public static void main(String[] args) {
        int arr[] = {10, 3, 8, 4, 2};
        mostrar(arr);
        System.out.print("\nOrdenamiento por CountingSort");
        countingSort(arr);
        mostrar(arr);
        System.out.print("\n------------------------------");
        int arr2[] = {100, 33, 88, 40, 20};
        mostrar(arr2);
        System.out.print("\nOrdenamiento por HeapSort");
        heapSort(arr2);
        mostrar(arr2);
    }
    public static void countingSort(int[] arr) {
        int max = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
        }
        int conteo[] = new int[max + 1];
        for (int x : arr) {
            conteo[x]++;
        }
        int index = 0;
        for (int i = 0; i < conteo.length; i++) {
            while (conteo[i] > 0) {
                arr[index] = i;
                index++;
                conteo[i]--;
            }
        }
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    public static void heapify(int[] arr, int n, int i) {
        int mayor = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;
        if (izq < n && arr[izq] > arr[mayor])
            mayor = izq;
        if (der < n && arr[der] > arr[mayor])
            mayor = der;
        if (mayor != i) {
            int temp = arr[i];
            arr[i] = arr[mayor];
            arr[mayor] = temp;

            heapify(arr, n, mayor);
        }
    }
    public static void mostrar(int arr[]){
        System.out.print("\n");
        for(int x:arr) System.out.print(x+" ");
    }
}
