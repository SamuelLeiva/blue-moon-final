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
public class DetInventario {
    int cantidad;
    String almacenId;
    String productoId;

    public DetInventario() {
    }

    public DetInventario(int cantidad, String almacenId, String productoId) {
        this.cantidad = cantidad;
        this.almacenId = almacenId;
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(String almacenId) {
        this.almacenId = almacenId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }
    
    
}
