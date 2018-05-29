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
public class Producto {
    
    private String codigo;
    private String nombre;
    private String descripcion;
    private float costo;
    private float utilidad_1;
    private float utilidad_2;
    private float utilidad_3;
    private String cod_proveedor;
    private float cantidad_almacen;
    private float cantidad_minima;
    private int tipo_producto;
    private String foto_producto;

    public Producto(String codigo, String nombre, String descripcion, float costo, float utilidad_1, float utilidad_2, float utilidad_3, String cod_proveedor, float cantidad_almacen, float cantidad_minima, int tipo_producto, String foto_producto) {
        this.codigo = codigo;
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.utilidad_1 = utilidad_1;
        this.utilidad_2 = utilidad_2;
        this.utilidad_3 = utilidad_3;
        this.cod_proveedor = cod_proveedor;
        this.cantidad_almacen = cantidad_almacen;
        this.cantidad_minima = cantidad_minima;
        this.tipo_producto = tipo_producto;
        this.foto_producto = foto_producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public float getUtilidad_1() {
        return utilidad_1;
    }

    public float getUtilidad_2() {
        return utilidad_2;
    }

    public float getUtilidad_3() {
        return utilidad_3;
    }

    public String getCod_proveedor() {
        return cod_proveedor;
    }

    public float getCantidad_almacen() {
        return cantidad_almacen;
    }

    public float getCantidad_minima() {
        return cantidad_minima;
    }

    public int getTipo_producto() {
        return tipo_producto;
    }

    public String getFoto_producto() {
        return foto_producto;
    }

    public Producto() {
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setUtilidad_1(float utilidad_1) {
        this.utilidad_1 = utilidad_1;
    }

    public void setUtilidad_2(float utilidad_2) {
        this.utilidad_2 = utilidad_2;
    }

    public void setUtilidad_3(float utilidad_3) {
        this.utilidad_3 = utilidad_3;
    }

    public void setCod_proveedor(String cod_proveedor) {
        this.cod_proveedor = cod_proveedor;
    }

    public void setCantidad_almacen(float cantidad_almacen) {
        this.cantidad_almacen = cantidad_almacen;
    }

    public void setCantidad_minima(float cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public void setTipo_producto(int tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public void setFoto_producto(String foto_producto) {
        this.foto_producto = foto_producto;
    }

    public String[] toArray() {
        
        String tipo="Servicio";
        
        if(tipo_producto == 0){
            tipo="Producto fisico";
        }
        
        String [] array = {""+codigo,""+nombre,""+descripcion,""+costo,""+utilidad_1,""+utilidad_2,""+utilidad_3,""+cod_proveedor,""+cantidad_almacen,""+cantidad_minima,tipo,foto_producto};
        
        return array;
    }
    
    
    
    
    
    
    
}
