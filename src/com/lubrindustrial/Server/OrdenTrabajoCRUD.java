/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

import com.lubrindustrial.View.OrdenTrabajo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonny
 */
public class OrdenTrabajoCRUD {
    
    String host;
    
    public OrdenTrabajoCRUD(){
        
    }
    
    public OrdenTrabajoCRUD(String hostname){
        this.host = hostname;
    }
    
    public boolean insertar(OrdenTrabajos ot){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        try {
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO ORDENTRABAJO (ID_MANT,NRO_ORDTR,DESCRIPCION_ORDTR, ESTADO_ORDTR, TIPO_ORDTR,"
                    + "PRIORIDAD_ORDTR, FECHAHORASOLICITUD_ORDTR, FECHAHORAREQUERIDA_ORDTR, RESPUESTA_ORDTR,INICIO_ORDTR,TERMINO_ORDTR,FECHAHORAENTREGA_ORDTR,DURACIONDIAS_ORDTR,ACEPTADOPOR_ORDTR,"
                    + "FALLA_ORDTR,DESCRIPCIONCAUSA_ORDTR,ACCIONREALIZADA_ORDTR,PREVENCIONTOMADA_ORDTR)values (" +ot.getIdMant()
                                                        + ",'" +ot.getNroOrdtr()+"','"+ot.getDescOrdtr()+"','"+ot.getEstOrdtr()+"','"+ot.getTipoOrdtr()+"','"+ot.getPriorOrdtr()
                                                        +"','"+ot.getFechHorSolicitudOrdtr()+"','"+ot.getFechHorReqOrdtr()+"','"+ot.getRespOrdtr()+"','"+ot.getInicioOrdtr()+"','"+ot.getTermOrdtr()
                                                        +"','"+ot.getFechHoraEntOrdtr()+"', "+ot.getDuracionDiasOrdtr()+",'"+ot.getAceptPorOrdtr()+"','"+ot.getFallaOrdtr()+"','"+ot.getDescCausaOrdtr()+"','"+ot.getAccionRealizOrdtr()+"',"
                                                                + "'"+ot.getPrevenTomadaOrdtr()+"');");
            if(respuesta>0){
                conexion.Desconectar();
                return true;
            }else{
                conexion.Desconectar();
                return false;
            }
        } catch (Exception ex) {
            conexion.Desconectar();
            System.out.println("El error es: "+ex.getMessage());
            return false;
        }
        
    }
    
