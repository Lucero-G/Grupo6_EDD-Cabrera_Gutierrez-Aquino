/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msClases;

/**
 *
 * @author Lucero Gutierrez
 */
public class Nodo {
    private Double dato;
    private Nodo next;

    public Nodo(Double dato) {
        this.dato = dato;
        this.next = null;
    }
    

    public Double getDato() {
        return dato;
    }

    public void setDato(Double dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
}
