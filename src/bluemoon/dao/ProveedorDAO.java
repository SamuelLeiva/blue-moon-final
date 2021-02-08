/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class ProveedorDAO{
  public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from proveedor");
        
        try {
            while(res.next()){
                Proveedor prod = new Proveedor(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
                Vector v = new Vector();
                v.add(prod.getIdProveedor());
                v.add(prod.getRucProveedor());
                v.add(prod.getNombreProveedor());
                v.add(prod.getDireccionProveedor());
                v.add(prod.getTelefonoProveedor());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tablas.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from proveedor where id_proveedor=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                Proveedor prod = new Proveedor(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));

                v.add(prod);
            }
        
        return v;
    }
    
    public static void insert(Proveedor prod) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_PROVEEDOR;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMPROVE-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO PROVEEDOR VALUES (?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,prod.getRucProveedor());
            pst2.setString(3,prod.getNombreProveedor());
            pst2.setString(4,prod.getDireccionProveedor());
            pst2.setString(5,prod.getTelefonoProveedor());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Proveedor ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Proveedor prod) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE PROVEEDOR SET ID_PROVEEDOR=?,RUC_PROVEEDOR=?,NOMBRE_PROVEEDOR=?,DIRECCION_PROVEEDOR=?,"
                    + "TELEFONO_PROVEEDOR=? WHERE ID_PROVEEDOR=?");

            pst2.setString(1,prod.getIdProveedor());
            pst2.setString(2,prod.getRucProveedor());
            pst2.setString(3,prod.getNombreProveedor());
            pst2.setString(4,prod.getDireccionProveedor());
            pst2.setString(5,prod.getTelefonoProveedor());
            pst2.setString(6,prod.getIdProveedor());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Proveedor actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM PROVEEDOR WHERE ID_PROVEEDOR=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Producto eliminado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}
