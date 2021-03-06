/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Conexion;
import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Instruction;
import com.lubrindustrial.Server.InstructionCRUD;
import com.lubrindustrial.Server.ReportsExcel;
import com.lubrindustrial.Server.Sequence;
import com.lubrindustrial.Server.SequenceCRUD;
import com.lubrindustrial.Server.User;
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

public class Sequences extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    int valor_encontrado;
    ArrayList<Sequence> secuencias = new ArrayList<Sequence>();
    ArrayList<Instruction> instrucciones = new ArrayList<Instruction>();
    User user = new User();
    String host;
    Conexion con;
    Connection cn;
    
    public int getvalorencontrado() {
        int valorencontrado = valor_encontrado;
        return valorencontrado = valor_encontrado;
    }

//ArrayList<Articulos> lista = new ArrayList<Articulos>();
    public Sequences() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
//        tab_sequences.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tab_sequences.doLayout();
    }

    public Sequences(User usu) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
//        tab_sequences.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tab_sequences.doLayout();
        user = usu;
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }
    
    public Sequences(User usu, String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
//        tab_sequences.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tab_sequences.doLayout();
        user = usu;
        this.host=hostname;
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }
    
    public int seleccionaritem() {
        int item = cbox.getSelectedIndex();
        return item;
    }

    public int getvalor() {
        int aux = valor_encontrado;
        return aux;
    }

    private void agregarDatos() {

        DefaultTableModel model = (DefaultTableModel) tab_sequences.getModel();

        model.setRowCount(0);
        String datos[] = new String[4];//ARRAY DE 3

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        SequenceCRUD secCRUD = new SequenceCRUD(host);

        secuencias = secCRUD.visualizar(); // devuelve todos los registros de la BD

        for (Sequence s : secuencias) {
            datos[0] = Integer.toString(s.getIdSec());
            datos[1] = s.getDescInst();
            datos[2] = s.getNroSec();
            datos[3] = s.getDescSec();
            model.addRow(datos);
        }

    }

    private String[] arregloSecuencias(int idSequence) {

        String datos[] = new String[4];//ARRAY DE 3

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        SequenceCRUD secCRUD = new SequenceCRUD(host);

        secuencias = secCRUD.visualizar(idSequence); // devuelve todos los registros de la BD

        for (Sequence s : secuencias) {
            datos[0] = Integer.toString(s.getIdSec());
            datos[1] = s.getDescInst();
            datos[2] = s.getNroSec();
            datos[3] = s.getDescSec();

        }
        return datos;
    }

    private void llenarComboBox(){
        InstructionCRUD instCRUD = new InstructionCRUD(host);
        
        instrucciones = instCRUD.visualizar(); // devuelve todos los registros de la BD
        
        SequenceEdit.cbox_instruction.removeAllItems();
        
        for(Instruction i: instrucciones){  
            SequenceEdit.cbox_instruction.addItem(i.getIdInst()+" "+i.getDescInst());
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
        tab_sequences = new javax.swing.JTable();
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

        setTitle("Secuencias");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_sequences.setModel(new javax.swing.table.DefaultTableModel(
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
                "Id Secuencia", "Instrucción", "Número Secuencia", "Descripción"
            }
        ));
        tab_sequences.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_sequencesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_sequences);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 650, 160));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de Secuencia", "Descripción" }));
        cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxActionPerformed(evt);
            }
        });
        jPanel2.add(cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

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
        jPanel2.add(txtInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 173, -1));

        jLabel1.setText("Cantidad de Registros:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 20));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 70, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 217, 650, 80));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/nuevo.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/show_all.png"))); // NOI18N
        jButton2.setText("Mostrar todo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/door_exit.png"))); // NOI18N
        jButton3.setText("Detalles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 100, -1));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/edit.png"))); // NOI18N
        btnEdit.setText("Modificar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eliminar.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/excel_logo.png"))); // NOI18N
        jButton4.setToolTipText("Generar hoja de cálculo de Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 40, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/pdf.png"))); // NOI18N
        jButton5.setToolTipText("Generar informe en PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_sequencesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_sequencesMouseClicked

    }//GEN-LAST:event_tab_sequencesMouseClicked

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed

    private void txtInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyReleased

       
        DefaultTableModel model = (DefaultTableModel) tab_sequences.getModel();
        model.setRowCount(0);
        SequenceCRUD seq_query = new SequenceCRUD(host);
        String datos[] = new String[4];//ARRAY DE 3
        if (txtInput.getText().isEmpty()) {

            for (int i = 0; i < tab_sequences.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;
            }

        } else {
            secuencias = seq_query.visualizar(txtInput.getText(), seleccionaritem());

      for (Sequence s : secuencias) {
            datos[0] = Integer.toString(s.getIdSec());
            datos[1] = s.getDescInst();
            datos[2] = s.getNroSec();
            datos[3] = s.getDescSec();
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

        SequenceNew obj = new SequenceNew(user,host);
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

        int filasel = tab_sequences.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            //String cuenta;
            //cuenta = .getText();
            int n = JOptionPane.showConfirmDialog(null, "¿Esta seguro de borrar el registro? ", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                SequenceCRUD obj = new SequenceCRUD(host);
                obj.eliminar(Integer.parseInt(tab_sequences.getValueAt(filasel, 0).toString()), user);
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
        // TODO add your handling code here:
        agregarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        
        int filasel = tab_sequences.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            SequenceEdit obj = new SequenceEdit(user,host);
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
            dat = arregloSecuencias(Integer.parseInt(tab_sequences.getValueAt(filasel, 0).toString()));
            SequenceEdit.lblID.setText(dat[0]);
            SequenceEdit.txt_Number.setText(dat[2]);
            SequenceEdit.txt_description.setText(dat[3]);
            llenarComboBox();
        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        ReportsExcel reporte = new ReportsExcel(host);
        SequenceCRUD secCRUD = new SequenceCRUD(host);
        ArrayList<Sequence> secs = secCRUD.visualizar();
        if(reporte.escribirExcelSecuencias(secs)){
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE SECUENCIAS CREADO","ARCHIVO GUARDADO EXITOSAMENTE",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE SECUENCIAS NO CREADO","EROOR EN GUARDADO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
             JasperReport reporte = null;
             String path = "src\\lubrindustrial\\secuencias.jasper";
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
    private javax.swing.JTable tab_sequences;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
