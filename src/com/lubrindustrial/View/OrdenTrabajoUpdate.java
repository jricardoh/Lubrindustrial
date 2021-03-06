/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Equipment;
import com.lubrindustrial.Server.Instruction;
import com.lubrindustrial.Server.InstructionCRUD;
import com.lubrindustrial.Server.MantenimientoCRUD;
import com.lubrindustrial.Server.Mantenimientos;
import com.lubrindustrial.Server.OrdenTrabajoCRUD;
import com.lubrindustrial.Server.OrdenTrabajos;
import com.lubrindustrial.Server.User;
import static com.lubrindustrial.View.Home.escritorio;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import com.toedter.components.JSpinField;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Jhonny
 */
public class OrdenTrabajoUpdate extends javax.swing.JInternalFrame {
    
    ArrayList<Mantenimientos> mante = new ArrayList<Mantenimientos>();
    User user = new User();
    String host;
    /**
     * Creates new form OrdenTrabajoUpdate
     */
    public OrdenTrabajoUpdate() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        llenarComboBoxMant();
    }
    
    public OrdenTrabajoUpdate(User us) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        llenarComboBoxMant();
        
        user = us;
    }
    
    private String obtenerFecha(JDateChooser jdc){
        
        try {
            String formato = /*"yyyy-MM-dd HH:mm:ss"*/"yyyy-MM-dd";
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
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
        try {
            Date fecha = formatter.parse(dateInString);
            return fecha;

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getHoraActual() {

//Instanciamos el objeto Calendar
//en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar();
//Obtenemos el valor del año, mes, día,
//hora, minuto y segundo del sistema
//usando el método get y el parámetro correspondiente
//        int anio = fecha.get(Calendar.YEAR);
//        int mes = fecha.get(Calendar.MONTH);
//        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
//        String ff = "" + dia + "/" + (mes + 1) + "/" + anio;
        String ff;
//                = System.out.println("Fecha Actual: "
//                        + dia + "/" + (mes + 1) + "/" + año);
//        System.out.printf("Hora Actual: %02d:%02d:%02d %n",
//                hora, minuto, segundo);
        ff = hora + ":" + minuto + ":" + segundo + ".0";
        return ff;
    }
    
    public OrdenTrabajoUpdate(User us,String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        
        user = us;
        host=hostname;
        llenarComboBoxMant();
        
    }
    
    
    private String obtenerHoraSpin(JSpinField jHora, JSpinField jMin, JSpinField jSeg){
        int hora, minuto, segundo;
        String h="", m="", s="";
        hora=jHora.getValue();
        minuto=jMin.getValue();
        segundo=jSeg.getValue();
        h=hora+"";
        m=minuto+"";
        s=segundo+"";
        //System.out.println(hora);
        if(h.length()==1){
            h="0"+h;
        }
        if(m.length()==1){
            m="0"+m;
        }
        if(s.length()==1){
            s="0"+s;
        }
        String horatexto=h+":"+m+":"+s;
        return horatexto;
    }
    
    private void Volver(){
        OrdenTrabajo obj = new OrdenTrabajo(user,host);
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
    
    private void llenarComboBoxMant() {
        MantenimientoCRUD  mantCRUD = new MantenimientoCRUD(host);

        mante = mantCRUD.visualizar(); // devuelve todos los registros de la BD

        comboMant.removeAllItems();

        for (Mantenimientos m : mante) {
            
            comboMant.addItem(m.getIdMantenimiento() + " " + m.getDescMantenimiento());
            /*
            if(Integer.parseInt(txtBusqueda.getText())==m.getIdMantenimiento())
            {    
                comboMant.setSelectedItem(m.getIdMantenimiento() + " " + m.getDescMantenimiento());
            }*/
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
        jLabel9 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        NroOrdtr = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        priorOrdtr = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        descOrdtr = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        respOrdtr = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        tipOrdtr = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        estOrdtr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboMant = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        duraDiasOrdtr = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        aceptPorOrdtr = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        fallaOrdtr = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        descCausa = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        accRealOrdtr = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        prevTomdaOrdtr = new javax.swing.JTextField();
        botonBusqueda = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jdcFechHorSolOrdtr = new com.toedter.calendar.JDateChooser();
        jdcFechHorReqOrdtr = new com.toedter.calendar.JDateChooser();
        jdcIniOrdtr = new com.toedter.calendar.JDateChooser();
        jdcTerOrdtr = new com.toedter.calendar.JDateChooser();
        jdcFechHorEntOrdtr = new com.toedter.calendar.JDateChooser();
        jspinHoraSol = new com.toedter.components.JSpinField();
        jLabel5 = new javax.swing.JLabel();
        jspinMinSol = new com.toedter.components.JSpinField();
        jLabel3 = new javax.swing.JLabel();
        jspinSegSol = new com.toedter.components.JSpinField();
        jspinHoraReq = new com.toedter.components.JSpinField();
        jLabel6 = new javax.swing.JLabel();
        jspinMinReq = new com.toedter.components.JSpinField();
        jLabel7 = new javax.swing.JLabel();
        jspinSegReq = new com.toedter.components.JSpinField();
        jspinHoraIni = new com.toedter.components.JSpinField();
        jLabel8 = new javax.swing.JLabel();
        jspinMinIni = new com.toedter.components.JSpinField();
        jLabel10 = new javax.swing.JLabel();
        jspinSegIni = new com.toedter.components.JSpinField();
        jspinHoraTer = new com.toedter.components.JSpinField();
        jspinSegTer = new com.toedter.components.JSpinField();
        jLabel16 = new javax.swing.JLabel();
        jspinMinTer = new com.toedter.components.JSpinField();
        jLabel17 = new javax.swing.JLabel();
        jspinHoraEnt = new com.toedter.components.JSpinField();
        jLabel29 = new javax.swing.JLabel();
        jspinMinEnt = new com.toedter.components.JSpinField();
        jLabel30 = new javax.swing.JLabel();
        jspinSegEnt = new com.toedter.components.JSpinField();

        setTitle("Modificar Orden de Trabajo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Nro. Orden Trabajo");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 20));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eraser.png"))); // NOI18N
        jButton11.setText("Limpiar campos");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, 30));

        jLabel11.setText("Estado ");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 20));

        NroOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NroOrdtrActionPerformed(evt);
            }
        });
        NroOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NroOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NroOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(NroOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 160, 20));

        jLabel12.setText("Fecha Hora Solicitud ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 20));

        priorOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorOrdtrActionPerformed(evt);
            }
        });
        priorOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priorOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priorOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(priorOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 160, 20));

        jLabel13.setText("Tipo ");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 20));

        descOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descOrdtrActionPerformed(evt);
            }
        });
        descOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(descOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 160, 20));

        jLabel18.setText("Fecha Hora Requerida");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 20));

        respOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respOrdtrActionPerformed(evt);
            }
        });
        respOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                respOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                respOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(respOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 160, 20));

        jLabel19.setText("Respuesta");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 60, 20));

        jLabel20.setText("Fecha Inicio");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, 20));

        jLabel21.setText("Fecha Término ");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, 20));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave.setText("Modificar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, -1, 30));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, -1, 30));

        tipOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipOrdtrActionPerformed(evt);
            }
        });
        tipOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tipOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tipOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(tipOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 160, 20));

        jLabel14.setText("Prioridad ");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 20));

        jLabel15.setText("Descripción ");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 20));
        jPanel3.add(estOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 160, 20));

        jLabel1.setText("Mantenimiento: ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 20));

        comboMant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 200, -1));

        jLabel22.setText("Fecha Hora Entrega ");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, 20));

        jLabel23.setText("Duración Días ");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, 20));

        duraDiasOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duraDiasOrdtrActionPerformed(evt);
            }
        });
        duraDiasOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                duraDiasOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                duraDiasOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(duraDiasOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 160, 20));

        jLabel24.setText("Aceptado por");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, 20));

        aceptPorOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptPorOrdtrActionPerformed(evt);
            }
        });
        aceptPorOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aceptPorOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aceptPorOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(aceptPorOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 160, 20));

        jLabel25.setText("Falla");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, 20));

        fallaOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fallaOrdtrActionPerformed(evt);
            }
        });
        fallaOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fallaOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fallaOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(fallaOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 160, 20));

        jLabel26.setText("Descripción Causa");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, 20));

        descCausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descCausaActionPerformed(evt);
            }
        });
        descCausa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCausaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descCausaKeyTyped(evt);
            }
        });
        jPanel3.add(descCausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 160, 20));

        jLabel27.setText("Acción Realizada");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, 20));

        accRealOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accRealOrdtrActionPerformed(evt);
            }
        });
        accRealOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                accRealOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                accRealOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(accRealOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 160, 20));

        jLabel28.setText("Prevención Tomada");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, -1, 20));

        prevTomdaOrdtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevTomdaOrdtrActionPerformed(evt);
            }
        });
        prevTomdaOrdtr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prevTomdaOrdtrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prevTomdaOrdtrKeyTyped(evt);
            }
        });
        jPanel3.add(prevTomdaOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 160, 20));

        botonBusqueda.setText("Buscar");
        botonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBusquedaActionPerformed(evt);
            }
        });
        jPanel3.add(botonBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 90, -1));
        jPanel3.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 120, -1));

        jLabel4.setText("Id a modificar");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        txtMant.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.add(txtMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 160, -1));

        jLabel2.setText("Actual Mantenimiento:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, 20));
        jPanel3.add(jdcFechHorSolOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 160, -1));
        jPanel3.add(jdcFechHorReqOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 160, -1));
        jPanel3.add(jdcIniOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 160, -1));
        jPanel3.add(jdcTerOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 160, -1));
        jPanel3.add(jdcFechHorEntOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 160, -1));

        jspinHoraSol.setMaximum(23);
        jspinHoraSol.setMinimum(0);
        jPanel3.add(jspinHoraSol, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 45, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText(":");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 10, -1));

        jspinMinSol.setMaximum(59);
        jspinMinSol.setMinimum(0);
        jPanel3.add(jspinMinSol, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 45, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText(":");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        jspinSegSol.setMaximum(59);
        jspinSegSol.setMinimum(0);
        jPanel3.add(jspinSegSol, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 45, -1));

        jspinHoraReq.setMaximum(23);
        jspinHoraReq.setMinimum(0);
        jPanel3.add(jspinHoraReq, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 45, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText(":");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 10, -1));

        jspinMinReq.setMaximum(59);
        jspinMinReq.setMinimum(0);
        jPanel3.add(jspinMinReq, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 45, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText(":");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        jspinSegReq.setMaximum(59);
        jspinSegReq.setMinimum(0);
        jPanel3.add(jspinSegReq, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 45, -1));

        jspinHoraIni.setMaximum(23);
        jspinHoraIni.setMinimum(0);
        jPanel3.add(jspinHoraIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 45, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText(":");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 10, -1));

        jspinMinIni.setMaximum(59);
        jspinMinIni.setMinimum(0);
        jPanel3.add(jspinMinIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 45, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText(":");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, -1, -1));

        jspinSegIni.setMaximum(59);
        jspinSegIni.setMinimum(0);
        jPanel3.add(jspinSegIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 45, -1));

        jspinHoraTer.setMaximum(23);
        jspinHoraTer.setMinimum(0);
        jPanel3.add(jspinHoraTer, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 45, -1));

        jspinSegTer.setMaximum(59);
        jspinSegTer.setMinimum(0);
        jPanel3.add(jspinSegTer, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 45, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText(":");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, -1, -1));

        jspinMinTer.setMaximum(59);
        jspinMinTer.setMinimum(0);
        jPanel3.add(jspinMinTer, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 45, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText(":");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 10, -1));

        jspinHoraEnt.setMaximum(23);
        jspinHoraEnt.setMinimum(0);
        jPanel3.add(jspinHoraEnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 45, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText(":");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 10, -1));

        jspinMinEnt.setMaximum(59);
        jspinMinEnt.setMinimum(0);
        jPanel3.add(jspinMinEnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 45, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText(":");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, -1, -1));

        jspinSegEnt.setMaximum(59);
        jspinSegEnt.setMinimum(0);
        jPanel3.add(jspinSegEnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 45, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 803, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NroOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NroOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NroOrdtrActionPerformed

    private void NroOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NroOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NroOrdtrKeyReleased

    private void NroOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NroOrdtrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_NroOrdtrKeyTyped

    private void priorOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priorOrdtrActionPerformed

    private void priorOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priorOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_priorOrdtrKeyReleased

    private void priorOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priorOrdtrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_priorOrdtrKeyTyped

    private void descOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descOrdtrActionPerformed

    private void descOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_descOrdtrKeyReleased

    private void descOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descOrdtrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_descOrdtrKeyTyped

    private void respOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respOrdtrActionPerformed

    private void respOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_respOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_respOrdtrKeyReleased

    private void respOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_respOrdtrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_respOrdtrKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //OBTENGO ANTERIOR REGISTRO
        OrdenTrabajoCRUD otCRUD=new OrdenTrabajoCRUD(host);
        OrdenTrabajos otAn=new OrdenTrabajos();
        otAn=otCRUD.mostrarPorCodigo(Integer.parseInt(txtBusqueda.getText()));
        ////Obtengo los nuevos
        OrdenTrabajoCRUD ordtrCRUD = new OrdenTrabajoCRUD(host);
        OrdenTrabajos otDes = new OrdenTrabajos();
        //Para tener el codigo de mantenimiento
        
        //para tener la fecha
        Calendar calendario = new GregorianCalendar();
        int anio, mes, dia, hora, min, seg;
        anio=calendario.get(Calendar.YEAR);
        mes=calendario.get(Calendar.MONTH);
        dia=calendario.get(Calendar.DATE);
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        min = calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND);
        String fecha=anio+"-"+mes+"-"+dia+" "+hora+":"+min+":"+seg;
        //para mantenimiento combo
        String codMant="";

        try{

            codMant=comboMant.getSelectedItem().toString();
            String []splitD = codMant.split(" ");
            codMant = splitD[0];
            otDes.setIdOrdtr(Integer.parseInt(txtBusqueda.getText()));
            otDes.setIdMant(Integer.parseInt(codMant));
            otDes.setNroOrdtr(NroOrdtr.getText());
            otDes.setDescOrdtr(descOrdtr.getText());
            otDes.setEstOrdtr(estOrdtr.getText());
            otDes.setTipoOrdtr(tipOrdtr.getText());
            otDes.setPriorOrdtr(priorOrdtr.getText());
            otDes.setFechHorSolicitudOrdtr(obtenerFecha(jdcFechHorSolOrdtr)+" "+obtenerHoraSpin(jspinHoraSol,jspinMinSol,jspinSegSol));
            otDes.setFechHorReqOrdtr(obtenerFecha(jdcFechHorReqOrdtr));
            otDes.setRespOrdtr(respOrdtr.getText());
            otDes.setInicioOrdtr(obtenerFecha(jdcIniOrdtr));
            otDes.setTermOrdtr(obtenerFecha(jdcTerOrdtr));
            otDes.setFechHoraEntOrdtr(obtenerFecha(jdcFechHorEntOrdtr));
            otDes.setDuracionDiasOrdtr(Float.parseFloat(duraDiasOrdtr.getText()));
            otDes.setAceptPorOrdtr(aceptPorOrdtr.getText());
            otDes.setFallaOrdtr(fallaOrdtr.getText());
            otDes.setDescCausaOrdtr(descCausa.getText());
            otDes.setAccionRealizOrdtr(accRealOrdtr.getText());
            otDes.setPrevenTomadaOrdtr(prevTomdaOrdtr.getText());

            if(ordtrCRUD.modificar(otAn, otDes, fecha, user)){
                JOptionPane.showMessageDialog(null, "ORDEN DE TRABAJO MODIFICADA","CAMBIO EXITOSO",JOptionPane.INFORMATION_MESSAGE);
                //Volver();
            }else{
                JOptionPane.showMessageDialog(null, "ORDEN DE TRABAJO NO MODIFICADA","ERROR EN EL CAMBIO", JOptionPane.ERROR_MESSAGE);
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

    private void tipOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipOrdtrActionPerformed

    private void tipOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tipOrdtrKeyReleased

    private void tipOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipOrdtrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tipOrdtrKeyTyped

    private void duraDiasOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duraDiasOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duraDiasOrdtrActionPerformed

    private void duraDiasOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duraDiasOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_duraDiasOrdtrKeyReleased

    private void duraDiasOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duraDiasOrdtrKeyTyped

        char c = evt.getKeyChar();

        if (((c < '0') || (c > '9')) && (c != '.')) {
            evt.consume();
        }
        if (c == '.' && duraDiasOrdtr.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_duraDiasOrdtrKeyTyped

    private void aceptPorOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptPorOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptPorOrdtrActionPerformed

    private void aceptPorOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aceptPorOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptPorOrdtrKeyReleased

    private void aceptPorOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aceptPorOrdtrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptPorOrdtrKeyTyped

    private void fallaOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fallaOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fallaOrdtrActionPerformed

    private void fallaOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fallaOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fallaOrdtrKeyReleased

    private void fallaOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fallaOrdtrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fallaOrdtrKeyTyped

    private void descCausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descCausaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descCausaActionPerformed

    private void descCausaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCausaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_descCausaKeyReleased

    private void descCausaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCausaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_descCausaKeyTyped

    private void accRealOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accRealOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accRealOrdtrActionPerformed

    private void accRealOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accRealOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_accRealOrdtrKeyReleased

    private void accRealOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accRealOrdtrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_accRealOrdtrKeyTyped

    private void prevTomdaOrdtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevTomdaOrdtrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prevTomdaOrdtrActionPerformed

    private void prevTomdaOrdtrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prevTomdaOrdtrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_prevTomdaOrdtrKeyReleased

    private void prevTomdaOrdtrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prevTomdaOrdtrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_prevTomdaOrdtrKeyTyped

    private void botonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBusquedaActionPerformed
        
        OrdenTrabajoCRUD otCRUD=new OrdenTrabajoCRUD(host);
        OrdenTrabajos ot=new OrdenTrabajos();
        ot=otCRUD.mostrarPorCodigo(Integer.parseInt(txtBusqueda.getText()));
        txtMant.setEnabled(false);
        txtMant.setText(ot.getIdMant()+"");
        NroOrdtr.setText(ot.getNroOrdtr());
        accRealOrdtr.setText(ot.getAccionRealizOrdtr());
        aceptPorOrdtr.setText(ot.getAceptPorOrdtr());
        descCausa.setText(ot.getDescCausaOrdtr());
        descOrdtr.setText(ot.getDescOrdtr());
        duraDiasOrdtr.setText(ot.getDuracionDiasOrdtr()+"");
        estOrdtr.setText(ot.getEstOrdtr());
        fallaOrdtr.setText(ot.getFallaOrdtr());
        jdcFechHorSolOrdtr.setDate(textoAFecha(ot.getFechHorSolicitudOrdtr()));
        jdcFechHorReqOrdtr.setDate(textoAFecha(ot.getFechHorReqOrdtr()));
        jdcIniOrdtr.setDate(textoAFecha(ot.getInicioOrdtr()));
        jdcTerOrdtr.setDate(textoAFecha(ot.getTermOrdtr()));
        prevTomdaOrdtr.setText(ot.getPrevenTomadaOrdtr());
        priorOrdtr.setText(ot.getPriorOrdtr());
        respOrdtr.setText(ot.getRespOrdtr());
        jdcFechHorEntOrdtr.setDate(textoAFecha(ot.getFechHoraEntOrdtr()));
        tipOrdtr.setText(ot.getTipoOrdtr());

    }//GEN-LAST:event_botonBusquedaActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NroOrdtr;
    private javax.swing.JTextField accRealOrdtr;
    private javax.swing.JTextField aceptPorOrdtr;
    private javax.swing.JButton botonBusqueda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboMant;
    private javax.swing.JTextField descCausa;
    private javax.swing.JTextField descOrdtr;
    private javax.swing.JTextField duraDiasOrdtr;
    private javax.swing.JTextField estOrdtr;
    private javax.swing.JTextField fallaOrdtr;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jdcFechHorEntOrdtr;
    private com.toedter.calendar.JDateChooser jdcFechHorReqOrdtr;
    private com.toedter.calendar.JDateChooser jdcFechHorSolOrdtr;
    private com.toedter.calendar.JDateChooser jdcIniOrdtr;
    private com.toedter.calendar.JDateChooser jdcTerOrdtr;
    private com.toedter.components.JSpinField jspinHoraEnt;
    private com.toedter.components.JSpinField jspinHoraIni;
    private com.toedter.components.JSpinField jspinHoraReq;
    private com.toedter.components.JSpinField jspinHoraSol;
    private com.toedter.components.JSpinField jspinHoraTer;
    private com.toedter.components.JSpinField jspinMinEnt;
    private com.toedter.components.JSpinField jspinMinIni;
    private com.toedter.components.JSpinField jspinMinReq;
    private com.toedter.components.JSpinField jspinMinSol;
    private com.toedter.components.JSpinField jspinMinTer;
    private com.toedter.components.JSpinField jspinSegEnt;
    private com.toedter.components.JSpinField jspinSegIni;
    private com.toedter.components.JSpinField jspinSegReq;
    private com.toedter.components.JSpinField jspinSegSol;
    private com.toedter.components.JSpinField jspinSegTer;
    private javax.swing.JTextField prevTomdaOrdtr;
    private javax.swing.JTextField priorOrdtr;
    private javax.swing.JTextField respOrdtr;
    private javax.swing.JTextField tipOrdtr;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtMant;
    // End of variables declaration//GEN-END:variables
}
