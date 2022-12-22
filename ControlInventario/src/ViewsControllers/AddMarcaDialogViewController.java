package ViewsControllers;

import Controllers.MarcaJpaController;
import Models.Marca;
import Resource.Conection;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddMarcaDialogViewController {
    JTextField Nombre;
    JLabel Error;

    public AddMarcaDialogViewController(JTextField Nombre, JLabel Error) {
        this.Nombre = Nombre;
        this.Error = Error;
    }
    
    public boolean Insert(){
        if(validate()){
            Marca marca = new Marca();
            marca.setNombre(Nombre.getText());
            MarcaJpaController marcaJpaController = new MarcaJpaController(Conection.CreateEntityManager());
            marcaJpaController.create(marca);
            return true;
        }
        return false;
    }
    
    public boolean validate(){
        if(Nombre.getText().isEmpty()){
            Error.setBackground(new Color(185, 0 , 0));
            Error.setText("El nombre de la marca es obligatorio");
            return false;
        }
        if(validateMarcaExist(Nombre.getText())){
            Error.setBackground(new Color(185, 0 , 0));
            Error.setText("El nombre de la marca ingresada ya existe");
            return false;
        }
        return true;
    }
    
    public boolean validateMarcaExist(String marcaIngresar){
        MarcaJpaController marcaJpaController = new MarcaJpaController(Conection.CreateEntityManager());
        List<Marca> marcas = marcaJpaController.findMarcaEntities();
        for(int i = 0; i < marcas.size(); i++){
            if(marcas.get(i).getNombre().equals(marcaIngresar)){
                return true;
            }
        }
        return false;
    }
}
