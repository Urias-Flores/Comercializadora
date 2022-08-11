package Controllers;

import Models.ModelAnticipo;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ControllerAnticipo {
    private ModelAnticipo mAnticipo = new ModelAnticipo();
    
    public DefaultTableModel SelectModelAnticipo () {
        return mAnticipo.SelectModelAnticipo();
    }
    
    public ArrayList SelectModelAnticipoPorID (int AnticipoID) {
        mAnticipo.setAnticipoID(AnticipoID);
        return mAnticipo.SelectAnticipoPorID();
    }
    
    public boolean InsertAnticipo (int UsuarioID, int ProductorID, String Estado, float Total) {
        mAnticipo.setUsuarioID(UsuarioID);
        mAnticipo.setProductorID(ProductorID);
        mAnticipo.setEstado(Estado);
        mAnticipo.setTotal(Total);
        return mAnticipo.InsertAnticipo();
    }
    
    public boolean DeleteAnticipo(int AnticipoID) {
        mAnticipo.setAnticipoID(AnticipoID);
        return mAnticipo.DeleteAnticipo();
    }
    
    public boolean UpdateAnticipo(int AnticipoID, int UsuarioID, int ProductorID, String Estado, float Total) {
        mAnticipo.setAnticipoID(AnticipoID);
        mAnticipo.setUsuarioID(UsuarioID);
        mAnticipo.setProductorID(ProductorID);
        mAnticipo.setEstado(Estado);
        mAnticipo.setTotal(Total);
        return mAnticipo.UpdateAnticipo();
    }
    
}
