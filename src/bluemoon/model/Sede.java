/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;


public class Sede {

    String idRestaurante;
    String idSede;
    String nombreSede;
    String direccionSede;
    int telefonoSede;
    String emailSede;
    
    public Sede(String idRestaurante, String idSede, String nombreSede, String direccionSede, int telefonoSede, String emailSede) {
        this.idRestaurante = idRestaurante;
        this.idSede = idSede;
        this.nombreSede = nombreSede;
        this.direccionSede = direccionSede;
        this.telefonoSede = telefonoSede;
        this.emailSede = emailSede;
    }

    public Sede(){
        
    }
    
    public String getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(String idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getIdSede() {
        return idSede;
    }

    public void setIdSede(String idSede) {
        this.idSede = idSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public void setDireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }

    public int getTelefonoSede() {
        return telefonoSede;
    }

    public void setTelefonoSede(int telefonoSede) {
        this.telefonoSede = telefonoSede;
    }

    public String getEmailSede() {
        return emailSede;
    }

    public void setEmailSede(String emailSede) {
        this.emailSede = emailSede;
    }
    
    
}
