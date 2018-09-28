/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
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
public class DepartmentEdit extends javax.swing.JInternalFrame {

    /**
     * Creates new form DepartmentNew
     */
    User user = new User();
    
    public DepartmentEdit() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        lblID.setVisible(false);
        lblID.setEnabled(false);
        this.setIconifiable(true);
        this.setClosable(true);
    }
    
    public DepartmentEdit(User us) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        lblID.setVisible(false);
        lblID.setEnabled(false);
        this.setIconifiable(true);
        this.setClosable(true);
        
        user = us;
    }
    
    private void Volver(){
        Departments obj = new Departments();
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
        txt_description = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Departamento");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("No. Departamento");
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
        jPanel2.add(txt_Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 140, -1));

        jLabel6.setText("Descripción");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        txt_description.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descriptionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descriptionKeyTyped(evt);
            }
        });
        jPanel2.add(txt_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 330, -1));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
//Solo permite texto
//        char C = evt.getKeyChar();
//        if (Character.isDigit(C)) {
//
//            evt.consume();
//            txt_Number.setCursor(null);
//
//        }
    }//GEN-LAST:event_txt_NumberKeyTyped

    private void txt_descriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descriptionKeyReleased
//Hace minúsculas a lo ingresado
//        char character = evt.getKeyChar();
//        if (Character.isLowerCase(character)) {
//            evt.setKeyChar(Character.toUpperCase(character));
//        }
    }//GEN-LAST:event_txt_descriptionKeyReleased

    private void txt_descriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descriptionKeyTyped
        ///validarletra(evt);
//        char C = evt.getKeyChar();
//        if (Character.isDigit(C)) {
//
//            evt.consume();
//            txt_description.setCursor(null);
//
//        }
    }//GEN-LAST:event_txt_descriptionKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        DepartmentCRUD depCRUD = new DepartmentCRUD();
        Department dep = new Department();
        try{
            dep.setIdDepartment(Integer.parseInt(lblID.getText()));
            dep.setNroDepartment(txt_Number.getText());
            dep.setDescDepartment(txt_description.getText());
            if(depCRUD.modificar(dep,user)){
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

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblID;
    public static javax.swing.JTextField txt_Number;
    public static javax.swing.JTextField txt_description;
    // End of variables declaration//GEN-END:variables
}