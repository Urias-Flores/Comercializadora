/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventadetalle.findAll", query = "SELECT v FROM Ventadetalle v"),
    @NamedQuery(name = "Ventadetalle.findByCompraDetalleID", query = "SELECT v FROM Ventadetalle v WHERE v.compraDetalleID = :compraDetalleID"),
    @NamedQuery(name = "Ventadetalle.findByCantidad", query = "SELECT v FROM Ventadetalle v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "Ventadetalle.findByPrecio", query = "SELECT v FROM Ventadetalle v WHERE v.precio = :precio"),
    @NamedQuery(name = "Ventadetalle.findByIsv", query = "SELECT v FROM Ventadetalle v WHERE v.isv = :isv"),
    @NamedQuery(name = "Ventadetalle.findByDescuento", query = "SELECT v FROM Ventadetalle v WHERE v.descuento = :descuento")})
public class Ventadetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer compraDetalleID;
    @Basic(optional = false)
    private int cantidad;
    @Basic(optional = false)
    private float precio;
    @Basic(optional = false)
    private float isv;
    @Basic(optional = false)
    private float descuento;
    @JoinColumn(name = "ProductoID", referencedColumnName = "ProductoID")
    @ManyToOne(optional = false)
    private Producto productoID;
    @JoinColumn(name = "CompraID", referencedColumnName = "VentaID")
    @ManyToOne(optional = false)
    private Venta compraID;

    public Ventadetalle() {
    }

    public Ventadetalle(Integer compraDetalleID) {
        this.compraDetalleID = compraDetalleID;
    }

    public Ventadetalle(Integer compraDetalleID, int cantidad, float precio, float isv, float descuento) {
        this.compraDetalleID = compraDetalleID;
        this.cantidad = cantidad;
        this.precio = precio;
        this.isv = isv;
        this.descuento = descuento;
    }

    public Integer getCompraDetalleID() {
        return compraDetalleID;
    }

    public void setCompraDetalleID(Integer compraDetalleID) {
        this.compraDetalleID = compraDetalleID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getIsv() {
        return isv;
    }

    public void setIsv(float isv) {
        this.isv = isv;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public Producto getProductoID() {
        return productoID;
    }

    public void setProductoID(Producto productoID) {
        this.productoID = productoID;
    }

    public Venta getCompraID() {
        return compraID;
    }

    public void setCompraID(Venta compraID) {
        this.compraID = compraID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraDetalleID != null ? compraDetalleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventadetalle)) {
            return false;
        }
        Ventadetalle other = (Ventadetalle) object;
        if ((this.compraDetalleID == null && other.compraDetalleID != null) || (this.compraDetalleID != null && !this.compraDetalleID.equals(other.compraDetalleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Ventadetalle[ compraDetalleID=" + compraDetalleID + " ]";
    }
    
}
