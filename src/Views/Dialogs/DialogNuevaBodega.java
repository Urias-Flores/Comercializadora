
package Views.Dialogs;

import Controllers.ControllerUsuario;
import Resources.Utilities;

public class DialogNuevaBodega extends javax.swing.JDialog {

    private int X, Y;
    private static boolean confirm = false;
    private final ControllerUsuario conUs;

    public boolean isConfirm() {
        return confirm;
    }
    
    public DialogNuevaBodega(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnCerrar.addMouseListener(Utilities.CloseBotonEfect);
        txtNombre.setText(Utilities.getUsuarioActual());
        conUs = new ControllerUsuario(txtNombre, txtNombre, txtNombre);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnBarra = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        nuevaBodegaLabel = new javax.swing.JLabel();
        ubicacionLabel = new javax.swing.JLabel();
        txtNombre = new javax.swing.JPasswordField();
        txtUbicacion = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtError = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();

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

        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cerrar.png"))); // NOI18N
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

        logoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bodega.png"))); // NOI18N

        nuevaBodegaLabel.setFont(new java.awt.Font("Cascadia Code", 1, 36)); // NOI18N
        nuevaBodegaLabel.setText("Nueva Bodega");

        ubicacionLabel.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        ubicacionLabel.setText("Ubicacion:");

        txtNombre.setFont(new java.awt.Font("Cascadia Code", 0, 20)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtUbicacion.setFont(new java.awt.Font("Cascadia Code", 0, 20)); // NOI18N

        btnConfirmar.setBackground(new java.awt.Color(0, 153, 51));
        btnConfirmar.setFont(new java.awt.Font("Cascadia Code", 1, 20)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/complete.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(153, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Cascadia Code", 1, 20)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtError.setBackground(new java.awt.Color(255, 255, 255));
        txtError.setFont(new java.awt.Font("Cascadia Code", 0, 16)); // NOI18N
        txtError.setForeground(new java.awt.Color(255, 0, 0));
        txtError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtError.setOpaque(true);

        nombreLabel.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        nombreLabel.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(nuevaBodegaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(nombreLabel)
                                    .addGap(39, 39, 39)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(ubicacionLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(nuevaBodegaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubicacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(203, 203, 203)
                .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBarraMousePressed
        X = evt.getX();
        Y = evt.getY();
    }//GEN-LAST:event_pnBarraMousePressed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        confirm = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        confirm = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(VerifyUser()){
            switch(conUs.IniciarSesion()){
                case -1:
                    txtError.setText("El usuario ingresado no existe");
                    break;
                case 0:
                    txtError.setText("La contraseña es incorrecta");
                    break;
                case 1:
                    if(txtUbicacion.getText().equals("CONFIRMAR")){
                        confirm = true;
                        this.setVisible(false);
                    }else{
                        txtError.setText("Debe escribir la palabra 'CONFIRMAR'");
                    }
                    break;
                default:
                    txtError.setText("ah ocurrido un error inesperado");
                    break;
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void pnBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - X, y - Y);
    }//GEN-LAST:event_pnBarraMouseDragged

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private boolean VerifyUser(){
        if(txtNombre.getText().isEmpty()){
            txtError.setText("Ha ocurrido un error al procesaro el usuario");
            return false;
        }
        if(txtNombre.getText().isEmpty()){
            txtError.setText("Debe ingresar su contraseña");
            return false;
        }
        if(txtUbicacion.getText().isEmpty()){
            txtError.setText("EL campo de confirmacion es obligatorio");
            return false;
        }
        return true;
    }
    
    
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
            java.util.logging.Logger.getLogger(DialogNuevaBodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogNuevaBodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogNuevaBodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogNuevaBodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DialogNuevaBodega dialog = new DialogNuevaBodega(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel nuevaBodegaLabel;
    private javax.swing.JPanel pnBarra;
    private javax.swing.JLabel txtError;
    private javax.swing.JPasswordField txtNombre;
    private javax.swing.JTextField txtUbicacion;
    private javax.swing.JLabel ubicacionLabel;
    // End of variables declaration//GEN-END:variables
}
