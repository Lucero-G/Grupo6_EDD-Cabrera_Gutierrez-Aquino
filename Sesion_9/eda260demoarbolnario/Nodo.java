/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda260demoarbolnario;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucero Gutierrez
 */
public class Nodo {
    String valor;
    List<Nodo> hijos;

    public Nodo(String valor) {
        this.valor = valor;
        this.hijos=new ArrayList<>();
    }
    
    public void agregarHijo(Nodo hijo){
        hijos.add(hijo);
    }
}
