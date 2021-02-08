
package bluemoon.model;


public class DetFacturaCompra {
    int cantidad;
    double precio;
    String productoId;
    String facturaId;

    public DetFacturaCompra() {
    }

    public DetFacturaCompra(int cantidad, double precio, String productoId, String facturaId) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.productoId = productoId;
        this.facturaId = facturaId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }
    
    
}
