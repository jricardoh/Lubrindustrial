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

public class Instructions extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    int valor_encontrado;
    ArrayList<Instruction> instrucciones = new ArrayList<Instruction>();
    User user = new User();
    String host="";
    Conexion con;
    Connection cn;
    public int getvalorencontrado() {
        int valorencontrado = valor_encontrado;
        return valorencontrado = valor_encontrado;
    }

//ArrayList<Articulos> lista = new ArrayList<Articulos>();
    public Instructions() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
//        tab_instructions.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tab_instructions.doLayout();
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }

    public Instructions(User usu) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        agregarDatos();
//        tab_instructions.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tab_instructions.doLayout();
        user = usu;
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }
    
    public Instructions(User usu, String hostname) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        
//        tab_instructions.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tab_instructions.doLayout();
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

    public int getvalor() {
        int aux = valor_encontrado;
        return aux;
    }

    private void agregarDatos() {

        DefaultTableModel model = (DefaultTableModel) tab_instructions.getModel();

        model.setRowCount(0);
        String datos[] = new String[5];//ARRAY DE 3

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        InstructionCRUD instCRUD = new InstructionCRUD(host);

        instrucciones = instCRUD.visualizar(); // devuelve todos los registros de la BD

        for (Instruction i : instrucciones) {
            datos[0] = Integer.toString(i.getIdInst());
            datos[1] = i.getNroInst();
            datos[2] = i.getDescInst();
            datos[3] = Float.toString(i.getHorasInst());
            datos[4] = i.getNotasInst();
            model.addRow(datos);
        }

    }

    private String[] arregloInstrucciones(int idInst) {

        String datos[] = new String[5];//ARRAY DE 3

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        InstructionCRUD instCRUD = new InstructionCRUD(host);

        instrucciones = instCRUD.visualizar(idInst); // devuelve todos los registros de la BD

        for (Instruction i : instrucciones) {
            datos[0] = Integer.toString(i.getIdInst());
            datos[1] = i.getNroInst();
            datos[2] = i.getDescInst();
            datos[3] = Float.toString(i.getHorasInst());
            datos[4] = i.getNotasInst();

        }
        return datos;
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
        tab_instructions = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbox = new javax.swing.JComboBox<>();
        txtInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSec = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

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

        setTitle("Instrucciones");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_instructions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Instrucción", "Número Instrucción", "Descripcion Instrucción", "Horas Instrucción", "Notas Instrucción"
            }
        ));
        tab_instructions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_instructionsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_instructions);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 160));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de Instrucción", "Descripción", "Horas", "Notas" }));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 217, 730, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/nuevo.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 181, -1, -1));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/edit.png"))); // NOI18N
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 181, -1, -1));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/eliminar.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 181, -1, -1));

        btnSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/nuevo.png"))); // NOI18N
        btnSec.setText("Secuencias");
        btnSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecActionPerformed(evt);
            }
        });
        jPanel1.add(btnSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 181, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/excel_logo.png"))); // NOI18N
        jButton5.setToolTipText("Generar hoja de cálculo de Excel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 40, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/pdf.png"))); // NOI18N
        jButton6.setToolTipText("Generar informe en PDF");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 40, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_instructionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_instructionsMouseClicked

    }//GEN-LAST:event_tab_instructionsMouseClicked

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed

    private void txtInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyReleased

        DefaultTableModel model = (DefaultTableModel) tab_instructions.getModel();
        model.setRowCount(0);
        InstructionCRUD inst_query = new InstructionCRUD(host);
        String datos[] = new String[5];//ARRAY DE 3
        if (txtInput.getText().isEmpty()) {

            for (int i = 0; i < tab_instructions.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;
            }

        } else {
            instrucciones = inst_query.visualizar(txtInput.getText(), seleccionaritem());

            for (Instruction i : instrucciones) {
                datos[0] = Integer.toString(i.getIdInst());
                datos[1] = i.getNroInst();
                datos[2] = i.getDescInst();
                datos[3] = Float.toString(i.getHorasInst());
                datos[4] = i.getNotasInst();
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

        InstructionNew obj = new InstructionNew(user,host);
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

        int filasel = tab_instructions.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            //String cuenta;
            //cuenta = .getText();
            int n = JOptionPane.showConfirmDialog(null, "¿Esta seguro de borrar el registro? ", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                InstructionCRUD obj = new InstructionCRUD(host);
                obj.eliminar(Integer.parseInt(tab_instructions.getValueAt(filasel, 0).toString()),user);
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

    private void btnSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecActionPerformed
        // TODO add your handling code here:
        Sequences obj = new Sequences(user,host);
        Home.escritorio.add(obj);
        obj.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = obj.getSize();
        obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        obj.show();
    }//GEN-LAST:event_btnSecActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int filasel = tab_instructions.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione primero la columna");
        } else {
            InstructionEdit obj = new InstructionEdit(user,host);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            this.dispose();

            String dat[] = new String[5];
            dat = arregloInstrucciones(Integer.parseInt(tab_instructions.getValueAt(filasel, 0).toString()));
            InstructionEdit.lblID.setText(dat[0]);
            InstructionEdit.txt_Number.setText(dat[1]);
            InstructionEdit.txt_description.setText(dat[2]);
            InstructionEdit.txt_horas.setText(dat[3]);
            InstructionEdit.txt_notas.setText(dat[4]);

        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        ReportsExcel reporte = new ReportsExcel(host);
        InstructionCRUD eqCRUD = new InstructionCRUD(host);
        ArrayList<Instruction> inst = eqCRUD.visualizar();
        if(reporte.escribirExcelInstrucciones(inst)){
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE INSTRUCCIONES CREADO","ARCHIVO GUARDADO EXITOSAMENTE",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "ARCHIVO EXCEL DE INSTRUCCIONES NO CREADO","EROOR EN GUARDADO", JOptionPane.ERROR_MESSAGE);
        }
                
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        try {
             JasperReport reporte = null;
             String path = "src\\lubrindustrial\\instrucciones.jasper";
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
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSec;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tab_instructions;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
