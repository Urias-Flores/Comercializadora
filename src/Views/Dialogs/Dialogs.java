package Views.Dialogs;

import java.util.ArrayList;

public class Dialogs {
    
    public static int ERRORMessage = -1, WARNINGMessage = 0, COMPLETEMessage = 1;
    
    public static boolean ShowCloseDialog(){
        DialogCloseSesion dc = new DialogCloseSesion(null, true);
        dc.setVisible(true);
        return dc.isAcces();
    }
    
    public static void ShowMessageDialog(String Message, int icon){
        DialogMessage dm = new DialogMessage(null, true);
        dm.setIcon(icon);
        dm.setMessage(Message);
        dm.setVisible(true);
    }
    
    public static boolean ShowLogerSecureDialog(String Text1, String Text2, String Text3){
        DialogLogerSecure ds = new DialogLogerSecure(null, true);
        ds.setText(Text1, Text2, Text3);
        ds.setVisible(true);
        return ds.isAcces();
    }
    
    public static ArrayList<String> ShowListaEmpleadosDialog(){
        DialogListaEmpleados dle = new DialogListaEmpleados(null, true);
        dle.setVisible(true);
        return dle.getResult();
    }
}
