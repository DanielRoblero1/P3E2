/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.vista;

import compras.controlador.clsOrdenesCompras;
import seguridad.vista.*;
import compras.vista.*;
import compras.modelo.daoProducto;
import compras.controlador.clsProducto;
import compras.modelo.daoOrdenesCompras;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class frmOrdenesCompras extends javax.swing.JInternalFrame {

  

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Orden");
        modelo.addColumn("FECHA");
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("ID producto");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("COSTO");
        daoOrdenesCompras productoDAO = new daoOrdenesCompras();
        List<clsOrdenesCompras> producto = productoDAO.select();
        List<clsOrdenesCompras> producto2 = productoDAO.select2();

        tablaVendedores.setModel(modelo);
        String[] dato = new String[6];
        for (int i = 0; i < producto.size(); i++) {
            dato[0] = Integer.toString(producto.get(i).getordid());
            dato[1] = producto.get(i).getordfecha();
            dato[2] = Integer.toString(producto.get(i).getprovid());
            dato[3] = Integer.toString(producto2.get(i).getprodid());
            dato[4] = Integer.toString(producto2.get(i).getordcantidad());
            dato[5] = Integer.toString(producto2.get(i).getordcosto());



            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscarProducto() {
        clsProducto productoAConsultar = new clsProducto();
        daoProducto productoDAO = new daoProducto();
        productoAConsultar.setProdid(Integer.parseInt(txtbuscado.getText()));
        productoAConsultar = productoDAO.query(productoAConsultar);
        txtFecha.setText(String.valueOf(productoAConsultar.getProvid()));
        txtProveedor.setText(productoAConsultar.getProdnombre());
        txtCantidad.setText(productoAConsultar.getProdmarca());
        txtProducto.setText(String.valueOf(productoAConsultar.getProdprecio()));
        txtCosto.setText(productoAConsultar.getProdlinea());
        
    }

    public frmOrdenesCompras() {
        initComponents();
        llenadoDeTablas();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        txtProducto = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtCosto = new javax.swing.JTextField();
        label8 = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PROCESO ORDENES DE COMPRAS");
        setPreferredSize(new java.awt.Dimension(1100, 550));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 95, 30));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 95, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 100, 30));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("ORDEN DE COMPRA");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 0, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 95, 30));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Codigo Del Orden de compra");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 102, -1));

        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 220, 20));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 95, 30));

        tablaVendedores.setBackground(new java.awt.Color(204, 255, 255));
        tablaVendedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 20, 612, 440));

        txtProducto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 220, 20));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("ID PRODUCTO");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 20, 13, -1));

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 100, 30));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("ID PROVEEDOR");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("CANTIDAD");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txtProveedor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtProveedor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 220, 20));

        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 220, 20));

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("FECHA");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 40, -1));

        txtCosto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCosto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 220, 20));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("COSTO");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        daoProducto productoDAO = new daoProducto();
        clsProducto productoAEliminar = new clsProducto();
        productoAEliminar.setProdid(Integer.parseInt(txtbuscado.getText()));
        productoDAO.delete(productoAEliminar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoOrdenesCompras productoDAO = new daoOrdenesCompras();
        clsOrdenesCompras productoAInsertar = new clsOrdenesCompras();
        clsOrdenesCompras productoAInsertar2 = new clsOrdenesCompras();

        productoAInsertar.setordfecha(txtFecha.getText());
        productoAInsertar.setprovid(Integer.parseInt(txtProveedor.getText()));
        productoAInsertar2.setordcantidad(Integer.parseInt(txtCantidad.getText()));
        productoAInsertar2.setordcosto(Integer.parseInt(txtCosto.getText()));
        productoAInsertar2.setprodid(Integer.parseInt(txtProducto.getText()));

        productoDAO.insert(productoAInsertar);
        productoDAO.insert3(productoAInsertar2);

        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarProducto();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        daoProducto productoDAO = new daoProducto();
        clsProducto productoAActualizar = new clsProducto();
        productoAActualizar.setProdid(Integer.parseInt(txtbuscado.getText()));
        productoAActualizar.setProvid(Integer.parseInt(txtFecha.getText()));
        productoAActualizar.setProdnombre(txtProveedor.getText());
        productoAActualizar.setProdmarca(txtCantidad.getText());
        productoAActualizar.setProdprecio(Integer.parseInt(txtProducto.getText()));
        productoAActualizar.setProdlinea(txtCosto.getText());
        productoDAO.update(productoAActualizar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       
        txtFecha.setText("");
        txtProducto.setText("");
        txtbuscado.setText("");
        txtProveedor.setText("");
        txtCantidad.setText("");
        txtCosto.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "INGRESE EL CODIGO DEL PRODUCTO QUE DESEA BUSCAR,ELIMINAR O REGISTRAR");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
