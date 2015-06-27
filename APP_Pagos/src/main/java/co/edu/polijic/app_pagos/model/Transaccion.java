/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.app_pagos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "transaccion")
@TableGenerator(name="TransaccionGenerator", initialValue=1, allocationSize=2500)
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByCdtransaccion", query = "SELECT t FROM Transaccion t WHERE t.cdtransaccion = :cdtransaccion"),
    @NamedQuery(name = "Transaccion.findByCdtarjetadestino", query = "SELECT t FROM Transaccion t WHERE t.cdtarjetadestino = :cdtarjetadestino"),
    @NamedQuery(name = "Transaccion.findByVltransaccion", query = "SELECT t FROM Transaccion t WHERE t.vltransaccion = :vltransaccion"),
    @NamedQuery(name = "Transaccion.findByNmcuotaspago", query = "SELECT t FROM Transaccion t WHERE t.nmcuotaspago = :nmcuotaspago")})
public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "TRANSACCION_GEN",
                table = "SEQUENCES",
		pkColumnName = "SEQ_NAME",
                valueColumnName = "SEQ_NUMBER",
		pkColumnValue = "TRANSACCION_ID",
                allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TRANSACCION_GEN")
    @Basic(optional = false)
    @Column(name = "cdtransaccion")
    private Integer cdtransaccion;
    @Basic(optional = false)
    @Column(name = "cdtarjetadestino")
    private int cdtarjetadestino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vltransaccion")
    private BigDecimal vltransaccion;
    @Basic(optional = false)
    @Column(name = "nmcuotaspago")
    private int nmcuotaspago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdtransaccion")
    private List<RegistroTransaccion> transacciones;
    @JoinColumn(name = "cdtarjetaorigen", referencedColumnName = "cdtarjeta")
    @ManyToOne(optional = false)
    private Tarjeta cdtarjetaorigen;
    @JoinColumn(name = "cdtipopago", referencedColumnName = "cdtipopago")
    @ManyToOne(optional = false)
    private TipoPago cdtipopago;

    public Transaccion() {
    }

    public Transaccion(Integer cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    public Transaccion(Integer cdtransaccion, int cdtarjetadestino, BigDecimal vltransaccion, int nmcuotaspago, Tarjeta cdtarjetaorigen, TipoPago cdtipopago) {
        this.cdtransaccion = cdtransaccion;
        this.cdtarjetadestino = cdtarjetadestino;
        this.vltransaccion = vltransaccion;
        this.nmcuotaspago = nmcuotaspago;
        this.cdtarjetaorigen = cdtarjetaorigen;
        this.cdtipopago = cdtipopago;
    }



    public Integer getCdtransaccion() {
        return cdtransaccion;
    }

    public void setCdtransaccion(Integer cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    public int getCdtarjetadestino() {
        return cdtarjetadestino;
    }

    public void setCdtarjetadestino(int cdtarjetadestino) {
        this.cdtarjetadestino = cdtarjetadestino;
    }

    public BigDecimal getVltransaccion() {
        return vltransaccion;
    }

    public void setVltransaccion(BigDecimal vltransaccion) {
        this.vltransaccion = vltransaccion;
    }

    public int getNmcuotaspago() {
        return nmcuotaspago;
    }

    public void setNmcuotaspago(int nmcuotaspago) {
        this.nmcuotaspago = nmcuotaspago;
    }

    public List<RegistroTransaccion> getRegistroTransaccionList() {
        return transacciones;
    }

    public void setRegistroTransaccionList(List<RegistroTransaccion> registroTransaccionList) {
        this.transacciones = registroTransaccionList;
    }

    public Tarjeta getCdtarjetaorigen() {
        return cdtarjetaorigen;
    }

    public void setCdtarjetaorigen(Tarjeta cdtarjetaorigen) {
        this.cdtarjetaorigen = cdtarjetaorigen;
    }

    public TipoPago getCdtipopago() {
        return cdtipopago;
    }

    public void setCdtipopago(TipoPago cdtipopago) {
        this.cdtipopago = cdtipopago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdtransaccion != null ? cdtransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.cdtransaccion == null && other.cdtransaccion != null) || (this.cdtransaccion != null && !this.cdtransaccion.equals(other.cdtransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.polijic.app_pagos.model.Transaccion[ cdtransaccion=" + cdtransaccion + " ]";
    }
    
}
