/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.FacturaCompra;
import bluemoon.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class UsuarioDao{
    public static List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from usuario");
        
        try {
            while(res.next()){
                Usuario prod = new Usuario(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5), res.getString(6));
                Vector v = new Vector();
                v.add(prod.getIdUser());
                v.add(prod.getNombreUser());
                v.add(prod.getPasswordUser());
                v.add(prod.getEmailUser());
                v.add(prod.getTipoUser());
                v.add(prod.getIdPersonal());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tablas.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from usuario where id_usuario=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                Usuario prod = new Usuario(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5), res.getString(6));

                v.add(prod);
            }
        
        return v;
    }
    
    public static void insert(Usuario prod) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_USUARIO;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMUSU-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO USUARIO VALUES (?,?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,prod.getNombreUser());
            pst2.setString(3,prod.getPasswordUser());
            pst2.setString(4,prod.getEmailUser());
            pst2.setString(5,prod.getTipoUser());
            pst2.setString(6,prod.getIdPersonal());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Usuario prod) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE USUARIO SET ID_USUARIO=?,NOMBRE_USUARIO=?,CONTRASEÑA_USUARIO=?,EMAIL_USUARIO=?,"
                    + "TIPO_USUARIO=?,ID_PERSONAL=? WHERE ID_PERSONAL=?");

            pst2.setString(1,prod.getIdUser());
            pst2.setString(2,prod.getNombreUser());
            pst2.setString(3,prod.getPasswordUser());
            pst2.setString(4,prod.getEmailUser());
            pst2.setString(5,prod.getTipoUser());
            pst2.setString(6,prod.getIdPersonal());
            pst2.setString(7,prod.getIdUser());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM USUARIO WHERE ID_USUARIO=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario eliminado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    
}
