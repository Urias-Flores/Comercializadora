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
    
    public boolean InsertCliente(String nombre, String RTN, String Documento, String TipoDocumento, String TipoCliente) {
        modelCliente.setNombre(nombre);
        modelCliente.setRTN(RTN);
        modelCliente.setDocumento(Documento);
        modelCliente.setTipoCliente(TipoCliente);
        modelCliente.setTipoDocumento(TipoDocumento);
        return modelCliente.InsertCliente();
    }
    
    public boolean UpdateCliente(int clienteID, String nombre, String RTN, String Documento, String TipoDocumento, String TipoCliente) {
        modelCliente.setClienteID(clienteID);
        modelCliente.setNombre(nombre);
        modelCliente.setRTN(RTN);
        modelCliente.setDocumento(Documento);
        modelCliente.setTipoCliente(TipoCliente);
        modelCliente.setTipoDocumento(TipoDocumento);
        return modelCliente.UpdateCliente();
    }
    
    public ArrayList SelectClientePorID(int clinteID) {
        modelCliente.setClienteID(clinteID);
        return modelCliente.SelectClientePorID();
    }
}
