
package bluemoon.model;


public class Bebida {
    String bebidaId;
    String nombre;
    String descripcion;
    double precio;
    String categoriaBebId;
    
    public Bebida(){
        
    }

    public Bebida(String bebidaId, String nombre, String descripcion, double precio, String categoriaBebId) {
        this.bebidaId = bebidaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoriaBebId = categoriaBebId;
    }

    public String getBebidaId() {
        return bebidaId;
    }

    public void setBebidaId(String bebidaId) {
        this.bebidaId = bebidaId;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoriaBebId() {
        return categoriaBebId;
    }

    public void setCategoriaBebId(String categoriaBebId) {
        this.categoriaBebId = categoriaBebId;
    }
    
    
}
