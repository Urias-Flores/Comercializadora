
package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class ModelTipoSuelo {
    
    private Conection conec = new Conection();
    
    private int TipoSueloID;
    private String Nombre;

    public int getTipoSueloID() {
        return TipoSueloID;
    }

    public void setTipoSueloID(int TipoSueloID) {
        this.TipoSueloID = TipoSueloID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public ArrayList<String> SelectListTipoSuelo(){
        ArrayList<String> list = new ArrayList<>();
        String Query = "SELECT * FROM TIPOSDESUELO;";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next()){
                list.add(rs.getString("Nombre"));
            }
            rs.close();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return list;
    }
    
    public boolean InsertTipoRiego(){
        String Query = "EXECUTE spInsertTipoSuelo ?;";
        try(PreparedStatement ps = conec.getconec().prepareStatement(Query)){
            ps.setString(1,Nombre);
            return ps.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
    
    public DefaultComboBoxModel SelectModelTipoSueloCmb(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        String Query = "SELECT ID, Nombre FROM TIPOSDESUELO";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next()){
                ModelTipoSuelo ts = new ModelTipoSuelo();
                ts.setTipoSueloID(rs.getInt("ID"));
                ts.setNombre(rs.getString("Nombre"));
                model.addElement(ts);
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
