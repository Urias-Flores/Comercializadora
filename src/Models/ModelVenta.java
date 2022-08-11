package Models;

import Resources.Conection;
import Resources.Utilities;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelVenta {
    
    private Conection conec = new Conection();
    
    private int VentaID;
    private int UsuarioID;
    private int ClienteID;
    private String Estado;
    private String Tipo;
    private Date Fecha;

    public int getVentaID() {
        return VentaID;
    }

    public void setVentaID(int VentaID) {
        this.VentaID = VentaID;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    public int InsertVenta(){
        String Query = "EXECUTE spInsertVenta "+UsuarioID+", "+ClienteID+", '"+Estado+"';";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return 0;
    }
}
