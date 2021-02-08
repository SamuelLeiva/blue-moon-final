/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.FacturaCompra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class FacturaCompraDAO{

    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from factura_compra");
        
        try {
            while(res.next()){
                FacturaCompra doc = new FacturaCompra(res.getString(1),res.getString(2),res.getDate(3),res.getDouble(4),res.getDouble(5),res.getDouble(6),res.getString(7));
                Vector v = new Vector();
                v.add(doc.getIdProveedor());
                v.add(doc.getIdFacturaCompra());
                v.add(doc.getFechaFactCompra());
                v.add(doc.getIgv());
                v.add(doc.getSubtotalFactCompra());
                v.add(doc.getTotalFactCompra());
                v.add(doc.getObsFacturaCompra());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla DOCUMENTO VENTA.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from factura_compra where id_factura_compra=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                FacturaCompra doc = new FacturaCompra(res.getString(1),res.getString(2),res.getDate(3),res.getDouble(4),res.getDouble(5),res.getDouble(6),res.getString(7));

                v.add(doc);
            }
        
        return v;
    }
    
    public static void insert(FacturaCompra doc) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM seq_factura_compra;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMFAC-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO factura_compra VALUES (?,?,?,?,?,?,?)");

            pst2.setString(1,doc.getIdProveedor());
            pst2.setString(2,myId);
            pst2.setDate(3, (Date) doc.getFechaFactCompra());
            pst2.setDouble(4,doc.getIgv());
            pst2.setDouble(5,doc.getSubtotalFactCompra());
            pst2.setDouble(6,doc.getTotalFactCompra());
            pst2.setString(7,doc.getObsFacturaCompra());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Documento ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(FacturaCompra doc) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE FACTURA_COMPRA SET ID_PROVEEDOR=?,ID_FACTURA_COMPRA=?,FECHA=?,IGV=?,"
                    + "SUBTOTAL=?, TOTAL_FACTURA=?, OBSERVACIONES=? WHERE ID_FACTURA_COMPRA=?");

            pst2.setString(1,doc.getIdProveedor());
            pst2.setString(2,doc.getIdFacturaCompra());
            pst2.setDate(3, (Date) doc.getFechaFactCompra());
            pst2.setDouble(4,doc.getIgv());
            pst2.setDouble(5,doc.getSubtotalFactCompra());
            pst2.setDouble(6,doc.getTotalFactCompra());
            pst2.setString(7,doc.getObsFacturaCompra());
            pst2.setString(8,doc.getIdFacturaCompra());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM FACTURA_COMPRA WHERE ID_FACTURA_COMPRA=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "FACTURA_COMPRA eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
