/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;


public class Plato {
    String idPlato;
    String idCategoriaPlato;
    String nombrePlato;
    double precioPlato;
    String descripcionPlato;

    public Plato(String idPlato, String idCategoriaPlato, String nombrePlato, double precioPlato, String descripcionPlato) {
        this.idPlato = idPlato;
        this.idCategoriaPlato = idCategoriaPlato;
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.descripcionPlato = descripcionPlato;
    }
    
    public Plato(){
        
    }

    public String getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(String idPlato) {
        this.idPlato = idPlato;
    }

    public String getIdCategoriaPlato() {
        return idCategoriaPlato;
    }

    public void setIdCategoriaPlato(String idCategoriaPlato) {
        this.idCategoriaPlato = idCategoriaPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }
    
    
}
