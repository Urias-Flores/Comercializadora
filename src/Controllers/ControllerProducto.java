package Controllers;

import Models.ModelProducto;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerProducto {
    private ModelProducto modelProducto = new ModelProducto();
    private Map<Integer, String> CatList;
    
    //Fields
    private JTextField Nombre;
    private JTextField Descripción;
    private JTextField PrecioCompra;
    private JTextField PrecioVenta;
    private JTextField Descuento;
    private JComboBox Categoria;
    private JComboBox TipoSuelo;
    private JComboBox TipoRiego;
    private JTextField TiempoCosecha;
    
    public DefaultTableModel SelectProductoModel(){
        return modelProducto.SelectProductosTableModel();
    }
    
    public ControllerProducto(JTextField Nombre, JTextField Descripción, JTextField PrecioCompra, JTextField PrecioVenta, JTextField Descuento, JComboBox Categoria, JComboBox TipoSuelo, JComboBox TipoRiego, JTextField TiempoCosecha){
        CatList = new HashMap<>();
        CatList.put(1, "S");
        CatList.put(2, "N");
        this.Nombre = Nombre;
        this.Descripción = Descripción;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.Descuento = Descuento;
        this.Categoria = Categoria;
        this.TipoSuelo = TipoSuelo;
        this.TipoRiego = TipoRiego;
        this.TiempoCosecha = TiempoCosecha;
    }
    
    public boolean InsertProducto()
    {
        modelProducto.setNombre(Nombre.getText());
        modelProducto.setDescripción(Descripción.getText());
        modelProducto.setPrecioCompra(Float.parseFloat(PrecioCompra.getText()));
        modelProducto.setPrecioVenta(Float.parseFloat(PrecioVenta.getText()));
        modelProducto.setDescuento(Float.parseFloat(Descuento.getText()));
        modelProducto.setCategoria(CatList.get(Categoria.getSelectedIndex()).charAt(0));
        modelProducto.setTipoSueloID(TipoSuelo.getSelectedIndex());
        modelProducto.setTipoRiegoID(TipoRiego.getSelectedIndex());
        modelProducto.setTiempoCocecha(Float.parseFloat(TiempoCosecha.getText()));
        return modelProducto.InsertProducto();
    }
}
