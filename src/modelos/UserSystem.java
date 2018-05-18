/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author julianmartinez
 */
public class UserSystem {
    
    
    private String userName,nombre;
    private int rol;

    public UserSystem(String userName,String nombre, int rol) {
        this.userName = userName;
        this.rol = rol;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "UserSystem{" + "userName=" + userName + ", nombre=" + nombre + ", rol=" + rol + '}';
    }

    public String getUserName() {
        return userName;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRol() {
        return rol;
    }
    
    
    
    
    
}
