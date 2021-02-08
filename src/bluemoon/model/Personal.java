/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;


public class Personal {
    String idCargo;
    String idPersonal;
    String dniPersonal;
    String nombrePersonal;
    String apellidoPersonal;
    String telefonoPersonal;
    String emailPersonal;
    String idSede;

    public Personal(String idCargo, String idPersonal, String dniPersonal, String nombrePersonal, String apellidoPersonal, String telefonoPersonal, String emailPersonal, String idSede) {
        this.idCargo = idCargo;
        this.idPersonal = idPersonal;
        this.dniPersonal = dniPersonal;
        this.nombrePersonal = nombrePersonal;
        this.apellidoPersonal = apellidoPersonal;
        this.telefonoPersonal = telefonoPersonal;
        this.emailPersonal = emailPersonal;
        this.idSede = idSede;
    }

    public Personal() {
    }

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getDniPersonal() {
        return dniPersonal;
    }

    public void setDniPersonal(String dniPersonal) {
        this.dniPersonal = dniPersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getApellidoPersonal() {
        return apellidoPersonal;
    }

    public void setApellidoPersonal(String apellidoPersonal) {
        this.apellidoPersonal = apellidoPersonal;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getIdSede() {
        return idSede;
    }

    public void setIdSede(String idSede) {
        this.idSede = idSede;
    }
    
    
    
    
}
