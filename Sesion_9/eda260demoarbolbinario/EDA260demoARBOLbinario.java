/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eda260demoarbolbinario;

/**
 *
 * @author Lucero Gutierrez
 */
public class EDA260demoARBOLbinario {
    public static void main(String[] args) {
        ArbolBinario arbol=new ArbolBinario();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
        arbol.insertar(10);
        arbol.insertar(25);
        System.out.println("InOrden (IRD):");
        arbol.inOrden(arbol.raiz);        
        System.out.println("\nPreOrden (RID):");
        arbol.preOrden(arbol.raiz);
        System.out.println("\nPostOrden (IDR):");
        arbol.postOrden(arbol.raiz);
    }
    
}
