
package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelTipoRiego {
    
    private Conection conec = new Conection();
    
    private int TipoRiegoID;
    private String Nombre;

    public int getTipoRiegoID() {
        return TipoRiegoID;
    }

    public void setTipoRiegoID(int TipoRiegoID) {
        this.TipoRiegoID = TipoRiegoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public ArrayList<String> SelectListTipoRiego(){
        ArrayList<String> list = new ArrayList();
        String Query = "SELECT * FROM TIPOSDERIEGO;";
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
        String Query = "EXECUTE spInsertTipoRiego ?;";
        try(PreparedStatement ps = conec.getconec().prepareStatement(Query)){
            ps.setString(1,Nombre);
            return ps.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
}
