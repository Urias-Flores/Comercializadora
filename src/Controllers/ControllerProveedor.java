
package Controllers;

import Models.ModelProveedor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerProveedor {
    
    private ModelProveedor modelProveedor = new ModelProveedor();
    
    private JTextField ProveedorID;
    private JTextField Nombre;
    private JTextField Documento;
    private JComboBox TipoDocumento;
    private JTextField Numero;
    private JTextField Correo;

    public ControllerProveedor(JTextField Nombre, JTextField Documento, JComboBox TipoDocumento, JTextField Numero, JTextField Correo) {
        this.Nombre = Nombre;
        this.Documento = Documento;
        this.TipoDocumento = TipoDocumento;
        this.Numero = Numero;
        this.Correo = Correo;
    }

    public ControllerProveedor(JTextField ProveedorID) {
        this.ProveedorID = ProveedorID;
    }

    public ControllerProveedor() {
    }
    
    public boolean InsertProveedor(){
        modelProveedor.setNombre(Nombre.getText());
        modelProveedor.setDocumento(Documento.getText());
        modelProveedor.setTipoDocumento(TipoDocumento.getSelectedItem().toString());
        modelProveedor.setNumero(Numero.getText());
        modelProveedor.setCorreo(Correo.getText());
        return modelProveedor.InsertProveedor();
    }
    
    public DefaultTableModel SelectModelProveedor(){
        return modelProveedor.SelectModelProveedor();
    }
    
    public ModelProveedor SelectProveedor(){
        modelProveedor.setProveedorID(Integer.parseInt(ProveedorID.getName()));
        return modelProveedor.SelectProveedor();
    }
        
}
