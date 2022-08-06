package Controllers;

import Models.ModelProductor;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerProductor {
    
    private ModelProductor modelProductor = new ModelProductor();
    private Map<Integer, String> TipoDoc = new HashMap<>();
    
    private JTextField ProductorID;
    private JTextField Nombre; 
    private JTextField Documento; 
    private JComboBox TipoDocumento; 
    private JTextField Numero; 
    private JTextField Correo;
    private JTextField Saldo; 

    public ControllerProductor(JTextField ProductorID, JTextField Nombre, JTextField Documento, JComboBox TipoDocumento, JTextField Numero, JTextField Correo, JTextField Saldo) {
        this.ProductorID = ProductorID;
        this.Nombre = Nombre;
        this.Documento = Documento;
        this.TipoDocumento = TipoDocumento;
        this.Numero = Numero;
        this.Correo = Correo;
        this.Saldo = Saldo;
    }

    public ControllerProductor(JTextField Nombre, JTextField Documento, JComboBox TipoDocumento, JTextField Numero, JTextField Correo) {
        TipoDoc.put(1, "I");
        TipoDoc.put(1, "P");
        this.Nombre = Nombre;
        this.Documento = Documento;
        this.TipoDocumento = TipoDocumento;
        this.Numero = Numero;
        this.Correo = Correo;
    }

    public ControllerProductor() {
    }
    
    public boolean InsertProductor(){
        modelProductor.setNombre(Nombre.getText());
        modelProductor.setDocumento(Documento.getText());
        modelProductor.setTipoDocumento(TipoDoc.get(TipoDocumento.getSelectedIndex()));
        modelProductor.setNumero(Numero.getText());
        modelProductor.setCorreo(Correo.getText());
        return modelProductor.InsertProductor();
    }
    
    public DefaultComboBoxModel setProductorCmb () {
        return modelProductor.setModelProductores();
    }
    
    public DefaultTableModel SelectModelProductor(){
        return modelProductor.SelectModelProductor();
    }
    
    public ModelProductor getModelProductor (int productorID, String nombre) {
        modelProductor.setProductorID(productorID);
        modelProductor.setNombre(nombre);
        return modelProductor;
    }
}
