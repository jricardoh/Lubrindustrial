/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Conexion;
import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Location;
import com.lubrindustrial.Server.LocationCRUD;
import com.lubrindustrial.Server.ReportsExcel;
import com.lubrindustrial.Server.User;
import static com.lubrindustrial.View.Home.escritorio;
import static com.lubrindustrial.View.LocationsEdit.cbox_department;
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

public class Locations extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();

    ArrayList<Location> locs = new ArrayList<Location>();
    ArrayList<Department> departamentos = new ArrayList<Department>();
    User user = new User();
    String host = "";
    Conexion con;
    Connection cn;
//ArrayList<Articulos> lista = new ArrayList<Articulos>();
    public Locations() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
//        tab_locations.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tab_locations.doLayout();
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }

     public Locations(User usu) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
//        tab_locations.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tab_locations.doLayout();
        user = usu;
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }
     
     public Locations(User usu, String hostname) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        
//        tab_locations.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tab_locations.doLayout();
        user = usu;
        host=hostname;
        agregarDatos();
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }
    
    public int seleccionaritem() {
        int item = cbox.getSelectedIndex();
        return item;
    }

    private void agregarDatos() {

        DefaultTableModel model = (DefaultTableModel) tab_locations.getModel();

        model.setRowCount(0);
        String datos[] = new String[4];//ARRAY DE 4

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        LocationCRUD loctCRUD = new LocationCRUD(host);

        locs = loctCRUD.visualizar(); // devuelve todos los registros de la BD

        for (Location l : locs) {
            datos[0] = Integer.toString(l.getIdLocation());
            datos[1] = l.getNroLocation();
            datos[2] = l.getDescLocation();
            datos[3] = l.getNameDepartment();
            model.addRow(datos);
        }

    }

    private String[] arregloLocaciones(int idLocation) {

        String datos[] = new String[4];//ARRAY DE 4

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        LocationCRUD loctCRUD = new LocationCRUD(host);

        locs = loctCRUD.visualizar(idLocation); // devuelve todos los registros de la BD

        for (Location l : locs) {
            datos[0] = Integer.toString(l.getIdLocation());
            datos[1] = l.getNroLocation();
            datos[2] = l.getDescLocation();
            datos[3] = l.getNameDepartment();

        }
        return datos;
    }

    private void llenarComboBox() {
        DepartmentCRUD deptCRUD = new DepartmentCRUD(host);

        departamentos = deptCRUD.visualizar(); // devuelve todos los registros de la BD

        LocationsEdit.cbox_department.removeAllItems();

        for (Department d : departamentos) {
            LocationsEdit.cbox_department.addItem(d.getIdDepartment() + " " + d.getDescDepartment());
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
        tab_locations = new javax.swing.JTable();
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

        setTitle("Localizaciones");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_locations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Locación", "Número de Locación", "Descripcion Locación", "Departamento"
            }
        ));
        tab_locations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_locationsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_locations);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda Inmediata"));

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de Locación", "Descripción" }));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jButton3.setText("Detalles");
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
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/pdf.png"))); // NOI18N
        jButton5.setToolTipText("Generar informe en PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1)
                        .addComponent(btnEdit)
                        .addComponent(btnDelete)
                        .addComponent(jButton3))
                    .addComponent(jButton5))
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 630, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_locationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_locationsMouseClicked

    }//GEN-LAST:event_tab_locationsMouseClicked

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed

    private void txtInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyReleased

        DefaultTableModel model = (DefaultTableModel) tab_locations.getModel();
        model.setRowCount(0);
        LocationCRUD loc_query = new LocationCRUD(host);
        String datos[] = new String[5];//ARRAY DE 3
        if (txtInput.getText().isEmpty()) {

            for (int i = 0; i < tab_locations.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;
            }

        } else {
            locs = loc_query.visualizar(txtInput.getText(), seleccionaritem());

            for (Location l : locs) {
                datos[0] = Integer.toString(l.getIdLocation());
                datos[1] = l.getNroLocation();
                datos[2] = l.getDescLocation();
                datos[3] = l.getNameDepartment();
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

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxActionPerformed
        txtInput.setText("");
    }//GEN-LAST:event_cboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        LocationsNew obj = new LocationsNew(user,host);
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

        int filasel = tab_locations.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            //String cuenta;
            //cuenta = .getText();
            int n = JOptionPane.showConfirmDialog(null, "¿Esta seguro de borrar el registro? ", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                LocationCRUD obj = new LocationCRUD(host);
                obj.eliminar(Integer.parseInt(tab_locations.getValueAt(filasel, 0).toString()),user);
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

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        int filasel = tab_locations.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            LocationsEdit obj = new LocationsEdit(user,host);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            this.dispose();

            String dat[] = new String[4];
            dat = arregloLocaciones(Integer.parseInt(tab_locations.getValueAt(filasel, 0).toString()));
            LocationsEdit.lblID.setText(dat[0]);
            LocationsEdit.txt_NumberLocation.setText(dat[1]);
            LocationsEdit.txt_description.setText(dat[2]);
            llenarComboBox();
        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        agregarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        ReportsExcel reporte = new ReportsExcel(host);
        LocationCRUD eqCRUD = new LocationCRUD(host);
        ArrayList<Location> locs = eqCRUD.visualizar();
        if(reporte.escribirExcelLocaciones(locs)){
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE LOCACIONES CREADO","ARCHIVO GUARDADO EXITOSAMENTE",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE LOCACIONES NO CREADO","EROOR EN GUARDADO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

      try {
             JasperReport reporte = null;
             String path = "src\\lubrindustrial\\locaciones.jasper";
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
    private javax.swing.JTable tab_locations;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
