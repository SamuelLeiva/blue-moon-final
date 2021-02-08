/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.DocumentoVenta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class DocumentoVentaDAO{
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from cliente");
        
        try {
            while(res.next()){
                DocumentoVenta doc = new DocumentoVenta(res.getString(1),res.getDouble(2),res.getDate(3),res.getDouble(4),res.getString(5),res.getString(6),res.getDouble(7),res.getString(8));
                Vector v = new Vector();
                v.add(doc.getIdDocVenta());
                v.add(doc.getTotal());
                v.add(doc.getFecha());
                v.add(doc.getSubtotal());
                v.add(doc.getIdPersonal());
                v.add(doc.getIdCliente());
                v.add(doc.getIgv());
                v.add(doc.getTipoDoc());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla DOCUMENTO VENTA.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from documento_venta where id_documento_venta=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                DocumentoVenta doc = new DocumentoVenta(res.getString(1),res.getDouble(2),res.getDate(3),res.getDouble(4),res.getString(5),res.getString(6),res.getDouble(7),res.getString(8));

                v.add(doc);
            }
        
        return v;
    }
    
    public static void insert(DocumentoVenta doc) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM seq_documento_venta;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMDOCV-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO DOCUMENTO_VENTA VALUES (?,?,?,?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setDouble(2,doc.getTotal());
            pst2.setDate(3, (Date) doc.getFecha());
            pst2.setDouble(4,doc.getSubtotal());
            pst2.setString(5,doc.getIdPersonal());
            pst2.setString(6,doc.getIdCliente());
            pst2.setDouble(7,doc.getIgv());
            pst2.setString(8,doc.getTipoDoc());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Documento ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(DocumentoVenta doc) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE DOCUMENTO_VENTA SET ID_DOCUMENTO_VENTA=?,TOTAL=?,FECHA=?,SUBTOTAL=?,"
                    + "ID_PERSONAL=?, ID_CLIENTE=?, IGV=?, TIPO_DOCUMENTO=? WHERE ID_DOCUMENTO_VENTA=?");

            pst2.setString(1,doc.getIdDocVenta());
            pst2.setDouble(2,doc.getTotal());
            pst2.setDate(3, (Date) doc.getFecha());
            pst2.setDouble(4,doc.getSubtotal());
            pst2.setString(5,doc.getIdPersonal());
            pst2.setString(6,doc.getIdCliente());
            pst2.setDouble(7,doc.getIgv());
            pst2.setString(8,doc.getTipoDoc());
            pst2.setString(9,doc.getIdDocVenta());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM DOCUMENTO_VENTA WHERE ID_DOCUMENTO_VENTA=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
