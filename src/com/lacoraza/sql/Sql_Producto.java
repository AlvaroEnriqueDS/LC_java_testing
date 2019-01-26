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
        ProductoHasTalla obj_pht = null;
        Imagenes obj_imag = null;


        //HACEMOS LA SENTENCIA PARA VERIFICAR EN LA TABLA ACCESO
        //===========================================================
        String sql;
        sql ="select a.idproducto, a.nom_producto, a.descripcion_produ, b.genero, c.categoria, e.talla, d.stock, f.ruta  from producto a \n" +
                "inner join genero b on a.genero_idgenero = b.idgenero \n" +
                "inner join categoria c on a.categoria_idcategoria = c.idcategoria \n" +
                "inner join producto_has_talla d on a.idproducto = d.producto_idproducto \n" +
                "inner join talla e on d.talla_idtalla = e.idtalla \n" +
                "inner join imagenes f on a.idproducto = f.producto_idproducto;";

        ArrayList<BeanProducto> listaproducto = new ArrayList();

        try {
            con  = conectar.conectar();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery(); //REVISAR EL CODIGO
            System.out.println(rs);

            while (rs.next()) {
                obj =new BeanProducto();
                obj_cat = new Categoria();
                obj_gen = new Genero();
                obj_tal = new Talla();
                obj_pht = new ProductoHasTalla();
                obj_imag =new Imagenes();

                obj.setIdProducto(rs.getInt(1));
                obj.setNomProdu(rs.getString(2));
                obj.setDescripcionProdu(rs.getString(3));
                obj_gen.setGenero(rs.getString(4));
                obj_cat.setCategoria(rs.getString(5));
                obj_tal.setTalla(rs.getString(6));
                obj_pht.setStock(rs.getInt(7));
                obj_imag.setRuta(rs.getString(8));

                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
                System.out.println(rs.getInt(7));
                System.out.println(rs.getString(8));

                obj.setCategoria(obj_cat);
                obj.setGenero(obj_gen);
                obj.setTalla(obj_tal);
                obj.setStock(obj_pht);
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