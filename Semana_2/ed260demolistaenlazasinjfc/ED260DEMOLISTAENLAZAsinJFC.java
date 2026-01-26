/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ed260demolistaenlazasinjfc;

import msClases.ListaEnlazada;

/**
 *
 * @author Lucero Gutierrez
 */
public class ED260DEMOLISTAENLAZAsinJFC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
//        lista.insertarInicio(1.0);
//        lista.insertarFinal(3.0);
//        lista.insertarFinal(5.0);
//        lista.insertarFinal(7.0);
//        lista.mostrar();
//        lista.insertaXposicion(4.0, 2);
//        lista.mostrar();
        lista.insertarFinalTail(8.0);
        lista.mostrar();
        lista.insertarFinalTail(9.0);
        lista.mostrar();
        lista.insertarFinalTail(10.0);
        lista.mostrar();
        lista.insertarFinalTail(11.0);
        lista.mostrar();
        System.out.print("Eliminamos: \n");
        lista.eliminarXposicion(2);
        lista.mostrar();
        System.out.print("Buscamos: \n");
        lista.buscarValor(10.0);
        lista.buscarPosicion(2);
        lista.insertarFinalTail(1.0);
        lista.mostrar();
        System.out.print("Ordenamos: \n");
        lista.ordenarBurbuja();
        lista.mostrar();

    }
    
}
