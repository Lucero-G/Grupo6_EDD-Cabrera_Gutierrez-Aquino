/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demomatrizdinamica;

/**
 *
 * @author HP
 */

public class MatrizDinamica {
    private String[][] matriz;
    private int filas;
    private int columnas;

    public MatrizDinamica(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new String[filas][columnas];
    }

    // 1. INSERTAR FILA EN POSICIÓN DADA
    // =========================================================
    public void insertarFila(int indice, String[] nuevosDatos) {
        if (indice < 0 || indice > filas) 
            throw new IndexOutOfBoundsException("Índice de fila inválido");
        if (nuevosDatos.length != columnas && filas > 0) 
            throw new IllegalArgumentException("La nueva fila debe tener " + columnas + " columnas.");

        // Reconstrucción: Nueva matriz con 1 fila más
        String[][] nuevaMatriz = new String[filas + 1][columnas];

        for (int i = 0; i < filas + 1; i++) {
            if (i < indice) {
                nuevaMatriz[i] = matriz[i]; // Copiar filas anteriores
            } else if (i == indice) {
                nuevaMatriz[i] = nuevosDatos; // Insertar la nueva fila
            } else {
                nuevaMatriz[i] = matriz[i - 1]; // Desplazar filas siguientes
            }
        }
        
        this.matriz = nuevaMatriz;
        this.filas++;
    }

    // 2. INSERTAR COLUMNA EN POSICIÓN DADA
    // =========================================================
    public void insertarColumna(int indice, String[] nuevosDatos) {
        if (indice < 0 || indice > columnas) 
            throw new IndexOutOfBoundsException("Índice de columna inválido");
        if (nuevosDatos.length != filas && columnas > 0)
            throw new IllegalArgumentException("La nueva columna debe tener " + filas + " elementos.");

        // Reconstrucción: Nueva matriz con 1 columna más
        String[][] nuevaMatriz = new String[filas][columnas + 1];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas + 1; j++) {
                if (j < indice) {
                    nuevaMatriz[i][j] = matriz[i][j]; // Copiar izquierda
                } else if (j == indice) {
                    nuevaMatriz[i][j] = nuevosDatos[i]; // Insertar dato nuevo
                } else {
                    nuevaMatriz[i][j] = matriz[i][j - 1]; // Desplazar derecha
                }
            }
        }

        this.matriz = nuevaMatriz;
        this.columnas++;
    }
    
    // 3. ELIMINAR FILA POR ÍNDICE
    // =========================================================
    public void eliminarFila(int indice) {
        if (indice < 0 || indice >= filas) 
            throw new IndexOutOfBoundsException("Índice fuera de rango");

        String[][] nuevaMatriz = new String[filas - 1][columnas];

        for (int i = 0; i < filas - 1; i++) {
            if (i < indice) {
                nuevaMatriz[i] = matriz[i];
            } else {
                nuevaMatriz[i] = matriz[i + 1]; // Saltamos la fila eliminada
            }
        }

        this.matriz = nuevaMatriz;
        this.filas--;
    }

    // 4. ELIMINAR COLUMNA POR ÍNDICE
    // =========================================================
    public void eliminarColumna(int indice) {
        if (indice < 0 || indice >= columnas) 
            throw new IndexOutOfBoundsException("Índice fuera de rango");

        String[][] nuevaMatriz = new String[filas][columnas - 1];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas - 1; j++) {
                if (j < indice) {
                    nuevaMatriz[i][j] = matriz[i][j];
                } else {
                    nuevaMatriz[i][j] = matriz[i][j + 1]; // Saltamos la columna eliminada
                }
            }
        }

        this.matriz = nuevaMatriz;
        this.columnas--;
    }

    // 5. BUSQUEDA (Valor y por Índice)
    // =========================================================
    
    /**
     * Busca coordenadas de un valor
     * @return int[] {fila, columna} o {-1, -1} si no existe
     */
    public int[] buscarValor(String valor) {
        if (valor == null) return new int[]{-1, -1};
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != null && matriz[i][j].equals(valor)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public String obtenerPorIndice(int f, int c) {
        if (f < 0 || f >= filas || c < 0 || c >= columnas)
            throw new IndexOutOfBoundsException("Coordenadas inválidas");
        return matriz[f][c];
    }

    // 6. RECORRIDOS
    // =========================================================
    
    public void recorrerPorFilas() {
        System.out.println("--- Recorrido por Filas ---");
        for (int i = 0; i < filas; i++) {
            System.out.print("Fila " + i + ": [ ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + (j < columnas - 1 ? ", " : ""));
            }
            System.out.println(" ]");
        }
    }

    public void recorrerPorColumnas() {
        System.out.println("--- Recorrido por Columnas ---");
        for (int j = 0; j < columnas; j++) {
            System.out.print("Columna " + j + ": [ ");
            for (int i = 0; i < filas; i++) {
                System.out.print(matriz[i][j] + (i < filas - 1 ? ", " : ""));
            }
            System.out.println(" ]");
        }
    }
    
    // Método auxiliar para llenar datos iniciales
    public void setDato(int f, int c, String valor) {
        matriz[f][c] = valor;
    }
}