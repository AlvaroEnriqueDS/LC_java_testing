package com.lacoraza.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

//IMPORTAMOS los beans y la conexción
//========================
import com.lacoraza.bean.BeanProducto;
import com.lacoraza.bean.Imagenes;
import com.lacoraza.util.PsqlConexion;

public class Sql_Producto {

    public BeanProducto obtenerProductos() throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        //metodo para conectar a la base de datos
        PsqlConexion conectar = new PsqlConexion();
        //creamoe el objeto del BeanUsuario
        //=================================
        BeanProducto obj = null;
        Imagenes obj_ = null;


        //HACEMOS LA SENTENCIA PARA VERIFICAR EN LA TABLA ACCESO
        //===========================================================
        String sql;
        sql ="select a.idproducto, a.nom_producto, a.descripcion_produ  from producto a";



    }
}