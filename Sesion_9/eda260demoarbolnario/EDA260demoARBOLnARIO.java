/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eda260demoarbolnario;

/**
 *
 * @author Lucero Gutierrez
 */
public class EDA260demoARBOLnARIO {
    public static void main(String[] args) {
        ArbolGeneral arbol = new ArbolGeneral("A");
        arbol.insertar(arbol.raiz, "B");
        arbol.insertar(arbol.raiz, "C");
        arbol.insertar(arbol.raiz, "D");
        Nodo nodoB = arbol.raiz.hijos.get(0);
        arbol.insertar(nodoB, "E");
        arbol.insertar(nodoB, "F");
        Nodo nodoC = arbol.raiz.hijos.get(1);
        arbol.insertar(nodoC, "G");
        System.out.println("Recorrido en amplitud:");
        arbol.recorridoAmplitud();
        System.out.println("\nRecorrido en profundidad (preorden):");
        arbol.recorridoProfundidad();
    }
}
