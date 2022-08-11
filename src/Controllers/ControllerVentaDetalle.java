
package Controllers;

import Models.ModelVentaDetalle;
import javax.swing.JTextField;

public class ControllerVentaDetalle {
    
    private ModelVentaDetalle modelVentaDetalle = new ModelVentaDetalle();
    
    private JTextField VentaDetalleID;
    private JTextField VentaID;
    private JTextField ProductoID;
    private JTextField BodegaID;
    private JTextField Cantidad;
    private JTextField Precio;
    private JTextField ISV;
    private JTextField Descuento;

    public ControllerVentaDetalle(JTextField VentaDetalleID, JTextField VentaID, JTextField ProductoID, JTextField BodegaID, JTextField Cantidad, JTextField Precio, JTextField ISV, JTextField Descuento) {
        this.VentaDetalleID = VentaDetalleID;
        this.VentaID = VentaID;
        this.ProductoID = ProductoID;
        this.BodegaID = BodegaID;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.ISV = ISV;
        this.Descuento = Descuento;
    }

    public ControllerVentaDetalle(JTextField VentaID, JTextField ProductoID, JTextField BodegaID, JTextField Cantidad, JTextField Precio, JTextField ISV, JTextField Descuento) {
        this.VentaID = VentaID;
        this.ProductoID = ProductoID;
        this.BodegaID = BodegaID;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.ISV = ISV;
        this.Descuento = Descuento;
    }

    public ControllerVentaDetalle() {
    }
    
    
    
    public boolean InsertVenta(String VentaID, String ProductoID, String BodegaID, String Cantidad, String Precio, String ISV, String Descuento){
        modelVentaDetalle.setVentaID(Integer.parseInt(VentaID));
        modelVentaDetalle.setProductoID(Integer.parseInt(ProductoID));
        modelVentaDetalle.setBodegaID(Integer.parseInt(BodegaID));
        modelVentaDetalle.setCantidad(Integer.parseInt(Cantidad));
        modelVentaDetalle.setPrecio(Float.parseFloat(Precio));
        modelVentaDetalle.setISV(Float.parseFloat(ISV));
        modelVentaDetalle.setDescuento(Float.parseFloat(Descuento)*0.01f);
        return modelVentaDetalle.InsertVentaDetalle();
    }
}
