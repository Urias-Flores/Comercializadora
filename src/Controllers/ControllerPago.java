package Controllers;

import Models.ModelPago;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ControllerPago {
    
    private ModelPago modelPago = new ModelPago();
    
    private JTextField PagoID;
    private JTextField UsuarioID;
    private JTextField ProveedorID;
    private JComboBox Estado;
    private JTextField Fecha;
    private JTextField Tipo;
    private JTextField Total;
    private JTable Pagos;
    private JTextField Saldo;
    private JLabel Deuda;

    public ControllerPago(JTextField PagoID, JTextField UsuarioID, JTextField ProveedorID, JComboBox Estado, JTextField Fecha, JTextField Tipo, JTextField Total, JTable Pagos) {
        this.PagoID = PagoID;
        this.UsuarioID = UsuarioID;
        this.ProveedorID = ProveedorID;
        this.Estado = Estado;
        this.Fecha = Fecha;
        this.Tipo = Tipo;
        this.Total = Total;
        this.Pagos = Pagos;
    }

    public ControllerPago(JTextField ProveedorID, JComboBox Estado, JTextField Total, JTable Pagos, JTextField Saldo, JLabel Deuda) {
        this.ProveedorID = ProveedorID;
        this.Estado = Estado;
        this.Total = Total;
        this.Pagos = Pagos;
        this.Saldo = Saldo;
        this.Deuda = Deuda;
    }

    public ControllerPago() {
    }
    
    public boolean InsertPago(){
        modelPago.setProveedorID(Integer.parseInt(ProveedorID.getName()));
        modelPago.setEstado(Estado.getSelectedIndex() == 1 ? "P" : "N");
        modelPago.setTotal(Float.parseFloat(Total.getText()));
        modelPago.setUsuarioID(1000);
        return modelPago.InsertPago();
    }
    
    public void Cargar(){
        this.Pagos.setModel(modelPago.cargarPagos());
        this.Deuda.setText(String.valueOf(modelPago.getDeuda()));
    }
    
    public void ActualizarSaldoActual(){
        modelPago.setProveedorID(Integer.parseInt(ProveedorID.getName()));
        Saldo.setText(modelPago.ObtenerSaldo());
    }
}
