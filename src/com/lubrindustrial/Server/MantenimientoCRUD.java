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
public class MantenimientoCRUD {
    
    String host;
    
    public MantenimientoCRUD(){
        
    }
    
    public MantenimientoCRUD(String hostname){
        this.host = hostname;
    }
    
    public boolean insertar(Mantenimientos man, ArrayList<Integer> idEmp, ArrayList<Integer> idInst){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        int respuesta2=0;
        
        try {
            if(man.getIdEquipo()!=0){

            respuesta=conexion.getStmt().executeUpdate("INSERT INTO MANTENIMIENTO(ID_EQ,ID_LOCT,NROTAREA_MANT, DESCRIPCION_MANT, OFICIO_MANT, FRECUENCIA_MANT, DIAS_MANT, DURACIONTAREA_MANT, FECHAINICIO_MANT,"
                    + "FECHAPROGRAMADAINICIO_MANT, FECHAPROGRAMADATERMINO_MANT, "
                    + "PROXIMAFECHA_MANT,HORASPROGRAMADAS_MANT,ACTIVO) values ("+man.getIdEquipo()+",null,'"+man.getNroTareaMant()+"','"
                            +man.getDescMantenimiento()+"','"+man.getOficioMantenimiento()+"', '"+man.getFrecuenciaMant()+"',"+man.getDiasMant()+","+man.getDurTareaMant()+",'"+man.getFechIniMantenimiento()+"', '"
                            +man.getFechProgInicMant()+"', '"+man.getFechProgTermMant()+"', '"+man.getFechProximaMant()+"',"+man.getHorasProgramadas()+", 1);");
            }
            else
            {
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO MANTENIMIENTO(ID_EQ,ID_LOCT,NROTAREA_MANT, DESCRIPCION_MANT, OFICIO_MANT, FRECUENCIA_MANT, DIAS_MANT, DURACIONTAREA_MANT, FECHAINICIO_MANT,"
                    + "FECHAPROGRAMADAINICIO_MANT, FECHAPROGRAMADATERMINO_MANT, "
                    + "PROXIMAFECHA_MANT,HORASPROGRAMADAS_MANT,ACTIVO) values (null,"+man.getIdLocacion()+",'"+man.getNroTareaMant()+"','"
                            +man.getDescMantenimiento()+"','"+man.getOficioMantenimiento()+"', '"+man.getFrecuenciaMant()+"',"+man.getDiasMant()+","+man.getDurTareaMant()+",'"+man.getFechIniMantenimiento()+"', '"
                            +man.getFechProgInicMant()+"', '"+man.getFechProgTermMant()+"', '"+man.getFechProximaMant()+"',"+man.getHorasProgramadas()+", 1);");
            }
            for(int i=0;i<idEmp.size();i++)
            {

                respuesta=conexion.getStmt().executeUpdate("INSERT INTO EMP_MANT(ID_MANT, ID_EMP) values ("+man.getIdMantenimiento()+", "+idEmp.get(i)+");");
            }
            for(int j=0;j<idInst.size();j++)
            {

                respuesta=conexion.getStmt().executeUpdate("INSERT INTO INSTR_MANT(ID_MANT, ID_INST) values ("+man.getIdMantenimiento()+", "+idInst.get(j)+");");
            }
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
    
    public boolean modificar(Mantenimientos mAn, Mantenimientos mDes, ArrayList<Employee> codAnEmp, ArrayList<Instruction> codAnInst, ArrayList<Integer> codDesEmp, ArrayList<Integer> codDesInt, String fecha, User usu){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try{
            ////INGRESO LA AUDITORIA ANTES DEL CAMBIO
            if(mAn.getIdEquipo()!=0){
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO `mantenimiento2`(`ID_MANT2`, `ID_USU`, `ID_EQ2`, "
                    + "`ID_LOCT2`, `NROTAREA_MANT2`, `DESCRIPCION_MANT2`, `OFICIO_MANT2`, `FRECUENCIA_MANT2`, `DIAS_MANT2`, "
                    + "`DURACIONTAREA_MANT2`, `FECHAINICIO_MANT2`, `FECHAPROGRAMADAINICIO_MANT2`, `FECHAPROGRAMADATERMINI_MANT2`,"
                    + " `PROXIMAFECHA_MANT2`, `HORACAMBIO_MANT2`) VALUES ("+mAn.getIdMantenimiento()+", 1, "+mAn.getIdEquipo()+","
                    + " null, '"+mAn.getNroTareaMant()+"', '"+mAn.getDescMantenimiento()+"', '"+mAn.getOficioMantenimiento()+"'"
                    + ", '"+mAn.getFrecuenciaMant()+"', "+mAn.getDiasMant()+", "+mAn.getDurTareaMant()+", '"+mAn.getFechIniMantenimiento()+"'"
                    + ", '"+mAn.getFechProgInicMant()+"', '"+mAn.getFechProgTermMant()+"', '"+mAn.getFechProximaMant()+"', '"+fecha+"')");
            }
            else
            {
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO `mantenimiento2`(`ID_MANT2`, `ID_USU`, `ID_EQ2`, "
                    + "`ID_LOCT2`, `NROTAREA_MANT2`, `DESCRIPCION_MANT2`, `OFICIO_MANT2`, `FRECUENCIA_MANT2`, `DIAS_MANT2`, "
                    + "`DURACIONTAREA_MANT2`, `FECHAINICIO_MANT2`, `FECHAPROGRAMADAINICIO_MANT2`, `FECHAPROGRAMADATERMINI_MANT2`,"
                    + " `PROXIMAFECHA_MANT2`, `HORACAMBIO_MANT2`) VALUES ("+mAn.getIdMantenimiento()+", 1, null"
                    + ", "+mAn.getIdLocacion()+", '"+mAn.getNroTareaMant()+"', '"+mAn.getDescMantenimiento()+"', '"+mAn.getOficioMantenimiento()+"'"
                    + ", '"+mAn.getFrecuenciaMant()+"', "+mAn.getDiasMant()+", "+mAn.getDurTareaMant()+", '"+mAn.getFechIniMantenimiento()+"'"
                    + ", '"+mAn.getFechProgInicMant()+"', '"+mAn.getFechProgTermMant()+"', '"+mAn.getFechProximaMant()+"', '"+fecha+"')");
            }
            
            for(int i=0;i<codAnEmp.size();i++)
            {
                //JOptionPane.showMessageDialog(null, "Se ingresa a emp_mant: "+idEmp.get(i));
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO EMP_MANT2(ID_MANT2, ID_EMP2, CAMBIO) values ("+mAn.getIdMantenimiento()+", "+codAnEmp.get(i).getIdEmployee()+", 0);");
            }
            for(int j=0;j<codAnInst.size();j++)
            {
                //JOptionPane.showMessageDialog(null, "Se ingresa a instr_mant");
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO INSTR_MANT2(ID_MANT2, ID_INST2, CAMBIO) values ("+mAn.getIdMantenimiento()+", "+codAnInst.get(j).getIdInst()+", 0);");
            }
            ////////SE ELIMINA LOS ANTERIORES EN TABLAS INTERMEDIAS
                respuesta=conexion.getStmt().executeUpdate("DELETE FROM EMP_MANT WHERE ID_MANT="+mAn.getIdMantenimiento());
                respuesta=conexion.getStmt().executeUpdate("DELETE FROM INSTR_MANT WHERE ID_MANT="+mAn.getIdMantenimiento());
            ///////INSERTAMOS LOS NUEVOS EN TABLAS INTERMEDIAS ArrayList<Integer> codDesEmp, ArrayList<Integer> codDesInt
                for(int i=0;i<codDesEmp.size();i++)
            {

                respuesta=conexion.getStmt().executeUpdate("INSERT INTO EMP_MANT(ID_MANT, ID_EMP) values ("+mAn.getIdMantenimiento()+", "+codDesEmp.get(i)+");");
            }
            for(int j=0;j<codDesInt.size();j++)
            {

                respuesta=conexion.getStmt().executeUpdate("INSERT INTO INSTR_MANT(ID_MANT, ID_INST) values ("+mAn.getIdMantenimiento()+", "+codDesInt.get(j)+");");
            }
            ////UPDATEAMOS LA TABLA MANTENIMIENTO
            if(mDes.getIdEquipo()!=0){
                respuesta=conexion.getStmt().executeUpdate("UPDATE mantenimiento SET "
                + "ID_EQ="+mDes.getIdEquipo()+",ID_LOCT=null,NROTAREA_MANT='"+mDes.getNroTareaMant()+"',"
                + "DESCRIPCION_MANT='"+mDes.getDescMantenimiento()+"',OFICIO_MANT='"+mDes.getOficioMantenimiento()+"',"
                + "FRECUENCIA_MANT='"+mDes.getFrecuenciaMant()+"',DIAS_MANT="+mDes.getDiasMant()+","
                + "DURACIONTAREA_MANT="+mDes.getDurTareaMant()+",FECHAINICIO_MANT='"+mDes.getFechIniMantenimiento()+"',"
                + "FECHAPROGRAMADAINICIO_MANT='"+mDes.getFechProgInicMant()+"',FECHAPROGRAMADATERMINO_MANT='"+mDes.getFechProgTermMant()+"',"
                + "PROXIMAFECHA_MANT='"+mDes.getFechProximaMant()
                + "',HORASPROGRAMADAS_MANT="+mDes.getHorasProgramadas()
                + " WHERE ID_MANT="+mDes.getIdMantenimiento());
            }
            else
            {
                respuesta=conexion.getStmt().executeUpdate("UPDATE `mantenimiento` SET "
                + "`ID_EQ`=null,`ID_LOCT`="+mDes.getIdLocacion()+",`NROTAREA_MANT`='"+mDes.getNroTareaMant()+"',"
                + "`DESCRIPCION_MANT`='"+mDes.getDescMantenimiento()+"',`OFICIO_MANT`='"+mDes.getOficioMantenimiento()+"',"
                + "`FRECUENCIA_MANT`='"+mDes.getFrecuenciaMant()+"',`DIAS_MANT`="+mDes.getDiasMant()+","
                + "`DURACIONTAREA_MANT`="+mDes.getDurTareaMant()+",`FECHAINICIO_MANT`='"+mDes.getFechIniMantenimiento()+"',"
                + "`FECHAPROGRAMADAINICIO_MANT`='"+mDes.getFechProgInicMant()+"',`FECHAPROGRAMADATERMINO_MANT`='"+mDes.getFechProgTermMant()+"',"
                + "`PROXIMAFECHA_MANT`='"+mDes.getFechProximaMant()
                + "',`HORASPROGRAMADAS_MANT`="+mDes.getHorasProgramadas()
                +" WHERE ID_MANT="+mDes.getIdMantenimiento());
            }
            ////////////////////HACEMOS LA AUDITORIA DESPUES DE ACTUALIZAR
            if(mDes.getIdEquipo()!=0){
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO `mantenimiento2`(`ID_MANT2`, `ID_USU`, `ID_EQ2`, "
                    + "`ID_LOCT2`, `NROTAREA_MANT2`, `DESCRIPCION_MANT2`, `OFICIO_MANT2`, `FRECUENCIA_MANT2`, `DIAS_MANT2`, "
                    + "`DURACIONTAREA_MANT2`, `FECHAINICIO_MANT2`, `FECHAPROGRAMADAINICIO_MANT2`, `FECHAPROGRAMADATERMINI_MANT2`,"
                    + " `PROXIMAFECHA_MANT2`, `HORACAMBIO_MANT2`) VALUES ("+mDes.getIdMantenimiento()+", 1, "+mDes.getIdEquipo()+""
                    + ", null, '"+mDes.getNroTareaMant()+"', '"+mDes.getDescMantenimiento()+"', '"+mDes.getOficioMantenimiento()+"'"
                    + ", '"+mDes.getFrecuenciaMant()+"', "+mDes.getDiasMant()+", "+mDes.getDurTareaMant()+", '"+mDes.getFechIniMantenimiento()+"'"
                    + ", '"+mDes.getFechProgInicMant()+"', '"+mDes.getFechProgTermMant()+"', '"+mDes.getFechProximaMant()+"', '"+fecha+"')");

            }
            else
            {
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO `mantenimiento2`(`ID_MANT2`, `ID_USU`, `ID_EQ2`, "
                    + "`ID_LOCT2`, `NROTAREA_MANT2`, `DESCRIPCION_MANT2`, `OFICIO_MANT2`, `FRECUENCIA_MANT2`, `DIAS_MANT2`, "
                    + "`DURACIONTAREA_MANT2`, `FECHAINICIO_MANT2`, `FECHAPROGRAMADAINICIO_MANT2`, `FECHAPROGRAMADATERMINI_MANT2`,"
                    + " `PROXIMAFECHA_MANT2`, `HORACAMBIO_MANT2`) VALUES ("+mDes.getIdMantenimiento()+", 1, null"
                    + ", "+mDes.getIdLocacion()+", '"+mDes.getNroTareaMant()+"', '"+mDes.getDescMantenimiento()+"', '"+mDes.getOficioMantenimiento()+"'"
                    + ", '"+mDes.getFrecuenciaMant()+"', "+mDes.getDiasMant()+", "+mDes.getDurTareaMant()+", '"+mDes.getFechIniMantenimiento()+"'"
                    + ", '"+mDes.getFechProgInicMant()+"', '"+mDes.getFechProgTermMant()+"', '"+mDes.getFechProximaMant()+"', '"+fecha+"')");

            }
            for(int i=0;i<codDesEmp.size();i++)
            {
                //JOptionPane.showMessageDialog(null, "Se ingresa a emp_mant: "+idEmp.get(i));
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO EMP_MANT2(ID_MANT2, ID_EMP2, CAMBIO) values ("+mAn.getIdMantenimiento()+", "+codDesEmp.get(i)+", 1);");

            }
            for(int j=0;j<codDesInt.size();j++)
            {
                //JOptionPane.showMessageDialog(null, "Se ingresa a instr_mant");
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO INSTR_MANT2(ID_MANT2, ID_INST2, CAMBIO) values ("+mAn.getIdMantenimiento()+", "+codDesInt.get(j)+", 1);");

            }
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("MANTENIMIENTOS");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(mAn.getNroTareaMant()+"-"+mAn.getDescMantenimiento()+"_"+mDes.getNroTareaMant()+"-"+mDes.getDescMantenimiento());
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
    
    public boolean eliminar(Mantenimientos man, ArrayList<Employee> codEmpleados, ArrayList<Instruction> codInst, String fecha, User usu){
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta=0, respuesta1=0, respuesta2=0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        
        try{
            
            if(man.getIdEquipo()!=0){
            respuesta=conexion.getStmt().executeUpdate("INSERT INTO `mantenimiento2`(`ID_MANT2`, `ID_USU`, `ID_EQ2`, "
                    + "`ID_LOCT2`, `NROTAREA_MANT2`, `DESCRIPCION_MANT2`, `OFICIO_MANT2`, `FRECUENCIA_MANT2`, `DIAS_MANT2`, "
                    + "`DURACIONTAREA_MANT2`, `FECHAINICIO_MANT2`, `FECHAPROGRAMADAINICIO_MANT2`, `FECHAPROGRAMADATERMINI_MANT2`,"
                    + " `PROXIMAFECHA_MANT2`, `HORACAMBIO_MANT2`) VALUES ("+man.getIdMantenimiento()+", 1, "+man.getIdEquipo()+""
                    + ", null, '"+man.getNroTareaMant()+"', '"+man.getDescMantenimiento()+"', '"+man.getOficioMantenimiento()+"'"
                    + ", '"+man.getFrecuenciaMant()+"', "+man.getDiasMant()+", "+man.getDurTareaMant()+", '"+man.getFechIniMantenimiento()+"'"
                    + ", '"+man.getFechProgInicMant()+"', '"+man.getFechProgTermMant()+"', '"+man.getFechProximaMant()+"', '"+fecha+"')");

            }
            else
            {
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO `mantenimiento2`(`ID_MANT2`, `ID_USU`, `ID_EQ2`, "
                    + "`ID_LOCT2`, `NROTAREA_MANT2`, `DESCRIPCION_MANT2`, `OFICIO_MANT2`, `FRECUENCIA_MANT2`, `DIAS_MANT2`, "
                    + "`DURACIONTAREA_MANT2`, `FECHAINICIO_MANT2`, `FECHAPROGRAMADAINICIO_MANT2`, `FECHAPROGRAMADATERMINI_MANT2`,"
                    + " `PROXIMAFECHA_MANT2`, `HORACAMBIO_MANT2`) VALUES ("+man.getIdMantenimiento()+", 1, null"
                    + ", "+man.getIdLocacion()+", '"+man.getNroTareaMant()+"', '"+man.getDescMantenimiento()+"', '"+man.getOficioMantenimiento()+"'"
                    + ", '"+man.getFrecuenciaMant()+"', "+man.getDiasMant()+", "+man.getDurTareaMant()+", '"+man.getFechIniMantenimiento()+"'"
                    + ", '"+man.getFechProgInicMant()+"', '"+man.getFechProgTermMant()+"', '"+man.getFechProximaMant()+"', '"+fecha+"')");

            }
            for(int i=0;i<codEmpleados.size();i++)
            {
                //JOptionPane.showMessageDialog(null, "Se ingresa a emp_mant: "+idEmp.get(i));
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO EMP_MANT2(ID_MANT2, ID_EMP2, CAMBIO) values ("+man.getIdMantenimiento()+", "+codEmpleados.get(i).getIdEmployee()+", 2);");

            }
            for(int j=0;j<codInst.size();j++)
            {
                //JOptionPane.showMessageDialog(null, "Se ingresa a instr_mant");
                respuesta=conexion.getStmt().executeUpdate("INSERT INTO INSTR_MANT2(ID_MANT2, ID_INST2, CAMBIO) values ("+man.getIdMantenimiento()+", "+codInst.get(j).getIdInst()+", 2);");

            }
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            respuesta=conexion.getStmt().executeUpdate("UPDATE MANTENIMIENTO SET ACTIVO=0 WHERE ID_MANT="+man.getIdMantenimiento());
            if(respuesta>0){
                 conexion.Desconectar();
                 Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("MANTENIMIENTOS");
                 a.setAccionRealizada("ELIMINACIÓN");
                 a.setDescripcion(man.getNroTareaMant()+"-"+man.getDescMantenimiento());
                 if(!audCRUD.insertarAuditoria(a))
                     JOptionPane.showMessageDialog(null, "AUDITORIA NO INSERTADA","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
                 
                 return true;
             }else{
                 conexion.Desconectar();
                 return false;
             }
        }catch (Exception ex){
            System.err.println("Error en ELIMINAR registro: " + ex.getMessage());
            System.out.println("Error eliminar: "+ex.getMessage());
            conexion.Desconectar();
            ex.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Mantenimientos> visualizar(){
        ArrayList<Mantenimientos> listaMant = new ArrayList<Mantenimientos>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0");
            /*SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO
              FROM DEPARTAMENTO d JOIN LOCACION l
              ON (d.ID_DEPT = l.ID_DEPT)*/
            
            while (resultado.next()) {
                  Mantenimientos mant = new Mantenimientos();
                  mant.setIdMantenimiento(resultado.getInt("ID_MANT"));
                  mant.setIdEquipo(resultado.getInt("ID_EQ"));
                  mant.setIdLocacion(resultado.getInt("ID_LOCT"));
                  mant.setNroTareaMant(resultado.getString("NROTAREA_MANT"));
                  mant.setDescMantenimiento(resultado.getString("DESCRIPCION_MANT"));
                  mant.setOficioMantenimiento(resultado.getString("OFICIO_MANT"));
                  mant.setFrecuenciaMant(resultado.getString("FRECUENCIA_MANT"));
                  mant.setDiasMant(resultado.getInt("DIAS_MANT"));
                  mant.setDurTareaMant(resultado.getInt("DURACIONTAREA_MANT"));
                  mant.setFechIniMantenimiento(resultado.getString("FECHAINICIO_MANT"));
                  mant.setFechProgInicMant(resultado.getString("FECHAPROGRAMADAINICIO_MANT"));
                  mant.setFechProgTermMant(resultado.getString("FECHAPROGRAMADATERMINO_MANT"));
                  mant.setFechProximaMant(resultado.getString("PROXIMAFECHA_MANT"));
                  mant.setHorasProgramadas(resultado.getInt("HORASPROGRAMADAS_MANT"));
                  
                  listaMant.add(mant);
            }
            
            return listaMant;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros MANTENIMIENTO: " + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Mantenimientos>();
        }
    }
    public ArrayList<Integer> visualizarCodigo(){
        ArrayList<Integer> listaMant = new ArrayList<Integer>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0");
            /*SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO
              FROM DEPARTAMENTO d JOIN LOCACION l
              ON (d.ID_DEPT = l.ID_DEPT)*/
            
            while (resultado.next()) {
                  Mantenimientos mant = new Mantenimientos();
                  mant.setIdMantenimiento(resultado.getInt("ID_MANT"));
                  listaMant.add(mant.getIdMantenimiento());
            }
            
            return listaMant;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros LOCATIONS: " + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Integer>();
        }
    }
    public Mantenimientos mostrarPorCodigo(int codigo)
    {
        ArrayList<Integer> listaMant = new ArrayList<Integer>();
        Mantenimientos mant = new Mantenimientos();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try{
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND ID_MANT="+codigo);
            /*SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO
              FROM DEPARTAMENTO d JOIN LOCACION l
              ON (d.ID_DEPT = l.ID_DEPT)*/
            
            while (resultado.next()) {
                  
                  
                  mant.setIdMantenimiento(resultado.getInt("ID_MANT"));
                  mant.setIdEquipo(resultado.getInt("ID_EQ"));
                  mant.setIdLocacion(resultado.getInt("ID_LOCT"));
                  mant.setNroTareaMant(resultado.getString("NROTAREA_MANT"));
                  mant.setDescMantenimiento(resultado.getString("DESCRIPCION_MANT"));
                  mant.setOficioMantenimiento(resultado.getString("OFICIO_MANT"));
                  mant.setFrecuenciaMant(resultado.getString("FRECUENCIA_MANT"));
                  mant.setDiasMant(resultado.getInt("DIAS_MANT"));
                  mant.setDurTareaMant(resultado.getInt("DURACIONTAREA_MANT"));
                  mant.setFechIniMantenimiento(resultado.getString("FECHAINICIO_MANT"));
                  mant.setFechProgInicMant(resultado.getString("FECHAPROGRAMADAINICIO_MANT"));
                  mant.setFechProgTermMant(resultado.getString("FECHAPROGRAMADATERMINO_MANT"));
                  mant.setFechProximaMant(resultado.getString("PROXIMAFECHA_MANT"));
                  mant.setHorasProgramadas(resultado.getInt("HORASPROGRAMADAS_MANT"));
            }
//            JOptionPane.showMessageDialog(null, "si lo hace");
            return mant;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros MANTENIMIENTO: " + ex.getMessage());
            ex.printStackTrace();
            return new Mantenimientos();
        }
    }
    public ArrayList<Employee> llenarComboEmpMant()
    {
        ArrayList<Employee> listEmp=new ArrayList<Employee>();

        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try
        {
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("select e.ID_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP "
                    + "from empleado e inner join emp_mant em on e.ID_EMP=em.ID_EMP INNER JOIN "
                    + "mantenimiento m on em.ID_MANT=m.ID_MANT where m.ACTIVO <> 0 GROUP BY E.ID_EMP");
            
            while (resultado.next()) {
                        Employee emp = new Employee();
                        emp.setIdEmployee(resultado.getInt("ID_EMP"));
                        emp.setNomEmployee(resultado.getString("NOMBRE_EMP"));
                        emp.setApeEmployee(resultado.getString("APELLIDO_EMP"));
                        listEmp.add(emp);
            }        
            return listEmp;
            
        }catch (SQLException ex){
            System.err.println("Error en devolver registros MANTENIMIENTO: " + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Employee>();
        }
    }
    
    public ArrayList<Mantenimientos> mantPorEmpleado(int idEmp)
    {
        ArrayList<Mantenimientos> listMant=new ArrayList<Mantenimientos>();

        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try
        {
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("select m.ID_MANT, m.ID_EQ, m.ID_LOCT, m.NROTAREA_MANT, "
                    + "m.DESCRIPCION_MANT, m.FRECUENCIA_MANT, m.DIAS_MANT, m.DURACIONTAREA_MANT, m.FECHAINICIO_MANT, "
                    + "m.FECHAPROGRAMADAINICIO_MANT , m.FECHAPROGRAMADATERMINO_MANT, m.PROXIMAFECHA_MANT, m.HORASPROGRAMADAS_MANT "
                    + "from mantenimiento m inner join emp_mant em on m.ID_MANT=em.ID_MANT INNER JOIN empleado e "
                    + "on em.ID_EMP=e.ID_EMP where m.ACTIVO <> 0 and e.ID_EMP="+idEmp);
            
            while (resultado.next()) {
                Mantenimientos mant=new Mantenimientos();
                        mant.setIdMantenimiento(resultado.getInt("ID_MANT"));
                  mant.setIdEquipo(resultado.getInt("ID_EQ"));
                  mant.setIdLocacion(resultado.getInt("ID_LOCT"));
                  mant.setNroTareaMant(resultado.getString("NROTAREA_MANT"));
                  mant.setDescMantenimiento(resultado.getString("DESCRIPCION_MANT"));
                  //mant.setOficioMantenimiento(resultado.getString("OFICIO_MANT"));
                  mant.setFrecuenciaMant(resultado.getString("FRECUENCIA_MANT"));
                  mant.setDiasMant(resultado.getInt("DIAS_MANT"));
                  mant.setDurTareaMant(resultado.getInt("DURACIONTAREA_MANT"));
                  mant.setFechIniMantenimiento(resultado.getString("FECHAINICIO_MANT"));
                  mant.setFechProgInicMant(resultado.getString("FECHAPROGRAMADAINICIO_MANT"));
                  mant.setFechProgTermMant(resultado.getString("FECHAPROGRAMADATERMINO_MANT"));
                  mant.setFechProximaMant(resultado.getString("PROXIMAFECHA_MANT"));
                  mant.setHorasProgramadas(resultado.getInt("HORASPROGRAMADAS_MANT"));
                        listMant.add(mant);
            }        
            return listMant;
            
        }catch (SQLException ex){
            System.err.println("Error en devolver registros MANTENIMIENTO: " + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Mantenimientos>();
        }
    }
    public ArrayList<String> colabPorMant(ArrayList<Mantenimientos> idMant)
    {
        ArrayList<String> listaColab=new ArrayList<String>();
        String colaboradores="";

        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        try
        {
            for(int i=0; i<idMant.size();i++)
            {
               colaboradores="";
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado= conexion.getStmt().executeQuery("select e.nombre_emp, e.apellido_emp from empleado "
                    + "e INNER JOIN emp_mant em on e.ID_EMP=em.ID_EMP where em.ID_MANT="+idMant.get(i).getIdMantenimiento());
            
            while (resultado.next()) {

                        String nombre=resultado.getString("NOMBRE_EMP");
                        String apellido=resultado.getString("APELLIDO_EMP");
                        colaboradores+=nombre+" "+apellido+";";
                        
                        
                }     
//            JOptionPane.showMessageDialog(null, colaboradores+" "+idMant.get(i).getIdMantenimiento());
            listaColab.add(colaboradores);
            }
            return listaColab;
            
        }catch (SQLException ex){
            System.err.println("Error en devolver registros MANTENIMIENTO: " + ex.getMessage());
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
    
            resultado = conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND (FECHAPROGRAMADATERMINO_MANT - NOW()) >= 7");
            
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
    
    
    public ArrayList<Mantenimientos> enviarDatosTabla(ResultSet resultado){
        
        ArrayList<Mantenimientos> listaMant = new ArrayList<Mantenimientos>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        try{
           while (resultado.next()) {
                Mantenimientos mant=new Mantenimientos();
                        mant.setIdMantenimiento(resultado.getInt("ID_MANT"));
                  mant.setIdEquipo(resultado.getInt("ID_EQ"));
                  mant.setIdLocacion(resultado.getInt("ID_LOCT"));
                  mant.setNroTareaMant(resultado.getString("NROTAREA_MANT"));
                  mant.setDescMantenimiento(resultado.getString("DESCRIPCION_MANT"));
                  //mant.setOficioMantenimiento(resultado.getString("OFICIO_MANT"));
                  mant.setFrecuenciaMant(resultado.getString("FRECUENCIA_MANT"));
                  mant.setDiasMant(resultado.getInt("DIAS_MANT"));
                  mant.setDurTareaMant(resultado.getInt("DURACIONTAREA_MANT"));
                  mant.setFechIniMantenimiento(resultado.getString("FECHAINICIO_MANT"));
                  mant.setFechProgInicMant(resultado.getString("FECHAPROGRAMADAINICIO_MANT"));
                  mant.setFechProgTermMant(resultado.getString("FECHAPROGRAMADATERMINO_MANT"));
                  mant.setFechProximaMant(resultado.getString("PROXIMAFECHA_MANT"));
                  mant.setHorasProgramadas(resultado.getInt("HORASPROGRAMADAS_MANT"));
                        listaMant.add(mant);
            }        
            return listaMant;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Mantenimientos>();
        }
    }
   
    public ArrayList<Mantenimientos> visualizar(String texto, int item){
        
        ArrayList<Mantenimientos> listaMant = new ArrayList<Mantenimientos>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
        String Filtro=""+texto+"_%";
        try {
            conexion.getStmt();
            switch (item) {
                case 0:
                    resultado = conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND NROTAREA_MANT like " + '"' + Filtro + '"');
                    break;
                case 1:
                    resultado = conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND DESCRIPCION_MANT like " + '"' + Filtro + '"');
                    break;
                case 2:
                    resultado = conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND OFICIO_MANT like " + '"' + Filtro + '"');
                    break;
                case 3:
                    resultado = conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND FRECUENCIA_MANT like " + '"' + Filtro + '"');
                    break;
                case 4:
                    resultado = conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND (DIAS_MANT LIKE '"+ Filtro +"' OR DIAS_MANT = '"+ texto +"')");
                    break;
                case 5:
                    resultado = conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND (DURACIONTAREA_MANT LIKE '"+ Filtro +"' OR DURACIONTAREA_MANT = '"+ texto +"')");
                    break;
                case 6:
                    resultado = conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND (HORASPROGRAMADAS_MANT LIKE '"+ Filtro +"' OR HORASPROGRAMADAS_MANT = '"+ texto +"')");
                    break;
                default:
                    break;
            }
            
           while (resultado.next()) {
                Mantenimientos mant=new Mantenimientos();
                        mant.setIdMantenimiento(resultado.getInt("ID_MANT"));
                  mant.setIdEquipo(resultado.getInt("ID_EQ"));
                  mant.setIdLocacion(resultado.getInt("ID_LOCT"));
                  mant.setNroTareaMant(resultado.getString("NROTAREA_MANT"));
                  mant.setDescMantenimiento(resultado.getString("DESCRIPCION_MANT"));
                  //mant.setOficioMantenimiento(resultado.getString("OFICIO_MANT"));
                  mant.setFrecuenciaMant(resultado.getString("FRECUENCIA_MANT"));
                  mant.setDiasMant(resultado.getInt("DIAS_MANT"));
                  mant.setDurTareaMant(resultado.getInt("DURACIONTAREA_MANT"));
                  mant.setFechIniMantenimiento(resultado.getString("FECHAINICIO_MANT"));
                  mant.setFechProgInicMant(resultado.getString("FECHAPROGRAMADAINICIO_MANT"));
                  mant.setFechProgTermMant(resultado.getString("FECHAPROGRAMADATERMINO_MANT"));
                  mant.setFechProximaMant(resultado.getString("PROXIMAFECHA_MANT"));
                  mant.setHorasProgramadas(resultado.getInt("HORASPROGRAMADAS_MANT"));
                        listaMant.add(mant);
            }        
            return listaMant;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return new ArrayList<Mantenimientos>();
        }
    }
       
    public Mantenimientos obtenerMant(int codigo){
        
//        ArrayList<Mantenimientos> listaMant = new ArrayList<Mantenimientos>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado=null;
//        String Filtro=""+texto+"_%";
        try {
            conexion.getStmt();


            resultado = conexion.getStmt().executeQuery("SELECT * FROM MANTENIMIENTO WHERE ACTIVO <> 0 AND ID_MANT = '" + codigo + "'");

            Mantenimientos mant=new Mantenimientos();
           if (resultado.next()) {
                
                        mant.setIdMantenimiento(resultado.getInt("ID_MANT"));
                  mant.setIdEquipo(resultado.getInt("ID_EQ"));
                  mant.setIdLocacion(resultado.getInt("ID_LOCT"));
                  mant.setNroTareaMant(resultado.getString("NROTAREA_MANT"));
                  mant.setDescMantenimiento(resultado.getString("DESCRIPCION_MANT"));
                  //mant.setOficioMantenimiento(resultado.getString("OFICIO_MANT"));
                  mant.setFrecuenciaMant(resultado.getString("FRECUENCIA_MANT"));
                  mant.setDiasMant(resultado.getInt("DIAS_MANT"));
                  mant.setDurTareaMant(resultado.getInt("DURACIONTAREA_MANT"));
                  mant.setFechIniMantenimiento(resultado.getString("FECHAINICIO_MANT"));
                  mant.setFechProgInicMant(resultado.getString("FECHAPROGRAMADAINICIO_MANT"));
                  mant.setFechProgTermMant(resultado.getString("FECHAPROGRAMADATERMINO_MANT"));
                  mant.setFechProximaMant(resultado.getString("PROXIMAFECHA_MANT"));
                  mant.setHorasProgramadas(resultado.getInt("HORASPROGRAMADAS_MANT"));
//                        listaMant.add(mant);
            }        
            return mant;

        } catch (SQLException ex){
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
}
