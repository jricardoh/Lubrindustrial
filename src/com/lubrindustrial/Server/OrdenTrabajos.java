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
public class OrdenTrabajos {
    private int idMant;
    private int idOrdtr;
    private String nroOrdtr;
    private String descOrdtr;
    private String estOrdtr;
    private String tipoOrdtr;
    private String priorOrdtr;
    private String fechHorSolicitudOrdtr;
    private String fechHorReqOrdtr;
    private String respOrdtr;
    private String inicioOrdtr;
    private String termOrdtr;
    private String fechHoraEntOrdtr;
    private float duracionDiasOrdtr;
    private String aceptPorOrdtr;
    private String fallaOrdtr;
    private String descCausaOrdtr;
    private String accionRealizOrdtr;
    private String prevenTomadaOrdtr;
    public OrdenTrabajos(){}

    public OrdenTrabajos(int idMant, int idOrdtr, String nroOrdtr, String descOrdtr, String estOrdtr, String tipoOrdtr, String priorOrdtr, String fechHorSolicitudOrdtr, String fechHorReqOrdtr, String respOrdtr, String inicioOrdtr, String termOrdtr, String fechHoraEntOrdtr, float duracionDiasOrdtr, String aceptPorOrdtr, String fallaOrdtr, String descCausaOrdtr, String accionRealizOrdtr, String prevenTomadaOrdtr) {
        this.idMant = idMant;
        this.idOrdtr = idOrdtr;
        this.nroOrdtr = nroOrdtr;
        this.descOrdtr = descOrdtr;
        this.estOrdtr = estOrdtr;
        this.tipoOrdtr = tipoOrdtr;
        this.priorOrdtr = priorOrdtr;
        this.fechHorSolicitudOrdtr = fechHorSolicitudOrdtr;
        this.fechHorReqOrdtr = fechHorReqOrdtr;
        this.respOrdtr = respOrdtr;
        this.inicioOrdtr = inicioOrdtr;
        this.termOrdtr = termOrdtr;
        this.fechHoraEntOrdtr = fechHoraEntOrdtr;
        this.duracionDiasOrdtr = duracionDiasOrdtr;
        this.aceptPorOrdtr = aceptPorOrdtr;
        this.fallaOrdtr = fallaOrdtr;
        this.descCausaOrdtr = descCausaOrdtr;
        this.accionRealizOrdtr = accionRealizOrdtr;
        this.prevenTomadaOrdtr = prevenTomadaOrdtr;
    }

    public String getTipoOrdtr() {
        return tipoOrdtr;
    }

    public void setTipoOrdtr(String tipoOrdtr) {
        this.tipoOrdtr = tipoOrdtr;
    }

    

    public int getIdMant() {
        return idMant;
    }

    public void setIdMant(int idMant) {
        this.idMant = idMant;
    }

    public int getIdOrdtr() {
        return idOrdtr;
    }

    public void setIdOrdtr(int idOrdtr) {
        this.idOrdtr = idOrdtr;
    }

    public String getNroOrdtr() {
        return nroOrdtr;
    }

    public void setNroOrdtr(String nroOrdtr) {
        this.nroOrdtr = nroOrdtr;
    }

    public String getDescOrdtr() {
        return descOrdtr;
    }

    public void setDescOrdtr(String descOrdtr) {
        this.descOrdtr = descOrdtr;
    }

    public String getEstOrdtr() {
        return estOrdtr;
    }

    public void setEstOrdtr(String estOrdtr) {
        this.estOrdtr = estOrdtr;
    }

    public String getPriorOrdtr() {
        return priorOrdtr;
    }

    public void setPriorOrdtr(String priorOrdtr) {
        this.priorOrdtr = priorOrdtr;
    }

    public String getFechHorSolicitudOrdtr() {
        return fechHorSolicitudOrdtr;
    }

    public void setFechHorSolicitudOrdtr(String fechHorSolicitudOrdtr) {
        this.fechHorSolicitudOrdtr = fechHorSolicitudOrdtr;
    }

    public String getFechHorReqOrdtr() {
        return fechHorReqOrdtr;
    }

    public void setFechHorReqOrdtr(String fechHorReqOrdtr) {
        this.fechHorReqOrdtr = fechHorReqOrdtr;
    }

    public String getRespOrdtr() {
        return respOrdtr;
    }

    public void setRespOrdtr(String respOrdtr) {
        this.respOrdtr = respOrdtr;
    }

    public String getInicioOrdtr() {
        return inicioOrdtr;
    }

    public void setInicioOrdtr(String inicioOrdtr) {
        this.inicioOrdtr = inicioOrdtr;
    }

    public String getTermOrdtr() {
        return termOrdtr;
    }

    public void setTermOrdtr(String termOrdtr) {
        this.termOrdtr = termOrdtr;
    }

    public String getFechHoraEntOrdtr() {
        return fechHoraEntOrdtr;
    }

    public void setFechHoraEntOrdtr(String fechHoraEntOrdtr) {
        this.fechHoraEntOrdtr = fechHoraEntOrdtr;
    }

    public float getDuracionDiasOrdtr() {
        return duracionDiasOrdtr;
    }

    public void setDuracionDiasOrdtr(float duracionDiasOrdtr) {
        this.duracionDiasOrdtr = duracionDiasOrdtr;
    }

    public String getAceptPorOrdtr() {
        return aceptPorOrdtr;
    }

    public void setAceptPorOrdtr(String aceptPorOrdtr) {
        this.aceptPorOrdtr = aceptPorOrdtr;
    }

    public String getFallaOrdtr() {
        return fallaOrdtr;
    }

    public void setFallaOrdtr(String fallaOrdtr) {
        this.fallaOrdtr = fallaOrdtr;
    }

    public String getDescCausaOrdtr() {
        return descCausaOrdtr;
    }

    public void setDescCausaOrdtr(String descCausaOrdtr) {
        this.descCausaOrdtr = descCausaOrdtr;
    }

    public String getAccionRealizOrdtr() {
        return accionRealizOrdtr;
    }

    public void setAccionRealizOrdtr(String accionRealizOrdtr) {
        this.accionRealizOrdtr = accionRealizOrdtr;
    }

    public String getPrevenTomadaOrdtr() {
        return prevenTomadaOrdtr;
    }

    public void setPrevenTomadaOrdtr(String prevenTomadaOrdtr) {
        this.prevenTomadaOrdtr = prevenTomadaOrdtr;
    }
    
}
