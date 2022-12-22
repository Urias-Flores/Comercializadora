package ViewsControllers;

import Resource.Utilities;
import Views.Main;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginViewController {
    private JFrame Instance;
    private JTextField Nombre;
    private JPasswordField Contrasena;
    private JCheckBox Recordarme;
    private JLabel Error;
    private JLabel IniciarSesion;
    private JLabel Olvidaste;

    public LoginViewController(JFrame Instance, JTextField Nombre, JPasswordField Contrasena, JCheckBox Recordarme, JLabel Error, JLabel IniciarSesion, JLabel Olvidaste) {
        this.Instance = Instance;
        this.Nombre = Nombre;
        this.Contrasena = Contrasena;
        this.Recordarme = Recordarme;
        this.Error = Error;
        this.IniciarSesion = IniciarSesion;
        this.Olvidaste = Olvidaste;
    }
    
    public void IniciarSesion(){
        if(valite()){
            int resultado = Utilities.IniciarSesion(Nombre.getText(), Contrasena.getText());
            switch (resultado) {
                case -2:
                    Error.setText("El usuario ingresado se encuentra desactivado");
                    break;
                case -1:
                    Error.setText("El usuario ingresado no existe");
                    break;
                case 0:
                    Error.setText("La contraseña es incorrecta");
                    break;
                default:
                    Main m = new Main();
                    Utilities.setUsuarioActual(resultado, Nombre.getText());
                    m.setVisible(true);
                    m.Cargar(Instance, Nombre.getText());
                    Instance.setVisible(false);
                    break;
            }
        }
    }
    
    private boolean valite(){
        if(Nombre.getText().isEmpty() || Nombre.getForeground().equals(new Color(180, 180, 180))){
            Error.setText("Ingrese el nombre de usuario");
            return false;
        }
        if(Contrasena.getText().isEmpty() || Nombre.getForeground().equals(new Color(180, 180, 180))){
            Error.setText("Ingrese la contraseña");
            return false;
        }
        return true;
    }
}
