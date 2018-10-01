/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Conexion;
import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Employee;
import com.lubrindustrial.Server.EmployeeCRUD;
import com.lubrindustrial.Server.ReportsExcel;
import com.lubrindustrial.Server.User;
import com.lubrindustrial.Server.UserCRUD;
import static com.lubrindustrial.View.Home.escritorio;
import java.awt.Dimension;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Employees extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Employee> emp = new ArrayList<Employee>();
    ArrayList<Department> departamentos = new ArrayList<Department>();
//    int valor_encontrado;
    User user = new User();
    public String host;
    Conexion con;
    Connection cn;
    
    public Employees() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
        tab_employees.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_employees.doLayout();
        //llenarComboBoxDep();
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }

    public Employees(User usu) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
        tab_employees.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_employees.doLayout();
        //llenarComboBoxDep();
        user = usu;
        System.out.println("dddd:" + user.getApeUser());
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }
    
    public Employees(User usu, String hostname) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        
        tab_employees.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_employees.doLayout();
        //llenarComboBoxDep();
        user = usu;
        this.host=hostname;
        //System.out.println("Soy la direccion ene emp view: "+host);
        agregarDatos();
        //System.out.println("dddd:" + user.getApeUser());
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }
    
//    public int getvalorencontrado() {
//        int valorencontrado = valor_encontrado;
//        return valorencontrado = valor_encontrado;
//    }
//    public int seleccionaritem() {
//        int item = cbox.getSelectedIndex();
//        return item;
//    }
    public int seleccionaritem() {
        int item = cbox.getSelectedIndex();
        return item;
    }

    private void llenarComboBoxDep() {
        DepartmentCRUD deptCRUD = new DepartmentCRUD();

        departamentos = deptCRUD.visualizar(); // devuelve todos los registros de la BD

        EmployeesEdit.cbox_department.removeAllItems();

        for (Department d : departamentos) {
            EmployeesEdit.cbox_department.addItem(d.getIdDepartment() + " " + d.getDescDepartment());
        }
    }

//    public void cargartxt(String[] dat) {
//        
//            String auxiliar = tab_employees.getValueAt(filasel, 0).toString();
//            valor_encontrado = Integer.parseInt(auxiliar);
//            txt_art.setText(tab_employees.getValueAt(filasel, 3).toString());
//            txt_des.setText(tab_employees.getValueAt(filasel, 4).toString());
//            txt_pre.setText(tab_employees.getValueAt(filasel, 5).toString());
//            txt_stock.setText(tab_employees.getValueAt(filasel, 6).toString());
//
////            String dat[] = new String[17];
//            dat = ArregloEmpleados();
//            EmployeesEdit.lblID.setText(dat[0]);
//            EmployeesEdit.txt_NoEmployee.setText(dat[2]);
//            EmployeesEdit.txt_nomEmployee.setText(dat[3]);
//            EmployeesEdit.txt_apeEmployee.setText(dat[2]);
//            EmployeesEdit.txt_posEmployee.setText(dat[5]);
//            EmployeesEdit.txt_TelftrabEmployee.setText(dat[6]);
//            EmployeesEdit.txt_extEmployee.setText(dat[7]);
//            EmployeesEdit.txt_TelfcasaEmployee.setText(dat[9]);
//            EmployeesEdit.txt_TelfpersEmployee.setText(dat[8]);
//            EmployeesEdit.txt_emailEmployee.setText(dat[10]);
//            EmployeesEdit.txt_email2Employee.setText(dat[11]);
//            EmployeesEdit.txt_LocOficEmployee.setText(dat[12]);
//            EmployeesEdit.txt_salarioHoraEmployee.setText(dat[13]);
//            EmployeesEdit.txt_sobretiempo1Employee.setText(dat[14]);
//            llenarComboBoxDep();
//        
//        
//    }
    private void agregarDatos() {

        DefaultTableModel model = (DefaultTableModel) tab_employees.getModel();

        model.setRowCount(0);
        String datos[] = new String[17];//ARRAY DE 17

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        EmployeeCRUD empCRUD = new EmployeeCRUD(host);

        emp = empCRUD.visualizar(); // devuelve todos los registros de la BD

        for (Employee e : emp) {
            datos[0] = Integer.toString(e.getIdEmployee());
            datos[1] = Integer.toString(e.getIdDepartment());
            datos[2] = e.getNroEmployee();
            datos[3] = e.getNomEmployee();
            datos[4] = e.getApeEmployee();
            datos[5] = e.getPosEmployee();
            datos[7] = e.getExtEmployee();
            datos[6] = e.getTelftrabEmployee();
            datos[8] = e.getTelfpersEmployee();
            datos[9] = e.getTelfcasaEmployee();
            datos[10] = e.getEmailEmployee();
            datos[11] = e.getFaxEmployee();
            datos[12] = e.getLocOficEmployee();
            datos[13] = Float.toString(e.getSalarioHoraEmployee());
            datos[14] = Float.toString(e.getSobretiempo1Employee());
            datos[15] = Integer.toString(e.getActivoEmployee());
            datos[16] = e.getNameDept();

            model.addRow(datos);
        }

    }

    private String[] ArregloEmpleados(int idEmpleado) {

//        DefaultTableModel model = (DefaultTableModel)tab_employees.getModel();
//        model.setRowCount(0);
        String datos[] = new String[17];//ARRAY DE 17

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        EmployeeCRUD empCRUD = new EmployeeCRUD();

        emp = empCRUD.visualizar(idEmpleado); // devuelve todos los registros de la BD

        for (Employee e : emp) {
            datos[0] = Integer.toString(e.getIdEmployee());
            datos[1] = Integer.toString(e.getIdDepartment());
            datos[2] = e.getNroEmployee();
            datos[3] = e.getNomEmployee();
            datos[4] = e.getApeEmployee();
            datos[5] = e.getPosEmployee();
            datos[7] = e.getExtEmployee();
            datos[6] = e.getTelftrabEmployee();
            datos[8] = e.getTelfpersEmployee();
            datos[9] = e.getTelfcasaEmployee();
            datos[10] = e.getEmailEmployee();
            datos[11] = e.getFaxEmployee();
            datos[12] = e.getLocOficEmployee();
            datos[13] = Float.toString(e.getSalarioHoraEmployee());
            datos[14] = Float.toString(e.getSobretiempo1Employee());
            datos[15] = Integer.toString(e.getActivoEmployee());
            datos[16] = e.getNameDept();
//            model.addRow(datos);
        }
        return datos;
    }

