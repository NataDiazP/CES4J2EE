/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.pagos.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Natalia
 */
@Entity
@Table(name = "tarjeta", schema = "public", catalog = "pagosbd")
@XmlRootElement
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "TARJETA_GEN",
            table = "SEQUENCES",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER",
            pkColumnValue = "TARJETA_ID",
            initialValue = 0,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TARJETA_GEN")
    @Basic(optional = false)
    @Column(name = "cdtarjeta")
    private Integer cdtarjeta;
    @Basic(optional = false)
    @Column(name = "opfranquicia")
    private String opfranquicia;
    @Basic(optional = false)
    @Column(name = "opestadotarjeta")
    private String opestadotarjeta;
    @Basic(optional = false)
    @Column(name = "optipotarjeta")
    private String optipotarjeta;
    @Basic(optional = false)
    @Column(name = "nmtarjeta")
    private int nmtarjeta;
    @Basic(optional = false)
    @Column(name = "dsmesvencimiento")
    private String dsmesvencimiento;
    @Basic(optional = false)
    @Column(name = "dsaniovencimiento")
    private String dsaniovencimiento;
    @Basic(optional = false)
    @Column(name = "cdseguridad")
    private int cdseguridad;
    @Basic(optional = false)
    @Column(name = "dsnombretitular")
    private String dsnombretitular;
    @JoinColumn(name = "cdtransaccion", referencedColumnName = "cdtransaccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Transaccion cdtransaccion;

    public Tarjeta() {
    }

    public Tarjeta(Integer cdtarjeta) {
        this.cdtarjeta = cdtarjeta;
    }

    public Tarjeta(Integer cdtarjeta, String opfranquicia, String opestadotarjeta, String optipotarjeta, int nmtarjeta, String dsmesvencimiento, String dsaniovencimiento, int cdseguridad, String dsnombretitular) {
        this.cdtarjeta = cdtarjeta;
        this.opfranquicia = opfranquicia;
        this.opestadotarjeta = opestadotarjeta;
        this.optipotarjeta = optipotarjeta;
        this.nmtarjeta = nmtarjeta;
        this.dsmesvencimiento = dsmesvencimiento;
        this.dsaniovencimiento = dsaniovencimiento;
        this.cdseguridad = cdseguridad;
        this.dsnombretitular = dsnombretitular;
    }

    public Integer getCdtarjeta() {
        return cdtarjeta;
    }

    public void setCdtarjeta(Integer cdtarjeta) {
        this.cdtarjeta = cdtarjeta;
    }

    public String getOpfranquicia() {
        return opfranquicia;
    }

    public void setOpfranquicia(String opfranquicia) {
        this.opfranquicia = opfranquicia;
    }

    public String getOpestadotarjeta() {
        return opestadotarjeta;
    }

    public void setOpestadotarjeta(String opestadotarjeta) {
        this.opestadotarjeta = opestadotarjeta;
    }

    public String getOptipotarjeta() {
        return optipotarjeta;
    }

    public void setOptipotarjeta(String optipotarjeta) {
        this.optipotarjeta = optipotarjeta;
    }

    public int getNmtarjeta() {
        return nmtarjeta;
    }

    public void setNmtarjeta(int nmtarjeta) {
        this.nmtarjeta = nmtarjeta;
    }

    public String getDsmesvencimiento() {
        return dsmesvencimiento;
    }

    public void setDsmesvencimiento(String dsmesvencimiento) {
        this.dsmesvencimiento = dsmesvencimiento;
    }

    public String getDsaniovencimiento() {
        return dsaniovencimiento;
    }

    public void setDsaniovencimiento(String dsaniovencimiento) {
        this.dsaniovencimiento = dsaniovencimiento;
    }

    public int getCdseguridad() {
        return cdseguridad;
    }

    public void setCdseguridad(int cdseguridad) {
        this.cdseguridad = cdseguridad;
    }

    public String getDsnombretitular() {
        return dsnombretitular;
    }

    public void setDsnombretitular(String dsnombretitular) {
        this.dsnombretitular = dsnombretitular;
    }

    public Transaccion getTransaccionList() {
        return cdtransaccion;
    }

    public void setTransaccionList(Transaccion cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdtarjeta != null ? cdtarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.cdtarjeta == null && other.cdtarjeta != null) || (this.cdtarjeta != null && !this.cdtarjeta.equals(other.cdtarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.polijic.pagos.modelos.Tarjeta[ cdtarjeta=" + cdtarjeta + " ]";
    }

}
