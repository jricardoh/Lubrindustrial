/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Conexion;
import com.lubrindustrial.Server.Employee;
import com.lubrindustrial.Server.EmployeeCRUD;
import com.lubrindustrial.Server.Instruction;
import com.lubrindustrial.Server.InstructionCRUD;
import com.lubrindustrial.Server.MantenimientoCRUD;
import com.lubrindustrial.Server.Mantenimientos;
import com.lubrindustrial.Server.ReportsExcel;
import com.lubrindustrial.Server.User;
import static com.lubrindustrial.View.Home.escritorio;
import java.sql.Connection;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
/**
 *
 * @author Jhonny
 */
public class Mantenimiento extends javax.swing.JInternalFrame {
    
    DefaultTableModel modelo=new DefaultTableModel();
    ArrayList<Mantenimientos> mant = new ArrayList<Mantenimientos>();
    User user = new User();
    String host="";
    Conexion con;
    Connection cn;
    //ArrayList<Employee> emp = new ArrayList<Employee>();
    /**
     * Creates new form Mantenimiento
     */
    public Mantenimiento() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
        tab_mantenimiento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_mantenimiento.doLayout();
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }

    public Mantenimiento(User usu) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
        tab_mantenimiento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_mantenimiento.doLayout();
        user = usu;
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }
    
    public Mantenimiento(User usu, String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        
        tab_mantenimiento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_mantenimiento.doLayout();
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
    
    private void agregarDatos(){
        
        DefaultTableModel model = (DefaultTableModel)tab_mantenimiento.getModel();

        model.setRowCount(0);
        String datos[] = new String[14];//ARRAY DE 13

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        MantenimientoCRUD mantCRUD = new MantenimientoCRUD(host);
        
        mant = mantCRUD.visualizar(); // devuelve todos los registros de la BD

        for(Mantenimientos m: mant){
            datos[0] = Integer.toString(m.getIdMantenimiento());
            datos[1] = Integer.toString(m.getIdEquipo());
            datos[2] = Integer.toString(m.getIdLocacion());
            datos[3] = m.getNroTareaMant();
            datos[4] = m.getDescMantenimiento();
            datos[5] = m.getOficioMantenimiento();
            datos[6] = m.getFrecuenciaMant();
            datos[7] = Integer.toString(m.getDiasMant());
            datos[8] = Integer.toString(m.getDurTareaMant());
            datos[9] = m.getFechIniMantenimiento();
            datos[10] = m.getFechProgInicMant();
            datos[11] = m.getFechProgTermMant();
            datos[12] = m.getFechProximaMant();
            datos[13] = Integer.toString(m.getHorasProgramadas());
            model.addRow(datos);
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_mantenimiento = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbox = new javax.swing.JComboBox<>();
        txtInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/show_all.png"))); // NOI18N
        jButton2.setText("Mostrar todo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/door_exit.png"))); // NOI18N
        jButton3.setText("Detalles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eliminar.png"))); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/edit.png"))); // NOI18N
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/nuevo.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/excel_logo.png"))); // NOI18N
        jButton6.setToolTipText("Generar hoja de cálculo de Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 41, -1));

        tab_mantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Mantenimiento", "Id Equipos", "Id Locación", "Número de tarea ", "Descripción ", "Oficio ", "Frecuencia", "Días", "Duración Tareas ", "Fecha Inicio", "Fecha Prog. Inicio", "Fecha Prog. Término", "Próxima Fecha", "Horas Programadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_mantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_mantenimientoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_mantenimiento);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 180));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de Tarea", "Descripción", "Oficio", "Frecuencia", "Días de Mantenimiento", "Duración de Tarea", "Horas Programadas" }));
        cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxActionPerformed(evt);
            }
        });
        jPanel2.add(cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

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
        jPanel2.add(txtInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 30, 140, -1));

        jLabel1.setText("Cantidad de Registros:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, 20));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 70, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 660, 80));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/pdf.png"))); // NOI18N
        jButton7.setToolTipText("Generar informe en PDF");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            agregarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

