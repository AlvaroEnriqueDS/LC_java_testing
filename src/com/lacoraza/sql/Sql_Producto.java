package com.lacoraza.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

//IMPORTAMOS los beans y la conexción
//========================
import com.lacoraza.bean.*;
import com.lacoraza.util.PsqlConexion;

public class Sql_Producto {

    public ArrayList<BeanProducto> obtenerProductos() throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        //metodo para conectar a la base de datos
        PsqlConexion conectar = new PsqlConexion();
        //creamoe el objeto del BeanUsuario
        //=================================
        BeanProducto obj = null;
        Categoria obj_cat = null;
        Genero obj_gen  = null;
        Talla obj_tal = null;
        Imagenes obj_imag = null;


        //HACEMOS LA SENTENCIA PARA VERIFICAR EN LA TABLA ACCESO
        //===========================================================
        String sql;
        sql ="select a.idproducto, a.nom_producto, a.descripcion_produ, b.descripcion, c.genero, d.talla, e.ruta  from producto a \n" +
                "inner join categoria b on a.categoria_idcategoria = b.idcategoria \n" +
                "inner join genero c on a.genero_idgenero = c.idgenero \n" +
                "inner join talla d on a.talla_idtalla = d.idtalla\n" +
                "inner join imagenes e on a.idproducto = e.producto_idproducto;";

        ArrayList<BeanProducto> listaproducto = new ArrayList();

        try {
            con  = conectar.conectar();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery(); //REVISAR EL CODIGO

            while (rs.next()) {
                obj =new BeanProducto();
                obj_cat = new Categoria();
                obj_tal = new Talla();
                obj_imag =new Imagenes();

                obj.setIdProducto(rs.getInt(1));
                obj.setNomProdu(rs.getString(2));
                obj.setDescripcionProdu(rs.getString(3));
                obj_cat.setDescripcion(rs.getString(4));
                obj_gen.setGenero(rs.getString(5));
                obj_tal.setTalla(rs.getString(6));
                obj_imag.setRuta(rs.getString(7));

                obj.setCategoria(obj_cat);
                obj.setGenero(obj_gen);
                obj.setTalla(obj_tal);
                obj.setTalla(obj_tal);
                obj.setImagenes(obj_imag);

                listaproducto.add(obj);
            }



            conectar.cerrar(con, stm, rs);
            //probar
            //System.out.println(obj.getNombre()+"- SQL_USUARIO -"+obj.getApellido());

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ESTE EROR ESTA EN EN EL SQL_PRODUCTO EN OBETENERPRODUCTOS(): " +ex);
        }

        return listaproducto;

    }
}