    public boolean modificar(OrdenTrabajos otAn, OrdenTrabajos otDes, String fecha, User usu){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try{
//            ////SE INGRESA LO QUE ESTA AHORA EN ADITORIA (ANTES DE MODIFICAR)
//            respuesta=conexion.getStmt().executeUpdate("INSERT INTO `ordentrabajo2`(`ID_ORDTR2`, `ID_USU2`, `ID_MANT2`, "
//            + "`NRO_ORDTR2`, `DESCRIPCION_ORDTR2`, `ESTADO_ORDTR2`, `TIPO_ORDTR2`, `PRIORIDAD_ORDTR2`, "
//                    + "`FECHAHORASOLICITUD_ORDTR2`, `FECHAHORAREQUERIDA_ORDTR2`, `RESPUESTA_ORDTR2`, `INICIO_ORDTR2`, "
//                    + "`TERMINO_ORDTR2`, `FECHAHORAENTREGA_ORDTR2`, `DURACIONDIAS_ORDTR2`, `ACEPTADOPOR_ORDTR2`, "
//                    + "`FALLA_ORDTR2`, `DESCRIPCIONCAUSA_ORDTR2`, `ACCIONREALIZADA_ORDTR2`, `PREVENCIONTOMADA_ORDTR2`, "
//                    + "`HORACAMBIO_ORDTR2`) VALUES ("+otAn.getIdOrdtr()+",1,"+otAn.getIdMant()+",'"+otAn.getNroOrdtr()+"','"
//                    + otAn.getDescOrdtr()+"','"+otAn.getEstOrdtr()+"','"+otAn.getTipoOrdtr()+"','"+otAn.getPriorOrdtr()+"'"
//                    + ",'"+otAn.getFechHorSolicitudOrdtr()+"','"+otAn.getFechHorReqOrdtr()+"','"+otAn.getRespOrdtr()+"'"
//                    + ",'"+otAn.getInicioOrdtr()+"','"+otAn.getTermOrdtr()+"','"+otAn.getFechHoraEntOrdtr()+"'"
//                    + ","+otAn.getDuracionDiasOrdtr()+",'"+otAn.getAceptPorOrdtr()+"','"+otAn.getFallaOrdtr()+"'"
//                    + ",'"+otAn.getDescCausaOrdtr()+"','"+otAn.getAccionRealizOrdtr()+"', '"+otAn.getPrevenTomadaOrdtr()+"'"
//                    + ",'"+fecha+"')");
            ////MODIFICAMOS REGISTRO

            respuesta=conexion.getStmt().executeUpdate("UPDATE `ordentrabajo` SET `ID_MANT`="+otDes.getIdMant()+","
                    + "`NRO_ORDTR`='"+otDes.getNroOrdtr()+"',`DESCRIPCION_ORDTR`='"+otDes.getDescOrdtr()+"',"
                    + "`ESTADO_ORDTR`='"+otDes.getEstOrdtr()+"',`TIPO_ORDTR`='"+otDes.getTipoOrdtr()+"',"
                    + "`PRIORIDAD_ORDTR`='"+otDes.getPriorOrdtr()+"',`FECHAHORASOLICITUD_ORDTR`='"+otDes.getFechHorSolicitudOrdtr()+"',"
                    + "`FECHAHORAREQUERIDA_ORDTR`='"+otDes.getFechHorReqOrdtr()+"',"
                    + "`RESPUESTA_ORDTR`='"+otDes.getRespOrdtr()+"',`INICIO_ORDTR`='"+otDes.getInicioOrdtr()+"',"
                    + "`TERMINO_ORDTR`='"+otDes.getTermOrdtr()+"',"
                    + "`FECHAHORAENTREGA_ORDTR`='"+otDes.getFechHoraEntOrdtr()+"',`DURACIONDIAS_ORDTR`="+otDes.getDuracionDiasOrdtr()+","
                    + "`ACEPTADOPOR_ORDTR`='"+otDes.getAceptPorOrdtr()+"',"
                    + "`FALLA_ORDTR`='"+otDes.getFallaOrdtr()+"',`DESCRIPCIONCAUSA_ORDTR`='"+otDes.getDescCausaOrdtr()+"',"
                    + "`ACCIONREALIZADA_ORDTR`='"+otDes.getAccionRealizOrdtr()+"',"
                    + "`PREVENCIONTOMADA_ORDTR`='"+otDes.getPrevenTomadaOrdtr()+"' WHERE ID_ORDTR="+otDes.getIdOrdtr());
            ////INGRESAMO AUDITORIA DESPUES DE REALIZAR EL UPDATE
//            respuesta=conexion.getStmt().executeUpdate("INSERT INTO `ordentrabajo2`(`ID_ORDTR2`, `ID_USU2`, `ID_MANT2`, "
//            + "`NRO_ORDTR2`, `DESCRIPCION_ORDTR2`, `ESTADO_ORDTR2`, `TIPO_ORDTR2`, `PRIORIDAD_ORDTR2`, "
//                    + "`FECHAHORASOLICITUD_ORDTR2`, `FECHAHORAREQUERIDA_ORDTR2`, `RESPUESTA_ORDTR2`, `INICIO_ORDTR2`, "
//                    + "`TERMINO_ORDTR2`, `FECHAHORAENTREGA_ORDTR2`, `DURACIONDIAS_ORDTR2`, `ACEPTADOPOR_ORDTR2`, "
//                    + "`FALLA_ORDTR2`, `DESCRIPCIONCAUSA_ORDTR2`, `ACCIONREALIZADA_ORDTR2`, `PREVENCIONTOMADA_ORDTR2`, "
//                    + "`HORACAMBIO_ORDTR2`) VALUES ("+otDes.getIdOrdtr()+",1,"+otDes.getIdMant()+",'"+otDes.getNroOrdtr()+"','"
//                    + otDes.getDescOrdtr()+"','"+otDes.getEstOrdtr()+"','"+otDes.getTipoOrdtr()+"','"+otDes.getPriorOrdtr()+"'"
//                    + ",'"+otDes.getFechHorSolicitudOrdtr()+"','"+otDes.getFechHorReqOrdtr()+"','"+otDes.getRespOrdtr()+"'"
//                    + ",'"+otDes.getInicioOrdtr()+"','"+otDes.getTermOrdtr()+"','"+otDes.getFechHoraEntOrdtr()+"'"
//                    + ","+otDes.getDuracionDiasOrdtr()+",'"+otDes.getAceptPorOrdtr()+"','"+otDes.getFallaOrdtr()+"'"
//                    + ",'"+otDes.getDescCausaOrdtr()+"','"+otDes.getAccionRealizOrdtr()+"', '"+otDes.getPrevenTomadaOrdtr()+"'"
//                    + ",'"+fecha+"')");
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("ORDEN DE TRABAJO");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(otAn.getNroOrdtr()+"-"+otAn.getDescOrdtr()+"-"+otDes.getNroOrdtr()+"-"+otDes.getDescOrdtr());
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
    
    public boolean eliminar(OrdenTrabajos ot, String fecha, User usu){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try{
//            //GUARDO EN LA TABLA AUDITORIA
//            respuesta=conexion.getStmt().executeUpdate("INSERT INTO `ordentrabajo2`(`ID_ORDTR2`, `ID_USU2`, "
//                    + "`ID_MANT2`, `NRO_ORDTR2`, `DESCRIPCION_ORDTR2`, `ESTADO_ORDTR2`, `TIPO_ORDTR2`, "
//                    + "`PRIORIDAD_ORDTR2`, `FECHAHORASOLICITUD_ORDTR2`, `FECHAHORAREQUERIDA_ORDTR2`, "
//                    + "`RESPUESTA_ORDTR2`, `INICIO_ORDTR2`, `TERMINO_ORDTR2`, `FECHAHORAENTREGA_ORDTR2`, "
//                    + "`DURACIONDIAS_ORDTR2`, `ACEPTADOPOR_ORDTR2`, `FALLA_ORDTR2`, `DESCRIPCIONCAUSA_ORDTR2`, "
//                    + "`ACCIONREALIZADA_ORDTR2`, `PREVENCIONTOMADA_ORDTR2`, "
//                    + "`HORACAMBIO_ORDTR2`) VALUES ("+ot.getIdOrdtr()+", 1, "+ot.getIdMant()+",'"+ot.getNroOrdtr()+"'"
//                    + ",'"+ot.getDescOrdtr()+"','"+ot.getEstOrdtr()+"','"+ot.getTipoOrdtr()+"','"+ot.getPriorOrdtr()+"'"
//                    + ",'"+ot.getFechHorSolicitudOrdtr()+"','"+ot.getFechHorReqOrdtr()+"','"+ot.getRespOrdtr()+"'"
//                    + ",'"+ot.getInicioOrdtr()+"','"+ot.getTermOrdtr()+"','"+ot.getFechHoraEntOrdtr()+"'"
//                    + ","+ot.getDuracionDiasOrdtr()+",'"+ot.getAceptPorOrdtr()+"','"+ot.getFallaOrdtr()+"'"
//                    + ",'"+ot.getDescCausaOrdtr()+"','"+ot.getAccionRealizOrdtr()+"','"+ot.getPrevenTomadaOrdtr()+"'"
//                    + ",'"+fecha+"')");
//            ///
            respuesta=conexion.getStmt().executeUpdate("UPDATE ORDENTRABAJO set ACTIVO=0 WHERE ID_ORDTR="+ot.getIdOrdtr());
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("ORDEN DE TRABAJO");
                 a.setAccionRealizada("ELIMINACIÓN");
                 a.setDescripcion(ot.getNroOrdtr()+"-"+ot.getDescOrdtr());
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
    
    public ArrayList<OrdenTrabajos> visualizar(){
        ArrayList<OrdenTrabajos> listaOrdenes = new ArrayList<OrdenTrabajos>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0");
            
            while (resultado.next()) {
                  OrdenTrabajos ot = new OrdenTrabajos();
                  ot.setIdOrdtr(resultado.getInt("ID_ORDTR"));
                  ot.setIdMant(resultado.getInt("ID_MANT"));
                  ot.setNroOrdtr(resultado.getString("NRO_ORDTR"));
                  ot.setDescOrdtr(resultado.getString("DESCRIPCION_ORDTR"));
                  ot.setEstOrdtr(resultado.getString("ESTADO_ORDTR"));
                  ot.setTipoOrdtr(resultado.getString("TIPO_ORDTR"));
                  ot.setPriorOrdtr(resultado.getString("PRIORIDAD_ORDTR"));
                  ot.setFechHorSolicitudOrdtr(resultado.getString("FECHAHORASOLICITUD_ORDTR"));
                  ot.setFechHorReqOrdtr(resultado.getString("FECHAHORAREQUERIDA_ORDTR"));
                  ot.setRespOrdtr(resultado.getString("RESPUESTA_ORDTR"));
                  ot.setInicioOrdtr(resultado.getString("INICIO_ORDTR"));
                  ot.setTermOrdtr(resultado.getString("TERMINO_ORDTR"));
                  ot.setFechHoraEntOrdtr(resultado.getString("FECHAHORAENTREGA_ORDTR"));
                  ot.setDuracionDiasOrdtr(resultado.getFloat("DURACIONDIAS_ORDTR"));
                  ot.setAceptPorOrdtr(resultado.getString("ACEPTADOPOR_ORDTR"));
                  ot.setFallaOrdtr(resultado.getString("FALLA_ORDTR"));
                  ot.setDescCausaOrdtr(resultado.getString("DESCRIPCIONCAUSA_ORDTR"));
                  ot.setAccionRealizOrdtr(resultado.getString("ACCIONREALIZADA_ORDTR"));
                  ot.setPrevenTomadaOrdtr(resultado.getString("PREVENCIONTOMADA_ORDTR"));
                  listaOrdenes.add(ot);
            }
            
            return listaOrdenes;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros Ordenes de Trabajo: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<OrdenTrabajos>();
        }
    }
    public OrdenTrabajos mostrarPorCodigo(int codigo)
    {
        ArrayList<Integer> listaOrden = new ArrayList<Integer>();
        OrdenTrabajos ot = new OrdenTrabajos();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND ID_ORDTR="+codigo);
            /*SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO
              FROM DEPARTAMENTO d JOIN LOCACION l
              ON (d.ID_DEPT = l.ID_DEPT)*/
            
            while (resultado.next()) {
                  
                  ot.setIdOrdtr(resultado.getInt("ID_ORDTR"));
                  ot.setIdMant(resultado.getInt("ID_MANT"));
                  ot.setNroOrdtr(resultado.getString("NRO_ORDTR"));
                  ot.setDescOrdtr(resultado.getString("DESCRIPCION_ORDTR"));
                  ot.setEstOrdtr(resultado.getString("ESTADO_ORDTR"));
                  ot.setTipoOrdtr(resultado.getString("TIPO_ORDTR"));
                  ot.setPriorOrdtr(resultado.getString("PRIORIDAD_ORDTR"));
                  ot.setFechHorSolicitudOrdtr(resultado.getString("FECHAHORASOLICITUD_ORDTR"));
                  ot.setFechHorReqOrdtr(resultado.getString("FECHAHORAREQUERIDA_ORDTR"));
                  ot.setRespOrdtr(resultado.getString("RESPUESTA_ORDTR"));
                  ot.setInicioOrdtr(resultado.getString("INICIO_ORDTR"));
                  ot.setTermOrdtr(resultado.getString("TERMINO_ORDTR"));
                  ot.setFechHoraEntOrdtr(resultado.getString("FECHAHORAENTREGA_ORDTR"));
                  ot.setDuracionDiasOrdtr(resultado.getFloat("DURACIONDIAS_ORDTR"));
                  ot.setAceptPorOrdtr(resultado.getString("ACEPTADOPOR_ORDTR"));
                  ot.setFallaOrdtr(resultado.getString("FALLA_ORDTR"));
                  ot.setDescCausaOrdtr(resultado.getString("DESCRIPCIONCAUSA_ORDTR"));
                  ot.setAccionRealizOrdtr(resultado.getString("ACCIONREALIZADA_ORDTR"));
                  ot.setPrevenTomadaOrdtr(resultado.getString("PREVENCIONTOMADA_ORDTR"));
                  
            }
            
            return ot;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros Ordenes Trabajo: " + ex.getMessage());
            ex.printStackTrace();
            return new OrdenTrabajos();
        }
    }
    
    public ArrayList<Employee> llenarComboEmpOrden()
    {
        ArrayList<Employee> listEmp=new ArrayList<Employee>();

        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try
        {
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("select e.ID_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP from empleado e inner join "
                    + "emp_mant em on e.ID_EMP=em.ID_EMP INNER JOIN mantenimiento m on em.ID_MANT=m.ID_MANT INNER JOIN ordentrabajo ot "
                    + "on m.ID_MANT=ot.ID_MANT where m.ACTIVO <> 0 GROUP BY E.ID_EMP");
            
            while (resultado.next()) {
                        Employee emp = new Employee();
                        emp.setIdEmployee(resultado.getInt("ID_EMP"));
                        emp.setNomEmployee(resultado.getString("NOMBRE_EMP"));
                        emp.setApeEmployee(resultado.getString("APELLIDO_EMP"));
                        listEmp.add(emp);
            }        
            return listEmp;
            
        }catch (SQLException ex){
            System.err.println("Error en devolver registros Orden Trabajo: " + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Employee>();
        }
    }
    
    public ArrayList<OrdenTrabajos> ordenPorEmpleado(int idEmp)
    {
        ArrayList<OrdenTrabajos> listOrden=new ArrayList<OrdenTrabajos>();

        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try
        {
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("select ot.ID_ORDTR, ot.ID_MANT, ot.NRO_ORDTR,ot.DESCRIPCION_ORDTR, "
                    + "ot.ESTADO_ORDTR, ot.TIPO_ORDTR, ot.PRIORIDAD_ORDTR, ot.FECHAHORASOLICITUD_ORDTR , ot.FECHAHORAREQUERIDA_ORDTR, "
                    + "ot.RESPUESTA_ORDTR, ot.INICIO_ORDTR, ot.TERMINO_ORDTR, ot.FECHAHORAENTREGA_ORDTR, ot.DURACIONDIAS_ORDTR , "
                    + "ot.ACEPTADOPOR_ORDTR, ot.FALLA_ORDTR, ot.DESCRIPCIONCAUSA_ORDTR, ot.ACCIONREALIZADA_ORDTR, ot.PREVENCIONTOMADA_ORDTR from empleado e inner join emp_mant em on "
                    + "e.ID_EMP=em.ID_EMP INNER JOIN mantenimiento m on em.ID_MANT=m.ID_MANT INNER JOIN ordentrabajo ot where ot.ACTIVO <> 0 "
                    + "and e.ID_EMP="+idEmp+" GROUP BY ot.ID_ORDTR");
            
            while (resultado.next()) {
                OrdenTrabajos ot=new OrdenTrabajos();
                        ot.setIdOrdtr(resultado.getInt("ID_ORDTR"));
                  ot.setIdMant(resultado.getInt("ID_MANT"));
                  ot.setNroOrdtr(resultado.getString("NRO_ORDTR"));
                  ot.setDescOrdtr(resultado.getString("DESCRIPCION_ORDTR"));
                  ot.setEstOrdtr(resultado.getString("ESTADO_ORDTR"));
                  ot.setTipoOrdtr(resultado.getString("TIPO_ORDTR"));
                  ot.setPriorOrdtr(resultado.getString("PRIORIDAD_ORDTR"));
                  ot.setFechHorSolicitudOrdtr(resultado.getString("FECHAHORASOLICITUD_ORDTR"));
                  ot.setFechHorReqOrdtr(resultado.getString("FECHAHORAREQUERIDA_ORDTR"));
                  ot.setRespOrdtr(resultado.getString("RESPUESTA_ORDTR"));
                  ot.setInicioOrdtr(resultado.getString("INICIO_ORDTR"));
                  ot.setTermOrdtr(resultado.getString("TERMINO_ORDTR"));
                  ot.setFechHoraEntOrdtr(resultado.getString("FECHAHORAENTREGA_ORDTR"));
                  ot.setDuracionDiasOrdtr(resultado.getFloat("DURACIONDIAS_ORDTR"));
                  ot.setAceptPorOrdtr(resultado.getString("ACEPTADOPOR_ORDTR"));
                  ot.setFallaOrdtr(resultado.getString("FALLA_ORDTR"));
                  ot.setDescCausaOrdtr(resultado.getString("DESCRIPCIONCAUSA_ORDTR"));
                  ot.setAccionRealizOrdtr(resultado.getString("ACCIONREALIZADA_ORDTR"));
                  ot.setPrevenTomadaOrdtr(resultado.getString("PREVENCIONTOMADA_ORDTR"));
                        listOrden.add(ot);
            }        
            return listOrden;
            
        }catch (SQLException ex){
            System.err.println("Error en devolver registros Orden Trabajos: " + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<OrdenTrabajos>();
        }
    }
    public ArrayList<String> colabPorOrden(ArrayList<OrdenTrabajos> idOrden)
    {
        ArrayList<String> listaColab=new ArrayList<String>();
        String colaboradores="";

        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try
        {
            for(int i=0; i<idOrden.size();i++)
            {
               colaboradores="";
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("select e.nombre_emp, e.apellido_emp from empleado e INNER JOIN "
                    + "emp_mant em on e.ID_EMP=em.ID_EMP INNER JOIN mantenimiento m on em.ID_MANT=m.ID_MANT INNER JOIN "
                    + "ordentrabajo ot on m.ID_MANT=ot.ID_MANT where ot.ID_ORDTR="+idOrden.get(i).getIdOrdtr());
            
            while (resultado.next()) {

                        String nombre=resultado.getString("NOMBRE_EMP");
                        String apellido=resultado.getString("APELLIDO_EMP");
                        colaboradores+=nombre+" "+apellido+";";
                        
                        
                }     
//            JOptionPane.showMessageDialog(null, colaboradores+" "+idOrden.get(i).getIdOrdtr());
            listaColab.add(colaboradores);
            }
            return listaColab;
            
        }catch (SQLException ex){
            System.err.println("Error en devolver registros Orden Trabajos: " + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<String>();
        }
    }
    
        public ResultSet cumplePuntoReorden(){
        
        //ArrayList<Article> listaArts = new ArrayList<Article>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();

//            resultado= conexion.getStmt().executeQuery("SELECT a.ID_ART,a.ID_PROV,p.NOMBRE_PROV,a.NRO_ART,a.DESCRIPCION_ART,a.ESPECIFICACIONES_ART,a.FABRICANTE_ART," +
//                                                        " a.UNIDADMEDIDA_ART,a.COSTOESTANDAR_ART,a.MAXIMO_ART,a.PUNTOREORDEN_ART,a.CANTIDADREORDEN_ART," +
//                                                        " a.MINIMO_ART,a.TIEMPOENTR_NRODIAS_ART,a.NOTAS_ART,a.CANTIDAD_ART,a.DESCCANTIDAD_ART, a.ACTIVO" +
//                                                        " FROM ARTICULO a JOIN PROVEEDOR p" +
//                                                        " ON (a.ID_PROV = p.ID_PROV)" +
//                                                        " WHERE a.ACTIVO <> 0 AND a.CANTIDAD_ART <= a.PUNTOREORDEN_ART");
//    
            resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND (FECHAHORAREQUERIDA_ORDTR - NOW())>=7");
            
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
    
    
    public ArrayList<OrdenTrabajos> enviarDatosTabla(ResultSet resultado){
        
        ArrayList<OrdenTrabajos> listaOrden = new ArrayList<OrdenTrabajos>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        try{
            
            while (resultado.next()) {
                OrdenTrabajos ot=new OrdenTrabajos();
                        ot.setIdOrdtr(resultado.getInt("ID_ORDTR"));
                  ot.setIdMant(resultado.getInt("ID_MANT"));
                  ot.setNroOrdtr(resultado.getString("NRO_ORDTR"));
                  ot.setDescOrdtr(resultado.getString("DESCRIPCION_ORDTR"));
                  ot.setEstOrdtr(resultado.getString("ESTADO_ORDTR"));
                  ot.setTipoOrdtr(resultado.getString("TIPO_ORDTR"));
                  ot.setPriorOrdtr(resultado.getString("PRIORIDAD_ORDTR"));
                  ot.setFechHorSolicitudOrdtr(resultado.getString("FECHAHORASOLICITUD_ORDTR"));
                  ot.setFechHorReqOrdtr(resultado.getString("FECHAHORAREQUERIDA_ORDTR"));
                  ot.setRespOrdtr(resultado.getString("RESPUESTA_ORDTR"));
                  ot.setInicioOrdtr(resultado.getString("INICIO_ORDTR"));
                  ot.setTermOrdtr(resultado.getString("TERMINO_ORDTR"));
                  ot.setFechHoraEntOrdtr(resultado.getString("FECHAHORAENTREGA_ORDTR"));
                  ot.setDuracionDiasOrdtr(resultado.getFloat("DURACIONDIAS_ORDTR"));
                  ot.setAceptPorOrdtr(resultado.getString("ACEPTADOPOR_ORDTR"));
                  ot.setFallaOrdtr(resultado.getString("FALLA_ORDTR"));
                  ot.setDescCausaOrdtr(resultado.getString("DESCRIPCIONCAUSA_ORDTR"));
                  ot.setAccionRealizOrdtr(resultado.getString("ACCIONREALIZADA_ORDTR"));
                  ot.setPrevenTomadaOrdtr(resultado.getString("PREVENCIONTOMADA_ORDTR"));
                        listaOrden.add(ot);
            }  
            
            return listaOrden;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<OrdenTrabajos>();
        }
    }
    
    public ArrayList<OrdenTrabajos> visualizar(String texto, int item){
        
        ArrayList<OrdenTrabajos> listaOT = new ArrayList<OrdenTrabajos>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        String Filtro=""+texto+"_%";
        try{
            conexion.getStmt();
            switch(item){
                case 0:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND NRO_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 1:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND DESCRIPCION_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 2:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND ESTADO_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 3:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND TIPO_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 4:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND PRIORIDAD_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 5:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND RESPUESTA_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 6:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND INICIO_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 7:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND TERMINO_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 8:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND (DURACIONDIAS_ORDTR LIKE '"+ Filtro +"' OR DURACIONDIAS_ORDTR = '"+ texto +"')");
                    break;
                case 9:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND ACEPTADOPOR_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 10:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND FALLA_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 11:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND DESCRIPCIONCAUSA_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 12:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND ACCIONREALIZADA_ORDTR like " +'"' + Filtro  +'"');
                    break;
                case 13:
                    resultado= conexion.getStmt().executeQuery("SELECT * FROM ORDENTRABAJO WHERE ACTIVO <> 0 AND PREVENCIONTOMADA_ORDTR like " +'"' + Filtro  +'"');
                    break;
                default:
                    break;
            }
            

           while (resultado.next()) {
                  OrdenTrabajos ot = new OrdenTrabajos();
                  ot.setIdOrdtr(resultado.getInt("ID_ORDTR"));
                  ot.setIdMant(resultado.getInt("ID_MANT"));
                  ot.setNroOrdtr(resultado.getString("NRO_ORDTR"));
                  ot.setDescOrdtr(resultado.getString("DESCRIPCION_ORDTR"));
                  ot.setEstOrdtr(resultado.getString("ESTADO_ORDTR"));
                  ot.setTipoOrdtr(resultado.getString("TIPO_ORDTR"));
                  ot.setPriorOrdtr(resultado.getString("PRIORIDAD_ORDTR"));
                  ot.setFechHorSolicitudOrdtr(resultado.getString("FECHAHORASOLICITUD_ORDTR"));
                  ot.setFechHorReqOrdtr(resultado.getString("FECHAHORAREQUERIDA_ORDTR"));
                  ot.setRespOrdtr(resultado.getString("RESPUESTA_ORDTR"));
                  ot.setInicioOrdtr(resultado.getString("INICIO_ORDTR"));
                  ot.setTermOrdtr(resultado.getString("TERMINO_ORDTR"));
                  ot.setFechHoraEntOrdtr(resultado.getString("FECHAHORAENTREGA_ORDTR"));
                  ot.setDuracionDiasOrdtr(resultado.getFloat("DURACIONDIAS_ORDTR"));
                  ot.setAceptPorOrdtr(resultado.getString("ACEPTADOPOR_ORDTR"));
                  ot.setFallaOrdtr(resultado.getString("FALLA_ORDTR"));
                  ot.setDescCausaOrdtr(resultado.getString("DESCRIPCIONCAUSA_ORDTR"));
                  ot.setAccionRealizOrdtr(resultado.getString("ACCIONREALIZADA_ORDTR"));
                  ot.setPrevenTomadaOrdtr(resultado.getString("PREVENCIONTOMADA_ORDTR"));
                  listaOT.add(ot);
            }
            
            return listaOT;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<OrdenTrabajos>();
        }
    }
       
   

}
