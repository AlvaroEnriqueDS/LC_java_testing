package com.lacoraza.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.lacoraza.sql.Sql_Usuario;
import com.lacoraza.bean.BeanUsuario;

@WebServlet(name = "ServletRegister")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //DECLARAMOS LAS VARIABLES
        //========================
        String nombres, apellidos, correo, contrasena, repetirContrasena;
        //OBTENEMOS PARAMETROS
        //============================
        JsonObject data = new Gson().fromJson(request.getReader(),JsonObject.class);

        nombres = data.get("nombres").getAsString();
        apellidos = data.get("apellidos").getAsString();
        correo=data.get("correo").getAsString();
        contrasena =data.get("contrasena").getAsString();
        repetirContrasena =data.get("repetirContrasena").getAsString();

        //SOUT DE VERIFICACION DE PASE DE DATOS
        System.out.println(correo+"- ServletRegister-"+contrasena);

        //SE INSTANCIA A LA CLASE Sql_Usuario
        //===================================
        Sql_Usuario obj=new Sql_Usuario();
        //SE LLAMA A LA CLASE BeanUsuario
        //===================================
        BeanUsuario bean;

        try {
            //INSERTAMOS EL NEUVO USUARIO INVOCANDO AL METODO REUsuario
            //EL CUAL DEBE DE DEVOLVER UN BEAN
            //====================================================================================================

            int fk = obj.registrarCliente(correo, contrasena);
            obj.registrarPersona(nombre, apellidos, fk);
            bean = obj.registrarUsuario(nombres, apellidos, correo, contrasena);

            if(bean != null) {
                //RECUPERAMOS EL BEAN TRAIDO DEL METODO registrarUsuario
                //====================================================
                System.out.println(bean.getNombre()+"- ServletRegister_BEAN -"+bean.getApellido());

                String json = null;
                json = new Gson().toJson(bean);
                response.setContentType("aplication/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }else{
                String json = null;
                BeanUsuario bean2=new BeanUsuario();
                json = new Gson().toJson(bean2);
                response.setContentType("aplication/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }

        }catch (Exception e) {
            System.out.println("HOLA ESTE ERROR ESTA EN ServletRegister "+e);;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
