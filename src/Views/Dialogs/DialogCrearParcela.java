package Views.Dialogs;

import Controllers.ControllerParcela;
import Models.ModelFinca;
import Models.ModelParcela;
import Models.ModelProducto;
import Models.ModelTipoRiego;
import Models.ModelTipoSuelo;
import Views.Panels.Produccion.Fincas;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;

public class DialogCrearParcela extends javax.swing.JDialog {

    public Fincas fincas = new Fincas();
    private int ParcelaID;

    private int X, Y;
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
            l.setOpaque(true);
            l.setBackground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setBackground(new Color(39, 49, 65));
            l.setOpaque(true);
        }
    };

    public DialogCrearParcela(java.awt.Frame parent, boolean modal, int parcelaID) {
        super(parent, modal);
        this.ParcelaID = parcelaID;
        initComponents();
        Load();
        btnCerrar.addMouseListener(ml);
    }

    private void Load() {
        ModelFinca mf = new ModelFinca();
        ModelProducto mp = new ModelProducto();
        ModelTipoSuelo ts = new ModelTipoSuelo();
        ModelTipoRiego tr = new ModelTipoRiego();

        cmbFinca.setModel(mf.SelectModelFincaCmb());
        cmbProducto.setModel(mp.SelectModelProductoCmb());
        cmbSuelo.setModel(ts.SelectModelTipoSueloCmb());
        cmbRiego.setModel(tr.SelectModelTipoRiegoCmb());
        
        if (ParcelaID != 0) {
            ControllerParcela conParcela = new ControllerParcela();
            ArrayList arryList = conParcela.selectParcelaPorID(ParcelaID);
            
            ModelParcela mParcela = (ModelParcela) arryList.get(0);
            
            for (int i = 0; i < cmbFinca.getItemCount(); i++) {
                ModelFinca mFinca = (ModelFinca) cmbFinca.getItemAt(i);
                if (mFinca.getFincaID()== mParcela.getFincaID()) {
                    cmbFinca.setSelectedIndex(i);
                }
            }
            
            for (int i = 0; i < cmbProducto.getItemCount(); i++) {
                ModelProducto mProducto = (ModelProducto) cmbProducto.getItemAt(i);
                if (mProducto.getProductoID() == mParcela.getProductoID()) {
                    cmbProducto.setSelectedIndex(i);
                }
            }
            
            for (int i = 0; i < cmbSuelo.getItemCount(); i++) {
                ModelTipoSuelo mTSuelo = (ModelTipoSuelo) cmbSuelo.getItemAt(i);
                if (mTSuelo.getTipoSueloID()== mParcela.getTipoSueloID()) {
                    cmbSuelo.setSelectedIndex(i);
                }
            }
            
            for (int i = 0; i < cmbRiego.getItemCount(); i++) {
                ModelTipoRiego mTRiego = (ModelTipoRiego) cmbRiego.getItemAt(i);
                if (mTRiego.getTipoRiegoID()== mParcela.getTipoRiegoID()) {
                    cmbRiego.setSelectedIndex(i);
                }
            }
            
            txtExtension.setText(String.valueOf(mParcela.getExtension()));
            txtCantidad.setText(String.valueOf(mParcela.getCantidad()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnBarra = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        cmbFinca = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbSuelo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbRiego = new javax.swing.JComboBox<>();
        txtExtension = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));

        pnBarra.setBackground(new java.awt.Color(39, 49, 65));
        pnBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnBarraMouseDragged(evt);
            }
        });
        pnBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnBarraMousePressed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(39, 49, 65));
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrar.png"))); // NOI18N
        btnCerrar.setOpaque(true);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnBarraLayout = new javax.swing.GroupLayout(pnBarra);
        pnBarra.setLayout(pnBarraLayout);
        pnBarraLayout.setHorizontalGroup(
            pnBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnBarraLayout.setVerticalGroup(
            pnBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Creación de Parcela");

        btnSeleccionar.setBackground(new java.awt.Color(49, 152, 65));
        btnSeleccionar.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/agregar.png"))); // NOI18N
        btnSeleccionar.setText("Guardar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        cmbFinca.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        cmbFinca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione Finca --" }));

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Finca");

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Producto");

        cmbProducto.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione Finca --" }));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tipo de Suelo");

        cmbSuelo.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        cmbSuelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione Finca --" }));

        jLabel5.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Tipo de Riego");

        cmbRiego.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        cmbRiego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione Finca --" }));

        txtExtension.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        txtExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExtensionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Extensión");

        jLabel7.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Cantidad");

        txtCantidad.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtExtension, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbFinca, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProducto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbSuelo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbRiego, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFinca, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRiego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        ControllerParcela cp = new ControllerParcela();

        ModelFinca mf = (ModelFinca) cmbFinca.getSelectedItem();
        ModelProducto mp = (ModelProducto) cmbProducto.getSelectedItem();
        ModelTipoSuelo ts = (ModelTipoSuelo) cmbSuelo.getSelectedItem();
        ModelTipoRiego tr = (ModelTipoRiego) cmbRiego.getSelectedItem();

        if(mp.getTipoSueloID() == ts.getTipoSueloID()){
            if(mp.getTipoRiegoID() == tr.getTipoRiegoID()){
                boolean ok = false;
                if (ParcelaID != 0) {
                    ok = cp.UpdateParcela(ParcelaID, mf.getFincaID(), mp.getProductoID(), ts.getTipoSueloID(), tr.getTipoRiegoID(), Float.valueOf(txtExtension.getText()), Float.valueOf(txtCantidad.getText()));
                } else {
                    ok = cp.InsertParcela(mf.getFincaID(), mp.getProductoID(), ts.getTipoSueloID(), tr.getTipoRiegoID(), Float.parseFloat(txtExtension.getText()), Float.parseFloat(txtCantidad.getText()));
                }

                if (!ok) {
                    Dialogs.ShowMessageDialog("Guardado exitosamente", Dialogs.COMPLETEMessage);
                    fincas.LoadTableParcelas();
                    this.dispose();
                } else {
                    Dialogs.ShowMessageDialog("Ha ocurrido un error", Dialogs.ERRORMessage);
                }
            }else{
                Dialogs.ShowMessageDialog("Tipo de riego de producto y parcela no coinciden", Dialogs.ERRORMessage);
            }
        }else{
            Dialogs.ShowMessageDialog("Tipo de suelo de producto y parcela no coinciden", Dialogs.ERRORMessage);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void pnBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBarraMousePressed
        X = evt.getX();
        Y = evt.getY();
    }//GEN-LAST:event_pnBarraMousePressed

    private void pnBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - X, y - Y);
    }//GEN-LAST:event_pnBarraMouseDragged

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void txtExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExtensionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExtensionActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogCrearParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogCrearParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogCrearParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogCrearParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DialogCrearParcela dialog = new DialogCrearParcela(new javax.swing.JFrame(), true, Integer.BYTES);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<Object> cmbFinca;
    private javax.swing.JComboBox<Object> cmbProducto;
    private javax.swing.JComboBox<Object> cmbRiego;
    private javax.swing.JComboBox<Object> cmbSuelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnBarra;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtExtension;
    // End of variables declaration//GEN-END:variables
}
