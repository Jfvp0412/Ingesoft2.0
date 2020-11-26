package com.company.workpeace.ClasesAuxiliares.Firebase;

public class MiRutinaAux {

    String nombre, series, repeticiones, descripcion;
    String usuario;
    String keydoes;
    int numero;

    public MiRutinaAux(){

    }

    public MiRutinaAux(String nombre, String series, String repeticiones, String descripcion,String usuario,String keydoes,int numero) {
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticiones;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.keydoes = keydoes;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getKeydoes() {
        return keydoes;
    }

    public void setKeydoes(String keydoes) {
        this.keydoes = keydoes;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}