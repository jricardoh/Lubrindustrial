/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonny
 */
public class DepartmentCRUD {
    
    String host="localhost";
    
    public DepartmentCRUD(){
        
    }
    
    public DepartmentCRUD(String hostname){
        this.host = hostname;
    }
    
    
    public boolean insertar(Department dep){
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO DEPARTAMENTO (NRO_DEPT,DESCRIPCION_DEPT)values ('" +
                                                        dep.getNroDepartment()+ "','" +dep.getDescDepartment()+"')");
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
    
    public boolean modificar(Department dep, User usu){
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE DEPARTAMENTO set NRO_DEPT='" +dep.getNroDepartment()+
                                                        "', DESCRIPCION_DEPT='"+dep.getDescDepartment()+
                                                        "' WHERE ID_DEPT="+dep.getIdDepartment()+"");
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("DEPARTAMENTOS");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(dep.getNroDepartment()+"-"+dep.getDescDepartment());
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
        Department dep = obtenerDept(codigo);
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE DEPARTAMENTO set ACTIVO='" +0+
                                                        "' WHERE ID_DEPT="+codigo+"");
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("DEPARTAMENTOS");
                 a.setAccionRealizada("ELIMINACIÓN");
                 a.setDescripcion(dep.getNroDepartment()+"-"+dep.getDescDepartment());
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
    
    public ArrayList<Department> visualizar(){
        ArrayList<Department> listaDepartamentos = new ArrayList<Department>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM DEPARTAMENTO WHERE ACTIVO <> 0");
            
            while (resultado.next()) {
                  Department dep = new Department();
                  dep.setIdDepartment(resultado.getInt("ID_DEPT"));
                  dep.setNroDepartment(resultado.getString("NRO_DEPT"));
                  dep.setDescDepartment(resultado.getString("DESCRIPCION_DEPT"));
                  dep.setActivoDepartment(resultado.getInt("ACTIVO"));
                  listaDepartamentos.add(dep);
            }
            
            return listaDepartamentos;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros DEPARTAMENTOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Department>();
        }
    }
    
    public ArrayList<Department> visualizar(int idDept){
        ArrayList<Department> listaDepartamentos = new ArrayList<Department>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM DEPARTAMENTO WHERE ACTIVO <> 0 AND ID_DEPT = '" + idDept + "'");
            
            while (resultado.next()) {
                  Department dep = new Department();
                  dep.setIdDepartment(resultado.getInt("ID_DEPT"));
                  dep.setNroDepartment(resultado.getString("NRO_DEPT"));
                  dep.setDescDepartment(resultado.getString("DESCRIPCION_DEPT"));
                  dep.setActivoDepartment(resultado.getInt("ACTIVO"));
                  listaDepartamentos.add(dep);
            }
            
            return listaDepartamentos;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros DEPARTAMENTOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Department>();
        }
    }
    
    public Department obtenerDept(int idDept){
//        ArrayList<Department> listaDepartamentos = new ArrayList<Department>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM DEPARTAMENTO WHERE ACTIVO <> 0 AND ID_DEPT = '" + idDept + "'");
            Department dep = new Department();
            if (resultado.next()) {
                  
                  dep.setIdDepartment(resultado.getInt("ID_DEPT"));
                  dep.setNroDepartment(resultado.getString("NRO_DEPT"));
                  dep.setDescDepartment(resultado.getString("DESCRIPCION_DEPT"));
                  dep.setActivoDepartment(resultado.getInt("ACTIVO"));
//                  listaDepartamentos.add(dep);
            }
            
            return dep;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros DEPARTAMENTOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
    
    public ArrayList<Department> visualizar(String texto, int item){
        
        ArrayList<Department> listaDept = new ArrayList<Department>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        String Filtro=""+texto+"_%";
        try{
            conexion.getStmt();
            switch(item){
                case 0:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM DEPARTAMENTO WHERE ACTIVO <> 0 AND NRO_DEPT like " +'"' + Filtro  +'"');

                    break;
                case 1:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM DEPARTAMENTO WHERE ACTIVO <> 0 AND DESCRIPCION_DEPT like " +'"' + Filtro  +'"');

                    break;
                  
                default:
                    break;
            }
            
            
            while (resultado.next()) {
                  Department dep = new Department();
                  dep.setIdDepartment(resultado.getInt("ID_DEPT"));
                  dep.setNroDepartment(resultado.getString("NRO_DEPT"));
                  dep.setDescDepartment(resultado.getString("DESCRIPCION_DEPT"));
                  dep.setActivoDepartment(resultado.getInt("ACTIVO"));
                  listaDept.add(dep);
            }
            
            return listaDept;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros DEPARTAMENTOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Department>();
        }
    }
       
}
