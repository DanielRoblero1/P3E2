/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.vista;

import compras.modelo.daoProducto_JosueMoran_MarcoGatica;
import compras.modelo.daoCompras_JosueMoran_DiegoCortez;
import compras.controlador.clsProducto_JosueMoran_MarcoGatica;
import compras.controlador.clsCompras_JosueMoran_DiegoCortez;
import compras.controlador.clsOrdenesCompras_DanielRoblero;
import compras.controlador.clsProveedorDanielRoblero;
import compras.modelo.daoOrdenesCompras_DanielRoblero;
import compras.modelo.daoProveedorDanielRoblero;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Calendar;
import javax.swing.JOptionPane;
import seguridad.vista.frmLogin;


/**
 *
 * @author visitante
 */
public class frmProcesoCompras extends javax.swing.JInternalFrame {

    public void llenadoDeCombos() {
        daoProveedorDanielRoblero provDAO = new daoProveedorDanielRoblero();
        List<clsProveedorDanielRoblero> proveedor = provDAO.select();

        cbx_Proveedor.addItem("Seleccione Un Codigo");
        for (int i = 0; i < proveedor.size(); i++) {
            cbx_Proveedor.addItem(String.valueOf(proveedor.get(i).getprovid()));
        }

        daoProducto_JosueMoran_MarcoGatica productoDao = new daoProducto_JosueMoran_MarcoGatica();
        List<clsProducto_JosueMoran_MarcoGatica> producto = productoDao.select();
        cbx_Producto.addItem("Seleccione Un codigo");
        for (int i = 0; i < producto.size(); i++) {
            cbx_Producto.addItem(String.valueOf(producto.get(i).getProdid()));

        }

        daoOrdenesCompras_DanielRoblero ordenes = new daoOrdenesCompras_DanielRoblero();
        List<clsOrdenesCompras_DanielRoblero> orden = ordenes.select();
        cbx_Orden.addItem("Seleccione Un Codigo");
        for (int i = 0; i < orden.size(); i++) {
            cbx_Orden.addItem(String.valueOf(orden.get(i).getordid()));

        }

    }

    public void llenadoDeTablas() {
        //instancia del objeta tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Compra");
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Serie");
        modelo.addColumn("Orden");
        modelo.addColumn("Emision");
        modelo.addColumn("Vencimiento");
        modelo.addColumn("ID Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Costo");
        //instancia el objeto productoDao
        daoCompras_JosueMoran_DiegoCortez productoDAO = new daoCompras_JosueMoran_DiegoCortez();
        //instacia del producto
        List<clsCompras_JosueMoran_DiegoCortez> producto = productoDAO.select();
        List<clsCompras_JosueMoran_DiegoCortez> producto2 = productoDAO.select2();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[9];
        for (int i = 0; i < producto.size(); i++) {
            dato[0] = Integer.toString(producto.get(i).getComid());
            dato[1] = Integer.toString(producto.get(i).getProvid());
            dato[2] = Integer.toString(producto.get(i).getComserie());
            dato[3] = Integer.toString(producto.get(i).getOrdid());
            dato[4] = producto.get(i).getComfechaemi();
            dato[5] = producto.get(i).getComfechavenci();
            dato[6] = Integer.toString(producto2.get(i).getProdid());
            dato[7] = Integer.toString(producto2.get(i).getOrdcantidad());
            dato[8] = Integer.toString(producto2.get(i).getOrdcosto());

            modelo.addRow(dato);
        }
    }

