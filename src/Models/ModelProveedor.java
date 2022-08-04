package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModelProveedor {
    
    private Conection conec = new Conection();
    
    private int ProveedorID;
    private String Nombre;
    private String Documento;
    private String TipoDocumento;
    private String Numero;
    private String Correo;

    public int getProveedorID() {
        return ProveedorID;
    }

    public void setProveedorID(int ProveedorID) {
        this.ProveedorID = ProveedorID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    public boolean InsertProveedor(){
        String Query = "EXECUTE spInsertProveedor ?, ?, ?, ?, ?;";
        try(PreparedStatement stm = conec.getconec().prepareStatement(Query)){
            stm.setString(1, Nombre);
            stm.setString(2, Documento);
            stm.setString(3, TipoDocumento);
            stm.setString(4, Numero);
            stm.setString(5, Correo);
            return stm.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
    
    public DefaultTableModel SelectModelProveedor(){
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"ID", "Nombre", "Documento", "Tipo de documento"};
        model.setColumnIdentifiers(Columns);
        
        String Query = "SELECT * FROM PROVEEDORDETALLES";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next()){
                String[] row = {rs.getString("ID"), 
                                rs.getString("Nombre"), 
                                rs.getString("Documento"), 
                                rs.getString("Tipo de documento")};
                model.addRow(row);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return model;
    }
}
