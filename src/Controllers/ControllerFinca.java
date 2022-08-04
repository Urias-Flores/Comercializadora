package Controllers;

import Models.ModelFinca;
import Models.ModelProductor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerFinca {
    
    private ModelFinca modelFinca = new ModelFinca();
    private ModelProductor modelProductor = new ModelProductor();
    
    private JTextField FincaID;
    private JTextField Nombre;
    private JTextField ProductorID;
    private JTextField Ubicacion;

    public ControllerFinca() {
        
    }

    public ControllerFinca(JTextField FincaID, JTextField Nombre, JTextField ProductorID, JTextField Ubicacion) {
        this.FincaID = FincaID;
        this.Nombre = Nombre;
        this.ProductorID = ProductorID;
        this.Ubicacion = Ubicacion;
    }

    public ControllerFinca(JTextField Nombre, JTextField ProductorID, JTextField Ubicacion) {
        this.Nombre = Nombre;
        this.ProductorID = ProductorID;
        this.Ubicacion = Ubicacion;
    }
    
    public DefaultTableModel SelectModelFinca(){
        return modelFinca.SelectModelFinca();
    }
    
    public DefaultComboBoxModel setFincaCmb () {
        return modelFinca.SelectModelFincaCmb();
    } 
    
    public boolean InsertFinca(){
        modelFinca.setNombre(Nombre.getText());
        modelFinca.setProductorID(Integer.parseInt(ProductorID.getName()));
        modelFinca.setUbicacion(Ubicacion.getText());
        return modelFinca.InsertFinca();
    }
    
    public boolean InsertFinca(int id, String nombre, String ubicacion) {
        modelFinca.setProductorID(id);
        modelFinca.setNombre(nombre);
        modelFinca.setUbicacion(ubicacion);
        return modelFinca.InsertFinca();
    }
}
