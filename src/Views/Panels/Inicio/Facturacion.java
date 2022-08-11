
package Views.Panels.Inicio;

import Controllers.ControllerInsumo;
import Controllers.ControllerInsumoDetalle;
import Controllers.ControllerVenta;
import Controllers.ControllerVentaDetalle;
import Views.Dialogs.Dialogs;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Facturacion extends javax.swing.JPanel {

    private ControllerVentaDetalle conVD = new ControllerVentaDetalle();
    private ControllerInsumoDetalle conID = new ControllerInsumoDetalle();
    private ControllerVenta controllerVenta;
    private ControllerInsumo controllerInsumo;
    
    private MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setBackground(new Color(220, 220, 220));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setBackground(Color.white);
        }
    };
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columns = {"Codigo", "Producto", "Bodega", "Precio", "Cantidad", "ISV", "Descuento %"};
    
    public Facturacion() {
        initComponents();
        controllerVenta = new ControllerVenta(txtProducCliente);
        controllerInsumo = new ControllerInsumo(txtProducCliente);
        btnAgregarVenta.addMouseListener(ml);
        btnEliminarVenta.addMouseListener(ml);
        btnEditarVenta.addMouseListener(ml);
        btnSeleccionar.addMouseListener(ml);
        model.setColumnIdentifiers(columns);
        tbVenta.setModel(model);
        tbVenta.getColumn("Codigo").setPreferredWidth(90);
        tbVenta.getColumn("Producto").setPreferredWidth(550);
        tbVenta.getColumn("Bodega").setPreferredWidth(200);
        tbVenta.getColumn("Precio").setPreferredWidth(150);
        tbVenta.getColumn("Cantidad").setPreferredWidth(110);
        tbVenta.getColumn("ISV").setPreferredWidth(150);
        tbVenta.getColumn("Descuento %").setPreferredWidth(150);
        txtProducCliente.setName("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoVenta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtProducCliente = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregarVenta = new javax.swing.JLabel();
        btnEliminarVenta = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnEditarVenta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtISV = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(190, 190, 190)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(190, 190, 190)));

        jLabel5.setFont(new java.awt.Font("Cascadia Code", 1, 20)); // NOI18N
        jLabel5.setText("Informacion de factura");

        jLabel2.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel2.setText("Tipo de venta");

        cmbTipoVenta.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        cmbTipoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --", "Factura normal", "Factura de insumo" }));
        cmbTipoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoVentaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel4.setText("Cliente/Productor");

        txtProducCliente.setEditable(false);
        txtProducCliente.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N

        btnSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/buscar_cliente.png"))); // NOI18N
        btnSeleccionar.setOpaque(true);
        btnSeleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeleccionarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtProducCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addComponent(cmbTipoVenta, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProducCliente)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbVenta);

        btnEditar.setBackground(new java.awt.Color(49, 152, 65));
        btnEditar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/complete.png"))); // NOI18N
        btnEditar.setText("Facturar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(144, 40, 40));
        btnCancelar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/limpiar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/agregar_compra.png"))); // NOI18N
        btnAgregarVenta.setToolTipText("Agrear compra");
        btnAgregarVenta.setOpaque(true);
        btnAgregarVenta.setPreferredSize(new java.awt.Dimension(38, 38));
        btnAgregarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarVentaMouseClicked(evt);
            }
        });

        btnEliminarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar_compra.png"))); // NOI18N
        btnEliminarVenta.setToolTipText("Eliminar compra");
        btnEliminarVenta.setOpaque(true);
        btnEliminarVenta.setPreferredSize(new java.awt.Dimension(38, 38));
        btnEliminarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarVentaMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Cascadia Code", 1, 20)); // NOI18N
        jLabel9.setText("Agregue productos a su factura");

        btnEditarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editar_compra.png"))); // NOI18N
        btnEditarVenta.setToolTipText("Editar compra");
        btnEditarVenta.setOpaque(true);
        btnEditarVenta.setPreferredSize(new java.awt.Dimension(38, 38));

        jLabel3.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel3.setText("Subtotal");

        txtSubtotal.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        txtSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtSubtotal.setText("0.0");

        jLabel7.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel7.setText("Lps.");

        jLabel8.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel8.setText("ISV");

        txtISV.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        txtISV.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtISV.setText("0.0");

        jLabel11.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel11.setText("Lps.");

        jLabel12.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel12.setText("Descuento");

        txtDescuento.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtDescuento.setText("0.0");

        jLabel14.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel14.setText("Lps.");

        jLabel15.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        jLabel15.setText("Total");

        txtTotal.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(49, 152, 54));
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtTotal.setText("0.0");

        jLabel17.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel17.setText("Lps.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtISV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel12)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(39, 39, 39)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel17))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAgregarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEditarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtISV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cascadia Code", 1, 22)); // NOI18N
        jLabel1.setText("Realizar nueva factura");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarVentaMouseClicked
        Map <Integer, String> tipo = new HashMap<>();
        tipo.put(1, "C");
        tipo.put(2, "P");
        if(cmbTipoVenta.getSelectedIndex() > 0){
            if(!txtProducCliente.getName().isEmpty()){
                ArrayList<Object> list = Dialogs.ShowAgregarVentaDialog(txtProducCliente.getName(), tipo.get(cmbTipoVenta.getSelectedIndex()));
                if(list.toArray().length > 0){
                    model.addRow(list.toArray());
                    UpdateData();
                }
            }else{
                ArrayList<Object> list = Dialogs.ShowAgregarVentaDialog("NULL", tipo.get(cmbTipoVenta.getSelectedIndex()));
                if(list.toArray().length > 0){
                    model.addRow(list.toArray());
                    UpdateData();
                }
            }
        }else{
            Dialogs.ShowMessageDialog("Seleccione una tipo de venta", Dialogs.ERRORMessage);
            cmbTipoVenta.requestFocus();
            cmbTipoVenta.setPopupVisible(true);
        }
    }//GEN-LAST:event_btnAgregarVentaMouseClicked

    private void UpdateData(){
        DecimalFormat d = new DecimalFormat("#.00");
        float subtotal = 0f, ISV = 0f, Descuento = 0f, Total = 0f;
        for(int i = 0; i < model.getRowCount(); i++){
            subtotal += Float.parseFloat(tbVenta.getValueAt(i, 3).toString()) * Float.parseFloat(tbVenta.getValueAt(i, 4).toString()) * 0.85;
            ISV += Float.parseFloat(tbVenta.getValueAt(i, 5).toString());
            Descuento += Float.parseFloat(tbVenta.getValueAt(i, 3).toString()) * Float.parseFloat(tbVenta.getValueAt(i, 6).toString()) * 0.1;
            Total = subtotal + ISV - Descuento;
        }
        txtSubtotal.setText(d.format(subtotal));
        txtISV.setText(d.format(ISV));
        txtDescuento.setText(d.format(Descuento));
        txtTotal.setText(d.format(Total));
    }
    
    private void btnSeleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeleccionarMouseClicked
        int Seleccion = cmbTipoVenta.getSelectedIndex();
        if(Seleccion > 0){
            Map <Integer, String> tipo = new HashMap<>();
            tipo.put(1, "C");
            tipo.put(2, "P");
            ArrayList<String> values = Dialogs.ShowSeleccionarClientProduc(tipo.get(Seleccion));
            if(values.toArray().length > 0){
                txtProducCliente.setText(values.get(1));
                txtProducCliente.setName(values.get(0));
            }
        }else{
            Dialogs.ShowMessageDialog("Error, Seleccione un tipo de venta", Dialogs.ERRORMessage);
        }
    }//GEN-LAST:event_btnSeleccionarMouseClicked

    private void cmbTipoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoVentaActionPerformed
        if(!txtProducCliente.getText().isEmpty() && !txtProducCliente.getName().isEmpty()){
            Dialogs.ShowMessageDialog("Se eliminara la seleccion de cliente/productor", Dialogs.ERRORMessage);
            txtProducCliente.setText("");
            txtProducCliente.setName("");
        }
    }//GEN-LAST:event_cmbTipoVentaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        clear();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void clear(){
        cmbTipoVenta.setSelectedIndex(0);
        txtProducCliente.setName("");
        txtProducCliente.setText("");
        txtSubtotal.setText("0.0");
        txtISV.setText("0.0");
        txtDescuento.setText("0.0");
        txtTotal.setText("0.0");
        model.setRowCount(0);
    }
    
    private void btnEliminarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarVentaMouseClicked
        System.out.println("Se precioono");
        int row = tbVenta.getSelectedRow();
        if(row > -1){
            if(Dialogs.ShowAdvertecimentDialog("Esta seguro de eliminar este producto")){
                model.removeRow(row);
                UpdateData();
            }
        }else{
            Dialogs.ShowMessageDialog("Error, Seleccione una venta de la lista", Dialogs.ERRORMessage);
        }
    }//GEN-LAST:event_btnEliminarVentaMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(verify()){
            if(cmbTipoVenta.getSelectedIndex() == 1){
                String VentaID = controllerVenta.InsertVenta()+"";
                for(int i = 0; i < model.getRowCount(); i++){
                    String ProductoID = tbVenta.getValueAt(i, 0).toString();
                    String Bodega = tbVenta.getValueAt(i, 2).toString();
                    String Precio = tbVenta.getValueAt(i, 3).toString();
                    String Cantidad = tbVenta.getValueAt(i, 4).toString();
                    String ISV = tbVenta.getValueAt(i, 5).toString();
                    String Descuento = tbVenta.getValueAt(i, 6).toString();
                    conVD.InsertVenta(VentaID, ProductoID, Bodega, Cantidad, Precio, ISV, Descuento);
                } 
            }else if (cmbTipoVenta.getSelectedIndex() == 2){
                int InsumoID = controllerInsumo.InsertInsumo();
                for(int i = 0; i < model.getRowCount(); i++){
                    String ProductoID = tbVenta.getValueAt(i, 0).toString();
                    String Bodega = tbVenta.getValueAt(i, 2).toString();
                    String Precio = tbVenta.getValueAt(i, 3).toString();
                    String Cantidad = tbVenta.getValueAt(i, 4).toString();
                    String ISV = tbVenta.getValueAt(i, 5).toString();
                    String Descuento = tbVenta.getValueAt(i, 6).toString();
                    conID.InsertInsumoDetalle(InsumoID, ProductoID, Bodega, Cantidad, Precio, ISV, Descuento);
                } 
            }
            Dialogs.ShowMessageDialog("Factura realizada con exito", Dialogs.COMPLETEMessage);
            clear();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public boolean verify(){
        if(cmbTipoVenta.getSelectedIndex() == 0){
            Dialogs.ShowMessageDialog("Error, seleccione un tipo de venta", Dialogs.ERRORMessage);
            return false;
        }
        if(txtProducCliente.getText().isEmpty() || txtProducCliente.getName().isEmpty()){
            if(!Dialogs.ShowAdvertecimentDialog("¿Desea continuar sin un cliente?")){
                return false;
            }
        }
        if(model.getRowCount() == 0){
            Dialogs.ShowMessageDialog("Error, seleccione al menos un producto", Dialogs.ERRORMessage);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregarVenta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel btnEditarVenta;
    private javax.swing.JLabel btnEliminarVenta;
    private javax.swing.JLabel btnSeleccionar;
    private javax.swing.JComboBox<String> cmbTipoVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVenta;
    private javax.swing.JLabel txtDescuento;
    private javax.swing.JLabel txtISV;
    private javax.swing.JTextField txtProducCliente;
    private javax.swing.JLabel txtSubtotal;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
