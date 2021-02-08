
package bluemoon.model;

public class CategoriaBebida {
    String catBebId;
    String nombre;
    String estado;
    String descripcion;

    public CategoriaBebida() {
    }

    public CategoriaBebida(String catBebId, String nombre, String estado, String descripcion) {
        this.catBebId = catBebId;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public String getCatBebId() {
        return catBebId;
    }

    public void setCatBebId(String catBebId) {
        this.catBebId = catBebId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
