
package Controllers;

import Models.ModelArqueo;
import javax.swing.table.DefaultTableModel;

public class ControllerArqueo {
    private ModelArqueo mArqueo = new ModelArqueo();
    
    public float ObtenerSaldoAnterior() {
        return mArqueo.ObtenerSaldoAnterior();
    }
    
    public float ObtenerSaldoFinal() {
        return mArqueo.ObtenerSaldoFinal();
    }
    
    public float ObtenerTotalCompras() {
        return mArqueo.ObtenerTotalCompras();
    }
    
    public float ObtenerTotalVentas() {
        return mArqueo.ObtenerTotalVentas();
    }
    
    public boolean InsertArqueo(int usuarioID, float SaldoAnterior, float SaldoFinalSistema, float SaldoFinalUsuario, float Diferencia, String Estado) {
        mArqueo.setUsuarioID(usuarioID);
        mArqueo.setSaldoAnterior(SaldoAnterior);
        mArqueo.setSaldoFinalSistema(SaldoFinalSistema);
        mArqueo.setSaldoFinalUsuario(SaldoFinalUsuario);
        mArqueo.setDiferencia(Diferencia);
        mArqueo.setEstado(Estado);
        return mArqueo.InsertArqueo();
    }
    
    public DefaultTableModel SelectModelArqueo() {
        return mArqueo.SelectModelArqueo();
    }
}
