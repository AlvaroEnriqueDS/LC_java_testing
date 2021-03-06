package com.lacoraza.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;

import com.lacoraza.bean.BeanCliente;
import com.lacoraza.sql.Sql_Usuario;


public class ServletLogin extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //DECLARAMOS LAS VARIABLES
        //========================
        String log,pas;
        //OBTENEMOS PARAMETROS
        //============================
        JsonObject data = new Gson().fromJson(request.getReader(),JsonObject.class);

        log=data.get("correo").getAsString();
        pas=data.get("contrasena").getAsString();
        //SOUT DE VERIFICACION DE PASE DE DATOS
        System.out.println(log+"- SERVLETLOGIN -"+pas);
        //SE INSTANCIA A LA CLASE Sql_Usuario
        //===================================
        Sql_Usuario obj=new Sql_Usuario();
        //SE LLAMA A LA CLASE BeanUsuario
        //===================================
        BeanCliente bean;
        //SE CREA LA SESSION
        //==================
        //HttpSession misession = request.getSession(true);



        try {
            //VERIFICAMOS SI EXISTE EL USUARIO INVOCANDO AL METODO obtenerUsuario
            //EL CUAL DEBE DE DEVOLVER UN BEAN
            //====================================================================================================
            bean = obj.obtenerUsuario(log, pas);
            if(bean != null) {
                //RECUPERAMOS EL BEAN TRAIDO DEL METODO obtenerUsuario
                //====================================================
                System.out.println(bean.getNombre()+"- SERVLETLOGIN_BEAN -"+bean.getApellido());
                //CREAMOS UN ATRIBUTO DE SESSION "nombres" Y LE DAMOS
                //LOS DATOS DEL NOMBRE, APELLIDO PATERNO Y MATERNO CONCATENADOS
                //=================================================================================================================
                //misession.setAttribute("nombres", bean.getNombre()); //+" "+bean.getApePat()+" "+bean.getApeMat());
                //misession.setAttribute("apellido", bean.getApellido());
                //misession.setAttribute("correo", bean.getCorreo());
                String json = null;
                json = new Gson().toJson(bean);
                response.setContentType("aplication/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);

            }else{
                String json = null;
                String mensaje = "hubo un error";
                json = new Gson().toJson(mensaje);
                response.setContentType("aplication/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }
        }catch (Exception e) {
            System.out.println("HOLA ESTE ERROR ESTA EN SERVLETLOGIN "+e);
        }
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
