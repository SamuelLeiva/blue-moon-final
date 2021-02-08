/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.PedidoCompra;
import bluemoon.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class ProductoDAO {
    
    

    public List<Vector> findAll(){
        List<Vector> lista = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from producto");
        
        try {
            while(res.next()){
                Producto prod = new Producto(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getDouble(5), res.getInt(6));
                Vector v = new Vector();
                v.add(prod.getIdProducto());
                v.add(prod.getNombreProducto());
                v.add(prod.getUnidadMedida());
                v.add(prod.getIdCategoria());
                v.add(prod.getPrecioUnitario());
                v.add(prod.getCantidadProducto());
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tablas.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }
    
    public Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from producto where id_producto=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                Producto prod = new Producto(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getDouble(5), res.getInt(6));

                v.add(prod);
            }
        
        return v;
    }
    
    public void insert(Producto prod) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_PRODUCTO;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMPROD-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO PRODUCTO VALUES (?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,prod.getNombreProducto());
            pst2.setString(3,prod.getUnidadMedida());
            pst2.setString(4,prod.getIdCategoria());
            pst2.setDouble(5,prod.getPrecioUnitario());
            pst2.setInt(6,prod.getCantidadProducto());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Producto ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update(Producto prod) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE PRODUCTO SET ID_PRODUCTO=?,NOMBRE_PRODUCTO=?,UNIDAD_MEDIDA=?,ID_CATEGORIA=?,"
                    + "PRECIO_UNITARIO=?,CANTIDAD_PRODUCTO=? WHERE ID_PEDIDO_COMPRA=?");

            pst2.setString(1,prod.getIdProducto());
            pst2.setString(2,prod.getNombreProducto());
            pst2.setString(3,prod.getUnidadMedida());
            pst2.setString(4,prod.getIdCategoria());
            pst2.setDouble(5,prod.getPrecioUnitario());
            pst2.setInt(6,prod.getCantidadProducto());
            pst2.setString(7,prod.getIdProducto());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Producto actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        String sql="DELETE FROM PRODUCTO WHERE ID_PRODUCTO=?";
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM PRODUCTO WHERE ID_PRODUCTO=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Producto eliminado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de producto.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}
