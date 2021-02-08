
package bluemoon.dao;

import bluemoon.model.Conexion;
import bluemoon.model.DetInventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetInventarioDao implements CRUD{
    Connection con = Conexion.getConexion();
    PreparedStatement ps;
    ResultSet rs;
    

    @Override
    public List listar() {
        List<DetInventario> lista = new ArrayList();
        String sql = "select * from det_inventario";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                DetInventario beb = new DetInventario();
                beb.setCantidad(rs.getInt(1));
                beb.setAlmacenId(rs.getString(2));
                beb.setProductoId(rs.getString(3));
                
                lista.add(beb);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int agregar(Object[] o) {
        int r = 0;
        String sqlInsert = "insert into DET_INVENTARIO values (?,?,?)";
        
        try {
                        
            ps = con.prepareStatement(sqlInsert);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update DET_INVENTARIO set CANTIDAD=? WHERE ID_PRODUCTO=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[2]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(String id) {
        String sql = "delete from DET_INVENTARIO where ID_PRODUCTO=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    
}
