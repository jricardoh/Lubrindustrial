/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RH
 */
public class EquipmentCRUD {
    
    String host;
    
    public EquipmentCRUD(){
        host = "";
    }
    
    public EquipmentCRUD(String hostname){
        this.host = hostname;
    }
    
    public String getHost(){
        return host;
    }
    
    public void setHost(String host){
        this.host = host;
    }
    
    public boolean insertar(Equipment equi) {
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta = 0;
        try {
            respuesta = conexion.getStmt().executeUpdate("INSERT INTO EQUIPO (ID_LOCT,ID_EMP,IDPADRE_EQ,NRO_EQ,DESCRIPCION_EQ,NROMODELO_EQ,NROSERIE_EQ,TIPO_EQ,ESTADO_EQ,FABRICANTE_EQ,FECHACOMPRA_EQ,FECHAINI_EQ,FECHAVEN_EQ,CONTRATISTA_EQ,PIEZAS_EQ,FOTO_EQ,ACTIVO)values ('"
                    + equi.getIdLocation() + "'," + equi.getIdEmployee() + "," + equi.getIdPadreEq() + ",'" + equi.getNroEquipment() + "','" + equi.getDescEquipment() + "','" + equi.getNroModEquipment()
                    + "','" + equi.getNroSerieEquipment() + "','" + equi.getTipoEquipment() + "','" + equi.getEstadoEquipment() + "','" + equi.getFabricEquipment() + "','" + equi.getFechaCompEquipment()
                    + "','" + equi.getFechaIniEquipment() + "','" + equi.getFechaVentEquipment() + "','" + equi.getContratistaEquipment() + "','" + equi.getPiezas() + "','" + equi.getFoto() + "','" + equi.getActivoEquipment() + "')");
            if (respuesta > 0) {
                conexion.Desconectar();
                return true;
            } else {
                conexion.Desconectar();
                return false;
            }
        } catch (Exception ex) {
            conexion.Desconectar();
            System.out.println("Excepcion registro: " + ex.getMessage());
            return false;
        }

    }

