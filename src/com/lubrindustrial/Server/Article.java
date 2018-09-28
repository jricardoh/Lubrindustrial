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
public class Article {
    
    private int idArt;
    private int idProv;
    private String descProv;
    private String nroArt;
    private String descArt;
    private String especificacionesArt;
    private String fabricante;
    private String unidaMedida;
    private float costoEstandar;
    private float maximo;
    private float puntoReorden;
    private float cantidadReorden;
    private float minimo;
    private int nroDias;
    private String notas;
    private int activo;
    // ADICIONAL **************
    private float cantidad;
    private String descripCantidad;

    public Article() {
    }

    public Article(int idArt, int idProv, String descProv, String nroArt, String descArt, String especificacionesArt, String fabricante, String unidaMedida, float costoEstandar, float maximo, float puntoReorden, float cantidadReorden, float minimo, int nroDias, String notas, int activo, float cantidad, String descripCantidad) {
        this.idArt = idArt;
        this.idProv = idProv;
        this.descProv = descProv;
        this.nroArt = nroArt;
        this.descArt = descArt;
        this.especificacionesArt = especificacionesArt;
        this.fabricante = fabricante;
        this.unidaMedida = unidaMedida;
        this.costoEstandar = costoEstandar;
        this.maximo = maximo;
        this.puntoReorden = puntoReorden;
        this.cantidadReorden = cantidadReorden;
        this.minimo = minimo;
        this.nroDias = nroDias;
        this.notas = notas;
        this.activo = activo;
        this.cantidad = cantidad;
        this.descripCantidad = descripCantidad;
    }

    

    public int getIdArt() {
        return idArt;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public String getDescProv() {
        return descProv;
    }

    public void setDescProv(String descProv) {
        this.descProv = descProv;
    }

    public String getNroArt() {
        return nroArt;
    }

    public void setNroArt(String nroArt) {
        this.nroArt = nroArt;
    }

    public String getDescArt() {
        return descArt;
    }

    public void setDescArt(String descArt) {
        this.descArt = descArt;
    }

    public String getEspecificacionesArt() {
        return especificacionesArt;
    }

    public void setEspecificacionesArt(String especificacionesArt) {
        this.especificacionesArt = especificacionesArt;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getUnidaMedida() {
        return unidaMedida;
    }

    public void setUnidaMedida(String unidaMedida) {
        this.unidaMedida = unidaMedida;
    }

    public float getCostoEstandar() {
        return costoEstandar;
    }

    public void setCostoEstandar(float costoEstandar) {
        this.costoEstandar = costoEstandar;
    }

    public float getMaximo() {
        return maximo;
    }

    public void setMaximo(float maximo) {
        this.maximo = maximo;
    }

    public float getPuntoReorden() {
        return puntoReorden;
    }

    public void setPuntoReorden(float puntoReorden) {
        this.puntoReorden = puntoReorden;
    }

    public float getCantidadReorden() {
        return cantidadReorden;
    }

    public void setCantidadReorden(float cantidadReorden) {
        this.cantidadReorden = cantidadReorden;
    }

    public float getMinimo() {
        return minimo;
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

    public int getNroDias() {
        return nroDias;
    }

    public void setNroDias(int nroDias) {
        this.nroDias = nroDias;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripCantidad() {
        return descripCantidad;
    }

    public void setDescripCantidad(String descripCantidad) {
        this.descripCantidad = descripCantidad;
    }
    
    
    
}
