
package bluemoon.dao;

import bluemoon.model.Bebida;
import bluemoon.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class BebidaDao{
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from bebida");
        
        try {
            while(res.next()){
                Bebida beb = new Bebida(res.getString(1),res.getString(2),res.getString(3),res.getDouble(4),res.getString(5));
                Vector v = new Vector();
                v.add(beb.getBebidaId());
                v.add(beb.getNombre());
                v.add(beb.getDescripcion());
                v.add(beb.getPrecio());
                v.add(beb.getCategoriaBebId());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla BEBIDA.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from bebida where id_bebida=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                Bebida prod = new Bebida(res.getString(1),res.getString(2),res.getString(3),res.getDouble(4),res.getString(5));

                v.add(prod);
            }
        
        return v;
    }
    
    public static void insert(Bebida beb) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_BEBIDA;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMBEB-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO BEBIDA VALUES (?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,beb.getNombre());
            pst2.setString(3,beb.getDescripcion());
            pst2.setDouble(4,beb.getPrecio());
            pst2.setString(5,beb.getCategoriaBebId());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Bebida ingresada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Bebida beb) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE BEBIDA SET ID_BEBIDA=?,NOMBRE_BEBIDA=?,DESCRIPCION_BEBIDA=?,PRECIO_BEBIDA=?,"
                    + "ID_CATEGORIA_BEBIDA=? WHERE ID_BEBIDA=?");

            pst2.setString(1,beb.getBebidaId());
            pst2.setString(2,beb.getNombre());
            pst2.setString(3,beb.getDescripcion());
            pst2.setDouble(4,beb.getPrecio());
            pst2.setString(5,beb.getCategoriaBebId());
            pst2.setString(6,beb.getBebidaId());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Bebida actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        String sql="DELETE FROM BEBIDA WHERE ID_BEBIDA=?";
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM BEBIDA WHERE ID_BEBIDA=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Bebida eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}
