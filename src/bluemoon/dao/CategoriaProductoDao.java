
package bluemoon.dao;

import bluemoon.model.CategoriaProducto;
import bluemoon.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class CategoriaProductoDao{
    public List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from CATEGORIA_BEBIDA");
        
        try {
            while(res.next()){
                CategoriaProducto beb = new CategoriaProducto(res.getString(1),res.getString(2),res.getString(3));
                Vector v = new Vector();
                v.add(beb.getCatProId());
                v.add(beb.getNombre());
                v.add(beb.getDescripcion());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla categoria producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from CATEGORIA_PLATO where id_categoria=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                CategoriaProducto beb = new CategoriaProducto(res.getString(1),res.getString(2),res.getString(3));

                v.add(beb);
            }
        
        return v;
    }
    
    public String findByName(String nombre) throws SQLException{
        PreparedStatement categoria = Conexion.getConexion().prepareStatement("SELECT * FROM CATEGORIA_PRODUCTO WHERE NOMBRE_CATEGORIA = ?");
        categoria.setString(1, nombre);
        ResultSet resCat = categoria.executeQuery();
         
        String id = "";
        
        while(resCat.next()){        
            id = resCat.getString(1);
        }
        return id;
    }
    
    public void insert(CategoriaProducto beb) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM seq_categoria_producto;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMCATP-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO CATEGORIA_PRODUCTO VALUES (?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,beb.getNombre());
            pst2.setString(3,beb.getDescripcion());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria de PRODUCTO ingresada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de categoria producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update(CategoriaProducto beb) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE CATEGORIA_PRODUCTO SET ID_CATEGORIA=?,NOMBRE_CATEGORIA=?,DESCRIPCION_CATEGORIA=?"
                    + " WHERE ID_CATEGORIA=?");

            pst2.setString(1,beb.getCatProId());
            pst2.setString(2,beb.getNombre());
            pst2.setString(3,beb.getDescripcion());
            pst2.setString(4,beb.getCatProId());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria de producto actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de categoria.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM CATEGORIA_PRODUCTO WHERE ID_CATEGORIA=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Categoria eliminada.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
