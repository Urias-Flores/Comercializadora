package Models;

import Resources.Conection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelInsumo {
    
    private Conection conec = new Conection();
    
    private int InsumoID;
    private int UsuarioID;
    private int ProductorID;
    private Date Fecha;
    private Date FechaVencimiento;
    private String Estado;

    public int getInsumoID() {
        return InsumoID;
    }

    public void setInsumoID(int InsumoID) {
        this.InsumoID = InsumoID;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public int getProductorID() {
        return ProductorID;
    }

    public void setProductorID(int ProductorID) {
        this.ProductorID = ProductorID;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public int InsertInsumo(){
        String Query = "EXECUTE spInsertVenta "+UsuarioID+", "+ProductorID+", '"+Estado+"';";
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
