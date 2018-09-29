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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.text.ParseException;



/**
 *
 * @author Jhonny
 */
public class MantenimientoUpdate extends javax.swing.JInternalFrame {
    DefaultListModel modeloLista = new DefaultListModel();
    DefaultListModel modeloLista1 = new DefaultListModel();
    ///////////////////////////////////////////////////
    ArrayList<Equipment> equipos = new ArrayList<Equipment>();
    ArrayList<Location> locacion = new ArrayList<Location>();
    ArrayList<Employee> empleados = new ArrayList<Employee>();
    ArrayList<Instruction> instrucciones = new ArrayList<Instruction>();
    User user = new User();
    String host;
    /**
     * Creates new form MantenimientoUpdate
     */
    public MantenimientoUpdate() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        listaEmpleados.setModel(modeloLista);
        listaInstrucciones.setModel(modeloLista1);
        comboEquipo.setVisible(false);
        comboLocacion.setVisible(false);
        llenarComboBoxEqui();
        llenarComboBoxLocacion();
        llenarComboBoxEmp();
        llenarComboBoxInstruc();
    }
    
    public MantenimientoUpdate(User us) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        listaEmpleados.setModel(modeloLista);
        listaInstrucciones.setModel(modeloLista1);
        llenarComboBoxEqui();
        llenarComboBoxLocacion();
        llenarComboBoxEmp();
        llenarComboBoxInstruc();
        
        user = us;
    }
    
    public MantenimientoUpdate(User us,String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
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
    
    private Date textoAFecha(String dateInString){
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                
        try {
            Date fecha = formatter.parse(dateInString);
            return fecha;
            
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
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
        jLabel5 = new javax.swing.JLabel();
        botonBusqueda = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        horasProgramadas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboEmp = new javax.swing.JComboBox<>();
        botonAniadoE = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        comboInst = new javax.swing.JComboBox<>();
        botonAniadoI = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaInstrucciones = new javax.swing.JList<>();
        jdcFechaInicioMant = new com.toedter.calendar.JDateChooser();
        jdcFechProgIniMant = new com.toedter.calendar.JDateChooser();
        jdcFechProgTermMant = new com.toedter.calendar.JDateChooser();
        jdcProxFechMant = new com.toedter.calendar.JDateChooser();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Id a modificar");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 20));

        jLabel9.setText("Nro. Tarea Mantenimiento");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eraser.png"))); // NOI18N
        jButton11.setText("Limpiar campos");
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, -1, 30));

        jLabel11.setText("Oficio Mantenimiento");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 20));
        jPanel3.add(txtNroTareaMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 153, 20));

        jLabel12.setText("Duración Tareas Mantenimiento");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 20));
        jPanel3.add(diasMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 153, 20));

        jLabel13.setText("Frecuencia Mantenimiento");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));
        jPanel3.add(desMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 153, 20));

        jLabel18.setText("Fecha Inicio Mantenimiento");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, 20));

        jLabel19.setText("Fecha Programada Inicio Mant.");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, -1, 20));

        jLabel20.setText("Fecha Programada Término Mant.");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, 20));

        jLabel21.setText("Próxima Fecha Mantenimiento");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, 20));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave.setText("Modificar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, 30));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, -1, 30));

        buttonGroup1.add(radioEquipo);
        radioEquipo.setText("Equipo");
        radioEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioEquipoMouseClicked(evt);
            }
        });
        jPanel3.add(radioEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        buttonGroup1.add(radioLocacion);
        radioLocacion.setText("Localización");
        radioLocacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioLocacionMouseClicked(evt);
            }
        });
        jPanel3.add(radioLocacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        comboEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        comboLocacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboLocacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));
        jPanel3.add(frecMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 153, 20));

        jLabel14.setText("Días Mantenimiento");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 20));
        jPanel3.add(durTareaMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 153, 20));

        jLabel15.setText("Descripción Mantenimiento");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));
        jPanel3.add(oficioMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 150, 20));

        jLabel5.setText("Tipo de Mantenimiento:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));

        botonBusqueda.setText("Buscar");
        botonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBusquedaActionPerformed(evt);
            }
        });
        jPanel3.add(botonBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 90, -1));
        jPanel3.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 120, -1));

        jLabel22.setText("Horas Programadas");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 120, 20));
        jPanel3.add(horasProgramadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 153, 20));

        jLabel6.setText("Empleados:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        comboEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, -1));

        botonAniadoE.setText("Añadir");
        botonAniadoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadoEActionPerformed(evt);
            }
        });
        jPanel3.add(botonAniadoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 90, -1));

        botonQuitar.setText("Quitar");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });
        jPanel3.add(botonQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 90, -1));

        listaEmpleados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaEmpleados);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 130, 90));

        jLabel1.setText("Instrucciones:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, 20));

        comboInst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboInst, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 120, -1));

        botonAniadoI.setText("Añadir");
        botonAniadoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadoIActionPerformed(evt);
            }
        });
        jPanel3.add(botonAniadoI, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 90, -1));

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jPanel3.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 90, -1));

        listaInstrucciones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listaInstrucciones);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 140, 90));
        jPanel3.add(jdcFechaInicioMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 150, -1));
        jPanel3.add(jdcFechProgIniMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 150, -1));
        jPanel3.add(jdcFechProgTermMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 150, -1));
        jPanel3.add(jdcProxFechMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 150, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 870, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBusquedaActionPerformed
        modeloLista.clear();
        modeloLista1.clear();
        MantenimientoCRUD mantCRUD=new MantenimientoCRUD(host);
        ArrayList<Mantenimientos> Mant=new ArrayList<Mantenimientos>();
        Mantenimientos m=new Mantenimientos();
        m=mantCRUD.mostrarPorCodigo(Integer.parseInt(txtBusqueda.getText()));
        
        diasMantenimiento.setText(m.getDiasMant()+"");
        desMantenimiento.setText(m.getDescMantenimiento()+"");
        durTareaMantenimiento.setText(m.getDurTareaMant()+"");
        jdcFechaInicioMant.setDate(textoAFecha(m.getFechIniMantenimiento()+""));
        jdcFechProgIniMant.setDate(textoAFecha(m.getFechProgInicMant()+""));
        jdcFechProgTermMant.setDate(textoAFecha(m.getFechProgTermMant()+""));
        frecMantenimiento.setText(m.getFrecuenciaMant()+"");
        oficioMant.setText(m.getOficioMantenimiento()+"");
        jdcProxFechMant.setDate(textoAFecha(m.getFechProximaMant()+""));
        txtNroTareaMant.setText(m.getNroTareaMant()+"");
        horasProgramadas.setText(m.getHorasProgramadas()+"");
        if(m.getIdEquipo()!=0){
            radioEquipo.setSelected(true);
            comboLocacion.setVisible(false);
        }else
        {
            radioLocacion.setSelected(true);
            comboEquipo.setVisible(false);
        }
        //Datos empleado
        EmployeeCRUD empCRUD=new EmployeeCRUD(host);
        ArrayList<Employee> listaEmp=new ArrayList<Employee>();
        listaEmp=empCRUD.mostrarPorCodigo(Integer.parseInt(txtBusqueda.getText()));
        for(int i=0;i<listaEmp.size();i++)
        {
            modeloLista.addElement(listaEmp.get(i).getIdEmployee()+" "+listaEmp.get(i).getNomEmployee());
        }
        
        //Datos instrucciones
        InstructionCRUD instCRUD=new InstructionCRUD(host);
        ArrayList<Instruction> listaInst=new ArrayList<Instruction>();
        listaInst=instCRUD.mostrarPorCodigo(Integer.parseInt(txtBusqueda.getText()));
        for(int i=0;i<listaInst.size();i++)
        {
            modeloLista1.addElement(listaInst.get(i).getIdInst()+" "+listaInst.get(i).getDescInst());
        }
        
        
    }//GEN-LAST:event_botonBusquedaActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //codigo de mantenimiento
        int codMant=Integer.parseInt(txtBusqueda.getText());
        //codigos antes
        EmployeeCRUD empCRUD=new EmployeeCRUD(host);
        ArrayList<Employee> codAnEmpleados=new ArrayList<>();
        ArrayList<Instruction> codAnInstruc=new ArrayList<>();
        codAnEmpleados=empCRUD.mostrarPorCodigo(codMant);
        InstructionCRUD instCRUD=new InstructionCRUD(host);
        codAnInstruc=instCRUD.mostrarPorCodigo(codMant);
        //mantenimiento antes
        MantenimientoCRUD mantCRUD=new MantenimientoCRUD(host);
        Mantenimientos mAn=new Mantenimientos();
        mAn=mantCRUD.mostrarPorCodigo(codMant);
        //mantenimiento despues
        MantenimientoCRUD manCRUD = new MantenimientoCRUD(host);
        Mantenimientos mDes = new Mantenimientos();
        //tiempo que aplasto
        Calendar calendario = new GregorianCalendar();
        int anio, mes, dia, hora, min, seg;
        anio=calendario.get(Calendar.YEAR);
        mes=calendario.get(Calendar.MONTH);
        dia=calendario.get(Calendar.DATE);
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        min = calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND);
        String fecha=anio+"-"+mes+"-"+dia+" "+hora+":"+min+":"+seg;
        //para equipo y locacion
        String comEq="";
        String comL="";
        ArrayList<Integer> codigoDesEmpleados=new ArrayList<>();
        ArrayList<Integer> codigoDesInstrucciones=new ArrayList<>();
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

            
            for(int i=0;i<modeloLista.size();i++)
            {
                String temp=modeloLista.get(i).toString();
                String []splitEmp=temp.split(" ");
                codigoDesEmpleados.add(Integer.parseInt(splitEmp[0]));
                //JOptionPane.showMessageDialog(null, "cod empleado: "+splitEmp[0]);
            }
            
            for(int i=0;i<modeloLista1.size();i++)
            {
                String temp=modeloLista1.get(i).toString();
                String []splitEmp=temp.split(" ");
                codigoDesInstrucciones.add(Integer.parseInt(splitEmp[0]));
                //JOptionPane.showMessageDialog(null, "cod instrucc: "+splitEmp[0]);
            }
            
            mDes.setIdMantenimiento(codMant);
            
            mDes.setIdEquipo(Integer.parseInt(comEq));
            //JOptionPane.showMessageDialog(null, "todo bien hasta setear datos"+codMant);
            mDes.setIdLocacion(Integer.parseInt(comL));
            mDes.setNroTareaMant(txtNroTareaMant.getText());
            mDes.setDescMantenimiento(desMantenimiento.getText());
            mDes.setOficioMantenimiento(oficioMant.getText());
            mDes.setFrecuenciaMant(frecMantenimiento.getText());
            mDes.setDiasMant(Integer.parseInt(diasMantenimiento.getText()));
            mDes.setDurTareaMant(Integer.parseInt(durTareaMantenimiento.getText()));
            mDes.setFechIniMantenimiento(obtenerFecha(jdcFechaInicioMant));
            mDes.setFechProgInicMant(obtenerFecha(jdcFechProgIniMant));
            mDes.setFechProgTermMant(obtenerFecha(jdcFechProgTermMant));
            mDes.setFechProximaMant(obtenerFecha(jdcProxFechMant));
            mDes.setHorasProgramadas(Integer.parseInt(horasProgramadas.getText()));

            if(manCRUD.modificar(mAn, mDes, codAnEmpleados, codAnInstruc, codigoDesEmpleados, codigoDesInstrucciones, fecha, user)){
                JOptionPane.showMessageDialog(null, "MANTENIMIENTO MODIFICADO","CAMBIO EXITOSO",JOptionPane.INFORMATION_MESSAGE);
                Volver();
            }else{
                JOptionPane.showMessageDialog(null, "MANTENIMIENTO NO MODIFICADO","ERROR EN EL CAMBIO", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error obtener los datos", "ERROR DATOS", JOptionPane.ERROR_MESSAGE);
            System.out.println(""+ex.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Volver();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void radioEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioEquipoMouseClicked
        comboEquipo.setVisible(true);
            comboLocacion.setVisible(false);
    }//GEN-LAST:event_radioEquipoMouseClicked

    private void radioLocacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioLocacionMouseClicked
        comboLocacion.setVisible(true);
            comboEquipo.setVisible(false);
    }//GEN-LAST:event_radioLocacionMouseClicked

    private void botonAniadoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadoEActionPerformed
        modeloLista.addElement(comboEmp.getSelectedItem());
    }//GEN-LAST:event_botonAniadoEActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        int index = listaEmpleados.getSelectedIndex();
        modeloLista.remove(index);
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonAniadoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadoIActionPerformed
        modeloLista1.addElement(comboInst.getSelectedItem());
    }//GEN-LAST:event_botonAniadoIActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int index = listaInstrucciones.getSelectedIndex();
        modeloLista1.remove(index);
    }//GEN-LAST:event_btnQuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAniadoE;
    private javax.swing.JButton botonAniadoI;
    private javax.swing.JButton botonBusqueda;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitar;
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
    private javax.swing.JTextField horasProgramadas;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jdcFechProgIniMant;
    private com.toedter.calendar.JDateChooser jdcFechProgTermMant;
    private com.toedter.calendar.JDateChooser jdcFechaInicioMant;
    private com.toedter.calendar.JDateChooser jdcProxFechMant;
    private javax.swing.JList<String> listaEmpleados;
    private javax.swing.JList<String> listaInstrucciones;
    private javax.swing.JTextField oficioMant;
    private javax.swing.JRadioButton radioEquipo;
    private javax.swing.JRadioButton radioLocacion;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtNroTareaMant;
    // End of variables declaration//GEN-END:variables
}
