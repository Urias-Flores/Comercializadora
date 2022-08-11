package Views.Dialogs;

import java.util.ArrayList;
import javax.swing.JTextField;

public class Dialogs {

    public static int ERRORMessage = -1, WARNINGMessage = 0, COMPLETEMessage = 1;

    public static boolean ShowCloseDialog() {
        DialogCloseSesion dc = new DialogCloseSesion(null, true);
        dc.setVisible(true);
        return dc.isAcces();
    }

    public static boolean ShowDeleteFincaDialog() {
        DialogDeleteFinca dc = new DialogDeleteFinca(null, true);
        dc.setVisible(true);
        return dc.ok;
    }

    public static boolean ShowDeleteParcelaDialog() {
        DialogDeleteParcela dp = new DialogDeleteParcela(null, true);
        dp.setVisible(true);
        return dp.ok;
    }

    public static void ShowMessageDialog(String Message, int icon) {
        DialogMessage dm = new DialogMessage(null, true);
        dm.setIcon(icon);
        dm.setMessage(Message);
        dm.setVisible(true);
    }

    public static boolean ShowLogerSecureDialog(String Text1, String Text2, String Text3) {
        DialogLogerSecure ds = new DialogLogerSecure(null, true);
        ds.setText(Text1, Text2, Text3);
        ds.setVisible(true);
        return ds.isAcces();
    }

    public static ArrayList<String> ShowListaEmpleadosDialog() {
        DialogListaEmpleados dle = new DialogListaEmpleados(null, true);
        dle.setVisible(true);
        return dle.getResult();
    }
    
    public static boolean ShowNuevaBodegaDialog(){
        DialogNuevaBodega dnb = new DialogNuevaBodega(null, true);
        dnb.setVisible(true);
        
        return dnb.isConfirm();
    }

    public static void ShowInformacionProveedorDialog(JTextField ProveedorID) {
        DialogInformacionProveedor dip = new DialogInformacionProveedor(null, true);
        dip.setProveedorID(ProveedorID);
        dip.Load();
        dip.setVisible(true);
    }

    public static void ShowInformacionClienteDialog(int ClienteID) {
        DialogInformacionCliente dic = new DialogInformacionCliente(null, true);
        System.out.println(ClienteID);
        dic.setClienteID(ClienteID);
        dic.Load();
        dic.setVisible(true);
    }

    public static ArrayList<Object> ShowAgregarVentaDialog(String ID, String type){
        DialogAgregarVenta dv = new DialogAgregarVenta(null, true);
        dv.setID(ID);
        dv.setType(type);
        dv.Load();
        dv.setVisible(true);
        return dv.getData();
    }
    
    public static ArrayList<String> ShowSeleccionarClientProduc(String type){
        DialogSelectClientProduc dscp = new DialogSelectClientProduc(null, true);
        dscp.setType(type);
        dscp.Load();
        dscp.setVisible(true);
        return dscp.getData();
    }
    
    public static boolean ShowAdvertecimentDialog(String text){
        DialogAdvertesiment da = new DialogAdvertesiment(null, true);
        da.setText(text);
        da.setVisible(true);
        return da.isAcces();
    }
}
