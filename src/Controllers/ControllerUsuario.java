
package Controllers;

import Models.ModelUsuario;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerUsuario {
    
    private ModelUsuario modelUsuario = new ModelUsuario();
    private Map<Integer, String> AccesValue;
    
    private JTextField UsuarioID;
    private JTextField Nombre;
    private JTextField EmpleadoID;
    private JTextField Correo;
    private JTextField Numero;
    private JPasswordField Contrasena;
    private JComboBox Acceso;
    private JTextField Token;

    public ControllerUsuario(JTextField UsuarioID, JTextField Nombre, JTextField Correo, JTextField Numero, JPasswordField Contrasena, JComboBox Acceso, JTextField Token) {
        this.AccesValue = new HashMap<>();
        this.UsuarioID = UsuarioID;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Numero = Numero;
        this.Contrasena = Contrasena;
        this.Acceso = Acceso;
        this.Token = Token;
    }

    public ControllerUsuario(JTextField Nombre, JTextField EmpleadoID, JTextField Correo, JTextField Numero, JPasswordField Contrasena, JComboBox Acceso) {
        this.AccesValue = new HashMap<>();
        AccesValue.put(1, "A");
        AccesValue.put(2, "S");
        AccesValue.put(3, "V");
        
        this.Nombre = Nombre;
        this.EmpleadoID = EmpleadoID;
        this.Correo = Correo;
        this.Numero = Numero;
        this.Contrasena = Contrasena;
        this.Acceso = Acceso;
    }

    public ControllerUsuario(JTextField UsuarioID) {
        this.AccesValue = new HashMap<>();
        this.UsuarioID = UsuarioID;
    }

    public ControllerUsuario(JTextField Nombre, JTextField Correo, JPasswordField Contrasena) {
        this.AccesValue = new HashMap<>();
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Contrasena = Contrasena;
    }

    public ControllerUsuario() {
        
    }
    
    public int IniciarSesion(){
        modelUsuario.setNombre(Nombre.getText());
        modelUsuario.setCorreo(Correo.getText());
        modelUsuario.setContrasena(Contrasena.getText());
        return modelUsuario.IniciarSesion();
    }
    
    public boolean InsertUsuario(){
        modelUsuario.setNombre(Nombre.getText());
        modelUsuario.setEmpleadoID(Integer.parseInt(EmpleadoID.getName()));
        modelUsuario.setCorreo(Correo.getText());
        modelUsuario.setNumero(Numero.getText());
        modelUsuario.setContrasena(Contrasena.getText());
        modelUsuario.setAcceso(AccesValue.get(Acceso.getSelectedIndex()));
        return modelUsuario.InsertUsuario();
    }
    
    public DefaultTableModel SelectModelUsuarios(){
        return modelUsuario.SelectModelUsuarios();
    }
}
