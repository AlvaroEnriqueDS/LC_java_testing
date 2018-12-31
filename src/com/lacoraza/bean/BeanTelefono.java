package com.lacoraza.bean;

public class BeanTelefono extends BeanCliente {
    //DECLARAMOS LAS VARIABLES
    //========================
    String numero, descripcion;


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
