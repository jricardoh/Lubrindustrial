/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Article;
import com.lubrindustrial.Server.ArticleCRUD;
import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Supplier;
import com.lubrindustrial.Server.SupplierCRUD;
import static com.lubrindustrial.View.Home.escritorio;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Jhonny
 */
public class ArticleNew extends javax.swing.JInternalFrame {

    /**
     * Creates new form DepartmentNew
     */
    
    ArrayList<Supplier> proveedores = new ArrayList<Supplier>();
    
    public ArticleNew() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        llenarComboBox();
    }
    
    private void llenarComboBox(){
        SupplierCRUD supCRUD = new SupplierCRUD();
        
        proveedores = supCRUD.visualizar(); // devuelve todos los registros de la BD
        
        cbox_suppliers.removeAllItems();
        
        for(Supplier s: proveedores){  
            cbox_suppliers.addItem(s.getIdSupplier()+" "+s.getNameSupplier());
        }
    }
    
    private void Volver(){
        Articles obj = new Articles();
        Home.escritorio.add(obj);
        obj.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = obj.getSize();
        obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        obj.show();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_Number = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_desc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_especificaciones = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_maximo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_punto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_cantidadreorden = new javax.swing.JTextField();
        cbox_suppliers = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_fabricante = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_unidadMedida = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_costoEstandar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_minimo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_nroDias = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_notas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_unidadStock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Artículo");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("No. Artículo");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 20));

        txt_Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NumberActionPerformed(evt);
            }
        });
        txt_Number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NumberKeyTyped(evt);
            }
        });
        jPanel2.add(txt_Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 140, -1));

        jLabel6.setText("Proveedor");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        jLabel7.setText("Descripción");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 20));

        txt_desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descKeyTyped(evt);
            }
        });
        jPanel2.add(txt_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 140, -1));

        jLabel9.setText("Especificaciones");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 20));

        txt_especificaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_especificacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_especificacionesKeyTyped(evt);
            }
        });
        jPanel2.add(txt_especificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 140, -1));

        jLabel10.setText("Máximo ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 20));

        txt_maximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_maximoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_maximoKeyTyped(evt);
            }
        });
        jPanel2.add(txt_maximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 140, -1));

        jLabel11.setText("Punto Reorden");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 100, 20));

        txt_punto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_puntoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_puntoKeyTyped(evt);
            }
        });
        jPanel2.add(txt_punto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 140, -1));

        jLabel12.setText("Cantidad Reorden");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 100, 20));

        txt_cantidadreorden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cantidadreordenKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadreordenKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cantidadreorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 140, -1));

        cbox_suppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_suppliersActionPerformed(evt);
            }
        });
        jPanel2.add(cbox_suppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        jLabel13.setText("Fabricante");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 20));

        txt_fabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_fabricanteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fabricanteKeyTyped(evt);
            }
        });
        jPanel2.add(txt_fabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 140, -1));

        jLabel14.setText("Unidad de Medida");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, 20));

        txt_unidadMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_unidadMedidaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_unidadMedidaKeyTyped(evt);
            }
        });
        jPanel2.add(txt_unidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 140, -1));

        jLabel15.setText("Costo Estándar");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 20));

        txt_costoEstandar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_costoEstandarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_costoEstandarKeyTyped(evt);
            }
        });
        jPanel2.add(txt_costoEstandar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 140, -1));

        jLabel16.setText("Mínimo");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 100, 20));

        txt_minimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_minimoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_minimoKeyTyped(evt);
            }
        });
        jPanel2.add(txt_minimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 140, -1));

        jLabel17.setText("Entrega Nro. días");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 100, 20));

        txt_nroDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nroDiasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nroDiasKeyTyped(evt);
            }
        });
        jPanel2.add(txt_nroDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 140, -1));

        jLabel18.setText("Notas");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 100, 20));

        txt_notas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_notasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_notasKeyTyped(evt);
            }
        });
        jPanel2.add(txt_notas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 140, -1));

        jLabel19.setText("Stock");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 100, 20));

        txt_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_stockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_stockKeyTyped(evt);
            }
        });
        jPanel2.add(txt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 140, -1));

        jLabel20.setText("Unidad Stock");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 100, 20));

        txt_unidadStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_unidadStockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_unidadStockKeyTyped(evt);
            }
        });
        jPanel2.add(txt_unidadStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NumberActionPerformed

    private void txt_NumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NumberKeyTyped
//        char C = evt.getKeyChar();
//        if (Character.isDigit(C)) {
//
//            evt.consume();
//            txt_Number.setCursor(null);
//
//        }
    }//GEN-LAST:event_txt_NumberKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ArticleCRUD artCRUD = new ArticleCRUD();
        Article art = new Article();
        String cad="";
        
        // ********** CAMBIO PARA REGISTRAR LOS 2 NUEVOS COLUMNAS DE LA BD
        try{
            cad=cbox_suppliers.getSelectedItem().toString();
            String []split = cad.split(" ");
            cad = split[0];
            art.setNroArt(txt_Number.getText());
            art.setIdProv(Integer.parseInt(cad));
            art.setDescArt(txt_desc.getText());
            art.setEspecificacionesArt(txt_especificaciones.getText());
            art.setFabricante(txt_fabricante.getText());
            art.setUnidaMedida(txt_unidadMedida.getText());
            art.setCostoEstandar(Float.parseFloat(txt_costoEstandar.getText()));
            art.setMaximo(Float.parseFloat(txt_maximo.getText()));
            art.setPuntoReorden(Float.parseFloat(txt_punto.getText()));
            art.setCantidadReorden(Float.parseFloat(txt_cantidadreorden.getText()));
            art.setMinimo(Float.parseFloat(txt_minimo.getText()));
            art.setNroDias(Integer.parseInt(txt_nroDias.getText()));
            art.setNotas(txt_notas.getText());
            art.setCantidad(Float.parseFloat(txt_stock.getText()));
            art.setDescripCantidad(txt_unidadStock.getText());
            
            if(artCRUD.insertar(art)){
                JOptionPane.showMessageDialog(null, "ARTICULO REGISTRADO","REGISTRO EXITOSO",JOptionPane.INFORMATION_MESSAGE);
                Volver();
            }else{
                JOptionPane.showMessageDialog(null, "ARTICULO NO REGISTRADO","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error obtener los datos", "ERROR DATOS", JOptionPane.ERROR_MESSAGE);
        }
        
        

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Volver();
        this.dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txt_descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descKeyReleased

    private void txt_descKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descKeyTyped

    private void txt_especificacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_especificacionesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_especificacionesKeyReleased

    private void txt_especificacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_especificacionesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_especificacionesKeyTyped

    private void txt_maximoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_maximoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maximoKeyReleased

    private void txt_maximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_maximoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maximoKeyTyped

    private void txt_puntoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_puntoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_puntoKeyReleased

    private void txt_puntoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_puntoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_puntoKeyTyped

    private void txt_cantidadreordenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadreordenKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadreordenKeyReleased

    private void txt_cantidadreordenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadreordenKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadreordenKeyTyped

    private void cbox_suppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_suppliersActionPerformed

    }//GEN-LAST:event_cbox_suppliersActionPerformed

    private void txt_fabricanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fabricanteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fabricanteKeyReleased

    private void txt_fabricanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fabricanteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fabricanteKeyTyped

    private void txt_unidadMedidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_unidadMedidaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_unidadMedidaKeyReleased

    private void txt_unidadMedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_unidadMedidaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_unidadMedidaKeyTyped

    private void txt_costoEstandarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costoEstandarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoEstandarKeyReleased

    private void txt_costoEstandarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costoEstandarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoEstandarKeyTyped

    private void txt_minimoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_minimoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_minimoKeyReleased

    private void txt_minimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_minimoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_minimoKeyTyped

    private void txt_nroDiasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nroDiasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nroDiasKeyReleased

    private void txt_nroDiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nroDiasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nroDiasKeyTyped

    private void txt_notasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_notasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_notasKeyReleased

    private void txt_notasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_notasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_notasKeyTyped

    private void txt_stockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stockKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stockKeyReleased

    private void txt_stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stockKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stockKeyTyped

    private void txt_unidadStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_unidadStockKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_unidadStockKeyReleased

    private void txt_unidadStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_unidadStockKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_unidadStockKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbox_suppliers;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_Number;
    private javax.swing.JTextField txt_cantidadreorden;
    private javax.swing.JTextField txt_costoEstandar;
    private javax.swing.JTextField txt_desc;
    private javax.swing.JTextField txt_especificaciones;
    private javax.swing.JTextField txt_fabricante;
    private javax.swing.JTextField txt_maximo;
    private javax.swing.JTextField txt_minimo;
    private javax.swing.JTextField txt_notas;
    private javax.swing.JTextField txt_nroDias;
    private javax.swing.JTextField txt_punto;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_unidadMedida;
    private javax.swing.JTextField txt_unidadStock;
    // End of variables declaration//GEN-END:variables
}
