/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

/**
 *
 * @author Marcelo
 */
public class AuditoriaCRUD {
    
    String host;
    
    public AuditoriaCRUD(){
        
    }
    
    public AuditoriaCRUD(String hostname){
        this.host = hostname;
    }
    
    public boolean insertarAuditoria(Auditoria aud){
        
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        try{
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO AUDITORIA (ID_AUD,ID_USU,NOMBRE_USU,APELLIDO_USU,TABLAAFECTADA_AUD,ACCION_AUD,DESCRIPCION_AUD) values (" +
                                                        aud.getIdAud()+","+aud.getIdUsu()+",'"+aud.getNombreUsu()+"','"+aud.getApellidoUsu()+"','"+aud.getTablaAfectada()+"','"+aud.getAccionRealizada()+"','"+aud.getDescripcion()+"')");
            if(respuesta>0){
                conexion.Desconectar();
                return true;
            }else{
                conexion.Desconectar();
                return false;
            }
            
        }catch(Exception ex){
            conexion.Desconectar();
            System.out.println(""+ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
