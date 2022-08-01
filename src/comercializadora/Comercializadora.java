package comercializadora;


import Resources.Conection;
import Resources.ConectionLocal;
import Views.LogIn;
import main.Theme;
import java.sql.SQLException;

public class Comercializadora {

    public static void main(String[] args) throws SQLException {
        Conection conection = new Conection();
        ConectionLocal conectionlocal = new ConectionLocal();
        
        if(conectionlocal.getconec() != null){
            if(conection.getconec() != null){
                System.out.println("Conexion establecida exitosamente");
                Theme.setup();
                LogIn m = new LogIn();
                m.setVisible(true);
            }else{
                System.out.println("Conexion no establecida");
            }
        }else{
            System.out.println("Archivo de configuracion no encontrado");
        }
    }
}
