/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.modelo.*;
import seguridad.modelo.*;
import compras.controlador.clsCuentasPorPagar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCuentasPorPagar {

    private static final String SQL_SELECT = "SELECT cuentapagarid, conid, cuentadoc, cuentasaldo, cuentavalor, cuentareferencia, comid, provid FROM tbl_cuentasporpagar";
    private static final String SQL_INSERT = "INSERT INTO tbl_cuentasporpagar ( conid, comid, provid, cuentadoc, cuentasaldo, cuentavalor, cuentareferencia) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cuentasporpagar SET cuentadoc = ?, cuentasaldo = ?, cuentavalor = ?, cuentareferencia =?, comid =?, provid =? WHERE tbl_cuentasporpagar.cuentapagarid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cuentasporpagar WHERE tbl_cuentasporpagar.cuentapagarid = ?";
    private static final String SQL_QUERY = "SELECT cuentapagarid, conid, cuentadoc, cuentasaldo, cuentavalor, cuentareferencia, comid, provid FROM tbl_cuentasporpagar WHERE tbl_cuentasporpagar.cuentapagarid=?";

    public List<clsCuentasPorPagar> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCuentasPorPagar cuentas = null;
        List<clsCuentasPorPagar> cuent = new ArrayList<clsCuentasPorPagar>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cuentapagarid = rs.getInt("cuentapagarid");
                int conid = rs.getInt("conid");
                int cuentadoc = rs.getInt("cuentadoc");
                int cuentasaldo = rs.getInt("cuentasaldo");
                int cuentavalor = rs.getInt("cuentavalor");
                int cuentareferencia = rs.getInt("cuentareferencia");
                int comid = rs.getInt("comid");
                int Provid = rs.getInt("provid");

                cuentas = new clsCuentasPorPagar();
                cuentas.setCuentapagarid(cuentapagarid);
                cuentas.setConid(conid);
                cuentas.setCuentadoc(cuentadoc);
                cuentas.setCuentasaldo(cuentasaldo);
                cuentas.setCuentavalor(cuentavalor);
                cuentas.setCuentareferencia(cuentareferencia);
                cuentas.setComid(comid);
                cuentas.setProvid(Provid);
                
                cuent.add(cuentas);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return cuent;
    }

    public int insert(clsCuentasPorPagar cuentas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cuentas.getConid());
            stmt.setInt(2, cuentas.getCuentadoc());
            stmt.setInt(3, cuentas.getCuentasaldo());
            stmt.setInt(4, cuentas.getCuentavalor());
            stmt.setInt(5, cuentas.getCuentareferencia());
            stmt.setInt(6, cuentas.getComid());
            stmt.setInt(7, cuentas.getProvid());

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


    public int update(clsCuentasPorPagar cuentas) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, cuentas.getCuentadoc());
            stmt.setInt(2, cuentas.getCuentasaldo());
            stmt.setInt(3, cuentas.getCuentavalor());
            stmt.setInt(4, cuentas.getCuentareferencia());
            stmt.setInt(5, cuentas.getComid());
            stmt.setInt(6, cuentas.getProvid());
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

    public int delete(clsCuentasPorPagar cuentas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cuentas.getCuentapagarid());
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

    public clsCuentasPorPagar query(clsCuentasPorPagar cuentas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cuentas.getCuentapagarid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cuentapagarid = rs.getInt("cuentapagarid");
                int conid = rs.getInt("conid");
                int cuentadoc = rs.getInt("cuentadoc");
                int cuentasaldo = rs.getInt("cuentasaldo");
                int cuentavalor = rs.getInt("cuentavalor");
                int cuentareferencia = rs.getInt("cuentareferencia");
                int comid = rs.getInt ("comid");
                int provid = rs.getInt("provid");

                cuentas = new clsCuentasPorPagar();
                cuentas.setCuentapagarid(cuentapagarid);
                cuentas.setConid(conid);
                cuentas.setCuentadoc(cuentadoc);
                cuentas.setCuentasaldo(cuentasaldo);
                cuentas.setCuentavalor(cuentasaldo);
                cuentas.setCuentareferencia(cuentavalor);
                cuentas.setComid(comid);
                cuentas.setProvid(provid);
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
        return cuentas;
    }
}
