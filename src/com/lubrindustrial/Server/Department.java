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
public class Department {
    
    private int idDepartment;
    private String nroDepartment;
    private String descDepartment;
    private int activoDepartment;

    public Department() {
    }

    public Department(int idDepartment, String nroDepartment, String descDepartment, int activoDepartment) {
        this.idDepartment = idDepartment;
        this.nroDepartment = nroDepartment;
        this.descDepartment = descDepartment;
        this.activoDepartment = activoDepartment;
    }

    

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNroDepartment() {
        return nroDepartment;
    }

    public void setNroDepartment(String nroDepartment) {
        this.nroDepartment = nroDepartment;
    }

    public String getDescDepartment() {
        return descDepartment;
    }

    public void setDescDepartment(String descDepartment) {
        this.descDepartment = descDepartment;
    }

    public int getActivoDepartment() {
        return activoDepartment;
    }

    public void setActivoDepartment(int activoDepartment) {
        this.activoDepartment = activoDepartment;
    }
    
    
    
}
