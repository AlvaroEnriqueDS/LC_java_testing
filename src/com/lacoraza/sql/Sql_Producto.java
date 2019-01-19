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
        sql ="select a.idproducto, a.nom_producto, a.descripcion_produ, b.descripcion, c.genero, d.talla, e.ruta  from producto a \n" +
                "inner join categoria b on a.categoria_idcategoria = b.idcategoria \n" +
                "inner join genero c on a.genero_idgenero = c.idgenero \n" +
                "inner join talla d on a.talla_idtalla = d.idtalla\n" +
                "inner join imagenes e on a.idproducto = e.producto_idproducto;";
        try {
            con  = conectar.conectar();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery(); //REVISAR EL CODIGO
            if(rs.next()){
                //INSTANCIAMOS EL BeanUsuario
                //===========================
                obj = new BeanProducto();

                //LLENAMOS EL BeanUsuario
                //=======================
                obj.setNombre(rs.getString(1));
                obj.setApellido(rs.getString(2));
                obj.setCorreo(rs.getString(3));
            }
            conectar.cerrar(con, stm, rs);
            //probar
            System.out.println(obj.getNombre()+"- SQL_USUARIO -"+obj.getApellido());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return obj;

    }
}