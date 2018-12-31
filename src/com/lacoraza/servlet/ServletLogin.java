package com.lacoraza.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lacoraza.sql.Sql_Usuario;
import com.lacoraza.bean.BeanUsuario;


public class ServletLogin extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //DECLARAMOS LAS VARIABLES
        //========================
        String log,pas;
        //OBTENEMOS PARAMETROS
        //============================
        log=(String)request.getParameter("txtUsu");
        pas=(String)request.getParameter("txtPas");
        //SE INSTANCIA A LA CLASE Sql_Usuario
        //===================================
        Sql_Usuario obj=new Sql_Usuario();
        //SE LLAMA A LA CLASE BeanUsuario
        //===================================
        BeanUsuario bean;
        //SE CREA LA SESSION
        //==================
        HttpSession misession = request.getSession(true);

        try {
            //VERIFICAMOS SI EXISTE EL USUARIO INVOCANDO AL METODO obtenerUsuario
            //EL CUAL DEBE DE DEVOLVER UN BEAN
            //====================================================================================================
            if(obj.obtenerUsuario(log, pas)!= null) {
                //RECUPERAMOS EL BEAN TRAIDO DEL METODO obtenerUsuario
                //====================================================
                bean = obj.obtenerUsuario(log, pas);
                System.out.println(log+"---"+pas);
                //CREAMOS UN ATRIBUTO DE SESSION "nombres" Y LE DAMOS
                //LOS DATOS DEL NOMBRE, APELLIDO PATERNO Y MATERNO CONCATENADOS
                //=================================================================================================================
                misession.setAttribute("nombres", bean.getNombre()); //+" "+bean.getApePat()+" "+bean.getApeMat());
                misession.setAttribute("apellido", bean.getApellido());
                //misession.setAttribute("correo", bean.getCorreo());
                response.sendRedirect("/index.html");
            }else{
                response.sendRedirect("/out.jsp");
            }
        }catch (Exception e) {
            System.out.println("HOLA ESTE ERROR ESTA EN SERVLETLOGIN "+e);
        }
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
