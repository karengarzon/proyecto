/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.utils;

import modelos.UserSystem;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Producto;
import modelos.Proveedor;

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
    
    /**
     * 
     *  Metodo para coectar a la base de datos
     */
    public static void Conectar(){
    
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/"+dataBase,login,password);
            statement =  connection.createStatement();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * metodo para logear el usuario
     * @param userName
     * @param password
     * @return retorna un booleano 
     */
    public boolean loginUser(String userName, String password) {
        
        boolean existeUsuario = false;
        int rolUser;
        String nombre;
        
        
        try {
            
            //Ejecutar la consulta
            ResultSet r = statement.executeQuery("select * from usuarios where user_name=\""+userName+"\" and password=\""+password+"\" ");
          
            
            while(r.next()){
                if(r.getString("user_name").equals(userName)){
                    existeUsuario=true; 
                    
                    rolUser = r.getInt("rol"); 
                    nombre = r.getString("nombre");
                    
                    UserSystem user = new UserSystem(userName,nombre,rolUser);
                    Persistencia.setUsuario(user);
                    
                }
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return existeUsuario;
    }

    /**
     * metodo para desconectar la conexion a la base de datos
     */
    public void Desconectar() {
        
               
        try {
            statement.close();
        } catch (SQLException ex) {
            try {
                Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
                
                if(!statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        }
    }

    /**
     * Metodo para ingresar un nuevo proveedor
     * @param codigo
     * @param nombre
     * @param direccion
     * @param telefono
     * @return retorna un boolean
     */
    public boolean IngresarProveedor(String codigo, String nombre, String direccion, String telefono) {
        
        
        boolean exito = true;
        
        
        String sql = "INSERT INTO proveedores (codigo, nombre,direccion,telefono) VALUES ('" + codigo+ "','" + nombre + "','" + direccion + "','" + telefono + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            exito = false;
            Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return exito;
        
    }

    /**
     * Metodo para obtener la lista de Proveedores
     * @return retorna un ArrayList
     */
    public ArrayList<Proveedor> getListaProveedores() {
        
        
        
            ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
            String sql = "SELECT * FROM proveedores";
            
        
        try {
            ResultSet resultado = statement.executeQuery(sql);
            while(resultado.next()){
                
                try {
                    Proveedor p = new Proveedor();
                    p.setId(resultado.getInt("id"));
                    p.setCodigo(resultado.getString("codigo"));
                    p.setDireccion(resultado.getString("direccion"));
                    p.setTelefono(resultado.getString("telefono"));
                    p.setNombre(resultado.getString("nombre"));
                    listaProveedores.add(p);
                } catch (SQLException ex) {
                    Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (SQLException ex) {            
            Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaProveedores;
    }

    /**
     * Metodo para ingresar un proudcto 
     * @param p
     * @return retorna un boolean
     */
    public boolean insertarProducto(Producto p) {
        
        
        boolean exito = true;
        
        String sql = "INSERT INTO productos "
                + "(codigo, nombre, descripcion, costo, utilidad_1,utilidad_2,utilidad_3,cod_proveedor,cantidad_almacen,cantidad_minima,tipo_producto,foto_producto) VALUES "
                + "('" + p.getCodigo()+ "','" + p.getNombre() + "','" + p.getDescripcion()+ "','"+ p.getCosto()+ "','" + p.getUtilidad_1()+ "','" + p.getUtilidad_2()+ "','" + p.getUtilidad_3()+ "','" + p.getCod_proveedor()+ "','" + p.getCantidad_almacen()+ "','" + p.getCantidad_minima()+ "','" + p.getTipo_producto()+ "','" + p.getFoto_producto() + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            exito = false;
            Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return exito;
        
        
        
    }

    /**
     * Metodo para obtener la lista de Productos
     * @return retorna un ArrayList
     */
    public ArrayList getListaProductos() {
        
        
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
            String sql = "SELECT * FROM productos";
            
        
        try {
            ResultSet resultado = statement.executeQuery(sql);
            while(resultado.next()){
                
                try {
                    Producto p = new Producto();
                    p.setCodigo(resultado.getString("codigo"));
                    p.setNombre(resultado.getString("nombre"));
                    p.setDescripcion(resultado.getString("descripcion"));
                    p.setCosto(Float.parseFloat(resultado.getString("costo")));
                    p.setUtilidad_1(Float.parseFloat(resultado.getString("utilidad_1")));
                    p.setUtilidad_2(Float.parseFloat(resultado.getString("utilidad_2")));
                    p.setUtilidad_3(Float.parseFloat(resultado.getString("utilidad_3")));
                    p.setCod_proveedor(resultado.getString("cod_proveedor"));
                    p.setCantidad_almacen(Float.parseFloat(resultado.getString("cantidad_almacen")));
                    p.setCantidad_minima(Float.parseFloat(resultado.getString("cantidad_minima")));
                    p.setTipo_producto(Integer.parseInt(resultado.getString("tipo_producto")));
                    p.setFoto_producto(resultado.getString("foto_producto"));
                    listaProductos.add(p);
                } catch (SQLException ex) {
                    Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (SQLException ex) {            
            Logger.getLogger(DataBaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaProductos;
        
        
    }
    
    
    
    
}
