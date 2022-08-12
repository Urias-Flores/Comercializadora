package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModelCompraDetalle {
    
    private Conection conec = new Conection();
    
    private int CompraDetalleID;
    private int CompraID;
    private int ProductoID;
    private int BodegaID;
    private int Cantidad;
    private float Precio;
    private float ISV;
    private float Descuento;

    public int getCompraDetalleID() {
        return CompraDetalleID;
    }

    public void setCompraDetalleID(int CompraDetalleID) {
        this.CompraDetalleID = CompraDetalleID;
    }

    public int getCompraID() {
        return CompraID;
    }

    public void setCompraID(int CompraID) {
        this.CompraID = CompraID;
    }

    public int getProductoID() {
        return ProductoID;
    }

    public void setProductoID(int ProductoID) {
        this.ProductoID = ProductoID;
    }

    public int getBodegaID() {
        return BodegaID;
    }

    public void setBodegaID(int BodegaID) {
        this.BodegaID = BodegaID;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public float getISV() {
        return ISV;
    }

    public void setISV(float ISV) {
        this.ISV = ISV;
    }

    public float getDescuento() {
        return Descuento;
    }

    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }
    
    public boolean InsertCompraDetalle(){
        String Query = "EXECUTE spInsertCompraDetalle ?, ?, ?, ?, ?, ?, ?";
        try(PreparedStatement ps = conec.getconec().prepareStatement(Query)){
            ps.setInt(1, CompraID);
            ps.setInt(2, ProductoID);
            ps.setInt(3, BodegaID);
            ps.setInt(4, Cantidad);
            ps.setFloat(5, Precio);
            ps.setFloat(6, ISV);
            ps.setFloat(7, Descuento);
            return ps.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
}
