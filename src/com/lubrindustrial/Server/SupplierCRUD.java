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
public class SupplierCRUD {
    
    String host;
    
    public SupplierCRUD(){
        
    }
    
    public SupplierCRUD(String hostname){
        this.host = hostname;
    }
    
    public boolean insertar(Supplier s){
        
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO PROVEEDOR (NRO_PROV,NOMBRE_PROV,DIRECCION_PROV,CIUDAD_PROV,FAX_PROV,EMAIL_RPOV,TELEFONO_PROV)values ('" +
                                                        s.getNroSupplier()+ "','" +s.getNameSupplier()+"','"+s.getDirSupplier()+"','"+
                                                        s.getCitySupplier()+"','"+s.getEmailSupplier()+"','"+s.getEmail2Supplier()+"','"+
                                                        s.getTelfSupplier()+"')");
            if(respuesta>0){
                conexion.Desconectar();
                return true;
            }else{
                conexion.Desconectar();
                return false;
            }
        } catch (Exception ex) {
            conexion.Desconectar();
            System.out.println("Excepcion Proveedor: "+ex.getMessage());
            return false;
        }
        
    }
    
    public boolean modificar(Supplier supp, User usu){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try{
            
            respuesta=conexion.getStmt().executeUpdate("UPDATE PROVEEDOR set NRO_PROV='" +supp.getNroSupplier()+
                                                        "', NOMBRE_PROV='"+supp.getNameSupplier()+
                                                        "', DIRECCION_PROV='"+supp.getDirSupplier()+
                                                        "', CIUDAD_PROV='"+supp.getCitySupplier()+
                                                        "', FAX_PROV='"+supp.getEmail2Supplier()+
                                                        "', TELEFONO_PROV='"+supp.getTelfSupplier()+
                                                        "', EMAIL_RPOV='"+supp.getEmailSupplier()+
                                                        "' WHERE ID_PROV="+supp.getIdSupplier()+"");
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("PROVEEDORES");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(supp.getNroSupplier()+"-"+supp.getNameSupplier());
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
        Supplier sup = obtenerProv(codigo);
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE PROVEEDOR set ACTIVO='" +0+
                                                        "' WHERE ID_PROV="+codigo+"");
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("PROVEEDORES");
                 a.setAccionRealizada("ELIMINACIÓN");
                 a.setDescripcion(sup.getNroSupplier()+"-"+sup.getNameSupplier());
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
    
    public ArrayList<Supplier> visualizar(){
        ArrayList<Supplier> listaProveedores = new ArrayList<Supplier>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0");
            
            while (resultado.next()) {
                  Supplier sup = new Supplier();
                  sup.setIdSupplier(resultado.getInt("ID_PROV"));
                  sup.setNroSupplier(resultado.getString("NRO_PROV"));
                  sup.setNameSupplier(resultado.getString("NOMBRE_PROV"));
                  sup.setDirSupplier(resultado.getString("DIRECCION_PROV"));
                  sup.setCitySupplier(resultado.getString("CIUDAD_PROV"));
                  sup.setEmailSupplier(resultado.getString("FAX_PROV"));
                  sup.setEmail2Supplier(resultado.getString("EMAIL_RPOV"));
                  sup.setTelfSupplier(resultado.getString("TELEFONO_PROV"));
                  sup.setActivo(resultado.getInt("ACTIVO"));
                  listaProveedores.add(sup);
            }
            
            return listaProveedores;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros PROVEEDORES: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Supplier>();
        }
    }
    
    public ArrayList<Supplier> visualizar(int idSupplier){
        ArrayList<Supplier> listaProveedores = new ArrayList<Supplier>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0 AND ID_PROV = '" + idSupplier + "'");
            
            while (resultado.next()) {
                  Supplier sup = new Supplier();
                  sup.setIdSupplier(resultado.getInt("ID_PROV"));
                  sup.setNroSupplier(resultado.getString("NRO_PROV"));
                  sup.setNameSupplier(resultado.getString("NOMBRE_PROV"));
                  sup.setDirSupplier(resultado.getString("DIRECCION_PROV"));
                  sup.setCitySupplier(resultado.getString("CIUDAD_PROV"));
                  sup.setEmailSupplier(resultado.getString("FAX_PROV"));
                  sup.setEmail2Supplier(resultado.getString("EMAIL_RPOV"));
                  sup.setTelfSupplier(resultado.getString("TELEFONO_PROV"));
                  sup.setActivo(resultado.getInt("ACTIVO"));
                  listaProveedores.add(sup);
            }
            
            return listaProveedores;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros PROVEEDORES: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Supplier>();
        }
    }
    
    public Supplier obtenerProv(int idSupplier){
//        ArrayList<Supplier> listaProveedores = new ArrayList<Supplier>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0 AND ID_PROV = '" + idSupplier + "'");
            Supplier sup = new Supplier();
            if (resultado.next()) {
                  
                  sup.setIdSupplier(resultado.getInt("ID_PROV"));
                  sup.setNroSupplier(resultado.getString("NRO_PROV"));
                  sup.setNameSupplier(resultado.getString("NOMBRE_PROV"));
                  sup.setDirSupplier(resultado.getString("DIRECCION_PROV"));
                  sup.setCitySupplier(resultado.getString("CIUDAD_PROV"));
                  sup.setEmailSupplier(resultado.getString("FAX_PROV"));
                  sup.setEmail2Supplier(resultado.getString("EMAIL_RPOV"));
                  sup.setTelfSupplier(resultado.getString("TELEFONO_PROV"));
                  sup.setActivo(resultado.getInt("ACTIVO"));
//                  listaProveedores.add(sup);
            }
            
            return sup;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros PROVEEDORES: " + ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
    
    public ArrayList<Supplier> visualizar(String texto, int item){
        
        ArrayList<Supplier> listaSupp = new ArrayList<Supplier>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        String Filtro=""+texto+"_%";
        try{
            conexion.getStmt();
            switch(item){
                case 0:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0 AND NRO_PROV like " +'"' + Filtro  +'"');
                    break;
                case 1:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0 AND NOMBRE_PROV like " +'"' + Filtro  +'"');
                    break;
                case 2:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0 AND DIRECCION_PROV like " +'"' + Filtro  +'"');
                    break;
                case 3:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0 AND CIUDAD_PROV like " +'"' + Filtro  +'"');
                    break;
                case 4:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0 AND FAX_PROV like " +'"' + Filtro  +'"');
                    break;
                case 5:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0 AND TELEFONO_PROV like " +'"' + Filtro  +'"');
                    break;
                case 6:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM PROVEEDOR WHERE ACTIVO <> 0 AND EMAIL_PROV like " +'"' + Filtro  +'"');
                    break;
                default:
                    break;
            }
            

           while (resultado.next()) {
                  Supplier sup = new Supplier();
                  sup.setIdSupplier(resultado.getInt("ID_PROV"));
                  sup.setNroSupplier(resultado.getString("NRO_PROV"));
                  sup.setNameSupplier(resultado.getString("NOMBRE_PROV"));
                  sup.setDirSupplier(resultado.getString("DIRECCION_PROV"));
                  sup.setCitySupplier(resultado.getString("CIUDAD_PROV"));
                  sup.setEmailSupplier(resultado.getString("FAX_PROV"));
                  sup.setEmail2Supplier(resultado.getString("EMAIL_RPOV"));
                  sup.setTelfSupplier(resultado.getString("TELEFONO_PROV"));
                  sup.setActivo(resultado.getInt("ACTIVO"));
                  listaSupp.add(sup);
            }
            
            return listaSupp;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros PROVEEDORES: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Supplier>();
        }
    }
       
}
