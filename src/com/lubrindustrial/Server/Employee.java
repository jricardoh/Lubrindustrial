/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lubrindustrial.Server;

/**
 *
 * @author RH
 */
public class Employee {
    private int idEmployee;
    private int idDepartment;
    private String nroEmployee;
    private String nomEmployee;
    private String apeEmployee;
    private String posEmployee;
    private String extEmployee;
    private String telftrabEmployee;
    private String telfpersEmployee;
    private String telfcasaEmployee;
    private String emailEmployee;
    private String email2Employee;
    private String locOficEmployee;
    private float sueldoEmployee;
    private float sobretiempoEmployee;
    private int activoEmployee;
    private String nameDept;

    public Employee() {
    }

    public Employee(int idEmployee, int idDepartment, String nroEmployee, String nomEmployee, String apeEmployee, String posEmployee, String extEmployee, String telftrabEmployee, String telfpersEmployee, String telfcasaEmployee, String emailEmployee, String faxEmployee, String locOficEmployee, float salarioHoraEmployee, float sobretiempo1Employee, float sobretiempo2Employee, float sobretiempo3Employee, int activoEmployee, String nameDept) {
        this.idEmployee = idEmployee;
        this.idDepartment = idDepartment;
        this.nroEmployee = nroEmployee;
        this.nomEmployee = nomEmployee;
        this.apeEmployee = apeEmployee;
        this.posEmployee = posEmployee;
        this.extEmployee = extEmployee;
        this.telftrabEmployee = telftrabEmployee;
        this.telfpersEmployee = telfpersEmployee;
        this.telfcasaEmployee = telfcasaEmployee;
        this.emailEmployee = emailEmployee;
        this.email2Employee = faxEmployee;
        this.locOficEmployee = locOficEmployee;
        this.sueldoEmployee = salarioHoraEmployee;
        this.sobretiempoEmployee = sobretiempo1Employee;
        this.activoEmployee = activoEmployee;
        this.nameDept = nameDept;
    }

    

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNroEmployee() {
        return nroEmployee;
    }

    public void setNroEmployee(String nroEmployee) {
        this.nroEmployee = nroEmployee;
    }

    public String getNomEmployee() {
        return nomEmployee;
    }

    public void setNomEmployee(String nomEmployee) {
        this.nomEmployee = nomEmployee;
    }

    public String getApeEmployee() {
        return apeEmployee;
    }

    public void setApeEmployee(String apeEmployee) {
        this.apeEmployee = apeEmployee;
    }

    public String getPosEmployee() {
        return posEmployee;
    }

    public void setPosEmployee(String posEmployee) {
        this.posEmployee = posEmployee;
    }

    public String getExtEmployee() {
        return extEmployee;
    }

    public void setExtEmployee(String extEmployee) {
        this.extEmployee = extEmployee;
    }

    public String getTelftrabEmployee() {
        return telftrabEmployee;
    }

    public void setTelftrabEmployee(String telftrabEmployee) {
        this.telftrabEmployee = telftrabEmployee;
    }

    public String getTelfpersEmployee() {
        return telfpersEmployee;
    }

    public void setTelfpersEmployee(String telfpersEmployee) {
        this.telfpersEmployee = telfpersEmployee;
    }

    public String getTelfcasaEmployee() {
        return telfcasaEmployee;
    }

    public void setTelfcasaEmployee(String telfcasaEmployee) {
        this.telfcasaEmployee = telfcasaEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getFaxEmployee() {
        return email2Employee;
    }

    public void setFaxEmployee(String faxEmployee) {
        this.email2Employee = faxEmployee;
    }

    public String getLocOficEmployee() {
        return locOficEmployee;
    }

    public void setLocOficEmployee(String locOficEmployee) {
        this.locOficEmployee = locOficEmployee;
    }

    public float getSalarioHoraEmployee() {
        return sueldoEmployee;
    }

    public void setSalarioHoraEmployee(float salarioHoraEmployee) {
        this.sueldoEmployee = salarioHoraEmployee;
    }

    public float getSobretiempo1Employee() {
        return sobretiempoEmployee;
    }

    public void setSobretiempo1Employee(float sobretiempo1Employee) {
        this.sobretiempoEmployee = sobretiempo1Employee;
    }

    public int getActivoEmployee() {
        return activoEmployee;
    }

    public void setActivoEmployee(int activoEmployee) {
        this.activoEmployee = activoEmployee;
    }

    public String getNameDept() {
        return nameDept;
    }

    public void setNameDept(String nameDept) {
        this.nameDept = nameDept;
    }

}
