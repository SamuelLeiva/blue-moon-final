/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;

import java.util.Date;


public class FacturaCompra {
    String idProveedor;
    String idFacturaCompra;
    Date fechaFactCompra;
    double igv;
    double subtotalFactCompra;
    double totalFactCompra;
    String obsFacturaCompra;

    public FacturaCompra(String idProveedor, String idFacturaCompra, Date fechaFactCompra, double igv, double subtotalFactCompra, double totalFactCompra, String obsFacturaCompra) {
        this.idProveedor = idProveedor;
        this.idFacturaCompra = idFacturaCompra;
        this.fechaFactCompra = fechaFactCompra;
        this.igv = igv;
        this.subtotalFactCompra = subtotalFactCompra;
        this.totalFactCompra = totalFactCompra;
        this.obsFacturaCompra = obsFacturaCompra;
    }

    public FacturaCompra() {
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(String idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public Date getFechaFactCompra() {
        return fechaFactCompra;
    }

    public void setFechaFactCompra(Date fechaFactCompra) {
        this.fechaFactCompra = fechaFactCompra;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getSubtotalFactCompra() {
        return subtotalFactCompra;
    }

    public void setSubtotalFactCompra(double subtotalFactCompra) {
        this.subtotalFactCompra = subtotalFactCompra;
    }

    public double getTotalFactCompra() {
        return totalFactCompra;
    }

    public void setTotalFactCompra(double totalFactCompra) {
        this.totalFactCompra = totalFactCompra;
    }

    public String getObsFacturaCompra() {
        return obsFacturaCompra;
    }

    public void setObsFacturaCompra(String obsFacturaCompra) {
        this.obsFacturaCompra = obsFacturaCompra;
    }
    
    
    
    
    
}
