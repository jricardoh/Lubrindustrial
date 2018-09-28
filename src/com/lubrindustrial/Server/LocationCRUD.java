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
 * @author Jhonny
 */
public class LocationCRUD {
    
    String host;
    
    public LocationCRUD(){
        
    }
    
    public LocationCRUD(String hostname){
        this.host = hostname;
    }
    
    public boolean insertar(Location loc){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO LOCACION (NRO_LOCT,DESCRIPCION_LOCT,ID_DEPT)values ('" +
                                                        loc.getNroLocation()+ "','" +loc.getDescLocation()+"',"+loc.getIdDepartment()+")");
            if(respuesta>0){
                conexion.Desconectar();
                return true;
            }else{
                conexion.Desconectar();
                return false;
            }
        } catch (Exception ex) {
            conexion.Desconectar();
            return false;
        }
        
    }
    
    public boolean modificar(Location loc, User usu){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE LOCACION set NRO_LOCT='" +loc.getNroLocation()+
                                                        "', DESCRIPCION_LOCT='"+loc.getDescLocation()+
                                                        "', ID_DEPT="+loc.getIdDepartment()+
                                                        " WHERE ID_LOCT="+loc.getIdLocation());
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("LOCACIONES");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(loc.getNroLocation()+"-"+loc.getDescLocation());
                 if(!audCRUD.insertarAuditoria(a))
                     JOptionPane.showMessageDialog(null, "AUDITORIA NO INSERTADA","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
                 
                 return true;
             }else{
                 conexion.Desconectar();
                 return false;
             }
        }catch(Exception ex){
            System.err.println("Error en MODIFICAR registro: " + ex.getMessage());
            conexion.Desconectar();
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminar(int codigo, User usu){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE LOCACION set ACTIVO='" +0+
                                                        "' WHERE ID_LOCT="+codigo);
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("LOCACIONES");
                 a.setAccionRealizada("ELIMINACIÓN");
//                 a.setDescripcion(loc.getNroLocation()+"-"+loc.getDescLocation());
                 if(!audCRUD.insertarAuditoria(a))
                     JOptionPane.showMessageDialog(null, "AUDITORIA NO INSERTADA","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
                 
                 return true;
             }else{
                 conexion.Desconectar();
                 return false;
             }
        }catch (Exception ex){
            System.err.println("Error en ELIMINAR registro: " + ex.getMessage());
            conexion.Desconectar();
            ex.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Location> visualizar(){
        ArrayList<Location> listaLocs = new ArrayList<Location>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO " +
                                                        "FROM DEPARTAMENTO d JOIN LOCACION l " +
                                                        "ON (d.ID_DEPT = l.ID_DEPT) " +
                                                        "WHERE l.ACTIVO <> 0");
            /*SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO
              FROM DEPARTAMENTO d JOIN LOCACION l
              ON (d.ID_DEPT = l.ID_DEPT)*/
            
            if (resultado.next()) {
                  Location loc = new Location();
                  loc.setIdDepartment(resultado.getInt("ID_DEPT"));
                  loc.setIdLocation(resultado.getInt("ID_LOCT"));
                  loc.setNroLocation(resultado.getString("NRO_LOCT"));
                  loc.setDescLocation(resultado.getString("DESCRIPCION_LOCT"));
                  loc.setActivoLocation(resultado.getInt("ACTIVO"));
                  loc.setNameDepartment(resultado.getString("DESCRIPCION_DEPT"));
                  listaLocs.add(loc);
            }
            
            return listaLocs;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros LOCATIONS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Location>();
        }
    }
    
    public ArrayList<Location> visualizar(int idLocation){
        ArrayList<Location> listaLocs = new ArrayList<Location>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO " +
                                                        "FROM DEPARTAMENTO d JOIN LOCACION l " +
                                                        "ON (d.ID_DEPT = l.ID_DEPT) " +
                                                        "WHERE l.ACTIVO <> 0 AND l.ID_LOCT = '" + idLocation + "'");
            /*SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO
              FROM DEPARTAMENTO d JOIN LOCACION l
              ON (d.ID_DEPT = l.ID_DEPT)*/
            
            while (resultado.next()) {
                  Location loc = new Location();
                  loc.setIdDepartment(resultado.getInt("ID_DEPT"));
                  loc.setIdLocation(resultado.getInt("ID_LOCT"));
                  loc.setNroLocation(resultado.getString("NRO_LOCT"));
                  loc.setDescLocation(resultado.getString("DESCRIPCION_LOCT"));
                  loc.setActivoLocation(resultado.getInt("ACTIVO"));
                  loc.setNameDepartment(resultado.getString("DESCRIPCION_DEPT"));
                  listaLocs.add(loc);
            }
            
            return listaLocs;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros LOCATIONS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Location>();
        }
    }
    public ArrayList<Location> visualizar(String texto, int item){
        
        ArrayList<Location> listaLocs = new ArrayList<Location>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        String Filtro=""+texto+"_%";
        try{
            conexion.getStmt();
            switch(item){
                case 0:
                    resultado= conexion.getStmt().executeQuery("SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO " +
                                                        "FROM DEPARTAMENTO d JOIN LOCACION l " +
                                                        "ON (d.ID_DEPT = l.ID_DEPT) " +
                                                        "WHERE l.ACTIVO <> 0 AND l.NRO_LOCT like " +'"' + Filtro  +'"');
                    break;
                case 1:
                    resultado= conexion.getStmt().executeQuery("SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO " +
                                                        "FROM DEPARTAMENTO d JOIN LOCACION l " +
                                                        "ON (d.ID_DEPT = l.ID_DEPT) " +
                                                        "WHERE l.ACTIVO <> 0 AND l.DESCRIPCION_LOCT like " +'"' + Filtro  +'"');
                    break;                    
                default:
                    break;
            }
   
            while (resultado.next()) {
                  Location loc = new Location();
                  loc.setIdDepartment(resultado.getInt("ID_DEPT"));
                  loc.setIdLocation(resultado.getInt("ID_LOCT"));
                  loc.setNroLocation(resultado.getString("NRO_LOCT"));
                  loc.setDescLocation(resultado.getString("DESCRIPCION_LOCT"));
                  loc.setActivoLocation(resultado.getInt("ACTIVO"));
                  loc.setNameDepartment(resultado.getString("DESCRIPCION_DEPT"));
                  listaLocs.add(loc);
            }
            
            return listaLocs;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Location>();
        }
    }
       
}
