package com.example.a07_ejemplosharedpreferencesgson;

public class ContactoMatricula {

    private String nombre;
    private String ciclo;
    private String mail;
    private String telefono;
    
    //La libreria GSON puede tomar un objeto y transformarlo a un json

    public ContactoMatricula() {
    }

    public ContactoMatricula(String nombre, String ciclo, String mail, String telefono) {
        this.nombre = nombre;
        this.ciclo = ciclo;
        this.mail = mail;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