    public boolean modificar(Equipment equi, User usu) {
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta = 0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try {
            respuesta = conexion.getStmt().executeUpdate("UPDATE EQUIPO set ID_LOCT='" + equi.getIdLocation()
                    + "', ID_EMP='" + equi.getIdEmployee()
                    + "', NRO_EQ='" + equi.getNroEquipment()
                    + "', DESCRIPCION_EQ='" + equi.getDescEquipment()
                    + "', NROMODELO_EQ='" + equi.getNroModEquipment()
                    + "', NROSERIE_EQ='" + equi.getNroSerieEquipment()
                    + "', TIPO_EQ='" + equi.getTipoEquipment()
                    + "', ESTADO_EQ='" + equi.getEstadoEquipment()
                    + "', FABRICANTE_EQ='" + equi.getFabricEquipment()
                    + "', FECHACOMPRA_EQ='" + equi.getFechaCompEquipment()
                    + "', FECHAINI_EQ='" + equi.getFechaIniEquipment()
                    + "', FECHAVEN_EQ='" + equi.getFechaVentEquipment()
                    + "', CONTRATISTA_EQ='" + equi.getContratistaEquipment()
                    + "', ACTIVO='" + equi.getActivoEquipment()
                    + "' WHERE ID_EQ=" + equi.getIdEquipment());
            if (respuesta > 0) {
                conexion.Desconectar();
                Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("EQUIPOS");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(equi.getNroEquipment()+"-"+equi.getDescEquipment());
                 if(!audCRUD.insertarAuditoria(a))
                     JOptionPane.showMessageDialog(null, "AUDITORIA NO INSERTADA","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
                 
                return true;
            } else {
                conexion.Desconectar();
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error en MODIFICAR registro: " + ex.getMessage());
            conexion.Desconectar();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int codigo, User usu) {
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta = 0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD(host);
        Equipment equi = obtenerEquipo(codigo);
        try {
            respuesta = conexion.getStmt().executeUpdate("UPDATE EQUIPO set ACTIVO='" + 0
                    + "' WHERE ID_EQ=" + codigo);
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if (respuesta > 0) {
                conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("EQUIPOS");
                 a.setAccionRealizada("ELIMINACIÓN");
                 a.setDescripcion(equi.getNroEquipment()+"-"+equi.getDescEquipment());
                 if(!audCRUD.insertarAuditoria(a))
                     JOptionPane.showMessageDialog(null, "AUDITORIA NO INSERTADA","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
                 
                return true;
            } else {
                conexion.Desconectar();
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error en ELIMINAR registro: " + ex.getMessage());
            conexion.Desconectar();
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Equipment> visualizarArbol() {
        ArrayList<Equipment> listaEqui = new ArrayList<Equipment>();

        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();

        Conexion conexion2 = new Conexion();
        conexion2.setHost(host);
        
        conexion2.Conectar();

        ResultSet resultado = null;
        ResultSet resultado2 = null;

        try {
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM EQUIPO WHERE ACTIVO <> 0");
            // ojo con el where activo <>0
            resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                    + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                    + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT,em.NOMBRE_EMP,EM.APELLIDO_EMP,eq.PIEZAS_EQ,eq.FOTO_EQ "
                    + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                    + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                    + "WHERE eq.ID_EQ > 0");

            /*
            SELECT eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,
                   eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,
                   eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT
            FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de
            ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT)
            WHERE eq.ACTIVO <> 0
             */
            while (resultado.next()) {
                Equipment equi = new Equipment();
                equi.setIdLocation(resultado.getInt("ID_LOCT"));
                equi.setIdEquipment(resultado.getInt("ID_EQ"));
                equi.setIdEmployee(resultado.getInt("ID_EMP"));
                equi.setIdPadreEq(resultado.getInt("IDPADRE_EQ"));
                equi.setNroEquipment(resultado.getString("NRO_EQ"));
                equi.setDescEquipment(resultado.getString("DESCRIPCION_EQ"));
                equi.setNroModEquipment(resultado.getString("NROMODELO_EQ"));
                equi.setNroSerieEquipment(resultado.getString("NROSERIE_EQ"));
                equi.setTipoEquipment(resultado.getString("TIPO_EQ"));
                equi.setEstadoEquipment(resultado.getString("ESTADO_EQ"));
                equi.setFabricEquipment(resultado.getString("FABRICANTE_EQ"));
                equi.setFechaCompEquipment(resultado.getString("FECHACOMPRA_EQ"));
                equi.setFechaIniEquipment(resultado.getString("FECHAINI_EQ"));
                equi.setFechaVentEquipment(resultado.getString("FECHAVEN_EQ"));
                equi.setContratistaEquipment(resultado.getString("CONTRATISTA_EQ"));
                equi.setActivoEquipment(resultado.getInt("ACTIVO"));
                equi.setDescLoc(resultado.getString("DESCRIPCION_LOCT"));
                equi.setDescEmple(resultado.getString("NOMBRE_EMP") + " " + resultado.getString("APELLIDO_EMP"));
                equi.setPiezas(resultado.getString("PIEZAS_EQ"));
                equi.setFoto(resultado.getString("FOTO_EQ"));
                listaEqui.add(equi);
                if (equi.getIdPadreEq() != 0) {
                    resultado2 = conexion2.getStmt().executeQuery("SELECT NRO_EQ,DESCRIPCION_EQ FROM EQUIPO WHERE ID_EQ=" + equi.getIdPadreEq() + " and ACTIVO <> 0");
                    while (resultado2.next()) {
                        equi.setDescEquipPadre(resultado2.getString("NRO_EQ") + " " + resultado2.getString("DESCRIPCION_EQ"));
                    }
                } else {
                    equi.setDescEquipPadre("");
                }

            }

            return listaEqui;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros EQUIPOS: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<Equipment>();
        }
    }

    
    public ArrayList<Equipment> visualizar() {
        ArrayList<Equipment> listaEqui = new ArrayList<Equipment>();

        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();

        Conexion conexion2 = new Conexion();
        conexion2.setHost(host);
        
        conexion2.Conectar();

        ResultSet resultado = null;
        ResultSet resultado2 = null;

        try {
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM EQUIPO WHERE ACTIVO <> 0");
            // ojo con el where activo <>0
            resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                    + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                    + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT,em.NOMBRE_EMP,EM.APELLIDO_EMP,eq.PIEZAS_EQ,eq.FOTO_EQ "
                    + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                    + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                    + "WHERE eq.ACTIVO <> 0");

            /*
            SELECT eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,
                   eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,
                   eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT
            FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de
            ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT)
            WHERE eq.ACTIVO <> 0
             */
            while (resultado.next()) {
                Equipment equi = new Equipment();
                equi.setIdLocation(resultado.getInt("ID_LOCT"));
                equi.setIdEquipment(resultado.getInt("ID_EQ"));
                equi.setIdEmployee(resultado.getInt("ID_EMP"));
                equi.setIdPadreEq(resultado.getInt("IDPADRE_EQ"));
                equi.setNroEquipment(resultado.getString("NRO_EQ"));
                equi.setDescEquipment(resultado.getString("DESCRIPCION_EQ"));
                equi.setNroModEquipment(resultado.getString("NROMODELO_EQ"));
                equi.setNroSerieEquipment(resultado.getString("NROSERIE_EQ"));
                equi.setTipoEquipment(resultado.getString("TIPO_EQ"));
                equi.setEstadoEquipment(resultado.getString("ESTADO_EQ"));
                equi.setFabricEquipment(resultado.getString("FABRICANTE_EQ"));
                equi.setFechaCompEquipment(resultado.getString("FECHACOMPRA_EQ"));
                equi.setFechaIniEquipment(resultado.getString("FECHAINI_EQ"));
                equi.setFechaVentEquipment(resultado.getString("FECHAVEN_EQ"));
                equi.setContratistaEquipment(resultado.getString("CONTRATISTA_EQ"));
                equi.setActivoEquipment(resultado.getInt("ACTIVO"));
                equi.setDescLoc(resultado.getString("DESCRIPCION_LOCT"));
                equi.setDescEmple(resultado.getString("NOMBRE_EMP") + " " + resultado.getString("APELLIDO_EMP"));
                equi.setPiezas(resultado.getString("PIEZAS_EQ"));
                equi.setFoto(resultado.getString("FOTO_EQ"));
                listaEqui.add(equi);
                if (equi.getIdPadreEq() != 0) {
                    resultado2 = conexion2.getStmt().executeQuery("SELECT NRO_EQ,DESCRIPCION_EQ FROM EQUIPO WHERE ID_EQ=" + equi.getIdPadreEq() + " and ACTIVO <> 0");
                    while (resultado2.next()) {
                        equi.setDescEquipPadre(resultado2.getString("NRO_EQ") + " " + resultado2.getString("DESCRIPCION_EQ"));
                    }
                } else {
                    equi.setDescEquipPadre("");
                }

            }

            return listaEqui;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros EQUIPOS: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<Equipment>();
        }
    }

    
    public ArrayList<Equipment> visualizar(int idEquipment) {
        ArrayList<Equipment> listaEqui = new ArrayList<Equipment>();

        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();

        Conexion conexion2 = new Conexion();
        conexion2.setHost(host);
        
        conexion2.Conectar();

        ResultSet resultado = null;
        ResultSet resultado2 = null;

        try {
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM EQUIPO WHERE ACTIVO <> 0");
            // ojo con el where activo <>0
            resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                    + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                    + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT,em.NOMBRE_EMP,EM.APELLIDO_EMP,eq.PIEZAS_EQ, eq.FOTO_EQ "
                    + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                    + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                    + "WHERE eq.ACTIVO <> 0 AND eq.ID_EQ = '" + idEquipment + "'");

            /*
            SELECT eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,
                   eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,
                   eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT
            FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de
            ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT)
            WHERE eq.ACTIVO <> 0
             */
            while (resultado.next()) {
                Equipment equi = new Equipment();
                equi.setIdLocation(resultado.getInt("ID_LOCT"));
                equi.setIdEquipment(resultado.getInt("ID_EQ"));
                equi.setIdEmployee(resultado.getInt("ID_EMP"));
                equi.setIdPadreEq(resultado.getInt("IDPADRE_EQ"));
                equi.setNroEquipment(resultado.getString("NRO_EQ"));
                equi.setDescEquipment(resultado.getString("DESCRIPCION_EQ"));
                equi.setNroModEquipment(resultado.getString("NROMODELO_EQ"));
                equi.setNroSerieEquipment(resultado.getString("NROSERIE_EQ"));
                equi.setTipoEquipment(resultado.getString("TIPO_EQ"));
                equi.setEstadoEquipment(resultado.getString("ESTADO_EQ"));
                equi.setFabricEquipment(resultado.getString("FABRICANTE_EQ"));
                equi.setFechaCompEquipment(resultado.getString("FECHACOMPRA_EQ"));
                equi.setFechaIniEquipment(resultado.getString("FECHAINI_EQ"));
                equi.setFechaVentEquipment(resultado.getString("FECHAVEN_EQ"));
                equi.setContratistaEquipment(resultado.getString("CONTRATISTA_EQ"));
                equi.setActivoEquipment(resultado.getInt("ACTIVO"));
                equi.setDescLoc(resultado.getString("DESCRIPCION_LOCT"));
                equi.setDescEmple(resultado.getString("NOMBRE_EMP") + " " + resultado.getString("APELLIDO_EMP"));
                equi.setPiezas(resultado.getString("PIEZAS_EQ"));
                equi.setFoto(resultado.getString("FOTO_EQ"));
                listaEqui.add(equi);
                if (equi.getIdPadreEq() != 0) {
                    resultado2 = conexion2.getStmt().executeQuery("SELECT NRO_EQ,DESCRIPCION_EQ FROM EQUIPO WHERE ID_EQ=" + equi.getIdPadreEq() + " and ACTIVO <> 0");
                    while (resultado2.next()) {
                        equi.setDescEquipPadre(resultado2.getString("NRO_EQ") + " " + resultado2.getString("DESCRIPCION_EQ"));
                    }
                } else {
                    equi.setDescEquipPadre("");
                }

            }

            return listaEqui;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros EQUIPOS: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<Equipment>();
        }
    }

    public Equipment obtenerEquipo(int idEquipment) {
//        ArrayList<Equipment> listaEqui = new ArrayList<Equipment>();

        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();

        Conexion conexion2 = new Conexion();
        conexion2.setHost(host);
        
        conexion2.Conectar();

        ResultSet resultado = null;
        ResultSet resultado2 = null;

        try {
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM EQUIPO WHERE ACTIVO <> 0");
            // ojo con el where activo <>0
            resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                    + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                    + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                    + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                    + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                    + "WHERE eq.ACTIVO <> 0 AND eq.ID_EQ = '" + idEquipment + "'");

            
            Equipment equi = new Equipment();
            if (resultado.next()) {
                
                equi.setIdLocation(resultado.getInt("ID_LOCT"));
                equi.setIdEquipment(resultado.getInt("ID_EQ"));
                equi.setIdEmployee(resultado.getInt("ID_EMP"));
                equi.setIdPadreEq(resultado.getInt("IDPADRE_EQ"));
                equi.setNroEquipment(resultado.getString("NRO_EQ"));
                equi.setDescEquipment(resultado.getString("DESCRIPCION_EQ"));
                equi.setNroModEquipment(resultado.getString("NROMODELO_EQ"));
                equi.setNroSerieEquipment(resultado.getString("NROSERIE_EQ"));
                equi.setTipoEquipment(resultado.getString("TIPO_EQ"));
                equi.setEstadoEquipment(resultado.getString("ESTADO_EQ"));
                equi.setFabricEquipment(resultado.getString("FABRICANTE_EQ"));
                equi.setFechaCompEquipment(resultado.getString("FECHACOMPRA_EQ"));
                equi.setFechaIniEquipment(resultado.getString("FECHAINI_EQ"));
                equi.setFechaVentEquipment(resultado.getString("FECHAVEN_EQ"));
                equi.setContratistaEquipment(resultado.getString("CONTRATISTA_EQ"));
                equi.setActivoEquipment(resultado.getInt("ACTIVO"));
                
//                listaEqui.add(equi);
                if (equi.getIdPadreEq() != 0) {
                    resultado2 = conexion2.getStmt().executeQuery("SELECT NRO_EQ,DESCRIPCION_EQ FROM EQUIPO WHERE ID_EQ=" + equi.getIdPadreEq() + " and ACTIVO <> 0");
                    while (resultado2.next()) {
                        equi.setDescEquipPadre(resultado2.getString("NRO_EQ") + " " + resultado2.getString("DESCRIPCION_EQ"));
                    }
                } else {
                    equi.setDescEquipPadre("");
                }

            }

            return equi;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros EQUIPOS: " + ex.getMessage());
            ex.printStackTrace();

            return null;
        }
    }
    
    public ResultSet cumple2Anios() {

        //ArrayList<Article> listaEqui = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado = null;
        ResultSet resultado2 = null;
        try {
            conexion.getStmt();

//            resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
//                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
//                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART, a.ACTIVO" +
//                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
//                                                        " ON (a.ID_PROV = p.ID_PROV)" +
//                                                        " WHERE a.ACTIVO <> 0 AND a.CANTIDAD_ART <= a.PUNTOREORDEN_ART");
            resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                    + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                    + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                    + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                    + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                    + "WHERE eq.ACTIVO <> 0 AND (NOW() - eq.FECHAINI_EQ) = 730");

            int contador = 0;
            while (resultado.next()) {
                contador++;
            }
            resultado.first();
            resultado.beforeFirst();
            System.out.println(contador);
            if (contador == 0) {
                resultado = null;
            }

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();

        }
        return resultado;
    }

    public ResultSet cumple1Anio() {

        //ArrayList<Article> listaEqui = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado = null;
        ResultSet resultado2 = null;
        try {
            conexion.getStmt();

//            resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
//                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
//                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART, a.ACTIVO" +
//                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
//                                                        " ON (a.ID_PROV = p.ID_PROV)" +
//                                                        " WHERE a.ACTIVO <> 0 AND a.CANTIDAD_ART <= a.PUNTOREORDEN_ART");
            resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                    + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                    + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                    + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                    + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                    + "WHERE eq.ACTIVO <> 0 AND (NOW() - eq.FECHAINI_EQ) = 365");

            int contador = 0;
            while (resultado.next()) {
                contador++;
            }
            resultado.first();
            resultado.beforeFirst();
            System.out.println(contador);
            if (contador == 0) {
                resultado = null;
            }

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();

        }
        return resultado;
    }
    
    public ResultSet cumple3Anios() {

        //ArrayList<Article> listaEqui = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado = null;
        ResultSet resultado2 = null;
        try {
            conexion.getStmt();

//            resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
//                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
//                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART, a.ACTIVO" +
//                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
//                                                        " ON (a.ID_PROV = p.ID_PROV)" +
//                                                        " WHERE a.ACTIVO <> 0 AND a.CANTIDAD_ART <= a.PUNTOREORDEN_ART");
            resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                    + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                    + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                    + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                    + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                    + "WHERE eq.ACTIVO <> 0 AND (NOW() - eq.FECHAINI_EQ) = 1095");

            int contador = 0;
            while (resultado.next()) {
                contador++;
            }
            resultado.first();
            resultado.beforeFirst();
            System.out.println(contador);
            if (contador == 0) {
                resultado = null;
            }

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();

        }
        return resultado;
    }
    
