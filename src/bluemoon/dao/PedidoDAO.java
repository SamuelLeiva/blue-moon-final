/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.Pedido;
import bluemoon.model.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class PedidoDAO {
    public static List<Vector> findAll(){
        List<Vector> listaPedidos = new ArrayList<>();
        
        ResultSet res = Conexion.Consulta("select * from pedido");
        
        try {
            while(res.next()){
                Pedido ped = new Pedido(res.getString(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDate(5), res.getString(6),res.getString(7));
                Vector v = new Vector();
                v.add(ped.getIdPersonal());
                v.add(ped.getIdPedido());
                v.add(ped.getIdMesa());
                v.add(ped.getTotalPedido());
                v.add(ped.getFechaPedido());
                v.add(ped.getEstadoPedido());
                v.add(ped.getIdCliente());
                listaPedidos.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de la tabla.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaPedidos;
    }

    public static Vector findById(String id) throws SQLException{
        PreparedStatement pst = Conexion.getConexion().prepareStatement("select * from pedido where id_pedido=?");
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        Vector v = new Vector();
        
        while(res.next()){
                Pedido ped = new Pedido(res.getString(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDate(5), res.getString(6),res.getString(7));

                v.add(ped);
            }
        
        return v;
    }
    
    public static void insert(Pedido ped) {
        
        String myId = "";
        String sqlIdentifier = "SELECT NEXT VALUE FROM SEQ_PEDIDO;";
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                myId = "BMPEDV-" + rs.getInt(1);
            }else{
                myId = "gaaaaaaaaa";
            }
        } catch (Exception e) {
        }
        
        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("INSERT INTO PEDIDO VALUES (?,?,?,?,?,?,?)");

            pst2.setString(1,ped.getIdPersonal());
            pst2.setString(2,myId);
            pst2.setString(3,ped.getIdMesa());
            pst2.setDouble(4,ped.getTotalPedido());
            pst2.setDate(5, (Date) ped.getFechaPedido());
            pst2.setString(6,ped.getEstadoPedido());
            pst2.setString(7,ped.getIdCliente());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pedido ingresado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la inserción de pedido de compra.","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Pedido ped) {

        try{
            PreparedStatement pst2 = Conexion.getConexion().prepareStatement("UPDATE PEDIDO SET ID_PERSONAL=?,ID_PEDIDO=?,ID_MESA=?, TOTAL_PEDIDO=?,"
                    + "FECHA_PEDIDO=?,ESTADO_PEDIDO=?,ID_CLIENTE=? WHERE ID_PEDIDO=?");

            pst2.setString(1,ped.getIdPersonal());
            pst2.setString(2,ped.getIdPedido());
            pst2.setString(3,ped.getIdMesa());
            pst2.setDouble(4,ped.getTotalPedido());
            pst2.setDate(5, (Date) ped.getFechaPedido());
            pst2.setString(6,ped.getEstadoPedido());
            pst2.setString(7,ped.getIdCliente());
            pst2.setString(8,ped.getIdPedido());
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pedido actualizado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de bebida.","Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    public void eliminar(String id) {
        try{
            PreparedStatement ps = Conexion.getConexion().prepareStatement("DELETE FROM PEDIDO WHERE ID_PEDIDO=?");
            ps.setString(1,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pedido eliminado.",
                        "Éxito",JOptionPane.PLAIN_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la eliminación de pedido.","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}
