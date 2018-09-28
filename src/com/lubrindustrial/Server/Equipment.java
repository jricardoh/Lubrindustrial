/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;


import java.util.Date;

/**
 *
 * @author RH
 */
public class Equipment {
    private int idEquipment;
    private int idLocation;
    private int idEmployee;
    private int idPadreEq;
    private String nroEquipment;
    private String descEquipment;
    private String nroModEquipment;
    private String nroSerieEquipment;
    private String tipoEquipment;
    private String estadoEquipment;
    private String fabricEquipment;
    private String fechaCompEquipment;
    private String fechaIniEquipment;
    private String fechaVentEquipment;
    private String contratistaEquipment;
    private int activoEquipment;
    private String piezas;
    private String foto;
    private String locDep;
    private String padre;
    private String descLoc;
    private String descEquipPadre;
    private String descEmple;

    public Equipment() {
    }

    public Equipment(int idEquipment, int idLocation, int idEmployee, int idPadreEq, String nroEquipment, String descEquipment, String nroModEquipment, String nroSerieEquipment, String tipoEquipment, String estadoEquipment, String fabricEquipment, String fechaCompEquipment, String fechaIniEquipment, String fechaVentEquipment, String contratistaEquipment, int activoEquipment, String piezas, String foto, String locDep, String padre, String descLoc, String descEquipPadre, String descEmple) {
        this.idEquipment = idEquipment;
        this.idLocation = idLocation;
        this.idEmployee = idEmployee;
        this.idPadreEq = idPadreEq;
        this.nroEquipment = nroEquipment;
        this.descEquipment = descEquipment;
        this.nroModEquipment = nroModEquipment;
        this.nroSerieEquipment = nroSerieEquipment;
        this.tipoEquipment = tipoEquipment;
        this.estadoEquipment = estadoEquipment;
        this.fabricEquipment = fabricEquipment;
        this.fechaCompEquipment = fechaCompEquipment;
        this.fechaIniEquipment = fechaIniEquipment;
        this.fechaVentEquipment = fechaVentEquipment;
        this.contratistaEquipment = contratistaEquipment;
        this.activoEquipment = activoEquipment;
        this.piezas = piezas;
        this.foto = foto;
        this.locDep = locDep;
        this.padre = padre;
        this.descLoc = descLoc;
        this.descEquipPadre = descEquipPadre;
        this.descEmple = descEmple;
    }

        

    public int getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNroEquipment() {
        return nroEquipment;
    }

    public void setNroEquipment(String nroEquipment) {
        this.nroEquipment = nroEquipment;
    }

    public String getDescEquipment() {
        return descEquipment;
    }

    public void setDescEquipment(String descEquipment) {
        this.descEquipment = descEquipment;
    }

    public String getNroModEquipment() {
        return nroModEquipment;
    }

    public void setNroModEquipment(String nroModEquipment) {
        this.nroModEquipment = nroModEquipment;
    }

    public String getNroSerieEquipment() {
        return nroSerieEquipment;
    }

    public void setNroSerieEquipment(String nroSerieEquipment) {
        this.nroSerieEquipment = nroSerieEquipment;
    }

    public String getTipoEquipment() {
        return tipoEquipment;
    }

    public void setTipoEquipment(String tipoEquipment) {
        this.tipoEquipment = tipoEquipment;
    }

    public String getEstadoEquipment() {
        return estadoEquipment;
    }

    public void setEstadoEquipment(String estadoEquipment) {
        this.estadoEquipment = estadoEquipment;
    }

    public String getFabricEquipment() {
        return fabricEquipment;
    }

    public void setFabricEquipment(String fabricEquipment) {
        this.fabricEquipment = fabricEquipment;
    }

    public String getFechaCompEquipment() {
        return fechaCompEquipment;
    }

    public void setFechaCompEquipment(String fechaCompEquipment) {
        this.fechaCompEquipment = fechaCompEquipment;
    }

    public String getFechaIniEquipment() {
        return fechaIniEquipment;
    }

    public void setFechaIniEquipment(String fechaIniEquipment) {
        this.fechaIniEquipment = fechaIniEquipment;
    }

    public String getFechaVentEquipment() {
        return fechaVentEquipment;
    }

    public void setFechaVentEquipment(String fechaVentEquipment) {
        this.fechaVentEquipment = fechaVentEquipment;
    }

    

    public String getContratistaEquipment() {
        return contratistaEquipment;
    }

    public void setContratistaEquipment(String contratistaEquipment) {
        this.contratistaEquipment = contratistaEquipment;
    }

    public int getActivoEquipment() {
        return activoEquipment;
    }

    public void setActivoEquipment(int activoEquipment) {
        this.activoEquipment = activoEquipment;
    }

    public int getIdPadreEq() {
        return idPadreEq;
    }

    public void setIdPadreEq(int idPadreEq) {
        this.idPadreEq = idPadreEq;
    }

    public String getPiezas() {
        return piezas;
    }

    public void setPiezas(String piezas) {
        this.piezas = piezas;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLocDep() {
        return locDep;
    }

    public void setLocDep(String locDep) {
        this.locDep = locDep;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getDescLoc() {
        return descLoc;
    }

    public void setDescLoc(String descLoc) {
        this.descLoc = descLoc;
    }

    public String getDescEquipPadre() {
        return descEquipPadre;
    }

    public void setDescEquipPadre(String descEquipPadre) {
        this.descEquipPadre = descEquipPadre;
    }

    public String getDescEmple() {
        return descEmple;
    }

    public void setDescEmple(String descEmple) {
        this.descEmple = descEmple;
    }
    
    

}
