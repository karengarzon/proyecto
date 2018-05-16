/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author julianmartinez
 */
public class Utils {

    
    /**
     * Metodo para comprobar si un string esta Vacio,
     * True si tiene datos
     * False si esta vacio
     * @param string variable a comprobar
     * @return 
     */
    public static boolean checkString(String string) {
        return !string.isEmpty();
    }

    /**
     * Metodo para mostrar un mensaje Diaolog,
     * Recibe el 
     * @param parentComponent el JPanel o JFrame, puede ser null
     * @param mensaje mensaje del Dialog
     * @param titulo titulo del Dialog
     * @param type tipo del mensaje 
     */
    public static void showDialog(Component parentComponent,String mensaje,String titulo,int type) {
        JOptionPane.showMessageDialog(parentComponent, mensaje, titulo, type);
    }
    
    
    
    
}
