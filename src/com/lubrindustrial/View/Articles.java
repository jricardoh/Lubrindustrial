/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Article;
import com.lubrindustrial.Server.ArticleCRUD;
import com.lubrindustrial.Server.ReportsExcel;
import com.lubrindustrial.Server.Supplier;
import com.lubrindustrial.Server.SupplierCRUD;
import com.lubrindustrial.Server.User;
import com.lubrindustrial.Server.UserCRUD;
import static com.lubrindustrial.View.Home.escritorio;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

public class Articles extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    int valor_encontrado;
    ArrayList<Article> articulos = new ArrayList<Article>();
    ArrayList<Supplier> proveedores = new ArrayList<Supplier>();
    User user = new User();
    String host="";
    public int getvalorencontrado() {
        int valorencontrado = valor_encontrado;
        return valorencontrado = valor_encontrado;
    }

//ArrayList<Articulos> lista = new ArrayList<Articulos>();
    public Articles() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
        tab_articles.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_articles.doLayout();
    }

    public Articles(User usu) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
        tab_articles.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_articles.doLayout();
        user = usu;
    }
    
    public Articles(User usu, String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        
        tab_articles.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_articles.doLayout();
        user = usu;
        host=hostname;
        agregarDatos();
    }
    
    public int seleccionaritem() {
        int item = cbox.getSelectedIndex();
        return item;
    }

    public int getvalor() {
        int aux = valor_encontrado;
        return aux;
    }

    private void agregarDatos() {
        // ********** CAMBIO PARA MOSTRAR LAS 2 NUEVAS COLUMNAS DE LA BD

        DefaultTableModel model = (DefaultTableModel) tab_articles.getModel();

        model.setRowCount(0);
        String datos[] = new String[16];//ARRAY DE 3

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        ArticleCRUD artCRUD = new ArticleCRUD();

        articulos = artCRUD.visualizar(); // devuelve todos los registros de la BD

        for (Article a : articulos) {

            datos[0] = Integer.toString(a.getIdArt());
            datos[1] = a.getNroArt();
            datos[2] = a.getDescProv();
            datos[3] = a.getDescArt();
            datos[4] = a.getEspecificacionesArt();
            datos[5] = a.getFabricante();
            datos[6] = a.getUnidaMedida();
            datos[7] = Float.toString(a.getCostoEstandar());
            datos[8] = Float.toString(a.getMaximo());
            datos[9] = Float.toString(a.getPuntoReorden());
            datos[10] = Float.toString(a.getCantidadReorden());
            datos[11] = Float.toString(a.getMinimo());
            datos[12] = Integer.toString(a.getNroDias());
            datos[13] = a.getNotas();
            datos[14] = Float.toString(a.getCantidad());
            datos[15] = a.getDescripCantidad();
            model.addRow(datos);
        }

    }

    private String[] arregloArticulos(int idArticulo) {

        String datos[] = new String[17];//ARRAY DE 3

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        ArticleCRUD artCRUD = new ArticleCRUD();

        articulos = artCRUD.visualizar(idArticulo); // devuelve todos los registros de la BD

        for (Article a : articulos) {

            datos[0] = Integer.toString(a.getIdArt());
            datos[1] = a.getNroArt();
            datos[2] = a.getDescProv();
            datos[3] = a.getDescArt();
            datos[4] = a.getEspecificacionesArt();
            datos[5] = a.getFabricante();
            datos[6] = a.getUnidaMedida();
            datos[7] = Float.toString(a.getCostoEstandar());
            datos[8] = Float.toString(a.getMaximo());
            datos[9] = Float.toString(a.getPuntoReorden());
            datos[10] = Float.toString(a.getCantidadReorden());
            datos[11] = Float.toString(a.getMinimo());
            datos[12] = Integer.toString(a.getNroDias());
            datos[13] = a.getNotas();
            datos[14] = Float.toString(a.getCantidad());
            datos[15] = a.getDescripCantidad();

        }
        return datos;
    }
    

    private void llenarComboBox(){
        SupplierCRUD supCRUD = new SupplierCRUD();
        
        proveedores = supCRUD.visualizar(); // devuelve todos los registros de la BD
        
        ArticleEdit.cbox_suppliers.removeAllItems();
        
        for(Supplier s: proveedores){  
            ArticleEdit.cbox_suppliers.addItem(s.getIdSupplier()+" "+s.getNameSupplier());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_articles = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cbox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setTitle("Artículos");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_articles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Artículo", "Número Artículo", "Proveedor", "Descripción", "Especificaciones", "Fabricante", "Unidad Medida", "Costo Estándar", "Máximo", "Punto Reorden", "Cantidad Reorden", "Mínimo ", "Nro. Días", "Notas ", "Stock", "Unidad Stock"
            }
        ));
        tab_articles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_articlesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_articles);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        txtInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputActionPerformed(evt);
            }
        });
        txtInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInputKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInputKeyTyped(evt);
            }
        });

        jLabel1.setText("Cantidad de Registros:");

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de Artículo", "Descripción", "Especificaciones", "Fabricante", "Unidad de Medida", "Costo Estándar", "Máximo", "Punto de Reorden", "Cantidad Reorden", "Mínimo", "Tiempo entrega", "Notas", "Cantidad" }));
        cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/nuevo.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/show_all.png"))); // NOI18N
        jButton2.setText("Mostrar todo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/door_exit.png"))); // NOI18N
        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/edit.png"))); // NOI18N
        btnEdit.setText("Modificar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eliminar.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/excel_logo.png"))); // NOI18N
        jButton4.setToolTipText("Generar hoja de cálculo de Excel");
        jButton4.setPreferredSize(new java.awt.Dimension(53, 29));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(15, 15, 15)
                                .addComponent(jButton1)
                                .addGap(17, 17, 17)
                                .addComponent(btnEdit)
                                .addGap(15, 15, 15)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete)
                        .addComponent(jButton3))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_articlesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_articlesMouseClicked

    }//GEN-LAST:event_tab_articlesMouseClicked

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed

    private void txtInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyReleased

        DefaultTableModel model = (DefaultTableModel) tab_articles.getModel();
        model.setRowCount(0);
        ArticleCRUD art_query = new ArticleCRUD();
        String datos[] = new String[14];//ARRAY DE 3
        if (txtInput.getText().isEmpty()) {

            for (int i = 0; i < tab_articles.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;
            }

        } else {
            articulos = art_query.visualizar(txtInput.getText(), seleccionaritem());

            for (Article a : articulos) {

                datos[0] = Integer.toString(a.getIdArt());
                datos[1] = a.getNroArt();
                datos[2] = a.getDescProv();
                datos[3] = a.getDescArt();
                datos[4] = a.getEspecificacionesArt();
                datos[5] = a.getFabricante();
                datos[6] = a.getUnidaMedida();
                datos[7] = Float.toString(a.getCostoEstandar());
                datos[8] = Float.toString(a.getMaximo());
                datos[9] = Float.toString(a.getPuntoReorden());
                datos[10] = Float.toString(a.getCantidadReorden());
                datos[11] = Float.toString(a.getMinimo());
                datos[12] = Integer.toString(a.getNroDias());
                datos[13] = a.getNotas();
                model.addRow(datos);
            }
        }
    }//GEN-LAST:event_txtInputKeyReleased

    private void txtInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyTyped
