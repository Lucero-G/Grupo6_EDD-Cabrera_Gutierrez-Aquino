/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msClases;

/**
 *
 * @author Lucero Gutierrez
 */
public class LESCircular {
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
    //retornar el nodo anterior a un indice dado
    private Nodo nodoAnterior(int index){
        if (index == 0) return tail;
        Nodo actual = head;
        for(int i=0;i<index-1;i++) actual=actual.next;
        return actual;
    }
    public void insertarFinal(Persona x){
        Nodo nuevo = new Nodo(x);
        if (head ==null) {head=nuevo; tail = nuevo; nuevo.next = nuevo;}
        else{
            nuevo.next= head;
            tail.next=nuevo;
            tail=nuevo;
        }
        size++;
    }
    //TAREA, INSERTAR CON TAIL
    public boolean insertaXposicion(Persona x, int indice){
        validarIndiceInsercion(indice);
        if(indice == 0) {insertarInicio(x); return true;}
        if(indice == size) {insertarFinal(x); return true;}
        Nodo nuevo = new Nodo(x);
        Nodo anterior = nodoAnterior(indice);
        nuevo.next=anterior.next;
        anterior.next=nuevo;
        size++;
        return true;
    }
    public void insertarInicio(Persona x){
        Nodo nuevo = new Nodo(x);
        if (head ==null) {head=nuevo; tail = nuevo; nuevo.next = nuevo;}
        else{
            nuevo.next=head;
            tail.next = nuevo;
            head=nuevo;
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
            Nodo anterior = nodoAnterior(0); // tail
            head = head.next;
            anterior.next = head;
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
            Nodo anterior = nodoAnterior(this.getSize() - 1);
            anterior.next = head;
            tail = anterior;
        }
        size--;
    }
    public void eliminarPosicion(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Indice inválido: " + pos); return;}
        if(head == null) {System.out.println("Lista ya estaba vacía");}
        if(pos == 0) {eliminarInicio();return;}
        if(pos == this.getSize()-1) {eliminarFinal();return;}
        Nodo anterior = nodoAnterior(pos);
        anterior.next = anterior.next.next;
        size--;
    }


    public Nodo getHead() {
        return head;
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
