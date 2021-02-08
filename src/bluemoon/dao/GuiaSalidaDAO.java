/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.GuiaEntrada;
import bluemoon.model.GuiaSalida;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class GuiaSalidaDAO{
    
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from guia_salida");
        
        try {
            while(res.next()){
                GuiaSalida guia = new GuiaSalida(res.getString(1),res.getDate(2),res.getString(3));
                Vector v = new Vector();
                v.add(guia.getIdGuiaSalida());
                v.add(guia.getFechaGuiaSalida());
                v.add(guia.getObservaciones());
                
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tablas.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from guia_salida where id_guia_salida=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                GuiaSalida guia = new GuiaSalida(res.getString(1), res.getDate(2), res.getString(3));

                v.add(guia);
            }
        
        return v;
    }
    
    public static void insert(GuiaSalida guia) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_GUIA_SALIDA;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMGUIAS-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO GUIA_SALIDA VALUES (?,?,?)");

            pst2.setString(1,myId);
            pst2.setDate(2, (Date) guia.getFechaGuiaSalida());
            pst2.setString(3,guia.getObservaciones());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "guia salida ingresada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(GuiaSalida guia) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE GUIA_SALIDA SET ID_GUIA_SALIDA=?,FECHA=?,OBSERVACIONES=? WHERE ID_GUIA_SALIDA=?");

            pst2.setString(1,guia.getIdGuiaSalida());
            pst2.setDate(2, (Date) guia.getFechaGuiaSalida());
            pst2.setString(3,guia.getObservaciones());
            pst2.setString(4,guia.getIdGuiaSalida());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Guia de entrada actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM GUIA_SALIDA WHERE ID_GUIA_SALIDA=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Guia de SALIDA eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
