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
public class OPERABILIDADCRUD {

    public String host;

    public OPERABILIDADCRUD(String hostname) {
        host=hostname;
    }
    
    
    public boolean insertar(OPERABILIDAD ope, PERIODO per){
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        PERIODOCRUD perCRUD = new PERIODOCRUD(host);
        conexion.Conectar();
        int respuesta=0;
        boolean flag=false;
        // ******** CAMBIO EN EL QUERY DE INSERCION PARA LA CANTIDAD STOCK DE OPERABILIDAD
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO OPERABILIDAD (ID_EQ,DESCRIPCION_OPE)values (" +
                                                        ope.getIdEq()+ ",'" +ope.getDescripcion()+"')");
            
            if(respuesta>0){
                per.setIdOp(obtenerIdOperabilidad()); // obtengo la operabilidad insertada
                per.setActividadPeriodo(1);
                flag=perCRUD.insertar(per);
                if(respuesta>0 && flag){
                    conexion.Desconectar();
                    return true;
                }else{
                    conexion.Desconectar();
                    return false;
                }
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
  
    public ArrayList<OPERABILIDAD> visualizar(){
        ArrayList<OPERABILIDAD> listaOperabilidades = new ArrayList<OPERABILIDAD>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        // ** CAMBIO EN EL QUERY DE VISUALIZAR PARA OBTENER LOS NUEVOS CAMPOS AÑADIDOS
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT o.ID_OPE,o.ID_EQ,e.NRO_EQ,e.DESCRIPCION_EQ,o.DESCRIPCION_OPE "
                    + "FROM OPERABILIDAD o JOIN EQUIPO e "
                    + "ON (o.ID_EQ=e.ID_EQ)");
            
            
            while (resultado.next()) {
                  OPERABILIDAD op = new OPERABILIDAD();
                  op.setIdOp(resultado.getInt("ID_OPE"));
                  op.setIdEq(resultado.getInt("ID_EQ"));
                  op.setDescEquipo(resultado.getString("NRO_EQ")+" "+resultado.getString("DESCRIPCION_EQ"));
                  op.setDescripcion(resultado.getString("DESCRIPCION_OPE"));
                  listaOperabilidades.add(op);
            }
            
            return listaOperabilidades;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros OPERABILIDADES: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<OPERABILIDAD>();
        }
        
    }
    
    public int obtenerIdOperabilidad(){
        int idOpe=0;
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        // ** CAMBIO EN EL QUERY DE VISUALIZAR PARA OBTENER LOS NUEVOS CAMPOS AÑADIDOS
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT MAX(ID_OPE) AS ID_OPERABILIDAD FROM OPERABILIDAD");
            
            
            while (resultado.next()) {
                  idOpe=resultado.getInt("ID_OPERABILIDAD");
                  
            }
            
            return idOpe;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros MAXIMO OPERABILIDAD: " + ex.getMessage());
            ex.printStackTrace();
            
            return 0;
        }
    }
   
    
}