//        this.dispose();
        this.doDefaultCloseAction();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void tab_mantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_mantenimientoMouseClicked

    }//GEN-LAST:event_tab_mantenimientoMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Calendar calendario = new GregorianCalendar();
        int anio, mes, dia, hora, min, seg;
        anio=calendario.get(Calendar.YEAR);
        mes=calendario.get(Calendar.MONTH);
        dia=calendario.get(Calendar.DATE);
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        min = calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND);
        String fecha=anio+"-"+mes+"-"+dia+" "+hora+":"+min+":"+seg;
        DefaultTableModel dtm = (DefaultTableModel)tab_mantenimiento.getModel(); 
        int codMant=Integer.parseInt(tab_mantenimiento.getValueAt(tab_mantenimiento.getSelectedRow(),0).toString());
        ///OBTENGO LA FILA CON EL CODIGO RESPECTIVO
        MantenimientoCRUD mantCRUD=new MantenimientoCRUD(host);
        Mantenimientos mant=new Mantenimientos();
        mant=mantCRUD.mostrarPorCodigo(codMant);
        //LA QUITO DE LA IMAGEN DE LA TABLA
        dtm.removeRow(tab_mantenimiento.getSelectedRow());
        //codigo empleados y codigo instrucciones
        EmployeeCRUD empCRUD=new EmployeeCRUD(host);
        ArrayList<Employee> codEmpleados=new ArrayList<>();
        ArrayList<Instruction> codInstruc=new ArrayList<>();
        codEmpleados=empCRUD.mostrarPorCodigo(codMant);
        InstructionCRUD instCRUD=new InstructionCRUD(host);
        codInstruc=instCRUD.mostrarPorCodigo(codMant);
        ///realizo el elimado (logico)

        mantCRUD.eliminar(mant, codEmpleados, codInstruc ,fecha, user);
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        MantenimientoNew obj = new MantenimientoNew(user,host);
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MantenimientoUpdate obj = new MantenimientoUpdate(user,host);
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxActionPerformed
        txtInput.setText("");
    }//GEN-LAST:event_cboxActionPerformed

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed

    private void txtInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyReleased

        DefaultTableModel model = (DefaultTableModel) tab_mantenimiento.getModel();
        model.setRowCount(0);
        MantenimientoCRUD mant_query = new MantenimientoCRUD(host);
        String datos[] = new String[14];//ARRAY DE 3
        if (txtInput.getText().isEmpty()) {

            for (int i = 0; i < tab_mantenimiento.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;
            }

        } else {
            mant = mant_query.visualizar(txtInput.getText(), seleccionaritem());

            for(Mantenimientos m: mant){
            datos[0] = Integer.toString(m.getIdMantenimiento());
            datos[1] = Integer.toString(m.getIdEquipo());
            datos[2] = Integer.toString(m.getIdLocacion());
            datos[3] = m.getNroTareaMant();
            datos[4] = m.getDescMantenimiento();
            datos[5] = m.getOficioMantenimiento();
            datos[6] = m.getFrecuenciaMant();
            datos[7] = Integer.toString(m.getDiasMant());
            datos[8] = Integer.toString(m.getDurTareaMant());
            datos[9] = m.getFechIniMantenimiento();
            datos[10] = m.getFechProgInicMant();
            datos[11] = m.getFechProgTermMant();
            datos[12] = m.getFechProximaMant();
            datos[13] = Integer.toString(m.getHorasProgramadas());
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        ReportsExcel reporte = new ReportsExcel(host);
        MantenimientoCRUD eqCRUD = new MantenimientoCRUD(host);
        ArrayList<Mantenimientos> mants = eqCRUD.visualizar();
        if(reporte.escribirExcelMantenimientos(mants)){
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE MANTENIMIENTOS CREADO","ARCHIVO GUARDADO EXITOSAMENTE",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE MANTENIMIENTOS NO CREADO","EROOR EN GUARDADO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

       try {
             JasperReport reporte = null;
             String path = "src\\lubrindustrial\\mantenimientos.jasper";
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
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tab_mantenimiento;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
