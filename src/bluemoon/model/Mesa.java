/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;


public class Mesa {
    String idMesa;
    int capacidadMesa;

    public Mesa(String idMesa, int capacidadMesa) {
        this.idMesa = idMesa;
        this.capacidadMesa = capacidadMesa;
    }

    public Mesa() {
    }

    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidadMesa() {
        return capacidadMesa;
    }

    public void setCapacidadMesa(int capacidadMesa) {
        this.capacidadMesa = capacidadMesa;
    }
    
    
    
    
}
