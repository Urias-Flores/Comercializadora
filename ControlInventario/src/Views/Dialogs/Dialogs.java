package Views.Dialogs;

public class Dialogs {
    
    public static int DELETE_ICON = -2;
    public static int WARNING_ICON = -1;
    public static int ERROR_ICON = 0;
    public static int COMPLETE_ICON = 1;
    
    public static void ShowGeneralDialog(String texto, int Icono){
        GeneralDialog gd = new GeneralDialog(null, true);
        gd.setText(texto);
        gd.setIcon(Icono);
        gd.setVisible(true);
        gd.dispose();
    }
    
    public static boolean ShowOKCancelDialog(String texto, int Icono){
        OkCancelDialog ocd = new OkCancelDialog(null, true);
        ocd.setText(texto);
        ocd.setIcon(Icono);
        ocd.setVisible(true);
        boolean result = ocd.getValue();
        ocd.dispose();
        return result;
    }
    
    public static boolean ShowEnterPasswordDialog(String text, String text1, String text2, int Icon){
        EnterPasswordDialogs epd = new EnterPasswordDialogs(null, true);
        epd.setText(text);
        epd.setText1(text1);
        epd.setText2(text2);
        epd.setIcon(Icon);
        epd.setVisible(true);
        return false;
    }
    
    public static void ShowAddProductoDialog(){
        AddProductoDialog pd = new AddProductoDialog(null, true);
        pd.setVisible(true);
        pd.dispose();
    }
    
    public static void ShowAddCompraDialog(){
        AddCompraDialog cd = new AddCompraDialog(null, true);
        cd.setVisible(true);
        cd.dispose();
    }
    
    public static void ShowAddVentaDialog(){
        AddVentaDialog vd = new AddVentaDialog(null, true);
        vd.setVisible(true);
        vd.dispose();
    }
    
    public static void ShowAddProveedorDialog(){
        AddProveedorDialog pd = new AddProveedorDialog(null, true);
        pd.setVisible(true);
        pd.dispose();
    }
    
    public static void ShowAddClienteDialog(){
        AddClienteDialog cd = new AddClienteDialog(null, true);
        cd.setVisible(true);
        cd.dispose();
    }
    
    public static void ShowAddUsuarioDialog(){
        AddUsuarioDialog ud = new AddUsuarioDialog(null, true);
        ud.setVisible(true);
        ud.dispose();
    }
    
    public static void ShowAddEmpleadoDialog(){
        AddEmpleadoDialog ed = new AddEmpleadoDialog(null, true);
        ed.setVisible(true);
        ed.dispose();
    }
    
    public static void ShowMarcasDialog(){
        MarcasDialog md = new MarcasDialog(null, true);
        md.setVisible(true);
        md.dispose();
    }
    
    public static void ShowCategoriasDialog(){
        CategoriasDialog md = new CategoriasDialog(null, true);
        md.setVisible(true);
        md.dispose();
    }
    
    public static void ShowAddMarcaDialog(){
        AddMarcaDialog md = new AddMarcaDialog(null, true);
        md.setVisible(true);
        md.dispose();
    }
    
    public static void ShowAddCategoriaDialog(){
        AddCategoriaDialog md = new AddCategoriaDialog(null, true);
        md.setVisible(true);
        md.dispose();
    }
}
