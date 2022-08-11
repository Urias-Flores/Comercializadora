package Models;

import Resources.Conection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ModelAnticipo {

    private Conection conec = new Conection();

    private int AnticipoID;

    public int getAnticipoID() {
        return AnticipoID;
    }

    public void setAnticipoID(int AnticipoID) {
        this.AnticipoID = AnticipoID;
    }
    private String Usuario;
    private int UsuarioID;
    private String Productor;
    private int ProductorID;
    private String Fecha;
    private String Estado;
    private float Total;

    public Conection getConec() {
        return conec;
    }

    public void setConec(Conection conec) {
        this.conec = conec;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public String getProductor() {
        return Productor;
    }

    public void setProductor(String Productor) {
        this.Productor = Productor;
    }

    public int getProductorID() {
        return ProductorID;
    }

    public void setProductorID(int ProductorID) {
        this.ProductorID = ProductorID;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public DefaultTableModel SelectModelAnticipo() {
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"ID", "Usuario", "Productor", "Fecha", "Estado"};
        model.setColumnIdentifiers(Columns);
        String Query = "SELECT * FROM ANTICIPODETALLE";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                String[] row = {rs.getString("Codigo"), rs.getString("Usuario"), rs.getString("Nombre"), rs.getString("Fecha"), rs.getString("Estado")};
                model.addRow(row);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return model;
    }

    public ArrayList SelectAnticipoPorID() {
        ArrayList arrList = new ArrayList();

        String Query = "SELECT * FROM ANTICIPODETALLE WHERE Codigo = " + AnticipoID;
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                this.setAnticipoID(rs.getInt("Codigo"));
                this.setUsuario(rs.getString("Usuario"));
                this.setProductor(rs.getString("Nombre"));
                this.setProductorID(rs.getInt("ProductorID"));
                this.setFecha(rs.getString("Fecha"));
                this.setEstado(rs.getString("Estado"));
                this.setTotal(rs.getFloat("Total"));
                arrList.add(this);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return arrList;
    }

    public boolean InsertAnticipo() {
        String Query = "EXECUTE spInsertAnticipo ?, ?, ?, ?;";
        try (PreparedStatement ps = conec.getconec().prepareStatement(Query)) {
            ps.setInt(1, UsuarioID);
            ps.setInt(2, ProductorID);
            ps.setString(3, Estado);
            ps.setFloat(4, Total);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }

    public boolean UpdateAnticipo() {
        String Query = "EXECUTE spUpdateAnticipo ?, ?, ?, ?, ?;";
        try (PreparedStatement ps = conec.getconec().prepareStatement(Query)) {
            ps.setInt(1, AnticipoID);
            ps.setInt(2, UsuarioID);
            ps.setInt(3, ProductorID);
            ps.setString(4, Estado);
            ps.setFloat(5, Total);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }

    public boolean DeleteAnticipo() {
        String Query = "EXECUTE spDeleteAnticipo ?;";
        try (PreparedStatement ps = conec.getconec().prepareStatement(Query)) {
            ps.setInt(1, AnticipoID);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }

}