    public void buscarProducto() {
        clsCompras_JosueMoran_DiegoCortez productoAConsultar = new clsCompras_JosueMoran_DiegoCortez();
        daoCompras_JosueMoran_DiegoCortez productoDAO = new daoCompras_JosueMoran_DiegoCortez();
        clsCompras_JosueMoran_DiegoCortez productoAConsultar2 = new clsCompras_JosueMoran_DiegoCortez();
        daoCompras_JosueMoran_DiegoCortez productoDAO2 = new daoCompras_JosueMoran_DiegoCortez();
        productoAConsultar.setComid(Integer.parseInt(txtbuscado.getText()));
        productoAConsultar2.setComid(Integer.parseInt(txtbuscado.getText()));

        productoAConsultar = productoDAO.query(productoAConsultar);
        productoAConsultar2 = productoDAO2.query2(productoAConsultar2);

        txtProveedor.setText(String.valueOf(productoAConsultar.getProvid()));
        txtSerie.setText(String.valueOf(productoAConsultar.getComserie()));
        txtOrden.setText(String.valueOf(productoAConsultar.getOrdid()));
        txtProducto.setText(String.valueOf(productoAConsultar2.getProdid()));
        txtCantidad.setText(String.valueOf(productoAConsultar2.getOrdcantidad()));
        txtCosto.setText(String.valueOf(productoAConsultar2.getOrdcosto()));
        lblEmi.setText(productoAConsultar.getComfechaemi());
        lblVenci.setText(productoAConsultar.getComfechavenci());

    }

