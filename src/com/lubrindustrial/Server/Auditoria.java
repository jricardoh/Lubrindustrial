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
public class Auditoria {
    private int idAud;
    private int idUsu;
    private String nombreUsu;
    private String apellidoUsu;
    private String tablaAfectada;
    private String accionRealizada; // solo para modificaciones y eliminaciones
    private String descripcion;

    public Auditoria() {
    }

    public Auditoria(int idAud, int idUsu, String nombreUsu, String apellidoUsu, String tablaAfectada, String accionRealizada, String descripcion) {
        this.idAud = idAud;
        this.idUsu = idUsu;
        this.nombreUsu = nombreUsu;
        this.apellidoUsu = apellidoUsu;
        this.tablaAfectada = tablaAfectada;
        this.accionRealizada = accionRealizada;
        this.descripcion = descripcion;
    }

    

    public int getIdAud() {
        return idAud;
    }

    public void setIdAud(int idAud) {
        this.idAud = idAud;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getApellidoUsu() {
        return apellidoUsu;
    }

    public void setApellidoUsu(String apellidoUsu) {
        this.apellidoUsu = apellidoUsu;
    }

    public String getTablaAfectada() {
        return tablaAfectada;
    }

    public void setTablaAfectada(String tablaAfectada) {
        this.tablaAfectada = tablaAfectada;
    }

    public String getAccionRealizada() {
        return accionRealizada;
    }

    public void setAccionRealizada(String accionRealizada) {
        this.accionRealizada = accionRealizada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
}
