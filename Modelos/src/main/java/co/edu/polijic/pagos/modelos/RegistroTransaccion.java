/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.pagos.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Natalia
 */
@Entity
@Table(name = "registro_transaccion", schema = "public", catalog = "pagosbd")
@XmlRootElement
public class RegistroTransaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistroTransaccionPK registroTransaccionPK;
    @Basic(optional = false)
    @Column(name = "opestado")
    private String opestado;
    @Basic(optional = false)
    @Column(name = "dsobservaciones")
    private String dsobservaciones;
    @JoinColumn(name = "cdtransaccion", referencedColumnName = "cdtransaccion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Transaccion transaccion;

    public RegistroTransaccion() {
    }

    public RegistroTransaccion(RegistroTransaccionPK registroTransaccionPK) {
        this.registroTransaccionPK = registroTransaccionPK;
    }

    public RegistroTransaccion(RegistroTransaccionPK registroTransaccionPK, String opestado, String dsobservaciones) {
        this.registroTransaccionPK = registroTransaccionPK;
        this.opestado = opestado;
        this.dsobservaciones = dsobservaciones;
    }

    public RegistroTransaccion(int cdtransaccion, Date fefechatransaccion) {
        this.registroTransaccionPK = new RegistroTransaccionPK(cdtransaccion, fefechatransaccion);
    }

    public RegistroTransaccionPK getRegistroTransaccionPK() {
        return registroTransaccionPK;
    }

    public void setRegistroTransaccionPK(RegistroTransaccionPK registroTransaccionPK) {
        this.registroTransaccionPK = registroTransaccionPK;
    }

    public String getOpestado() {
        return opestado;
    }

    public void setOpestado(String opestado) {
        this.opestado = opestado;
    }

    public String getDsobservaciones() {
        return dsobservaciones;
    }

    public void setDsobservaciones(String dsobservaciones) {
        this.dsobservaciones = dsobservaciones;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroTransaccionPK != null ? registroTransaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroTransaccion)) {
            return false;
        }
        RegistroTransaccion other = (RegistroTransaccion) object;
        if ((this.registroTransaccionPK == null && other.registroTransaccionPK != null) || (this.registroTransaccionPK != null && !this.registroTransaccionPK.equals(other.registroTransaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.polijic.pagos.modelos.RegistroTransaccion[ registroTransaccionPK=" + registroTransaccionPK + " ]";
    }
    
}
