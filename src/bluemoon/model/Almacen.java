
package bluemoon.model;


public class Almacen {
    String sedeId;
    String almacenId;
    String nombre;
    
    public Almacen(){
        
    }

    public Almacen(String sedeId, String almacenId, String nombre) {
        this.sedeId = sedeId;
        this.almacenId = almacenId;
        this.nombre = nombre;
    }

    public String getSedeId() {
        return sedeId;
    }

    public void setSedeId(String sedeId) {
        this.sedeId = sedeId;
    }

    public String getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(String almacenId) {
        this.almacenId = almacenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
