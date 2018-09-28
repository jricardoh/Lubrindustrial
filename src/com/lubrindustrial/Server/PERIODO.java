/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

/**
 *
 * @author Marcelo
 */
public class PERIODO {
    private int idOp;
    private String fechaInicio;
    private String fechaFin;
    private String descipcionPeriodo;
    private float horasPeriodo;
    private int actividadPeriodo; // se refiere al estado ya sea pasivo o activo de la operabilidad del equipo
    private int diasDiferencia; // para obtener la diferencia entre dias de 2 fechas

    public PERIODO() {
    }

    public PERIODO(int idOp, String fechaInicio, String fechaFin, String descipcionPeriodo, float horasPeriodo, int actividadPeriodo, int diasDiferencia) {
        this.idOp = idOp;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descipcionPeriodo = descipcionPeriodo;
        this.horasPeriodo = horasPeriodo;
        this.actividadPeriodo = actividadPeriodo;
        this.diasDiferencia = diasDiferencia;
    }

    

    public int getIdOp() {
        return idOp;
    }

    public void setIdOp(int idOp) {
        this.idOp = idOp;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescipcionPeriodo() {
        return descipcionPeriodo;
    }

    public void setDescipcionPeriodo(String descipcionPeriodo) {
        this.descipcionPeriodo = descipcionPeriodo;
    }

    public float getHorasPeriodo() {
        return horasPeriodo;
    }

    public void setHorasPeriodo(float horasPeriodo) {
        this.horasPeriodo = horasPeriodo;
    }

    public int getActividadPeriodo() {
        return actividadPeriodo;
    }

    public void setActividadPeriodo(int actividadPeriodo) {
        this.actividadPeriodo = actividadPeriodo;
    }

    public int getDiasDiferencia() {
        return diasDiferencia;
    }

    public void setDiasDiferencia(int diasDiferencia) {
        this.diasDiferencia = diasDiferencia;
    }
    
    
    
}