    public frmProcesoCompras() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();

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
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        label8 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtVenci = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        txtEmi = new com.toedter.calendar.JDateChooser();
        cbx_Proveedor = new javax.swing.JComboBox<>();
        txtProveedor = new javax.swing.JLabel();
        lblVenci = new javax.swing.JLabel();
        lblEmi = new javax.swing.JLabel();
        cbx_Orden = new javax.swing.JComboBox<>();
        txtOrden = new javax.swing.JLabel();
        txtProducto = new javax.swing.JLabel();
        cbx_Producto = new javax.swing.JComboBox<>();
        label12 = new javax.swing.JLabel();
        label13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtVenci1 = new com.toedter.calendar.JDateChooser();
        txtOrd1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        label14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtComid = new javax.swing.JTextField();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Compras");
        setPreferredSize(new java.awt.Dimension(1500, 700));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnEliminar.setText("Anular Compra");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 150, 30));

        btnRegistrar.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnRegistrar.setText("Comprar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 90, 30));

        btnBuscar.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnBuscar.setText("🔍");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 50, 30));

        btnModificar.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 110, 30));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label3.setText("CODIGO DE COMPRA");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 180, -1));

        txtbuscado.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 102, -1));

        btnLimpiar.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnLimpiar.setText("🗑️");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 40, 30));

        tablaVendedores.setBackground(new java.awt.Color(204, 255, 255));
        tablaVendedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 950, 660));

        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidad.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(0, 51, 255));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 220, 20));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label5.setText("Cantidad de Orden");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 13, -1));

        jButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, 30));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label6.setText("Numero De Serie");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label7.setText("Numero De orden");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        label4.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label4.setText("Codigo Proveedor");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 40, -1));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label8.setText("ID producto");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        txtCosto.setBackground(new java.awt.Color(255, 255, 255));
        txtCosto.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(0, 51, 255));
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCosto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 220, 20));

        label9.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label9.setText("Costo De Orden");
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        label10.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label10.setText("Emision");
        getContentPane().add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        label11.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label11.setText("Vencimiento");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        txtSerie.setBackground(new java.awt.Color(255, 255, 255));
        txtSerie.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        txtSerie.setForeground(new java.awt.Color(0, 51, 255));
        txtSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSerie.setActionCommand("<Not Set>");
        txtSerie.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 220, 20));
        getContentPane().add(txtVenci, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 220, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(51, 51, 51)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtEmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 220, -1));

        cbx_Proveedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbx_Proveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_Proveedor.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        cbx_Proveedor.setDoubleBuffered(true);
        cbx_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_ProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(cbx_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 160, 30));

        txtProveedor.setBackground(new java.awt.Color(255, 255, 255));
        txtProveedor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtProveedor.setForeground(new java.awt.Color(0, 51, 255));
        txtProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 30, 30));

        lblVenci.setBackground(new java.awt.Color(51, 51, 255));
        lblVenci.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblVenci.setForeground(new java.awt.Color(0, 51, 255));
        lblVenci.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVenci.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblVenci, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 220, 30));

        lblEmi.setBackground(new java.awt.Color(51, 51, 255));
        lblEmi.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblEmi.setForeground(new java.awt.Color(0, 51, 255));
        lblEmi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblEmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 220, 30));

        cbx_Orden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbx_Orden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_Orden.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        cbx_Orden.setDoubleBuffered(true);
        cbx_Orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_OrdenActionPerformed(evt);
            }
        });
        jPanel1.add(cbx_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 30));

        txtOrden.setBackground(new java.awt.Color(255, 255, 255));
        txtOrden.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtOrden.setForeground(new java.awt.Color(0, 51, 255));
        txtOrden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtOrden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 30, 30));

        txtProducto.setBackground(new java.awt.Color(153, 153, 153));
        txtProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtProducto.setForeground(new java.awt.Color(0, 51, 255));
        txtProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 30, 30));

        cbx_Producto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbx_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_Producto.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        cbx_Producto.setDoubleBuffered(true);
        cbx_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_ProductoActionPerformed(evt);
            }
        });
        jPanel1.add(cbx_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 500, 360));

        label12.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label12.setText("Vencimiento");
        getContentPane().add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        label13.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label13.setText("Vencimiento");
        getContentPane().add(label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("INGRESO DE DATOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));
        getContentPane().add(txtVenci1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 220, -1));

        txtOrd1.setBackground(new java.awt.Color(255, 255, 255));
        txtOrd1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        txtOrd1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOrd1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtOrd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrd1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtOrd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 220, 20));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label14.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label14.setText("Codigo Proveedor");
        jPanel2.add(label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setText("CODIGO DE LA COMPRA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, -1));
        jPanel2.add(txtComid, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 180, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 500, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        daoCompras_JosueMoran_DiegoCortez productoDAO = new daoCompras_JosueMoran_DiegoCortez();
        clsCompras_JosueMoran_DiegoCortez productoAEliminar = new clsCompras_JosueMoran_DiegoCortez();
        clsCompras_JosueMoran_DiegoCortez productoAEliminar2 = new clsCompras_JosueMoran_DiegoCortez();
        productoAEliminar.setComid(Integer.parseInt(txtbuscado.getText()));
        productoAEliminar2.setComid(Integer.parseInt(txtbuscado.getText()));

        String resp = JOptionPane.showInputDialog("Esta seguro de Eliminar esta Compra S/N");
        if (resp.equals("S") || resp.equals("s")) {
            
        int actualizarCompra = buscarid() - buscarcomid();
        
        System.out.println(actualizarCompra);
            System.out.println(buscarprodid());
        productoAEliminar.setProdexistenciaA(actualizarCompra);
        productoAEliminar.setComid2(buscarprodid());
        
            productoDAO.update3(productoAEliminar);
            productoDAO.delete2(productoAEliminar2);
            productoDAO.delete(productoAEliminar);
            llenadoDeTablas();

        } else {
            JOptionPane.showMessageDialog(null, "no se ha realizado la eliminacion");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        daoCompras_JosueMoran_DiegoCortez productoDAO = new daoCompras_JosueMoran_DiegoCortez();
        clsCompras_JosueMoran_DiegoCortez productoAInsertar = new clsCompras_JosueMoran_DiegoCortez();
        clsCompras_JosueMoran_DiegoCortez productoAInsertar2 = new clsCompras_JosueMoran_DiegoCortez();
        daoCompras_JosueMoran_DiegoCortez productoDAO2 = new daoCompras_JosueMoran_DiegoCortez();

        productoAInsertar.setComid(Integer.parseInt(txtComid.getText()));
        productoAInsertar.setProvid(Integer.parseInt(String.valueOf(cbx_Proveedor.getSelectedItem())));
        productoAInsertar.setComserie(Integer.parseInt(txtSerie.getText()));
        productoAInsertar.setOrdid(Integer.parseInt(String.valueOf(cbx_Orden.getSelectedItem())));
        productoAInsertar2.setProdid(Integer.parseInt(String.valueOf(cbx_Producto.getSelectedItem())));
        productoAInsertar2.setOrdcantidad(Integer.parseInt(txtCantidad.getText()));
        productoAInsertar2.setComid(Integer.parseInt(txtComid.getText()));
        productoAInsertar2.setOrdcosto(Integer.parseInt(txtCosto.getText()));
        String dia = Integer.toString(txtEmi.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(txtEmi.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(txtEmi.getCalendar().get(Calendar.YEAR));
        String fecha = (year + "-" + mes + "-" + dia);
        System.out.println(fecha);
        productoAInsertar.setComfechaemi(fecha);
        String dia1 = Integer.toString(txtVenci.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes1 = Integer.toString(txtVenci.getCalendar().get(Calendar.MONTH) + 1);
        String year1 = Integer.toString(txtVenci.getCalendar().get(Calendar.YEAR));
        String fecha2 = (year1 + "-" + mes1 + "-" + dia1);

        productoAInsertar.setComfechavenci(fecha2);

        int actualizarCompra = buscarid() + (Integer.parseInt(txtCantidad.getText()));
        System.out.println(buscarid());
        System.out.println(actualizarCompra);

        productoAInsertar.setProdexistenciaA(actualizarCompra);
        productoAInsertar.setComid2(Integer.parseInt(String.valueOf(cbx_Producto.getSelectedItem())));
        productoDAO.update3(productoAInsertar);
        productoDAO.insert(productoAInsertar);
        productoDAO2.insert2(productoAInsertar2);

        llenadoDeTablas();
        JOptionPane.showMessageDialog(null, "La Compra Ha sido Realizada con exito","Compra Realizada",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        // TODO add your handling code here:
        buscarProducto();


    }//GEN-LAST:event_btnBuscarActionPerformed
    private int buscarid() {
        clsCompras_JosueMoran_DiegoCortez productoAConsultar = new clsCompras_JosueMoran_DiegoCortez();
        daoCompras_JosueMoran_DiegoCortez productoDAO = new daoCompras_JosueMoran_DiegoCortez();
        productoAConsultar.setProdid(Integer.parseInt(String.valueOf(cbx_Producto.getSelectedItem())));
        productoAConsultar = productoDAO.query3(productoAConsultar);

        int existencia = productoAConsultar.getProdexistencia();
        System.out.println(existencia);
        return existencia;

    }
        private int buscarcomid() {
        clsCompras_JosueMoran_DiegoCortez productoAConsultar = new clsCompras_JosueMoran_DiegoCortez();
        daoCompras_JosueMoran_DiegoCortez productoDAO = new daoCompras_JosueMoran_DiegoCortez();
        productoAConsultar.setComid(Integer.parseInt(txtbuscado.getText()));
        productoAConsultar = productoDAO.query4(productoAConsultar);

        int existencia = productoAConsultar.getProdexistencia();
        System.out.println(existencia);
        return existencia;

    }
              private int buscarprodid() {
        clsCompras_JosueMoran_DiegoCortez productoAConsultar = new clsCompras_JosueMoran_DiegoCortez();
        daoCompras_JosueMoran_DiegoCortez productoDAO = new daoCompras_JosueMoran_DiegoCortez();
        productoAConsultar.setComid(Integer.parseInt(txtbuscado.getText()));
        productoAConsultar = productoDAO.query5(productoAConsultar);

        int existencia = productoAConsultar.getProdexistencia();
        System.out.println(existencia);
        return existencia;

    }
    

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        //primera instacia de las clases dao y cls
        daoCompras_JosueMoran_DiegoCortez productoDAO = new daoCompras_JosueMoran_DiegoCortez();
        clsCompras_JosueMoran_DiegoCortez productoAActualizar = new clsCompras_JosueMoran_DiegoCortez();
        //segunda instancia  de las clase dao y cls
        daoCompras_JosueMoran_DiegoCortez productoDAO2 = new daoCompras_JosueMoran_DiegoCortez();
        clsCompras_JosueMoran_DiegoCortez productoAActualizar2 = new clsCompras_JosueMoran_DiegoCortez();

        //recopilacion de datos para ser subida a la base 
        productoAActualizar.setComid(Integer.parseInt(txtbuscado.getText()));
        productoAActualizar2.setComid(Integer.parseInt(txtbuscado.getText()));
        productoAActualizar.setProvid(Integer.parseInt(String.valueOf(cbx_Proveedor.getSelectedItem())));
        productoAActualizar.setComserie(Integer.parseInt(txtSerie.getText()));
        productoAActualizar.setOrdid(Integer.parseInt(String.valueOf(cbx_Orden.getSelectedItem())));

        productoAActualizar2.setProdid(Integer.parseInt(String.valueOf(cbx_Producto.getSelectedItem())));
        productoAActualizar2.setOrdcantidad(Integer.parseInt(txtCantidad.getText()));
        productoAActualizar2.setOrdcosto(Integer.parseInt(txtCosto.getText()));
        String dia = Integer.toString(txtEmi.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(txtEmi.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(txtEmi.getCalendar().get(Calendar.YEAR));
        String fecha = (year + "-" + mes + "-" + dia);
        productoAActualizar.setComfechaemi(fecha);
        String dia1 = Integer.toString(txtVenci.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes1 = Integer.toString(txtVenci.getCalendar().get(Calendar.MONTH) + 1);
        String year1 = Integer.toString(txtVenci.getCalendar().get(Calendar.YEAR));
        String fecha2 = (year1 + "-" + mes1 + "-" + dia1);

        productoAActualizar.setComfechavenci(fecha2);

        int actualizarCompra = buscarid() + (Integer.parseInt(txtCantidad.getText()));

        System.out.println(actualizarCompra);

        productoAActualizar.setProdexistenciaA(actualizarCompra);
        productoAActualizar.setComid2(Integer.parseInt(String.valueOf(cbx_Producto.getSelectedItem())));
        productoDAO.update3(productoAActualizar);
        productoDAO.update(productoAActualizar);
        productoDAO2.update2(productoAActualizar2);

        llenadoDeTablas();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        txtProveedor.setText("");
        txtCantidad.setText("");
        txtbuscado.setText("");
        txtProveedor.setText("");
        txtOrden.setText("");
        txtProducto.setText("");
        txtCosto.setText("");
        txtEmi.cleanup();
        txtVenci.cleanup();
        txtSerie.setText("");
        lblEmi.setText("");
        lblVenci.setText("");
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
        JOptionPane.showMessageDialog(rootPane, "INGRESE EL CODIGO DE LA COMPRA QUE DESEA BUSCAR,ELIMINAR O MODIFICAR");
    }//GEN-LAST:event_jButton1ActionPerformed


    private void cbx_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_ProductoActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cbx_ProductoActionPerformed

    private void cbx_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_ProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_ProveedorActionPerformed

    private void txtOrd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrd1ActionPerformed

    private void cbx_OrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_OrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_OrdenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbx_Orden;
    private javax.swing.JComboBox<String> cbx_Producto;
    private javax.swing.JComboBox<String> cbx_Proveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lblEmi;
    private javax.swing.JLabel lblVenci;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtComid;
    private javax.swing.JTextField txtCosto;
    private com.toedter.calendar.JDateChooser txtEmi;
    private javax.swing.JTextField txtOrd1;
    private javax.swing.JLabel txtOrden;
    private javax.swing.JLabel txtProducto;
    private javax.swing.JLabel txtProveedor;
    private javax.swing.JTextField txtSerie;
    private com.toedter.calendar.JDateChooser txtVenci;
    private com.toedter.calendar.JDateChooser txtVenci1;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
