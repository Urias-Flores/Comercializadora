package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public DefaultTableModel SelectBodegasTableModel(){
        DefaultTableModel m = new DefaultTableModel();
        String[] Columns = {"ID", "Nombre", "Ubicacion"};
        m.setColumnIdentifiers(Columns);
        
        String Query = "SELECT * FROM BODEGA;";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next())
            {
                String[] row = {rs.getString("BodegaID"), 
                                rs.getString("Nombre"), 
                                rs.getString("Ubicacion")
                };
                m.addRow(row);
            }
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return m;
    }
    
    public boolean InsertBodega(){
        String Query = "EXECUTE spInsertBodega ?, ?;";
        try(PreparedStatement stm = conec.getconec().prepareStatement(Query)){
            stm.setString(1, Nombre);
            stm.setString(2, Ubicacion);
            
            return stm.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
            return true;
        }
    }
}
