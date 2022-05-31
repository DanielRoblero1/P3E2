/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.controlador.clsOrdenesCompras_DanielRoblero;
import compras.modelo.*;
import seguridad.modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoOrdenesCompras_DanielRoblero {

    private static final String SQL_SELECT = "SELECT ordid ,ordfecha, provid FROM tbl_ordecompraencabezado";
    private static final String SQL_SELECT2 = "SELECT ordcdetalleid,ordcantidad, ordcosto, prodid FROM tbl_ordecompradetalle";

    private static final String SQL_INSERT = "INSERT INTO tbl_ordecompraencabezado (ordfecha, provid) VALUES ( ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO tbl_ordecompradetalle (ordcantidad, ordcosto, prodid) VALUES ( ?, ?, ?)";
                                              

    private static final String SQL_UPDATE = "UPDATE tbl_ordecompraencabezado SET ordfecha = ?, provid = ? WHERE tbl_ordecompraencabezado.ordid = ?";
    private static final String SQL_UPDATE2 = "UPDATE tbl_ordecompradetalle SET ordcantidad = ?, ordcosto = ?, prodid = ? WHERE tbl_ordecompradetalle.ordcdetalleid  = ?";

    private static final String SQL_DELETE = "DELETE FROM tbl_ordecompraencabezado WHERE tbl_ordecompraencabezado.ordid = ?";
    private static final String SQL_DELETE2 = "DELETE FROM tbl_ordecompradetalle WHERE tbl_ordecompradetalle.ordcdetalleid = ?";

    private static final String SQL_QUERY = "SELECT ordid ,ordfecha, provid FROM tbl_ordecompraencabezado WHERE tbl_ordecompraencabezado.ordid = ?";
    private static final String SQL_QUERY2 = "SELECT ordcantidad, ordcosto,prodid FROM tbl_ordecompradetalle WHERE tbl_ordecompradetalle.ordcdetalleid = ?";

    public List<clsOrdenesCompras_DanielRoblero> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsOrdenesCompras_DanielRoblero compras = null;
        List<clsOrdenesCompras_DanielRoblero> compra= new ArrayList<clsOrdenesCompras_DanielRoblero>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ordid = rs.getInt("ordid");
                String ordfecha = rs.getString("ordfecha");
                int provid = rs.getInt("provid");
                

                compras = new clsOrdenesCompras_DanielRoblero();
                compras.setordid(ordid);
                compras.setordfecha(ordfecha);
                compras.setprovid(provid);
                
   
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
        public List<clsOrdenesCompras_DanielRoblero> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsOrdenesCompras_DanielRoblero compras = null;
        List<clsOrdenesCompras_DanielRoblero> compra= new ArrayList<clsOrdenesCompras_DanielRoblero>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ordcantidad = rs.getInt("ordcantidad");
                int ordcosto = rs.getInt("ordcosto");
                int prodid = rs.getInt("prodid");

                
                compras = new clsOrdenesCompras_DanielRoblero();
                compras.setordcantidad(ordcantidad);
                compras.setordcosto(ordcosto);
                compras.setprodid(prodid);

   
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

    public int insert(clsOrdenesCompras_DanielRoblero producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getordfecha());
            stmt.setInt(2, producto.getprovid());
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
    
        public int insert2(clsOrdenesCompras_DanielRoblero producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setInt(1, producto.getordcantidad());
            stmt.setInt(2, producto.getordcosto());
            stmt.setInt(3, producto.getprodid());
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


    public int update(clsOrdenesCompras_DanielRoblero producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getordfecha());
            stmt.setInt(2, producto.getprovid());
            stmt.setInt(3, producto.getordid());

                        
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
        public int update2(clsOrdenesCompras_DanielRoblero producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setInt(1, producto.getordcantidad());
            stmt.setInt(2, producto.getordcosto());
            stmt.setInt(3, producto.getprodid());
            stmt.setInt(4, producto.getordid());


                        
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

    public int delete(clsOrdenesCompras_DanielRoblero producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getordid());
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
    public int delete2(clsOrdenesCompras_DanielRoblero producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setInt(1, producto.getordid());
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

    public clsOrdenesCompras_DanielRoblero query(clsOrdenesCompras_DanielRoblero compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, compras.getordid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                 int ordid = rs.getInt("ordid");
                String ordfecha = rs.getString("ordfecha");
                int provid = rs.getInt("provid");

                compras = new clsOrdenesCompras_DanielRoblero();
                compras.setordid(ordid);
                compras.setordfecha(ordfecha);
                compras.setprovid(provid);
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
        public clsOrdenesCompras_DanielRoblero query2(clsOrdenesCompras_DanielRoblero compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setInt(1, compras.getordid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ordcantidad = rs.getInt("ordcantidad");
                int ordcosto = rs.getInt("ordcosto");
                int prodid = rs.getInt("prodid");

                
                compras = new clsOrdenesCompras_DanielRoblero();
                compras.setordcantidad(ordcantidad);
                compras.setordcosto(ordcosto);
                compras.setprodid(prodid);

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
