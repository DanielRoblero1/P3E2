/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.modelo.*;
import seguridad.modelo.*;
import compras.controlador.clsProducto_JosueMoran_MarcoGatica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProducto_JosueMoran_MarcoGatica {

    private static final String SQL_SELECT = "SELECT prodid, provid, prodnombre,prodmarca,prodprecio,prodlinea,prodexistencia FROM tbl_producto";
    private static final String SQL_INSERT = "INSERT INTO tbl_producto( provid, prodnombre, prodmarca, prodprecio, Prodlinea, prodexistencia) VALUES ( ?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_producto SET provid = ?,prodnombre = ?,prodmarca = ?, prodprecio = ?, Prodlinea = ?, prodexistencia = ? WHERE tbl_producto.prodid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_producto WHERE tbl_producto.prodid = ?";
    private static final String SQL_QUERY = "SELECT prodid, provid, prodnombre,prodmarca,prodprecio,prodlinea,prodexistencia FROM tbl_producto WHERE tbl_producto.prodid = ?";

    public List<clsProducto_JosueMoran_MarcoGatica> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProducto_JosueMoran_MarcoGatica producto = null;
        List<clsProducto_JosueMoran_MarcoGatica> product = new ArrayList<clsProducto_JosueMoran_MarcoGatica>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int prodid = rs.getInt("prodid");
                int provid = rs.getInt("provid");
                String prodnombre = rs.getString("prodnombre");
                String prodmarca = rs.getString("prodmarca");
                int prodprecio = rs.getInt("prodprecio");
                String prodlinea = rs.getString("prodlinea");
                String prodexistencia = rs.getString("prodexistencia");

                producto = new clsProducto_JosueMoran_MarcoGatica();
                producto.setProdid(prodid);
                producto.setProvid(provid);
                producto.setProdnombre(prodnombre);
                producto.setProdmarca(prodmarca);
                producto.setProdprecio(prodprecio);
                producto.setProdlinea(prodlinea);
                producto.setProdexistencia(prodexistencia);

                product.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return product;
    }

    public int insert(clsProducto_JosueMoran_MarcoGatica producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, producto.getProvid());
            stmt.setString(2, producto.getProdnombre());
            stmt.setString(3, producto.getProdmarca());
            stmt.setInt(4, producto.getProdprecio());
            stmt.setString(5,producto.getProdlinea());
            stmt.setString(6, producto.getProdexistencia());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }


    public int update(clsProducto_JosueMoran_MarcoGatica producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, producto.getProvid());
            stmt.setString(2, producto.getProdnombre());
            stmt.setString(3, producto.getProdmarca());
            stmt.setInt(4, producto.getProdprecio());
            stmt.setString(5, producto.getProdlinea());
            stmt.setString(6, producto.getProdexistencia());                      
            stmt.setInt(7, producto.getProdid());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsProducto_JosueMoran_MarcoGatica producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getProdid());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsProducto_JosueMoran_MarcoGatica query(clsProducto_JosueMoran_MarcoGatica producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, producto.getProdid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                int provid = rs.getInt("provid");
                String prodnombre = rs.getString("prodnombre");
                String prodmarca = rs.getString("prodmarca");
                int prodprecio = rs.getInt("prodprecio");
                String prodlinea = rs.getString("prodlinea");
                String prodexistencia = rs.getString("prodexistencia");

                producto = new clsProducto_JosueMoran_MarcoGatica();
                producto.setProvid(provid);
                producto.setProdnombre(prodnombre);
                producto.setProdmarca(prodmarca);
                producto.setProdprecio(prodprecio);
                producto.setProdlinea(prodlinea);
                producto.setProdexistencia(prodexistencia);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return producto;
    }

    public void insert2(clsProducto_JosueMoran_MarcoGatica productoAInsertar2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void update2(clsProducto_JosueMoran_MarcoGatica productoAActualizar2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
