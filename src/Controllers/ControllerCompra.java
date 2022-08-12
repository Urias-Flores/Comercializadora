package Controllers;

import Models.ModelCompra;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerCompra {
    
    private ModelCompra modelCompra = new ModelCompra();
    
    private JTextField CompraID;
    private JTextField UsuarioID;
    private JTextField ProductorID;
    private JTextField ProveedorID;
    private JTextField Estado;
    private JTextField Fecha;
    private JTextField FechaVencimiento;

    public ControllerCompra(JTextField CompraID, JTextField UsuarioID, JTextField ProductorID, JTextField ProveedorID, JTextField Estado, JTextField Fecha, JTextField FechaVencimiento) {
        this.CompraID = CompraID;
        this.UsuarioID = UsuarioID;
        this.ProductorID = ProductorID;
        this.ProveedorID = ProveedorID;
        this.Estado = Estado;
        this.Fecha = Fecha;
        this.FechaVencimiento = FechaVencimiento;
    }

    public ControllerCompra() {
    }

    public ControllerCompra(JTextField ProductorID, JTextField ProveedorID) {
        this.ProductorID = ProductorID;
        this.ProveedorID = ProveedorID;
    }
    
    public int InsertCompra(String type){
        modelCompra.setUsuarioID(1000);
        modelCompra.setProductorID(Integer.parseInt(ProductorID.getName()));
        modelCompra.setProveedorID(Integer.parseInt(ProveedorID.getName()));
        modelCompra.setEstado("R");
        return modelCompra.InsertVenta(type);
    }
    
    public DefaultTableModel getPreeliminar(int ID){
        return modelCompra.getPreelimar(ID);
    }
    
    public int DeleteCompra(int ID){
        modelCompra.setCompraID(ID);
        return modelCompra.DeleteCompra();
    }
}
