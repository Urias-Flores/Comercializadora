package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ModelCliente {
    private Conection conec = new Conection();
    
    private int ClienteID;
    private String Nombre;
    private String RTN;
    private String Documento;
    private String TipoDocumento;
    private String TipoCliente;

    public Conection getConec() {
        return conec;
    }

    public void setConec(Conection conec) {
        this.conec = conec;
    }

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRTN() {
        return RTN;
    }

    public void setRTN(String RTN) {
        this.RTN = RTN;
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

    public String getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(String TipoCliente) {
        this.TipoCliente = TipoCliente;
    }
    
    public DefaultTableModel SelectModelFinca() {
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"ID", "Nombre", "Propietario", "Ubicación"};
        model.setColumnIdentifiers(Columns);
        String Query = "SELECT * FROM FINCADETALLE";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                String[] row = {rs.getString("ID"), rs.getString("Nombre"), rs.getString("Propietario"), rs.getString("Ubicacion")};
                model.addRow(row);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return model;
    }
    
}
