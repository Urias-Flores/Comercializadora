
package Controllers;

import Models.ModelTipoRiego;
import java.util.ArrayList;
import javax.swing.JTextField;

public class ControllerTipoRiego {
    
    private ModelTipoRiego modelTipoRiego = new ModelTipoRiego();
    
    private JTextField TipoRiegoID;
    private JTextField Nombre;

    public ControllerTipoRiego(JTextField TipoRiegoID, JTextField Nombre) {
        this.TipoRiegoID = TipoRiegoID;
        this.Nombre = Nombre;
    }

    public ControllerTipoRiego(JTextField Nombre) {
        this.Nombre = Nombre;
    }

    public ControllerTipoRiego() {
    }
    
    public ArrayList<String> SelectListTipoRiego(){
        return modelTipoRiego.SelectListTipoRiego();
    }
    
    public boolean InsertTipoRiego(){
        modelTipoRiego.setNombre(Nombre.getText());
        return modelTipoRiego.InsertTipoRiego();
    }
}
