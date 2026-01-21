/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demomatrizdinamica;

/**
 *
 * @author HP
 */

public class DemoMatrizDinamica {
    public static void main(String[] args) {
        // 1. Inicializamos una matriz de 2x2
        MatrizDinamica m = new MatrizDinamica(2, 2);
        m.setDato(0, 0, "A"); m.setDato(0, 1, "B");
        m.setDato(1, 0, "C"); m.setDato(1, 1, "D");
        
        System.out.println("ESTADO INICIAL (2x2):");
        m.recorrerPorFilas();

        // 2. INSERTAR FILA (en medio, índice 1)
        // Necesitamos 2 elementos porque hay 2 columnas
        String[] nuevaFila = {"X", "Y"}; 
        m.insertarFila(1, nuevaFila);
        
        System.out.println("\nDESPUES DE INSERTAR FILA en pos 1:");
        m.recorrerPorFilas(); 

        // 3. INSERTAR COLUMNA (al final, índice 2)
        // Necesitamos 3 elementos porque ahora hay 3 filas
        String[] nuevaColumna = {"1", "2", "3"};
        m.insertarColumna(2, nuevaColumna);

        System.out.println("\nDESPUES DE INSERTAR COLUMNA en pos 2:");
        m.recorrerPorFilas();

        // 4. BUSCAR VALOR
        int[] coords = m.buscarValor("Y");
        System.out.println("\nBuscando 'Y': Fila " + coords[0] + ", Columna " + coords[1]);

        // 5. RECORRIDO POR COLUMNAS
        System.out.println();
        m.recorrerPorColumnas();

        // 6. ELIMINAR FILA (La fila 0 -> A, B, 1)
        m.eliminarFila(0);
        System.out.println("\nDESPUES DE ELIMINAR FILA 0:");
        m.recorrerPorFilas();

        // 7. ELIMINAR COLUMNA (La columna del medio -> índice 1)
        m.eliminarColumna(1);
        System.out.println("\nDESPUES DE ELIMINAR COLUMNA 1:");
        m.recorrerPorFilas();
    }
}