/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tartlate file, choose Tools | Tartlates
 * and open the tartlate in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Employee;
import com.lubrindustrial.Server.EmployeeCRUD;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.lubrindustrial.Server.Equipment;
import com.lubrindustrial.Server.EquipmentCRUD;
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
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;


public class EquipmentEdit extends javax.swing.JInternalFrame {

    ArrayList<Employee> empleados = new ArrayList<Employee>();
    ArrayList<Location> locaciones = new ArrayList<Location>();
    ArrayList<Equipment> equipos = new ArrayList<Equipment>();
    User user = new User();
    String host="";

    public EquipmentEdit() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        llenarComboBoxLoc();
        llenarComboBoxEquiposPadres();
        llenarComboBoxResponsable();
        this.setIconifiable(true);
        this.setClosable(true);
        lblID.setVisible(false);
        lblID.setEnabled(false);
//        this.setLocationRelativeTo(null);
//        rsscalelabel.RSScaleLabel.setScaleLabel(lblImage, "carburador.jpg");

    }

    public EquipmentEdit(User us, String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        llenarComboBoxLoc();
        llenarComboBoxEquiposPadres();
        llenarComboBoxResponsable();
        this.setIconifiable(true);
        this.setClosable(true);
        lblID.setVisible(false);
        lblID.setEnabled(false);
        
        user = us;
        host=hostname;
    }
    
    private void Volver(){
        Equipments obj = new Equipments(user,host);
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
    
     public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
     private String agregaBarraInvertida(String r){
        String aux="";
        for(int i=0; i<r.length(); i++){
            if(r.charAt(i)=='\\'){
                aux+=(r.charAt(i)+"\\");
            }else{
                aux+=(r.charAt(i));
            }
            
        }
        return aux;
    }
     
    private void llenarComboBoxResponsable(){
        
        EmployeeCRUD empCRUD = new EmployeeCRUD(host);
        empleados = empCRUD.visualizar(); // devuelve todos los registros de la BD
        cbox_responsable.removeAllItems();

        for (Employee e : empleados) {
            cbox_responsable.addItem(e.getIdEmployee() + " " + e.getNomEmployee() + " "+ e.getApeEmployee());
        }
    } 
   
    private void llenarComboBoxEquiposPadres(){
        
        EquipmentCRUD equipCRUD = new EquipmentCRUD(host);
        equipos = equipCRUD.visualizar(); // devuelve todos los registros de la BD
        cbox_padreEQ.removeAllItems();

        cbox_padreEQ.addItem("Ninguno");
        for (Equipment e : equipos) {
            cbox_padreEQ.addItem(e.getIdEquipment() + " " + e.getDescEquipment());
        }
    }
     
    private void llenarComboBoxLoc() {
        
        LocationCRUD locCRUD = new LocationCRUD(host);
        locaciones = locCRUD.visualizar(); // devuelve todos los registros de la BD
        cbox_location.removeAllItems();

        for (Location l : locaciones) {
            cbox_location.addItem(l.getIdLocation() + " " + l.getDescLocation());
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

        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txt_DescEquipment = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_NroModEquipment = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_NroSerieEquipment = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_TipoEquipment = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_EstadoEquipment = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_FabricEquipment = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_FechaCompEquipment = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_FechaVentEquipment = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_ContratistaEquipment = new javax.swing.JTextField();
        txt_NroEquipment = new javax.swing.JTextField();
        cbox_padreEQ = new javax.swing.JComboBox<>();
        btnSave1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        txt_FechaIniEquipment = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbox_location = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbox_responsable = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        txt_Piezas = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txt_foto = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        setTitle("Editar Equipo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Equipo Padre");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eraser.png"))); // NOI18N
        jButton12.setText("Limpiar campos");
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        jLabel25.setText("Descripción");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 20));

        txt_DescEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DescEquipmentActionPerformed(evt);
            }
        });
        txt_DescEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_DescEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_DescEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_DescEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 153, -1));

        jLabel26.setText("No. Modelo");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        txt_NroModEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NroModEquipmentActionPerformed(evt);
            }
        });
        txt_NroModEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_NroModEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NroModEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_NroModEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 153, -1));

        jLabel27.setText("No. Serie");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));

        txt_NroSerieEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NroSerieEquipmentActionPerformed(evt);
            }
        });
        txt_NroSerieEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_NroSerieEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NroSerieEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_NroSerieEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 153, -1));

        jLabel28.setText("Tipo de Equipo");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 20));

        txt_TipoEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TipoEquipmentActionPerformed(evt);
            }
        });
        txt_TipoEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TipoEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TipoEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_TipoEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 153, -1));

        jLabel29.setText("Estado");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 20));

        txt_EstadoEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EstadoEquipmentActionPerformed(evt);
            }
        });
        txt_EstadoEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_EstadoEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_EstadoEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_EstadoEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 153, -1));

        jLabel30.setText("No. de Equipo");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        jLabel31.setText("Fabricante");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, 20));

        txt_FabricEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FabricEquipmentActionPerformed(evt);
            }
        });
        txt_FabricEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_FabricEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_FabricEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_FabricEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 153, -1));

        jLabel32.setText("Fecha de Compra");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, 20));

        txt_FechaCompEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FechaCompEquipmentActionPerformed(evt);
            }
        });
        txt_FechaCompEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_FechaCompEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_FechaCompEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_FechaCompEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 153, -1));

        jLabel33.setText("Fecha Inicial");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 20));

        txt_FechaVentEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FechaVentEquipmentActionPerformed(evt);
            }
        });
        txt_FechaVentEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_FechaVentEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_FechaVentEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_FechaVentEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 153, -1));

        jLabel34.setText("Fecha de Venta");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, 20));

        jLabel35.setText("Contratista");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, 20));

        txt_ContratistaEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ContratistaEquipmentActionPerformed(evt);
            }
        });
        txt_ContratistaEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ContratistaEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ContratistaEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_ContratistaEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 153, -1));

        txt_NroEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NroEquipmentActionPerformed(evt);
            }
        });
        txt_NroEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_NroEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NroEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_NroEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 153, -1));

        cbox_padreEQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_padreEQActionPerformed(evt);
            }
        });
        jPanel4.add(cbox_padreEQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 150, -1));

        btnSave1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        btnCancelar1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar1.setText("Cerrar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        txt_FechaIniEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FechaIniEquipmentActionPerformed(evt);
            }
        });
        txt_FechaIniEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_FechaIniEquipmentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_FechaIniEquipmentKeyTyped(evt);
            }
        });
        jPanel4.add(txt_FechaIniEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 153, -1));

        jLabel9.setText("Id de Locación");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        cbox_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_locationActionPerformed(evt);
            }
        });
        jPanel4.add(cbox_location, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 150, -1));

        jLabel10.setText("Responsable");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        cbox_responsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_responsableActionPerformed(evt);
            }
        });
        jPanel4.add(cbox_responsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, -1));

        jLabel36.setText("Piezas");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, 20));

        txt_Piezas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PiezasActionPerformed(evt);
            }
        });
        txt_Piezas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PiezasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PiezasKeyTyped(evt);
            }
        });
        jPanel4.add(txt_Piezas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 153, -1));

        jLabel37.setText("Imagen");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, 20));

        txt_foto.setEditable(false);
        txt_foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_fotoMouseClicked(evt);
            }
        });
        txt_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fotoActionPerformed(evt);
            }
        });
        txt_foto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_fotoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fotoKeyTyped(evt);
            }
        });
        jPanel4.add(txt_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 153, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 340));
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 40, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_DescEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DescEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DescEquipmentActionPerformed

    private void txt_DescEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DescEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DescEquipmentKeyReleased

    private void txt_DescEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DescEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DescEquipmentKeyTyped

    private void txt_NroModEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NroModEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NroModEquipmentActionPerformed

    private void txt_NroModEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NroModEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NroModEquipmentKeyReleased

    private void txt_NroModEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NroModEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NroModEquipmentKeyTyped

    private void txt_NroSerieEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NroSerieEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NroSerieEquipmentActionPerformed

    private void txt_NroSerieEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NroSerieEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NroSerieEquipmentKeyReleased

    private void txt_NroSerieEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NroSerieEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NroSerieEquipmentKeyTyped

    private void txt_TipoEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TipoEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TipoEquipmentActionPerformed

    private void txt_TipoEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TipoEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TipoEquipmentKeyReleased

    private void txt_TipoEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TipoEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TipoEquipmentKeyTyped

    private void txt_EstadoEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EstadoEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EstadoEquipmentActionPerformed

    private void txt_EstadoEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EstadoEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EstadoEquipmentKeyReleased

    private void txt_EstadoEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_EstadoEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EstadoEquipmentKeyTyped

    private void txt_FabricEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FabricEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FabricEquipmentActionPerformed

    private void txt_FabricEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FabricEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FabricEquipmentKeyReleased

    private void txt_FabricEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FabricEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FabricEquipmentKeyTyped

    private void txt_FechaCompEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FechaCompEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaCompEquipmentActionPerformed

    private void txt_FechaCompEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FechaCompEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaCompEquipmentKeyReleased

    private void txt_FechaCompEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FechaCompEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaCompEquipmentKeyTyped

    private void txt_FechaVentEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FechaVentEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaVentEquipmentActionPerformed

    private void txt_FechaVentEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FechaVentEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaVentEquipmentKeyReleased

    private void txt_FechaVentEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FechaVentEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaVentEquipmentKeyTyped

    private void txt_ContratistaEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ContratistaEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContratistaEquipmentActionPerformed

    private void txt_ContratistaEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContratistaEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContratistaEquipmentKeyReleased

    private void txt_ContratistaEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContratistaEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContratistaEquipmentKeyTyped

    private void txt_NroEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NroEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NroEquipmentActionPerformed

    private void txt_NroEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NroEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NroEquipmentKeyReleased

    private void txt_NroEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NroEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NroEquipmentKeyTyped

    private void cbox_padreEQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_padreEQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_padreEQActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed

        EquipmentCRUD equiCRUD = new EquipmentCRUD(host);
        Equipment e = new Equipment();
        String cadEquip="",cadLoc="",cadEmple="";
        
        try{
            cadLoc=cbox_location.getSelectedItem().toString();
            String []splitLoc = cadLoc.split(" ");
            cadLoc = splitLoc[0];
                      
            cadEmple=cbox_responsable.getSelectedItem().toString();
            String []splitEm = cadEmple.split(" ");
            cadEmple = splitEm[0];
            
            if(cbox_padreEQ.getItemCount()==1){
                e.setIdPadreEq(0);
            }else{
                if(cbox_padreEQ.getSelectedItem().toString().equals("Ninguno")){
                    e.setIdPadreEq(0);
                    System.out.println("Registro de un padre");
                }else{
                    cadEquip=cbox_padreEQ.getSelectedItem().toString();
                    String []splitPadre = cadEquip.split(" ");
                    cadEquip = splitPadre[0];
                    e.setIdPadreEq(Integer.parseInt(cadEquip));
                }
                
            }
                
            
            e.setIdEquipment(Integer.parseInt(lblID.getText()));
            e.setIdLocation(Integer.parseInt(cadLoc));
            e.setIdEmployee(Integer.parseInt(cadEmple));
            
            e.setNroEquipment(txt_NroEquipment.getText());
            e.setDescEquipment(txt_DescEquipment.getText());
            e.setNroModEquipment(txt_NroModEquipment.getText());
            e.setNroSerieEquipment(txt_NroSerieEquipment.getText());
            e.setTipoEquipment(txt_TipoEquipment.getText());
            e.setEstadoEquipment(txt_EstadoEquipment.getText());
            e.setFabricEquipment(txt_FabricEquipment.getText());
            e.setFechaCompEquipment((txt_FechaCompEquipment.getText()));
            e.setFechaIniEquipment((txt_FechaIniEquipment.getText()));
            e.setFechaVentEquipment((txt_FechaVentEquipment.getText()));
            e.setContratistaEquipment(txt_ContratistaEquipment.getText());
            e.setPiezas(txt_Piezas.getText());
            e.setFoto(txt_foto.getText());
            e.setActivoEquipment(1);

            if(equiCRUD.modificar(e,user)){
                JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO CORRECTAMENTE","REGISTRO EXITOSO",JOptionPane.INFORMATION_MESSAGE);
                Volver();
            }else{
                JOptionPane.showMessageDialog(null, "REGISTRO NO MODIFICADO","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error obtener los datos", "ERROR DATOS", JOptionPane.ERROR_MESSAGE);
            System.out.println("Excepcion "+ex.getMessage());
        }

    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        Volver();
        this.dispose();

    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void txt_FechaIniEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FechaIniEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaIniEquipmentActionPerformed

    private void txt_FechaIniEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FechaIniEquipmentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaIniEquipmentKeyReleased

    private void txt_FechaIniEquipmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FechaIniEquipmentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FechaIniEquipmentKeyTyped

    private void cbox_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_locationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_locationActionPerformed

    private void cbox_responsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_responsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_responsableActionPerformed

    private void txt_PiezasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PiezasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PiezasActionPerformed

    private void txt_PiezasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PiezasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PiezasKeyReleased

    private void txt_PiezasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PiezasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PiezasKeyTyped

    private void txt_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fotoActionPerformed

    private void txt_fotoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fotoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fotoKeyReleased

    private void txt_fotoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fotoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fotoKeyTyped

    private void txt_fotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_fotoMouseClicked
        // TODO add your handling code here:
        String path="";
        try{
 
            JFileChooser explorador = new JFileChooser();
            explorador.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            explorador.showOpenDialog(explorador);
            
            path=explorador.getSelectedFile().getAbsolutePath();
            path=agregaBarraInvertida(path);
//            System.out.println("abs: "+abs);
//            System.out.println("rel: "+rel);
            System.out.println("En modificar; "+path);
            txt_foto.setText(path);
            
        }catch(Exception ex){
            System.out.println(""+ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txt_fotoMouseClicked
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
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnSave1;
    public static javax.swing.JComboBox<String> cbox_location;
    public static javax.swing.JComboBox<String> cbox_padreEQ;
    public static javax.swing.JComboBox<String> cbox_responsable;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JLabel lblID;
    public static javax.swing.JTextField txt_ContratistaEquipment;
    public static javax.swing.JTextField txt_DescEquipment;
    public static javax.swing.JTextField txt_EstadoEquipment;
    public static javax.swing.JTextField txt_FabricEquipment;
    public static javax.swing.JTextField txt_FechaCompEquipment;
    public static javax.swing.JTextField txt_FechaIniEquipment;
    public static javax.swing.JTextField txt_FechaVentEquipment;
    public static javax.swing.JTextField txt_NroEquipment;
    public static javax.swing.JTextField txt_NroModEquipment;
    public static javax.swing.JTextField txt_NroSerieEquipment;
    public static javax.swing.JTextField txt_Piezas;
    public static javax.swing.JTextField txt_TipoEquipment;
    public static javax.swing.JTextField txt_foto;
    // End of variables declaration//GEN-END:variables
}
