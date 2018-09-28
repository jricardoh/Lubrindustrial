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
 * @author RH
 */
public class EmployeeCRUD {
    
    String host;
    
    public EmployeeCRUD(){
        
    }
    
    public EmployeeCRUD(String hostname){
        this.host = hostname;
    }
    
    public ArrayList<Employee> visualizarPorDepartamento(int idDep) {
        ArrayList<Employee> listaEmp = new ArrayList<Employee>();
        Conexion conexion = new Conexion();
        conexion.Conectar();
        ResultSet resultado = null;
        try {
            conexion.getStmt();
            resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                    + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                    + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                    + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                    + " ON (d.ID_DEPT = e.ID_DEPT)"
                    + " WHERE e.ACTIVO <> 0 "
                    + " ORDER BY d.DESCRIPCION_DEPT");
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM EMPLEADO WHERE ACTIVO <> 0");
            /*SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,
              e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,
              e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO
              FROM EMPLEADO e JOIN DEPARTAMENTO d
              ON (d.ID_DEPT = e.ID_DEPT)
              WHERE ACTIVO <> 0*/

            while (resultado.next()) {
                Employee emp = new Employee();
                //emp.setIdDepartment(resultado.getInt("ID_DEPT"));
                emp.setIdEmployee(resultado.getInt("ID_EMP"));
                emp.setNroEmployee(resultado.getString("NRO_EMP"));
                emp.setNomEmployee(resultado.getString("NOMBRE_EMP"));
                emp.setApeEmployee(resultado.getString("APELLIDO_EMP"));
                emp.setPosEmployee(resultado.getString("POSICION_EMP"));
                emp.setExtEmployee(resultado.getString("EXTENSION_EMP"));
                emp.setTelftrabEmployee(resultado.getString("TELFTRAB_EMP"));
                emp.setTelfpersEmployee(resultado.getString("TELFPERS_EMP"));
                emp.setTelfcasaEmployee(resultado.getString("TELFCASA_EMP"));
                emp.setEmailEmployee(resultado.getString("EMAIL_EMP"));
                emp.setFaxEmployee(resultado.getString("EMAIL2_EMP"));
                emp.setLocOficEmployee(resultado.getString("LOCACIONOFICINA_EMP"));
                emp.setSalarioHoraEmployee(resultado.getFloat("SUELDO_EMP"));
                emp.setSobretiempo1Employee(resultado.getFloat("SOBRETIEMPO_EMP"));
                emp.setNameDept(resultado.getString("DESCRIPCION_DEPT"));

                emp.setActivoEmployee(resultado.getInt("ACTIVO"));
                listaEmp.add(emp);
            }

            return listaEmp;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros EMPLEADOS: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<Employee>();
        }
    }

    
    public boolean insertar(Employee emp) {
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta = 0;
        try {
            respuesta = conexion.getStmt().executeUpdate("INSERT INTO EMPLEADO (ID_DEPT,NRO_EMP,NOMBRE_EMP,APELLIDO_EMP,POSICION_EMP,EXTENSION_EMP,TELFTRAB_EMP,TELFPERS_EMP,TELFCASA_EMP,EMAIL_EMP,EMAIL2_EMP,LOCACIONOFICINA_EMP,SUELDO_EMP,SOBRETIEMPO_EMP, ACTIVO)values ('"
                    + emp.getIdDepartment() + "','" + emp.getNroEmployee() + "','" + emp.getNomEmployee() + "','" + emp.getApeEmployee() + "','" + emp.getPosEmployee() + "','" + emp.getExtEmployee() + "','" + emp.getTelftrabEmployee() + "','" + emp.getTelfpersEmployee() + "','" + emp.getTelfcasaEmployee() + "','" + emp.getEmailEmployee() + "','" + emp.getFaxEmployee() + "','" + emp.getLocOficEmployee() + "','" + emp.getSalarioHoraEmployee() + "','" + emp.getSobretiempo1Employee() + "'," + emp.getActivoEmployee() + ")");
            if (respuesta > 0) {
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

    public boolean modificar(Employee emp, User usu) {
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta = 0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        try {
            respuesta = conexion.getStmt().executeUpdate("UPDATE EMPLEADO set ID_DEPT='" + emp.getIdDepartment()
                    + "', NRO_EMP='" + emp.getNroEmployee()
                    + "', NOMBRE_EMP='" + emp.getNomEmployee()
                    + "', APELLIDO_EMP='" + emp.getApeEmployee()
                    + "', POSICION_EMP='" + emp.getPosEmployee()
                    + "', EXTENSION_EMP='" + emp.getExtEmployee()
                    + "', TELFTRAB_EMP='" + emp.getTelftrabEmployee()
                    + "', TELFPERS_EMP='" + emp.getTelfpersEmployee()
                    + "', TELFCASA_EMP='" + emp.getTelfcasaEmployee()
                    + "', EMAIL_EMP='" + emp.getEmailEmployee()
                    + "', EMAIL2_EMP='" + emp.getFaxEmployee()
                    + "', LOCACIONOFICINA_EMP='" + emp.getLocOficEmployee()
                    + "', SUELDO_EMP='" + emp.getSalarioHoraEmployee()
                    + "', SOBRETIEMPO_EMP='" + emp.getSobretiempo1Employee()
                    + "', ACTIVO='" + emp.getActivoEmployee()
                    + "' WHERE ID_EMP='" + emp.getIdEmployee() + "'");
            if (respuesta > 0) {
                conexion.Desconectar();
                Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("EMPLEADOS");
                 a.setAccionRealizada("MODIFICACION");
                 a.setDescripcion(emp.getNroEmployee()+"-"+emp.getNomEmployee()+"-"+emp.getApeEmployee());
                 if(!audCRUD.insertarAuditoria(a))
                     JOptionPane.showMessageDialog(null, "AUDITORIA NO INSERTADA","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
                 
                return true;
            } else {
                conexion.Desconectar();
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error en MODIFICAR registro: " + ex.getMessage());
            conexion.Desconectar();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int codigo, User usu) {
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        int respuesta = 0;
        AuditoriaCRUD audCRUD = new AuditoriaCRUD();
        Employee emp  = obtenerEmp(respuesta);
        try {
            respuesta = conexion.getStmt().executeUpdate("UPDATE EMPLEADO set ACTIVO='" + 0
                    + "' WHERE ID_EMP=" + codigo);
            /*ELIMINADO LOGICO A NIVEL DE ACTUALIZCION DE UNA COLUMNA EN LA TABLA DE LA BD*/
            if (respuesta > 0) {
                conexion.Desconectar();
                return true;
            } else {
                conexion.Desconectar();
                Auditoria a = new Auditoria();

                 a.setIdUsu(usu.getIdUser());
                 a.setNombreUsu(usu.getNomUser());
                 a.setApellidoUsu(usu.getApeUser());
                 a.setTablaAfectada("EMPLEADOS");
                 a.setAccionRealizada("ELIMINACIÓN");
                 a.setDescripcion(emp.getNroEmployee()+"-"+emp.getNomEmployee()+"-"+emp.getApeEmployee());
                 if(!audCRUD.insertarAuditoria(a))
                     JOptionPane.showMessageDialog(null, "AUDITORIA NO INSERTADA","ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
                 
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error en ELIMINAR registro: " + ex.getMessage());
            conexion.Desconectar();
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Employee> visualizar() {
        ArrayList<Employee> listaEmp = new ArrayList<Employee>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado = null;
        try {
            conexion.getStmt();
            resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                    + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                    + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                    + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                    + " ON (d.ID_DEPT = e.ID_DEPT)"
                    + " WHERE e.ACTIVO <> 0");
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM EMPLEADO WHERE ACTIVO <> 0");
            /*SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,
              e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,
              e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO
              FROM EMPLEADO e JOIN DEPARTAMENTO d
              ON (d.ID_DEPT = e.ID_DEPT)
              WHERE ACTIVO <> 0*/

            while (resultado.next()) {
                Employee emp = new Employee();
                //emp.setIdDepartment(resultado.getInt("ID_DEPT"));
                emp.setIdEmployee(resultado.getInt("ID_EMP"));
                emp.setNroEmployee(resultado.getString("NRO_EMP"));
                emp.setNomEmployee(resultado.getString("NOMBRE_EMP"));
                emp.setApeEmployee(resultado.getString("APELLIDO_EMP"));
                emp.setPosEmployee(resultado.getString("POSICION_EMP"));
                emp.setExtEmployee(resultado.getString("EXTENSION_EMP"));
                emp.setTelftrabEmployee(resultado.getString("TELFTRAB_EMP"));
                emp.setTelfpersEmployee(resultado.getString("TELFPERS_EMP"));
                emp.setTelfcasaEmployee(resultado.getString("TELFCASA_EMP"));
                emp.setEmailEmployee(resultado.getString("EMAIL_EMP"));
                emp.setFaxEmployee(resultado.getString("EMAIL2_EMP"));
                emp.setLocOficEmployee(resultado.getString("LOCACIONOFICINA_EMP"));
                emp.setSalarioHoraEmployee(resultado.getFloat("SUELDO_EMP"));
                emp.setSobretiempo1Employee(resultado.getFloat("SOBRETIEMPO_EMP"));
                emp.setNameDept(resultado.getString("DESCRIPCION_DEPT"));

                emp.setActivoEmployee(resultado.getInt("ACTIVO"));
                listaEmp.add(emp);
            }

            return listaEmp;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros EMPLEADOS: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<Employee>();
        }
    }

    public ArrayList<Employee> visualizar(int idEmpleado) {
        ArrayList<Employee> listaEmp = new ArrayList<Employee>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado = null;
        try {
            conexion.getStmt();
            resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                    + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                    + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                    + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                    + " ON (d.ID_DEPT = e.ID_DEPT)"
                    + " WHERE e.ACTIVO <> 0 AND e.ID_EMP = '" + idEmpleado + "'");
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM EMPLEADO WHERE ACTIVO <> 0");
            /*SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,
              e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,
              e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO
              FROM EMPLEADO e JOIN DEPARTAMENTO d
              ON (d.ID_DEPT = e.ID_DEPT)
              WHERE ACTIVO <> 0*/

            while (resultado.next()) {
                Employee emp = new Employee();
                //emp.setIdDepartment(resultado.getInt("ID_DEPT"));
                emp.setIdEmployee(resultado.getInt("ID_EMP"));
                emp.setNroEmployee(resultado.getString("NRO_EMP"));
                emp.setNomEmployee(resultado.getString("NOMBRE_EMP"));
                emp.setApeEmployee(resultado.getString("APELLIDO_EMP"));
                emp.setPosEmployee(resultado.getString("POSICION_EMP"));
                emp.setExtEmployee(resultado.getString("EXTENSION_EMP"));
                emp.setTelftrabEmployee(resultado.getString("TELFTRAB_EMP"));
                emp.setTelfpersEmployee(resultado.getString("TELFPERS_EMP"));
                emp.setTelfcasaEmployee(resultado.getString("TELFCASA_EMP"));
                emp.setEmailEmployee(resultado.getString("EMAIL_EMP"));
                emp.setFaxEmployee(resultado.getString("EMAIL2_EMP"));
                emp.setLocOficEmployee(resultado.getString("LOCACIONOFICINA_EMP"));
                emp.setSalarioHoraEmployee(resultado.getFloat("SUELDO_EMP"));
                emp.setSobretiempo1Employee(resultado.getFloat("SOBRETIEMPO_EMP"));
                emp.setNameDept(resultado.getString("DESCRIPCION_DEPT"));

                emp.setActivoEmployee(resultado.getInt("ACTIVO"));
                listaEmp.add(emp);
            }

            return listaEmp;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros EMPLEADOS: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<Employee>();
        }
    }

    public Employee obtenerEmp(int idEmpleado) {
//        ArrayList<Employee> listaEmp = new ArrayList<Employee>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado = null;
        try {
            conexion.getStmt();
            resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                    + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                    + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                    + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                    + " ON (d.ID_DEPT = e.ID_DEPT)"
                    + " WHERE e.ACTIVO <> 0 AND e.ID_EMP = '" + idEmpleado + "'");
            
            Employee emp = new Employee();
            if (resultado.next()) {
                
                //emp.setIdDepartment(resultado.getInt("ID_DEPT"));
                emp.setIdEmployee(resultado.getInt("ID_EMP"));
                emp.setNroEmployee(resultado.getString("NRO_EMP"));
                emp.setNomEmployee(resultado.getString("NOMBRE_EMP"));
                emp.setApeEmployee(resultado.getString("APELLIDO_EMP"));
                emp.setPosEmployee(resultado.getString("POSICION_EMP"));
                emp.setExtEmployee(resultado.getString("EXTENSION_EMP"));
                emp.setTelftrabEmployee(resultado.getString("TELFTRAB_EMP"));
                emp.setTelfpersEmployee(resultado.getString("TELFPERS_EMP"));
                emp.setTelfcasaEmployee(resultado.getString("TELFCASA_EMP"));
                emp.setEmailEmployee(resultado.getString("EMAIL_EMP"));
                emp.setFaxEmployee(resultado.getString("EMAIL2_EMP"));
                emp.setLocOficEmployee(resultado.getString("LOCACIONOFICINA_EMP"));
                emp.setSalarioHoraEmployee(resultado.getFloat("SUELDO_EMP"));
                emp.setSobretiempo1Employee(resultado.getFloat("SOBRETIEMPO_EMP"));
                emp.setNameDept(resultado.getString("DESCRIPCION_DEPT"));

                emp.setActivoEmployee(resultado.getInt("ACTIVO"));
//                listaEmp.add(emp);
            }

            return emp;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros EMPLEADOS: " + ex.getMessage());
            ex.printStackTrace();

            return null;
        }
    }
    
    public ArrayList<Employee> mostrarPorCodigo(int codigo) {
        ArrayList<Employee> listaEmp = new ArrayList<Employee>();

        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado = null;
        try {
            conexion.getStmt();
            //resultado= conexion.getStmt().executeQuery("SELECT * FROM LOCACION WHERE ACTIVO <> 0");
            resultado = conexion.getStmt().executeQuery("SELECT E.ID_EMP, E.NOMBRE_EMP, E.APELLIDO_EMP FROM EMPLEADO E "
                    + "INNER JOIN emp_mant EM ON E.ID_EMP=EM.ID_EMP WHERE EM.ID_MANT=" + codigo);
            /*SELECT l.ID_DEPT, l.ID_LOCT, l.NRO_LOCT, l.DESCRIPCION_LOCT, d.DESCRIPCION_DEPT, l.ACTIVO
              FROM DEPARTAMENTO d JOIN LOCACION l
              ON (d.ID_DEPT = l.ID_DEPT)*/

            while (resultado.next()) {
                Employee emp = new Employee();
                emp.setIdEmployee(resultado.getInt("ID_EMP"));
                emp.setNomEmployee(resultado.getString("NOMBRE_EMP"));
                emp.setApeEmployee(resultado.getString("APELLIDO_EMP"));
                listaEmp.add(emp);
            }

            return listaEmp;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros EMPLOYEES: " + ex.getMessage());
            ex.printStackTrace();
            return new ArrayList<Employee>();
        }
    }

    public ArrayList<Employee> visualizar(String texto, int item) {

        ArrayList<Employee> listaEmp = new ArrayList<Employee>();
        Conexion conexion = new Conexion(this.host);
        conexion.Conectar();
        ResultSet resultado = null;
        String Filtro = "" + texto + "_%";
        try {
            conexion.getStmt();
            switch (item) {
                case 0:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.NOMBRE_EMP like " + '"' + Filtro + '"');
                    break;
                case 1:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.APELLIDO_EMP like " + '"' + Filtro + '"');
                    break;
                case 2:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.POSICION_EMP like " + '"' + Filtro + '"');
                    break;
                case 3:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.EXTENSION_EMP like " + '"' + Filtro + '"');
                    break;
                case 4:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.TELFTRAB_EMP like " + '"' + Filtro + '"');
                    break;
                case 5:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.TELFPERS_EMP like " + '"' + Filtro + '"');
                    break;
                case 6:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.TELFCASA_EMP like " + '"' + Filtro + '"');
                    break;
                case 7:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.EMAIL_EMP like " + '"' + Filtro + '"');
                    break;
                case 8:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.EMAIL2_EMP like " + '"' + Filtro + '"');
                    break;
                case 9:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND e.LOCACIONOFICINA_EMP like " + '"' + Filtro + '"');
                    break;
                case 10:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND (e.SUELDO_EMP LIKE '"+ Filtro +"' OR e.SUELDO_EMP = '"+ texto +"')");
                    break;
                case 11:
                    resultado = conexion.getStmt().executeQuery("SELECT e.ID_EMP, e.NRO_EMP, e.NOMBRE_EMP, e.APELLIDO_EMP, e.POSICION_EMP, e.EXTENSION_EMP,"
                            + " e.TELFTRAB_EMP, e.TELFPERS_EMP, e.TELFCASA_EMP, e.EMAIL_EMP, e.EMAIL2_EMP, e.LOCACIONOFICINA_EMP,"
                            + " e.SUELDO_EMP, e.SOBRETIEMPO_EMP, d.DESCRIPCION_DEPT, e.ACTIVO"
                            + " FROM EMPLEADO e JOIN DEPARTAMENTO d"
                            + " ON (d.ID_DEPT = e.ID_DEPT)"
                            + " WHERE e.ACTIVO <> 0 AND (e.SOBRETIEMPO_EMP LIKE '"+ Filtro +"' OR e.SOBRETIEMPO_EMP = '"+ texto +"')");
                    break;
                default:
                    break;
            }

            while (resultado.next()) {
                Employee emp = new Employee();
                //emp.setIdDepartment(resultado.getInt("ID_DEPT"));
                emp.setIdEmployee(resultado.getInt("ID_EMP"));
                emp.setNroEmployee(resultado.getString("NRO_EMP"));
                emp.setNomEmployee(resultado.getString("NOMBRE_EMP"));
                emp.setApeEmployee(resultado.getString("APELLIDO_EMP"));
                emp.setPosEmployee(resultado.getString("POSICION_EMP"));
                emp.setExtEmployee(resultado.getString("EXTENSION_EMP"));
                emp.setTelftrabEmployee(resultado.getString("TELFTRAB_EMP"));
                emp.setTelfpersEmployee(resultado.getString("TELFPERS_EMP"));
                emp.setTelfcasaEmployee(resultado.getString("TELFCASA_EMP"));
                emp.setEmailEmployee(resultado.getString("EMAIL_EMP"));
                emp.setFaxEmployee(resultado.getString("EMAIL2_EMP"));
                emp.setLocOficEmployee(resultado.getString("LOCACIONOFICINA_EMP"));
                emp.setSalarioHoraEmployee(resultado.getFloat("SUELDO_EMP"));
                emp.setSobretiempo1Employee(resultado.getFloat("SOBRETIEMPO_EMP"));
                emp.setNameDept(resultado.getString("DESCRIPCION_DEPT"));

                emp.setActivoEmployee(resultado.getInt("ACTIVO"));
                listaEmp.add(emp);
            }

            return listaEmp;

        } catch (SQLException ex) {
            System.err.println("Error en devolver registros ARTICULOS: " + ex.getMessage());
            ex.printStackTrace();

            return new ArrayList<Employee>();
        }
    }

}
