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
public class User {
    private int idUser;
    private String nomUser;
    private String apeUser;
    private String preg1User;
    private String preg2User;
    private String usuUser;
    private String passUser;
    private int activoUser;

    public User() {
    }

    public User(int idEmployee, int idDepartment, String nroEmployee, String nomEmployee, String apeEmployee, String posEmployee, String extEmployee, String telftrabEmployee, String telfpersEmployee, String telfcasaEmployee, String emailEmployee, String faxEmployee, String locOficEmployee, float salarioHoraEmployee, float sobretiempo1Employee, float sobretiempo2Employee, float sobretiempo3Employee, int activoEmployee, String nameDept) {
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.apeUser = apeUser;
        this.preg1User = preg1User;
        this.preg2User = preg2User;
        this.usuUser = usuUser;
        this.passUser = passUser;
        this.activoUser = activoUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getApeUser() {
        return apeUser;
    }

    public void setApeUser(String apeUser) {
        this.apeUser = apeUser;
    }

    public String getPreg1User() {
        return preg1User;
    }

    public void setPreg1User(String preg1User) {
        this.preg1User = preg1User;
    }

    public String getPreg2User() {
        return preg2User;
    }

    public void setPreg2User(String preg2User) {
        this.preg2User = preg2User;
    }

    public String getUsuUser() {
        return usuUser;
    }

    public void setUsuUser(String usuUser) {
        this.usuUser = usuUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public int getActivoUser() {
        return activoUser;
    }

    public void setActivoUser(int activoUser) {
        this.activoUser = activoUser;
    }

        
}
