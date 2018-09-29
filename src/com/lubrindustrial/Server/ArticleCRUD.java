/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonny
 */
public class ArticleCRUD {
    
    String host;
    
    public ArticleCRUD(){
        
    }
    
    public ArticleCRUD(String hostname){
        this.host = hostname;
    }
    
    public boolean insertar(Article art){
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO ARTICULO (ID_PROV,NRO_ART,DESCRIPCION_ART,ESPECIFICACIONES_ART,FABRICANTE_ART,"
                                                        + "UNIDADMEDIDA_ART,COSTOESTANDAR_ART,MAXIMO_ART,PUNTOREORDEN_ART,CANTIDADREORDEN_ART,"
                                                        + "MINIMO_ART,TIEMPOENTR_NRODIAS_ART,NOTAS_ART,CANTIDAD_ART,DESCCANTIDAD_ART)values (" +
                                                        art.getIdProv()+ ",'" +art.getNroArt()+"','"+art.getDescArt()+"','"+art.getEspecificacionesArt()+"','"+
                                                        art.getFabricante()+"','"+art.getUnidaMedida()+"',"+art.getCostoEstandar()+","+art.getMaximo()+","+
                                                        art.getPuntoReorden()+","+art.getCantidadReorden()+","+art.getMinimo()+","+art.getNroDias()+",'"+
                                                        art.getNotas()+"',"+art.getCantidad()+",'"+art.getDescripCantidad()+"')");
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
    
    public boolean actualizarStock(Article art){
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE ARTICULO set CANTIDAD_ART=CANTIDAD_ART-"+art.getCantidad()+
                                                        " WHERE ID_ART="+art.getIdArt());
            if(respuesta>0){
                 conexion.Desconectar();
                 return true;
             }else{
                 conexion.Desconectar();
                 return false;
             }
        }catch(Exception ex){
            System.err.println("Error en ACTUALIZAR STOCK registro: " + ex.getMessage());
            conexion.Desconectar();
            ex.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Article> visualizarSTOCK(){
        
        ArrayList<Article> listaArts = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        // ** CAMBIO EN EL QUERY DE VISUALIZAR PARA OBTENER LOS NUEVOS CAMPOS AÑADIDOS
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.ACTIVO,a.CANTIDAD_ART,a.DESCCANTIDAD_ART" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND a.CANTIDAD_ART>0");
            /*
            SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,
                    a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,
                    a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.ACTIVO
            FROM ARTICULO a JOIN PROVEEDOR p
            ON (a.ID_PROV = p.ID_PROV)
            WHERE a.ACTIVO <> 0
            */
            
            while (resultado.next()) {
                  Article art = new Article();
                  art.setIdArt(resultado.getInt("ID_ART"));
                  art.setIdProv(resultado.getInt("ID_PROV"));
                  art.setDescProv(resultado.getString("NOMBRE_PROV"));
                  art.setNroArt(resultado.getString("NRO_ART"));
                  art.setDescArt(resultado.getString("DESCRIPCION_ART"));
                  art.setEspecificacionesArt(resultado.getString("ESPECIFICACIONES_ART"));
                  art.setFabricante(resultado.getString("FABRICANTE_ART"));
                  art.setUnidaMedida(resultado.getString("UNIDADMEDIDA_ART"));
                  art.setCostoEstandar(resultado.getFloat("COSTOESTANDAR_ART"));
                  art.setMaximo(resultado.getFloat("MAXIMO_ART"));
                  art.setPuntoReorden(resultado.getFloat("PUNTOREORDEN_ART"));
                  art.setCantidadReorden(resultado.getFloat("CANTIDADREORDEN_ART"));
                  art.setMinimo(resultado.getFloat("MINIMO_ART"));
                  art.setNroDias(resultado.getInt("TIEMPOENTR_NRODIAS_ART"));
                  art.setNotas(resultado.getString("NOTAS_ART"));
                  art.setActivo(resultado.getInt("ACTIVO"));
                  art.setCantidad(resultado.getFloat("CANTIDAD_ART"));
                  art.setDescripCantidad(resultado.getString("DESCCANTIDAD_ART"));
                  listaArts.add(art);
            }
            
            return listaArts;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Article>();
        }
    }
    
    
    public boolean modificar(Article art, User usu){
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE ARTICULO set NRO_ART='" +art.getNroArt()+
                                                        "', ID_PROV='"+art.getIdProv()+
                                                        "', DESCRIPCION_ART='"+art.getDescArt()+
                                                        "', ESPECIFICACIONES_ART='"+art.getEspecificacionesArt()+
                                                        "', FABRICANTE_ART='"+art.getFabricante()+
                                                        "', UNIDADMEDIDA_ART='"+art.getUnidaMedida()+
                                                        "', COSTOESTANDAR_ART='"+art.getCostoEstandar()+
                                                        "', MAXIMO_ART='"+art.getMaximo()+
                                                        "', PUNTOREORDEN_ART='"+art.getPuntoReorden()+
                                                        "', CANTIDADREORDEN_ART='"+art.getCantidadReorden()+
                                                        "', MINIMO_ART='"+art.getMinimo()+
                                                        "', TIEMPOENTR_NRODIAS_ART='"+art.getNroDias()+
                                                        "', NOTAS_ART='"+art.getNotas()+
                                                        "', CANTIDAD_ART='"+art.getCantidad()+
                                                        "', DESCCANTIDAD_ART='"+art.getDescripCantidad()+
                                                        "' WHERE ID_ART="+art.getIdArt());
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("MATERIALES");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(art.getNroArt()+"-"+art.getDescArt());
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
        Article art = obtenerArticulo(codigo);
        try{
            respuesta=conexion.getStmt().executeUpdate("UPDATE ARTICULO set ACTIVO='" +0+
                                                        "' WHERE ID_ART="+codigo);
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if(respuesta>0){
                 conexion.Desconectar();
                  Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("MATERIALES");
                 a.setAccionRealizada("ELIMINACIÓN");
                 a.setDescripcion(art.getNroArt()+"-"+art.getDescArt());
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
    
    public ArrayList<Article> visualizar(){
        
        ArrayList<Article> listaArts = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        // ** CAMBIO EN EL QUERY DE VISUALIZAR PARA OBTENER LOS NUEVOS CAMPOS AÑADIDOS
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0");
            /*
            SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,
                    a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,
                    a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.ACTIVO
            FROM ARTICULO a JOIN PROVEEDOR p
            ON (a.ID_PROV = p.ID_PROV)
            WHERE a.ACTIVO <> 0
            */
            
            while (resultado.next()) {
                  Article art = new Article();
                  art.setIdArt(resultado.getInt("ID_ART"));
                  art.setIdProv(resultado.getInt("ID_PROV"));
                  art.setDescProv(resultado.getString("NOMBRE_PROV"));
                  art.setNroArt(resultado.getString("NRO_ART"));
                  art.setDescArt(resultado.getString("DESCRIPCION_ART"));
                  art.setEspecificacionesArt(resultado.getString("ESPECIFICACIONES_ART"));
                  art.setFabricante(resultado.getString("FABRICANTE_ART"));
                  art.setUnidaMedida(resultado.getString("UNIDADMEDIDA_ART"));
                  art.setCostoEstandar(resultado.getFloat("COSTOESTANDAR_ART"));
                  art.setMaximo(resultado.getFloat("MAXIMO_ART"));
                  art.setPuntoReorden(resultado.getFloat("PUNTOREORDEN_ART"));
                  art.setCantidadReorden(resultado.getFloat("CANTIDADREORDEN_ART"));
                  art.setMinimo(resultado.getFloat("MINIMO_ART"));
                  art.setNroDias(resultado.getInt("TIEMPOENTR_NRODIAS_ART"));
                  art.setNotas(resultado.getString("NOTAS_ART"));
                  art.setCantidad(resultado.getFloat("CANTIDAD_ART"));
                  art.setDescripCantidad(resultado.getString("DESCCANTIDAD_ART"));
                  art.setActivo(resultado.getInt("ACTIVO"));
                  listaArts.add(art);
            }
            
            return listaArts;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Article>();
        }
    }
    
    public ArrayList<Article> visualizar(int idArt){
        
        ArrayList<Article> listaArts = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND a.ID_ART = '" + idArt + "'");
            /*
            SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,
                    a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,
                    a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.ACTIVO
            FROM ARTICULO a JOIN PROVEEDOR p
            ON (a.ID_PROV = p.ID_PROV)
            WHERE a.ACTIVO <> 0
            */
            
            while (resultado.next()) {
                  Article art = new Article();
                  art.setIdArt(resultado.getInt("ID_ART"));
                  art.setIdProv(resultado.getInt("ID_PROV"));
                  art.setDescProv(resultado.getString("NOMBRE_PROV"));
                  art.setNroArt(resultado.getString("NRO_ART"));
                  art.setDescArt(resultado.getString("DESCRIPCION_ART"));
                  art.setEspecificacionesArt(resultado.getString("ESPECIFICACIONES_ART"));
                  art.setFabricante(resultado.getString("FABRICANTE_ART"));
                  art.setUnidaMedida(resultado.getString("UNIDADMEDIDA_ART"));
                  art.setCostoEstandar(resultado.getFloat("COSTOESTANDAR_ART"));
                  art.setMaximo(resultado.getFloat("MAXIMO_ART"));
                  art.setPuntoReorden(resultado.getFloat("PUNTOREORDEN_ART"));
                  art.setCantidadReorden(resultado.getFloat("CANTIDADREORDEN_ART"));
                  art.setMinimo(resultado.getFloat("MINIMO_ART"));
                  art.setNroDias(resultado.getInt("TIEMPOENTR_NRODIAS_ART"));
                  art.setNotas(resultado.getString("NOTAS_ART"));
                  art.setCantidad(resultado.getFloat("CANTIDAD_ART"));
                  art.setDescripCantidad(resultado.getString("DESCCANTIDAD_ART"));
                  art.setActivo(resultado.getInt("ACTIVO"));
                  listaArts.add(art);
            }
            
            
            return listaArts;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Article>();
        }
    }
   
    
    public Article obtenerArticulo(int idArt){
        
//        ArrayList<Article> listaArts = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND a.ID_ART = '" + idArt + "'");

            Article art = new Article();
            if (resultado.next()) {
                  
                  art.setIdArt(resultado.getInt("ID_ART"));
                  art.setIdProv(resultado.getInt("ID_PROV"));
                  art.setDescProv(resultado.getString("NOMBRE_PROV"));
                  art.setNroArt(resultado.getString("NRO_ART"));
                  art.setDescArt(resultado.getString("DESCRIPCION_ART"));
                  art.setEspecificacionesArt(resultado.getString("ESPECIFICACIONES_ART"));
                  art.setFabricante(resultado.getString("FABRICANTE_ART"));
                  art.setUnidaMedida(resultado.getString("UNIDADMEDIDA_ART"));
                  art.setCostoEstandar(resultado.getFloat("COSTOESTANDAR_ART"));
                  art.setMaximo(resultado.getFloat("MAXIMO_ART"));
                  art.setPuntoReorden(resultado.getFloat("PUNTOREORDEN_ART"));
                  art.setCantidadReorden(resultado.getFloat("CANTIDADREORDEN_ART"));
                  art.setMinimo(resultado.getFloat("MINIMO_ART"));
                  art.setNroDias(resultado.getInt("TIEMPOENTR_NRODIAS_ART"));
                  art.setNotas(resultado.getString("NOTAS_ART"));
                  art.setCantidad(resultado.getFloat("CANTIDAD_ART"));
                  art.setDescripCantidad(resultado.getString("DESCCANTIDAD_ART"));
                  art.setActivo(resultado.getInt("ACTIVO"));
//                  listaArts.add(art);
            }
            
            
            return art;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
    
    public ArrayList<Article> visualizar(String texto, int item){
        
        ArrayList<Article> listaArts = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        String Filtro=""+texto+"_%";
        try{
            conexion.getStmt();
            switch(item){
                case 0:
                    resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND a.NRO_ART like " +'"' + Filtro  +'"');
                    break;
                case 1:
                    resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND a.DESCRIPCION_ART like " +'"' + Filtro  +'"');
                    break;
                case 2:
                    resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND a.ESPECIFICACIONES_ART like " +'"' + Filtro  +'"');
                    break;
                case 3:
                    resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND a.FABRICANTE_ART like " +'"' + Filtro  +'"');
                    break;
                case 4:
                    resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND a.UNIDADMEDIDA_ART like " +'"' + Filtro  +'"');
                    break;
                case 5:
                    //float valor=Integer.parseInt(texto);
                    resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND (a.COSTOESTANDAR_ART LIKE '"+ Filtro +"' OR a.COSTOESTANDAR_ART = '"+ texto +"')");
                    break;                    
                case 6:
                    resultado = conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,"
                            + " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,"
                            + " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO"
                            + " FROM ARTICULO a JOIN PROVEEDOR p"
                            + " ON (a.ID_PROV = p.ID_PROV)"
                            + " WHERE a.ACTIVO <> 0 AND (a.MAXIMO_ART LIKE '"+ Filtro +"' OR a.MAXIMO_ART = '"+ texto +"')");
                    break;                    
                case 7:
                    resultado = conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,"
                            + " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,"
                            + " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO"
                            + " FROM ARTICULO a JOIN PROVEEDOR p"
                            + " ON (a.ID_PROV = p.ID_PROV)"
                            + " WHERE a.ACTIVO <> 0 AND (a.PUNTOREORDEN_ART LIKE '"+ Filtro +"' OR a.PUNTOREORDEN_ART = '"+ texto +"')");
                    break;                    
                case 8:
                    resultado = conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,"
                            + " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,"
                            + " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO"
                            + " FROM ARTICULO a JOIN PROVEEDOR p"
                            + " ON (a.ID_PROV = p.ID_PROV)"
                            + " WHERE a.ACTIVO <> 0 AND (a.CANTIDADREORDEN_ART LIKE '"+ Filtro +"' OR a.CANTIDADREORDEN_ART = '"+ texto +"')");
                    break;                    
                case 9:
                    resultado = conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,"
                            + " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,"
                            + " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO"
                            + " FROM ARTICULO a JOIN PROVEEDOR p"
                            + " ON (a.ID_PROV = p.ID_PROV)"
                            + " WHERE a.ACTIVO <> 0 AND (a.MINIMO_ART LIKE '"+ Filtro +"' OR a.MINIMO_ART = '"+ texto +"')");
                    break;                    
                case 10:
                    resultado = conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,"
                            + " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,"
                            + " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO"
                            + " FROM ARTICULO a JOIN PROVEEDOR p"
                            + " ON (a.ID_PROV = p.ID_PROV)"
                            + " WHERE a.ACTIVO <> 0 AND (a.TIEMPOENTR_NRODIAS_ART LIKE '"+ Filtro +"' OR a.TIEMPOENTR_NRODIAS_ART = '"+ texto +"')");
                    break;                    
                case 11:
                    resultado = conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,"
                            + " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,"
                            + " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO"
                            + " FROM ARTICULO a JOIN PROVEEDOR p"
                            + " ON (a.ID_PROV = p.ID_PROV)"
                            + " WHERE a.ACTIVO <> 0 AND a.NOTAS_ART like " + '"' + Filtro + '"');
                    break;                    
                case 12:
                    resultado = conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,"
                            + " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,"
                            + " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART,a.ACTIVO"
                            + " FROM ARTICULO a JOIN PROVEEDOR p"
                            + " ON (a.ID_PROV = p.ID_PROV)"
                            + " WHERE a.ACTIVO <> 0 AND (a.CANTIDAD_ART LIKE '"+ Filtro +"' OR a.CANTIDAD_ART = '"+ texto +"')");
                    break;                    
