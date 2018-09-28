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
public class Sequence {
    private int idSec;
    private int idInst;
    private String descInst;
    private String nroSec;
    private String descSec;
    private int activo;

    public Sequence() {
    }

    public Sequence(int idSec, int idInst, String descInst, String nroSec, String descSec, int activo) {
        this.idSec = idSec;
        this.idInst = idInst;
        this.descInst = descInst;
        this.nroSec = nroSec;
        this.descSec = descSec;
        this.activo = activo;
    }

    

    public int getIdSec() {
        return idSec;
    }

    public void setIdSec(int idSec) {
        this.idSec = idSec;
    }

    public int getIdInst() {
        return idInst;
    }

    public void setIdInst(int idInst) {
        this.idInst = idInst;
    }

    public String getDescInst() {
        return descInst;
    }

    public void setDescInst(String descInst) {
        this.descInst = descInst;
    }

    public String getNroSec() {
        return nroSec;
    }

    public void setNroSec(String nroSec) {
        this.nroSec = nroSec;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getDescSec() {
        return descSec;
    }

    public void setDescSec(String descSec) {
        this.descSec = descSec;
    }
    
    
}
