package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ModelBodega {
    //Conexion a la base de datos principal
    private Conection conec = new Conection();
    
    //Propiedades
    private long BodegaID;
    private String Nombre;
    private String Ubicacion;
    
    public ModelBodega() {
        this.BodegaID = 0;
        this.Nombre = "";
        this.Ubicacion = "";
    }
    
    public ModelBodega(long BodegaID, String Nombre, String Ubicacion) {
        this.BodegaID = BodegaID;
        this.Nombre = Nombre;
        this.Ubicacion = Ubicacion;
    }
    
    //Getters & Setters
    public long getBodegaId() {
        return this.BodegaID;
    }

    public void setBodegaId(long BodegaID) {
        this.BodegaID = BodegaID;
    }
    
    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public String getUbicacion() {
        return this.Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    
    public boolean InsertBodega(){
        String Query = "EXECUTE spInsertBodega ?, ?;";
        try(PreparedStatement ps = conec.getconec().prepareStatement(Query)){
            ps.setString(1, Nombre);
            ps.setString(2, Ubicacion);
            return ps.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
    
    public DefaultComboBoxModel SelectListBodegas(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("-- Seleccione --");
        String Query = "SELECT Nombre FROM BODEGA";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next())
            {
                model.addElement(rs.getString("Nombre"));
            }
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return model;
    }
    
    public DefaultTableModel SelectBodegasTableModel(){
        DefaultTableModel m = new DefaultTableModel();
        String[] Columns = {"ID", "Bodega", "Producto", "Cantidad", "Estado"};
        m.setColumnIdentifiers(Columns);
        
        String Query = "SELECT * FROM EXITENCIADETALLADA";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next())
            {
                String[] row = {rs.getString("ID"),
                                rs.getString("Bodega"), 
                                rs.getString("Producto"), 
                                rs.getString("Cantidad"),
                                rs.getString("Estado")
                };
                m.addRow(row);
            }
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return m;
    }
}
