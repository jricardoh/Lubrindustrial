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
public class Location {
    private int idLocation;
    private int idDepartment;
    private String nroLocation;
    private String descLocation;
    private int activoLocation;
    private String nameDepartment;

    public Location() {
    }

    public Location(int idLocation, int idDepartment, String nroLocation, String descLocation, int activoLocation, String nameDepartment) {
        this.idLocation = idLocation;
        this.idDepartment = idDepartment;
        this.nroLocation = nroLocation;
        this.descLocation = descLocation;
        this.activoLocation = activoLocation;
        this.nameDepartment = nameDepartment;
    }

    
    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNroLocation() {
        return nroLocation;
    }

    public void setNroLocation(String nroLocation) {
        this.nroLocation = nroLocation;
    }

    public String getDescLocation() {
        return descLocation;
    }

    public void setDescLocation(String descLocation) {
        this.descLocation = descLocation;
    }

    public int getActivoLocation() {
        return activoLocation;
    }

    public void setActivoLocation(int activoLocation) {
        this.activoLocation = activoLocation;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }
    
    
}
