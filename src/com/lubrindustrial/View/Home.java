/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.View;

import com.lubrindustrial.Server.Article;
import com.lubrindustrial.Server.ArticleCRUD;
import com.lubrindustrial.Server.Department;
import com.lubrindustrial.Server.EquipmentCRUD;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import com.lubrindustrial.Server.Mantenimientos;
import com.lubrindustrial.Server.MantenimientoCRUD;
import com.lubrindustrial.Server.OrdenTrabajoCRUD;
import com.lubrindustrial.Server.User;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private static String cuenta;
    private static String nivel;
    public static String host;
    User user = new User();

    public Home() throws UnknownHostException {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
//        habilitar();
        this.setLocationRelativeTo(null);
        lblCuenta.setVisible(false);
        lblNivel.setVisible(false);
        alertaMantenimiento();
        mostrarIP();

    }

    public Home(User us, String hostname) throws UnknownHostException {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
//        habilitar();
        this.setLocationRelativeTo(null);
        lblCuenta.setVisible(false);
        lblNivel.setVisible(false);
        alertaMantenimiento();
        mostrarIP();
        this.user = us;
        inicializarFrames();
        System.out.println("sa:" + user.getNomUser());
        this.host = hostname;

    }
        Employees empView; 
        Equipments equiView;
        Departments deptView;
        Locations loctView; 
        Articles artView; 
        Suppliers suppView; 
        Instructions instView; 
        Mantenimiento mantView;
        OrdenTrabajo ordtrView; 
        Reports repView;
        GestionPedidos pedView;
//    Employees empView = new Employees(this.user);
//    Equipments equiView = new Equipments(this.user);
//    Departments deptView = new Departments(this.user);
//    Locations loctView = new Locations(this.user);
//    Articles artView = new Articles(this.user);
//    Suppliers suppView = new Suppliers(this.user);
//    Instructions instView = new Instructions(this.user);
//    Mantenimiento mantView = new Mantenimiento(this.user);
//    OrdenTrabajo ordtrView = new OrdenTrabajo(this.user);
//    Reports repView = new Reports(this.user);
public void inicializarFrames(){
        this.empView = new Employees(this.user);
        this.equiView = new Equipments(this.user);
        this.deptView = new Departments(this.user);
        this.loctView = new Locations(this.user);
        this.artView = new Articles(this.user);
        this.suppView = new Suppliers(this.user);
        this.instView = new Instructions(this.user);
        this.mantView = new Mantenimiento(this.user);
        this.ordtrView = new OrdenTrabajo(this.user);
        this.repView = new Reports(this.user,this.host);
        this.pedView = new GestionPedidos(this.user,this.host);
}
      
    
    public Home(String aux) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        lblNivel.setText(aux);
//        habilitar();
        lblCuenta.setVisible(false);
        lblNivel.setVisible(false);
