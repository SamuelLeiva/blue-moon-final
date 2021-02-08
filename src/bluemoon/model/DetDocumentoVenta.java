
package bluemoon.model;


public class DetDocumentoVenta {
    String documentoId;
    String platoId;
    double precio;
    int cantidad;

    public DetDocumentoVenta() {
    }

    public DetDocumentoVenta(String documentoId, String platoId, double precio, int cantidad) {
        this.documentoId = documentoId;
        this.platoId = platoId;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getPlatoId() {
        return platoId;
    }

    public void setPlatoId(String platoId) {
        this.platoId = platoId;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
