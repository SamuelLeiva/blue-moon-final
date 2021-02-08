
package bluemoon.dao;

import bluemoon.model.BebidaPedido;
import bluemoon.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class BebidaPedidoDao{
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from DET_BEBIDA_PEDIDO");
        
        try {
            while(res.next()){
                BebidaPedido bebped = new BebidaPedido(res.getInt(1),res.getDouble(2),res.getString(3),res.getString(4));
                Vector v = new Vector();
                v.add(bebped.getCantidad());
                v.add(bebped.getPrecio());
                v.add(bebped.getPedidoId());
                v.add(bebped.getBebidaId());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla PEDIDO BEBIDA.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from DET_BEBIDA_PEDIDO where id_bebida=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                BebidaPedido bebped = new BebidaPedido(res.getInt(1),res.getDouble(2),res.getString(3),res.getString(4));

                v.add(bebped);
            }
        
        return v;
    }
    
    public static void insert(BebidaPedido bebped) {
        
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO DET_BEBIDA_PEDIDO VALUES (?,?,?,?)");

            pst2.setInt(1,bebped.getCantidad());
            pst2.setDouble(2,bebped.getPrecio());
            pst2.setString(3,bebped.getPedidoId());
            pst2.setString(4,bebped.getBebidaId());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Detalle ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en el detalle.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(BebidaPedido bebped) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE DET_BEBIDA_PEDIDO SET CANTIDAD=?,PRECIO=?,ID_PEDIDO=?,ID_BEBIDA=?,"
                    + " WHERE ID_BEBIDA=?");

            pst2.setInt(1,bebped.getCantidad());
            pst2.setDouble(2,bebped.getPrecio());
            pst2.setString(3,bebped.getPedidoId());
            pst2.setString(4,bebped.getBebidaId());
            pst2.setString(5,bebped.getBebidaId());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Detalle actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM DET_BEBIDA_PEDIDO WHERE ID_BEBIDA=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Bebida eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
