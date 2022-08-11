package Controllers;

import Models.ModelBodega;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerBodega {
    private ModelBodega modelBodega = new ModelBodega();
    
    private JTextField Nombre;
    private JTextField Ubicacion;
    
    public ControllerBodega() {
    }

    public ControllerBodega(JTextField Nombre, JTextField Ubicacion) {
        this.Nombre = Nombre;
        this.Ubicacion = Ubicacion;
    }
    
    public DefaultTableModel SelectBodegaModel(){
        return modelBodega.SelectBodegasTableModel();
    }
    
    public boolean InsertBodega()
    {
        modelBodega.setNombre(Nombre.getText());
        modelBodega.setUbicacion(Ubicacion.getText());
        
        return modelBodega.InsertBodega();
    }
}
