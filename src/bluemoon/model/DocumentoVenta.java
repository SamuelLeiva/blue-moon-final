/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;

import java.util.Date;




public class DocumentoVenta {

    String idDocVenta;
    double total;
    Date fecha;
    double subtotal;
    String idPersonal;
    String idCliente;
    double igv;
    String tipoDoc;
    
    public DocumentoVenta(String idDocVenta, double total, Date fecha, double subtotal, String idPersonal, String idCliente, double igv, String tipoDoc) {
        this.idDocVenta = idDocVenta;
        this.total = total;
        this.fecha = fecha;
        this.subtotal= subtotal;
        this.idPersonal = idPersonal;
        this.idCliente = idCliente;
        this.igv = igv;
        this.tipoDoc = tipoDoc;
    }
    
    public DocumentoVenta(){
        
    }
    
    public String getIdDocVenta() {
        return idDocVenta;
    }

    public void setIdDocVenta(String idDocVenta) {
        this.idDocVenta = idDocVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    
    
    
    
}
