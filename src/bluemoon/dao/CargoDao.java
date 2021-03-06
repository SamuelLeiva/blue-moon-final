
package bluemoon.dao;

import bluemoon.model.Cargo;
import bluemoon.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class CargoDao{
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from cargo");
        
        try {
            while(res.next()){
                Cargo cargo = new Cargo(res.getString(1),res.getString(2),res.getString(3));
                Vector v = new Vector();
                v.add(cargo.getCargoId());
                v.add(cargo.getNombre());
                v.add(cargo.getDescripcion());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tablas.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from cargo where id_cargo=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                Cargo cargo = new Cargo(res.getString(1),res.getString(2),res.getString(3));

                v.add(cargo);
            }
        
        return v;
    }
    
    /*public static void insert(Cargo cargo) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_CARGO;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMPROD-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO PRODUCTO VALUES (?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,prod.getNombreProducto());
            pst2.setString(3,prod.getUnidadMedida());
            pst2.setString(4,prod.getIdCategoria());
            pst2.setDouble(5,prod.getPrecioUnitario());
            pst2.setInt(6,prod.getCantidadProducto());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Producto ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }*/

    public static void update(Cargo cargo) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE PRODUCTO SET ID_CARGO=?,NOMBRE_CARGO=?,DESCRIPCION_CARGO=?,ID_CATEGORIA=?"
                    + " WHERE ID_CARGO=?");

            pst2.setString(1,cargo.getCargoId());
            pst2.setString(2,cargo.getNombre());
            pst2.setString(3,cargo.getDescripcion());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cargo actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de cargo.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM CARGO WHERE ID_CARGO=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cargo eliminado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de cargo.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
