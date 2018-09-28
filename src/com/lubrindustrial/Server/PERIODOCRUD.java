/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class PERIODOCRUD {
    
    public boolean insertar(PERIODO per){
        Conexion conexion = new Conexion();
        //conexion.setHost(ip);
        
        conexion.Conectar();
        int respuesta=0;
        // ******** CAMBIO EN EL QUERY DE INSERCION PARA LA CANTIDAD STOCK DE OPERABILIDAD
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO PERIODOS(ID_OPE,FECHAINICIO_PER,FECHAFIN_PER,DESCRIPCION_PER,HORAS_PER,ACTIVIDAD_PER)values (" +
                                                        per.getIdOp()+ ",'" +per.getFechaInicio()+"','"+per.getFechaFin()+"','"+per.getDescipcionPeriodo()+
                                                        "',"+per.getHorasPeriodo()+","+per.getActividadPeriodo()+")");
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
    
    public ArrayList<PERIODO> visualizar(){
        ArrayList<PERIODO> listaOperabilidades = new ArrayList<PERIODO>();
        Conexion conexion = new Conexion();
        conexion.Conectar();
        ResultSet resultado=null;
        // ** CAMBIO EN EL QUERY DE VISUALIZAR PARA OBTENER LOS NUEVOS CAMPOS AÑADIDOS
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM PERIODOS");
            
            
            while (resultado.next()) {
                  PERIODO per = new PERIODO();
                  per.setIdOp(resultado.getInt("ID_OPE"));
                  per.setFechaInicio(resultado.getString("FECHAINICIO_PER"));
                  per.setFechaFin(resultado.getString("FECHAFIN_PER"));
                  per.setDescipcionPeriodo("DESCRIPCION_PER");
                  per.setHorasPeriodo(resultado.getFloat("HORAS_PER"));
                  per.setActividadPeriodo(resultado.getInt("ACTIVIDAD_PER"));
                  listaOperabilidades.add(per);
            }
            
            return listaOperabilidades;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros OPERABILIDADES: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<PERIODO>();
        }
        
    }
    
    public ArrayList<PERIODO> visualizarPorID(int idOpe){
        ArrayList<PERIODO> listaOperabilidades = new ArrayList<PERIODO>();
        Conexion conexion = new Conexion();
        conexion.Conectar();
        ResultSet resultado=null;
        // ** CAMBIO EN EL QUERY DE VISUALIZAR PARA OBTENER LOS NUEVOS CAMPOS AÑADIDOS
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM PERIODOS WHERE ID_OPE="+idOpe);
            
            
            while (resultado.next()) {
                  PERIODO per = new PERIODO();
                  per.setIdOp(resultado.getInt("ID_OPE"));
                  per.setFechaInicio(resultado.getString("FECHAINICIO_PER"));
                  per.setFechaFin(resultado.getString("FECHAFIN_PER"));
                  per.setDescipcionPeriodo("DESCRIPCION_PER");
                  per.setHorasPeriodo(resultado.getFloat("HORAS_PER"));
                  per.setActividadPeriodo(resultado.getInt("ACTIVIDAD_PER"));
                  listaOperabilidades.add(per);
            }
            
            return listaOperabilidades;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros OPERABILIDADES: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<PERIODO>();
        }
        
    }
    
    public ArrayList<PERIODO> visualizarHorasDiferenciaPorID(int idOpe){
        ArrayList<PERIODO> listaOperabilidades = new ArrayList<PERIODO>();
        Conexion conexion = new Conexion();
        conexion.Conectar();
        ResultSet resultado=null;
        // ** CAMBIO EN EL QUERY DE VISUALIZAR PARA OBTENER LOS NUEVOS CAMPOS AÑADIDOS
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT ID_OPE,FECHAINICIO_PER,FECHAFIN_PER,DESCRIPCION_PER,HORAS_PER,ACTIVIDAD_PER,DATEDIFF(FECHAFIN_PER,FECHAINICIO_PER) AS DIAS"
                                                    + " FROM PERIODOS WHERE ID_OPE="+idOpe);
            
            
            while (resultado.next()) {
                  PERIODO per = new PERIODO();
                  per.setIdOp(resultado.getInt("ID_OPE"));
                  per.setFechaInicio(resultado.getString("FECHAINICIO_PER"));
                  per.setFechaFin(resultado.getString("FECHAFIN_PER"));
                  per.setDescipcionPeriodo(resultado.getString("DESCRIPCION_PER"));
                  per.setHorasPeriodo(resultado.getFloat("HORAS_PER"));
                  per.setActividadPeriodo(resultado.getInt("ACTIVIDAD_PER"));
                  per.setDiasDiferencia(resultado.getInt("DIAS"));
                  listaOperabilidades.add(per);
            }
            
            return listaOperabilidades;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros OPERABILIDADES: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<PERIODO>();
        }
        
    }
}
