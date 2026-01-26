/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msClases;

/**
 *
 * @author Lucero Gutierrez
 */
public class ListaEnlazada {
    private Nodo head=null, tail=null;
    private int size=0;
    
    public void insertarFinal(Double x){
        Nodo nuevo = new Nodo(x);
        if (head ==null) head=tail=nuevo;
        else{
            Nodo actual = head;
            while(actual.getNext()!=null) actual=actual.getNext();
            actual.setNext(nuevo);
            tail = nuevo;
        }
        size++;
    }
    //TAREA, INSERTAR CON TAIL
    public void insertarFinalTail(Double x){
        Nodo nuevo = new Nodo(x);
        if (head ==null) head=tail=nuevo;
        else{
            tail.setNext(nuevo);
            tail = nuevo;
        }
        size++;
    }
    
    public boolean insertaXposicion(Double x, int pos){
        if(pos < 0 || pos > size) return false;
        if(pos == 0) {insertarInicio(x); return true;}
        if(pos == size) {insertarFinal(x); return true;}
        Nodo nuevo = new Nodo(x);
        int posactual = 0;
        Nodo actual = head;
        while (posactual<pos-1){
            actual = actual.getNext();
            posactual++;
        }
        nuevo.setNext(actual.getNext());
        actual.setNext(nuevo);
        size++;
        return true;
    }
    public void insertarInicio(Double x){
        Nodo nuevo = new Nodo(x);
        if (head !=null) nuevo.setNext(head);
        head=nuevo;
        size++;
    }
    //METODOS PARA ELIMINAR
    public void eliminarInicio(){
        if (head == null) {
            System.out.println("La lista ya estaba vacía");
            return;
        }
        if (head == tail) {   // solo un nodo
            head = tail = null;
            System.out.println("Lista vacía");
        } else {
            head = head.getNext();
        }
        size--;
    }
    public void eliminarFinalTail(){
        if (head == null) {
            System.out.println("La lista ya estaba vacía");
            return;
        }
        if (head == tail) {
            head = tail = null;
            System.out.println("Lista vacía");
        } else {
            Nodo actual = head;
            while(actual.getNext() != tail){
                actual = actual.getNext();
            }
            actual.setNext(null);
            tail = actual;
        }
        size--;
    }
    public void eliminarXposicion(int pos){
        if(pos < 0 || pos > size) return;
        if(pos == 0) {eliminarInicio(); return;}
        if(pos == size) {eliminarFinalTail(); return;}
        int posactual = 0;
        Nodo actual = head;
        while (posactual<pos-1){
            actual = actual.getNext();
            posactual++;
        }
        actual.setNext(actual.getNext().getNext());
        size--;
    }

    //METODOS DE BUSQUEDA
    public void buscarValor(Double x){
        Nodo actual = head;
        while(actual != null){
            if(actual.getDato().equals(x)){
                System.out.println("Se encontró el valor");
            }
            actual = actual.getNext();
        }
        System.out.println("No se encontró el valor");
    }
    public void buscarPosicion(int pos){
        if(pos < 0 || pos >= size){
            System.out.println("Posición inválida");
            return;
        }
        Nodo actual = head;
        for(int i = 0; i < pos; i++){
            actual = actual.getNext();
        }
        System.out.println("Se encontró en la posición a: "+actual.getDato());
    }

    //METODO DE ORDENAMIENTO
    public void ordenarBurbuja(){
        if(head == null) return;
        boolean cambio;
        do{
            cambio = false;
            Nodo actual = head;
            while(actual.getNext() != null){
                if(actual.getDato() > actual.getNext().getDato()){
                    Double temp = actual.getDato();
                    actual.setDato(actual.getNext().getDato());
                    actual.getNext().setDato(temp);
                    cambio = true;
                }
                actual = actual.getNext();
            }
        }while(cambio);
    }


    public void mostrar(){
        Nodo actual = head;
        while(actual != null){
            System.out.print(actual.getDato()+" ");
            actual = actual.getNext();
        }
        System.out.println();
    }

    public Nodo getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }
    
}
