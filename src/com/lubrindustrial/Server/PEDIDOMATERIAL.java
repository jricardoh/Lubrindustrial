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
public class PEDIDOMATERIAL {
    
    private int idPedido;
    private int idArt;
    private int idEmpPedido;
    private int idEmpEntregado;
    private int idEmpAutorizado;
    private int idEmpAprobado;
    private float cantidad;
    private String unidadCantidad;
    private String descripcion;
    private String fechaHoraSolicitud;
    private String fechaHoraEntrega;
    private String descArt;
    private String descEmpPedido;
    private String descEmpEntregado;
    private String descEmpAutorizado;
    private String descEmpAprobado;
    private int activo;

    public PEDIDOMATERIAL() {
    }

    public PEDIDOMATERIAL(int idPedido, int idArt, int idEmpPedido, int idEmpEntregado, int idEmpAutorizado, int idEmpAprobado, float cantidad, String unidadCantidad, String descripcion, String fechaHoraSolicitud, String fechaHoraEntrega, String descArt, String descEmpPedido, String descEmpEntregado, String descEmpAutorizado, String descEmpAprobado, int activo) {
        this.idPedido = idPedido;
        this.idArt = idArt;
        this.idEmpPedido = idEmpPedido;
        this.idEmpEntregado = idEmpEntregado;
        this.idEmpAutorizado = idEmpAutorizado;
        this.idEmpAprobado = idEmpAprobado;
        this.cantidad = cantidad;
        this.unidadCantidad = unidadCantidad;
        this.descripcion = descripcion;
        this.fechaHoraSolicitud = fechaHoraSolicitud;
        this.fechaHoraEntrega = fechaHoraEntrega;
        this.descArt = descArt;
        this.descEmpPedido = descEmpPedido;
        this.descEmpEntregado = descEmpEntregado;
        this.descEmpAutorizado = descEmpAutorizado;
        this.descEmpAprobado = descEmpAprobado;
        this.activo = activo;
    }

    
    
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdArt() {
        return idArt;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    public int getIdEmpPedido() {
        return idEmpPedido;
    }

    public void setIdEmpPedido(int idEmpPedido) {
        this.idEmpPedido = idEmpPedido;
    }

    public int getIdEmpEntregado() {
        return idEmpEntregado;
    }

    public void setIdEmpEntregado(int idEmpEntregado) {
        this.idEmpEntregado = idEmpEntregado;
    }

    public int getIdEmpAutorizado() {
        return idEmpAutorizado;
    }

    public void setIdEmpAutorizado(int idEmpAutorizado) {
        this.idEmpAutorizado = idEmpAutorizado;
    }

    public int getIdEmpAprobado() {
        return idEmpAprobado;
    }

    public void setIdEmpAprobado(int idEmpAprobado) {
        this.idEmpAprobado = idEmpAprobado;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadCantidad() {
        return unidadCantidad;
    }

    public void setUnidadCantidad(String unidadCantidad) {
        this.unidadCantidad = unidadCantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaHoraSolicitud() {
        return fechaHoraSolicitud;
    }

    public void setFechaHoraSolicitud(String fechaHoraSolicitud) {
        this.fechaHoraSolicitud = fechaHoraSolicitud;
    }

    public String getFechaHoraEntrega() {
        return fechaHoraEntrega;
    }

    public void setFechaHoraEntrega(String fechaHoraEntrega) {
        this.fechaHoraEntrega = fechaHoraEntrega;
    }

    public String getDescArt() {
        return descArt;
    }

    public void setDescArt(String descArt) {
        this.descArt = descArt;
    }

    public String getDescEmpPedido() {
        return descEmpPedido;
    }

    public void setDescEmpPedido(String descEmpPedido) {
        this.descEmpPedido = descEmpPedido;
    }

    public String getDescEmpEntregado() {
        return descEmpEntregado;
    }

    public void setDescEmpEntregado(String descEmpEntregado) {
        this.descEmpEntregado = descEmpEntregado;
    }

    public String getDescEmpAutorizado() {
        return descEmpAutorizado;
    }

    public void setDescEmpAutorizado(String descEmpAutorizado) {
        this.descEmpAutorizado = descEmpAutorizado;
    }

    public String getDescEmpAprobado() {
        return descEmpAprobado;
    }

    public void setDescEmpAprobado(String descEmpAprobado) {
        this.descEmpAprobado = descEmpAprobado;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
    
}
