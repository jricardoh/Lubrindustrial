/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author RH
 */
public class UserCRUD {
    
    String host;
    
    public UserCRUD(){
        
    }
    
    public UserCRUD(String hostname){
        this.host = hostname;
    }
    
  
    public boolean insertar(User use){
        Conexion conexion = new Conexion(this.host);
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO USUARIO ("/*ID_USU, */+"NOMBRE_USU, APELLIDO_USU, PREGUNTA1_USU, PREGUNTA2_USU, USUARIO_USU, PASSWORD_USU, ACTIVO) values ('" +
                                                        /*use.getNomUser()+"0','"+*/use.getNomUser()+"','"+use.getApeUser()+"','"+use.getPreg1User()+"','"+use.getPreg2User()+"','"+use.getUsuUser()+"',MD5(SHA1(SHA1(\""+use.getPassUser()+"\"))),'"+use.getActivoUser()+"')");
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
    
    public boolean modificar(User use){
        Conexion conexion = new Conexion(this.host);
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE USUARIO set "/*+"ID_USU='" +use.getIdUser()*/+
                                                        "NOMBRE_USU='"+use.getNomUser()+
                                                        "', APELLIDO_USU='"+use.getApeUser()+
                                                        "', PREGUNTA1_USU='"+use.getPreg1User()+
                                                        "', PREGUNTA2_USU='"+use.getPreg2User()+
                                                        "', USUARIO_USU='"+use.getUsuUser()+
                                                        "', PASSWORD_USU='"+use.getPassUser()+
                                                        "', ACTIVO='"+use.getActivoUser()+
                                                        "' WHERE ID_USU="+use.getIdUser());
            if(respuesta>0){
                 conexion.Desconectar();
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
    
    public boolean eliminar(int codigo){
        Conexion conexion = new Conexion(this.host);
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE USUARIO set ACTIVO='" +0+
                                                        "' WHERE ID_USU="+codigo);
            
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if(respuesta>0){
                 conexion.Desconectar();
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
    
    public ArrayList<User> visualizar(String nomUsuario){
        ArrayList<User> listaUsu = new ArrayList<User>();
        Conexion conexion = new Conexion(this.host);
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM USUARIO WHERE ACTIVO <> 0 AND USUARIO_USU LIKE '" + nomUsuario + "'");

            while (resultado.next()) {
                  User use = new User();
 
                  use.setIdUser(resultado.getInt("ID_USU"));
                  use.setNomUser(resultado.getString("NOMBRE_USU"));
                  use.setApeUser(resultado.getString("APELLIDO_USU"));
                  use.setPreg1User(resultado.getString("PREGUNTA1_USU"));
                  use.setPreg2User(resultado.getString("PREGUNTA2_USU"));
                  use.setUsuUser(resultado.getString("USUARIO_USU"));
                  use.setPassUser(resultado.getString("PASSWORD_USU"));
                  use.setActivoUser(resultado.getInt("ACTIVO"));
                  listaUsu.add(use);
            }
            
            return listaUsu;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros USUARIOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<User>();
        }
    }
    
    public User obtenerUsuario(String nomUsuario){
        
        Conexion conexion = new Conexion(this.host);
        conexion.setHost(host);
        
        conexion.Conectar();
        System.out.println(this.host);
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM USUARIO WHERE ACTIVO <> 0 AND USUARIO_USU LIKE '" + nomUsuario + "'");
            User use = new User();
            if(resultado.next()) {
 
                  use.setIdUser(resultado.getInt("ID_USU"));
                  use.setNomUser(resultado.getString("NOMBRE_USU"));
                  use.setApeUser(resultado.getString("APELLIDO_USU"));
                  use.setPreg1User(resultado.getString("PREGUNTA1_USU"));
                  use.setPreg2User(resultado.getString("PREGUNTA2_USU"));
                  use.setUsuUser(resultado.getString("USUARIO_USU"));
                  use.setPassUser(resultado.getString("PASSWORD_USU"));
                  use.setActivoUser(resultado.getInt("ACTIVO"));
            }
            
            return use;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros USUARIOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
    
    public int numUsers(){
        
        int count = 0;
        Conexion conexion = new Conexion(this.host);
        conexion.setHost(host);
        
        conexion.Conectar ();
        ResultSet resultado = null;
    
        try{
            conexion.getStmt();
            resultado = conexion.getStmt().executeQuery("SELECT * FROM USUARIO");
        
        while (resultado.next()) {
            count++;
        }
        return count;
    }
    catch (SQLException ex){
            System.err.println("Error en obtener el número de usuarios: " + ex.getMessage());
            ex.printStackTrace();
            return -1;
        }
    }
    
    public String leerPass(String nomUsuario){
        ArrayList<User> listaUsu = new ArrayList<User>();
        Conexion conexion = new Conexion(this.host);
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM USUARIO WHERE ACTIVO <> 0 AND USUARIO_USU LIKE '" + nomUsuario + "'");
            
            while (resultado.next()) {
                  User use = new User();

                  use.setIdUser(resultado.getInt("ID_USU"));
                  use.setNomUser(resultado.getString("NOMBRE_USU"));
                  use.setApeUser(resultado.getString("APELLIDO_USU"));
                  use.setPreg1User(resultado.getString("PREGUNTA1_USU"));
                  use.setPreg2User(resultado.getString("PREGUNTA2_USU"));
                  use.setUsuUser(resultado.getString("USUARIO_USU"));
                  use.setPassUser(resultado.getString("PASSWORD_USU"));
                  use.setActivoUser(resultado.getInt("ACTIVO"));
                  listaUsu.add(use);
            }
            
            return listaUsu.get(6).toString();

        } catch (SQLException ex){
            System.err.println("Error en leer contraseña: " + ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
    
        public String[] leerNomApe(String nomUsuario){
        ArrayList<User> listaUsu = new ArrayList<User>();
        Conexion conexion = new Conexion(this.host);
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        String[] nomApe = new String[2];
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM USUARIO WHERE ACTIVO <> 0 AND USUARIO_USU LIKE '" + nomUsuario + "'");
            
            while (resultado.next()) {
                  User use = new User();

                  use.setIdUser(resultado.getInt("ID_USU"));
                  use.setNomUser(resultado.getString("NOMBRE_USU"));
                  use.setApeUser(resultado.getString("APELLIDO_USU"));
                  use.setPreg1User(resultado.getString("PREGUNTA1_USU"));
                  use.setPreg2User(resultado.getString("PREGUNTA2_USU"));
                  use.setUsuUser(resultado.getString("USUARIO_USU"));
                  use.setPassUser(resultado.getString("PASSWORD_USU"));
                  use.setActivoUser(resultado.getInt("ACTIVO"));
                  listaUsu.add(use);
            }
            nomApe[0] = listaUsu.get(1).toString();
            nomApe[1] = listaUsu.get(2).toString();
            return nomApe;

        } catch (SQLException ex){
            System.err.println("Error en leer contraseña: " + ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
        
}
