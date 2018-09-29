/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Employee;
import com.lubrindustrial.Server.EmployeeCRUD;
import com.lubrindustrial.Server.Equipment;
import com.lubrindustrial.Server.EquipmentCRUD;
import com.lubrindustrial.Server.Location;
import com.lubrindustrial.Server.LocationCRUD;
import com.lubrindustrial.Server.ReportsExcel;
import com.lubrindustrial.Server.User;
import static com.lubrindustrial.View.Home.escritorio;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

public class Equipments extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    //ArrayList<Equipment> equi = new ArrayList<Equipment>();
    ArrayList<Employee> empleados = new ArrayList<Employee>();
    ArrayList<Location> locaciones = new ArrayList<Location>();
    ArrayList<Equipment> equipos = new ArrayList<Equipment>();
    User user = new User();
    public String host;
    //EquipmentView obj = new EquipmentView();
    
    public Equipments() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
        tab_equipment.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_equipment.doLayout();
    }

    public Equipments(User usu) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
        tab_equipment.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_equipment.doLayout();
        user = usu;
    }
    
    public Equipments(User usu, String hostname) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        
        tab_equipment.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_equipment.doLayout();
        user = usu;
        host=hostname;
        
        agregarDatos();
    }
    
    public int seleccionaritem() {
        int item = cbox.getSelectedIndex();
        return item;
    }

    private void agregarDatos() {

        DefaultTableModel model = (DefaultTableModel) tab_equipment.getModel();

        model.setRowCount(0);
        String datos[] = new String[19];//ARRAY DE 16

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        EquipmentCRUD equiCRUD = new EquipmentCRUD(host);

        equipos = equiCRUD.visualizar(); // devuelve todos los registros de la BD

        for (Equipment e : equipos) {
            datos[0] = Integer.toString(e.getIdEquipment());
            datos[1] = Integer.toString(e.getIdLocation())+" "+e.getDescLoc();
            datos[2] = Integer.toString(e.getIdEmployee())+" "+e.getDescEmple();
            datos[3] = e.getNroEquipment();
            datos[4] = e.getDescEquipment();
            datos[5] = e.getNroModEquipment();
            datos[6] = e.getNroSerieEquipment();
            datos[7] = e.getTipoEquipment();
            datos[8] = e.getEstadoEquipment();
            datos[9] = e.getFabricEquipment();
            datos[10] = e.getFechaCompEquipment().toString();
            datos[11] = e.getFechaIniEquipment().toString();
            datos[12] = e.getFechaVentEquipment().toString();
            datos[13] = e.getContratistaEquipment();
            datos[14] = e.getPiezas();
            datos[15] = e.getDescEquipPadre();
            //datos[14] = Integer.toString(e.getActivoEquipment());
            //datos[16] = e.getDescEquipPadre();
            model.addRow(datos);
        }

    }

    private String[] arregloEquipos(int idEquipment) {

        String datos[] = new String[19];//ARRAY DE 16

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        EquipmentCRUD equiCRUD = new EquipmentCRUD(host);
        
        equipos = equiCRUD.visualizar(idEquipment); // devuelve todos los registros de la BD

        for (Equipment e : equipos) {
            datos[0] = Integer.toString(e.getIdEquipment());
            datos[1] = Integer.toString(e.getIdLocation())+" "+e.getDescLoc();
            datos[2] = Integer.toString(e.getIdEmployee())+" "+e.getDescEmple();
            datos[3] = e.getNroEquipment();
            datos[4] = e.getDescEquipment();
            datos[5] = e.getNroModEquipment();
            datos[6] = e.getNroSerieEquipment();
            datos[7] = e.getTipoEquipment();
            datos[8] = e.getEstadoEquipment();
            datos[9] = e.getFabricEquipment();
            datos[10] = e.getFechaCompEquipment().toString();
            datos[11] = e.getFechaIniEquipment().toString();
            datos[12] = e.getFechaVentEquipment().toString();
            datos[13] = e.getContratistaEquipment();
            datos[14] = e.getPiezas();
            datos[15] = e.getFoto();
            //datos[14] = Integer.toString(e.getActivoEquipment());
            datos[16] = e.getDescEquipPadre();

        }
        return datos;
    }

    private void llenarComboBoxResponsable() {

        EmployeeCRUD empCRUD = new EmployeeCRUD(host);
        empleados = empCRUD.visualizar(); // devuelve todos los registros de la BD
        EquipmentEdit.cbox_responsable.removeAllItems();
        //EquipmentView.cbox_responsable.removeAllItems();

        for (Employee e : empleados) {
            EquipmentEdit.cbox_responsable.addItem(e.getIdEmployee() + " " + e.getNomEmployee() + " " + e.getApeEmployee());
            //EquipmentView.cbox_responsable.addItem(e.getIdEmployee() + " " + e.getNomEmployee() + " " + e.getApeEmployee());
        }
    }

    private void llenarComboBoxEquiposPadres() {

        EquipmentCRUD equipCRUD = new EquipmentCRUD(host);
        equipos = equipCRUD.visualizar(); // devuelve todos los registros de la BD
        EquipmentEdit.cbox_padreEQ.removeAllItems();
        //EquipmentView.cbox_padreEQ.removeAllItems();
        
        EquipmentEdit.cbox_padreEQ.addItem("Ninguno");
        for (Equipment e : equipos) {
            EquipmentEdit.cbox_padreEQ.addItem(e.getIdEquipment() + " " + e.getDescEquipment());
            //EquipmentView.cbox_padreEQ.addItem(e.getIdEquipment() + " " + e.getDescEquipment());
        }
    }

    private void llenarComboBoxLoc() {

        LocationCRUD locCRUD = new LocationCRUD(host);
        locaciones = locCRUD.visualizar(); // devuelve todos los registros de la BD
        EquipmentEdit.cbox_location.removeAllItems();
        //EquipmentView.cbox_location.removeAllItems();
        
        for (Location l : locaciones) {
            EquipmentEdit.cbox_location.addItem(l.getIdLocation() + " " + l.getDescLocation());
            //EquipmentView.cbox_location.addItem(l.getIdLocation() + " " + l.getDescLocation());
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
        tab_equipment = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbox = new javax.swing.JComboBox<>();
        txtInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnArbol = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        setTitle("Equipos");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_equipment.setModel(new javax.swing.table.DefaultTableModel(
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
                "Id Equipo", "Id Locación", "Id Empleado", "No. Equipo", "Descripción", "No. Modelo", "No. Serie", "Tipo Equipo", "Estado", "Fabricante", "Fecha Compra", "Fecha Inicial", "Fecha Venta", "Contratista", "Piezas", "Padre"
            }
        ));
        tab_equipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_equipmentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_equipment);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de Equipo", "Descripción", "Número de Modelo", "Número de Serie", "Tipo de Equipo", "Estado", "Fabricante", "Contratista", "Piezas" }));
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

        btnArbol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/show_all.png"))); // NOI18N
        btnArbol.setText("Árbol Equipos");
        btnArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbolActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/excel_logo.png"))); // NOI18N
        jButton4.setToolTipText("Generar hoja de cálculo de Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/door_exit.png"))); // NOI18N
        jButton3.setText("Detalles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnArbol)
                        .addGap(4, 4, 4)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEdit)
                        .addComponent(btnDelete))
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(btnArbol))))
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_equipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_equipmentMouseClicked

        if(evt.getClickCount()==2){
            
        }
    }//GEN-LAST:event_tab_equipmentMouseClicked

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed

    private void txtInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyReleased

        DefaultTableModel model = (DefaultTableModel) tab_equipment.getModel();
        model.setRowCount(0);
        EquipmentCRUD equi_query = new EquipmentCRUD(host);
        String datos[] = new String[19];//ARRAY DE 3
        if (txtInput.getText().isEmpty()) {

            for (int i = 0; i < tab_equipment.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;
            }

        } else {
            equipos = equi_query.visualizar(txtInput.getText(), seleccionaritem());

            for (Equipment e : equipos) {
                datos[0] = Integer.toString(e.getIdEquipment());
                datos[1] = Integer.toString(e.getIdLocation());
                datos[2] = Integer.toString(e.getIdEmployee());
                datos[3] = e.getNroEquipment();
                datos[4] = e.getDescEquipment();
                datos[5] = e.getNroModEquipment();
                datos[6] = e.getNroSerieEquipment();
                datos[7] = e.getTipoEquipment();
                datos[8] = e.getEstadoEquipment();
                datos[9] = e.getFabricEquipment();
                datos[10] = e.getFechaCompEquipment().toString();
                datos[11] = e.getFechaIniEquipment().toString();
                datos[12] = e.getFechaVentEquipment().toString();
                datos[13] = e.getContratistaEquipment();
                //datos[14] = Integer.toString(e.getActivoEquipment());
                datos[14] = e.getDescEquipPadre();
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

        EquipmentNew obj = new EquipmentNew(user,host);
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

        int filasel = tab_equipment.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            //String cuenta;
            //cuenta = .getText();
            int n = JOptionPane.showConfirmDialog(null, "¿Esta seguro de borrar el registro? ", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                EquipmentCRUD obj = new EquipmentCRUD(host);
                obj.eliminar(Integer.parseInt(tab_equipment.getValueAt(filasel, 0).toString()),user);
                agregarDatos();
            }
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

//        this.dispose();
        //this.doDefaultCloseAction();
        int filasel = tab_equipment.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            EquipmentView obj = new EquipmentView(user,host);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            this.dispose();

            String dat[] = new String[18];
            dat = arregloEquipos(Integer.parseInt(tab_equipment.getValueAt(filasel, 0).toString()));
            //EquipmentView.lblID.setText(dat[0]);
            EquipmentView.txt_NroEquipment1.setText(dat[0]);
            EquipmentView.txt_EqPadre.setText(dat[3]);
            EquipmentView.txt_DescEquipment.setText(dat[4]);
            EquipmentView.txt_NroModEquipment.setText(dat[5]);
            EquipmentView.txt_NroSerieEquipment.setText(dat[6]);
            EquipmentView.txt_TipoEquipment.setText(dat[7]);
            EquipmentView.txt_EstadoEquipment.setText(dat[8]);
            EquipmentView.txt_FabricEquipment.setText(dat[9]);
            EquipmentView.txt_FechaCompEquipment.setText(dat[10]);
            EquipmentView.txt_FechaIniEquipment.setText(dat[11]);
            EquipmentView.txt_FechaVentEquipment.setText(dat[12]);
            EquipmentView.txt_ContratistaEquipment.setText(dat[13]);
            EquipmentView.txt_Piezas1.setText(dat[14]);
            EquipmentView.txt_Locacion.setText(dat[1]);
            EquipmentView.txt_Responsable.setText(dat[2]);
            EquipmentView.txt_EqPadre.setText(dat[16]);
            EquipmentView.txt_foto1.setText(dat[15]);
            EquipmentView.ruta=dat[15];
            //System.out.println("Ruta desde equipo: "+dat[15]);
//            llenarComboBoxEquiposPadres();
//            llenarComboBoxLoc();
//            llenarComboBoxResponsable();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

        this.setEnabled(true);

    }//GEN-LAST:event_formFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        agregarDatos();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        int filasel = tab_equipment.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            EquipmentEdit obj = new EquipmentEdit(user,host);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            this.dispose();

            String dat[] = new String[18];
            dat = arregloEquipos(Integer.parseInt(tab_equipment.getValueAt(filasel, 0).toString()));
            EquipmentEdit.lblID.setText(dat[0]);
            EquipmentEdit.txt_NroEquipment.setText(dat[3]);
            EquipmentEdit.txt_DescEquipment.setText(dat[4]);
            EquipmentEdit.txt_NroModEquipment.setText(dat[5]);
            EquipmentEdit.txt_NroSerieEquipment.setText(dat[6]);
            EquipmentEdit.txt_TipoEquipment.setText(dat[7]);
            EquipmentEdit.txt_EstadoEquipment.setText(dat[8]);
            EquipmentEdit.txt_FabricEquipment.setText(dat[9]);
            EquipmentEdit.txt_FechaCompEquipment.setText(dat[10]);
            EquipmentEdit.txt_FechaIniEquipment.setText(dat[11]);
            EquipmentEdit.txt_FechaVentEquipment.setText(dat[12]);
            EquipmentEdit.txt_ContratistaEquipment.setText(dat[13]);
            EquipmentEdit.txt_Piezas.setText(dat[14]);
            EquipmentEdit.txt_foto.setText(dat[15]);
//            llenarComboBoxEquiposPadres();
//            llenarComboBoxLoc();
//            llenarComboBoxResponsable();
        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void btnArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolActionPerformed
        // TODO add your handling code here:
        EquipmentTree obj = new EquipmentTree(user,host);
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
    }//GEN-LAST:event_btnArbolActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        ReportsExcel reporte = new ReportsExcel(host);
        EquipmentCRUD eqCRUD = new EquipmentCRUD(host);
        ArrayList<Equipment> equips = eqCRUD.visualizar();
        if (reporte.escribirExcelEquipos(equips)) {
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE EQUIPOS CREADO", "ARCHIVO GUARDADO EXITOSAMENTE", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE EQUIPOS NO CREADO", "EROOR EN GUARDADO", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArbol;
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
    private javax.swing.JTable tab_equipment;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
