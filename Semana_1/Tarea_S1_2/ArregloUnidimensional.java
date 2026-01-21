/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demoarreglosuni01;

/**
 *
 * @author HP
 */
public class ArregloUnidimensional {
    private String[] elementos;
    private int tamano;
    private static final int CAPACIDAD_MAXIMA=10;
   /**
    * Constructor que inicializa un arreglo vacio
    */
    public ArregloUnidimensional() {
        this.elementos=new String[CAPACIDAD_MAXIMA];
        this.tamano=0;
    }
    /**
     * inserta un nombre en una posición específica
     * @param indice posición donde insertar (0<=indice<=tamano)
     * @param nombre nombre propio a insertar(ej. "Hugo", "Paco", ..)
     * @throws IndexOutOfBoundsException si el índice no es válido
     * @throws IllegalStateException si el arreglo está lleno
     */
    public void insertar(int indice, String nombre){
        if(tamano==CAPACIDAD_MAXIMA)
            throw new IllegalStateException("Arreglo Lleno");
        if(indice<0||indice>tamano)
            throw new IndexOutOfBoundsException("indice fuera de rango: "+indice);
        if(nombre==null||nombre.trim().isEmpty()) return;
        for(int i=tamano;i>indice;i--)
            elementos[i]=elementos[i-1];
        elementos[indice]=nombre.trim();
        tamano++;
    }
    /**
     * elimina un nombre en una posición específica
     * @param indice posición del elemento a eliminar (0<=indice<tamano)
     * @throws IndexOutOfBoundsException si el índice no es válido
     * @return nombre eliminado
     */
    public String eliminar(int indice){
        if(indice<0||indice>tamano)
            throw new IndexOutOfBoundsException("indice fuera de rango: "+indice);
        String nombreEliminado=elementos[indice];
        for(int i=indice;i<tamano-1;i++) elementos[i]=elementos[i+1];
        elementos[tamano-1]=null;
        tamano--;
        return nombreEliminado;
    }
    /**
     * obtiene el nombre de una posicion dada
     * @param indice posición del elemento (0<=indice<tamano)
     * @return nombre almacenado
     * @throws IndexOutOfBoundsException si el índice no es válido
     */
    public String obtener(int indice){
        if(indice<0||indice>tamano)
            throw new IndexOutOfBoundsException("indice fuera de rango: "+indice);
        return elementos[indice];
    }
    /**
     * devuelve el número actUal de elementos
     * @return tamaño lógico  (0 a 10)
     */
    public int getTamano() {
        return tamano;
    }
    /**
     * Verifica si el el arreglo está lleno
     * @return true si alcanzó la capacidad máxima (10)
     */
    public boolean estaLleno(){
        return tamano==CAPACIDAD_MAXIMA;
    }
    /**
     * imprime el estado actual del arreglo
     * muestra solo los elementos reales (hasta "tamaño")
     */
    public void imprimir(){
        if(tamano==0){
            System.out.println("[] (arreglo vacio");
            return;
        }
        System.out.print("[");
         for(int i=0;i<tamano;i++) {
             System.out.print(elementos[i]);
             if (i<tamano-1) System.out.print(", ");
         }
         System.out.println("]");
    } 
    /**
     * 1. BUSQUEDA POR VALOR (Búsqueda Lineal)
     * Recorre todo el arreglo buscando el nombre.
     * @return índice del elemento o -1 si no existe.
     */
    public int buscar(String nombre) {
        if (nombre == null) return -1;
        String busqueda = nombre.trim();
        for (int i = 0; i < tamano; i++) {
            if (elementos[i].equals(busqueda)) {
                return i; // Encontrado
            }
        }
        return -1; // No encontrado
    }

    /**
     * 2. ORDENAMIENTO (Burbuja)
     * Ordena el arreglo alfabéticamente (A-Z).
     * Usa compareTo
     */
    public void ordenar() {
        if (tamano < 2) return; // No hace falta ordenar
        for (int i = 0; i < tamano - 1; i++) {
            for (int j = 0; j < tamano - i - 1; j++) {
                // Si el actual es alfabéticamente mayor que el siguiente, intercambiar
                if (elementos[j].compareTo(elementos[j + 1]) > 0) {
                    String temp = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 3. BUSQUEDA BINARIA
     * Requisito: El arreglo debe estar ordenado previamente.
     * Divide el arreglo en mitades para buscar más rápido.
     * @return índice del elemento o -1 si no existe.
     */
    public int busquedaBinaria(String nombre) {
        if (nombre == null) return -1;
        String busqueda = nombre.trim();
        int inicio = 0;
        int fin = tamano - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = busqueda.compareTo(elementos[medio]);
            if (comparacion == 0) {
                return medio; // Encontrado en el medio
            } else if (comparacion < 0) {
                fin = medio - 1; // Buscar en la mitad izquierda
            } else {
                inicio = medio + 1; // Buscar en la mitad derecha
            }
        }
        return -1;
    }

    /**
     * 4. INSERCION EN ORDEN
     * Inserta un elemento manteniendo el orden alfabético.
     * Asume que el arreglo ya está ordenado.
     */
    public void insertarOrdenado(String nombre) {
        if (tamano == CAPACIDAD_MAXIMA) 
            throw new IllegalStateException("Arreglo Lleno");
        if (nombre == null) return;
        String nuevoNombre = nombre.trim();
        // Empezamos desde el final y movemos a la derecha los que sean "mayores" que el nuevo
        int i = tamano - 1;
        while (i >= 0 && elementos[i].compareTo(nuevoNombre) > 0) {
            elementos[i + 1] = elementos[i];
            i--;
        }
        // Insertamos en el hueco que quedó
        elementos[i + 1] = nuevoNombre;
        tamano++;
    }
    
    /**
     * 5. INVERSION DEL ARREGLO
     * Invierte el orden de los elementos (el último pasa a ser el primero).
     */
    public void invertir() {
        for (int i = 0; i < tamano / 2; i++) {
            String temp = elementos[i];
            int indiceContrario = tamano - 1 - i;
            elementos[i] = elementos[indiceContrario];
            elementos[indiceContrario] = temp;
        }
    }
}
