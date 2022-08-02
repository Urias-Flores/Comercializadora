package Controllers;

import Models.ModelTipoSuelo;
import java.util.ArrayList;
import javax.swing.JTextField;

public class ControllerTipoSuelo {
    
    private ModelTipoSuelo modelTipoSuelo = new ModelTipoSuelo();
    
    private JTextField TipoSueloID;
    private JTextField Nombre;

    public ControllerTipoSuelo(JTextField TipoSueloID, JTextField Nombre) {
        this.TipoSueloID = TipoSueloID;
        this.Nombre = Nombre;
    }

    public ControllerTipoSuelo(JTextField Nombre) {
        this.Nombre = Nombre;
    }

    public ControllerTipoSuelo() {
    }
    
    public ArrayList<String> SelectListTipoSuelo(){
        return modelTipoSuelo.SelectListTipoSuelo();
    }
    
    public boolean InsertTipoSuelo(){
        modelTipoSuelo.setNombre(Nombre.getText());
        return modelTipoSuelo.InsertTipoRiego();
    }
}
