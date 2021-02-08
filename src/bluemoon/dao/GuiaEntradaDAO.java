/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.GuiaEntrada;
import bluemoon.model.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class GuiaEntradaDAO{
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from guia_entrada");
        
        try {
            while(res.next()){
                GuiaEntrada guia = new GuiaEntrada(res.getString(1),res.getDate(2),res.getString(3),res.getString(4),res.getString(5));
                Vector v = new Vector();
                v.add(guia.getIdGuiaEntrada());
                v.add(guia.getFechaGuiaEntrada());
                v.add(guia.getObservacionesGE());
                v.add(guia.getIdProveedor());
                v.add(guia.getIdFacturaCompra());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tablas.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from guia_entrada where id_guia_entrada=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                GuiaEntrada guia = new GuiaEntrada(res.getString(1),res.getDate(2),res.getString(3),res.getString(4),res.getString(5));

                v.add(guia);
            }
        
        return v;
    }
    
    public static void insert(GuiaEntrada guia) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_GUIA_ENTRADA;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMGUIAE-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO GUIA_ENTRADA VALUES (?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setDate(2, (Date) guia.getFechaGuiaEntrada());
            pst2.setString(3,guia.getObservacionesGE());
            pst2.setString(4,guia.getIdProveedor());
            pst2.setString(5,guia.getIdFacturaCompra());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "guia entrada ingresada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(GuiaEntrada guia) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE GUIA_ENTRADA SET ID_GUIA_ENTRADA=?,FECHA=?,OBSERVACIONES=?,ID_PROVEEDOR=?,"
                    + "ID_FACTURA_COMPRA=? WHERE ID_GUIA_ENTRADA=?");

            pst2.setString(1,guia.getIdGuiaEntrada());
            pst2.setDate(2, (Date) guia.getFechaGuiaEntrada());
            pst2.setString(3,guia.getObservacionesGE());
            pst2.setString(4,guia.getIdProveedor());
            pst2.setString(5,guia.getIdFacturaCompra());
            pst2.setString(6,guia.getIdGuiaEntrada());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Guia de entrada actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM GUIA_ENTRADA WHERE ID_GUIA_ENTRADA=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Guia de entrada eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}
    
    
