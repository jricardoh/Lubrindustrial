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
 * @author Marcelo
 */
public class SequenceCRUD {
    
    String host;
    
    public SequenceCRUD(){
        
    }
    
    public SequenceCRUD(String hostname){
        this.host = hostname;
    }
    
    public boolean insertar(Sequence sec){
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO SECUENCIA (ID_INST,NRO_SEC,DESCRIPCION_SEC)values (" +
                                                        sec.getIdInst()+ ",'" +sec.getNroSec()+"','"+sec.getDescSec()+"')");
            if(respuesta>0){
                conexion.Desconectar();
                return true;
            }else{
                conexion.Desconectar();
                return false;
            }
        } catch (Exception ex) {
            conexion.Desconectar();
            System.out.println(""+ex.getMessage());
            return false;
        }
        
    }
    
    public boolean modificar(Sequence sec, User usu){
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE SECUENCIA set NRO_SEC='" +sec.getNroSec()+
                                                        "', DESCRIPCION_SEC='"+sec.getDescSec()+
                                                        "', ID_INST='"+sec.getIdInst()+
                                                        "' WHERE ID_SEC="+sec.getIdSec()+"");
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("SECUENCIAS");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(sec.getNroSec()+"-"+sec.getDescSec());
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
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        Sequence sec = obtenerSecuencia(codigo);
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE SECUENCIA set ACTIVO='" +0+
                                                        "' WHERE ID_SEC="+codigo+"");
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("SECUENCIAS");
                 a.setAccionRealizada("ELIMINACIÓN");
                 a.setDescripcion(sec.getNroSec()+"-"+sec.getDescSec());
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
    
    public ArrayList<Sequence> visualizar(){
        ArrayList<Sequence> listaSecuencias = new ArrayList<Sequence>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT s.ID_SEC,s.ID_INST,i.DESCRIPCION_INST,s.NRO_SEC,s.DESCRIPCION_SEC,s.ACTIVO" +
                                                        " FROM SECUENCIA s JOIN INSTRUCCION i" +
                                                        " ON (s.ID_INST = i.ID_INST)" +
                                                        " WHERE s.ACTIVO <> 0");
            
            /*
            SELECT s.ID_SEC,s.ID_INST,i.DESCRIPCION_INST,s.NRO_SEC,s.DESCRIPCION_SEC,s.ACTIVO
            FROM SECUENCIA s JOIN INSTRUCCION i
            ON (s.ID_INST = i.ID_INST)
            WHERE s.ACTIVO <> 0
            */
            
            while (resultado.next()) {
                  Sequence sec = new Sequence();
                  sec.setIdSec(resultado.getInt("ID_SEC"));
                  sec.setIdInst(resultado.getInt("ID_INST"));
                  sec.setDescInst(resultado.getString("DESCRIPCION_INST"));
                  sec.setNroSec(resultado.getString("NRO_SEC"));
                  sec.setDescSec(resultado.getString("DESCRIPCION_SEC"));
                  sec.setActivo(resultado.getInt("ACTIVO"));
                  listaSecuencias.add(sec);
            }
            
            return listaSecuencias;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros SECUENCIAS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Sequence>();
        }
    }
    
    public ArrayList<Sequence> visualizar(int idSequence){
        ArrayList<Sequence> listaSecuencias = new ArrayList<Sequence>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT s.ID_SEC,s.ID_INST,i.DESCRIPCION_INST,s.NRO_SEC,s.DESCRIPCION_SEC,s.ACTIVO" +
                                                        " FROM SECUENCIA s JOIN INSTRUCCION i" +
                                                        " ON (s.ID_INST = i.ID_INST)" +
                                                        " WHERE s.ACTIVO <> 0 AND s.ID_SEC = '" + idSequence + "'");
            
            /*
            SELECT s.ID_SEC,s.ID_INST,i.DESCRIPCION_INST,s.NRO_SEC,s.DESCRIPCION_SEC,s.ACTIVO
            FROM SECUENCIA s JOIN INSTRUCCION i
            ON (s.ID_INST = i.ID_INST)
            WHERE s.ACTIVO <> 0
            */
            
            while (resultado.next()) {
                  Sequence sec = new Sequence();
                  sec.setIdSec(resultado.getInt("ID_SEC"));
                  sec.setIdInst(resultado.getInt("ID_INST"));
                  sec.setDescInst(resultado.getString("DESCRIPCION_INST"));
                  sec.setNroSec(resultado.getString("NRO_SEC"));
                  sec.setDescSec(resultado.getString("DESCRIPCION_SEC"));
                  sec.setActivo(resultado.getInt("ACTIVO"));
                  listaSecuencias.add(sec);
            }
            
            return listaSecuencias;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros SECUENCIAS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Sequence>();
        }
    }
    
    public Sequence obtenerSecuencia(int idSequence){
//        ArrayList<Sequence> listaSecuencias = new ArrayList<Sequence>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT s.ID_SEC,s.ID_INST,i.DESCRIPCION_INST,s.NRO_SEC,s.DESCRIPCION_SEC,s.ACTIVO" +
                                                        " FROM SECUENCIA s JOIN INSTRUCCION i" +
                                                        " ON (s.ID_INST = i.ID_INST)" +
                                                        " WHERE s.ACTIVO <> 0 AND s.ID_SEC = '" + idSequence + "'");
            

            Sequence sec = new Sequence();
            if (resultado.next()) {
                  
                  sec.setIdSec(resultado.getInt("ID_SEC"));
                  sec.setIdInst(resultado.getInt("ID_INST"));
                  sec.setDescInst(resultado.getString("DESCRIPCION_INST"));
                  sec.setNroSec(resultado.getString("NRO_SEC"));
                  sec.setDescSec(resultado.getString("DESCRIPCION_SEC"));
                  sec.setActivo(resultado.getInt("ACTIVO"));
//                  listaSecuencias.add(sec);
            }
            
            return sec;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros SECUENCIAS: " + ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
    
    public ArrayList<Sequence> visualizar(String texto, int item){
        
        ArrayList<Sequence> listaSeq = new ArrayList<Sequence>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        String Filtro=""+texto+"_%";
        try{
            conexion.getStmt();
            switch(item){
                case 0:
                    resultado= conexion.getStmt().executeQuery("SELECT s.ID_SEC,s.ID_INST,i.DESCRIPCION_INST,s.NRO_SEC,s.DESCRIPCION_SEC,s.ACTIVO" +
                                                        " FROM SECUENCIA s JOIN INSTRUCCION i" +
                                                        " ON (s.ID_INST = i.ID_INST)" +
                                                        " WHERE s.ACTIVO <> 0 AND s.NRO_SEC like " +'"' + Filtro  +'"');
                    break;
                case 1:
                    resultado= conexion.getStmt().executeQuery("SELECT s.ID_SEC,s.ID_INST,i.DESCRIPCION_INST,s.NRO_SEC,s.DESCRIPCION_SEC,s.ACTIVO" +
                                                        " FROM SECUENCIA s JOIN INSTRUCCION i" +
                                                        " ON (s.ID_INST = i.ID_INST)" +
                                                        " WHERE s.ACTIVO <> 0 AND s.DESCRIPCION_SEC like " +'"' + Filtro  +'"');
                    break;
                default:
                    break;
            }
           
             while (resultado.next()) {
                  Sequence sec = new Sequence();
                  sec.setIdSec(resultado.getInt("ID_SEC"));
                  sec.setIdInst(resultado.getInt("ID_INST"));
                  sec.setDescInst(resultado.getString("DESCRIPCION_INST"));
                  sec.setNroSec(resultado.getString("NRO_SEC"));
                  sec.setDescSec(resultado.getString("DESCRIPCION_SEC"));
                  sec.setActivo(resultado.getInt("ACTIVO"));
                  listaSeq.add(sec);
            }
            return listaSeq;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Sequence>();
        }
    }
       
}
