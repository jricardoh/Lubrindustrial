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
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private static String cuenta;
    private static String nivel;
    public static String host="";
    User user = new User();
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
    Pedidos pedView;
    Operabilidad opeView;

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
//        alertaMantenimiento();
        mostrarIP();
        host = "";
        compararHost();
//        host="192.168.0.1";
//        inicializarFrames();
        Dimension dim = escritorio.getSize();
        Dimension lblSize = lblLogo.getSize();
        lblLogo.setLocation((dim.width - lblSize.width) / 2, (dim.height - lblSize.height) / 2);
//        generarCopiaSeguridad();
    }
    
    public String obtenerRuta(){
        String ruta="";
        JFileChooser explorador = new JFileChooser();
        explorador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       
        explorador.showOpenDialog(explorador);
            
        ruta=explorador.getSelectedFile().getAbsolutePath();
            
        return ruta;
    }
    
    public String obtenerFechaSistema() {

//Instanciamos el objeto Calendar
//en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar();
//Obtenemos el valor del año, mes, día,
//hora, minuto y segundo del sistema
//usando el método get y el parámetro correspondiente
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
//        int hora = fecha.get(Calendar.HOUR_OF_DAY);
//        int minuto = fecha.get(Calendar.MINUTE);
//        int segundo = fecha.get(Calendar.SECOND);
//        String ff = "" + dia + "/" + (mes + 1) + "/" + anio;
        String ff;
//                = System.out.println("Fecha Actual: "
//                        + dia + "/" + (mes + 1) + "/" + año);
//        System.out.printf("Hora Actual: %02d:%02d:%02d %n",
//                hora, minuto, segundo);
//        ff = hora + ":" + minuto + ":" + segundo + ".0";
        ff = anio + "-" + mes + "-" + dia;
        return ff;
    }
    
    public void generarCopiaSeguridadNube()
    {
        JOptionPane.showMessageDialog(null, "A continuación seleccionesu carpeta en Google Drive para el respaldo de su información","BackUp Google Drive",JOptionPane.INFORMATION_MESSAGE);
        String path=obtenerRuta();
        try {
            Process proceso = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u administrador -padmin.soft.18.jcrh.1000 lubrindustrial");
            InputStream is = proceso.getInputStream();
            FileOutputStream fos = new FileOutputStream(path+"\\BackUp_"+obtenerFechaSistema()+".sql");

            byte[] buffer = new byte[1000];
            int leer = is.read(buffer);

            while (leer > 0) {
                fos.write(buffer, 0, leer);
                leer = is.read(buffer);
                //System.out.println("Estoy while");
            }
            fos.close();
            JOptionPane.showMessageDialog(null, "RESPALDO GENERADO CORRECTAMENTE","RESPALDO CORRECTO",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "RESPALDO NO GENERADO CORRECTAMENTE", "ERROR RESPALDO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    public Home(User us, String hostname) throws UnknownHostException { // utilizo para jalar el User y Host
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
        this.host = hostname;
        compararHost();
        Dimension dim = escritorio.getSize();
        Dimension lblSize = lblLogo.getSize();
        lblLogo.setLocation((dim.width - lblSize.width) / 2, (dim.height - lblSize.height) / 2);
//        System.out.println("sadasdsa");
//        inicializarFrames();

        //System.out.println("sa:" + user.getNomUser());
        
        //System.out.println("Me conecto a la IP: "+host);
    }
    
        
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
public void inicializarFrames(){ // hay que enviar tambien la direccion IP
    
        this.empView = new Employees(this.user,this.host);
        this.equiView = new Equipments(this.user,this.host);
        this.deptView = new Departments(this.user,this.host);
        this.loctView = new Locations(this.user,this.host);
        this.artView = new Articles(this.user,this.host);
        this.suppView = new Suppliers(this.user,this.host);
        this.instView = new Instructions(this.user,this.host);
        this.mantView = new Mantenimiento(this.user,this.host);
        this.ordtrView = new OrdenTrabajo(this.user,this.host);        
        this.repView = new Reports(this.user,this.host);
        this.pedView = new Pedidos(/*this.user,*/this.host);
        this.opeView = new Operabilidad(/*this.user,*/this.host);
}
      
    
//    public Home(String aux) {
//        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
//        lblNivel.setText(aux);
////        habilitar();
//        lblCuenta.setVisible(false);
//        lblNivel.setVisible(false);
////        alertaMantenimiento();        
//    }

    public void mostrarIP() throws UnknownHostException {
        lblIP.setText("Dirección IP: " + InetAddress.getLocalHost().getHostAddress());
        lblHostName.setText("Nombre de Red: " + InetAddress.getLocalHost().getHostName());
    }

    public void compararHost() throws UnknownHostException{
         
        if (this.host.equals(InetAddress.getLocalHost().getHostAddress()) || this.host.equals(InetAddress.getLocalHost().getHostName())){
            
            btnCopiaSeg.setVisible(true);
            btnCopiaSeg.setEnabled(true);
            
        }else
        {
            btnCopiaSeg.setVisible(false);
            btnCopiaSeg.setEnabled(false);
        }
        
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
        ArticleCRUD artCRUD = new ArticleCRUD(host);
        if (artCRUD.cumplePuntoReorden() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Los materiales mostrados han descendido del punto de reorden, realice un pedido");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        if (artCRUD.cumpleMinimo() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Los materiales mostrados han descendido al nivel mínimo en bodega, realice un pedido inmediatamente");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        EquipmentCRUD equiCRUD = new EquipmentCRUD(host);
        if (equiCRUD.cumple2Anios() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(1);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Los equipos mostrados cumplen 2 años de uso");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        if (equiCRUD.cumple1Anio() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(1);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Los equipos mostrados cumplen 1 año de uso");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        if (equiCRUD.cumple3Anios() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(1);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Los equipos mostrados cumplen 3 años de uso");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        OrdenTrabajoCRUD ordtrCRUD = new OrdenTrabajoCRUD(host);
        if (ordtrCRUD.cumpleMesAntes() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Las siguientes órdenes de trabajo están a un mes o menos de cumplir la fecha requerida");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        if (ordtrCRUD.cumpleSemanaAntes() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Las siguientes órdenes de trabajo están a una semana o menos de cumplir la fecha requerida");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        if (ordtrCRUD.cumpleDiaAntes() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Las siguientes órdenes de trabajo están a 1 día de llegar a la fecha requerida");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        MantenimientoCRUD mantCRUD = new MantenimientoCRUD(host);
        if (mantCRUD.cumpleMesAntes() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Las siguientes tareas de mantenimiento están a 1 mes o menos de llegar a la fecha de término");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        if (mantCRUD.cumpleSemanaAntes() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Las siguientes tareas de mantenimiento están a 1 semana o menos de llegar a la fecha de término");
        } else {
            System.out.println("Sin notificaciones de caducidad");
        }
        if (mantCRUD.cumpleDiaAntes() != null) {
            //articulos = artCRUD.enviarDatosTabla(artCRUD.cumple2Anios());
            Alert obj = new Alert(0);
            Home.escritorio.add(obj);
            obj.toFront();
            //centrar
            //Para centrar la ventana abierta
            Dimension dimension = escritorio.getSize();
            Dimension FrameSize = obj.getSize();
            //obj.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
            obj.show();
            obj.lblMensaje.setText("Las siguientes tareas de mantenimiento están a 1 día de llegar a la fecha de término");
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
        lblLogo2 = new javax.swing.JLabel();
        lblNomApe1 = new javax.swing.JLabel();
        lblNomApe2 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
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
        jButton12 = new javax.swing.JButton();
        btnCopiaSeg = new javax.swing.JButton();
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

        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/Logo Grease Warehouse.jpeg"))); // NOI18N
        lblLogo2.setText(" ");

        lblNomApe1.setForeground(new java.awt.Color(255, 255, 255));
        lblNomApe1.setText("Lubrinsdustrial v1.0");

        lblNomApe2.setForeground(new java.awt.Color(255, 255, 255));
        lblNomApe2.setText("Jhonny Cajamarca / Ricardo Herrera");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/lubrindustrial_logo (2).png"))); // NOI18N
        lblLogo.setText(" ");

        escritorio.setLayer(jDesktopPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblCuenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblNivel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblNomApe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblIP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblHostName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblLogo2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblNomApe1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblNomApe2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(lblNomApe1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNomApe2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHostName, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNomApe, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGap(22, 22, 22))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNomApe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(290, 290, 290))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHostName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomApe2)
                    .addComponent(lblNomApe1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
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

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/engr-.png"))); // NOI18N
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

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/puzzle.png"))); // NOI18N
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

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/operabilidad.png"))); // NOI18N
        jButton12.setText("Operabilidad");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton12);

        btnCopiaSeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lubrindustrial/Icons/candado.png"))); // NOI18N
        btnCopiaSeg.setText("Copia de Seguridad");
        btnCopiaSeg.setFocusable(false);
        btnCopiaSeg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCopiaSeg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCopiaSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiaSegActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCopiaSeg);

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
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1095, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        this.empView = new Employees(this.user,this.host);
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

        try {
            generarCopiaSeguridadNube();
            this.dispose();
            Login login = new Login();
            login.setVisible(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.equiView = new Equipments(this.user,this.host);
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
        this.deptView = new Departments(this.user,this.host);
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
        this.loctView = new Locations(this.user,this.host);
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
        this.artView = new Articles(this.user,this.host);
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
        this.suppView = new Suppliers(this.user,this.host);
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
        this.instView = new Instructions(this.user,this.host);
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
        this.mantView = new Mantenimiento(this.user,this.host);
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
        this.ordtrView = new OrdenTrabajo(this.user,this.host);
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

    private void btnCopiaSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiaSegActionPerformed

        String path="";
        try{
            Process proceso = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u administrador -padmin.soft.18.jcrh.1000 lubrindustrial");
            InputStream is = proceso.getInputStream();
            
            JFileChooser explorador = new JFileChooser();
            explorador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            explorador.showOpenDialog(explorador);
            
            path=explorador.getSelectedFile().getAbsolutePath();
            //System.out.println("ruta: "+path);
            
            FileOutputStream fos = new FileOutputStream(path+"\\ArchivoRespaldo.sql");
            
            byte []buffer = new byte[1000];
            int leer = is.read(buffer);
            
            while(leer > 0){
                fos.write(buffer,0,leer);
                leer = is.read(buffer);
                //System.out.println("Estoy while");
            }
            fos.close();
            JOptionPane.showMessageDialog(null, "RESPALDO GENERADO CORRECTAMENTE","RESPALDO CORRECTO",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "RESPALDO NO GENERADO CORRECTAMENTE", "ERROR RESPALDO", JOptionPane.ERROR_MESSAGE);
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


    }//GEN-LAST:event_btnCopiaSegActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        this.repView = new Reports(this.user,this.host);
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
        this.pedView = new Pedidos(/*this.user,*/this.host);
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

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        
        this.opeView = new Operabilidad(/*this.user,*/this.host);
        opeView.dispose();
        Home.escritorio.add(opeView);
        opeView.toFront();
        //centrar
        //Para centrar la ventana abierta
        Dimension dimension = escritorio.getSize();
        Dimension FrameSize = opeView.getSize();
        opeView.setLocation((dimension.width - FrameSize.width) / 2, (dimension.height - FrameSize.height) / 2);
        //
        opeView.show();
        
    }//GEN-LAST:event_jButton12ActionPerformed

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
    private javax.swing.JButton btnCopiaSeg;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
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
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JLabel lblCuenta;
    public javax.swing.JLabel lblHostName;
    public javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo2;
    public javax.swing.JLabel lblNivel;
    public javax.swing.JLabel lblNomApe;
    public javax.swing.JLabel lblNomApe1;
    public javax.swing.JLabel lblNomApe2;
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
