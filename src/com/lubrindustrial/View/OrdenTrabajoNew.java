/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.MantenimientoCRUD;
import com.lubrindustrial.Server.Mantenimientos;
import com.lubrindustrial.Server.OrdenTrabajoCRUD;
import com.lubrindustrial.Server.OrdenTrabajos;
import com.lubrindustrial.Server.User;
import static com.lubrindustrial.View.Home.escritorio;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
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
public class OrdenTrabajoNew extends javax.swing.JInternalFrame {
    
    ArrayList<Mantenimientos> mantenimientos = new ArrayList<Mantenimientos>();
    User user = new User();
    String host;
    
    /**
     * Creates new form OrdenTrabajoNew
     */
    public OrdenTrabajoNew() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        llenarComboBoxOrdenTrab();
        
        
    }
    
    public OrdenTrabajoNew(User us, String hostmame) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        user=us;
        host=hostmame;
        llenarComboBoxOrdenTrab();
        
        
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
    private void llenarComboBoxOrdenTrab() {
        MantenimientoCRUD mantCRUD = new MantenimientoCRUD(host);

        mantenimientos = mantCRUD.visualizar(); // devuelve todos los registros de la BD

        comboMant.removeAllItems();

        for (Mantenimientos m : mantenimientos) {
            comboMant.addItem(m.getIdMantenimiento() + " " + m.getDescMantenimiento());
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
        jdcIniOrdtr = new com.toedter.calendar.JDateChooser();
        jdcFechHorSolOrdtr = new com.toedter.calendar.JDateChooser();
        jdcTerOrdtr = new com.toedter.calendar.JDateChooser();
        jdcFechHorEntOrdtr = new com.toedter.calendar.JDateChooser();
        jdcFechHorReqOrdtr = new com.toedter.calendar.JDateChooser();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Nro. Orden Trabajo");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eraser.png"))); // NOI18N
        jButton11.setText("Limpiar campos");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, 30));

        jLabel11.setText("Estado ");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

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
        jPanel3.add(NroOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 153, 20));

        jLabel12.setText("Fecha Hora Solicitud ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

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
        jPanel3.add(priorOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 153, 20));

        jLabel13.setText("Tipo ");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

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
        jPanel3.add(descOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 153, 20));

        jLabel18.setText("Fecha Hora Requerida");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

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
        jPanel3.add(respOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 153, 20));

        jLabel19.setText("Respuesta");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        jLabel20.setText("Fecha Inicio");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, 20));

        jLabel21.setText("Fecha Término ");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, 20));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/guardar.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, 30));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, 30));

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
        jPanel3.add(tipOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 153, 20));

        jLabel14.setText("Prioridad ");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        jLabel15.setText("Descripción ");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));
        jPanel3.add(estOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 150, 20));

        jLabel1.setText("Mantenimiento: ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        comboMant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboMant, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 210, -1));

        jLabel22.setText("Fecha Hora Entrega ");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, 20));

        jLabel23.setText("Duración Días ");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, 20));

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
        jPanel3.add(duraDiasOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 153, 20));

        jLabel24.setText("Aceptado por");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, 20));

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
        jPanel3.add(aceptPorOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 153, 20));

        jLabel25.setText("Falla");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, 20));

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
        jPanel3.add(fallaOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 153, 20));

        jLabel26.setText("Descripción Causa");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, 20));

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
        jPanel3.add(descCausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 153, 20));

        jLabel27.setText("Acción Realizada");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, 20));

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
        jPanel3.add(accRealOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 153, 20));

        jLabel28.setText("Prevención Tomada");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, -1, 20));

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
        jPanel3.add(prevTomdaOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 153, 20));
        jPanel3.add(jdcIniOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 150, -1));
        jPanel3.add(jdcFechHorSolOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 150, -1));
        jPanel3.add(jdcTerOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 150, -1));
        jPanel3.add(jdcFechHorEntOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 150, -1));
        jPanel3.add(jdcFechHorReqOrdtr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 150, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 760, 390));

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

        OrdenTrabajoCRUD ordtrCRUD = new OrdenTrabajoCRUD(host);
        OrdenTrabajos ot = new OrdenTrabajos();
        //Para tener el codigo de mantenimiento
        
        //para mantenimiento combo
        String codMant="";

        try{
            
                codMant=comboMant.getSelectedItem().toString();
                String []splitD = codMant.split(" ");
                codMant = splitD[0];
            JOptionPane.showMessageDialog(null, "Codigo Mant es: "+codMant);

            

            ot.setIdMant(Integer.parseInt(codMant));
            ot.setNroOrdtr(NroOrdtr.getText());
            ot.setDescOrdtr(descOrdtr.getText());
            ot.setEstOrdtr(estOrdtr.getText());
            ot.setTipoOrdtr(tipOrdtr.getText());
            ot.setPriorOrdtr(priorOrdtr.getText());
            ot.setFechHorSolicitudOrdtr(obtenerFecha(jdcFechHorSolOrdtr)+" "+getHoraActual());
            ot.setFechHorReqOrdtr(obtenerFecha(jdcFechHorReqOrdtr)+" "+getHoraActual());
            ot.setRespOrdtr(respOrdtr.getText());
            ot.setInicioOrdtr(obtenerFecha(jdcIniOrdtr)+" "+getHoraActual());
            ot.setTermOrdtr(obtenerFecha(jdcTerOrdtr)+" "+getHoraActual());
            ot.setFechHoraEntOrdtr(obtenerFecha(jdcFechHorEntOrdtr)+" "+getHoraActual());
            ot.setDuracionDiasOrdtr(Float.parseFloat(duraDiasOrdtr.getText()));
            ot.setAceptPorOrdtr(aceptPorOrdtr.getText());
            ot.setFallaOrdtr(fallaOrdtr.getText());
            ot.setDescCausaOrdtr(descCausa.getText());
            ot.setAccionRealizOrdtr(accRealOrdtr.getText());
            ot.setPrevenTomadaOrdtr(prevTomdaOrdtr.getText());
            
            if(ordtrCRUD.insertar(ot)){
                JOptionPane.showMessageDialog(null, "ORDEN DE TRABAJO GENERADA","REGISTRO EXITOSO",JOptionPane.INFORMATION_MESSAGE);
                //Volver();
            }else{
                JOptionPane.showMessageDialog(null, "ORDEN DE TRABAJO NO GENERADA","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
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

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        System.out.println(getHoraActual());
        
        
        
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NroOrdtr;
    private javax.swing.JTextField accRealOrdtr;
    private javax.swing.JTextField aceptPorOrdtr;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jdcFechHorEntOrdtr;
    private com.toedter.calendar.JDateChooser jdcFechHorReqOrdtr;
    private com.toedter.calendar.JDateChooser jdcFechHorSolOrdtr;
    private com.toedter.calendar.JDateChooser jdcIniOrdtr;
    private com.toedter.calendar.JDateChooser jdcTerOrdtr;
    private javax.swing.JTextField prevTomdaOrdtr;
    private javax.swing.JTextField priorOrdtr;
    private javax.swing.JTextField respOrdtr;
    private javax.swing.JTextField tipOrdtr;
    // End of variables declaration//GEN-END:variables
}
