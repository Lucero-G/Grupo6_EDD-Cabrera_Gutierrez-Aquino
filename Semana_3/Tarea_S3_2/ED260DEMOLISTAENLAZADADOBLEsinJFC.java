/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package msClases;

import msClases.LEDCircular;
import java.time.LocalDate;

/**
 *
 * @author Lucero Gutierrez
 */
public class ED260DEMOLISTAENLAZADADOBLEsinJFC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LEDCircular lista = new LEDCircular();
        lista.insertarInicio(new Persona("Javier", LocalDate.of(1969,5,24)));
        lista.insertarFinal(new Persona("Hugo", LocalDate.of(1969,1,1)));
        lista.insertarFinal(new Persona("Paco", LocalDate.of(1969,2,1)));
        lista.insertarFinal(new Persona("Luis", LocalDate.of(1969,3,3)));
        System.out.println(lista);
        System.out.println("\n Insertamos posicion 2");
        lista.insertaXposicion(new Persona("Maria", LocalDate.of(1222,2,22)), 2);
        System.out.println(lista);
        
        System.out.println("\n Eliminamos al inicio");
        lista.eliminarInicio();
        System.out.println(lista);
        System.out.println("\n Eliminamos al último");
        lista.eliminarFinal();
        System.out.println(lista);
        System.out.println("\n Eliminamos a la posición 1");
        lista.eliminarPosicion(1);
        System.out.println(lista);
        System.out.println("\n Eliminamos a la posición 4");
        lista.eliminarPosicion(4);
        System.out.println("\n Eliminamos al inicio");
        lista.eliminarInicio();
        System.out.println(lista);
        System.out.println("\n Eliminamos al inicio");
        lista.eliminarInicio();
        System.out.println(lista);
    }
    
}
