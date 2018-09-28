/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tartlate file, choose Tools | Tartlates
 * and open the tartlate in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Location;
import com.lubrindustrial.Server.LocationCRUD;
import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Employee;
import com.lubrindustrial.Server.EmployeeCRUD;
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


public class EmployeesEdit extends javax.swing.JInternalFrame {

    ArrayList<Department> departamentos = new ArrayList<Department>();
//    ArrayList<Location> locaciones = new ArrayList<Location>();
    User user = new User();
    String host="";
    
    public EmployeesEdit() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
//        llenarComboBoxDep();
        lblID.setVisible(false);
        lblID.setEnabled(false);
        this.setIconifiable(true);
        this.setClosable(true);
        
    }

    public EmployeesEdit(User us) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
//        llenarComboBoxDep();
        lblID.setVisible(false);
        lblID.setEnabled(false);
        this.setIconifiable(true);
        this.setClosable(true);
        
        user = us;
    }
    
    public EmployeesEdit(User us, String hostname) {
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
        host=hostname;
        
        llenarComboBoxDep();
    }
    
    private void Volver(){
        Employees obj = new Employees(user,host);
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

    private void llenarComboBoxDep() {
        DepartmentCRUD deptCRUD = new DepartmentCRUD(host);

        departamentos = deptCRUD.visualizar(); // devuelve todos los registros de la BD

        cbox_department.removeAllItems();

        for (Department d : departamentos) {
            cbox_department.addItem(d.getIdDepartment() + " " + d.getDescDepartment());
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

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_apeEmployee = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_posEmployee = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_extEmployee = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_TelftrabEmployee = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_TelfpersEmployee = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_TelfcasaEmployee = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_emailEmployee = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_LocOficEmployee = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_salarioHoraEmployee = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_sobretiempo1Employee = new javax.swing.JTextField();
        txt_nomEmployee = new javax.swing.JTextField();
        cbox_department = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txt_NoEmployee = new javax.swing.JTextField();
        txt_email2Employee = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        setTitle("Editar Empleado");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("No. de Empleado");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        jLabel7.setText("Apellido");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        jLabel9.setText("Id de Departamento");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        txt_apeEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apeEmployeeActionPerformed(evt);
            }
        });
        txt_apeEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_apeEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apeEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_apeEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 153, -1));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eraser.png"))); // NOI18N
        jButton11.setText("Limpiar campos");
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jLabel11.setText("Cargo");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 20));

        txt_posEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_posEmployeeActionPerformed(evt);
            }
        });
        txt_posEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_posEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_posEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_posEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 153, -1));

        jLabel12.setText("Extensión");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));

        txt_extEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_extEmployeeActionPerformed(evt);
            }
        });
        txt_extEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_extEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_extEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_extEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 153, -1));

        jLabel13.setText("Teléfono Trabajo");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        txt_TelftrabEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelftrabEmployeeActionPerformed(evt);
            }
        });
        txt_TelftrabEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TelftrabEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelftrabEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_TelftrabEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 153, -1));

        jLabel14.setText("Teléfono Personal");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, 20));

        txt_TelfpersEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelfpersEmployeeActionPerformed(evt);
            }
        });
        txt_TelfpersEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TelfpersEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelfpersEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_TelfpersEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 153, -1));

        jLabel15.setText("Nombre");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jLabel16.setText("Teléfono Casa");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 20));

        txt_TelfcasaEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelfcasaEmployeeActionPerformed(evt);
            }
        });
        txt_TelfcasaEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TelfcasaEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelfcasaEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_TelfcasaEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 153, -1));

        jLabel17.setText("Email");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, 20));

        txt_emailEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailEmployeeActionPerformed(evt);
            }
        });
        txt_emailEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_emailEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_emailEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_emailEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 153, -1));

        jLabel18.setText("Email2");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 20));

        txt_LocOficEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_LocOficEmployeeActionPerformed(evt);
            }
        });
        txt_LocOficEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_LocOficEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_LocOficEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_LocOficEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 153, -1));

        jLabel19.setText("Locación Oficina");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, 20));

        jLabel20.setText("Salario");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, 20));

        txt_salarioHoraEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salarioHoraEmployeeActionPerformed(evt);
            }
        });
        txt_salarioHoraEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_salarioHoraEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_salarioHoraEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_salarioHoraEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 153, -1));

        jLabel21.setText("Sobretiempo ");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, 20));

        txt_sobretiempo1Employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sobretiempo1EmployeeActionPerformed(evt);
            }
        });
        txt_sobretiempo1Employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sobretiempo1EmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sobretiempo1EmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_sobretiempo1Employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 153, -1));

        txt_nomEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomEmployeeActionPerformed(evt);
            }
        });
        txt_nomEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nomEmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nomEmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_nomEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 153, -1));

        cbox_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_departmentActionPerformed(evt);
            }
        });
        jPanel3.add(cbox_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 150, -1));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, -1));
        jPanel3.add(txt_NoEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 150, -1));

        txt_email2Employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_email2EmployeeActionPerformed(evt);
            }
        });
        txt_email2Employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_email2EmployeeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_email2EmployeeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_email2Employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 153, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 310));
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 40, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_email2EmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_email2EmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email2EmployeeKeyTyped

    private void txt_email2EmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_email2EmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email2EmployeeKeyReleased

    private void txt_email2EmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_email2EmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email2EmployeeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Volver();
        this.dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        EmployeeCRUD empCRUD = new EmployeeCRUD(host);
        Employee e = new Employee();
        String cadD="";
        try{
            cadD=cbox_department.getSelectedItem().toString();
            String []splitD = cadD.split(" ");
            cadD = splitD[0];
            e.setIdEmployee(Integer.parseInt(lblID.getText()));
            e.setNomEmployee(txt_nomEmployee.getText());
            e.setApeEmployee(txt_apeEmployee.getText());
            e.setIdDepartment(Integer.parseInt(cadD));
            e.setNroEmployee(txt_NoEmployee.getText());
            e.setPosEmployee(txt_posEmployee.getText());
            e.setExtEmployee(txt_extEmployee.getText());
            e.setTelftrabEmployee(txt_TelftrabEmployee.getText());
            e.setTelfpersEmployee(txt_TelfpersEmployee.getText());
            e.setTelfcasaEmployee(txt_TelfcasaEmployee.getText());
            e.setEmailEmployee(txt_emailEmployee.getText());
            e.setFaxEmployee(txt_email2Employee.getText());
            e.setLocOficEmployee(txt_LocOficEmployee.getText());
            e.setSalarioHoraEmployee(Float.parseFloat(txt_salarioHoraEmployee.getText()));
            e.setSobretiempo1Employee(Float.parseFloat(txt_sobretiempo1Employee.getText()));
            e.setActivoEmployee(1);
            
            
            
            if(empCRUD.modificar(e,user)){
                JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO CORRECTAMENTE","REGISTRO EXITOSO",JOptionPane.INFORMATION_MESSAGE);
                Volver();
            }else{
                JOptionPane.showMessageDialog(null, "REGISTRO NO MODIFICADO","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error obtener los datos", "ERROR DATOS", JOptionPane.ERROR_MESSAGE);
            System.out.println(""+ex.getMessage());
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbox_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_departmentActionPerformed

    private void txt_nomEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomEmployeeKeyTyped

    private void txt_nomEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomEmployeeKeyReleased

    private void txt_nomEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomEmployeeActionPerformed

    private void txt_sobretiempo1EmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sobretiempo1EmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sobretiempo1EmployeeKeyTyped

    private void txt_sobretiempo1EmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sobretiempo1EmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sobretiempo1EmployeeKeyReleased

    private void txt_sobretiempo1EmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sobretiempo1EmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sobretiempo1EmployeeActionPerformed

    private void txt_salarioHoraEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_salarioHoraEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salarioHoraEmployeeKeyTyped

    private void txt_salarioHoraEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_salarioHoraEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salarioHoraEmployeeKeyReleased

    private void txt_salarioHoraEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salarioHoraEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salarioHoraEmployeeActionPerformed

    private void txt_LocOficEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_LocOficEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LocOficEmployeeKeyTyped

    private void txt_LocOficEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_LocOficEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LocOficEmployeeKeyReleased

    private void txt_LocOficEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LocOficEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LocOficEmployeeActionPerformed

    private void txt_emailEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailEmployeeKeyTyped

    private void txt_emailEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailEmployeeKeyReleased

    private void txt_emailEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailEmployeeActionPerformed

    private void txt_TelfcasaEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelfcasaEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelfcasaEmployeeKeyTyped

    private void txt_TelfcasaEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelfcasaEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelfcasaEmployeeKeyReleased

    private void txt_TelfcasaEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelfcasaEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelfcasaEmployeeActionPerformed

    private void txt_TelfpersEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelfpersEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelfpersEmployeeKeyTyped

    private void txt_TelfpersEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelfpersEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelfpersEmployeeKeyReleased

    private void txt_TelfpersEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelfpersEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelfpersEmployeeActionPerformed

    private void txt_TelftrabEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelftrabEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelftrabEmployeeKeyTyped

    private void txt_TelftrabEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelftrabEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelftrabEmployeeKeyReleased

    private void txt_TelftrabEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelftrabEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelftrabEmployeeActionPerformed

    private void txt_extEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_extEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_extEmployeeKeyTyped

    private void txt_extEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_extEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_extEmployeeKeyReleased

    private void txt_extEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_extEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_extEmployeeActionPerformed

    private void txt_posEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_posEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_posEmployeeKeyTyped

    private void txt_posEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_posEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_posEmployeeKeyReleased

    private void txt_posEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_posEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_posEmployeeActionPerformed

    private void txt_apeEmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apeEmployeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apeEmployeeKeyTyped

    private void txt_apeEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apeEmployeeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apeEmployeeKeyReleased

    private void txt_apeEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apeEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apeEmployeeActionPerformed
public void validarletra(java.awt.event.KeyEvent evt)
{
    char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z'))
            evt.consume();
}    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSave;
    public static javax.swing.JComboBox<String> cbox_department;
    private javax.swing.JButton jButton11;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblID;
    public static javax.swing.JTextField txt_LocOficEmployee;
    public static javax.swing.JTextField txt_NoEmployee;
    public static javax.swing.JTextField txt_TelfcasaEmployee;
    public static javax.swing.JTextField txt_TelfpersEmployee;
    public static javax.swing.JTextField txt_TelftrabEmployee;
    public static javax.swing.JTextField txt_apeEmployee;
    public static javax.swing.JTextField txt_email2Employee;
    public static javax.swing.JTextField txt_emailEmployee;
    public static javax.swing.JTextField txt_extEmployee;
    public static javax.swing.JTextField txt_nomEmployee;
    public static javax.swing.JTextField txt_posEmployee;
    public static javax.swing.JTextField txt_salarioHoraEmployee;
    public static javax.swing.JTextField txt_sobretiempo1Employee;
    // End of variables declaration//GEN-END:variables
}
