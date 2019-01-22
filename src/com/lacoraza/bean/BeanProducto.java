/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacoraza.bean;

/**
 *
 * @author Alvaro
 */
public class BeanProducto {
    int idProducto;
    String nomProdu;
    String descripcionProdu;
    Categoria categoria;
    Genero genero;
    Talla talla;
    Imagenes imagenes;



    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProdu() {
        return nomProdu;
    }

    public void setNomProdu(String nomProdu) {
        this.nomProdu = nomProdu;
    }

    public String getDescripcionProdu() {
        return descripcionProdu;
    }

    public void setDescripcionProdu(String descripcionProdu) {
        this.descripcionProdu = descripcionProdu;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Imagenes getImagenes() {
        return imagenes;
    }

    public void setImagenes(Imagenes imagenes) {
        this.imagenes = imagenes;
    }
}
