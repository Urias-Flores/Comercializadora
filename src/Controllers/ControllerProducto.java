package Controllers;

import Models.ModelProducto;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerProducto {
    
    private ModelProducto modelProducto = new ModelProducto();
    
    private JTextField ProductoID;
    private JTextField Nombre;
    private JTextField Descripcion;
    private JTextField PrecioCompra;
    private JTextField PrecioVenta;
    private JTextField Descuento;
    private JComboBox Categoria;
    private JComboBox TipoSueloID;
    private JComboBox TipoRiegoID;
    private JTextField TiempoCosecha;
    
    private Map<Integer, String> CategoriaMapping = new HashMap<>();

    public ControllerProducto() {
    }

    public ControllerProducto(JTextField ProductoID, JTextField Nombre, JTextField Descripcion, JTextField PrecioCompra, JTextField PrecioVenta, JTextField Descuento, JComboBox Categoria, JComboBox TipoSueloID, JComboBox TipoRiegoID, JTextField TiempoCosecha) {
        this.ProductoID = ProductoID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.Descuento = Descuento;
        this.Categoria = Categoria;
        this.TipoSueloID = TipoSueloID;
        this.TipoRiegoID = TipoRiegoID;
        this.TiempoCosecha = TiempoCosecha;
    }

    public ControllerProducto(JTextField Nombre, JTextField Descripcion, JTextField PrecioCompra, JTextField PrecioVenta, JTextField Descuento, JComboBox Categoria, JComboBox TipoSueloID, JComboBox TipoRiegoID, JTextField TiempoCosecha) {
        CategoriaMapping.put(1, "S");
        CategoriaMapping.put(2, "N");
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.Descuento = Descuento;
        this.Categoria = Categoria;
        this.TipoSueloID = TipoSueloID;
        this.TipoRiegoID = TipoRiegoID;
        this.TiempoCosecha = TiempoCosecha;
    }

    public ControllerProducto(JTextField Nombre, JTextField Descripcion, JTextField PrecioCompra, JTextField PrecioVenta, JTextField Descuento, JComboBox Categoria) {
        CategoriaMapping.put(1, "S");
        CategoriaMapping.put(2, "N");
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.Descuento = Descuento;
        this.Categoria = Categoria;
    }
    
   
    public ControllerProducto(JTextField ProductoID) {
        this.ProductoID = ProductoID;
    }
    
    public boolean InsertProductoDeproduccion(){
        modelProducto.setNombre(Nombre.getText());
        modelProducto.setDescripcion(Descripcion.getText());
        modelProducto.setPrecioCompra(Float.parseFloat(PrecioCompra.getText()));
        modelProducto.setPrecioVenta(Float.parseFloat(PrecioVenta.getText()));
        modelProducto.setDescuento(Float.parseFloat(Descuento.getText())/100);
        modelProducto.setCategoria(CategoriaMapping.get(Categoria.getSelectedIndex()));
        modelProducto.setTipoSueloID(TipoSueloID.getSelectedIndex() + 999);
        modelProducto.setTipoRiegoID(TipoRiegoID.getSelectedIndex() + 999);
        modelProducto.setTiempoCosecha(Float.parseFloat(TiempoCosecha.getText()));
        return modelProducto.InsertProductoDeProduccion();
    }
    
    public boolean InsertProductoObtenible(){
        modelProducto.setNombre(Nombre.getText());
        modelProducto.setDescripcion(Descripcion.getText());
        modelProducto.setPrecioCompra(Float.parseFloat(PrecioCompra.getText()));
        modelProducto.setPrecioVenta(Float.parseFloat(PrecioVenta.getText()));
        modelProducto.setDescuento(Float.parseFloat(Descuento.getText())/100);
        modelProducto.setCategoria(CategoriaMapping.get(Categoria.getSelectedIndex()));
        return modelProducto.InsertProductoObtenible();
    }
    
    public DefaultTableModel SelectModelProductos(){
        return modelProducto.SelectModelProducto();
    }
    
    public DefaultTableModel SelectListaProductos(String ID, String type){
        return modelProducto.ListProductosFactura(ID, type);
    }
}
