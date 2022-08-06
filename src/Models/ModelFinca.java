package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ModelFinca {

    private Conection conec = new Conection();

    private int FincaID;
    private String Nombre;
    private int ProductorID;
    private String Ubicacion;

    public int getFincaID() {
        return FincaID;
    }

    public void setFincaID(int FincaID) {
        this.FincaID = FincaID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getProductorID() {
        return ProductorID;
    }

    public void setProductorID(int ProductorID) {
        this.ProductorID = ProductorID;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
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

    public ArrayList SelectFincaPorID() {
        ArrayList<Object> arrList = new ArrayList<>();
        String Query = "SELECT * FROM FINCADETALLE WHERE ID = " + FincaID;
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                ModelFinca mf = new ModelFinca();
                this.setFincaID(rs.getInt("ID"));
                this.setNombre(rs.getString("Nombre"));
                this.setProductorID(rs.getInt("ProductorID"));
                this.setUbicacion(rs.getString("Ubicacion"));
                arrList.add(this);
                
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return arrList;
    }

    public DefaultComboBoxModel SelectModelFincaCmb() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        String Query = "SELECT * FROM FINCADETALLE";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                ModelFinca finc = new ModelFinca();
                finc.setFincaID(rs.getInt("ID"));
                finc.setNombre(rs.getString("Nombre"));
                model.addElement(finc);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return model;
    }
    
    public boolean UpdateFinca() {
        String Query = "EXECUTE spUpdateFinca ?, ?, ?, ?;";
        try (PreparedStatement ps = conec.getconec().prepareStatement(Query)) {
            ps.setInt(1, FincaID);
            ps.setInt(2, ProductorID);
            ps.setString(3, Nombre);
            ps.setString(4, Ubicacion);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }

    public boolean InsertFinca() {
        String Query = "EXECUTE spInsertFinca ?, ?, ?;";
        try (PreparedStatement ps = conec.getconec().prepareStatement(Query)) {
            ps.setInt(1, ProductorID);
            ps.setString(2, Nombre);
            ps.setString(3, Ubicacion);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }

    public boolean DeleteFinca() {
        String Query = "EXECUTE spDeleteFinca ?;";
        try (PreparedStatement ps = conec.getconec().prepareStatement(Query)) {
            ps.setInt(1, FincaID);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
    
}
