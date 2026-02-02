/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msClases;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 *
 * @author Lucero Gutierrez
 */
public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.fechaNacimiento);
        return Objects.hash(nombre, fechaNacimiento);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persona){
            Persona otro = (Persona)obj;
            return Objects.equals(this.fechaNacimiento, otro.fechaNacimiento);
        }
        else return false;
        }

    @Override
    public String toString() {
        return "Persona{" + nombre + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
}
