/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tartlate file, choose Tools | Tartlates
 * and open the tartlate in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Location;
import com.lubrindustrial.Server.LocationCRUD;
import com.lubrindustrial.Server.User;
import static com.lubrindustrial.View.Home.escritorio;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;


public class LocationsNew extends javax.swing.JInternalFrame {

    ArrayList<Department> departamentos = new ArrayList<Department>();

    User user = new User();
    String host;
    
    public LocationsNew() {
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
    
    public LocationsNew(User us, String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        
        user=us;
        host=hostname;
        llenarComboBox();
    }

    private void Volver(){
        Locations obj = new Locations(user,host);
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
    
    private void llenarComboBox(){
        DepartmentCRUD deptCRUD = new DepartmentCRUD(host);
        
        departamentos = deptCRUD.visualizar(); // devuelve todos los registros de la BD
        
        cbox_department.removeAllItems();
        
        for(Department d: departamentos){  
            cbox_department.addItem(d.getIdDepartment()+" "+d.getDescDepartment());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_NumberLocation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_description = new javax.swing.JTextField();
        cbox_department = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        setTitle("Nueva Locación");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Departamento");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        jLabel5.setText("No. de Locación");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 20));

        txt_NumberLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NumberLocationActionPerformed(evt);
            }
        });
        txt_NumberLocation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NumberLocationKeyTyped(evt);
            }
        });
        jPanel2.add(txt_NumberLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 140, -1));

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

        cbox_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_departmentActionPerformed(evt);
            }
        });
        jPanel2.add(cbox_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 230, -1));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        LocationCRUD loctCRUD = new LocationCRUD(host);
        Location l = new Location();
        String cad="";
        try{
            cad=cbox_department.getSelectedItem().toString();
            String []split = cad.split(" ");
            cad = split[0];
            l.setNroLocation(txt_NumberLocation.getText());
            l.setDescLocation(txt_description.getText());
            l.setIdDepartment(Integer.parseInt(cad));
            if(loctCRUD.insertar(l)){
                JOptionPane.showMessageDialog(null, "LOCACION REGISTRADO","REGISTRO EXITOSO",JOptionPane.INFORMATION_MESSAGE);
                Volver();
            }else{
                JOptionPane.showMessageDialog(null, "LOCACION NO REGISTRADO","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error obtener los datos", "ERROR DATOS", JOptionPane.ERROR_MESSAGE);
        }
        
       
    }//GEN-LAST:event_btnSaveActionPerformed
public void validarletra(java.awt.event.KeyEvent evt)
{
    char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z'))
            evt.consume();
}
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Volver();
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbox_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_departmentActionPerformed
        
    }//GEN-LAST:event_cbox_departmentActionPerformed

    private void txt_NumberLocationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NumberLocationKeyTyped
//    char C = evt.getKeyChar();
//        if (Character.isDigit(C)) {
//
//            evt.consume();
//            txt_NumberLocation.setCursor(null);
//
//        }
    }//GEN-LAST:event_txt_NumberLocationKeyTyped

    private void txt_descriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descriptionKeyReleased
//char charecter = evt.getKeyChar();
//		if (Character.isLowerCase(charecter)) {
//			evt.setKeyChar(Character.toUpperCase(charecter));
//		}
    }//GEN-LAST:event_txt_descriptionKeyReleased

    private void txt_descriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descriptionKeyTyped
   ///validarletra(evt);
//       char C = evt.getKeyChar();
//        if (Character.isDigit(C)) {
//
//            evt.consume();
//            txt_description.setCursor(null);
//
//        }
    }//GEN-LAST:event_txt_descriptionKeyTyped

    private void txt_NumberLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NumberLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NumberLocationActionPerformed
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbox_department;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_NumberLocation;
    private javax.swing.JTextField txt_description;
    // End of variables declaration//GEN-END:variables
}
