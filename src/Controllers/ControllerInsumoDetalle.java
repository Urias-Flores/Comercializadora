
package Controllers;

import Models.ModelInsumoDetalle;
import javax.swing.JTextField;

public class ControllerInsumoDetalle {
    
    private ModelInsumoDetalle modelInsumoDetalle = new ModelInsumoDetalle();
    
    private JTextField InsumoID;
    private JTextField InsumoDetalleID;
    private JTextField ProductoID;
    private JTextField BodegaID;
    private JTextField Cantidad;
    private JTextField Precio;
    private JTextField ISV;
    private JTextField Descuento;

    public ControllerInsumoDetalle(JTextField InsumoID, JTextField InsumoDetalleID, JTextField ProductoID, JTextField BodegaID, JTextField Cantidad, JTextField Precio, JTextField ISV, JTextField Descuento) {
        this.InsumoID = InsumoID;
        this.InsumoDetalleID = InsumoDetalleID;
        this.ProductoID = ProductoID;
        this.BodegaID = BodegaID;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.ISV = ISV;
        this.Descuento = Descuento;
    }

    public ControllerInsumoDetalle() {
    }
    
    public boolean InsertInsumoDetalle(int InsumoID, String ProductoID, String BodegaID, String Cantidad, String Precio, String ISV, String Descuento){
        modelInsumoDetalle.setInsumoID(InsumoID);
        modelInsumoDetalle.setProductoID(Integer.parseInt(ProductoID));
        modelInsumoDetalle.setBodegaID(Integer.parseInt(BodegaID));
        modelInsumoDetalle.setCantidad(Integer.parseInt(Cantidad));
        modelInsumoDetalle.setPrecio(Float.parseFloat(Precio));
        modelInsumoDetalle.setISV(Float.parseFloat(ISV));
        modelInsumoDetalle.setDescuento(Float.parseFloat(Descuento));
        return modelInsumoDetalle.InsertInsumoDetalle();
    }
}
