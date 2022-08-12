
package Controllers;

import Models.ModelVenta;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
        if(ClienteID.getName().isEmpty())
            modelVenta.setClienteID(0);
        else{
            modelVenta.setClienteID(Integer.parseInt(ClienteID.getName()));
        }
        modelVenta.setEstado("R");
        return modelVenta.InsertVenta();
    }
    
    public DefaultTableModel getTotalVentasCompras(){
        return modelVenta.getVentasCompras();
    }
    
    public DefaultTableModel getPreeliminar(int ID){
        return modelVenta.getPreelimar(ID);
    }
}
