package com.company.workpeace.ClasesAuxiliares.Firebase;

public class RutinasAux {

    String duracion, nombre;

    public RutinasAux() {
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RutinasAux(String duracion, String nombre) {
        this.duracion = duracion;
        this.nombre = nombre;
    }
}
