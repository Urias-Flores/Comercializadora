package jpa_prueba;

import com.formdev.flatlaf.FlatLightLaf;
import jpa_prueba.Views.Main;

public class JPA_prueba {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        Main v = new Main();
        v.setVisible(true);
    }
    
}
