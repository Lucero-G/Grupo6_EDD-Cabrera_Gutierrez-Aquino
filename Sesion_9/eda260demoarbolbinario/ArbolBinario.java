/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda260demoarbolbinario;

/**
 *
 * @author Lucero Gutierrez
 */
public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }
    public void insertar(int valor){
        raiz = insertarRecursivo(raiz, valor);
    }
    private Nodo insertarRecursivo(Nodo nodo, int valor){
        if (nodo==null) return new Nodo(valor);
        if(valor<nodo.valor) nodo.izquierdo=insertarRecursivo(nodo.izquierdo,valor);
        else nodo.derecho=insertarRecursivo(nodo.derecho,valor);
        return nodo;
    }
    //RECORRIDO inORDEN =iRD
    public void inOrden (Nodo nodo){
        if(nodo!=null){
            inOrden(nodo.izquierdo);
            System.out.println(nodo.valor);
            inOrden(nodo.derecho);
        }
    }
    // RECORRIDO preORDEN =RID
    public void preOrden(Nodo nodo){
        if(nodo != null){
            System.out.println(nodo.valor);  
            preOrden(nodo.izquierdo);        
            preOrden(nodo.derecho);          
        }
    }
    // RECORRIDO postORDEN =IDR
    public void postOrden(Nodo nodo){
        if(nodo != null){
            postOrden(nodo.izquierdo);       
            postOrden(nodo.derecho);         
            System.out.println(nodo.valor);  
        }
    }
}
