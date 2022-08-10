
package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ModelProducto {
    private Conection conec = new Conection();
    
    private int ProductoID;
    private String Nombre;
    private String Descripcion;
    private float PrecioCompra;
    private float PrecioVenta;
    private float Descuento;
    private String Categoria;
    private int TipoSueloID;
    private int TipoRiegoID;
    private float TiempoCosecha;

    public int getProductoID() {
        return ProductoID;
    }

    public void setProductoID(int ProductoID) {
        this.ProductoID = ProductoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(float PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public float getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(float PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public float getDescuento() {
        return Descuento;
    }

    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getTipoSueloID() {
        return TipoSueloID;
    }

    public void setTipoSueloID(int TipoSueloID) {
        this.TipoSueloID = TipoSueloID;
    }

    public int getTipoRiegoID() {
        return TipoRiegoID;
    }

    public void setTipoRiegoID(int TipoRiegoID) {
        this.TipoRiegoID = TipoRiegoID;
    }

    public float getTiempoCosecha() {
        return TiempoCosecha;
    }

    public void setTiempoCosecha(float TiempoCosecha) {
        this.TiempoCosecha = TiempoCosecha;
    }
    
    public boolean InsertProductoDeProduccion(){
        String Query = "EXECUTE spInsertProducto ?, ?, ?, ?, ?, ?, ?, ?, ?;";
        try(PreparedStatement ps = conec.getconec().prepareStatement(Query)){
            ps.setString(1,Nombre);
            ps.setString(2, Descripcion);
            ps.setFloat(3, PrecioCompra);
            ps.setFloat(4, PrecioVenta);
            ps.setFloat(5, Descuento);
            ps.setString(6, Categoria);
            ps.setInt(7, TipoSueloID);
            ps.setInt(8, TipoRiegoID);
            ps.setFloat(9, TiempoCosecha);
            return ps.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
    
    public boolean InsertProductoObtenible(){
        String Query = "EXECUTE spInsertProductoObtenible ?, ?, ?, ?, ?, ?;";
        try(PreparedStatement ps = conec.getconec().prepareStatement(Query)){
            ps.setString(1,Nombre);
            ps.setString(2, Descripcion);
            ps.setFloat(3, PrecioCompra);
            ps.setFloat(4, PrecioVenta);
            ps.setFloat(5, Descuento);
            ps.setString(6, Categoria);
            return ps.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
    
    public DefaultTableModel SelectModelProducto(){
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"ID", "Nombre", "Precio/Compra", "Precio/Venta", "Categoria"};
        model.setColumnIdentifiers(Columns);
        String Query = "SELECT * FROM PRODUCTOSOBTENIBLES";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next()){
                String[] row = {rs.getString("ID"), 
                                rs.getString("Nombre"), 
                                rs.getString("PrecioCompra"), 
                                rs.getString("PrecioVenta"), 
                                rs.getString("Categoria")};
                model.addRow(row);
            }
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return model;
    }
    
    public DefaultComboBoxModel SelectModelProductoCmb(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        String Query = "SELECT ID, Nombre FROM PRODUCTOSOBTENIBLES";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next()){
                ModelProducto prod = new ModelProducto();
                prod.setProductoID(rs.getInt("ID"));
                prod.setNombre(rs.getString("Nombre"));
                model.addElement(prod);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return model;
    }
    
    public DefaultTableModel ListProductosFactura(String type){
        DefaultTableModel model = new DefaultTableModel();
        String[] Colums = {"ID", "Nombre", "Precio", "ISV", "Descuento"};
        model.setColumnIdentifiers(Colums);
        
        String Query = "SELECT * FROM LISTPRODUCTOS('"+type+"');";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next()){
                String[] row = {rs.getString("ID"), 
                                rs.getString("Nombre"),
                                rs.getString("Precio"),
                                rs.getString("ISV"),
                                rs.getString("Descuento")};
                model.addRow(row);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return model;
    }
    
    @Override
    public String toString() {
        return this.getNombre();
    }
}
