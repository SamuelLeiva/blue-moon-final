/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;


public class PedidoCompra {
    String idPedCompra;
    String idProveedor;
    String idProducto;
    double precioPedCompra;
    int cantidad;

    public PedidoCompra(String idPedCompra, String idProveedor, String idProducto, double precioPedCompra, int cantidad) {
        this.idPedCompra = idPedCompra;
        this.idProveedor = idProveedor;
        this.idProducto = idProducto;
        this.precioPedCompra = precioPedCompra;
        this.cantidad = cantidad;
    }

    public PedidoCompra() {
    
    }

    public String getIdPedCompra() {
        return idPedCompra;
    }

    public void setIdPedCompra(String idPedCompra) {
        this.idPedCompra = idPedCompra;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioPedCompra() {
        return precioPedCompra;
    }

    public void setPrecioPedCompra(double precioPedCompra) {
        this.precioPedCompra = precioPedCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
    
}
