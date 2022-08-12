package Models;

import Resources.Conection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModelPago {
    
    private Conection conec = new Conection();
    
    private int PagoID;
    private int UsuarioID;
    private int ProveedorID;
    private String Estado;
    private Date Fecha;
    private String Tipo;
    private float Total;

    public int getPagoID() {
        return PagoID;
    }

    public void setPagoID(int PagoID) {
        this.PagoID = PagoID;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public int getProveedorID() {
        return ProveedorID;
    }

    public void setProveedorID(int ProveedorID) {
        this.ProveedorID = ProveedorID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
    
    public boolean InsertPago(){
        String Query = "EXECUTE spInsertPago "+UsuarioID+", "+ProveedorID+", "+Total+", '"+Estado+"';";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            if(rs.next()){
                return rs.getInt(1) != 1;
            }
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }
    
    public DefaultTableModel cargarPagos(){
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"ID", "Usuario", "Proveedor", "Fecha", "Estado", "Total"};
        model.setColumnIdentifiers(Columns);
        String Query = "SELECT * FROM PAGODETALLE";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                String[] row = {
                    rs.getString("Codigo"),
                    rs.getString("Usuario"),
                    rs.getString("Proveedor"),
                    rs.getString("Fecha"),
                    rs.getString("Estado"),
                    rs.getString("Total")
                };
                model.addRow(row);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return model;
    }
    
    public String ObtenerSaldo(){
        String Query = "SELECT DBO.SALDOPROVPROD("+ProveedorID+", 1)";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            if (rs.next()) {
                return rs.getString(1);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return "";
    }
}
