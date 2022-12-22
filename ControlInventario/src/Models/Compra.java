/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dell
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByCompraID", query = "SELECT c FROM Compra c WHERE c.compraID = :compraID"),
    @NamedQuery(name = "Compra.findByFecha", query = "SELECT c FROM Compra c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Compra.findByHora", query = "SELECT c FROM Compra c WHERE c.hora = :hora")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer compraID;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "ProveedorID", referencedColumnName = "ProveedorID")
    @ManyToOne
    private Proveedor proveedorID;
    @JoinColumn(name = "UsuarioID", referencedColumnName = "UsuarioID")
    @ManyToOne(optional = false)
    private Usuario usuarioID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraID")
    private List<Compradetalle> compradetalleList;

    public Compra() {
    }

    public Compra(Integer compraID) {
        this.compraID = compraID;
    }

    public Compra(Integer compraID, Date fecha, Date hora) {
        this.compraID = compraID;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getCompraID() {
        return compraID;
    }

    public void setCompraID(Integer compraID) {
        this.compraID = compraID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Proveedor getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(Proveedor proveedorID) {
        this.proveedorID = proveedorID;
    }

    public Usuario getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }

    @XmlTransient
    public List<Compradetalle> getCompradetalleList() {
        return compradetalleList;
    }

    public void setCompradetalleList(List<Compradetalle> compradetalleList) {
        this.compradetalleList = compradetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraID != null ? compraID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraID == null && other.compraID != null) || (this.compraID != null && !this.compraID.equals(other.compraID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Compra[ compraID=" + compraID + " ]";
    }
    
}
