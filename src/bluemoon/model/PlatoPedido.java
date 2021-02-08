
package bluemoon.model;


public class PlatoPedido {
    int cantidad;
    double precio;
    String pedidoId;
    String platoId;

    public PlatoPedido() {
    }

    public PlatoPedido(int cantidad, double precio, String pedidoId, String platoId) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.pedidoId = pedidoId;
        this.platoId = platoId;
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

    public String getPlatoId() {
        return platoId;
    }

    public void setPlatoId(String platoId) {
        this.platoId = platoId;
    }
    
    
}
