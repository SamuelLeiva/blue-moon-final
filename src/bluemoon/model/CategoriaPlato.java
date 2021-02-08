
package bluemoon.model;


public class CategoriaPlato {
    String catPlatId;
    String nombre;
    String descripcion;
    String estado;

    public CategoriaPlato() {
    }

    public CategoriaPlato(String catPlatId, String nombre, String descripcion, String estado) {
        this.catPlatId = catPlatId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getCatPlatId() {
        return catPlatId;
    }

    public void setCatPlatId(String catPlatId) {
        this.catPlatId = catPlatId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
