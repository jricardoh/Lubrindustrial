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
public class PEDIDOMATERIALCRUD {
    
    public String host;

    public PEDIDOMATERIALCRUD() {
    }

    public PEDIDOMATERIALCRUD(String hostname) {
        this.host = hostname;
    }
    
    
    
    public boolean insertar(PEDIDOMATERIAL ped) {
        ArticleCRUD artC = new ArticleCRUD();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        int respuesta = 0;
        boolean flag=false;
        try {
            respuesta = conexion.getStmt().executeUpdate("INSERT INTO PEDIDOMATERIALES (ID_ART,ID_EMP_PEDIDO,ID_EMP_ENTREGADO,ID_EMP_AUTORIZADO,ID_EMP_APROBADO,CANTIDAD_PED,UNIDAD_PED,DESCRIPCION_PED,FECHAHORASOL_PED,FECHAHORAENTR_PED)values ("
                    + ped.getIdArt() + "," + ped.getIdEmpPedido() + "," + ped.getIdEmpEntregado() + "," + ped.getIdEmpAutorizado() + "," + ped.getIdEmpAprobado() + "," + ped.getCantidad() + ",'" + ped.getUnidadCantidad() + "','" + ped.getDescripcion() + "','" + ped.getFechaHoraSolicitud() + "','" + ped.getFechaHoraEntrega() + "')");
            Article art = new Article();
            art.setIdArt(ped.getIdArt());
            art.setCantidad(ped.getCantidad());
            
            flag=artC.actualizarStock(art);
            
            if (respuesta > 0 && flag) {
                conexion.Desconectar();
                return true;
            } else {
                conexion.Desconectar();
                return false;
            }
        } catch (Exception ex) {
            conexion.Desconectar();
            System.out.println("" + ex.getMessage());
            return false;
        }

    }
    
    public ArrayList<PEDIDOMATERIAL> visualizar() {
        ArrayList<PEDIDOMATERIAL> listaPedidos = new ArrayList<PEDIDOMATERIAL>();
        Conexion conexion = new Conexion();
        conexion.setHost(host);
        
        conexion.Conectar();
        ResultSet resultado = null;
        try {
            conexion.getStmt();
            resultado = conexion.getStmt().executeQuery("SELECT p.ID_PED,a.ID_ART,a.NRO_ART,a.DESCRIPCION_ART,p.ID_EMP_PEDIDO AS id1,e1.NRO_EMP AS nro1,e1.NOMBRE_EMP AS nomb1,e1.APELLIDO_EMP AS ap1,p.ID_EMP_ENTREGADO AS id2,e2.NRO_EMP AS nro2,e2.NOMBRE_EMP AS nomb2,e2.APELLIDO_EMP AS ap2," +
                                                        " p.ID_EMP_AUTORIZADO AS id3,e3.NRO_EMP AS nro3,e3.NOMBRE_EMP AS nomb3,e3.APELLIDO_EMP AS ap3,p.ID_EMP_APROBADO AS id4,e4.NRO_EMP AS nro4,e4.NOMBRE_EMP as nomb4,e4.APELLIDO_EMP AS ap4,p.CANTIDAD_PED,p.UNIDAD_PED," +
                                                        " p.DESCRIPCION_PED,p.FECHAHORASOL_PED,p.FECHAHORAENTR_PED,p.ACTIVO" +
                                                        " FROM PEDIDOMATERIALES p JOIN articulo a JOIN empleado e1 JOIN empleado e2 JOIN empleado e3 JOIN empleado e4" +
                                                        " ON (p.ID_ART=a.ID_ART and p.ID_EMP_PEDIDO=e1.ID_EMP and p.ID_EMP_ENTREGADO=e2.ID_EMP and p.ID_EMP_AUTORIZADO=e3.ID_EMP and p.ID_EMP_APROBADO=e4.ID_EMP)" +
                                                        " WHERE p.ACTIVO <> 0");
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM EMPLEADO WHERE ACTIVO <> 0");
            /*SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,
              e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,
              e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO
              FROM PEDIDOMATERIALES p PEDIDEMPLEADO e JOIN ARTICULO a
              ON (a.ID_ART = p.ID_ART)
              WHERE ACTIVO <> 0*/

            while (resultado.next()) {
                PEDIDOMATERIAL ped = new PEDIDOMATERIAL();
                //emp.setIdDepartment(resultado.getInt("ID_DEPT"));
                ped.setIdPedido(resultado.getInt("ID_PED"));
                ped.setIdArt(resultado.getInt("ID_ART"));
                ped.setDescArt(resultado.getString("NRO_ART")+" "+resultado.getString("DESCRIPCION_ART"));
                ped.setIdEmpPedido(resultado.getInt("id1"));
                ped.setDescEmpPedido(resultado.getString("nro1")+" "+resultado.getString("nomb1")+" "+resultado.getString("ap1"));
                ped.setIdEmpEntregado(resultado.getInt("id2"));
                ped.setDescEmpEntregado(resultado.getString("nro2")+" "+resultado.getString("nomb2")+" "+resultado.getString("ap2"));
                ped.setIdEmpAutorizado(resultado.getInt("id3"));
                ped.setDescEmpAutorizado(resultado.getString("nro3")+" "+resultado.getString("nomb3")+" "+resultado.getString("ap3"));
                ped.setIdEmpAprobado(resultado.getInt("id4"));
                ped.setDescEmpAprobado(resultado.getString("nro4")+" "+resultado.getString("nomb4")+" "+resultado.getString("ap4"));
                ped.setCantidad(resultado.getFloat("CANTIDAD_PED"));
                ped.setUnidadCantidad(resultado.getString("UNIDAD_PED"));
                ped.setDescripcion(resultado.getString("DESCRIPCION_PED"));
                ped.setFechaHoraSolicitud(resultado.getString("FECHAHORASOL_PED"));
                ped.setFechaHoraEntrega(resultado.getString("FECHAHORAENTR_PED"));
                ped.setActivo(resultado.getInt("ACTIVO"));
                listaPedidos.add(ped);
            }

            conexion.Desconectar();
            return listaPedidos;

        } catch (SQLException ex) {
            conexion.Desconectar();
            System.err.println("Error en devolver registros PEDIDO DE MATERIALES: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<PEDIDOMATERIAL>();
        }
    }
}
