
package jpa_prueba.Views.Dialogs;

import javax.swing.JFrame;

public class Dialogs {
    
    public static int ADD = -1;
    
    public static void ShowDialog(int ID, JFrame Patern){
        Agregar ag = new Agregar(Patern, true);
        if(ID < 0){
            ag.setVisible(true);
        }
    }
}