    public ArrayList<Equipment> enviarDatosTabla(ResultSet resultado) {

        ArrayList<Equipment> listaEqui = new ArrayList<Equipment>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        
        Conexion conexion2 = new Conexion();
        conexion.setHost(host);
        
        conexion2.Conectar();
        ResultSet resultado2 = null;
        try {
            while (resultado.next()) {
                Equipment equi = new Equipment();
                equi.setIdLocation(resultado.getInt("ID_LOCT"));
                equi.setIdEquipment(resultado.getInt("ID_EQ"));
                equi.setIdEmployee(resultado.getInt("ID_EMP"));
                equi.setIdPadreEq(resultado.getInt("IDPADRE_EQ"));
                equi.setNroEquipment(resultado.getString("NRO_EQ"));
                equi.setDescEquipment(resultado.getString("DESCRIPCION_EQ"));
                equi.setNroModEquipment(resultado.getString("NROMODELO_EQ"));
                equi.setNroSerieEquipment(resultado.getString("NROSERIE_EQ"));
                equi.setTipoEquipment(resultado.getString("TIPO_EQ"));
                equi.setEstadoEquipment(resultado.getString("ESTADO_EQ"));
                equi.setFabricEquipment(resultado.getString("FABRICANTE_EQ"));
                equi.setFechaCompEquipment(resultado.getString("FECHACOMPRA_EQ"));
                equi.setFechaIniEquipment(resultado.getString("FECHAINI_EQ"));
                equi.setFechaVentEquipment(resultado.getString("FECHAVEN_EQ"));
                equi.setContratistaEquipment(resultado.getString("CONTRATISTA_EQ"));
                equi.setActivoEquipment(resultado.getInt("ACTIVO"));
                listaEqui.add(equi);
                if (equi.getIdPadreEq() != 0) {
                    resultado2 = conexion2.getStmt().executeQuery("SELECT NRO_EQ,DESCRIPCION_EQ FROM EQUIPO WHERE ID_EQ=" + equi.getIdPadreEq() + " and ACTIVO <> 0");
                    while (resultado2.next()) {
                        equi.setDescEquipPadre(resultado2.getString("NRO_EQ") + " " + resultado2.getString("DESCRIPCION_EQ"));
                    }
                } else {
                    equi.setDescEquipPadre("");
                }

            }

            return listaEqui;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<Equipment>();
        }
    }

