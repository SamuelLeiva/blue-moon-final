/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.CategoriaBebida;
import bluemoon.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class CategoriaBebidaDao {
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from CATEGORIA_BEBIDA");
        
        try {
            while(res.next()){
                CategoriaBebida beb = new CategoriaBebida(res.getString(1),res.getString(2),res.getString(3),res.getString(4));
                Vector v = new Vector();
                v.add(beb.getCatBebId());
                v.add(beb.getNombre());
                v.add(beb.getEstado());
                v.add(beb.getDescripcion());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla categoria bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from CATEGORIA_BEBIDA where id_categoria_bebida=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                CategoriaBebida beb = new CategoriaBebida(res.getString(1),res.getString(2),res.getString(3),res.getString(4));

                v.add(beb);
            }
        
        return v;
    }
    
    public static void insert(CategoriaBebida beb) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM seq_categoria_bebida;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMCATB-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO CATEGORIA_BEBIDA VALUES (?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,beb.getNombre());
            pst2.setString(3,beb.getEstado());
            pst2.setString(4,beb.getDescripcion());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria de Bebida ingresada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(CategoriaBebida beb) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE CATEGORIA_BEBIDA SET ID_CATEGORIA_BEBIDA=?,NOMBRE=?,ESTADO=?,DESCRIPCION=?"
                    + " WHERE ID_CATEGORIA_BEBIDA=?");

            pst2.setString(1,beb.getCatBebId());
            pst2.setString(2,beb.getNombre());
            pst2.setString(3,beb.getEstado());
            pst2.setString(4,beb.getDescripcion());
            pst2.setString(5,beb.getCatBebId());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria de bebida actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de categoria.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM CATEGORIA_BEBIDA WHERE ID_CATEGORIA_BEBIDA=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}
