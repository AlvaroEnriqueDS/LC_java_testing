/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacoraza.excepciones;

/**
 *
 * @author Alvaro
 */
public class Excepcion_General extends RuntimeException{
    
    public Excepcion_General(String msg){
        super(msg);
    }
    
    public Excepcion_General(){
        this("Hubo un error y está sin un mensaje");
    }
}
