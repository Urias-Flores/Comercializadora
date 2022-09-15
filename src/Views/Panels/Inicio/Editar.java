
package Views.Panels.Inicio;

import Controllers.ControllerArqueo;
import Controllers.ControllerCompra;
import Controllers.ControllerInsumo;
import Controllers.ControllerVenta;
import Views.Dialogs.Dialogs;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Editar extends javax.swing.JPanel {

    private ControllerVenta conFac = new ControllerVenta();
    private ControllerCompra conCom = new ControllerCompra();
    private ControllerInsumo conIns = new ControllerInsumo();
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
    private FocusListener fl = new FocusListener(){
        @Override
        public void focusGained(FocusEvent e) {
           JTextField jt = (JTextField) e.getComponent();
           if(jt.getText().equals("buscar...")){
               jt.setText("");
               jt.setForeground(Color.BLACK);
           }
        }

        @Override
        public void focusLost(FocusEvent e) {
           JTextField jt = (JTextField) e.getComponent();
           if(jt.getText().isEmpty()){
               jt.setText("buscar...");
               jt.setForeground(new Color(190, 190, 190));
           }
        }
    };
    
    public Editar() {
        initComponents();
        txtBuscar.addFocusListener(fl);
        btnActualizar.addMouseListener(ml);
        Load();
    }
    
    private void Load(){
        String[] Columns = {"Producto", "Cantidad"};
        model.setColumnIdentifiers(Columns);
        tbPreeliminar.setModel(model);
        tbPreeliminar.getColumn("Producto").setPreferredWidth(300);
        tbPreeliminar.getColumn("Cantidad").setPreferredWidth(100);
        tbDetalles.setModel(conFac.getTotalVentasCompras());
        tbDetalles.getColumn("Codigo").setPreferredWidth(50);
        tbDetalles.getColumn("Usuario").setPreferredWidth(150);
        tbDetalles.getColumn("Titular").setPreferredWidth(250);
        tbDetalles.getColumn("Tipo").setPreferredWidth(80);
        tbDetalles.getColumn("Fecha/Hora").setPreferredWidth(300);
        tbDetalles.getColumn("Total").setPreferredWidth(120);
        
        float TotalVentas = 0;
        float TotalCompras = 0;
        float Ganancias = 0;
        for(int i = 0; i < tbDetalles.getRowCount(); i++){
            String type = tbDetalles.getValueAt(i, 3).toString();
            float valor = Float.parseFloat(tbDetalles.getValueAt(i, 5).toString());
            if(type.equals("COMPRA")){
                TotalCompras += valor;
            }else {
                TotalVentas += valor;
            }
        }
        Ganancias = TotalVentas - TotalCompras;
        lbVentas.setText(String.valueOf(TotalVentas));
        lbCompras.setText(String.valueOf(TotalCompras));
        lbGanancias.setText(String.valueOf(Ganancias));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbVentas = new javax.swing.JLabel();
        lbCompras = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbGanancias = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalles = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPreeliminar = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(190, 190, 190)));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 20)); // NOI18N
        jLabel1.setText("Resumen del dia");

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 0, 20)); // NOI18N
        jLabel2.setText("Total de ventas hoy");

        lbVentas.setFont(new java.awt.Font("Cascadia Mono", 0, 65)); // NOI18N
        lbVentas.setForeground(new java.awt.Color(49, 152, 54));
        lbVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/entradas.png"))); // NOI18N
        lbVentas.setText("0.0");
        lbVentas.setIconTextGap(12);

        lbCompras.setFont(new java.awt.Font("Cascadia Mono", 0, 65)); // NOI18N
        lbCompras.setForeground(new java.awt.Color(140, 40, 40));
        lbCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salidas.png"))); // NOI18N
        lbCompras.setText("0.0");
        lbCompras.setIconTextGap(12);

        jLabel5.setFont(new java.awt.Font("Cascadia Mono", 0, 20)); // NOI18N
        jLabel5.setText("Total de compras hoy");

        lbGanancias.setFont(new java.awt.Font("Cascadia Mono", 0, 65)); // NOI18N
        lbGanancias.setForeground(new java.awt.Color(49, 152, 54));
        lbGanancias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Ganancias.png"))); // NOI18N
        lbGanancias.setText("0.0");
        lbGanancias.setIconTextGap(12);

        jLabel10.setFont(new java.awt.Font("Cascadia Mono", 0, 20)); // NOI18N
        jLabel10.setText("Total de ganancias hoy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGanancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(lbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbDetalles.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        tbDetalles.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetallesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalles);

        jLabel6.setFont(new java.awt.Font("Cascadia Mono", 1, 20)); // NOI18N
        jLabel6.setText("Historial de acciones");

        btnEliminar.setBackground(new java.awt.Color(144, 40, 40));
        btnEliminar.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/buscar.png"))); // NOI18N

        txtBuscar.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(190, 190, 190));
        txtBuscar.setText("buscar...");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/actualizar.png"))); // NOI18N
        btnActualizar.setToolTipText("Actualizar");
        btnActualizar.setOpaque(true);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(190, 190, 190)));

        jLabel8.setFont(new java.awt.Font("Cascadia Mono", 1, 20)); // NOI18N
        jLabel8.setText("Vistas previa");

        tbPreeliminar.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        tbPreeliminar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbPreeliminar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int row = tbDetalles.getSelectedRow();
        if(row > -1){
            String type = tbDetalles.getValueAt(row, 3).toString();
            int ID = Integer.parseInt(tbDetalles.getValueAt(row, 0).toString());
            int result = 0;
            switch(type){
                case "INSUMO":
                    result = conIns.DeleteInsumo(ID);
                    break;
                case "VENTA":
                    result = conFac.DeleteVenta(ID);
                    break;
                case "COMPRA":
                    result = conCom.DeleteCompra(ID);
                    break;
            }
            if(result > 0){
                Dialogs.ShowMessageDialog("Compra eliminado con exito", Dialogs.COMPLETEMessage);
            }else{
                Dialogs.ShowMessageDialog("Ups, ha ocurrido un error inesperado", Dialogs.ERRORMessage);
            }
            model.setRowCount(0);
            Load();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        TableRowSorter s = new TableRowSorter(tbDetalles.getModel());
        tbDetalles.setRowSorter(s);
        s.setRowFilter(RowFilter.regexFilter(txtBuscar.getText(), 2));
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        Load();
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void tbDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetallesMouseClicked
        int row = tbDetalles.getSelectedRow();
        if(row > -1){
            String type = tbDetalles.getValueAt(row, 3).toString();
            int ID = Integer.parseInt(tbDetalles.getValueAt(row, 0).toString());
            model.setRowCount(0);
            switch(type){
                case "INSUMO":
                    model = conIns.getPreelimar(ID);
                    tbPreeliminar.setModel(model);
                    break;
                case "VENTA":
                    model = conFac.getPreeliminar(ID);
                    tbPreeliminar.setModel(model);
                    break;
                case "COMPRA":
                    model = conCom.getPreeliminar(ID);
                    tbPreeliminar.setModel(model);
                    break;
            }
            tbPreeliminar.getColumn("Producto").setPreferredWidth(300);
            tbPreeliminar.getColumn("Cantidad").setPreferredWidth(100);
        }
    }//GEN-LAST:event_tbDetallesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCompras;
    private javax.swing.JLabel lbGanancias;
    private javax.swing.JLabel lbVentas;
    private javax.swing.JTable tbDetalles;
    private javax.swing.JTable tbPreeliminar;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
