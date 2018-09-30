/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Conexion;
import com.lubrindustrial.Server.Employee;
import com.lubrindustrial.Server.MantenimientoCRUD;
import com.lubrindustrial.Server.OrdenTrabajoCRUD;
import com.lubrindustrial.Server.OrdenTrabajos;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DIEGOPC
 */
public class ReportOrdenEmployee extends javax.swing.JInternalFrame {
    ArrayList<Employee> emp = new ArrayList<Employee>();
    ArrayList<OrdenTrabajos> ot = new ArrayList<OrdenTrabajos>();
    String host = "localhost";
    Conexion con;
    Connection cn;
    /**
     * Creates new form frmOrdenEmployee
     */
    public ReportOrdenEmployee() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        llenarComboBoxEmpOrden();
        tab_ordentrabajo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_ordentrabajo.doLayout();
        this.setIconifiable(true);
        this.setClosable(true);
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
    }
    
    public ReportOrdenEmployee(String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        llenarComboBoxEmpOrden();
        tab_ordentrabajo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_ordentrabajo.doLayout();
        this.setIconifiable(true);
        this.setClosable(true);
        this.host = hostname;
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
        
    }
    
    private void llenarComboBoxEmpOrden() {
        OrdenTrabajoCRUD  otCRUD = new OrdenTrabajoCRUD(host);

        emp = otCRUD.llenarComboEmpOrden(); // devuelve todos los registros de la BD
        comboEmp.removeAllItems();

        for (Employee e : emp) {
            comboEmp.addItem(e.getIdEmployee() + " " + e.getNomEmployee()+" "+e.getApeEmployee());
            //JOptionPane.showMessageDialog(null, m.getIdMantenimiento() + " " + m.getDescMantenimiento());
        }
    }
    
    private void agregarDatos(){
        
        DefaultTableModel model = (DefaultTableModel)tab_ordentrabajo.getModel();

        model.setRowCount(0);
        String datos[] = new String[20];

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        OrdenTrabajoCRUD mantCRUD = new OrdenTrabajoCRUD(host);
        String codEmp;
        codEmp=comboEmp.getSelectedItem().toString();
        String []splitD = codEmp.split(" ");
        codEmp = splitD[0];
        int codEmpi=Integer.parseInt(codEmp);
        ot = mantCRUD.ordenPorEmpleado(codEmpi);
        ArrayList<String> listaColab=new ArrayList<String>();
        listaColab=mantCRUD.colabPorOrden(ot);
        for(int i=0; i<ot.size();i++){
            datos[0] = Integer.toString(ot.get(i).getIdOrdtr());
            datos[1] = Integer.toString(ot.get(i).getIdMant());
            datos[2] = ot.get(i).getNroOrdtr();
            datos[3] = ot.get(i).getDescOrdtr();
            datos[4] = ot.get(i).getEstOrdtr();
            datos[5] = ot.get(i).getTipoOrdtr();
            datos[6] = ot.get(i).getPriorOrdtr();
            datos[7] = ot.get(i).getFechHorSolicitudOrdtr();
            datos[8] = ot.get(i).getFechHorReqOrdtr();
            datos[9] = ot.get(i).getRespOrdtr();
            datos[10] = ot.get(i).getInicioOrdtr();
            datos[11] = ot.get(i).getTermOrdtr();
            datos[12] = ot.get(i).getFechHoraEntOrdtr();
            datos[13] = Float.toString(ot.get(i).getDuracionDiasOrdtr());
            datos[14] = ot.get(i).getAceptPorOrdtr();
            datos[15] = ot.get(i).getFallaOrdtr();
            datos[16] = ot.get(i).getDescCausaOrdtr();
            datos[17] = ot.get(i).getAccionRealizOrdtr();
            datos[18] = ot.get(i).getPrevenTomadaOrdtr();
            datos[19]=listaColab.get(i);
            model.addRow(datos);
        }
        /*
        for(int i=0; i<listaColab.size();i++)
        {
            JOptionPane.showMessageDialog(null, "Colab: "+listaColab.get(i));
            datos[13]=listaColab.get(i);
        }*/
        
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_ordentrabajo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        comboEmp = new javax.swing.JComboBox<>();
        btnGeneratePDF = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_ordentrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Orden Trabajo", "Id Mantenimiento", "Número ", "Descripción ", "Estado ", "Tipo", "Prioridad", "Fecha Hora Solicitud", "Fecha Hora Requerida", "Respuesta", "Inicio", "Término", "Fecha Hora Entrega", "Duración Días", "Aceptado Por", "Falla", "Descripción Causa", "Acción Realizada", "Prevención Tomada", "Colaboradores"
            }
        ));
        tab_ordentrabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_ordentrabajoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_ordentrabajo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 590, 160));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        comboEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 230, -1));

        btnGeneratePDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/pdf.png"))); // NOI18N
        btnGeneratePDF.setText("Generar PDF");
        btnGeneratePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnGeneratePDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_ordentrabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_ordentrabajoMouseClicked

    }//GEN-LAST:event_tab_ordentrabajoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGeneratePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePDFActionPerformed

        try {
            JasperReport reporte = JasperCompileManager.compileReport("reportOrdTrabEmp1.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporte, null, this.cn);
            JasperViewer jviewer = new JasperViewer(print,false);
            jviewer.show();
            //JasperViewer.viewReport(print);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnGeneratePDFActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ReportOrdenEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ReportOrdenEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ReportOrdenEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ReportOrdenEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReportOrdenEmployee().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeneratePDF;
    private javax.swing.JComboBox<String> comboEmp;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tab_ordentrabajo;
    // End of variables declaration//GEN-END:variables
}
