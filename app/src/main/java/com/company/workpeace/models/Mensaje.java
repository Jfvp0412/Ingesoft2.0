package com.company.workpeace.models;

public class Mensaje {
    String NombreRutina,fecha,duracion;
    public Mensaje(){}
    public Mensaje(String NombreRutina,String fecha,String duracion)
    {
        this.NombreRutina = NombreRutina;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNombreRutina() {
        return NombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        NombreRutina = nombreRutina;
    }
}