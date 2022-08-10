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

    public static String[] ShowAgregarVentaDialog() {
        DialogAgregarVenta dv = new DialogAgregarVenta(null, true);
        dv.setVisible(true);
        return null;
    }
}
