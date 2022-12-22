package main;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;

public class ControlInventarioTheme extends  FlatLightFlatIJTheme{
    
    public static boolean setup() {
        return setup(new ControlInventarioTheme() );
    }
    
    @Override
    public String getName() {
        return "ControlInventario";
    }
}
