
package bluemoon.dao;

import bluemoon.model.DetDocumentoVenta;
import bluemoon.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetDocumentoVentaDao implements CRUD{
    Connection con = Conexion.getConexion();
    PreparedStatement ps;
    ResultSet rs;
    

    @Override
    public List listar() {
        List<DetDocumentoVenta> lista = new ArrayList();
        String sql = "select * from det_documento_venta";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                DetDocumentoVenta beb = new DetDocumentoVenta();
                beb.setDocumentoId(rs.getString(1));
                beb.setPlatoId(rs.getString(2));
                beb.setPrecio(rs.getDouble(3));
                beb.setCantidad(rs.getInt(4));
                lista.add(beb);
            }
        } catch (Exception e) {
        }
        return lista;
    }

   @Override
    public int agregar(Object[] o) {
        int r = 0;
        String sqlInsert = "insert into det_documento_venta values (?,?,?,?)";
        
        try {
                        
            ps = con.prepareStatement(sqlInsert);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update det_documento_venta set PRECIO=?,CANTIDAD=? WHERE ID_DOCUMENTO_VENTA=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[3]);
            ps.setObject(2, o[4]);
            ps.setObject(3, o[0]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(String id) {
        String sql = "delete from det_documento_venta where id_documento_venta=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
