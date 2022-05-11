/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.modelo.*;
import seguridad.modelo.*;
import compras.controlador.clsCompras;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCompras {

    private static final String SQL_SELECT = "SELECT comid ,provid, comserie, ordid FROM tbl_compraencabezado";
    private static final String SQL_SELECT2 = "SELECT prodid, ordcantidad, ordcosto,comfechaemi,comfechavenci FROM tbl_compradetalle";
    private static final String SQL_INSERT = "INSERT INTO tbl_compraencabezado ( provid, comserie, ordid) VALUES ( ?, ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO tbl_compradetalle (prodid, ordcantidad, ordcosto, comfechaemi, comfechavenci) VALUES (?, ?, ?,?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_compraencabezado SET provid = ?, comserie = ?, ordid = ? WHERE tbl_compraencabezado.comid = ?";
    private static final String SQL_UPDATE2 = "UPDATE tbl_compradetalle SET prodid = ?, ordcantidad = ?, ordcosto = ?, comfechaemi = ?, comfechavenci = ? WHERE tbl_compradetalle.comdetid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_compraencabezado WHERE tbl_compraencabezado.comid = ?";
    private static final String SQL_DELETE2 = "DELETE FROM tbl_compradetalle WHERE tbl_compradetalle.comdetid = ?";
    private static final String SQL_QUERY = "SELECT comid ,provid, comserie, ordid FROM tbl_compraencabezado WHERE tbl_compraencabezado.comid = ?";
    private static final String SQL_QUERY2 = "SELECT prodid, ordcantidad, ordcosto,comfechaemi,comfechavenci FROM tbl_compradetalle WHERE tbl_compradetalle.comdetid = ?";
    public List<clsCompras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCompras compras = null;
        List<clsCompras> compra= new ArrayList<clsCompras>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int comid = rs.getInt("comid");
                int provid = rs.getInt("provid");
                int comserie = rs.getInt("comserie");
                int ordid = rs.getInt("ordid");

                compras = new clsCompras();
                compras.setComid(comid);
                compras.setProvid(provid);
                compras.setComserie(comserie);
                compras.setOrdid(ordid);
   
                compra.add(compras);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return compra;
    }
        public List<clsCompras> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCompras compras = null;
        List<clsCompras> compra= new ArrayList<clsCompras>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int prodid = rs.getInt("prodid");
                int ordcantidad = rs.getInt("ordcantidad");
                int ordcosto = rs.getInt("ordcosto");
                String comfechaemi = rs.getString("comfechaemi");
                String comfechavenci = rs.getString("comfechavenci");
                
                compras = new clsCompras();
                compras.setProdid(prodid);
                compras.setOrdcantidad(ordcantidad);
                compras.setOrdcosto(ordcosto);
                compras.setComfechaemi(comfechaemi);
                compras.setComfechavenci(comfechavenci);
   
                compra.add(compras);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return compra;
    }

    public int insert(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, producto.getProvid());
            stmt.setInt(2, producto.getComserie());
            stmt.setInt(3, producto.getOrdid());
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
    
        public int insert2(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setInt(1, producto.getProdid());
            stmt.setInt(2, producto.getOrdcantidad());
            stmt.setInt(3, producto.getOrdcosto());
            stmt.setString(4, producto.getComfechaemi());
            stmt.setString(5, producto.getComfechavenci());
            System.out.println("ejecutando query:" + SQL_INSERT2);
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


    public int update(clsCompras producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, producto.getProvid());
            stmt.setInt(2, producto.getComserie());
            stmt.setInt(3, producto.getOrdid());
            stmt.setInt(4, producto.getComid());
                        
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
        public int update2(clsCompras producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setInt(1, producto.getProdid());
            stmt.setInt(2, producto.getOrdcantidad());
            stmt.setInt(3, producto.getOrdcosto());
            stmt.setString(4, producto.getComfechaemi());
            stmt.setString(5, producto.getComfechavenci());
            stmt.setInt(6, producto.getComid());
                        
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

    public int delete(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getComid());
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
    public int delete2(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setInt(1, producto.getComid());
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

    public clsCompras query(clsCompras compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, compras.getComid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                 int comid = rs.getInt("comid");
                int provid = rs.getInt("provid");
                int comserie = rs.getInt("comserie");
                int ordid = rs.getInt("ordid");

                compras = new clsCompras();
                compras.setComid(comid);
                compras.setProvid(provid);
                compras.setComserie(comserie);
                compras.setOrdid(ordid);
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
        return compras;
    }
        public clsCompras query2(clsCompras compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setInt(1, compras.getComid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                 int prodid = rs.getInt("prodid");
                int ordcantidad = rs.getInt("ordcantidad");
                int ordcosto = rs.getInt("ordcosto");
                String comfechaemi = rs.getString("comfechaemi");
                String comfechavenci = rs.getString("comfechavenci");
                
                compras = new clsCompras();
                compras.setProdid(prodid);
                compras.setOrdcantidad(ordcantidad);
                compras.setOrdcosto(ordcosto);
                compras.setComfechaemi(comfechaemi);
                compras.setComfechavenci(comfechavenci);
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
        return compras;
    }
    
    
    
}
