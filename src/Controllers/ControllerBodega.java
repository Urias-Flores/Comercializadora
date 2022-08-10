package Controllers;

import Models.ModelBodega;
import javax.swing.table.DefaultTableModel;

public class ControllerBodega {
    private ModelBodega modelBodega = new ModelBodega();
    public DefaultTableModel SelectBodegaModel(){
        return modelBodega.SelectBodegasTableModel();
    }
}
