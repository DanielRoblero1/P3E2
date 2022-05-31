/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.modelo.*;
import seguridad.modelo.*;
import compras.controlador.clsConcepto_DiegoCortez;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoConcepto_DiegoCortez {

    private static final String SQL_SELECT = "SELECT conid, connombre, conefecto, conestatus FROM tbl_concepto";
    private static final String SQL_INSERT = "INSERT INTO tbl_concepto ( conid, connombre, conefecto, conestatus) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_concepto SET connombre = ?, conefecto = ?, conestatus = ? WHERE tbl_concepto.conid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_concepto WHERE tbl_concepto.conid = ?";
    private static final String SQL_QUERY = "SELECT conid, connombre, conefecto, conestatus FROM tbl_concepto WHERE conid=?";

    public List<clsConcepto_DiegoCortez> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsConcepto_DiegoCortez concepto = null;
        List<clsConcepto_DiegoCortez> concept = new ArrayList<clsConcepto_DiegoCortez>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int conid = rs.getInt("conid");
                String connombre = rs.getString("connombre");
                boolean conefecto = rs.getBoolean("conefecto");
                boolean conestatus = rs.getBoolean("conestatus");

                concepto = new clsConcepto_DiegoCortez();
                concepto.setConid(conid);
                concepto.setConnombre(connombre);
                concepto.setConefecto(conefecto);
                concepto.setConestatus(conestatus);
                
                concept.add(concepto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return concept;
    }

    public int insert(clsConcepto_DiegoCortez concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, concepto.getConid());
            stmt.setString(2, concepto.getConnombre());
            stmt.setBoolean(3, concepto.getConefecto());
            stmt.setBoolean(4, concepto.getConestatus());

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


    public int update(clsConcepto_DiegoCortez concepto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(4, concepto.getConid());
            stmt.setString(1, concepto.getConnombre());
            stmt.setBoolean(2, concepto.getConefecto());
            stmt.setBoolean(3, concepto.getConestatus());

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

    public int delete(clsConcepto_DiegoCortez concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, concepto.getConid());
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

    public clsConcepto_DiegoCortez query(clsConcepto_DiegoCortez concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, concepto.getConid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                int conid = rs.getInt("conid");
                String connombre = rs.getString("connombre");
                boolean conefecto = rs.getBoolean("conefecto");
                boolean conestatus = rs.getBoolean("conestatus");

                concepto = new clsConcepto_DiegoCortez();
                concepto.setConid(conid);
                concepto.setConnombre(connombre);
                concepto.setConefecto(conefecto);
                concepto.setConestatus(conestatus);
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
        return concepto;
    }
}
