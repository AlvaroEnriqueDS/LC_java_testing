package com.lacoraza.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.lacoraza.sql.Sql_Producto;
import com.lacoraza.bean.*;

@WebServlet(name = "ServletProducto")
public class ServletProducto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //String genero;
        //genero =

        Sql_Producto obj=new Sql_Producto();

        ArrayList<BeanProducto> listaproducto;

        try {

            listaproducto = obj.obtenerProductos();

            if(listaproducto != null) {

                String json = null;
                json = new Gson().toJson(listaproducto);
                response.setContentType("aplication/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }else{
                String json = null;
                String message = "Error en servlet producto";
                json = new Gson().toJson(message);
                response.setContentType("aplication/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }

        }catch (Exception e) {
            System.out.println("HOLA ESTE ERROR ESTA EN ServletProducto "+e);;
        }

    }
}
