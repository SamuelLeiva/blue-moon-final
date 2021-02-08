/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.PedidoCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class PedidoCompraDAO{

    public static List<Vector> findAll(){
        List<Vector> listaPedidos = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from pedido_compra");
        
        try {
            while(res.next()){
                PedidoCompra ped = new PedidoCompra(res.getString(1),res.getString(2),res.getString(3),res.getDouble(4),res.getInt(5));
                Vector v = new Vector();
                v.add(ped.getIdPedCompra());
                v.add(ped.getIdProveedor());
                v.add(ped.getIdProducto());
                v.add(ped.getPrecioPedCompra());
                v.add(ped.getCantidad());
                listaPedidos.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tablas.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaPedidos;
    }

    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from pedido_compra where id_pedido_compra=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                PedidoCompra ped = new PedidoCompra(res.getString(1), res.getString(2), res.getString(3), res.getDouble(4),res.getInt(5));

                v.add(ped);
            }
        
        return v;
    }
    
    public static void insert(PedidoCompra ped) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_PEDIDO_COMPRA;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMPEDC-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO PEDIDO_COMPRA VALUES (?,?,?,?,?)");

            pst2.setString(1,myId);
            pst2.setString(2,ped.getIdProveedor());
            pst2.setString(3,ped.getIdProducto());
            pst2.setDouble(4,ped.getPrecioPedCompra());
            pst2.setInt(5,ped.getCantidad());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pedido de compra ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de pedido de compra.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(PedidoCompra ped) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE PEDIDO_COMPRA SET ID_PEDIDO_COMPRA=?,ID_PROVEEDOR=?,ID_PRODUCTO=?, PRECIO=?,"
                    + "CANTIDAD=? WHERE ID_PEDIDO_COMPRA=?");

            pst2.setString(1,ped.getIdPedCompra());
            pst2.setString(2,ped.getIdProveedor());
            pst2.setString(3,ped.getIdProducto());
            pst2.setDouble(4,ped.getPrecioPedCompra());
            pst2.setInt(5,ped.getCantidad());
            pst2.setString(6,ped.getIdPedCompra());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pedido de compra actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM PEDIDO_COMPRA WHERE ID_PEDIDO_COMPRA=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pedido de compra eliminado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
