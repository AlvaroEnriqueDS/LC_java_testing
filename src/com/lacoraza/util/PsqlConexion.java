/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacoraza.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Alvaro
 */
public class PsqlConexion {
    
    public Connection conectar(){
        Connection conexion = null;
        String url = "jdbc:postgresql://localhost/LACORAZA";
        Properties propiedades  = new Properties();
        propiedades.setProperty("user", "postgres");
        propiedades.setProperty("password", "asd020");
        
        try {
            conexion = (Connection) DriverManager.getConnection(url, propiedades);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
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
    public static void main(String[] args) {
        PsqlConexion cn = new PsqlConexion();
        cn.conectar();
    }
    
    
    
    
    
}
