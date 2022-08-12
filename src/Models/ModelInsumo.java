package Models;

import Resources.Conection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

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
        String Query = "EXECUTE spInsertInsumo "+UsuarioID+", "+ProductorID+", '"+Estado+"';";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return 0;
    }
    
    public DefaultTableModel getPreelimar(int ID){
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"Producto", "Cantidad"};
        model.setColumnIdentifiers(Columns);
        String Query = "SELECT * FROM dbo.Preeliminar("+ID+", 'INSUMO')";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                String[] row = {rs.getString("Producto"), 
                                rs.getString("Cantidad")};
                model.addRow(row);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return model;
    }
    
    public int DeleteInsumo(){
        String Query = "EXECUTE spDeleteInsumo ?;";
        try(PreparedStatement ps = conec.getconec().prepareStatement(Query)){
            ps.setInt(1, InsumoID);
            return ps.executeUpdate();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return 0;
    }
}
