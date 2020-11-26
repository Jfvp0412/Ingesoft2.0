package com.company.workpeace.ClasesAuxiliares.Firebase;

import com.company.workpeace.ClasesPrincipales.MyDoes;

public class MyDoesAux {

    String titulo, descripcion, fecha;
    String keydoes;
    String usuario;
    String hora;
    public MyDoesAux(){

    }



    public MyDoesAux(String titulo, String descripcion, String fecha, String keydoes,String usuario,String hora) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.keydoes = keydoes;
        this.usuario = usuario;
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getKeydoes() {
        return keydoes;
    }

    public void setKeydoes(String keydoes) {
        this.keydoes = keydoes;
    }
}
