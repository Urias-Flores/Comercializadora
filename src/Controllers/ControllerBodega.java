package Controllers;

import Models.ModelBodega;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerBodega {
    private ModelBodega modelBodega = new ModelBodega();
    
    private JTextField BodegaID;
    private JTextField Nombre;
    private JTextField Ubicacion;

    public ControllerBodega(JTextField BodegaID, JTextField Nombre, JTextField Ubicacion) {
        this.BodegaID = BodegaID;
        this.Nombre = Nombre;
        this.Ubicacion = Ubicacion;
    }

    public ControllerBodega(JTextField Nombre, JTextField Ubicacion) {
        this.Nombre = Nombre;
        this.Ubicacion = Ubicacion;
    }

    public ControllerBodega(JTextField BodegaID) {
        this.BodegaID = BodegaID;
    }

    public ControllerBodega() {
    }
    
    public boolean InsertBodega(){
        modelBodega.setNombre(Nombre.getText());
        modelBodega.setUbicacion(Ubicacion.getText());
        return modelBodega.InsertBodega();
    }
    
    public DefaultComboBoxModel SelectListBodegas(){
        return modelBodega.SelectListBodegas();
    }
    
    public DefaultTableModel SelectBodegaModel(){
        return modelBodega.SelectBodegasTableModel();
    }
}
