package Models;

import Resources.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModelUsuario {
    
    Conection conec = new Conection();
    
    private int UsuarioID;
    private String Nombre;
    private int EmpleadoID;
    private String Correo;
    private String Numero;
    private String Contrasena;
    private String Acceso;
    private String Token;
    private int Estado;

    public ModelUsuario(int UsuarioID, String Nombre, String Correo, String Numero, String Contrasena, String Acceso, String Token, int Estado) {
        this.UsuarioID = UsuarioID;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Numero = Numero;
        this.Contrasena = Contrasena;
        this.Acceso = Acceso;
        this.Token = Token;
        this.Estado = Estado;
    }
    
    public ModelUsuario() {
        this.UsuarioID = -1;
        this.Nombre = "";
        this.Correo = "";
        this.Numero = "";
        this.Contrasena = "";
        this.Acceso = "";
        this.Token = "";
    }

    public Conection getConec() {
        return conec;
    }

    public void setConec(Conection conec) {
        this.conec = conec;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public int getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoID(int EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getAcceso() {
        return Acceso;
    }

    public void setAcceso(String Acceso) {
        this.Acceso = Acceso;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }
    
    public int IniciarSesion(){
        String sql = "select dbo.VerifyUser('"+Nombre+"', '"+Correo+"', '"+Contrasena+"')";
        try(ResultSet rs = conec.getStatement().executeQuery(sql)){
            if(rs.next())
            {
               return rs.getInt(1);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return -1;
    }
    
    public boolean InsertUsuario(){
        String sql = "EXECUTE spInsertUsuario ?, ?, ?, ?, ?, ?;";
        try(PreparedStatement stm = conec.getconec().prepareStatement(sql)){
            stm.setString(1, Nombre);
            stm.setInt(2, EmpleadoID);
            stm.setString(3, Correo);
            stm.setString(4, Numero);
            stm.setString(5, Contrasena);
            stm.setString(6, Acceso);
            return stm.execute();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return true;
    }
    
    public DefaultTableModel SelectModelUsuarios(){
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = 
        {"ID", "Nombre del empleado", "Nombre de usuario", "Correo Electronico", "Numero Telefonico", "Nivel de acceso"};
        model.setColumnIdentifiers(Columns);
        
        String Query = "SELECT * FROM USUARIOSDETALLES";
        try(ResultSet rs = conec.getStatement().executeQuery(Query)){
            while(rs.next())
            {
                String[] row = {rs.getString("ID"), 
                                rs.getString("Nombre de empleado"),
                                rs.getString("Nombre de usuario"),
                                rs.getString("Correo electronico"),
                                rs.getString("Numero telefonico"),
                                rs.getString("Nivel de acceso")};
                model.addRow(row);
            }
            rs.close();
        }catch(SQLException ex){
            System.out.print("ERROR: "+ex.getMessage()+" Codigo: "+ex.getErrorCode());
        }
        return model;
    }
}
