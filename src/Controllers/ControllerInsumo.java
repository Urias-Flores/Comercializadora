package Controllers;

import Models.ModelInsumo;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerInsumo {
    
    private ModelInsumo modelInsumo = new ModelInsumo();
    
    private JTextField InsumoID;
    private JTextField UsuarioID;
    private JTextField ProductorID;
    private JTextField Fecha;
    private JTextField FechaVencimiento;
    private JTextField Estado;

    public ControllerInsumo(JTextField InsumoID, JTextField UsuarioID, JTextField ProductorID, JTextField Fecha, JTextField FechaVencimiento, JTextField Estado) {
        this.InsumoID = InsumoID;
        this.UsuarioID = UsuarioID;
        this.ProductorID = ProductorID;
        this.Fecha = Fecha;
        this.FechaVencimiento = FechaVencimiento;
        this.Estado = Estado;
    }

    public ControllerInsumo(JTextField UsuarioID, JTextField ProductorID, JTextField Estado) {
        this.UsuarioID = UsuarioID;
        this.ProductorID = ProductorID;
        this.Estado = Estado;
    }

    public ControllerInsumo(JTextField ProductorID) {
        this.ProductorID = ProductorID;
    }
    
    public ControllerInsumo() {
    }
    
    public int InsertInsumo(){
        modelInsumo.setUsuarioID(1000);
        modelInsumo.setProductorID(Integer.parseInt(ProductorID.getName()));
        modelInsumo.setEstado("P");
        return modelInsumo.InsertInsumo();
    }
    
    public DefaultTableModel getPreelimar(int ID){
        return modelInsumo.getPreelimar(ID);
    }
    
    public int DeleteInsumo(int ID){
        modelInsumo.setInsumoID(ID);
        return modelInsumo.DeleteInsumo();
    }
}
