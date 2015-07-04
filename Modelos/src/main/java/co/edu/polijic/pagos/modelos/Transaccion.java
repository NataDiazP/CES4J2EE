/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.pagos.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Natalia
 */
@Entity
@Table(name = "transaccion", schema = "public", catalog = "pagosbd")
@XmlRootElement
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "TRANSACCION_GEN",
            table = "SEQUENCES",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER",
            pkColumnValue = "TRANSACCION_ID",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TRANSACCION_GEN")
    @Basic(optional = false)
    @Column(name = "cdtransaccion")
    private Integer cdtransaccion;
    @Basic(optional = false)
    @Column(name = "cdtarjetaorigen")
    private int cdtarjetaorigen;
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
    @JoinColumn(name = "cdtipopago", referencedColumnName = "cdtipopago")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoPago cdtipopago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaccion", fetch = FetchType.LAZY)
    private List<RegistroTransaccion> registroTransaccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdtransaccion", fetch = FetchType.LAZY)
    private List<Tarjeta> tarjetaList;

    public Transaccion() {
    }

    public Transaccion(Integer cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    public Transaccion(Integer cdtransaccion, int cdtarjetaorigen, int cdtarjetadestino, BigDecimal vltransaccion, int nmcuotaspago) {
        this.cdtransaccion = cdtransaccion;
        this.cdtarjetaorigen = cdtarjetaorigen;
        this.cdtarjetadestino = cdtarjetadestino;
        this.vltransaccion = vltransaccion;
        this.nmcuotaspago = nmcuotaspago;
    }

    public Integer getCdtransaccion() {
        return cdtransaccion;
    }

    public void setCdtransaccion(Integer cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    public int getCdtarjetaorigen() {
        return cdtarjetaorigen;
    }

    public void setCdtarjetaorigen(int cdtarjetaorigen) {
        this.cdtarjetaorigen = cdtarjetaorigen;
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

    public TipoPago getCdtipopago() {
        return cdtipopago;
    }

    public void setCdtipopago(TipoPago cdtipopago) {
        this.cdtipopago = cdtipopago;
    }

    @XmlTransient
    public List<RegistroTransaccion> getRegistroTransaccionList() {
        return registroTransaccionList;
    }

    public void setRegistroTransaccionList(List<RegistroTransaccion> registroTransaccionList) {
        this.registroTransaccionList = registroTransaccionList;
    }

    @XmlTransient
    public List<Tarjeta> getTarjetaList() {
        return tarjetaList;
    }

    public void setTarjetaList(List<Tarjeta> tarjetaList) {
        this.tarjetaList = tarjetaList;
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
        return "co.edu.polijic.pagos.modelos.Transaccion[ cdtransaccion=" + cdtransaccion + " ]";
    }

}
