package com.lacoraza.sql;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

//IMPORTAMOS EL BeanUsuario y la conexción
//========================
import com.lacoraza.bean.BeanUsuario;
import com.lacoraza.util.PsqlConexion;

public class Sql_Usuario {

    public BeanUsuario obtenerUsuario(String log, String pas) throws Exception{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        //metodo para conectar a la base de datos
        PsqlConexion conectar = new PsqlConexion();
        //creamoe el objeto del BeanUsuario
        //=================================
        BeanUsuario obj = null;

        //HACEMOS LA SENTENCIA PARA INSERTAR DATOS EN LA TABLA ACCESO
        //===========================================================
        String sql;
        sql ="select p.nombre, p.apellido from cliente c INNER JOIN persona p ON c.idcliente=p.cliente_idcliente WHERE c.correoelectronico='"+log+"' AND c.contraseÑa='"+pas+"';";
        try {
            con  = conectar.conectar();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery(); //REVISAR EL CODIGO
            if(rs.next()){
                //INSTANCIAMOS EL BeanUsuario
                //===========================
                obj = new BeanUsuario();

                //LLENAMOS EL BeanUsuario
                //=======================
                obj.setNombre(rs.getString(1));
                obj.setApellido(rs.getString(2));
            }
            System.out.println("hola "+log+" contra "+pas);
            System.out.printf(obj.getNombre()+"- - - -"+obj.getApellido());
            conectar.cerrar(con, stm, rs);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //RETORNAMOS EL OBJETO CON LOS DATOS LLENOS
        return obj;
    }


}
