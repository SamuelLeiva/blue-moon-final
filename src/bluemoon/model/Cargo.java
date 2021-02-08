/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Cargo {
    String cargoId;
    String nombre;
    String descripcion;
    

    public Cargo() {
    }

    public Cargo(String cargoId, String nombre, String descripcion) {
        this.cargoId = cargoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        
    }

    public String getCargoId() {
        return cargoId;
    }

    public void setCargoId(String cargoId) {
        this.cargoId = cargoId;
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
