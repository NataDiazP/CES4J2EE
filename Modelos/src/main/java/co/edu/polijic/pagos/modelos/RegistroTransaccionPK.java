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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Natalia
 */
@Embeddable
public class RegistroTransaccionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cdtransaccion")
    private int cdtransaccion;
    @Basic(optional = false)
    @Column(name = "fefechatransaccion")
    @Temporal(TemporalType.DATE)
    private Date fefechatransaccion;

    public RegistroTransaccionPK() {
    }

    public RegistroTransaccionPK(int cdtransaccion, Date fefechatransaccion) {
        this.cdtransaccion = cdtransaccion;
        this.fefechatransaccion = fefechatransaccion;
    }

    public int getCdtransaccion() {
        return cdtransaccion;
    }

    public void setCdtransaccion(int cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    public Date getFefechatransaccion() {
        return fefechatransaccion;
    }

    public void setFefechatransaccion(Date fefechatransaccion) {
        this.fefechatransaccion = fefechatransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cdtransaccion;
        hash += (fefechatransaccion != null ? fefechatransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroTransaccionPK)) {
            return false;
        }
        RegistroTransaccionPK other = (RegistroTransaccionPK) object;
        if (this.cdtransaccion != other.cdtransaccion) {
            return false;
        }
        if ((this.fefechatransaccion == null && other.fefechatransaccion != null) || (this.fefechatransaccion != null && !this.fefechatransaccion.equals(other.fefechatransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.polijic.pagos.modelos.RegistroTransaccionPK[ cdtransaccion=" + cdtransaccion + ", fefechatransaccion=" + fefechatransaccion + " ]";
    }
    
}
