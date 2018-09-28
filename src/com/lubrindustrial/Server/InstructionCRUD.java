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
public class InstructionCRUD {
    
    String host;
    
    public InstructionCRUD(){
        
    }
    
    public InstructionCRUD(String hostname){
        this.host = hostname;
    }
    
    public boolean insertar(Instruction inst){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO INSTRUCCION (NRO_INST,DESCRIPCION_INST,HORAS_INST,NOTAS_INST)values ('" +
                                                        inst.getNroInst()+ "','" +inst.getDescInst()+"',"+inst.getHorasInst()+",'"+inst.getNotasInst()+"')");
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
    
    public boolean modificar(Instruction inst, User usu){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE INSTRUCCION set NRO_INST='" +inst.getNroInst()+
                                                        "', DESCRIPCION_INST='"+inst.getDescInst()+
                                                        "', HORAS_INST='"+inst.getHorasInst()+
                                                        "', NOTAS_INST='"+inst.getNotasInst()+
                                                        "' WHERE ID_INST="+inst.getIdInst()+"");
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("INSTRUCCIONES");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(inst.getNroInst()+"-"+inst.getDescInst());
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
        Instruction inst = obtenerInst(codigo);
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE INSTRUCCION set ACTIVO='" +0+
                                                        "' WHERE ID_INST="+codigo+"");
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("INSTRUCCIONES");
                 a.setAccionRealizada("ELIMINACIÓN");
                 a.setDescripcion(inst.getNroInst()+"-"+inst.getDescInst());
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
    
    public ArrayList<Instruction> visualizar(){
        ArrayList<Instruction> listaInstrucciones = new ArrayList<Instruction>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM INSTRUCCION WHERE ACTIVO <> 0");
            
            while (resultado.next()) {
                  Instruction inst = new Instruction();
                  inst.setIdInst(resultado.getInt("ID_INST"));
                  inst.setNroInst(resultado.getString("NRO_INST"));
                  inst.setDescInst(resultado.getString("DESCRIPCION_INST"));
                  inst.setHorasInst(resultado.getFloat("HORAS_INST"));
                  inst.setNotasInst(resultado.getString("NOTAS_INST"));
                  inst.setActivo(resultado.getInt("ACTIVO"));
                  listaInstrucciones.add(inst);
            }
            
            return listaInstrucciones;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros INSTRUCCIONES: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Instruction>();
        }
    }
    
    public ArrayList<Instruction> visualizar(int idInstruction){
        ArrayList<Instruction> listaInstrucciones = new ArrayList<Instruction>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM INSTRUCCION WHERE ACTIVO <> 0  AND ID_INST = '" + idInstruction + "'");
            
            while (resultado.next()) {
                  Instruction inst = new Instruction();
                  inst.setIdInst(resultado.getInt("ID_INST"));
                  inst.setNroInst(resultado.getString("NRO_INST"));
                  inst.setDescInst(resultado.getString("DESCRIPCION_INST"));
                  inst.setHorasInst(resultado.getFloat("HORAS_INST"));
                  inst.setNotasInst(resultado.getString("NOTAS_INST"));
                  inst.setActivo(resultado.getInt("ACTIVO"));
                  listaInstrucciones.add(inst);
            }
            
            return listaInstrucciones;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros INSTRUCCIONES: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Instruction>();
        }
    }
    
    public Instruction obtenerInst(int idInstruction){
//        ArrayList<Instruction> listaInstrucciones = new ArrayList<Instruction>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM INSTRUCCION WHERE ACTIVO <> 0  AND ID_INST = '" + idInstruction + "'");
            Instruction inst = new Instruction();
            if (resultado.next()) {
                  
                  inst.setIdInst(resultado.getInt("ID_INST"));
                  inst.setNroInst(resultado.getString("NRO_INST"));
                  inst.setDescInst(resultado.getString("DESCRIPCION_INST"));
                  inst.setHorasInst(resultado.getFloat("HORAS_INST"));
                  inst.setNotasInst(resultado.getString("NOTAS_INST"));
                  inst.setActivo(resultado.getInt("ACTIVO"));
//                  listaInstrucciones.add(inst);
            }
            
            return inst;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros INSTRUCCIONES: " + ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
    
    public ArrayList<Instruction> mostrarPorCodigo(int codigo)
    {
        ArrayList<Instruction> listaIns=new ArrayList<Instruction>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT I.ID_INST, I.DESCRIPCION_INST FROM INSTRUCCION I "
                    + "INNER JOIN instr_mant IM ON I.ID_INST=IM.ID_INST WHERE IM.ID_MANT="+codigo);
            /*SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO
              FROM DEPARTAMENTO d JOIN LOCACION l
              ON (d.ID_DEPT = l.ID_DEPT)*/
            
            while (resultado.next()) {
                  Instruction inst = new Instruction();
                  
                  inst.setIdInst(resultado.getInt("ID_INST"));
                  inst.setDescInst(resultado.getString("DESCRIPCION_INST"));
                  listaIns.add(inst);
            }
            
            return listaIns;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros LOCATIONS: " + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Instruction>();
        }
    }
     public ArrayList<Instruction> visualizar(String texto, int item){
        
        ArrayList<Instruction> listaInstrucciones = new ArrayList<Instruction>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        String Filtro=""+texto+"_%";
        try{
            conexion.getStmt();
            switch(item){
                case 0:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM INSTRUCCION WHERE ACTIVO <> 0  AND NRO_INST like " +'"' + Filtro  +'"');
                    break;
                case 1:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM INSTRUCCION WHERE ACTIVO <> 0  AND DESCRIPCION_INST like " +'"' + Filtro  +'"');
                    break;
                case 2:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM INSTRUCCION WHERE ACTIVO <> 0 AND (HORAS_INST '"+ Filtro +"' OR HORAS_INST = '"+ texto +"')");
                    break;
                case 3:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM INSTRUCCION WHERE ACTIVO <> 0  AND NOTAS_INST like " +'"' + Filtro  +'"');
                    break;
                default:
                    break;
            }
            
            while (resultado.next()) {
                  Instruction inst = new Instruction();
                  inst.setIdInst(resultado.getInt("ID_INST"));
                  inst.setNroInst(resultado.getString("NRO_INST"));
                  inst.setDescInst(resultado.getString("DESCRIPCION_INST"));
                  inst.setHorasInst(resultado.getFloat("HORAS_INST"));
                  inst.setNotasInst(resultado.getString("NOTAS_INST"));
                  inst.setActivo(resultado.getInt("ACTIVO"));
                  listaInstrucciones.add(inst);
            }
            
            return listaInstrucciones;
            
           

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Instruction>();
        }
    }
       
}
