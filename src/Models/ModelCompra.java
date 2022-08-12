
package Models;

import Resources.Conection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModelCompra {
    
    private Conection conec = new Conection();
    
    private int CompraID;
    private int UsuarioID;
    private int ProductorID;
    private int ProveedorID;
    private String Estado;
    private Date Fecha;
    private Date FechaVencimiento;

    public int getCompraID() {
        return CompraID;
    }

    public void setCompraID(int CompraID) {
        this.CompraID = CompraID;
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

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }
    
    public int InsertVenta(String type){
        String Query = "";
        if(type.equals("prod")){
            Query = "EXECUTE spInsertCompra "+UsuarioID+",  "+ProductorID+", null, '"+Estado+"';";
        }else if(type.equals("prov")){
            Query = "EXECUTE spInsertCompra "+UsuarioID+",  null,"+ProveedorID+", '"+Estado+"';";
        }
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
        String Query = "SELECT * FROM dbo.Preeliminar("+ID+", 'COMPRA')";
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
}