//        String nombre = String.valueOf(cbox.getSelectedItem());
//        System.out.println(nombre);
//        String c = "Nombre";
//        if (nombre.equals(c)) {
//            char C = evt.getKeyChar();
//            if (Character.isDigit(C)) {
//
//                evt.consume();
//                txtInput.setCursor(null);
//
//            }
//        } else {
//
//            char caracter = evt.getKeyChar();
//
//            // Verificar si la tecla pulsada no es un digito
//            if (((caracter < '0')
//                    || (caracter > '9'))
//                    && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
//                evt.consume();  // ignorar el evento de teclado
//            }
//
//        }
    }//GEN-LAST:event_txtInputKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ArticleNew obj = new ArticleNew();
        Home.escritorio.add(obj);
        obj.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = obj.getSize();
        obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        obj.show();

//        this.dispose();
        this.doDefaultCloseAction();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int filasel = tab_articles.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            //String cuenta;
            //cuenta = .getText();
            int n = JOptionPane.showConfirmDialog(null, "¿Esta seguro de borrar el registro? ", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                ArticleCRUD obj = new ArticleCRUD();
                UserCRUD usrCRUD = new UserCRUD();
                obj.eliminar(Integer.parseInt(tab_articles.getValueAt(filasel, 0).toString()),user);
                agregarDatos();
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

//        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

        this.setEnabled(true);

    }//GEN-LAST:event_formFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        agregarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        
        int filasel = tab_articles.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            ArticleEdit obj = new ArticleEdit();
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            this.dispose();


            String dat[] = new String[17];
            dat = arregloArticulos(Integer.parseInt(tab_articles.getValueAt(filasel, 0).toString()));
            ArticleEdit.lblID.setText(dat[0]);
            ArticleEdit.txt_Number.setText(dat[1]);
            ArticleEdit.txt_desc.setText(dat[3]);
            ArticleEdit.txt_especificaciones.setText(dat[4]);
            ArticleEdit.txt_fabricante.setText(dat[5]);
            ArticleEdit.txt_unidadMedida.setText(dat[6]);
            ArticleEdit.txt_costoEstandar.setText(dat[7]);
            ArticleEdit.txt_maximo.setText(dat[8]);
            ArticleEdit.txt_punto.setText(dat[9]);
            ArticleEdit.txt_cantidadreorden.setText(dat[10]);
            ArticleEdit.txt_minimo.setText(dat[11]);
            ArticleEdit.txt_nroDias.setText(dat[12]);
            ArticleEdit.txt_notas.setText(dat[13]);
            ArticleEdit.txt_stock.setText(dat[14]);
            ArticleEdit.txt_unidadStock.setText(dat[15]);
            for(int i = 0; i<dat.length;i++)
            {
                System.out.println(dat[i]);
            }
            llenarComboBox();
        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxActionPerformed
        txtInput.setText("");
    }//GEN-LAST:event_cboxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ReportsExcel reporte = new ReportsExcel();
        ArticleCRUD artCRUD = new ArticleCRUD();
        ArrayList<Article> arts = artCRUD.visualizar();
        if(reporte.escribirExcelArticulos(arts)){
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE ARTICULOS CREADO","ARCHIVO GUARDADO EXITOSAMENTE",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE ARTICULOS NO CREADO","EROOR EN GUARDADO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tab_articles;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
