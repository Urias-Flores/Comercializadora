package Controllers;

import Models.ModelCompraDetalle;
import javax.swing.JTextField;

public class ControllerCompraDetalle {
    
    private ModelCompraDetalle modelCompraDetalle = new ModelCompraDetalle();
    
    private JTextField CompraDetalleID;
    private JTextField CompraID;
    private JTextField ProductoID;
    private JTextField BodegaID;
    private JTextField Cantidad;
    private JTextField Precio;
    private JTextField ISV;
    private JTextField Descuento;

    public ControllerCompraDetalle(JTextField CompraDetalleID, JTextField CompraID, JTextField ProductoID, JTextField BodegaID, JTextField Cantidad, JTextField Precio, JTextField ISV, JTextField Descuento) {
        this.CompraDetalleID = CompraDetalleID;
        this.CompraID = CompraID;
        this.ProductoID = ProductoID;
        this.BodegaID = BodegaID;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.ISV = ISV;
        this.Descuento = Descuento;
    }

    public ControllerCompraDetalle() {
    }
    
    public boolean InsertCompraDetalle(int CompraID, String ProductoID, String BodegaID, String Cantidad, String Precio, String ISV){
        modelCompraDetalle.setCompraID(CompraID);
        modelCompraDetalle.setProductoID(Integer.parseInt(ProductoID));
        modelCompraDetalle.setBodegaID(Integer.parseInt(BodegaID));
        modelCompraDetalle.setCantidad(Integer.parseInt(Cantidad));
        modelCompraDetalle.setPrecio(Float.parseFloat(Precio));
        modelCompraDetalle.setISV(Float.parseFloat(ISV));
        modelCompraDetalle.setDescuento(0);
        return modelCompraDetalle.InsertCompraDetalle();
    }
}
