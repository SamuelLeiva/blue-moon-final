/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.CategoriaPlato;
import bluemoon.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class CategoriaPlatoDao{
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from CATEGORIA_PLATO");
        
        try {
            while(res.next()){
                CategoriaPlato beb = new CategoriaPlato(res.getString(1),res.getString(2),res.getString(3),res.getString(4));
                Vector v = new Vector();
                v.add(beb.getCatPlatId());
                v.add(beb.getNombre());
                v.add(beb.getDescripcion());
                v.add(beb.getEstado());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla categoria plato.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from CATEGORIA_PLATO where id_categoria_plato=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                CategoriaPlato beb = new CategoriaPlato(res.getString(1),res.getString(2),res.getString(3),res.getString(4));

                v.add(beb);
            }
        
        return v;
    }
    
    public static void insert(CategoriaPlato beb) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM seq_categoria_plato;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMCAT-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO CATEGORIA_PLATO VALUES (?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,beb.getNombre());
            pst2.setString(3,beb.getDescripcion());
            pst2.setString(4,beb.getEstado());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria de palto ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(CategoriaPlato beb) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE CATEGORIA_PLATO SET ID_CATEGORIA_PLATO=?,NOMBRE=?,DESCRIPCION=?,ESTADO=?"
                    + " WHERE ID_CATEGORIA_PLATO=?");

            pst2.setString(1,beb.getCatPlatId());
            pst2.setString(2,beb.getNombre());
            pst2.setString(3,beb.getEstado());
            pst2.setString(4,beb.getDescripcion());
            pst2.setString(5,beb.getCatPlatId());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria de plato actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de categoria.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM CATEGORIA_PLATO WHERE ID_CATEGORIA_PLATO=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