//                case 13:
//                    resultado = conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,"
//                            + " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,"
//                            + " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.ACTIVO"
//                            + " FROM ARTICULO a JOIN PROVEEDOR p"
//                            + " ON (a.ID_PROV = p.ID_PROV)"
//                            + " WHERE a.ACTIVO <> 0 AND a.DESCCANTIDAD_ART like " + '"' + Filtro + '"');
//                    break;                    
                default:
                    break;
            }
            
            /*
            SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART,
                    a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART,
                    a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.ACTIVO
            FROM ARTICULO a JOIN PROVEEDOR p
            ON (a.ID_PROV = p.ID_PROV)
            WHERE a.ACTIVO <> 0
            */
            
            while (resultado.next()) {
                  Article art = new Article();
                  art.setIdArt(resultado.getInt("ID_ART"));
                  art.setIdProv(resultado.getInt("ID_PROV"));
                  art.setDescProv(resultado.getString("NOMBRE_PROV"));
                  art.setNroArt(resultado.getString("NRO_ART"));
                  art.setDescArt(resultado.getString("DESCRIPCION_ART"));
                  art.setEspecificacionesArt(resultado.getString("ESPECIFICACIONES_ART"));
                  art.setFabricante(resultado.getString("FABRICANTE_ART"));
                  art.setUnidaMedida(resultado.getString("UNIDADMEDIDA_ART"));
                  art.setCostoEstandar(resultado.getFloat("COSTOESTANDAR_ART"));
                  art.setMaximo(resultado.getFloat("MAXIMO_ART"));
                  art.setPuntoReorden(resultado.getFloat("PUNTOREORDEN_ART"));
                  art.setCantidadReorden(resultado.getFloat("CANTIDADREORDEN_ART"));
                  art.setMinimo(resultado.getFloat("MINIMO_ART"));
                  art.setNroDias(resultado.getInt("TIEMPOENTR_NRODIAS_ART"));
                  art.setNotas(resultado.getString("NOTAS_ART"));
                  art.setCantidad(resultado.getFloat("CANTIDAD_ART"));
                  art.setDescripCantidad(resultado.getString("DESCCANTIDAD_ART"));
                  art.setActivo(resultado.getInt("ACTIVO"));
                  listaArts.add(art);
            }
            
            return listaArts;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Article>();
        }
    }
        
    public ResultSet cumplePuntoReorden(){
        
        //ArrayList<Article> listaArts = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();

            resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART, a.ACTIVO" +
                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
                                                        " ON (a.ID_PROV = p.ID_PROV)" +
                                                        " WHERE a.ACTIVO <> 0 AND a.CANTIDAD_ART <= a.PUNTOREORDEN_ART");
    
            int contador = 0;
            while (resultado.next()) {
                contador++;
            }
            resultado.first();
            resultado.beforeFirst();
            System.out.println(contador);
            if(contador==0){
                resultado = null;
            }
            
        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
        }
        return resultado;
    }    
    
    
    public ArrayList<Article> enviarDatosTabla(ResultSet resultado){
        
        ArrayList<Article> listaArts = new ArrayList<Article>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        try{
            while (resultado.next()) {
                  Article art = new Article();
                  art.setIdArt(resultado.getInt("ID_ART"));
                  art.setIdProv(resultado.getInt("ID_PROV"));
                  art.setDescProv(resultado.getString("NOMBRE_PROV"));
                  art.setNroArt(resultado.getString("NRO_ART"));
                  art.setDescArt(resultado.getString("DESCRIPCION_ART"));
                  art.setEspecificacionesArt(resultado.getString("ESPECIFICACIONES_ART"));
                  art.setFabricante(resultado.getString("FABRICANTE_ART"));
                  art.setUnidaMedida(resultado.getString("UNIDADMEDIDA_ART"));
                  art.setCostoEstandar(resultado.getFloat("COSTOESTANDAR_ART"));
                  art.setMaximo(resultado.getFloat("MAXIMO_ART"));
                  art.setPuntoReorden(resultado.getFloat("PUNTOREORDEN_ART"));
                  art.setCantidadReorden(resultado.getFloat("CANTIDADREORDEN_ART"));
                  art.setMinimo(resultado.getFloat("MINIMO_ART"));
                  art.setNroDias(resultado.getInt("TIEMPOENTR_NRODIAS_ART"));
                  art.setNotas(resultado.getString("NOTAS_ART"));
                  art.setActivo(resultado.getInt("ACTIVO"));
                  art.setCantidad(resultado.getFloat("CANTIDAD_ART"));
                  art.setDescripCantidad(resultado.getString("DESCCANTIDAD_ART"));
                  listaArts.add(art);
            }
            
            return listaArts;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Article>();
        }
    }
   
}
