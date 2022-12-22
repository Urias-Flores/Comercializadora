import Views.Dialogs.Dialogs;
import main.ControlInventarioTheme;

public class TestDialog {
    
    public static void main(String[] args){
        ControlInventarioTheme.setup();
        Dialogs.ShowEnterPasswordDialog("Primer texto", "Segundo texto", "Tercer Texto", Dialogs.WARNING_ICON);
        System.exit(0);
    }
}
