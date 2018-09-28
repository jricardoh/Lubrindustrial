/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.DepartmentCRUD;
import com.lubrindustrial.Server.Article;
import com.lubrindustrial.Server.ArticleCRUD;
import com.lubrindustrial.Server.Equipment;
import com.lubrindustrial.Server.EquipmentCRUD;
import com.lubrindustrial.Server.MantenimientoCRUD;
import com.lubrindustrial.Server.Mantenimientos;
import com.lubrindustrial.Server.OrdenTrabajoCRUD;
import com.lubrindustrial.Server.OrdenTrabajos;
import com.lubrindustrial.Server.Supplier;
import com.lubrindustrial.Server.SupplierCRUD;
import static com.lubrindustrial.View.Home.escritorio;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

public class Alert extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;// = new DefaultTableModel();
    int valor_encontrado;
    ArrayList<Article> articulos = new ArrayList<Article>();
    ArrayList<Supplier> proveedores = new ArrayList<Supplier>();
    ArrayList<Equipment> equipos = new ArrayList<Equipment>();
    ArrayList<Mantenimientos> mant = new ArrayList<Mantenimientos>();
    ArrayList<OrdenTrabajos> ot = new ArrayList<OrdenTrabajos>();
    //vector con los titulos de cada columna
    String[] titulosArticulo = {"Id Artículo", "Número Artículo", "Descripción", "Especificaciones", "Fabricante", "Unidad de Medida", "Costo Estándar", "Máximo", "Mínimo", "Entrega No. Días", "Notas", "Cantidad", "Descripción Proveedor"};
    String[] titulosEquipo = {"Id Equipo", "Id Locación", "Id Empleados", "Número de Equipo", "Descripción", "No. de Modelo", "No. de Serie", "Tipo", "Estado", "Fabricante", "Fecha Compra", "Fecha Inicial", "Fecha Venta", "Contratista", "Piezas", "Padre"};
    String[] titulosOrdenTrabajo = {"Id Orden Trabajo", "Id Mantenimiento", "Número", "Descripción", "Estado", "Tipo", "Prioridad", "Fecha Hora Solicitud", "Fecha Hora Requerida", "Respuesta", "Inicio", "Término", "Fecha Hora Entrega", "Duración Días", "Aceptado por", "Falla", "Descripción Causa", "Acción Realizada", "Prevención Tomada"};
    String[] titulosMantenimiento = {"Id Mantenimiento", "Id Equipos", "Id Locación", "Número de Tarea", "Descripción", "Oficio", "Frecuencia", "Días", "Duración Tareas", "Fecha Inicio", "Fecha Prog. Inicio", "Fecha Prog. Término", "Próxima Fecha", "Horas Programadas"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
//    int tipo;

    public int getvalorencontrado() {
        int valorencontrado = valor_encontrado;
        return valorencontrado = valor_encontrado;
    }

    public Alert() {
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);
        tab_alert.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_alert.doLayout();
    }

//ArrayList<Articulos> lista = new ArrayList<Articulos>();
    public Alert(int tipo) {
        initComponents();
        this.setIconifiable(true);
        this.setClosable(true);

        //agregarDatos();
        switch (tipo) {
            case 0:
                this.modelo = new DefaultTableModel(info, titulosArticulo);
                this.title = "Alerta de Artículos";
                break;
            case 1:
                this.modelo = new DefaultTableModel(info, titulosEquipo);
                this.title = "Alerta de Equipos";
                break;
            case 2:
                this.modelo = new DefaultTableModel(info, titulosOrdenTrabajo);
                this.title = "Alerta de Órdenes de Trabajo";
                break;
            case 3:
                this.modelo = new DefaultTableModel(info, titulosMantenimiento);
                this.title = "Alerta de Mantenimiento";
                break;
        }
        agregarDatos(tipo);
    }

