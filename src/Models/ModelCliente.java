package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public DefaultTableModel SelectModelCliente() {
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"ID", "Nombre", "Tipo de Cliente"};
        model.setColumnIdentifiers(Columns);
        String Query = "SELECT * FROM CLIENTEDETALLE";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                String[] row = {rs.getString("ID"), rs.getString("Nombre"), rs.getString("Tipo de Cliente")};
                model.addRow(row);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return model;
    }
    
    public ArrayList SelectClientePorID() {
        ArrayList arrList = new ArrayList();
        String Query = "SELECT * FROM CLIENTEDETALLE WHERE ID = " + ClienteID;
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                this.setClienteID(rs.getInt("ID"));
                this.setNombre(rs.getString("Nombre"));
                this.setRTN(rs.getString("RTN"));
                this.setTipoDocumento(rs.getString("Tipo de documento"));
                this.setDocumento(rs.getString("Documento"));
                this.setTipoCliente(rs.getString("Tipo de Cliente"));
                arrList.add(this);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return arrList;
    }
    
    public boolean InsertCliente() {
        String Query = "EXECUTE spInsertCliente ?, ?, ?, ?, ?;";
        try (PreparedStatement ps = conec.getconec().prepareStatement(Query)) {
            ps.setString(1, Nombre);
            ps.setString(2, RTN);
            ps.setString(3, Documento);
            ps.setString(4, TipoDocumento);
            ps.setString(5, TipoCliente);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }
    
    public boolean UpdateCliente() {
        String Query = "EXECUTE spUpdateCliente ?, ?, ?, ?, ?, ?;";
        try (PreparedStatement ps = conec.getconec().prepareStatement(Query)) {
            ps.setInt(1, ClienteID);
            ps.setString(2, Nombre);
            ps.setString(3, RTN);
            ps.setString(4, Documento);
            ps.setString(5, TipoDocumento);
            ps.setString(6, TipoCliente);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }
    
}
