
package bluemoon.model;

public class DetGuiaSalida {
    String productoId;
    String guiaSalidaId;
    int cantidad;

    public DetGuiaSalida() {
    }

    public DetGuiaSalida(String productoId, String guiaSalidaId, int cantidad) {
        this.productoId = productoId;
        this.guiaSalidaId = guiaSalidaId;
        this.cantidad = cantidad;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getGuiaSalidaId() {
        return guiaSalidaId;
    }

    public void setGuiaSalidaId(String guiaSalidaId) {
        this.guiaSalidaId = guiaSalidaId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
