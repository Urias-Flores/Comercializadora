
package Views.Panels.Inicio;

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

public class Compras extends javax.swing.JPanel {

    private String[] Column = {"Codigo", "Producto", "Bodega", "Precio", "Cantidad", "ISV"};
    private DefaultTableModel model = new DefaultTableModel();
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
    
    public Compras() {
        initComponents();
        btnAgregarCompra.addMouseListener(ml);
        btnEliminarCompra.addMouseListener(ml);
        btnEditarCompra.addMouseListener(ml);
        btnSeleccionar.addMouseListener(ml);
        model.setColumnIdentifiers(Column);
        tbCompras.setModel(model);
        tbCompras.getColumn("Codigo").setPreferredWidth(90);
        tbCompras.getColumn("Producto").setPreferredWidth(550);
        tbCompras.getColumn("Bodega").setPreferredWidth(200);
        tbCompras.getColumn("Precio").setPreferredWidth(150);
        tbCompras.getColumn("Cantidad").setPreferredWidth(110);
        tbCompras.getColumn("ISV").setPreferredWidth(150);
    }
    
    private void UpdateData(){
        DecimalFormat d = new DecimalFormat("#.00");
        float Total = 0f, Subtotal = 0f, ISV = 0f;
        for(int i = 0; i < model.getRowCount(); i++){
            Subtotal += (Float.parseFloat(tbCompras.getValueAt(i, 3).toString()) * Float.parseFloat(tbCompras.getValueAt(i, 4).toString()) * 0.85);
            ISV += Float.parseFloat(tbCompras.getValueAt(i, 5).toString()) * Float.parseFloat(tbCompras.getValueAt(i, 4).toString());
            Total = Subtotal + ISV;
        }
        txtSubtotal.setText(d.format(Subtotal));
        txtISV.setText(d.format(ISV));
        txtTotal.setText(d.format(Total));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoCompra = new javax.swing.JComboBox<>();
        lbProvProd = new javax.swing.JLabel();
        txtproductor = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnEditarCompra = new javax.swing.JLabel();
        btnAgregarCompra = new javax.swing.JLabel();
        btnEliminarCompra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCompras = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtISV = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(190, 190, 190)));

        jLabel1.setFont(new java.awt.Font("Cascadia Code", 1, 22)); // NOI18N
        jLabel1.setText("Agregar nueva compra");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(383, 210));

        jLabel2.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel2.setText("A quien se realiza la compra");

        cmbTipoCompra.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        cmbTipoCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --", "Proveedor", "Productor" }));
        cmbTipoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoCompraActionPerformed(evt);
            }
        });

        lbProvProd.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        lbProvProd.setText("Seleccione");

        txtproductor.setEditable(false);
        txtproductor.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N

        btnSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/buscar_cliente.png"))); // NOI18N
        btnSeleccionar.setOpaque(true);
        btnSeleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeleccionarMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cascadia Code", 1, 20)); // NOI18N
        jLabel5.setText("Informacion de compra");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtproductor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbProvProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTipoCompra, 0, 347, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbProvProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtproductor)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(190, 190, 190)));

        jLabel6.setFont(new java.awt.Font("Cascadia Code", 1, 20)); // NOI18N
        jLabel6.setText("Agregar productos a la compra");

        btnEditarCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editar_compra.png"))); // NOI18N
        btnEditarCompra.setToolTipText("Editar compra");
        btnEditarCompra.setOpaque(true);
        btnEditarCompra.setPreferredSize(new java.awt.Dimension(38, 38));

        btnAgregarCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/agregar_compra.png"))); // NOI18N
        btnAgregarCompra.setToolTipText("Agrear compra");
        btnAgregarCompra.setOpaque(true);
        btnAgregarCompra.setPreferredSize(new java.awt.Dimension(38, 38));
        btnAgregarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarCompraMouseClicked(evt);
            }
        });

        btnEliminarCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar_compra.png"))); // NOI18N
        btnEliminarCompra.setToolTipText("Eliminar compra");
        btnEliminarCompra.setOpaque(true);
        btnEliminarCompra.setPreferredSize(new java.awt.Dimension(38, 38));
        btnEliminarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarCompraMouseClicked(evt);
            }
        });

        tbCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbCompras);

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

        jLabel14.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel14.setText("Lps.");

        jLabel15.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        jLabel15.setText("Total");

        txtTotal.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(49, 152, 54));
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtTotal.setText("0.0");

        jLabel3.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel3.setText("Subtotal");

        jLabel17.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel17.setText("Lps.");

        txtSubtotal.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        txtSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtSubtotal.setText("0.0");

        jLabel7.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel7.setText("Lps.");

        jLabel12.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel12.setText("ISV");

        txtISV.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        txtISV.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtISV.setText("0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(612, 612, 612)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtISV, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)))))
                        .addGap(18, 18, 18))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAgregarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEditarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtISV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoCompraActionPerformed
        if(!txtproductor.getText().isEmpty() && !txtproductor.getName().isEmpty()){
            Dialogs.ShowMessageDialog("Se eliminara la seleccion de productor/proveedor", Dialogs.ERRORMessage);
            txtproductor.setText("");
            txtproductor.setName("");
        }
        if(cmbTipoCompra.getSelectedIndex() == 1){lbProvProd.setText("Seleccione un proveedor");}
        else{lbProvProd.setText("Seleccione un productor");}
    }//GEN-LAST:event_cmbTipoCompraActionPerformed

    private void btnSeleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeleccionarMouseClicked
        int Seleccion = cmbTipoCompra.getSelectedIndex();
        if(Seleccion > 0){
            Map <Integer, String> tipo = new HashMap<>();
            tipo.put(1, "R");
            tipo.put(2, "P");
            ArrayList<String> values = Dialogs.ShowSeleccionarClientProduc(tipo.get(Seleccion));
            if(values.toArray().length > 0){
                txtproductor.setText(values.get(1));
                txtproductor.setName(values.get(0));
            }
        }else{
            Dialogs.ShowMessageDialog("Error, Seleccione a quien se realiza la compra", Dialogs.ERRORMessage);
        }
    }//GEN-LAST:event_btnSeleccionarMouseClicked

    private void btnAgregarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarCompraMouseClicked
        ArrayList<Object> list = Dialogs.ShowAgregarCompraDialog();
        if(list.toArray().length > 0){
            model.addRow(list.toArray());
            UpdateData();
        }
    }//GEN-LAST:event_btnAgregarCompraMouseClicked

    private void btnEliminarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarCompraMouseClicked
        int row = tbCompras.getSelectedRow();
        if(row > -1){
            if(Dialogs.ShowAdvertecimentDialog("Esta seguro de eliminar este producto")){
                model.removeRow(row);
                UpdateData();
            }
        }else{
            Dialogs.ShowMessageDialog("Error, Seleccione una venta de la lista", Dialogs.ERRORMessage);
        }
    }//GEN-LAST:event_btnEliminarCompraMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cmbTipoCompra.setSelectedIndex(0);
        txtproductor.setName("");
        txtproductor.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(verify()){
            
            Dialogs.ShowMessageDialog("Compra agregada exitosamente", Dialogs.COMPLETEMessage);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private boolean verify(){
        if(cmbTipoCompra.getSelectedIndex() == 0){
            Dialogs.ShowMessageDialog("Error, seleccion una fuente de compra", Dialogs.ERRORMessage);
            return false;
        }
        if(txtproductor.getText().isEmpty() || txtproductor.getName().isEmpty()){
            Dialogs.ShowMessageDialog("Error, seleccion un proveedor/productor", Dialogs.ERRORMessage);
            return false;
        }
        if(model.getRowCount() == 0){
            Dialogs.ShowMessageDialog("Error, debe seleccionar al menos un producto", Dialogs.ERRORMessage);
            return false;
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregarCompra;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel btnEditarCompra;
    private javax.swing.JLabel btnEliminarCompra;
    private javax.swing.JLabel btnSeleccionar;
    private javax.swing.JComboBox<String> cmbTipoCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbProvProd;
    private javax.swing.JTable tbCompras;
    private javax.swing.JLabel txtISV;
    private javax.swing.JLabel txtSubtotal;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JTextField txtproductor;
    // End of variables declaration//GEN-END:variables
}
