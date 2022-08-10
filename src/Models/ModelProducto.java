
package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModelProducto {
    //Conexion a la base de datos principal
    private Conection conec = new Conection();
    
    //Propiedades
    private long ProductoID;
    private String Nombre;
    private String Descripción;
    private char Categoria;
    private float PrecioCompra;
    private float PrecioVenta;
    private float Descuento;
    private long TipoSueloID;
    private long TipoRiegoID;
    private float TiempoCocecha;
    
    public ModelProducto() {
        this.ProductoID = 0;
        this.Nombre = "";
        this.Descripción = "";
        this.Categoria = 'N';
        this.PrecioCompra = 0;
        this.PrecioVenta = 0;
        this.Descuento = 0;
        this.TipoSueloID = 0;
        this.TipoRiegoID = 0;
        this.TiempoCocecha = 0;
    }

    //Getters & setters
    public void setTiempoCocecha(float TiempoCocecha) {    
        this.TiempoCocecha = TiempoCocecha;
    }

    public long getProductoID() {
        return ProductoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripción() {
        return Descripción;
    }

    public char getCategoria() {
        return Categoria;
    }

    public float getPrecioCompra() {
        return PrecioCompra;
    }

    public float getPrecioVenta() {
        return PrecioVenta;
    }

    public float getDescuento() {
        return Descuento;
    }

    public long getTipoSueloID() {
        return TipoSueloID;
    }

    public long getTipoRiegoID() {
        return TipoRiegoID;
    }

    public float getTiempoCocecha() {
        return TiempoCocecha;
    }
    
    public void setProductoID(long ProductoID) {
        this.ProductoID = ProductoID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDescripción(String Descripción) {
        this.Descripción = Descripción;
    }

    public void setCategoria(char Categoria) {
        this.Categoria = Categoria;
    }

    public void setPrecioCompra(float PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public void setPrecioVenta(float PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }

    public void setTipoSueloID(long TipoSueloID) {
        this.TipoSueloID = TipoSueloID;
    }

    public void setTipoRiegoID(long TipoRiegoID) {
        this.TipoRiegoID = TipoRiegoID;
    }
    
    public ModelProducto(long ProductoID, String Nombre, String Descripción, char Categoria, float PrecioCompra, float PrecioVenta, float Descuento, long TipoSueloID, long TipoRiegoID, float TiempoCocecha) {
        this.ProductoID = ProductoID;
        this.Nombre = Nombre;
        this.Descripción = Descripción;
        this.Categoria = Categoria;
        this.PrecioCompra = PrecioCompra;
        this.PrecioVenta = PrecioVenta;
        this.Descuento = Descuento;
        this.TipoSueloID = TipoSueloID;
        this.TipoRiegoID = TipoRiegoID;
        this.TiempoCocecha = TiempoCocecha;
    }
    
    public DefaultTableModel SelectProductosTableModel(){
        DefaultTableModel m = new DefaultTableModel();
        String[] Columns = {"ID", "Nombre", "Descripción", "Precio de compra", "Precio de venta", "Descuento", "Meses de cosecha"};
        m.setColumnIdentifiers(Columns);
        
        String Query = "SELECT * FROM PRODUCTO;";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next())
            {
                String[] row = {rs.getString("ProductoID"),
                                rs.getString("Nombre"), 
                                rs.getString("Descripción"),
                                rs.getString("PrecioCompra"),
                                rs.getString("PrecioVenta"),
                                rs.getString("Descuento"),
                                rs.getString("TiempoCocecha")
                                
                };
                m.addRow(row);
            }
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        
        return m;
    }
    
    public boolean InsertProducto(){
        String Query = "EXECUTE spInsertProducto ?, ?, ?, ?, ?, ?, ?, ?, ?;";
        try(PreparedStatement stm = conec.getconec().prepareStatement(Query)){
            stm.setString(1, this.Nombre);
            stm.setString(2, this.Descripción);
            stm.setString(3, String.valueOf(this.Categoria));
            stm.setFloat(4, this.PrecioCompra);
            stm.setFloat(5, this.PrecioVenta);
            stm.setFloat(6, this.Descuento);
            stm.setLong(7, this.TipoSueloID);
            stm.setLong(8, this.TipoRiegoID);
            stm.setFloat(9, this.TiempoCocecha);
            
            return stm.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
            
            return false;
        }
    }
}
