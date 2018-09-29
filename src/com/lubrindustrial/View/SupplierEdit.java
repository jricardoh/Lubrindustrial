/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Supplier;
import com.lubrindustrial.Server.SupplierCRUD;
import com.lubrindustrial.Server.User;
import static com.lubrindustrial.View.Home.escritorio;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Marcelo
 */
public class SupplierEdit extends javax.swing.JInternalFrame {

    /**
     * Creates new form DepartmentNew
     */
    User user = new User();
    String host;
    public SupplierEdit() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        lblID.setVisible(false);
        lblID.setEnabled(false);
    }
    
    public SupplierEdit(User us) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        lblID.setVisible(false);
        lblID.setEnabled(false);
        
        user = us;
    }
    
    public SupplierEdit(User us,String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        lblID.setVisible(false);
        lblID.setEnabled(false);
        
        user = us;
        host=hostname;
    }
    
    private void Volver(){
        Suppliers obj = new Suppliers(user,host);
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
        txt_name = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_city = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_telf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_email1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_email2 = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Proveedor");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("No. Proveedor");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 20));

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
        jPanel2.add(txt_Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, -1));

        jLabel6.setText("Nombre Proveedor");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nameKeyTyped(evt);
            }
        });
        jPanel2.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 140, -1));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        jLabel7.setText("Ciudad Proveedor");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 20));

        txt_city.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cityKeyTyped(evt);
            }
        });
        jPanel2.add(txt_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 140, -1));

        jLabel9.setText("Direccion Proveedor");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 20));

        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_direccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        jPanel2.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 140, -1));

        jLabel10.setText("Teléfono Proveedor");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 100, 20));

        txt_telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_telfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telfKeyTyped(evt);
            }
        });
        jPanel2.add(txt_telf, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 140, -1));

        jLabel11.setText("Email1 Proveedor");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 100, 20));

        txt_email1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_email1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_email1KeyTyped(evt);
            }
        });
        jPanel2.add(txt_email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 140, -1));

        jLabel12.setText("Email2 Proveedor");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 100, 20));

        txt_email2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_email2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_email2KeyTyped(evt);
            }
        });
        jPanel2.add(txt_email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txt_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyReleased
//        char charecter = evt.getKeyChar();
//        if (Character.isLowerCase(charecter)) {
//            evt.setKeyChar(Character.toUpperCase(charecter));
//        }
    }//GEN-LAST:event_txt_nameKeyReleased

    private void txt_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyTyped
        ///validarletra(evt);
//        char C = evt.getKeyChar();
//        if (Character.isDigit(C)) {
//
//            evt.consume();
//            txt_name.setCursor(null);
//
//        }
    }//GEN-LAST:event_txt_nameKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        SupplierCRUD supCRUD = new SupplierCRUD(host);
        Supplier sup = new Supplier();
        
        try{
            sup.setIdSupplier(Integer.parseInt(lblID.getText()));
            sup.setNroSupplier(txt_Number.getText());
            sup.setNameSupplier(txt_name.getText());
            sup.setCitySupplier(txt_city.getText());
            sup.setDirSupplier(txt_direccion.getText());
            sup.setTelfSupplier(txt_telf.getText());
            sup.setEmailSupplier(txt_email1.getText());
            sup.setEmail2Supplier(txt_email2.getText());
            
            if(supCRUD.modificar(sup, user)){
                JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO CORRECTAMENTE","REGISTRO EXITOSO",JOptionPane.INFORMATION_MESSAGE);
                Volver();
            }else{
                JOptionPane.showMessageDialog(null, "REGISTRO NO MODIFICADO","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error obtener los datos", "ERROR DATOS", JOptionPane.ERROR_MESSAGE);
        }
        
        

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Volver();
        this.dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txt_cityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cityKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cityKeyReleased

    private void txt_cityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cityKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cityKeyTyped

    private void txt_direccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionKeyReleased

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionKeyTyped

    private void txt_telfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telfKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telfKeyReleased

    private void txt_telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telfKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telfKeyTyped

    private void txt_email1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_email1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email1KeyReleased

    private void txt_email1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_email1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email1KeyTyped

    private void txt_email2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_email2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email2KeyReleased

    private void txt_email2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_email2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email2KeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblID;
    public static javax.swing.JTextField txt_Number;
    public static javax.swing.JTextField txt_city;
    public static javax.swing.JTextField txt_direccion;
    public static javax.swing.JTextField txt_email1;
    public static javax.swing.JTextField txt_email2;
    public static javax.swing.JTextField txt_name;
    public static javax.swing.JTextField txt_telf;
    // End of variables declaration//GEN-END:variables
}
