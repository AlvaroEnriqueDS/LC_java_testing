package com.lacoraza.sql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

//IMPORTAMOS EL BeanUsuario y la conexción
//========================
import com.lacoraza.bean.BeanCliente;
import com.lacoraza.util.PsqlConexion;

public class Sql_Usuario {

    public BeanCliente obtenerUsuario(String log, String pas) throws Exception{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        //metodo para conectar a la base de datos
        PsqlConexion conectar = new PsqlConexion();
        //creamoe el objeto del BeanUsuario
        //=================================
        BeanCliente obj = null;

        //HACEMOS LA SENTENCIA PARA VERIFICAR EN LA TABLA ACCESO
        //===========================================================
        String sql;
        sql = "select c.nombre, c.apellido, c.correoelectronico from cliente c WHERE c.correoelectronico=? AND c.contrasena=?;";
        try {
            con  = conectar.conectar();
            stm = con.prepareStatement(sql);
            stm.setString(1, log);
            stm.setString(2, pas);
            rs = stm.executeQuery(); //REVISAR EL CODIGO
            if(rs.next()){
                //INSTANCIAMOS EL BeanUsuario
                //===========================
                obj = new BeanCliente();

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

        //RETORNAMOS EL OBJETO CON LOS DATOS LLENOS
        return obj;
    }

    public void registrarCliente(String correo, String contraseña, String nombre, String apellido){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        //metodo para conectar a la base de datos
        PsqlConexion conectar = new PsqlConexion();

        //HACEMOS LA SENTENCIA PARA INSERTAR DATOS EN LA TABLA ACCESO
        //===========================================================
        String sql;
        sql = "insert into cliente (correoelectronico, nombre, apellido, contrasena) values (?,?,?,?);";

        int idcliente = -1;
        try {
            con  = conectar.conectar();
            stm = con.prepareStatement(sql);
            stm.setString(1, correo);
            stm.setString(2, nombre);
            stm.setString(3, apellido);
            stm.setString(4, contraseña);
            rs = stm.executeQuery(); //REVISAR EL CODIGO


            conectar.cerrar(con, stm, rs);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void registrarPersona (String nombre, String apellido, int fk){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        //metodo para conectar a la base de datos
        PsqlConexion conectar = new PsqlConexion();

        //HACEMOS LA SENTENCIA PARA INSERTAR DATOS EN LA TABLA ACCESO
        //===========================================================
        String sql;
        sql="insert into persona (nombre, apellido, cliente_idcliente) values ('"+nombre+"', '"+apellido+"', "+fk+");";

        try {
            con  = conectar.conectar();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery(); //REVISAR EL CODIGO


            conectar.cerrar(con, stm, rs);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
