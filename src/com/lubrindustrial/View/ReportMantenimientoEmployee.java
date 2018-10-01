/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Conexion;
import com.lubrindustrial.Server.Employee;
import com.lubrindustrial.Server.MantenimientoCRUD;
import com.lubrindustrial.Server.Mantenimientos;
import com.lubrindustrial.Server.OrdenTrabajoCRUD;
import com.lubrindustrial.Server.OrdenTrabajos;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
 * @author jHONNY
 */
public class ReportMantenimientoEmployee extends javax.swing.JInternalFrame {
    ArrayList<Employee> emp = new ArrayList<Employee>();
    ArrayList<Mantenimientos> mant = new ArrayList<Mantenimientos>();
    String host = "localhost";
    Conexion con;
    Connection cn;
    /**
     * Creates new form frmReporteMantenimientoEmployee
     */
    public ReportMantenimientoEmployee() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        llenarComboBoxEmpMant();
        tab_mantenimiento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_mantenimiento.doLayout();
        this.setIconifiable(true);
        this.setClosable(true);
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
        
    }
    
    public ReportMantenimientoEmployee(String hostname) {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        llenarComboBoxEmpMant();
        tab_mantenimiento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_mantenimiento.doLayout();
        this.setIconifiable(true);
        this.setClosable(true);
        this.host = hostname;
        con = new Conexion(this.host);
        this.con.Conectar();
        cn =con.getCon();
        
    }
    
    private void llenarComboBoxEmpMant() {
        MantenimientoCRUD  mantCRUD = new MantenimientoCRUD();

        emp = mantCRUD.llenarComboEmpMant(); // devuelve todos los registros de la BD
        comboEmp.removeAllItems();

        for (Employee e : emp) {
            comboEmp.addItem(e.getIdEmployee() + " " + e.getNomEmployee()+" "+e.getApeEmployee());
            //JOptionPane.showMessageDialog(null, m.getIdMantenimiento() + " " + m.getDescMantenimiento());
        }
    }
    
    private void agregarDatos(){
        
        DefaultTableModel model = (DefaultTableModel)tab_mantenimiento.getModel();

        model.setRowCount(0);
        String datos[] = new String[14];//ARRAY DE 13

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        MantenimientoCRUD mantCRUD = new MantenimientoCRUD();
        String codEmp;
        codEmp=comboEmp.getSelectedItem().toString();
        String []splitD = codEmp.split(" ");
        codEmp = splitD[0];
        int codEmpi=Integer.parseInt(codEmp);
        mant = mantCRUD.mantPorEmpleado(codEmpi);
        ArrayList<String> listaColab=new ArrayList<String>();
        listaColab=mantCRUD.colabPorMant(mant);
        for(int i=0; i<mant.size();i++){
            datos[0] = Integer.toString(mant.get(i).getIdMantenimiento());
            datos[1] = Integer.toString(mant.get(i).getIdEquipo());
            datos[2] = Integer.toString(mant.get(i).getIdLocacion());
            datos[3] = mant.get(i).getNroTareaMant();
            datos[4] = mant.get(i).getDescMantenimiento();
            datos[5] = mant.get(i).getFrecuenciaMant();
            datos[6] = Integer.toString(mant.get(i).getDiasMant());
            datos[7] = Integer.toString(mant.get(i).getDurTareaMant());
            datos[8] = mant.get(i).getFechIniMantenimiento();
            datos[9] = mant.get(i).getFechProgInicMant();
            datos[10] = mant.get(i).getFechProgTermMant();
            datos[11] = mant.get(i).getFechProximaMant();
            datos[12] = Integer.toString(mant.get(i).getHorasProgramadas());
            datos[13]=listaColab.get(i);
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
        tab_mantenimiento = new javax.swing.JTable();
        comboEmp = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnGeneratePDF = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_mantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Id Mantenimiento", "Id Equipos", "Id Locación", "Número de tarea ", "Descripción ", "Frecuencia", "Días", "Duración Tareas ", "Fecha Inicio", "Fecha Prog. Inicio", "Fecha Prog. Término", "Próxima Fecha", "Horas Programadas", "Colaboradores"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, true, true, true, true, true, true, true
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 531, 160));

        comboEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 230, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        btnGeneratePDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/pdf.png"))); // NOI18N
        btnGeneratePDF.setText("Generar PDF");
        btnGeneratePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnGeneratePDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 30, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 590, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tab_mantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_mantenimientoMouseClicked

    }//GEN-LAST:event_tab_mantenimientoMouseClicked

    private void btnGeneratePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePDFActionPerformed
        
        String cad="";
        try {
            cad=comboEmp.getSelectedItem().toString();
            String []split = cad.split(" ");
            cad = split[0];
             JasperReport reporte = null;
             String path = "src\\lubrindustrial\\mantenimientoEmp.jasper";
             Map parametro = new HashMap();
             parametro.put("id_emp",cad);
             reporte = (JasperReport)JRLoader.loadObjectFromFile(path);
             JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,this.cn);
//             JasperReport reporte = JasperCompileManager.compileReport("reportMantEmp2.jrxml");
//            JasperPrint print = JasperFillManager.fillReport(reporte, null, this.cn);
            JasperViewer jviewer = new JasperViewer(jprint,false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
            //JasperViewer.viewReport(print);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
//        try {
//             JasperReport reporte = null;
//             String path = "src\\lubrindustrial\\materiales.jasper";
//             reporte = (JasperReport)JRLoader.loadObjectFromFile(path);
//             JasperPrint jprint = JasperFillManager.fillReport(reporte, null,this.cn);
////             JasperReport reporte = JasperCompileManager.compileReport("reportMantEmp2.jrxml");
////            JasperPrint print = JasperFillManager.fillReport(reporte, null, this.cn);
//            JasperViewer jviewer = new JasperViewer(jprint,false);
//            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            jviewer.setVisible(true);
//            //JasperViewer.viewReport(print);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        
//        try {
//            JasperReport reporte = JasperCompileManager.compileReport("reportMantEmp2.jrxml");
//            JasperPrint print = JasperFillManager.fillReport(reporte, null, this.cn);
//            JasperViewer jviewer = new JasperViewer(print,false);
//            jviewer.show();
//            //JasperViewer.viewReport(print);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        
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
//            java.util.logging.Logger.getLogger(ReportMantenimientoEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ReportMantenimientoEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ReportMantenimientoEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ReportMantenimientoEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReportMantenimientoEmployee().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeneratePDF;
    private javax.swing.JComboBox<String> comboEmp;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tab_mantenimiento;
    // End of variables declaration//GEN-END:variables
}
