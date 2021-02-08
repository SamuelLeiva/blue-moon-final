/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.Plato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class PlatoDAO{

    public static List<Vector> findAll(){
        List<Vector> listaPedidos = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from plato");
        
        try {
            while(res.next()){
                Plato ped = new Plato(res.getString(1),res.getString(2),res.getString(3),res.getDouble(4),res.getString(5));
                Vector v = new Vector();
                v.add(ped.getIdPlato());
                v.add(ped.getIdCategoriaPlato());
                v.add(ped.getNombrePlato());
                v.add(ped.getPrecioPlato());
                v.add(ped.getDescripcionPlato());
                listaPedidos.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaPedidos;
    }

    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from plato where id_plato=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                Plato ped = new Plato(res.getString(1),res.getString(2),res.getString(3),res.getDouble(4),res.getString(5));
                v.add(ped);
            }
        
        return v;
    }
    
    public static void insert(Plato ped) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_PLATO;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMPLATO-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO PLATO VALUES (?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,ped.getIdCategoriaPlato());
            pst2.setString(3,ped.getNombrePlato());
            pst2.setDouble(4,ped.getPrecioPlato());
            pst2.setString(5, ped.getDescripcionPlato());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Plato ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de pedido de compra.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Plato ped) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE PLATO SET ID_PLATO=?,ID_CATEGORIA_PLATO=?,NOMBRE_PLATO=?, PRECIO_PLATO=?,"
                    + "DESCRIPCION_PLATO=? WHERE ID_PLATO=?");

            pst2.setString(1,ped.getIdPlato());
            pst2.setString(2,ped.getIdCategoriaPlato());
            pst2.setString(3,ped.getNombrePlato());
            pst2.setDouble(4,ped.getPrecioPlato());
            pst2.setString(5, ped.getDescripcionPlato());
            pst2.setString(6,ped.getIdPlato());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Plato actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM PLATO WHERE ID_PLATO=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Plato eliminado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de pedido.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