    public ArrayList<Equipment> visualizar(String texto, int item) {

        ArrayList<Equipment> listaEqui = new ArrayList<Equipment>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();

        Conexion conexion2 = new Conexion();
        conexion2.setHost(host);
        
        conexion2.Conectar();

        ResultSet resultado = null;
        ResultSet resultado2 = null;

        String Filtro = "" + texto + "_%";
        try {
            conexion.getStmt();
            switch (item) {
                case 0:
                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                            + "WHERE eq.ACTIVO <> 0 AND eq.NRO_EQ like " + '"' + Filtro + '"');
                    break;
                case 1:
                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                            + "WHERE eq.ACTIVO <> 0 AND eq.DESCRIPCION_EQ like " + '"' + Filtro + '"');
                    break;
                case 2:
                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                            + "WHERE eq.ACTIVO <> 0 AND eq.NROMODELO_EQ like " + '"' + Filtro + '"');
                    break;
                case 3:
                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                            + "WHERE eq.ACTIVO <> 0 AND eq.NROSERIE_EQ like " + '"' + Filtro + '"');
                    break;
                case 4:
                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                            + "WHERE eq.ACTIVO <> 0 AND eq.TIPO_EQ like " + '"' + Filtro + '"');
                    break;
                case 5:
                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                            + "WHERE eq.ACTIVO <> 0 AND eq.ESTADO_EQ like " + '"' + Filtro + '"');
                    break;
                case 6:
                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                            + "WHERE eq.ACTIVO <> 0 AND eq.FABRICANTE_EQ like " + '"' + Filtro + '"');
                    break;
                case 7:
                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                            + "WHERE eq.ACTIVO <> 0 AND eq.CONTRATISTA_EQ like " + '"' + Filtro + '"');
                    break;
                case 8:
                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
                            + "WHERE eq.ACTIVO <> 0 AND eq.PIEZAS_EQ like " + '"' + Filtro + '"');
                    break;
