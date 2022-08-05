
package Models;

import Resources.Conection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModelParcela {
    
    private Conection conec = new Conection();
    
    private int ParcelaID;
    private int FincaID;
    private int ProductoID;
    private int TipoSueloID;
    private int TipoRiegoID;
    private Date FechaCocecha;
    private float Extension;
    private float Cantidad;

    public int getParcelaID() {
        return ParcelaID;
    }

    public void setParcelaID(int ParcelaID) {
        this.ParcelaID = ParcelaID;
    }

    public int getFincaID() {
        return FincaID;
    }

    public void setFincaID(int FincaID) {
        this.FincaID = FincaID;
    }

    public int getProductoID() {
        return ProductoID;
    }

    public void setProductoID(int ProductoID) {
        this.ProductoID = ProductoID;
    }

    public int getTipoSueloID() {
        return TipoSueloID;
    }

    public void setTipoSueloID(int TipoSueloID) {
        this.TipoSueloID = TipoSueloID;
    }

    public int getTipoRiegoID() {
        return TipoRiegoID;
    }

    public void setTipoRiegoID(int TipoRiegoID) {
        this.TipoRiegoID = TipoRiegoID;
    }

    public Date getFechaCocecha() {
        return FechaCocecha;
    }

    public void setFechaCocecha(Date FechaCocecha) {
        this.FechaCocecha = FechaCocecha;
    }

    public float getExtension() {
        return Extension;
    }

    public void setExtension(float Extension) {
        this.Extension = Extension;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    public boolean InsertParcela(){
        String Query = "EXECUTE spInsertParcela ?, ?, ?, ?, ?, ?;";
        try(PreparedStatement ps = conec.getconec().prepareStatement(Query)){
            ps.setInt(1,FincaID);
            ps.setInt(2, ProductoID);
            ps.setInt(3, TipoSueloID);
            ps.setInt(4, TipoRiegoID);
            ps.setFloat(5, Extension);
            ps.setFloat(6, Cantidad);
            return ps.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
    
    public DefaultTableModel SelectModelParcelaDetalle(){
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"Parcela", "Finca", "Propietario", "Bodega", "Producto"};
        model.setColumnIdentifiers(Columns);
        String Query = "select * from PARCELADETALLES";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next()){
                String[] row = {
                    rs.getString("Parcela"), rs.getString("Finca"), rs.getString("Propietario"), rs.getString("Bodega"), rs.getString("Producto")
                };
                model.addRow(row);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return model;
    }
    
    public DefaultTableModel SelectModelParcela(){
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"ID", "Finca", "Propietario", "Tipo de Suelo", "Tipo de Riego", "Extensión", "Cantidad de Cosecha", "Fecha de Cosecha"};
        model.setColumnIdentifiers(Columns);
        String Query = "select * from PARCELAS";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next()){
                String[] row = {
                    rs.getString("ID"),
                    rs.getString("Finca"),
                    rs.getString("Dueno"),
                    rs.getString("Tipo de Suelo"),
                    rs.getString("Tipo de Riego"),
                    rs.getString("Extension"),
                    rs.getString("Cantidad/Cosechada"),
                    rs.getString("Fecha/Cosecha")
                };
                model.addRow(row);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return model;
    }
}
