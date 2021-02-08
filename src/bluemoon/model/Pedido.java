/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;

import java.util.Date;


public class Pedido {
    String idPersonal;
    String idPedido;
    String idMesa;
    double totalPedido;
    Date fechaPedido;
    String estadoPedido;
    String idCliente;

    public Pedido(String idPersonal, String idPedido, String idMesa, double totalPedido, Date fechaPedido, String estadoPedido,String idCliente) {
        this.idPersonal = idPersonal;
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.totalPedido = totalPedido;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.idCliente = idCliente;
    }

    public Pedido() {
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    
    
    
    
    
}
