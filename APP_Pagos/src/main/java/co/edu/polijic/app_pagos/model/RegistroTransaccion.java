/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.app_pagos.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "registro_transaccion")
@NamedQueries({
    @NamedQuery(name = "RegistroTransaccion.findAll", query = "SELECT r FROM RegistroTransaccion r"),
    @NamedQuery(name = "RegistroTransaccion.findByCdregistro", query = "SELECT r FROM RegistroTransaccion r WHERE r.cdregistro = :cdregistro"),
    @NamedQuery(name = "RegistroTransaccion.findByOpestado", query = "SELECT r FROM RegistroTransaccion r WHERE r.opestado = :opestado"),
    @NamedQuery(name = "RegistroTransaccion.findByFefechatransaccion", query = "SELECT r FROM RegistroTransaccion r WHERE r.fefechatransaccion = :fefechatransaccion"),
    @NamedQuery(name = "RegistroTransaccion.findByDsobservaciones", query = "SELECT r FROM RegistroTransaccion r WHERE r.dsobservaciones = :dsobservaciones")})
public class RegistroTransaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "REGISTROTRANSACCION_GEN",
                table = "SEQUENCES",
		pkColumnName = "SEQ_NAME",
                valueColumnName = "SEQ_NUMBER",
		pkColumnValue = "REGISTROTRANSACCION_ID",
                allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "REGISTROTRANSACCION_GEN")
    @Basic(optional = false)
    @Column(name = "cdregistro")
    private Integer cdregistro;
    @Basic(optional = false)
    @Column(name = "opestado")
    private String opestado;
    @Basic(optional = false)
    @Column(name = "fefechatransaccion")
    @Temporal(TemporalType.DATE)
    private Date fefechatransaccion;
    @Basic(optional = false)
    @Column(name = "dsobservaciones")
    private String dsobservaciones;
    @JoinColumn(name = "cdtransaccion", referencedColumnName = "cdtransaccion")
    @ManyToOne(optional = false)
    private Transaccion cdtransaccion;

    public RegistroTransaccion() {
    }

    public RegistroTransaccion(Integer cdregistro) {
        this.cdregistro = cdregistro;
    }

    public RegistroTransaccion(Integer cdregistro, String opestado, Date fefechatransaccion, String dsobservaciones) {
        this.cdregistro = cdregistro;
        this.opestado = opestado;
        this.fefechatransaccion = fefechatransaccion;
        this.dsobservaciones = dsobservaciones;
    }

    public Integer getCdregistro() {
        return cdregistro;
    }

    public void setCdregistro(Integer cdregistro) {
        this.cdregistro = cdregistro;
    }

    public String getOpestado() {
        return opestado;
    }

    public void setOpestado(String opestado) {
        this.opestado = opestado;
    }

    public Date getFefechatransaccion() {
        return fefechatransaccion;
    }

    public void setFefechatransaccion(Date fefechatransaccion) {
        this.fefechatransaccion = fefechatransaccion;
    }

    public String getDsobservaciones() {
        return dsobservaciones;
    }

    public void setDsobservaciones(String dsobservaciones) {
        this.dsobservaciones = dsobservaciones;
    }

    public Transaccion getCdtransaccion() {
        return cdtransaccion;
    }

    public void setCdtransaccion(Transaccion cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdregistro != null ? cdregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroTransaccion)) {
            return false;
        }
        RegistroTransaccion other = (RegistroTransaccion) object;
        if ((this.cdregistro == null && other.cdregistro != null) || (this.cdregistro != null && !this.cdregistro.equals(other.cdregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.polijic.app_pagos.model.RegistroTransaccion[ cdregistro=" + cdregistro + " ]";
    }
    
}
