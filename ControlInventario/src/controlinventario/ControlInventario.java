package controlinventario;

import Resource.Conection;
import Views.Login;
import main.ControlInventarioTheme;

public class ControlInventario {

    public static void main(String[] args) {
        Conection conec = new Conection();
        if(conec != null){
            ControlInventarioTheme.setup();
            System.out.println("La conexion con el servidor ha sido exitosa!");
            new Login().setVisible(true);
        }else{
            System.err.println("La conexion con el servidor no se pudo establecer");
        }
    }
}
