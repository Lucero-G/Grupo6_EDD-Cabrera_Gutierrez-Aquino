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
    Persona dato;
    Nodo next;
    Nodo prev;

    public Nodo(Persona p) {
        this.dato = p;
        this.next = null;
        this.prev = null;
    }
    
    
}
