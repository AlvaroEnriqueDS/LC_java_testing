package com.lacoraza.bean;
import com.lacoraza.util.Bean;

public class BeanCliente extends Bean{
    //DECLARAMOS LAS VARIABLES
    //========================
    String correo, clave;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
