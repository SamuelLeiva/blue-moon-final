/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;

import java.util.Date;


public class GuiaEntrada {
    String idGuiaEntrada;
    Date fechaGuiaEntrada;
    String observacionesGE;
    String idProveedor;
    String idFacturaCompra;

    public GuiaEntrada(String idGuiaEntrada, Date fechaGuiaEntrada, String observacionesGE, String idProveedor, String idFacturaCompra) {
        this.idGuiaEntrada = idGuiaEntrada;
        this.fechaGuiaEntrada = fechaGuiaEntrada;
        this.observacionesGE = observacionesGE;
        this.idProveedor = idProveedor;
        this.idFacturaCompra = idFacturaCompra;
    }

    public GuiaEntrada() {
    }

    public String getIdGuiaEntrada() {
        return idGuiaEntrada;
    }

    public void setIdGuiaEntrada(String idGuiaEntrada) {
        this.idGuiaEntrada = idGuiaEntrada;
    }

    public Date getFechaGuiaEntrada() {
        return fechaGuiaEntrada;
    }

    public void setFechaGuiaEntrada(Date fechaGuiaEntrada) {
        this.fechaGuiaEntrada = fechaGuiaEntrada;
    }

    public String getObservacionesGE() {
        return observacionesGE;
    }

    public void setObservacionesGE(String observacionesGE) {
        this.observacionesGE = observacionesGE;
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
    
    
    
    
    
    
}
