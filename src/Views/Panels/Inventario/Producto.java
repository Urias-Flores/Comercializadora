
package Views.Panels.Inventario;

import Controllers.ControllerProducto;
import Controllers.ControllerTipoRiego;
import Controllers.ControllerTipoSuelo;
import Views.Dialogs.Dialogs;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class Producto extends javax.swing.JPanel {
    private ControllerProducto controllerProducto;
    private ControllerTipoSuelo conSu = new ControllerTipoSuelo();
    private ControllerTipoRiego conRi = new ControllerTipoRiego();

    private ControllerProducto conPro;
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
    
    public Producto() {
        initComponents();
        Load();
        controllerProducto = new ControllerProducto
        (txtNombre, txtDescripcion, txtPrecioCompra, txtPrecioVenta, txtDescuento, cmbCategoria, cmbTipoSuelo, cmbTipoRiego, txtTiempoObtencion);
        conPro = new ControllerProducto
        (txtNombre, txtDescripcion, txtPrecioCompra, txtPrecioVenta, txtDescuento, cmbCategoria);
    }

    private void Load(){
        ArrayList<String> list;
        list = conSu.SelectListTipoSuelo();
        list.forEach(cmbTipoSuelo::addItem);
        list = conRi.SelectListTipoRiego();
        list.forEach(cmbTipoRiego::addItem);
        lbActualizar.addMouseListener(ml);
        lbInformacion.addMouseListener(ml);
        txtBuscar.addFocusListener(fl);
        LoadTable();
    }
    
    private void LoadTable(){
        ControllerProducto conPro2 = new ControllerProducto();
        tbProductos.setModel(conPro2.SelectModelProductos());
        tbProductos.getColumn("ID").setPreferredWidth(10);
        tbProductos.getColumn("Nombre").setPreferredWidth(400);
        tbProductos.getColumn("Precio/Compra").setPreferredWidth(70);
        tbProductos.getColumn("Precio/Venta").setPreferredWidth(70);
        tbProductos.getColumn("Categoria").setPreferredWidth(130);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTiempoObtencion = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtError = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbTipoSuelo = new javax.swing.JComboBox<>();
        cmbTipoRiego = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cmbCategoriaFilter = new javax.swing.JComboBox<>();
        lbActualizar = new javax.swing.JLabel();
        lbInformacion = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Cascadia Mono", 1, 22)); // NOI18N
        jLabel7.setText("Agregar nuevo producto");

        jLabel8.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel8.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel9.setText("Descripcion");

        txtDescripcion.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel10.setText("Categoria");

        txtPrecioCompra.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        txtPrecioCompra.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPrecioCompra.setText("0.00");

        txtPrecioVenta.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        txtPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPrecioVenta.setText("0.00");

        jLabel13.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel13.setText("Descuento");

        txtDescuento.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtDescuento.setText("0");

        jLabel12.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel12.setText("Compra");

        jLabel14.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel14.setText("Venta");

        jLabel15.setFont(new java.awt.Font("Cascadia Mono", 0, 20)); // NOI18N
        jLabel15.setText("$");

        jLabel16.setFont(new java.awt.Font("Cascadia Mono", 0, 20)); // NOI18N
        jLabel16.setText("$");

        jLabel17.setFont(new java.awt.Font("Cascadia Mono", 0, 20)); // NOI18N
        jLabel17.setText("%");

        jLabel11.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel11.setText("Tipo de suelo");

        jLabel18.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel18.setText("Tipo de riego");

        jLabel19.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel19.setText("Tiempo de obtencion");

        txtTiempoObtencion.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        txtTiempoObtencion.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTiempoObtencion.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel20.setText("Meses");

        txtError.setFont(new java.awt.Font("Cascadia Code", 0, 16)); // NOI18N
        txtError.setForeground(new java.awt.Color(140, 40, 40));

        btnAgregar.setBackground(new java.awt.Color(49, 152, 65));
        btnAgregar.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(144, 40, 40));
        btnLimpiar.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        cmbCategoria.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --", "PRODUCCION", "OBTENIBLE" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        cmbTipoSuelo.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        cmbTipoSuelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));
        cmbTipoSuelo.setEnabled(false);

        cmbTipoRiego.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        cmbTipoRiego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));
        cmbTipoRiego.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescripcion)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescuento)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPrecioVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16))
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addComponent(cmbTipoSuelo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTipoRiego, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTiempoObtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoSuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoRiego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTiempoObtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(190, 190, 190)));

        jLabel22.setFont(new java.awt.Font("Cascadia Mono", 1, 22)); // NOI18N
        jLabel22.setText("Registro de productos");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/buscar.png"))); // NOI18N

        txtBuscar.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(190, 190, 190));
        txtBuscar.setText("Nombre...");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        jLabel23.setText("Categoria");

        cmbCategoriaFilter.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        cmbCategoriaFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --", "PRODUCCION", "OBTENIBLE" }));
        cmbCategoriaFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaFilterActionPerformed(evt);
            }
        });

        lbActualizar.setBackground(new java.awt.Color(255, 255, 255));
        lbActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/actualizar.png"))); // NOI18N
        lbActualizar.setToolTipText("Actualizar");
        lbActualizar.setOpaque(true);
        lbActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbActualizarMouseClicked(evt);
            }
        });

        lbInformacion.setBackground(new java.awt.Color(255, 255, 255));
        lbInformacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/informacion.png"))); // NOI18N
        lbInformacion.setToolTipText("Ver informacion");
        lbInformacion.setOpaque(true);

        btnEditar.setBackground(new java.awt.Color(49, 152, 65));
        btnEditar.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editar2.png"))); // NOI18N
        btnEditar.setText("Editar");

        btnEliminar.setBackground(new java.awt.Color(144, 40, 40));
        btnEliminar.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");

        tbProductos.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCategoriaFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(lbInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar)
                    .addComponent(lbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbInformacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbCategoriaFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        TableRowSorter s = new TableRowSorter(tbProductos.getModel());
        tbProductos.setRowSorter(s);
        s.setRowFilter(RowFilter.regexFilter(txtBuscar.getText(), 0, 1));
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cmbCategoriaFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaFilterActionPerformed
        TableRowSorter s = new TableRowSorter(tbProductos.getModel());
        tbProductos.setRowSorter(s);
        if(cmbCategoriaFilter.getSelectedIndex() > 0){
            s.setRowFilter(RowFilter.regexFilter(cmbCategoriaFilter.getSelectedItem().toString(), 4));
        }else{
            s.setRowFilter(RowFilter.regexFilter("", 4));
        }
    }//GEN-LAST:event_cmbCategoriaFilterActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        if(cmbCategoria.getSelectedIndex() == 0 || cmbCategoria.getSelectedIndex() == 2){
            cmbTipoSuelo.setEnabled(false); cmbTipoSuelo.setSelectedIndex(0);
            cmbTipoRiego.setEnabled(false); cmbTipoRiego.setSelectedIndex(0);
            txtTiempoObtencion.setEnabled(false); txtTiempoObtencion.setText("");
        }else{
            cmbTipoSuelo.setEnabled(true);
            cmbTipoRiego.setEnabled(true);
            txtTiempoObtencion.setEnabled(true);
        }
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(Verify()){
            if(cmbCategoria.getSelectedIndex() == 1){
                if(!controllerProducto.InsertProductoDeproduccion()){
                    Dialogs.ShowMessageDialog("Producto agregado exitosamente", Dialogs.COMPLETEMessage);
                    LoadTable();
                    ClearFields();
                }else{
                    Dialogs.ShowMessageDialog("Ha ocurrido un error inesperado", Dialogs.ERRORMessage);
                }
            }else if(cmbCategoria.getSelectedIndex() == 2){
                if(!conPro.InsertProductoObtenible()){
                    Dialogs.ShowMessageDialog("Producto agregado exitosamente", Dialogs.COMPLETEMessage);
                    LoadTable();
                    ClearFields();
                }else{
                    Dialogs.ShowMessageDialog("Ha ocurrido un error inesperado", Dialogs.ERRORMessage);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void lbActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbActualizarMouseClicked
        LoadTable();
    }//GEN-LAST:event_lbActualizarMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        ClearFields();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private boolean Verify(){
        if(txtNombre.getText().isEmpty()){
            txtError.setText("Error, el nombre es obligatorio");
            return false;
        }
        if(txtDescripcion.getText().isEmpty()){
            txtError.setText("Error, la descripcion es obligatorio");
            return false;
        }
        if(txtPrecioCompra.getText().isEmpty()){
            txtError.setText("El precio de compra es obligatorio");
            return false;
        }
        try{
            float number = Float.parseFloat(txtPrecioCompra.getText());
        }catch(NumberFormatException ex){
            txtError.setText("El precio de compra debe ser un numero");
            return false;
        }
        if(txtPrecioVenta.getText().isEmpty()){
            txtError.setText("El precio de venta es obligatorio");
            return false;
        }
        try{
            float number = Float.parseFloat(txtPrecioVenta.getText());
        }catch(NumberFormatException ex){
            txtError.setText("El precio de venta debe ser un numero");
            return false;
        }
        if(txtDescuento.getText().isEmpty()){
            txtError.setText("El descuento es obligatorio");
            return false;
        }
        try{
            float number = Float.parseFloat(txtDescuento.getText());
        }catch(NumberFormatException ex){
            txtError.setText("El descuento debe ser un numero");
            return false;
        }
        if(cmbCategoria.getSelectedIndex() == 0){
            txtError.setText("Seleccione una categoria");
            return false;
        }
        if(cmbCategoria.getSelectedIndex() == 1 && cmbTipoSuelo.getSelectedIndex() == 0){
            txtError.setText("Seleccione un tipo de suelo");
            return false;
        }
        if(cmbCategoria.getSelectedIndex() == 1 && cmbTipoRiego.getSelectedIndex() == 0){
            txtError.setText("Seleccione un tipo de riego");
            return false;
        }
        if(cmbCategoria.getSelectedIndex() == 1 && txtTiempoObtencion.getText().isEmpty()){
            txtError.setText("El tiempo de obtencion es obligatorio");
            return false;
        }
        if(cmbCategoria.getSelectedIndex() == 1){
            try{
            float number = Float.parseFloat(txtTiempoObtencion.getText());
            }catch(NumberFormatException ex){
            txtError.setText("El descuento debe ser un numero");
            return false;
        }
        }
        return true;
    }
    
    private void ClearFields(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecioCompra.setText("0.00");
        txtPrecioVenta.setText("0.00");
        txtDescuento.setText("0");
        cmbCategoria.setSelectedIndex(0);
        cmbTipoSuelo.setSelectedIndex(0);
        cmbTipoRiego.setSelectedIndex(0);
        txtTiempoObtencion.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbCategoriaFilter;
    private javax.swing.JComboBox<String> cmbTipoRiego;
    private javax.swing.JComboBox<String> cmbTipoSuelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbActualizar;
    private javax.swing.JLabel lbInformacion;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JLabel txtError;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtTiempoObtencion;
    // End of variables declaration//GEN-END:variables
}
