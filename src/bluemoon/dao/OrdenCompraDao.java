/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.OrdenCompra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class OrdenCompraDao {
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from ORDEN_COMPRA");
        
        try {
            while(res.next()){
                OrdenCompra prod = new OrdenCompra(res.getString(1),res.getString(2),res.getInt(3));
                Vector v = new Vector();
                v.add(prod.getIdProducto());
                v.add(prod.getIdOrden());
                v.add(prod.getCantidad());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tablas.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from orden_compra where id_orden=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                OrdenCompra prod = new OrdenCompra(res.getString(1),res.getString(2),res.getInt(3));

                v.add(prod);
            }
        
        return v;
    }
    
    public static void insert(OrdenCompra prod) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_ORDEN;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMORDEN-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO ORDEN_COMPRA VALUES (?,?,?)");

            pst2.setString(1,prod.getIdProducto());
            pst2.setString(2,myId);
            pst2.setInt(3,prod.getCantidad());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(OrdenCompra prod) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE ORDEN_COMPRA SET ID_PRODUCTO=?,ID_ORDEN=?,CANTIDAD=?"
                    + "WHERE ID_ORDEN=?");

            pst2.setString(1,prod.getIdProducto());
            pst2.setString(2,prod.getIdOrden());
            pst2.setInt(3,prod.getCantidad());
            pst2.setString(4,prod.getIdOrden());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Orden actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM ORDEN_COMPRA WHERE ID_ORDEN=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "ORDEN eliminado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}
