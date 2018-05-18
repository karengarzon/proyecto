/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.utils;

import modelos.UserSystem;

/**
 *
 * @author julianmartinez
 */
public class Persistencia {
    
    public static UserSystem usuario;

    public static UserSystem getUsuario() {
        return usuario;
    }

    public static void setUsuario(UserSystem usuario) {
        Persistencia.usuario = usuario;
    }
    
    
    
}