//    public int seleccionaritem() {
//        int item = cbox.getSelectedIndex();
//        return item;
//    }

    public int getvalor() {
        int aux = valor_encontrado;
        return aux;
    }

    private void agregarDatos(int tipo) {
        String datos[];
        switch (tipo) {
            case 0:
                datos = new String[16];//ARRAY
                //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
                ArticleCRUD artCRUD = new ArticleCRUD();
                if (artCRUD.cumplePuntoReorden() != null) {
                    articulos = artCRUD.enviarDatosTabla(artCRUD.cumplePuntoReorden());
                } else {
                    System.out.println("Sin notificaciones");
                }
                for (Article a : articulos) {
                    datos[0] = Integer.toString(a.getIdArt());
                    datos[1] = a.getNroArt();
                    datos[2] = a.getDescProv();
                    datos[3] = a.getDescArt();
                    datos[4] = a.getEspecificacionesArt();
                    datos[5] = a.getFabricante();
                    datos[6] = a.getUnidaMedida();
                    datos[7] = Float.toString(a.getCostoEstandar());
                    datos[8] = Float.toString(a.getMaximo());
                    datos[9] = Float.toString(a.getPuntoReorden());
                    datos[10] = Float.toString(a.getCantidadReorden());
                    datos[11] = Float.toString(a.getMinimo());
                    datos[12] = Integer.toString(a.getNroDias());
                    datos[13] = a.getNotas();
                    datos[14] = Float.toString(a.getCantidad());
                    datos[15] = a.getDescripCantidad();
                    modelo.addRow(datos);
                }
                break;
            case 1:
                datos = new String[16];//ARRAY
                //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
                EquipmentCRUD equiCRUD = new EquipmentCRUD();
                if (equiCRUD.cumplePuntoReorden() != null) {
                    equipos = equiCRUD.enviarDatosTabla(equiCRUD.cumplePuntoReorden());
                } else {
                    System.out.println("Sin notificaciones");
                }
                for (Equipment e : equipos) {
                    datos[0] = Integer.toString(e.getIdEquipment());
                    datos[1] = Integer.toString(e.getIdLocation());
                    datos[2] = Integer.toString(e.getIdEmployee());
                    datos[3] = e.getNroEquipment();
                    datos[4] = e.getDescEquipment();
                    datos[5] = e.getNroModEquipment();
                    datos[6] = e.getNroSerieEquipment();
                    datos[7] = e.getTipoEquipment();
                    datos[8] = e.getEstadoEquipment();
                    datos[9] = e.getFabricEquipment();
                    datos[10] = e.getFechaCompEquipment().toString();
                    datos[11] = e.getFechaIniEquipment().toString();
                    datos[12] = e.getFechaVentEquipment().toString();
                    datos[13] = e.getContratistaEquipment();
                    //datos[14] = Integer.toString(e.getActivoEquipment());
                    datos[14] = e.getDescEquipPadre();
                    modelo.addRow(datos);
                }
                break;
            case 2:
                datos = new String[16];//ARRAY
                //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
                OrdenTrabajoCRUD otCRUD = new OrdenTrabajoCRUD();
                if (otCRUD.cumplePuntoReorden() != null) {
                    ot = otCRUD.enviarDatosTabla(otCRUD.cumplePuntoReorden());
                } else {
                    System.out.println("Sin notificaciones");
                }
                for (OrdenTrabajos o : ot) {
                    datos[0] = Integer.toString(o.getIdOrdtr());
                    datos[1] = Integer.toString(o.getIdMant());
                    datos[2] = o.getNroOrdtr();
                    datos[3] = o.getDescOrdtr();
                    datos[4] = o.getEstOrdtr();
                    datos[5] = o.getTipoOrdtr();
                    datos[6] = o.getPriorOrdtr();
                    datos[7] = o.getFechHorSolicitudOrdtr();
                    datos[8] = o.getFechHorReqOrdtr();
                    datos[9] = o.getRespOrdtr();
                    datos[10] = o.getInicioOrdtr();
                    datos[11] = o.getTermOrdtr();
                    datos[12] = o.getFechHoraEntOrdtr();
                    datos[13] = Float.toString(o.getDuracionDiasOrdtr());
                    datos[14] = o.getAceptPorOrdtr();
                    datos[15] = o.getFallaOrdtr();
                    datos[16] = o.getDescCausaOrdtr();
                    datos[17] = o.getAccionRealizOrdtr();
                    datos[18] = o.getPrevenTomadaOrdtr();
                    modelo.addRow(datos);
                }
                break;
            case 3:
                datos = new String[16];//ARRAY
                //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
                MantenimientoCRUD mantCRUD = new MantenimientoCRUD();
                if (mantCRUD.cumplePuntoReorden() != null) {
                    mant = mantCRUD.enviarDatosTabla(mantCRUD.cumplePuntoReorden());
                } else {
                    System.out.println("Sin notificaciones");
                }
                for (Mantenimientos m : mant) {
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
                    modelo.addRow(datos);
                }
                break;
        }

        tab_alert.setModel(modelo);
        tab_alert.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tab_alert.doLayout();
    }

    private String[] arregloArticulos(int idArticulo) {

        String datos[] = new String[14];//ARRAY DE 3

        //LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST 
        ArticleCRUD artCRUD = new ArticleCRUD();

        articulos = artCRUD.visualizar(idArticulo); // devuelve todos los registros de la BD

        for (Article a : articulos) {

            datos[0] = Integer.toString(a.getIdArt());
            datos[1] = a.getNroArt();
            datos[2] = a.getDescProv();
            datos[3] = a.getDescArt();
            datos[4] = a.getEspecificacionesArt();
            datos[5] = a.getFabricante();
            datos[6] = a.getUnidaMedida();
            datos[7] = Float.toString(a.getCostoEstandar());
            datos[8] = Float.toString(a.getMaximo());
            datos[9] = Float.toString(a.getPuntoReorden());
            datos[10] = Float.toString(a.getCantidadReorden());
            datos[11] = Float.toString(a.getMinimo());
            datos[12] = Integer.toString(a.getNroDias());
            datos[13] = a.getNotas();

        }
        return datos;
    }

    private void llenarComboBox() {
        SupplierCRUD supCRUD = new SupplierCRUD();

        proveedores = supCRUD.visualizar(); // devuelve todos los registros de la BD

        ArticleEdit.cbox_suppliers.removeAllItems();

        for (Supplier s : proveedores) {
            ArticleEdit.cbox_suppliers.addItem(s.getIdSupplier() + " " + s.getNameSupplier());
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
        tab_alert = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

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

        setTitle("Alerta");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_alert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tab_alert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_alertMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_alert);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/door_exit.png"))); // NOI18N
        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_alertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_alertMouseClicked

    }//GEN-LAST:event_tab_alertMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

        this.setEnabled(true);

    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tab_alert;
    // End of variables declaration//GEN-END:variables
}
