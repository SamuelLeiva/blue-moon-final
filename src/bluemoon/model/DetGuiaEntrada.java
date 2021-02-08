
package bluemoon.model;


public class DetGuiaEntrada {
    int cantidad;
    String productoId;
    String guiaEntradaId;

    public DetGuiaEntrada() {
    }

    public DetGuiaEntrada(int cantidad, String productoId, String guiaEntradaId) {
        this.cantidad = cantidad;
        this.productoId = productoId;
        this.guiaEntradaId = guiaEntradaId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getGuiaEntradaId() {
        return guiaEntradaId;
    }

    public void setGuiaEntradaId(String guiaEntradaId) {
        this.guiaEntradaId = guiaEntradaId;
    }
    
    
}
