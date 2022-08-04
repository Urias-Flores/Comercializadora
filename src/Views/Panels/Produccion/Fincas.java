package Views.Panels.Produccion;

import Controllers.ControllerFinca;
import Controllers.ControllerParcela;
import Controllers.ControllerProductor;
import Views.Dialogs.DialogCrearFinca;
import Views.Dialogs.DialogCrearParcela;
import Views.Main;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Fincas extends javax.swing.JPanel {
    
    private ControllerFinca conFinc;
    private ControllerParcela controllerParcela;
    private ControllerProductor controllerProductor = new ControllerProductor();
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
    private FocusListener fl = new FocusListener(){
        @Override
        public void focusGained(FocusEvent e) {
           JTextField jt = (JTextField) e.getComponent();
           if(jt.getText().equals("Nombre...")){
               jt.setText("");
               jt.setForeground(Color.BLACK);
           }
        }

        @Override
        public void focusLost(FocusEvent e) {
           JTextField jt = (JTextField) e.getComponent();
           if(jt.getText().isEmpty()){
               jt.setText("Nombre...");
               jt.setForeground(new Color(190, 190, 190));
           }
        }
    };
   
    public Fincas() {
        initComponents();
        LoadTableFincas();
        LoadTableParcelas();
        Load();
        lbAgregarFinca.addMouseListener(ml);
        lbActualizarFincas.addMouseListener(ml);
        lbAgregarParcelas.addMouseListener(ml);
        lbActualizarParcelas.addMouseListener(ml);
        txtBuscar.addFocusListener(fl);
    }
    
    private void Load(){
        cmbProductores.setModel(controllerProductor.setProductorCmb());
        cmbFincas.setModel(conFinc.setFincaCmb());
    }
    private void LoadTableFincas() {
        conFinc = new ControllerFinca();
        tbFincas.setModel(conFinc.SelectModelFinca());
        tbFincas.getColumn("ID").setPreferredWidth(10);
        tbFincas.getColumn("Nombre").setPreferredWidth(140);
        tbFincas.getColumn("Propietario").setPreferredWidth(200);
    }
    
    private void LoadTableParcelas() {
        controllerParcela = new ControllerParcela();
        tbParcelas.setModel(controllerParcela.SelectModelParcelas()); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFincas = new javax.swing.JTable();
        btnEditarFinca = new javax.swing.JButton();
        btnEliminarFinca = new javax.swing.JButton();
        lbActualizarFincas = new javax.swing.JLabel();
        lbAgregarFinca = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbParcelas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbProductores = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbFincas = new javax.swing.JComboBox<>();
        btnCargar = new javax.swing.JButton();
        btnEditarParcelar = new javax.swing.JButton();
        btnEliminarParcela = new javax.swing.JButton();
        lbActualizarParcelas = new javax.swing.JLabel();
        lbAgregarParcelas = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Cascadia Code", 1, 22)); // NOI18N
        jLabel7.setText("Fincas");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/buscar.png"))); // NOI18N

        txtBuscar.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(190, 190, 190));
        txtBuscar.setText("Nombre...");

        tbFincas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbFincas);

        btnEditarFinca.setBackground(new java.awt.Color(49, 152, 65));
        btnEditarFinca.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnEditarFinca.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarFinca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editar2.png"))); // NOI18N
        btnEditarFinca.setText("Editar");
        btnEditarFinca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFincaActionPerformed(evt);
            }
        });

        btnEliminarFinca.setBackground(new java.awt.Color(144, 40, 40));
        btnEliminarFinca.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnEliminarFinca.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarFinca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar.png"))); // NOI18N
        btnEliminarFinca.setText("Eliminar");
        btnEliminarFinca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFincaActionPerformed(evt);
            }
        });

        lbActualizarFincas.setBackground(new java.awt.Color(255, 255, 255));
        lbActualizarFincas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbActualizarFincas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/actualizar.png"))); // NOI18N
        lbActualizarFincas.setToolTipText("Actualizar");
        lbActualizarFincas.setOpaque(true);

        lbAgregarFinca.setBackground(new java.awt.Color(255, 255, 255));
        lbAgregarFinca.setFont(new java.awt.Font("Cascadia Code", 0, 16)); // NOI18N
        lbAgregarFinca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAgregarFinca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/agregar_32.png"))); // NOI18N
        lbAgregarFinca.setToolTipText("Agregar");
        lbAgregarFinca.setOpaque(true);
        lbAgregarFinca.setPreferredSize(new java.awt.Dimension(38, 32));
        lbAgregarFinca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAgregarFincaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditarFinca, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarFinca, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbAgregarFinca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbActualizarFincas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbActualizarFincas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAgregarFinca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarFinca, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarFinca, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(190, 190, 190)));

        jLabel8.setFont(new java.awt.Font("Cascadia Code", 1, 22)); // NOI18N
        jLabel8.setText("Control de parcelas o lotes");

        tbParcelas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbParcelas);

        jLabel9.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel9.setText("Filtrar");

        jLabel10.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel10.setText("Productor");

        cmbProductores.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        cmbProductores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- seleccione --" }));

        jLabel11.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jLabel11.setText("Finca");

        cmbFincas.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        cmbFincas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- seleccione --" }));

        btnCargar.setBackground(new java.awt.Color(49, 152, 65));
        btnCargar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnCargar.setForeground(new java.awt.Color(255, 255, 255));
        btnCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cargar.png"))); // NOI18N
        btnCargar.setText("Cargar");

        btnEditarParcelar.setBackground(new java.awt.Color(49, 152, 65));
        btnEditarParcelar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnEditarParcelar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarParcelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editar2.png"))); // NOI18N
        btnEditarParcelar.setText("Editar");
        btnEditarParcelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarParcelarActionPerformed(evt);
            }
        });

        btnEliminarParcela.setBackground(new java.awt.Color(144, 40, 40));
        btnEliminarParcela.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnEliminarParcela.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar.png"))); // NOI18N
        btnEliminarParcela.setText("Eliminar");
        btnEliminarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarParcelaActionPerformed(evt);
            }
        });

        lbActualizarParcelas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbActualizarParcelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/actualizar.png"))); // NOI18N
        lbActualizarParcelas.setToolTipText("Actualizar");

        lbAgregarParcelas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAgregarParcelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/agregar_32.png"))); // NOI18N
        lbAgregarParcelas.setToolTipText("Agregar");
        lbAgregarParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAgregarParcelasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbAgregarParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbActualizarParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEliminarParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarParcelar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProductores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFincas, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProductores, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbActualizarParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAgregarParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbFincas)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarParcelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarFincaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFincaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarFincaActionPerformed

    private void btnEliminarFincaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFincaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarFincaActionPerformed

    private void btnEliminarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarParcelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarParcelaActionPerformed

    private void btnEditarParcelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarParcelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarParcelarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tbParcelas.getModel());
        java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);
        filters.add(RowFilter.regexFilter(cmbProductores.getSelectedItem().toString(), 2));
        filters.add(RowFilter.regexFilter(cmbFincas.getSelectedItem().toString(), 1));
        RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
        sorter.setRowFilter(serviceFilter);
        tbParcelas.setRowSorter(sorter);
    }//GEN-LAST:event_btnCargarActionPerformed

    private void lbAgregarFincaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAgregarFincaMouseClicked
        Main m = new Main();
        DialogCrearFinca cf = new DialogCrearFinca(m, true);
        cf.setVisible(true);
    }//GEN-LAST:event_lbAgregarFincaMouseClicked

    private void lbAgregarParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAgregarParcelasMouseClicked
        Main m = new Main();
        DialogCrearParcela cp = new DialogCrearParcela(m, true);
        cp.setVisible(true);
    }//GEN-LAST:event_lbAgregarParcelasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEditarFinca;
    private javax.swing.JButton btnEditarParcelar;
    private javax.swing.JButton btnEliminarFinca;
    private javax.swing.JButton btnEliminarParcela;
    private javax.swing.JComboBox<String> cmbFincas;
    private javax.swing.JComboBox<String> cmbProductores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbActualizarFincas;
    private javax.swing.JLabel lbActualizarParcelas;
    private javax.swing.JLabel lbAgregarFinca;
    private javax.swing.JLabel lbAgregarParcelas;
    private javax.swing.JTable tbFincas;
    private javax.swing.JTable tbParcelas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
