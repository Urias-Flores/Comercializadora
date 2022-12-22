package Views;

import Resource.Utilities;
import ViewsControllers.LoginViewController;
import javax.swing.ImageIcon;

public class Login extends javax.swing.JFrame {

    private int X, Y;
    private LoginViewController loginVC;

    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Icons/logo.png")).getImage());
        btnClose.addMouseListener(Utilities.getMLButtonClose());
        btnIniciarSesion.addMouseListener(Utilities.getMLGeneralButton());
        txtNombre.addFocusListener(Utilities.getFLPlaceHolderEfect());
        loginVC = new LoginViewController(this, txtNombre, txtContrasena, cbRecordarme, lbError, btnIniciarSesion, lbOlvidaste);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JLabel();
        cbRecordarme = new javax.swing.JCheckBox();
        lbOlvidaste = new javax.swing.JLabel();
        pnBarra = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        lbError = new javax.swing.JLabel();
        txtCargando = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(3, 57, 103));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 0, 490, 618));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 42)); // NOI18N
        jLabel1.setText("Iniciar Sesion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 60, 495, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        jLabel2.setText("Nombre de usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 163, 495, -1));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(180, 180, 180));
        txtNombre.setText("Escribe tu nombre de usuario...");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 196, 495, 40));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 254, 495, -1));

        txtContrasena.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 287, 495, 40));

        btnIniciarSesion.setBackground(new java.awt.Color(3, 57, 103));
        btnIniciarSesion.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIniciarSesion.setText("Iniciar sesion");
        btnIniciarSesion.setOpaque(true);
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
        });
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 238, 40));

        cbRecordarme.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cbRecordarme.setText("Recordarme");
        jPanel1.add(cbRecordarme, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 495, 38));

        lbOlvidaste.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbOlvidaste.setText("¿olvidaste tu contraseña?");
        lbOlvidaste.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lbOlvidaste, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 238, 32));

        pnBarra.setBackground(new java.awt.Color(255, 255, 255));
        pnBarra.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(220, 220, 220)));
        pnBarra.setPreferredSize(new java.awt.Dimension(1120, 36));
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

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/closeBlue.png"))); // NOI18N
        btnClose.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(220, 220, 220)));
        btnClose.setOpaque(true);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnBarraLayout = new javax.swing.GroupLayout(pnBarra);
        pnBarra.setLayout(pnBarraLayout);
        pnBarraLayout.setHorizontalGroup(
            pnBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBarraLayout.createSequentialGroup()
                .addComponent(btnClose)
                .addGap(0, 1087, Short.MAX_VALUE))
        );
        pnBarraLayout.setVerticalGroup(
            pnBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel1.add(pnBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 36));

        lbError.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbError.setForeground(new java.awt.Color(255, 0, 0));
        lbError.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lbError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 490, 32));

        txtCargando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtCargando, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked
        IniciarSesion();
    }//GEN-LAST:event_btnIniciarSesionMouseClicked

    private void pnBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBarraMousePressed
        X = evt.getX();
        Y = evt.getY();
    }//GEN-LAST:event_pnBarraMousePressed

    private void pnBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - X, y - Y);
    }//GEN-LAST:event_pnBarraMouseDragged

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        IniciarSesion();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        IniciarSesion();
    }//GEN-LAST:event_txtContrasenaActionPerformed

    public void IniciarSesion() {
        txtCargando.setIcon(new ImageIcon(getClass().getResource("/Icons/cargando32px.gif")));
        Runnable run = () -> {
            loginVC.IniciarSesion();
            txtCargando.setIcon(null);
        };
        Thread runnable = new Thread(run);
        runnable.start();
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnIniciarSesion;
    private javax.swing.JCheckBox cbRecordarme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbOlvidaste;
    private javax.swing.JPanel pnBarra;
    private javax.swing.JLabel txtCargando;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
