package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conection {

    private static Connection conec;
    //private static Information INFO = new Information();
    private static Statement stm;
    private String ip, port, user, password, database, timeout;
    
    public Statement getStatement()
    {
        try{
            stm = conec.createStatement();
        }catch(SQLException ex){
               System.out.print(ex.getMessage());
        }
        return stm;
    }
    
    public Connection getconec()
    {
        return conec;
    }
    
    public Conection()
    {
        if(conec == null)
        {
            ip = "localhost\\SQLEXPRESS";
            port = "1433";
            user = "sa";
            password = "340$Uuxwp7Mcxo7Khy";
            database = "Comercializadora";
            timeout = "100";
            try{
                String url = "jdbc:sqlserver://"+ip+":"+port+";"
                        + "database="+database+";"
                        + "user="+user+";"
                        + "password="+password+";"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout="+timeout+";";
                conec = DriverManager.getConnection(url);
            }catch(SQLException ex){
                System.out.print(ex.getMessage());
            }
        }
    }
    
    public Connection tryConexion(String ip, String port, String user, String password, String driver, String database)
    {
        Connection c = null;
        try{
            Class.forName(driver);
            String url = "jdbc:mysql://"+ip+":"+port+"/"+database;
            c = DriverManager.getConnection(url, user , password);
        }catch(ClassNotFoundException | SQLException ex){
            System.out.print(ex.getMessage());
        }
        return c;
    }
    
    public void closeConec()
    {
        try {
            conec.close();
            conec = null;
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
