
package Controllers;

import Models.ModelVenta;
import Resources.Utilities;
import javax.swing.JTextField;

public class ControllerVenta {
    
    private ModelVenta modelVenta = new ModelVenta();
    
    private JTextField VentaID;
    private JTextField UsuarioID;
    private JTextField ClienteID;
    private JTextField Estado;
    private JTextField Tipo;
    private JTextField Fecha;

    public ControllerVenta() {
    }

    public ControllerVenta(JTextField ClienteID) {
        this.ClienteID = ClienteID;
    }
    
    public int InsertVenta(){
        modelVenta.setUsuarioID(Integer.parseInt("1000"));
        modelVenta.setClienteID(Integer.parseInt(ClienteID.getName()));
        modelVenta.setEstado("R");
        return modelVenta.InsertVenta();
    }
}
