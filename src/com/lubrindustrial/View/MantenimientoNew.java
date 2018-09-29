/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Employee;
import com.lubrindustrial.Server.EmployeeCRUD;
import com.lubrindustrial.Server.Equipment;
import com.lubrindustrial.Server.EquipmentCRUD;
import com.lubrindustrial.Server.Instruction;
import com.lubrindustrial.Server.InstructionCRUD;
import com.lubrindustrial.Server.Location;
import com.lubrindustrial.Server.LocationCRUD;
import com.lubrindustrial.Server.MantenimientoCRUD;
import com.lubrindustrial.Server.Mantenimientos;
import com.lubrindustrial.Server.User;
import static com.lubrindustrial.View.Home.escritorio;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Jhonny
 */
public class MantenimientoNew extends javax.swing.JInternalFrame {
    DefaultListModel modeloLista = new DefaultListModel();
    DefaultListModel modeloLista1 = new DefaultListModel();
    
    ArrayList<Equipment> equipos = new ArrayList<Equipment>();
    ArrayList<Location> locacion = new ArrayList<Location>();
    ArrayList<Employee> empleados = new ArrayList<Employee>();
    ArrayList<Instruction> instrucciones = new ArrayList<Instruction>();
    User user = new User();
    String host;
    /**
     * Creates new form MantenimientoNew
     */
    public MantenimientoNew() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        comboEquipo.setVisible(false);
        comboLocacion.setVisible(false);
        listaEmpleados.setModel(modeloLista);
        listaInstrucciones.setModel(modeloLista1);
        llenarComboBoxEqui();
        llenarComboBoxLocacion();
        llenarComboBoxEmp();
        llenarComboBoxInstruc();
    }
    
    public MantenimientoNew(User us, String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        comboEquipo.setVisible(false);
        comboLocacion.setVisible(false);
        listaEmpleados.setModel(modeloLista);
        listaInstrucciones.setModel(modeloLista1);
        user = us;
        host=hostname;
        
        llenarComboBoxEqui();
        llenarComboBoxLocacion();
        llenarComboBoxEmp();
        llenarComboBoxInstruc();
    }
    
    private void llenarComboBoxEmp() {
        EmployeeCRUD  empCRUD = new EmployeeCRUD(host);

        empleados = empCRUD.visualizar(); // devuelve todos los registros de la BD

        comboEmp.removeAllItems();

        for (Employee e : empleados) {
            comboEmp.addItem(e.getIdEmployee() + " " + e.getNomEmployee());
        }
    }
    
    private String obtenerFecha(JDateChooser jdc){
        
        try {
            String formato = "yyyy-MM-dd";
            Date date = jdc.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String fecha = String.valueOf(sdf.format(date));
            return fecha;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es una fecha válida", "Error..!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    private void llenarComboBoxInstruc() {
        InstructionCRUD  instCRUD = new InstructionCRUD(host);

        instrucciones = instCRUD.visualizar(); // devuelve todos los registros de la BD

        comboInst.removeAllItems();

        for (Instruction i : instrucciones) {
            comboInst.addItem(i.getIdInst() + " " + i.getDescInst());
        }
    }
    
    private void llenarComboBoxEqui() {
        EquipmentCRUD  equCRUD = new EquipmentCRUD(host);

        equipos = equCRUD.visualizar(); // devuelve todos los registros de la BD

        comboEquipo.removeAllItems();

        for (Equipment e : equipos) {
            comboEquipo.addItem(e.getIdEquipment() + " " + e.getDescEquipment());
        }
    }
    private void llenarComboBoxLocacion() {
        LocationCRUD  locCRUD = new LocationCRUD(host);

        locacion = locCRUD.visualizar(); // devuelve todos los registros de la BD

        comboLocacion.removeAllItems();

        for (Location l : locacion) {
            comboLocacion.addItem(l.getIdLocation() + " " + l.getDescLocation());
        }
    }
    private void Volver(){
        Mantenimiento obj = new Mantenimiento(user,host);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        grupoOpciones = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtNroTareaMant = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        diasMantenimiento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        desMantenimiento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        radioEquipo = new javax.swing.JRadioButton();
        radioLocacion = new javax.swing.JRadioButton();
        comboEquipo = new javax.swing.JComboBox<>();
        comboLocacion = new javax.swing.JComboBox<>();
        frecMantenimiento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        durTareaMantenimiento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        oficioMant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboEmp = new javax.swing.JComboBox<>();
        botonAniadoE = new javax.swing.JButton();
        botonAniadoI = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaInstrucciones = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JList<>();
        jLabel22 = new javax.swing.JLabel();
        horasProgramadas = new javax.swing.JTextField();
        comboInst = new javax.swing.JComboBox<>();
        jdcFechaInicioMant = new com.toedter.calendar.JDateChooser();
        jdcFechProgIniMant = new com.toedter.calendar.JDateChooser();
        jdcFechProgTermMant = new com.toedter.calendar.JDateChooser();
        jdcProxFechMant = new com.toedter.calendar.JDateChooser();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Tipo de Mantenimiento:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel9.setText("Nro. Tarea Mantenimiento");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eraser.png"))); // NOI18N
        jButton11.setText("Limpiar campos");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, 30));

        jLabel11.setText("Oficio Mantenimiento");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 20));

        txtNroTareaMant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroTareaMantActionPerformed(evt);
            }
        });
        txtNroTareaMant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNroTareaMantKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroTareaMantKeyTyped(evt);
            }
        });
        jPanel3.add(txtNroTareaMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 153, 20));

        jLabel12.setText("Duración Tareas Mantenimiento");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 20));

        diasMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diasMantenimientoActionPerformed(evt);
            }
        });
        diasMantenimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                diasMantenimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                diasMantenimientoKeyTyped(evt);
            }
        });
        jPanel3.add(diasMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 153, 20));

        jLabel13.setText("Frecuencia Mantenimiento");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 20));

        desMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desMantenimientoActionPerformed(evt);
            }
        });
        desMantenimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desMantenimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                desMantenimientoKeyTyped(evt);
            }
        });
        jPanel3.add(desMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 153, 20));

        jLabel18.setText("Fecha Inicio Mantenimiento");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, 20));

        jLabel19.setText("Fecha Programada Inicio Mant.");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, 20));

        jLabel20.setText("Fecha Programada Término Mant.");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, 20));

        jLabel21.setText("Próxima Fecha Mantenimiento");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, 20));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, 30));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, 30));

        grupoOpciones.add(radioEquipo);
        radioEquipo.setText("Equipo");
        radioEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioEquipoMouseClicked(evt);
            }
        });
        jPanel3.add(radioEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        grupoOpciones.add(radioLocacion);
        radioLocacion.setText("Localización");
        radioLocacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioLocacionMouseClicked(evt);
            }
        });
        radioLocacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLocacionActionPerformed(evt);
            }
        });
        jPanel3.add(radioLocacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        comboEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        comboLocacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboLocacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        frecMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frecMantenimientoActionPerformed(evt);
            }
        });
        frecMantenimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                frecMantenimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                frecMantenimientoKeyTyped(evt);
            }
        });
        jPanel3.add(frecMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 153, 20));

        jLabel14.setText("Días Mantenimiento");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        durTareaMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durTareaMantenimientoActionPerformed(evt);
            }
        });
        durTareaMantenimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                durTareaMantenimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                durTareaMantenimientoKeyTyped(evt);
            }
        });
        jPanel3.add(durTareaMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 153, 20));

        jLabel15.setText("Descripción Mantenimiento");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));
        jPanel3.add(oficioMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 150, 20));

        jLabel1.setText("Instrucciones:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, 20));

        jLabel2.setText("Empleados:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        comboEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, -1));

        botonAniadoE.setText("Añadir");
        botonAniadoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadoEActionPerformed(evt);
            }
        });
        jPanel3.add(botonAniadoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 90, -1));

        botonAniadoI.setText("Añadir");
        botonAniadoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadoIActionPerformed(evt);
            }
        });
        jPanel3.add(botonAniadoI, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 90, -1));

        jButton1.setText("Quitar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 90, -1));

        jButton2.setText("Quitar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 90, -1));

        listaInstrucciones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaInstrucciones);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 140, 90));

        listaEmpleados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaEmpleados);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 130, 90));

        jLabel22.setText("Horas Programadas");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 140, 20));

        horasProgramadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasProgramadasActionPerformed(evt);
            }
        });
        horasProgramadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                horasProgramadasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                horasProgramadasKeyTyped(evt);
            }
        });
        jPanel3.add(horasProgramadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 150, 20));

        comboInst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboInst, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 120, -1));
        jPanel3.add(jdcFechaInicioMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 150, -1));
        jPanel3.add(jdcFechProgIniMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 150, -1));
        jPanel3.add(jdcFechProgTermMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 150, -1));
        jPanel3.add(jdcProxFechMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 150, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 880, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNroTareaMantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroTareaMantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroTareaMantActionPerformed

    private void txtNroTareaMantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroTareaMantKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroTareaMantKeyReleased

    private void txtNroTareaMantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroTareaMantKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroTareaMantKeyTyped

    private void diasMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diasMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diasMantenimientoActionPerformed

    private void diasMantenimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diasMantenimientoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_diasMantenimientoKeyReleased

    private void diasMantenimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diasMantenimientoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_diasMantenimientoKeyTyped

    private void desMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desMantenimientoActionPerformed

    private void desMantenimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desMantenimientoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_desMantenimientoKeyReleased

    private void desMantenimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desMantenimientoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_desMantenimientoKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int codMant=0;
        ArrayList<Integer> mant=new ArrayList<Integer>(); 
        MantenimientoCRUD manCRUD = new MantenimientoCRUD(host);
        Mantenimientos m = new Mantenimientos();
        mant=manCRUD.visualizarCodigo();
        //Para tener el codigo de mantenimiento
        for(int i=0; i<mant.size();i++)
        {
            codMant=mant.get(i);
        }
        codMant++;
        //para equipo y locacion
        String comEq="";
        String comL="";
        String comEmp="";
        String comInst="";
        ArrayList<Integer> codigoEmpleados=new ArrayList<>();
        ArrayList<Integer> codigoInstrucciones=new ArrayList<>();
        try{
            if(radioEquipo.isSelected())
            {
                comEq=comboEquipo.getSelectedItem().toString();
                String []splitD = comEq.split(" ");
                comEq = splitD[0];
                comL="0";
            }
            else
            {
                comL=comboLocacion.getSelectedItem().toString();
                String []splitD = comL.split(" ");
                comL = splitD[0];
                comEq="0";
            }
            //codigoEmpleados.add(1);
            //codigoInstrucciones.add(1);


            for(int i=0;i<modeloLista.size();i++)
            {
                String temp=modeloLista.get(i).toString();
                String []splitEmp=temp.split(" ");
                codigoEmpleados.add(Integer.parseInt(splitEmp[0]));

            }
            
            for(int i=0;i<modeloLista1.size();i++)
            {
                String temp=modeloLista1.get(i).toString();
                String []splitEmp=temp.split(" ");
                codigoInstrucciones.add(Integer.parseInt(splitEmp[0]));

            }

            
            m.setIdMantenimiento(codMant);
            
            m.setIdEquipo(Integer.parseInt(comEq));
            m.setIdLocacion(Integer.parseInt(comL));
            m.setNroTareaMant(txtNroTareaMant.getText());
            m.setDescMantenimiento(desMantenimiento.getText());
            m.setOficioMantenimiento(oficioMant.getText());
            m.setFrecuenciaMant(frecMantenimiento.getText());
            m.setDiasMant(Integer.parseInt(diasMantenimiento.getText()));
            m.setDurTareaMant(Integer.parseInt(durTareaMantenimiento.getText()));
            m.setFechIniMantenimiento(obtenerFecha(jdcFechaInicioMant));
            m.setFechProgInicMant(obtenerFecha(jdcFechProgIniMant));
            m.setFechProgTermMant(obtenerFecha(jdcFechProgTermMant));
            m.setFechProximaMant(obtenerFecha(jdcProxFechMant));
            m.setHorasProgramadas(Integer.parseInt(horasProgramadas.getText()));

            if(manCRUD.insertar(m, codigoEmpleados, codigoInstrucciones)){
                JOptionPane.showMessageDialog(null, "MANTENIMIENTO REGISTRADO","REGISTRO EXITOSO",JOptionPane.INFORMATION_MESSAGE);
                Volver();
            }else{
                JOptionPane.showMessageDialog(null, "MANTENIMIENTO NO REGISTRADO","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error obtener los datos", "ERROR DATOS", JOptionPane.ERROR_MESSAGE);
            System.out.println(""+ex.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
//        Volver();
//        this.dispose();
        this.doDefaultCloseAction();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void radioLocacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLocacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioLocacionActionPerformed

    private void radioEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioEquipoMouseClicked
        comboEquipo.setVisible(true);
            comboLocacion.setVisible(false);
    }//GEN-LAST:event_radioEquipoMouseClicked

    private void radioLocacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioLocacionMouseClicked
        comboLocacion.setVisible(true);
            comboEquipo.setVisible(false);
    }//GEN-LAST:event_radioLocacionMouseClicked

    private void frecMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frecMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_frecMantenimientoActionPerformed

    private void frecMantenimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frecMantenimientoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_frecMantenimientoKeyReleased

    private void frecMantenimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frecMantenimientoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_frecMantenimientoKeyTyped

    private void durTareaMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durTareaMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durTareaMantenimientoActionPerformed

    private void durTareaMantenimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durTareaMantenimientoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_durTareaMantenimientoKeyReleased

    private void durTareaMantenimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durTareaMantenimientoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_durTareaMantenimientoKeyTyped

    private void botonAniadoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadoEActionPerformed
        modeloLista.addElement(comboEmp.getSelectedItem()); 
    }//GEN-LAST:event_botonAniadoEActionPerformed

    private void botonAniadoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadoIActionPerformed
        modeloLista1.addElement(comboEmp.getSelectedItem());
    }//GEN-LAST:event_botonAniadoIActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        System.out.println(obtenerFecha(jdcProxFechMant));
        System.out.println(obtenerFecha(jdcFechProgIniMant));
        System.out.println(obtenerFecha(jdcFechProgTermMant));
        System.out.println(obtenerFecha(jdcProxFechMant));

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index = listaEmpleados.getSelectedIndex(); 
        modeloLista.remove(index); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = listaInstrucciones.getSelectedIndex(); 
        modeloLista1.remove(index);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void horasProgramadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasProgramadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasProgramadasActionPerformed

    private void horasProgramadasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horasProgramadasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_horasProgramadasKeyReleased

    private void horasProgramadasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horasProgramadasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_horasProgramadasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAniadoE;
    private javax.swing.JButton botonAniadoI;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboEmp;
    private javax.swing.JComboBox<String> comboEquipo;
    private javax.swing.JComboBox<String> comboInst;
    private javax.swing.JComboBox<String> comboLocacion;
    private javax.swing.JTextField desMantenimiento;
    private javax.swing.JTextField diasMantenimiento;
    private javax.swing.JTextField durTareaMantenimiento;
    private javax.swing.JTextField frecMantenimiento;
    private javax.swing.ButtonGroup grupoOpciones;
    private javax.swing.JTextField horasProgramadas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFechProgIniMant;
    private com.toedter.calendar.JDateChooser jdcFechProgTermMant;
    private com.toedter.calendar.JDateChooser jdcFechaInicioMant;
    private com.toedter.calendar.JDateChooser jdcProxFechMant;
    private javax.swing.JList<String> listaEmpleados;
    private javax.swing.JList<String> listaInstrucciones;
    private javax.swing.JTextField oficioMant;
    private javax.swing.JRadioButton radioEquipo;
    private javax.swing.JRadioButton radioLocacion;
    private javax.swing.JTextField txtNroTareaMant;
    // End of variables declaration//GEN-END:variables
}