//        alertaMantenimiento();        
    }

    public void mostrarIP() throws UnknownHostException {
        lblIP.setText("Dirección IP: " + InetAddress.getLocalHost().getHostAddress());
        lblHostName.setText("Nombre de Red: " + InetAddress.getLocalHost().getHostName());
    }

    public static boolean estacerrado(Object obj) {
        JInternalFrame[] activos = escritorio.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
            }
            i++;
        }
        return cerrado;
    }

    public static void alertaMantenimiento() {

//        ArrayList<Article> articulos = new ArrayList<Article>();
        ArticleCRUD artCRUD = new ArticleCRUD();
        if (artCRUD.cumplePuntoReorden() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumplePuntoReorden());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        EquipmentCRUD equiCRUD = new EquipmentCRUD();
        if (equiCRUD.cumplePuntoReorden() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumplePuntoReorden());
            Alert obj = new Alert(1);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        OrdenTrabajoCRUD ordtrCRUD = new OrdenTrabajoCRUD();
        if (ordtrCRUD.cumplePuntoReorden() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumplePuntoReorden());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        MantenimientoCRUD mantCRUD = new MantenimientoCRUD();
        if (mantCRUD.cumplePuntoReorden() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumplePuntoReorden());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
        } else {
            System.out.println("Sin notificaciones de caducidad");
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

        escritorio = new javax.swing.JDesktopPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblCuenta = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblNomApe = new javax.swing.JLabel();
        lblIP = new javax.swing.JLabel();
        lblHostName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lubrindustrial");

        escritorio.setBackground(new java.awt.Color(65, 105, 170));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblNomApe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomApe.setForeground(new java.awt.Color(255, 255, 255));
        lblNomApe.setText("Nombre y Apellido de usuario");

        lblIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIP.setForeground(new java.awt.Color(255, 255, 255));
        lblIP.setText("IP de equipo servidor");

        lblHostName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHostName.setForeground(new java.awt.Color(255, 255, 255));
        lblHostName.setText("Nombre Red equipo servidor");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/lubrindustrial.png"))); // NOI18N
        jLabel1.setText(" ");

        escritorio.setLayer(jDesktopPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblCuenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblNivel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblNomApe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblIP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblHostName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblNomApe, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHostName, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHostName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomApe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setFocusable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/equipo.png"))); // NOI18N
        jButton2.setText("Empleados");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/equip.png"))); // NOI18N
        jButton3.setText("Equipos");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/department.png"))); // NOI18N
        jButton4.setText("Departamentos");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/map.png"))); // NOI18N
        jButton5.setText("Locaciones");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/material.png"))); // NOI18N
        jButton6.setText("Materiales");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon("D:\\Software lubricantes\\AVANCE FINAL 24-09-2018\\Lubrindustrial_v25\\Lubrindustrial\\src\\com\\lubrindustrial\\Icons\\engr-.png")); // NOI18N
        jButton7.setText("Proveedores");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon("D:\\Software lubricantes\\AVANCE FINAL 24-09-2018\\Lubrindustrial_v25\\Lubrindustrial\\src\\com\\lubrindustrial\\Icons\\Fondo-.png")); // NOI18N
        jButton8.setText("Instrucciones");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/invent.png"))); // NOI18N
        jButton9.setText("Mantenimientos");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/inventario.png"))); // NOI18N
        jButton10.setText("Orden Trabajo");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/reportes.png"))); // NOI18N
        jButton14.setText("Reportes");
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton14);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/pedido.png"))); // NOI18N
        jButton11.setText("Pedidos");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton11);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/candado.png"))); // NOI18N
        jButton13.setText("Copia de Seguridad");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton13);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/logout2.png"))); // NOI18N
        jButton1.setText("Cerrar Sesión");
        jButton1.setActionCommand("   Inicio   ");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public void habilitar() {
//        String aux = lblNivel.getText();
//        System.out.println("nivel " + aux);
//        switch (aux) {
//            case "1":
//                //Administrador
//                System.out.println("Admin");
//                break;
//            case "2":
//                //Empleado
////                jEmpleados.setVisible(false);
////                mbUsuarios.setVisible(false);
//                System.out.println("Empleado");
//                break;
//            case "3":
//                //Bodeguero
//                jLocations.setVisible(false);
//                System.out.println("Bodegero");
//                break;
//            default:
//                break;
//        }
//    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

//        empView.dispose();
        Home.escritorio.add(empView);
        empView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = empView.getSize();
        empView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        empView.show();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
        Login login = new Login();
        login.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        equiView.dispose();
        Home.escritorio.add(equiView);
        equiView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = equiView.getSize();
        equiView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        equiView.show();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        deptView.dispose();
        Home.escritorio.add(deptView);
        deptView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = deptView.getSize();
        deptView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        deptView.show();


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        loctView.dispose();
        Home.escritorio.add(loctView);
        loctView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = loctView.getSize();
        loctView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        loctView.show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        artView.dispose();
        Home.escritorio.add(artView);
        artView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = artView.getSize();
        artView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        artView.show();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        suppView.dispose();
        Home.escritorio.add(suppView);
        suppView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = suppView.getSize();
        suppView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        suppView.show();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        instView.dispose();
        Home.escritorio.add(instView);
        instView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = instView.getSize();
        instView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        instView.show();

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        mantView.dispose();
        Home.escritorio.add(mantView);
        mantView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = mantView.getSize();
        mantView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        mantView.show();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        ordtrView.dispose();
        Home.escritorio.add(ordtrView);
        ordtrView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = ordtrView.getSize();
        ordtrView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        ordtrView.show();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        String path="";
        try{
            Process proceso = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u jhonny -pjhonny lubrindustriales_vfinal");
            InputStream is = proceso.getInputStream();
            
            JFileChooser explorador = new JFileChooser();
            explorador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            explorador.showOpenDialog(explorador);
            
            path=explorador.getSelectedFile().getAbsolutePath();
            System.out.println("ruta: "+path);
            
            FileOutputStream fos = new FileOutputStream(path+"\\dump2.sql");
            
            byte []buffer = new byte[1000];
            int leer = is.read(buffer);
            
            while(leer > 0){
                fos.write(buffer,0,leer);
                leer = is.read(buffer);
                //System.out.println("Estoy while");
            }
            fos.close();
            System.out.println("Respaldo de la base de datos correcto");
        }catch(Exception ex){
            System.out.println(""+ex.getMessage());
            ex.printStackTrace();
        }

        
//        try {
//            Process proceso = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u jhonny -pjhonny lubrindustriales");
//            InputStream is = proceso.getInputStream();
//            FileOutputStream fos = new FileOutputStream("C:\\Users\\RH\\Google Drive\\Respaldos\\dump2.sql");
//
//            byte[] buffer = new byte[1000];
//            int leer = is.read(buffer);
//
//            while (leer > 0) {
//                fos.write(buffer, 0, leer);
//                leer = is.read(buffer);
//                //System.out.println("Estoy while");
//            }
//            fos.close();
//            System.out.println("Respaldo de la base de datos correcto");
//        } catch (Exception ex) {
//            System.out.println("" + ex.getMessage());
//            ex.printStackTrace();
//        }


    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        repView.dispose();
        Home.escritorio.add(repView);
        repView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = repView.getSize();
        repView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        repView.show();

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        pedView.dispose();
        Home.escritorio.add(pedView);
        pedView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = pedView.getSize();
        pedView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        pedView.show();
        
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JLabel lblCuenta;
    public javax.swing.JLabel lblHostName;
    public javax.swing.JLabel lblIP;
    public javax.swing.JLabel lblNivel;
    public javax.swing.JLabel lblNomApe;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the cuenta
     */
    public static String getCuenta() {
        return cuenta;
    }

    /**
     * @param aCuenta the cuenta to set
     */
    public static void setCuenta(String aCuenta) {
        cuenta = aCuenta;
    }

    /**
     * @return the nivel
     */
    public static String getNivel() {
        return nivel;
    }

    /**
     * @param aNivel the nivel to set
     */
    public static void setNivel(String aNivel) {
        nivel = aNivel;
    }

    public static String getCuenta1() {
        return lblCuenta.getText();
    }
}
