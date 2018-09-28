/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

/**
 *
 * @author Jhonny
 */
public class Mantenimientos {
    private int idMantenimiento;
    private int idOrdtr;
    private int idEquipo;
    private int idLocacion;
    private String nroTareaMant;
    private String descMantenimiento;
    private String oficioMantenimiento;
    private String frecuenciaMant;
    private int diasMant;
    private int durTareaMant;
    private String fechIniMantenimiento;
    private String fechProgInicMant;
    private String fechProgTermMant;
    private String fechProximaMant;
    private int horasProgramadas;

    public Mantenimientos() {
    }

    public Mantenimientos(int idMantenimiento, int idOrdtr, int idEquipo, int idLocacion, String nroTareaMant, String descMantenimiento, String oficioMantenimiento, String frecuenciaMant, int diasMant, int durTareaMant, String fechIniMantenimiento, String fechProgInicMant, String fechProgTermMant, String fechProximaMant, int horasProgramadas) {
        this.idMantenimiento = idMantenimiento;
        this.idOrdtr = idOrdtr;
        this.idEquipo = idEquipo;
        this.idLocacion = idLocacion;
        this.nroTareaMant = nroTareaMant;
        this.descMantenimiento = descMantenimiento;
        this.oficioMantenimiento = oficioMantenimiento;
        this.frecuenciaMant = frecuenciaMant;
        this.diasMant = diasMant;
        this.durTareaMant = durTareaMant;
        this.fechIniMantenimiento = fechIniMantenimiento;
        this.fechProgInicMant = fechProgInicMant;
        this.fechProgTermMant = fechProgTermMant;
        this.fechProximaMant = fechProximaMant;
        this.horasProgramadas = horasProgramadas;
    }
    
    

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public int getIdOrdtr() {
        return idOrdtr;
    }

    public void setIdOrdtr(int idOrdtr) {
        this.idOrdtr = idOrdtr;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdLocacion() {
        return idLocacion;
    }

    public void setIdLocacion(int idLocacion) {
        this.idLocacion = idLocacion;
    }

    public String getNroTareaMant() {
        return nroTareaMant;
    }

    public void setNroTareaMant(String nroTareaMant) {
        this.nroTareaMant = nroTareaMant;
    }

    public String getDescMantenimiento() {
        return descMantenimiento;
    }

    public void setDescMantenimiento(String descMantenimiento) {
        this.descMantenimiento = descMantenimiento;
    }

    public String getOficioMantenimiento() {
        return oficioMantenimiento;
    }

    public void setOficioMantenimiento(String oficioMantenimiento) {
        this.oficioMantenimiento = oficioMantenimiento;
    }

    public String getFrecuenciaMant() {
        return frecuenciaMant;
    }

    public void setFrecuenciaMant(String frecuenciaMant) {
        this.frecuenciaMant = frecuenciaMant;
    }

    public int getDiasMant() {
        return diasMant;
    }

    public void setDiasMant(int diasMant) {
        this.diasMant = diasMant;
    }

    public int getDurTareaMant() {
        return durTareaMant;
    }

    public void setDurTareaMant(int durTareaMant) {
        this.durTareaMant = durTareaMant;
    }

    public String getFechIniMantenimiento() {
        return fechIniMantenimiento;
    }

    public void setFechIniMantenimiento(String fechIniMantenimiento) {
        this.fechIniMantenimiento = fechIniMantenimiento;
    }

    public String getFechProgInicMant() {
        return fechProgInicMant;
    }

    public void setFechProgInicMant(String fechProgInicMant) {
        this.fechProgInicMant = fechProgInicMant;
    }

    public String getFechProgTermMant() {
        return fechProgTermMant;
    }

    public void setFechProgTermMant(String fechProgTermMant) {
        this.fechProgTermMant = fechProgTermMant;
    }

    public String getFechProximaMant() {
        return fechProximaMant;
    }

    public void setFechProximaMant(String fechProximaMant) {
        this.fechProximaMant = fechProximaMant;
    }

    public int getHorasProgramadas() {
        return horasProgramadas;
    }

    public void setHorasProgramadas(int horasProgramadas) {
        this.horasProgramadas = horasProgramadas;
    }
    
    
}
