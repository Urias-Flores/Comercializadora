
package Controllers;

import Models.ModelEmpleado;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControllerEmpleado {
    private ModelEmpleado modelEmpleado = new ModelEmpleado();
    private Map<Integer, String> TipoD;
    
    private JTextField EmpleadoID;
    private JTextField Nombre;
    private JTextField Apellidos;
    private JTextField Documento;
    private JComboBox TipoDocumento;
    private JComboBox Dia;
    private JComboBox Mes;
    private JComboBox Anio;
    private JComboBox Sexo;
    private JTextField Domicilio;

    public ControllerEmpleado(JTextField Nombre, JTextField Apellidos, JTextField Documento, JComboBox TipoDocumento, JComboBox Dia, JComboBox Mes, JComboBox Anio, JComboBox Sexo, JTextField Domicilio) {
        TipoD = new HashMap<>();
        TipoD.put(1, "I");
        TipoD.put(2, "P");
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Documento = Documento;
        this.TipoDocumento = TipoDocumento;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Anio = Anio;
        this.Sexo = Sexo;
        this.Domicilio = Domicilio;
    }

    public ControllerEmpleado(JTextField EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }

    public ControllerEmpleado() {
    }
    
    public boolean InsertEmpleado()
    {
        modelEmpleado.setNombre(Nombre.getText());
        modelEmpleado.setApellidos(Apellidos.getText());
        modelEmpleado.setDocumento(Documento.getText());
        modelEmpleado.setTipoDocumento(TipoD.get(TipoDocumento.getSelectedIndex()));
        modelEmpleado.setFechaNacimiento(new Date(Integer.parseInt(Anio.getSelectedItem().toString())-1900, Mes.getSelectedIndex()-1, Dia.getSelectedIndex()));
        modelEmpleado.setSexo(Sexo.getSelectedItem().toString().substring(0, 1));
        modelEmpleado.setDomicilio(Domicilio.getText());
        return modelEmpleado.InsertEmpleado();
    }
    
    public DefaultTableModel SelectEmpleados(){
        return modelEmpleado.SelectSimpleTableModel();
    }
    
    public DefaultTableModel SelectEmpleadosModel(){
        return modelEmpleado.SelectEmpleadosTableModel();
    }
}
