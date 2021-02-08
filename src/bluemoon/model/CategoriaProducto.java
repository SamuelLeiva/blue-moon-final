/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;

/**
 *
 * @author LENOVO
 */
public class CategoriaProducto {
    String catProId;
    String nombre;
    String descripcion;

    public CategoriaProducto() {
    }

    public CategoriaProducto(String catProId, String nombre, String descripcion) {
        this.catProId = catProId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCatProId() {
        return catProId;
    }

    public void setCatProId(String catProId) {
        this.catProId = catProId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
