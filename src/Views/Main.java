package Views;

import Resources.Conection;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Views.Dialogs.Dialogs;
import Views.Panels.Administracion.Arqueo;
import Views.Panels.Administracion.Empleados;
import Views.Panels.Administracion.Resumen;
import Views.Panels.Administracion.Usuarios;
import Views.Panels.Inicio.Compras;
import Views.Panels.Inicio.Editar;
import Views.Panels.Inicio.Facturacion;
import Views.Panels.Inicio.Clientes;
import Views.Panels.Inventario.Bodega;
import Views.Panels.Inventario.Inventario;
import Views.Panels.Inventario.Producto;
import Views.Panels.Preferencias.Preferencias;
import Views.Panels.Produccion.Anticipo;
import Views.Panels.Produccion.Fincas;
import Views.Panels.Produccion.Insumos;
import Views.Panels.Produccion.Productores;
import Views.Panels.Proveedores.Pagos;
import Views.Panels.Proveedores.Proveedores;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main extends javax.swing.JFrame {
    
    public Main() {
        initComponents();
        lb1.addMouseListener(ml);
        lb2.addMouseListener(ml);
        lb3.addMouseListener(ml);
        lb4.addMouseListener(ml);
        lb5.addMouseListener(ml);
        lb6.addMouseListener(ml);
        
        lbSalir.addMouseListener(ml2);
        lbAjustes.addMouseListener(ml2);
        
        disableLabel();
        lb1.setEnabled(true);
        lb1.setBackground(new Color(38, 73, 119));
        
        Load(1);
        Image logo = new ImageIcon(getClass().getResource("/Icons/LOGO.png")).getImage();
        this.setIconImage(logo);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            disableLabel();
            l.setEnabled(true);
            l.setBackground(new Color(38, 73, 119));
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setBackground(new Color(38, 73, 119));
            l.setForeground(new Color(220, 220, 220));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            if(!l.isEnabled()){
                l.setBackground(new Color(39, 49, 65));
                l.setForeground(Color.white);
            }
        }
    };
    MouseListener ml2 = new MouseListener() {
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
            l.setForeground(new Color(90, 90, 90));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setForeground(new Color(39, 49, 65));
        }
    };
    
    private void disableLabel(){
        lb1.setEnabled(false); lb1.setBackground(new Color(39, 49, 65));
        lb2.setEnabled(false); lb2.setBackground(new Color(39, 49, 65));
        lb3.setEnabled(false); lb3.setBackground(new Color(39, 49, 65));
        lb4.setEnabled(false); lb4.setBackground(new Color(39, 49, 65));
        lb5.setEnabled(false); lb5.setBackground(new Color(39, 49, 65));
        lb6.setEnabled(false); lb6.setBackground(new Color(39, 49, 65));
    }
    
    private void Load(int Pane) {
        TabPane.removeAll();
        switch(Pane){
            case 1:
                Facturacion fac = new Facturacion();
                Compras com = new Compras();
                Editar edi = new Editar();
                Clientes otr = new Clientes();
              
                Icon ico11 = new ImageIcon(getClass().getResource("/icons/facturacion.png"));
                Icon ico12 = new ImageIcon(getClass().getResource("/icons/compra.png"));
                Icon ico13 = new ImageIcon(getClass().getResource("/icons/editar.png"));
                Icon ico14 = new ImageIcon(getClass().getResource("/icons/otros.png"));
                
                TabPane.addTab("Facturacion", ico11, fac);
                TabPane.addTab("Compras", ico12, com);
                TabPane.addTab("Edicion", ico13, edi);
                TabPane.addTab("Clientes", ico14,otr);
                
                break;
            case 2:
                
                Bodega bo = new Bodega();
                Inventario inv = new Inventario();
                Producto pro = new Producto();
                
                Icon ico21 = new ImageIcon(getClass().getResource("/icons/inventario.png"));
                Icon ico22 = new ImageIcon(getClass().getResource("/icons/producto.png"));
                Icon ico23 = new ImageIcon(getClass().getResource("/icons/bodega.png"));
                
                TabPane.addTab("Inventario", ico21, inv);
                TabPane.addTab("Productos", ico22, pro);
                TabPane.addTab("Bodegas", ico23,bo);
                
                break;
            case 3:
                
                Anticipo ant = new Anticipo();
                Insumos ins = new Insumos();
                Fincas fin = new Fincas();
                Productores prod = new Productores();
                
                Icon ico31 = new ImageIcon(getClass().getResource("/icons/productores.png"));
                Icon ico32 = new ImageIcon(getClass().getResource("/icons/finca.png"));
                Icon ico33 = new ImageIcon(getClass().getResource("/icons/insumo.png"));
                Icon ico34 = new ImageIcon(getClass().getResource("/icons/anticipo.png"));
                
                TabPane.addTab("Productores", ico31, prod);
                TabPane.addTab("Fincas y parcelas", ico32,fin);
                //TabPane.addTab("Insumos", ico33,ins);
                TabPane.addTab("Anticipos", ico34,ant);
                
                break;
            case 4:
                
                Proveedores prov = new Proveedores();
                Pagos pag = new Pagos();
                        
                Icon ico41 = new ImageIcon(getClass().getResource("/icons/proveedor.png"));
                Icon ico42 = new ImageIcon(getClass().getResource("/icons/pago.png"));
                
                TabPane.addTab("Proveedores", ico41, prov);
                TabPane.addTab("Pagos", ico42,pag);
                
                break;
            case 5:
                
                Resumen res = new Resumen();
                Arqueo arq = new Arqueo();
                Usuarios us = new Usuarios();
                Empleados emp = new Empleados();
                
                Icon ico51 = new ImageIcon(getClass().getResource("/icons/resumen.png"));
                Icon ico52 = new ImageIcon(getClass().getResource("/icons/arqueo.png"));
                Icon ico53 = new ImageIcon(getClass().getResource("/icons/usuarios.png"));
                Icon ico54 = new ImageIcon(getClass().getResource("/icons/empleado.png"));
                
                //TabPane.addTab("Resumenes", ico51, res);
                TabPane.addTab("Arqueos", ico52, arq);
                TabPane.addTab("Empleados", ico54,emp);
                TabPane.addTab("Usuarios", ico53, us);
                
                break;
            case 6:
                
                Preferencias pre = new Preferencias();
                
                Icon ico61 = new ImageIcon(getClass().getResource("/icons/preferencias.png"));
                
                TabPane.addTab("Preferencias", ico61, pre);
                       
                break;
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbSalir = new javax.swing.JLabel();
        lbAjustes = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        TabPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CN | inicio");
        setMinimumSize(new java.awt.Dimension(1780, 920));
        setPreferredSize(new java.awt.Dimension(1780, 920));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(39, 49, 65));

        jLabel5.setFont(new java.awt.Font("Cascadia Code", 1, 34)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Opciones");

        lb1.setBackground(new java.awt.Color(39, 49, 65));
        lb1.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb1.setText(" Inicio");
        lb1.setAlignmentX(1.5F);
        lb1.setEnabled(false);
        lb1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lb1.setOpaque(true);
        lb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb1MouseClicked(evt);
            }
        });

        lb2.setBackground(new java.awt.Color(39, 49, 65));
        lb2.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setText(" Inventario");
        lb2.setEnabled(false);
        lb2.setOpaque(true);
        lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2MouseClicked(evt);
            }
        });

        lb3.setBackground(new java.awt.Color(39, 49, 65));
        lb3.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setText(" Produccion");
        lb3.setEnabled(false);
        lb3.setOpaque(true);
        lb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb3MouseClicked(evt);
            }
        });

        lb4.setBackground(new java.awt.Color(39, 49, 65));
        lb4.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 255, 255));
        lb4.setText(" Proveedores");
        lb4.setEnabled(false);
        lb4.setOpaque(true);
        lb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb4MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cascadia Code", 1, 34)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("otros");

        lb5.setBackground(new java.awt.Color(39, 49, 65));
        lb5.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 255, 255));
        lb5.setText(" Administracion");
        lb5.setEnabled(false);
        lb5.setOpaque(true);
        lb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb5MouseClicked(evt);
            }
        });

        lb6.setBackground(new java.awt.Color(39, 49, 65));
        lb6.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        lb6.setForeground(new java.awt.Color(255, 255, 255));
        lb6.setText(" Preferencias");
        lb6.setEnabled(false);
        lb6.setOpaque(true);
        lb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(190, 190, 190)));

        jLabel1.setFont(new java.awt.Font("Cascadia Code", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(39, 49, 65));
        jLabel1.setText("COMERCIALIZADORA");

        jLabel2.setFont(new java.awt.Font("Cascadia Code", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(39, 49, 65));
        jLabel2.setText("Del Norte");

        lbSalir.setFont(new java.awt.Font("Cascadia Code", 0, 20)); // NOI18N
        lbSalir.setForeground(new java.awt.Color(39, 49, 65));
        lbSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSalir.setText("Salir");
        lbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalirMouseClicked(evt);
            }
        });

        lbAjustes.setFont(new java.awt.Font("Cascadia Code", 0, 20)); // NOI18N
        lbAjustes.setForeground(new java.awt.Color(39, 49, 65));
        lbAjustes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAjustes.setText("Ajustes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 804, Short.MAX_VALUE)
                .addComponent(lbAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        TabPane.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(Dialogs.ShowCloseDialog()){
            Conection conec = new Conection();
            conec.closeConec();
            System.out.println("Conexion cerrada exitosamente");
            System.exit(0);
        }else{
            this.setDefaultCloseOperation(Main.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void lb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MouseClicked
        Load(1);
    }//GEN-LAST:event_lb1MouseClicked

    private void lb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseClicked
        Load(2);
    }//GEN-LAST:event_lb2MouseClicked

    private void lb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3MouseClicked
        Load(3);
    }//GEN-LAST:event_lb3MouseClicked

    private void lb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4MouseClicked
        Load(4);
    }//GEN-LAST:event_lb4MouseClicked

    private void lb5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb5MouseClicked
        Load(5);
    }//GEN-LAST:event_lb5MouseClicked

    private void lb6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb6MouseClicked
        Load(6);
    }//GEN-LAST:event_lb6MouseClicked

    private void lbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirMouseClicked
        LogIn lg = new LogIn();
        lg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbSalirMouseClicked

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
    private javax.swing.JTabbedPane TabPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lbAjustes;
    private javax.swing.JLabel lbSalir;
    // End of variables declaration//GEN-END:variables
}
