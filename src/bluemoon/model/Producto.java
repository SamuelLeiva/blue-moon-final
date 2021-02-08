/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.model;


public class Producto {
    String idProducto;
    String nombreProducto;
    String unidadMedida;
    String idCategoria;
    double precioUnitario;
    int cantidadProducto;

    public Producto(String idProducto, String nombreProducto, String unidadMedida, String idCategoria, double precioUnitario, int cantidadProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.unidadMedida = unidadMedida;
        this.idCategoria = idCategoria;
        this.precioUnitario = precioUnitario;
        this.cantidadProducto = cantidadProducto;
    }
    
    public Producto(String nombreProducto, String unidadMedida, String idCategoria, double precioUnitario, int cantidadProducto) {
        this.nombreProducto = nombreProducto;
        this.unidadMedida = unidadMedida;
        this.idCategoria = idCategoria;
        this.precioUnitario = precioUnitario;
        this.cantidadProducto = cantidadProducto;
    }

    public Producto(){
        
    }

    
    
    
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    
    
    
    
}
