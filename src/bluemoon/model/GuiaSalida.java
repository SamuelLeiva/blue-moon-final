/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;

import java.util.Date;


public class GuiaSalida {
    String idGuiaSalida;
    Date fechaGuiaSalida;
    String observaciones;

    public GuiaSalida(String idGuiaSalida, Date fechaGuiaSalida, String observaciones) {
        this.idGuiaSalida = idGuiaSalida;
        this.fechaGuiaSalida = fechaGuiaSalida;
        this.observaciones = observaciones;
    }

    public GuiaSalida() {
    }

    public String getIdGuiaSalida() {
        return idGuiaSalida;
    }

    public void setIdGuiaSalida(String idGuiaSalida) {
        this.idGuiaSalida = idGuiaSalida;
    }

    public Date getFechaGuiaSalida() {
        return fechaGuiaSalida;
    }

    public void setFechaGuiaSalida(Date fechaGuiaSalida) {
        this.fechaGuiaSalida = fechaGuiaSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    
}
