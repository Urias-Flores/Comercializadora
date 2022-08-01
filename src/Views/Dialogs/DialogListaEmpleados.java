package Views.Dialogs;

import Controllers.ControllerEmpleado;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class DialogListaEmpleados extends javax.swing.JDialog {

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
    private ControllerEmpleado contEmpleado = new ControllerEmpleado();
    private ArrayList<String> result = new ArrayList<>();
    private DefaultTableModel model = new DefaultTableModel();

    public ArrayList<String> getResult() {
        return result;
    }

    public DialogListaEmpleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Load();
    }
    
    private void Load(){
        btnCerrar.addMouseListener(ml);
        txtBuscar.addFocusListener(fl);
        Runnable run = ()->{
            model = contEmpleado.SelectEmpleados();
            tbListaEmpleados.setModel(model);
            tbListaEmpleados.getColumn("ID").setPreferredWidth(40);
            tbListaEmpleados.getColumn("Nombre").setPreferredWidth(200);
            tbListaEmpleados.getColumn("Documento").setPreferredWidth(150);
        };
        Thread th = new Thread(run);
        th.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnBarra = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaEmpleados = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Cascadia Code", 1, 22)); // NOI18N
        jLabel1.setText("Seleccione un empleado");

        jLabel2.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/buscar.png"))); // NOI18N

        txtBuscar.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(190, 190, 190));
        txtBuscar.setText("Nombre...");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tbListaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbListaEmpleados);

        btnSeleccionar.setBackground(new java.awt.Color(49, 152, 65));
        btnSeleccionar.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/seleccionar.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
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
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBarraMousePressed
        X = evt.getX();
        Y = evt.getY();
    }//GEN-LAST:event_pnBarraMousePressed

    private void pnBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - X, y - Y);
    }//GEN-LAST:event_pnBarraMouseDragged

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int fila = tbListaEmpleados.getSelectedRow();
        if(fila > -1){
            result.add(tbListaEmpleados.getValueAt(fila, 0).toString());
            result.add(tbListaEmpleados.getValueAt(fila, 1).toString());
            result.add(tbListaEmpleados.getValueAt(fila, 2).toString());
            this.setVisible(false);
        }else{
            Dialogs.ShowMessageDialog("Error, seleccione un empleado", Dialogs.ERRORMessage);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        TableRowSorter s = new TableRowSorter(tbListaEmpleados.getModel());
        tbListaEmpleados.setRowSorter(s);
        s.setRowFilter(RowFilter.regexFilter(txtBuscar.getText(), 1));
    }//GEN-LAST:event_txtBuscarKeyReleased

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
            java.util.logging.Logger.getLogger(DialogListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DialogListaEmpleados dialog = new DialogListaEmpleados(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnBarra;
    private javax.swing.JTable tbListaEmpleados;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
