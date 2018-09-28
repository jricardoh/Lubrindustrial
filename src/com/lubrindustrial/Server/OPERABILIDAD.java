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
public class OPERABILIDAD {
    private int idOp;
    private int idEq;
    private String descripcionOperabilidad;
    private String descEquipo;

    public OPERABILIDAD() {
    }

    public OPERABILIDAD(int idOp, int idEq, String descripcion, String descEquipo) {
        this.idOp = idOp;
        this.idEq = idEq;
        this.descripcionOperabilidad = descripcion;
        this.descEquipo = descEquipo;
    }

    public int getIdOp() {
        return idOp;
    }

    public void setIdOp(int idOp) {
        this.idOp = idOp;
    }

    public int getIdEq() {
        return idEq;
    }

    public void setIdEq(int idEq) {
        this.idEq = idEq;
    }

    public String getDescripcion() {
        return descripcionOperabilidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcionOperabilidad = descripcion;
    }

    public String getDescEquipo() {
        return descEquipo;
    }

    public void setDescEquipo(String descEquipo) {
        this.descEquipo = descEquipo;
    }
    
    
}
