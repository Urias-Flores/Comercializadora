package Controllers;

import Models.ModelCliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControllerCliente {
    private ModelCliente modelCliente = new ModelCliente();
    
    public ControllerCliente() {
        
    }
    
    public DefaultTableModel SelectModelFinca() {
        return modelCliente.SelectModelCliente();
    }
    
}
