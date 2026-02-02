/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msClases;

/**
 *
 * @author Lucero Gutierrez
 */
public class LEDCircular {
    private Nodo head=null, tail=null;
    private int size=0;
    
    public boolean isEmpty(){
        return size==0;
    }
    public int getSize() {
        return size;
    }
    private void validarIndiceInsercion(int indice){
        if(indice<0||indice>this.getSize())
            throw new IndexOutOfBoundsException("Indice INVALIDO "+indice);
    }
    private void validarIndiceAcceso(int indice) {
        if (indice < 0 || indice >= this.getSize())
            throw new IndexOutOfBoundsException("Indice INVALIDO " + indice);
    }
    //retornar el nodo anterior a un indice dado
    private Nodo obtenerNodo(int index){
        validarIndiceAcceso(index);
        Nodo actual;
        // Si el indice esta en la primera mitad, recorrer desde head
        if (index < size / 2) {
            actual = head;
            for (int i = 0; i < index; i++) {
                actual = actual.next;
            }
        } else {
            // Si esta en la segunda mitad, recorrer desde tail hacia atras
            actual = tail;
            for (int i = size - 1; i > index; i--) {
                actual = actual.prev;
            }
        }
        return actual;
    }
    public void insertarFinal(Persona x){
        Nodo nuevo = new Nodo(x);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
            nuevo.next = nuevo;
            nuevo.prev = nuevo;
        } else {
            nuevo.prev = tail;
            nuevo.next = head;
            tail.next = nuevo;
            head.prev = nuevo;
            tail = nuevo;
        }
        size++;
    }
    public boolean insertaXposicion(Persona x, int indice){
        validarIndiceInsercion(indice);
        if(indice == 0) {insertarInicio(x); return true;}
        if(indice == size) {insertarFinal(x); return true;}
        Nodo nuevo = new Nodo(x);
        Nodo actual = obtenerNodo(indice);
        Nodo anterior = actual.prev;        
        nuevo.next = actual;
        nuevo.prev = anterior;
        anterior.next = nuevo;
        actual.prev = nuevo;
        size++;
        return true;
    }
    public void insertarInicio(Persona x){
        Nodo nuevo = new Nodo(x);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
            nuevo.next = nuevo;
            nuevo.prev = nuevo;
        } else {
            nuevo.next = head;
            nuevo.prev = tail;
            head.prev = nuevo;
            tail.next = nuevo;
            head = nuevo;
        }
        size++;
    }
    public void eliminarInicio() {
        if (head == null) {
            System.out.println("Lista ya estaba vacía");
            return;
        }
        if (this.getSize() == 1) {
            head = tail = null;
        } else {
            Nodo nuevoHead = head.next;
            nuevoHead.prev = tail;
            tail.next = nuevoHead;
            head = nuevoHead;
        }
        size--;
    }
    public void eliminarFinal() {
        if (head == null) {
            System.out.println("Lista ya estaba vacía");
            return;
        }
        if (this.getSize() == 1) {
            head = tail = null;
        } else {
            Nodo nuevoTail = tail.prev;
            nuevoTail.next = head;
            head.prev = nuevoTail;
            tail = nuevoTail;
        }
        size--;
    }
    public void eliminarPosicion(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Indice inválido: " + pos); return;}
        if(head == null) {System.out.println("Lista ya estaba vacía");return;}
        if(pos == 0) {eliminarInicio();return;}
        if(pos == this.getSize()-1) {eliminarFinal();return;}
        Nodo aEliminar = obtenerNodo(pos);
        Nodo anterior = aEliminar.prev;
        Nodo siguiente = aEliminar.next;
        anterior.next = siguiente;
        siguiente.prev = anterior;
        size--;
    }


    public Nodo getHead() {
        return head;
    }
    public Nodo getTail() {
        return tail;
    }
    
    @Override
    public String toString(){
        if(this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        Nodo actual = head;
        for(int i=0;i<this.getSize(); i++){
            sb.append(actual.dato.toString());
            if(i<this.getSize()-1) sb.append("\n->");
            actual=actual.next;
        }
        sb.append("");
        return sb.toString();
    }
}
