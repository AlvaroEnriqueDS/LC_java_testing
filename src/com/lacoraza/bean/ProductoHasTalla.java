package com.lacoraza.bean;

public class ProductoHasTalla {
    int idProducto_has_talla;
    int talla_idtalla;
    int producto_idproducto;
    int stock;

    public int getIdProducto_has_talla() {
        return idProducto_has_talla;
    }

    public void setIdProducto_has_talla(int idProducto_has_talla) {
        this.idProducto_has_talla = idProducto_has_talla;
    }

    public int getTalla_idtalla() {
        return talla_idtalla;
    }

    public void setTalla_idtalla(int talla_idtalla) {
        this.talla_idtalla = talla_idtalla;
    }

    public int getProducto_idproducto() {
        return producto_idproducto;
    }

    public void setProducto_idproducto(int producto_idproducto) {
        this.producto_idproducto = producto_idproducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
