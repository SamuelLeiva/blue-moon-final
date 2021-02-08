/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.Personal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class PersonalDAO{

    public static List<Vector> findAll(){
        List<Vector> listaPedidos = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from personal");
        
        try {
            while(res.next()){
                Personal ped = new Personal(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5), res.getString(6),res.getString(7),res.getString(8));
                Vector v = new Vector();
                v.add(ped.getIdCargo());
                v.add(ped.getIdPersonal());
                v.add(ped.getDniPersonal());
                v.add(ped.getNombrePersonal());
                v.add(ped.getApellidoPersonal());
                v.add(ped.getTelefonoPersonal());
                v.add(ped.getEmailPersonal());
                v.add(ped.getIdSede());
                listaPedidos.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaPedidos;
    }

    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from personal where id_personal=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                Personal ped = new Personal(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5), res.getString(6),res.getString(7),res.getString(8));
                v.add(ped);
            }
        
        return v;
    }
    
    public static void insert(Personal ped) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_PERSONAL;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMPERS-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO PERSONAL VALUES (?,?,?,?,?,?,?,?)");

            pst2.setString(1,ped.getIdCargo());
            pst2.setString(2,myId);
            pst2.setString(3,ped.getDniPersonal());
            pst2.setString(4,ped.getNombrePersonal());
            pst2.setString(5, ped.getApellidoPersonal());
            pst2.setString(6,ped.getTelefonoPersonal());
            pst2.setString(7,ped.getEmailPersonal());
            pst2.setString(8,ped.getIdSede());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Personal ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de pedido de compra.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Personal ped) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE PERSONAL SET ID_CARGO=?,ID_PERSONAL=?,DNI_PERSONAL=?, NOMBRE_PERSONAL=?,"
                    + "APELLIDO_PERSONAL=?,TELEFONO_PERSONAL=?,EMAIL_PERSONAL=?,ID_SEDE=? WHERE ID_PERSONAL=?");

            pst2.setString(1,ped.getIdCargo());
            pst2.setString(2,ped.getIdPersonal());
            pst2.setString(3,ped.getDniPersonal());
            pst2.setString(4,ped.getNombrePersonal());
            pst2.setString(5, ped.getApellidoPersonal());
            pst2.setString(6,ped.getTelefonoPersonal());
            pst2.setString(7,ped.getEmailPersonal());
            pst2.setString(8,ped.getIdSede());
            pst2.setString(9,ped.getIdPersonal());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Personal actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM PERSONAL WHERE ID_PERSONAL=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "PERSONAL eliminado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de pedido.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