//private void agregarDatos(String dato){
//        
//        DefaultTableModel model = (DefaultTableModel)tab_employees.getModel();
//
//        model.setRowCount(0);
//        String datos[] = new String[15];//ARRAY DE 18
//
//        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
//        EmployeeCRUD empCRUD = new EmployeeCRUD();
//        
//        emp = empCRUD.visualizar(); // devuelve todos los registros de la BD
//
//        for(Employee e: emp){
//            datos[0] = Integer.toString(e.getIdEmployee());
//            datos[2] = e.getNameDept();
//            datos[1] = e.getNroEmployee();
//            datos[3] = e.getNomEmployee();
//            datos[4] = e.getApeEmployee();
//            datos[5] = e.getPosEmployee();
//            datos[7] = e.getExtEmployee();
//            datos[6] = e.getTelftrabEmployee();
//            datos[8] = e.getTelfpersEmployee();
//            datos[9] = e.getTelfcasaEmployee();
//            datos[10] = e.getEmailEmployee();
//            datos[11] = e.getFaxEmployee();
//            datos[12] = e.getLocOficEmployee();
//            datos[13] = Float.toString(e.getSalarioHoraEmployee());
//            datos[14] = Float.toString(e.getSobretiempo1Employee());
//      
//            model.addRow(datos);
//        }
//        
//    }
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
        tab_employees = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbox = new javax.swing.JComboBox<>();
        txtInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

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

        setTitle("Empleados");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_employees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Empleado", "Nro. Empleado", "Departamento", "Nombre", "Apellido", "Cargo", "Telf. Trabajo", "Extensión", "Telf. Personal", "Telf. Casa", "Email", "Email2", "Locación Oficina", "Salario ", "Sobretiempo"
            }
        ));
        tab_employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_employeesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_employees);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 680, 160));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre Empleado", "Apellido Empleado", "Cargo Empleado", "Extensión Telefónica", "Teléfono de Trabajo", "Teléfono Personal", "Teléfono de Casa", "Email", "Email2", "Locación Oficina", "Sueldo", "Sobretiempo" }));
        cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 217, 680, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/nuevo.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 181, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/show_all.png"))); // NOI18N
        jButton2.setText("Mostrar todo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 181, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/door_exit.png"))); // NOI18N
        jButton3.setText("Detalles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/edit.png"))); // NOI18N
        btnEdit.setText("Modificar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 181, -1, -1));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eliminar.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 181, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/excel_logo.png"))); // NOI18N
        jButton4.setToolTipText("Generar hoja de cálculo de Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 40, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/pdf.png"))); // NOI18N
        jButton5.setToolTipText("Generar informe en PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 180, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 700, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_employeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_employeesMouseClicked

    }//GEN-LAST:event_tab_employeesMouseClicked

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed

    private void txtInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyReleased

        DefaultTableModel model = (DefaultTableModel) tab_employees.getModel();
        model.setRowCount(0);
        EmployeeCRUD emp_query = new EmployeeCRUD();
        String datos[] = new String[17];//ARRAY DE 3
        if (txtInput.getText().isEmpty()) {

            for (int i = 0; i < tab_employees.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;
            }

        } else {
            emp = emp_query.visualizar(txtInput.getText(), seleccionaritem());

            for (Employee e : emp) {
                datos[0] = Integer.toString(e.getIdEmployee());
                datos[1] = Integer.toString(e.getIdDepartment());
                datos[2] = e.getNroEmployee();
                datos[3] = e.getNomEmployee();
                datos[4] = e.getApeEmployee();
                datos[5] = e.getPosEmployee();
                datos[7] = e.getExtEmployee();
                datos[6] = e.getTelftrabEmployee();
                datos[8] = e.getTelfpersEmployee();
                datos[9] = e.getTelfcasaEmployee();
                datos[10] = e.getEmailEmployee();
                datos[11] = e.getFaxEmployee();
                datos[12] = e.getLocOficEmployee();
                datos[13] = Float.toString(e.getSalarioHoraEmployee());
                datos[14] = Float.toString(e.getSobretiempo1Employee());
                datos[15] = Integer.toString(e.getActivoEmployee());
                datos[16] = e.getNameDept();

                model.addRow(datos);
            }

        }
    }//GEN-LAST:event_txtInputKeyReleased

    private void txtInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyTyped
