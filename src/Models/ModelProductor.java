package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModelProductor {
    private Conection conec = new Conection();
    
    private int ProductorID;
    private String Nombre;
    private String Documento;
    private String TipoDocumento;
    private String Numero;
    private String Correo;
    private float Saldo;

    public int getProductorID() {
        return ProductorID;
    }

    public void setProductorID(int ProductorID) {
        this.ProductorID = ProductorID;
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

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }
    
    public boolean InsertProductor(){
        String Query = "EXECUTE spInsertProductor  ?, ?, ?, ?, ?;";
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
    
    public DefaultTableModel SelectModelProductor(){
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"ID", "Nombre", "Documento", "Tipo de documento", "Numero telefonico", "Correo electronico"};
        model.setColumnIdentifiers(Columns);

        String Query = "SELECT * FROM PRODUCTORES";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next()){
                String[] row = {rs.getString("ID"), 
                                rs.getString("Nombre"), 
                                rs.getString("Documento"), 
                                rs.getString("Tipo de documento"),
                                rs.getString("Numero"),
                                rs.getString("Correo")};
                model.addRow(row);
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
