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
public class Instruction {
    private int idInst;
    private String nroInst;
    private String descInst;
    private float horasInst;
    private String notasInst;
    private int activo;

    public Instruction() {
    }

    public Instruction(int idInst, String nroInst, String descInst, float horasInst, String notasInst, int activo) {
        this.idInst = idInst;
        this.nroInst = nroInst;
        this.descInst = descInst;
        this.horasInst = horasInst;
        this.notasInst = notasInst;
        this.activo = activo;
    }

    public int getIdInst() {
        return idInst;
    }

    public void setIdInst(int idInst) {
        this.idInst = idInst;
    }

    public String getNroInst() {
        return nroInst;
    }

    public void setNroInst(String nroInst) {
        this.nroInst = nroInst;
    }

    public String getDescInst() {
        return descInst;
    }

    public void setDescInst(String descInst) {
        this.descInst = descInst;
    }

    public float getHorasInst() {
        return horasInst;
    }

    public void setHorasInst(float horasInst) {
        this.horasInst = horasInst;
    }

    public String getNotasInst() {
        return notasInst;
    }

    public void setNotasInst(String notasInst) {
        this.notasInst = notasInst;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
}
