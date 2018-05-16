/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julianmartinez
 */
public class DataBaseHelper {

    
    
    private static String dataBase = "Proyecto";    
    private static String login = "root"; 
    private static String password = "root"; 
    
    public static java.sql.Connection connection;
    
    public static Statement statement;
    
    public static void Conectar(){
    
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/"+dataBase,login,password);
            statement =  connection.createStatement();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean loginUser(String userName, String password) {
        
        boolean existeUsuario = false;
        int rolUser;
        
        try {
            
            ResultSet r = statement.executeQuery("select * from usuarios where user_name=\""+userName+"\" and password=\""+password+"\" ");
            
            while(r.next()){
                existeUsuario=true; 
                rolUser = r.getInt("rol"); 
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return false;
    }
    
    
    
    
}
