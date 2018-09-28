/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class ReportsExcel {
    private String path;
    String host;
    
    public ReportsExcel(){
        
    }
    
    public ReportsExcel(String hostname){
        this.host = hostname;
    }
    
    public boolean escribirExcelArticulos(ArrayList<Article> arts)
    {
	path="src/Articulos.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID ARTICULO\tPROVEEDOR\tNUMERO\tDESCRIPCION\tESPECIFICACIONES\tFABRICANTE\tUNIDAD MEDIDA\tCOSTO ESTANDAR\tMAXIMO\t"
                    + "PUNTO REORDEN\tCANTIDAD REORDEN\tMINIMO\tTIEMPO ENTREGA\tNOTAS\tSTOCK\tDESCRIPCION STOCK\n");
            for(Article c: arts){
                e.write(c.getIdArt()+"\t"+c.getDescProv()+"\t"+c.getNroArt()+"\t"+c.getDescArt()+"\t"+c.getEspecificacionesArt()+"\t"+c.getFabricante()+"\t"+
                        c.getUnidaMedida()+"\t"+c.getCostoEstandar()+"\t"+c.getMaximo()+"\t"+c.getPuntoReorden()+"\t"+c.getCantidadReorden()+"\t"+
                        c.getMinimo()+"\t"+c.getNroDias()+"\t"+c.getNotas()+"\t"+c.getCantidad()+"\t"+c.getDescripCantidad()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelDepartamentos(ArrayList<Department> deps)
    {
	path="src/Departamentos.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID DEPARTAMENTO\tNUMERO\tDESCRIPCION\n");
            for(Department d: deps){
                e.write(d.getIdDepartment()+"\t"+d.getNroDepartment()+"\t"+d.getDescDepartment()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelEmpleados(ArrayList<Employee> emps)
    {
	path="src/Empleados.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID EMPLEADO\tDEPARTAMENTO\tNUMERO\tNOMBRE\tAPELLIDO\tCARGO\tTELF. TRABAJO\tEXTENSION\tTELF. PERSONAL\tTELF. CASA\t"
                    + "EAMIL 1\tEMAIL 2\tDIRECCION OFICINA\tSUELDO\tSOBRETIEMPO\n");
            for(Employee em: emps){
                e.write(em.getIdEmployee()+"\t"+em.getNameDept()+"\t"+em.getNroEmployee()+"\t"+em.getNomEmployee()+"\t"+em.getApeEmployee()+"\t"
                        +em.getPosEmployee()+"\t"+em.getTelftrabEmployee()+"\t"+em.getExtEmployee()+"\t"+em.getTelfpersEmployee()+"\t"
                        +em.getTelfcasaEmployee()+"\t"+em.getEmailEmployee()+"\t"+em.getFaxEmployee()+"\t"+em.getLocOficEmployee()+"\t"
                        +em.getSalarioHoraEmployee()+"\t"+em.getSobretiempo1Employee()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelEquipos(ArrayList<Equipment> equips)
    {
	path="src/Equipos.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID EQUIPO\tLOCACION\tEMPLEADO\tEQUIPO PADRE\tNUMERO\tMODELO\tSERIE\tTIPO\tESTADO\tFABRICANTE\t"
                    + "FECHA COMPRA\tFECHA INICIO\tFECHA VENTA\tCONTRATISTA\tPIEZAS\n");
            for(Equipment eq: equips){
                e.write(eq.getIdEquipment()+"\t"+eq.getDescLoc()+"\t"+eq.getDescEmple()+"\t"+eq.getDescEquipPadre()+"\t"+eq.getNroEquipment()+"\t"
                        +eq.getNroModEquipment()+"\t"+eq.getNroSerieEquipment()+"\t"+eq.getTipoEquipment()+"\t"+eq.getEstadoEquipment()+"\t"
                        +eq.getFabricEquipment()+"\t"+eq.getFechaCompEquipment()+"\t"+eq.getFechaIniEquipment()+"\t"+eq.getFechaVentEquipment()+"\t"
                        +eq.getContratistaEquipment()+"\t"+eq.getPiezas()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelInstrucciones(ArrayList<Instruction> insts)
    {
	path="src/Instrucciones.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID INSTRUCCION\tNUMERO\tDESCRIPCION\tHORAS\tNOTAS\n");
            for(Instruction i: insts){
                e.write(i.getIdInst()+"\t"+i.getNroInst()+"\t"+i.getDescInst()+"\t"+i.getHorasInst()+"\t"+i.getNotasInst()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelLocaciones(ArrayList<Location> locs)
    {
	path="src/Locaciones.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID LOCACION\tDEPARTAMENTO\tNUMERO LOCACION\tDESCRIPCION\n");
            for(Location l: locs){
                e.write(l.getIdLocation()+"\t"+l.getNameDepartment()+"\t"+l.getNroLocation()+"\t"+l.getDescLocation()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelProveedores(ArrayList<Supplier> sups)
    {
	path="src/Proveedores.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID PROVEEDOR\tNUMERO PROVEEDOR\tNOMBRE\tCIUDAD\tDIRECCION\tTELEFONO\tEMAIL 1\tEMAIL2\n");
            for(Supplier s: sups){
                e.write(s.getIdSupplier()+"\t"+s.getNroSupplier()+"\t"+s.getNameSupplier()+"\t"+s.getCitySupplier()+"\t"
                        +s.getDirSupplier()+"\t"+s.getTelfSupplier()+"\t"+s.getEmailSupplier()+"\t"+s.getEmail2Supplier()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelSecuencias(ArrayList<Sequence> secs)
    {
	path="src/Secuencias.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID SECUENCIA\tINSTRUCCION\tNUMERO\tDESCRIPCION\n");
            for(Sequence s: secs){
                e.write(s.getIdSec()+"\t"+s.getDescInst()+"\t"+s.getNroSec()+"\t"+s.getDescSec()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelMantenimientos(ArrayList<Mantenimientos> mants)
    {
	path="src/Mantenimientos.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID MANTENIMIENTO\tID EQUIPO\tID LOCACION\tNRO TAREA\tDESCRIPCION\tOFICIO\tFRECUENCIA\tDIAS\tDURACION TAREA\tFECHA INICIO\tFECHA PROG INICIO\tFECHA PROG TERMINO\tPROXIMA FECHA MANT\tHORAS PROGRAMADAS\n");
            for(Mantenimientos m: mants){
                e.write(m.getIdMantenimiento()+"\t"+m.getIdEquipo()+"\t"+m.getIdLocacion()+"\t"+m.getNroTareaMant()+"\t"+
                        m.getDescMantenimiento()+"\t"+m.getOficioMantenimiento()+"\t"+m.getFrecuenciaMant()+"\t"+m.getDiasMant()+"\t"+
                        m.getDurTareaMant()+"\t"+m.getFechIniMantenimiento()+"\t"+m.getFechProgInicMant()+"\t"+m.getFechProgTermMant()+"\t"+
                        m.getFechProximaMant()+"\t"+m.getHorasProgramadas()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelOrdenesTrabajo(ArrayList<OrdenTrabajos> ords)
    {
	path="src/OrdenesTrabajo.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID ORDEN\tID MANTENIMIENTO\tNUMERO ORDEN\tDESCRIPCION\tESTADO\tTIPO\tPRIORIDAD\tFECHA SOLICITUD\tFECHA REQUERIDA\tRESPUESTA\tINICIO ORDEN\tTERMINO ORDEN\tFECHA ENTREGA\tDURACION DIAS\tACEPTADO POR\tFALLAS\tDESCRIPCION CAUSAS\tACCION REALIZADA\tPREVENCION TOMADA\n");
            for(OrdenTrabajos ord: ords){
                e.write(ord.getIdOrdtr()+"\t"+ord.getIdMant()+"\t"+ord.getNroOrdtr()+"\t"+ord.getDescOrdtr()+"\t"+ord.getEstOrdtr()+"\t"+
                        ord.getTipoOrdtr()+"\t"+ord.getPriorOrdtr()+"\t"+ord.getFechHorSolicitudOrdtr()+"\t"+ord.getFechHorReqOrdtr()+"\t"+
                        ord.getRespOrdtr()+"\t"+ord.getInicioOrdtr()+"\t"+ord.getTermOrdtr()+"\t"+ord.getFechHoraEntOrdtr()+"\t"+
                        ord.getDuracionDiasOrdtr()+"\t"+ord.getAceptPorOrdtr()+"\t"+ord.getFallaOrdtr()+"\t"+ord.getDescCausaOrdtr()+"\t"+
                        ord.getAccionRealizOrdtr()+"\t"+ord.getPrevenTomadaOrdtr()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelOperabilidad(ArrayList<OPERABILIDAD> ops)
    {
	path="src/Operabilidad.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID ORDEN\tID MANTENIMIENTO\tNUMERO ORDEN\tDESCRIPCION\tESTADO\tTIPO\tPRIORIDAD\tFECHA SOLICITUD\tFECHA REQUERIDA\tRESPUESTA\tINICIO ORDEN\tTERMINO ORDEN\tFECHA ENTREGA\tDURACION DIAS\tACEPTADO POR\tFALLAS\tDESCRIPCION CAUSAS\tACCION REALIZADA\tPREVENCION TOMADA\n");
            for(OPERABILIDAD op: ops){
                e.write(ord.getIdOrdtr()+"\t"+ord.getIdMant()+"\t"+ord.getNroOrdtr()+"\t"+ord.getDescOrdtr()+"\t"+ord.getEstOrdtr()+"\t"+
                        ord.getTipoOrdtr()+"\t"+ord.getPriorOrdtr()+"\t"+ord.getFechHorSolicitudOrdtr()+"\t"+ord.getFechHorReqOrdtr()+"\t"+
                        ord.getRespOrdtr()+"\t"+ord.getInicioOrdtr()+"\t"+ord.getTermOrdtr()+"\t"+ord.getFechHoraEntOrdtr()+"\t"+
                        ord.getDuracionDiasOrdtr()+"\t"+ord.getAceptPorOrdtr()+"\t"+ord.getFallaOrdtr()+"\t"+ord.getDescCausaOrdtr()+"\t"+
                        ord.getAccionRealizOrdtr()+"\t"+ord.getPrevenTomadaOrdtr()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    public boolean escribirExcelPeriodosOperabilidad(ArrayList<OrdenTrabajos> ords)
    {
	path="src/PeriodosOperabilidad.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID ORDEN\tID MANTENIMIENTO\tNUMERO ORDEN\tDESCRIPCION\tESTADO\tTIPO\tPRIORIDAD\tFECHA SOLICITUD\tFECHA REQUERIDA\tRESPUESTA\tINICIO ORDEN\tTERMINO ORDEN\tFECHA ENTREGA\tDURACION DIAS\tACEPTADO POR\tFALLAS\tDESCRIPCION CAUSAS\tACCION REALIZADA\tPREVENCION TOMADA\n");
            for(OrdenTrabajos ord: ords){
                e.write(ord.getIdOrdtr()+"\t"+ord.getIdMant()+"\t"+ord.getNroOrdtr()+"\t"+ord.getDescOrdtr()+"\t"+ord.getEstOrdtr()+"\t"+
                        ord.getTipoOrdtr()+"\t"+ord.getPriorOrdtr()+"\t"+ord.getFechHorSolicitudOrdtr()+"\t"+ord.getFechHorReqOrdtr()+"\t"+
                        ord.getRespOrdtr()+"\t"+ord.getInicioOrdtr()+"\t"+ord.getTermOrdtr()+"\t"+ord.getFechHoraEntOrdtr()+"\t"+
                        ord.getDuracionDiasOrdtr()+"\t"+ord.getAceptPorOrdtr()+"\t"+ord.getFallaOrdtr()+"\t"+ord.getDescCausaOrdtr()+"\t"+
                        ord.getAccionRealizOrdtr()+"\t"+ord.getPrevenTomadaOrdtr()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
    
    public boolean escribirExcelPedidoMateriales(ArrayList<OrdenTrabajos> ords)
    {
	path="src/PedidosMateriales.xls";
	try {
            FileWriter e = new FileWriter(path, false);
            e.write("ID ORDEN\tID MANTENIMIENTO\tNUMERO ORDEN\tDESCRIPCION\tESTADO\tTIPO\tPRIORIDAD\tFECHA SOLICITUD\tFECHA REQUERIDA\tRESPUESTA\tINICIO ORDEN\tTERMINO ORDEN\tFECHA ENTREGA\tDURACION DIAS\tACEPTADO POR\tFALLAS\tDESCRIPCION CAUSAS\tACCION REALIZADA\tPREVENCION TOMADA\n");
            for(OrdenTrabajos ord: ords){
                e.write(ord.getIdOrdtr()+"\t"+ord.getIdMant()+"\t"+ord.getNroOrdtr()+"\t"+ord.getDescOrdtr()+"\t"+ord.getEstOrdtr()+"\t"+
                        ord.getTipoOrdtr()+"\t"+ord.getPriorOrdtr()+"\t"+ord.getFechHorSolicitudOrdtr()+"\t"+ord.getFechHorReqOrdtr()+"\t"+
                        ord.getRespOrdtr()+"\t"+ord.getInicioOrdtr()+"\t"+ord.getTermOrdtr()+"\t"+ord.getFechHoraEntOrdtr()+"\t"+
                        ord.getDuracionDiasOrdtr()+"\t"+ord.getAceptPorOrdtr()+"\t"+ord.getFallaOrdtr()+"\t"+ord.getDescCausaOrdtr()+"\t"+
                        ord.getAccionRealizOrdtr()+"\t"+ord.getPrevenTomadaOrdtr()+"\n");
            }
	    e.close();
            return true;
        } catch (IOException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            return false;
	}	
    }
    
}

