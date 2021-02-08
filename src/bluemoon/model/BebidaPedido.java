
package bluemoon.model;


public class BebidaPedido {
    int cantidad;
    double precio;
    String pedidoId;
    String bebidaId;

    public BebidaPedido() {
    }

    public BebidaPedido(int cantidad, double precio, String pedidoId, String bebidaId) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.pedidoId = pedidoId;
        this.bebidaId = bebidaId;
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

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getBebidaId() {
        return bebidaId;
    }

    public void setBebidaId(String bebidaId) {
        this.bebidaId = bebidaId;
    }
    
    
}
