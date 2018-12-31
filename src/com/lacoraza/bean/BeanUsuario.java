package com.lacoraza.bean;

import com.lacoraza.util.Bean;

//AGREGAMOS A LA CLASE EL "extends BeanCliente"
//======================================
public class BeanUsuario extends BeanCliente {

    //DECLARAMOS LAS VARIABLES
    //========================
    String nombre, apellido;

    //GENERAMOS LOS METODOS GET Y SET DE LAS VARIABLES
    //======================================================================================================

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