//                case 12:
//                    resultado = conexion.getStmt().executeQuery("SELECT eq.ID_EMP,eq.ID_LOCT,lo.DESCRIPCION_LOCT,eq.ID_EQ,eq.DESCRIPCION_EQ, eq.IDPADRE_EQ,eq.DESCRIPCION_EQ,eq.ID_EQ,eq.DESCRIPCION_EQ,eq.NRO_EQ,"
//                            + "eq.NROMODELO_EQ,eq.NROSERIE_EQ,eq.TIPO_EQ,eq.ESTADO_EQ,eq.FABRICANTE_EQ,eq.FECHACOMPRA_EQ,eq.FECHAINI_EQ,eq.FECHAVEN_EQ,eq.CONTRATISTA_EQ,"
//                            + "eq.ACTIVO,de.ID_DEPT,de.DESCRIPCION_DEPT "
//                            + "FROM EQUIPO eq JOIN EMPLEADO em JOIN LOCACION lo JOIN DEPARTAMENTO de "
//                            + "ON(em.ID_EMP=eq.ID_EMP and eq.ID_LOCT=lo.ID_LOCT and lo.ID_DEPT=de.ID_DEPT) "
//                            + "WHERE eq.ACTIVO <> 0 AND (eq.FECHACOMPRA_EQ LIKE '"+ Filtro +"' OR eq.FECHACOMPRA_EQ = '"+ texto +"')");
//                    break;
                default:
                    break;
            }

            while (resultado.next()) {
                Equipment equi = new Equipment();
                equi.setIdLocation(resultado.getInt("ID_LOCT"));
                equi.setIdEquipment(resultado.getInt("ID_EQ"));
                equi.setIdEmployee(resultado.getInt("ID_EMP"));
                equi.setIdPadreEq(resultado.getInt("IDPADRE_EQ"));
                equi.setNroEquipment(resultado.getString("NRO_EQ"));
                equi.setDescEquipment(resultado.getString("DESCRIPCION_EQ"));
                equi.setNroModEquipment(resultado.getString("NROMODELO_EQ"));
                equi.setNroSerieEquipment(resultado.getString("NROSERIE_EQ"));
                equi.setTipoEquipment(resultado.getString("TIPO_EQ"));
                equi.setEstadoEquipment(resultado.getString("ESTADO_EQ"));
                equi.setFabricEquipment(resultado.getString("FABRICANTE_EQ"));
                equi.setFechaCompEquipment(resultado.getString("FECHACOMPRA_EQ"));
                equi.setFechaIniEquipment(resultado.getString("FECHAINI_EQ"));
                equi.setFechaVentEquipment(resultado.getString("FECHAVEN_EQ"));
                equi.setContratistaEquipment(resultado.getString("CONTRATISTA_EQ"));
                equi.setActivoEquipment(resultado.getInt("ACTIVO"));
                listaEqui.add(equi);
                if (equi.getIdPadreEq() != 0) {
                    resultado2 = conexion2.getStmt().executeQuery("SELECT NRO_EQ,DESCRIPCION_EQ FROM EQUIPO WHERE ID_EQ=" + equi.getIdPadreEq() + " and ACTIVO <> 0");
                    while (resultado2.next()) {
                        equi.setDescEquipPadre(resultado2.getString("NRO_EQ") + " " + resultado2.getString("DESCRIPCION_EQ"));
                    }
                } else {
                    equi.setDescEquipPadre("");
                }

            }
            return listaEqui;
        } catch (SQLException ex) {
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<Equipment>();
        }
    }

}
