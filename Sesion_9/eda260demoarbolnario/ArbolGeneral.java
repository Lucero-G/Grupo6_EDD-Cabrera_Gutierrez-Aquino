/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda260demoarbolnario;

import java.util.ArrayList;

/**
 *
 * @author Lucero Gutierrez
 */
public class ArbolGeneral {
    Nodo raiz;

    public ArbolGeneral(String valorRaiz) {
        this.raiz = new Nodo(valorRaiz);
    }
    public void insertar(Nodo nodoPadre, String valorHijo){
        Nodo hijo=new Nodo(valorHijo);
        nodoPadre.agregarHijo(hijo);
    }
    public void eliminar(Nodo nodoPadre, Nodo nodoHijo){
        nodoPadre.hijos.remove(nodoHijo);
    }
    public void recorridoAmplitud(){
        ArrayList<Nodo> cola = new ArrayList<>();
        cola.add(raiz);
        int indice = 0;
        while(indice < cola.size()){
            Nodo actual = cola.get(indice);
            System.out.println(actual.valor);
            // Agregar todos los hijos
            cola.addAll(actual.hijos);
            indice++;
        }
    }
    public void recorridoProfundidad() {
        recorridoProfundidadPreorden(raiz);
    }
    private void recorridoProfundidadPreorden(Nodo nodo) {
        System.out.println(nodo.valor);//Visitar el nodo actual
        for (int i = 0; i < nodo.hijos.size(); i++) {//Recursivamente visitar cada hijo
            recorridoProfundidadPreorden(nodo.hijos.get(i));
        }
    }
}
