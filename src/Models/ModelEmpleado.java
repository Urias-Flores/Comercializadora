
package Models;

import Resources.Conection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModelEmpleado {
    private Conection conec = new Conection();
    
    private int EmpleadoID;
    private String Nombre;
    private String Apellidos;
    private String Documento;
    private String TipoDocumento;
    private Date FechaNacimiento;
    private String sexo;
    private String Domicilio;

    public ModelEmpleado(int EmpleadoID, String Nombre, String Apellidos, String Documento, String TipoDocumento, Date FechaNacimiento, String sexo, String Domicilio) {
        this.EmpleadoID = EmpleadoID;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Documento = Documento;
        this.TipoDocumento = TipoDocumento;
        this.FechaNacimiento = FechaNacimiento;
        this.sexo = sexo;
        this.Domicilio = Domicilio;
    }
    
    public ModelEmpleado() {
        this.EmpleadoID = -1;
        this.Nombre = "";
        this.Apellidos = "";
        this.Documento = "";
        this.TipoDocumento = "";
        this.FechaNacimiento = null;
        this.sexo = "";
        this.Domicilio = "";
    }

    public int getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoID(int EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
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

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }
    
    public boolean InsertEmpleado(){
        String Query = "EXECUTE spInsertEmpleado ?, ?, ?, ?, ?, ?, ?;";
        try(PreparedStatement stm = conec.getconec().prepareStatement(Query)){
            stm.setString(1, Nombre);
            stm.setString(2, Apellidos);
            stm.setString(3, Documento);
            stm.setString(4, TipoDocumento);
            stm.setDate(5, FechaNacimiento);
            stm.setString(6, sexo);
            stm.setString(7, Domicilio);
            return stm.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
    
    public DefaultTableModel SelectSimpleTableModel(){
        DefaultTableModel m = new DefaultTableModel();
        String[] Columns = {"ID", "Nombre", "Documento"};
        m.setColumnIdentifiers(Columns);
        
        String Query = "SELECT * FROM SELECTEMPLEADO";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next())
            {
                String[] row = {rs.getString("ID"), 
                                rs.getString("Nombre"), 
                                rs.getString("Documento")};
                m.addRow(row);
            }
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return m;
    }
    
    public DefaultTableModel SelectEmpleadosTableModel(){
        DefaultTableModel m = new DefaultTableModel();
        String[] Columns = {"ID", "Nombre completo", "Documento", "Tipo de documento", "Edad", "Sexo"};
        m.setColumnIdentifiers(Columns);
        
        String Query = "SELECT * FROM EMPLEADODETALLE;";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next())
            {
                String[] row = {rs.getString("ID"), 
                                rs.getString("Nombre completo"), 
                                rs.getString("Documento"),
                                rs.getString("Tipo de documento"),
                                rs.getString("Edad"),
                                rs.getString("Sexo")};
                m.addRow(row);
            }
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return m;
    }
}
