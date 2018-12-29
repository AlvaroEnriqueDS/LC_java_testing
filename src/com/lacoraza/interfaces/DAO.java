/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacoraza.interfaces;

import java.util.List;

/**
 *
 * @author Alvaro
 */
public interface DAO<K, O>{
    
    public void insertar(O o);
    public void modificar(O o);
    public void eliminar(O o);
    public void obtenerPorId(K k);
    public List<O> listar();
    
    
    
}
