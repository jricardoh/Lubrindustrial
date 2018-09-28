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
public class Supplier {
    
    private int idSupplier;
    private String nroSupplier;
    private String nameSupplier;
    private String dirSupplier;
    private String citySupplier;
    private String emailSupplier;
    private String email2Supplier;
    private String telfSupplier;
    private int activo;

    public Supplier() {
    }

    public Supplier(int idSupplier, String nroSupplier, String nameSupplier, String dirSupplier, String citySupplier, String emailSupplier, String email2Supplier, String telfSupplier, int activo) {
        this.idSupplier = idSupplier;
        this.nroSupplier = nroSupplier;
        this.nameSupplier = nameSupplier;
        this.dirSupplier = dirSupplier;
        this.citySupplier = citySupplier;
        this.emailSupplier = emailSupplier;
        this.email2Supplier = email2Supplier;
        this.telfSupplier = telfSupplier;
        this.activo = activo;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNroSupplier() {
        return nroSupplier;
    }

    public void setNroSupplier(String nroSupplier) {
        this.nroSupplier = nroSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getDirSupplier() {
        return dirSupplier;
    }

    public void setDirSupplier(String dirSupplier) {
        this.dirSupplier = dirSupplier;
    }

    public String getCitySupplier() {
        return citySupplier;
    }

    public void setCitySupplier(String citySupplier) {
        this.citySupplier = citySupplier;
    }

    public String getEmailSupplier() {
        return emailSupplier;
    }

    public void setEmailSupplier(String emailSupplier) {
        this.emailSupplier = emailSupplier;
    }

    public String getEmail2Supplier() {
        return email2Supplier;
    }

    public void setEmail2Supplier(String email2Supplier) {
        this.email2Supplier = email2Supplier;
    }

    public String getTelfSupplier() {
        return telfSupplier;
    }

    public void setTelfSupplier(String telfSupplier) {
        this.telfSupplier = telfSupplier;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
    
}
