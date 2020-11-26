package com.company.workpeace.ClasesAuxiliares.Firebase;

public class UsuariosAux {
    String usuario, nombre, email, clave,genero;
    int edad;
    float estatura,peso;

    public UsuariosAux() {

    }

    public UsuariosAux(String usuario, String nombre, String email, String clave, String genero, int edad, float estatura, float peso) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.genero = genero;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
