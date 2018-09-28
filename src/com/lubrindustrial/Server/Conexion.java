/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marcelo
 */
public class Conexion {
    private Connection con;
    private Statement stm;
    private String host;
    private String port;
    private String database;
    private String url;
    private String userName;
    private String password;
    
    private String errString;
     // Constructor public Connect(){}

    public Conexion(String ipPrueba, int n){
    
            this.host = ipPrueba;
            // ESTE ES UN COMENTARIO
            // ESTE ES UN SEGUNDO COMENTARIO
            // este es otro comentario
        
    }
    
    public Conexion()
    {
        host = "localhost";
        port = "3306";
        database = "lubrindustriales";
        url = "jdbc:mysql://localhost:3306/" + database;
        userName = "administrador";
        password = "admin.soft.18.jcrh.1000";
        //Conectar();
    }
    
    public Conexion(int num) {
        host = "localhost";
        port = "3306";
        database = "lubrindustriales";
        url = "jdbc:mysql://localhost:3306/" + database;
        userName = "root";
        password = "";

        Conectar();
    }

    public Conexion(String host)
    {
//        this.host = host;
        this.host = "localhost";
        port = "3306";
        database = "lubrindustriales";
//        url = "jdbc:mysql://"+this.host+":3306/" + database;
        url = "jdbc:mysql://localhost:3306/" + database;
        userName = "root";
        password = "";
        
        Conectar();
    }
    
    public String getConnectionUrl()
    {
        return url;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        
        this.host = host;
        this.url = "jdbc:mysql://"+this.host+":3306/" + database;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrString() {
        return errString;
    }

    public void setErrString(String errString) {
        this.errString = errString;
    }

    
     public Connection Conectar(){
        con=null;
         try{
              Class.forName("org.gjt.mm.mysql.Driver");
              con = DriverManager.getConnection(getConnectionUrl(),userName,password);
              stm=con.createStatement();
              System.out.println("Conectado a "+url);
         }catch(Exception e){
             errString= "Error de conexion con la Base de Datos";
             System.out.println(errString);
             System.out.println(""+e.getMessage());
             return null;
         }
          return con;
     }

     public Connection Conectar(String host){
        con=null;
         try{
              Class.forName("org.gjt.mm.mysql.Driver");
              con = DriverManager.getConnection(getConnectionUrl(),userName,password);
              stm=con.createStatement();
              System.out.println("Conectado");
         }catch(Exception e){
             errString= "Error de conexion con la Base de Datos";
             System.out.println(errString);
             System.out.println(""+e.getMessage());
             return null;
         }
          return con;
     }
     
     /* Mostrar las propiedades del controlador y los detalles de la base de datos */

       public void Desconectar()
     {
         try{
              stm.close();
              con.close();
         }catch(SQLException e){
             errString= "Error Mientras se Cerraba la Conexion a la Base de Datos";
         }
     }
       public Statement getStmt()
       {
          return this.stm;
       }
}
