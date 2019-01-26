/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacoraza.util;

import com.lacoraza.sql.Sql_Usuario;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

/**
 *
 * @author Alvaro
 */

public class PsqlConexion {

    public Connection conectar(){
        Connection conexion = null;
        String url = "jdbc:postgresql://www.lacoraza.com:5432/lacoraza";
        Properties propiedades  = new Properties();
        propiedades.setProperty("user", "lcadmin");
        propiedades.setProperty("password", "vueyjava");
        
        try {
            Class.forName("org.postgresql.Driver");
            conexion = (Connection) DriverManager.getConnection(url, propiedades);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conexion;
    }
    
    public static void cerrar(java.sql.Connection c, PreparedStatement p, ResultSet r) {
        try {
            if (r != null) {
                r.close();
            }
            if (p != null) {
                p.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException sqle) {
            
        }
    }
    public static void main(String[] args) throws Exception {
        PsqlConexion cn = new PsqlConexion();
        cn.conectar();
        Sql_Usuario cx = new Sql_Usuario();
        cx.obtenerUsuario("alvaro@lc.com", "1234");

    }

}
