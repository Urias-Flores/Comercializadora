package Views;

import ViewsControllers.MainViewController;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends javax.swing.JFrame {

    private MainViewController MainVC;
    
    public Main() {
        initComponents();
        setTitle("Inicio");
        setIconImage(new ImageIcon(getClass().getResource("/Icons/logo.png")).getImage());
    }
    
    public void Cargar(JFrame Login, String user){
        MainVC = new MainViewController(this, Login, txtUsuarioActual, btnFacturacion, btnControl, btnEstadisticas, btnPreferecias, btnAjustes, btnCerrarSesion, tbpPrincipal);
        MainVC.cargarUsuario(user);
        MainVC.CargarPanel(1);
        MainVC.activarBoton(btnFacturacion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnFacturacion = new javax.swing.JLabel();
        btnControl = new javax.swing.JLabel();
        btnEstadisticas = new javax.swing.JLabel();
        btnPreferecias = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAjustes = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtUsuarioActual = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tbpPrincipal = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setPreferredSize(new java.awt.Dimension(1800, 970));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(3, 57, 103));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Principal");

        btnFacturacion.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        btnFacturacion.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturacion.setText("    Facturación");
        btnFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFacturacionMouseClicked(evt);
            }
        });

        btnControl.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        btnControl.setForeground(new java.awt.Color(255, 255, 255));
        btnControl.setText("    Control");
        btnControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnControlMouseClicked(evt);
            }
        });

        btnEstadisticas.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        btnEstadisticas.setForeground(new java.awt.Color(255, 255, 255));
        btnEstadisticas.setText("    Estadisticas");
        btnEstadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadisticasMouseClicked(evt);
            }
        });

        btnPreferecias.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        btnPreferecias.setForeground(new java.awt.Color(255, 255, 255));
        btnPreferecias.setText("    Preferencias");
        btnPreferecias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrefereciasMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Otros");

        btnAjustes.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        btnAjustes.setForeground(new java.awt.Color(255, 255, 255));
        btnAjustes.setText("    Ajustes");
        btnAjustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAjustesMouseClicked(evt);
            }
        });

        btnCerrarSesion.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("    Cerrar sesión");
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/usuario128px.png"))); // NOI18N

        txtUsuarioActual.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        txtUsuarioActual.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuarioActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUsuarioActual.setText("UsuarioActivo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFacturacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnControl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(btnEstadisticas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(btnPreferecias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(btnAjustes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuarioActual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuarioActual)
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnFacturacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnControl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEstadisticas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPreferecias)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(btnAjustes)
                .addGap(18, 18, 18)
                .addComponent(btnCerrarSesion)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbpPrincipal.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(tbpPrincipal))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

    private void btnFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturacionMouseClicked
        MainVC.CargarPanel(1);
        MainVC.activarBoton(btnFacturacion);
    }//GEN-LAST:event_btnFacturacionMouseClicked

    private void btnControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnControlMouseClicked
        MainVC.CargarPanel(2);
        MainVC.activarBoton(btnControl);
    }//GEN-LAST:event_btnControlMouseClicked

    private void btnEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadisticasMouseClicked
        MainVC.CargarPanel(3);
        MainVC.activarBoton(btnEstadisticas);
    }//GEN-LAST:event_btnEstadisticasMouseClicked

    private void btnPrefereciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrefereciasMouseClicked
        MainVC.CargarPanel(4);
        MainVC.activarBoton(btnPreferecias);
    }//GEN-LAST:event_btnPrefereciasMouseClicked

    private void btnAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseClicked
        MainVC.CargarPanel(5);
        MainVC.activarBoton(btnAjustes);
    }//GEN-LAST:event_btnAjustesMouseClicked

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        MainVC.cerrasSesion();
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAjustes;
    private javax.swing.JLabel btnCerrarSesion;
    private javax.swing.JLabel btnControl;
    private javax.swing.JLabel btnEstadisticas;
    private javax.swing.JLabel btnFacturacion;
    private javax.swing.JLabel btnPreferecias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane tbpPrincipal;
    private javax.swing.JLabel txtUsuarioActual;
    // End of variables declaration//GEN-END:variables
}