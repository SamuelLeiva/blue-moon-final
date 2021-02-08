
package bluemoon.dao;

import bluemoon.model.Cliente;
import bluemoon.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ClienteDao{
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from cliente");
        
        try {
            while(res.next()){
                Cliente beb = new Cliente(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7));
                Vector v = new Vector();
                v.add(beb.getClienteId());
                v.add(beb.getDni());
                v.add(beb.getNombre());
                v.add(beb.getApellido());
                v.add(beb.getTelefono());
                v.add(beb.getRuc());
                v.add(beb.getDireccion());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla BEBIDA.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from cliente where id_cliente=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                Cliente cli = new Cliente(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7));

                v.add(cli);
            }
        
        return v;
    }
    
    public static void insert(Cliente cli) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_CLIENTE;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMCLI-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,cli.getDni());
            pst2.setString(3,cli.getNombre());
            pst2.setString(4,cli.getApellido());
            pst2.setString(5,cli.getTelefono());
            pst2.setString(6,cli.getRuc());
            pst2.setString(7,cli.getDireccion());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente ingresada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Cliente cli) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE CLIENTE SET ID_CLIENTE=?,DNI_CLIENTE=?,NOMBRE_CLIENTE=?,APELLIDOS_CLIENTE=?,"
                    + "TELEFONO_CLIENTE=?, RUC=?, DIRECCION=? WHERE ID_CLIENTE=?");

            pst2.setString(1,cli.getClienteId());
            pst2.setString(2,cli.getDni());
            pst2.setString(3,cli.getNombre());
            pst2.setString(4,cli.getApellido());
            pst2.setString(5,cli.getTelefono());
            pst2.setString(6,cli.getRuc());
            pst2.setString(7,cli.getDireccion());
            pst2.setString(8,cli.getClienteId());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM CLIENTE WHERE ID_CLIENTE=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
