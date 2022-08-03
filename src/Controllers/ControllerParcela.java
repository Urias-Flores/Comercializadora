package Controllers;

import Models.ModelParcela;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerParcela {
    
    private ModelParcela modelParcela = new ModelParcela();
    
    private JTextField ParcelaID;
    private JTextField FincaID;
    private JTextField ProductoID;
    private JComboBox TipoSueloID;
    private JComboBox TipoRiegoID;
    private JComboBox Dia;
    private JComboBox Mes;
    private JComboBox Anio;
    private JTextField Extension;
    private JTextField Cantidad;

    public ControllerParcela() {
    }

    public ControllerParcela(JTextField ParcelaID, JTextField FincaID, JTextField ProductoID, JComboBox TipoSueloID, JComboBox TipoRiegoID, JComboBox Dia, JComboBox Mes, JComboBox Anio, JTextField Extension, JTextField Cantidad) {
        this.ParcelaID = ParcelaID;
        this.FincaID = FincaID;
        this.ProductoID = ProductoID;
        this.TipoSueloID = TipoSueloID;
        this.TipoRiegoID = TipoRiegoID;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Anio = Anio;
        this.Extension = Extension;
        this.Cantidad = Cantidad;
    }

    public ControllerParcela(JTextField FincaID, JTextField ProductoID, JComboBox TipoSueloID, JComboBox TipoRiegoID, JComboBox Dia, JComboBox Mes, JComboBox Anio, JTextField Extension, JTextField Cantidad) {
        this.FincaID = FincaID;
        this.ProductoID = ProductoID;
        this.TipoSueloID = TipoSueloID;
        this.TipoRiegoID = TipoRiegoID;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Anio = Anio;
        this.Extension = Extension;
        this.Cantidad = Cantidad;
    }
    
    public boolean InsertParcela(){
        modelParcela.setFincaID(Integer.parseInt(FincaID.getName()));
        modelParcela.setProductoID(Integer.parseInt(ProductoID.getName()));
        modelParcela.setTipoSueloID(TipoSueloID.getSelectedIndex() + 1000);
        modelParcela.setTipoRiegoID(TipoRiegoID.getSelectedIndex() + 1000);
        modelParcela.setExtension(Float.parseFloat(Extension.getText()));
        modelParcela.setCantidad(Float.parseFloat(Cantidad.getText()));
        return modelParcela.InsertParcela();
    }
  
    public DefaultTableModel SelectModelParcelas(){
        return modelParcela.SelectModelParcela();
    }
    
}