//        String nombre=String.valueOf(cbox.getSelectedItem());
//                System.out.println(nombre);
//              String c="Nombre";
//        if(nombre.equals(c))
//        {
//            char C = evt.getKeyChar();
//            if (Character.isDigit(C)) {
//                
//                evt.consume();
//                txtInput.setCursor(null);
//                
//            }
//        }
//        else{
//           
//             char caracter = evt.getKeyChar();
//            
//            // Verificar si la tecla pulsada no es un digito
//            if(((caracter < '0') ||
//                    (caracter > '9')) &&
//                    (caracter != '\b' /*corresponde a BACK_SPACE*/))
//            {
//                evt.consume();  // ignorar el evento de teclado
//            }
//            
//        }
    }//GEN-LAST:event_txtInputKeyTyped

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxActionPerformed
        txtInput.setText("");
    }//GEN-LAST:event_cboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        EmployeesNew obj = new EmployeesNew(user,host);
        Home.escritorio.add(obj);
        obj.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = obj.getSize();
        obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        obj.show();

        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int filasel = tab_employees.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            //String cuenta;
            //cuenta = .getText();
            int n = JOptionPane.showConfirmDialog(null, "¿Esta seguro de borrar el registro? ", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                EmployeeCRUD obj = new EmployeeCRUD(host);
                obj.eliminar(Integer.parseInt(tab_employees.getValueAt(filasel, 0).toString()),user);
                agregarDatos();
            }
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

//        this.dispose();
        this.doDefaultCloseAction();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

        this.setEnabled(true);

    }//GEN-LAST:event_formFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        agregarDatos();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        int filasel = tab_employees.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            EmployeesEdit obj = new EmployeesEdit(user,host);
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
            dat = ArregloEmpleados(Integer.parseInt(tab_employees.getValueAt(filasel, 0).toString()));
            EmployeesEdit.lblID.setText(dat[0]);
            EmployeesEdit.txt_NoEmployee.setText(dat[2]);
            EmployeesEdit.txt_nomEmployee.setText(dat[3]);
            EmployeesEdit.txt_apeEmployee.setText(dat[4]);
            EmployeesEdit.txt_posEmployee.setText(dat[5]);
            EmployeesEdit.txt_TelftrabEmployee.setText(dat[6]);
            EmployeesEdit.txt_extEmployee.setText(dat[7]);
            EmployeesEdit.txt_TelfcasaEmployee.setText(dat[9]);
            EmployeesEdit.txt_TelfpersEmployee.setText(dat[8]);
            EmployeesEdit.txt_emailEmployee.setText(dat[10]);
            EmployeesEdit.txt_email2Employee.setText(dat[11]);
            EmployeesEdit.txt_LocOficEmployee.setText(dat[12]);
            EmployeesEdit.txt_salarioHoraEmployee.setText(dat[13]);
            EmployeesEdit.txt_sobretiempo1Employee.setText(dat[14]);
            llenarComboBoxDep();
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        ReportsExcel reporte = new ReportsExcel(host);
        EmployeeCRUD empCRUD = new EmployeeCRUD(host);
        ArrayList<Employee> emps = empCRUD.visualizar();
        if(reporte.escribirExcelEmpleados(emps)){
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE EMPLEADOS CREADO","ARCHIVO GUARDADO EXITOSAMENTE",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE EMPLEADOS NO CREADO","EROOR EN GUARDADO", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

      try {
             JasperReport reporte = null;
             String path = "src\\lubrindustrial\\empleados.jasper";
             reporte = (JasperReport)JRLoader.loadObjectFromFile(path);
             JasperPrint jprint = JasperFillManager.fillReport(reporte, null,this.cn);
//             JasperReport reporte = JasperCompileManager.compileReport("reportMantEmp2.jrxml");
//            JasperPrint print = JasperFillManager.fillReport(reporte, null, this.cn);
            JasperViewer jviewer = new JasperViewer(jprint,false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
            //JasperViewer.viewReport(print);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tab_employees;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
