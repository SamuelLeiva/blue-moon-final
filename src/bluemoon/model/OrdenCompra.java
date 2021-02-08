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
public class OrdenCompra {
    private String IdProducto;
    private String IdOrden;
    private int cantidad;

    public OrdenCompra() {
    }

    public OrdenCompra(String IdProducto, String IdOrden, int cantidad) {
        this.IdProducto = IdProducto;
        this.IdOrden = IdOrden;
        this.cantidad = cantidad;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProductoo(String IdUsuario) {
        this.IdProducto = IdUsuario;
    }

    public String getIdOrden() {
        return IdOrden;
    }

    public void setIdOrden(String IdOrden) {
        this.IdOrden = IdOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
