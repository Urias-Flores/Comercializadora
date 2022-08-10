package Models;

import Resources.Conection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModelArqueo {

    private Conection conec = new Conection();

    private int usuarioID;
    private float SaldoAnterior;
    private float SaldoFinalUsuario;
    private float SaldoFinalSistema;
    private float TotalVentas;
    private float TotalCompras;
    private float Diferencia;
    private String Estado;

    public float getSaldoFinalUsuario() {
        return SaldoFinalUsuario;
    }

    public void setSaldoFinalUsuario(float SaldoFinalUsuario) {
        this.SaldoFinalUsuario = SaldoFinalUsuario;
    }

    public float getSaldoFinalSistema() {
        return SaldoFinalSistema;
    }

    public void setSaldoFinalSistema(float SaldoFinalSistema) {
        this.SaldoFinalSistema = SaldoFinalSistema;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Conection getConec() {
        return conec;
    }

    public void setConec(Conection conec) {
        this.conec = conec;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public float getSaldoAnterior() {
        return SaldoAnterior;
    }

    public void setSaldoAnterior(float SaldoAnterior) {
        this.SaldoAnterior = SaldoAnterior;
    }

    public float getTotalVentas() {
        return TotalVentas;
    }

    public void setTotalVentas(float TotalVentas) {
        this.TotalVentas = TotalVentas;
    }

    public float getTotalCompras() {
        return TotalCompras;
    }

    public void setTotalCompras(float TotalCompras) {
        this.TotalCompras = TotalCompras;
    }

    public float getDiferencia() {
        return Diferencia;
    }

    public void setDiferencia(float Diferencia) {
        this.Diferencia = Diferencia;
    }

    public float ObtenerSaldoAnterior() {
        String Query = "select dbo.fnObtenerSaldoAnteriorArqueo()";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            if (rs.next()) {
                this.setSaldoAnterior(rs.getFloat(1));
            }
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return this.SaldoAnterior;
    }
    
    public float ObtenerTotalCompras() {
        String Query = "select dbo.fnObtenerTotalComprasPorDia(cast(getdate() as date))";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            if (rs.next()) {
                this.setTotalCompras(rs.getFloat(1));
            }
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return this.TotalCompras;
    }
    
    public float ObtenerTotalVentas() {
        String Query = "select dbo.fnObtenerTotalVentasPorDia(cast(getdate() as date))";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            if (rs.next()) {
                this.setTotalVentas(rs.getFloat(1));
            }
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return this.TotalVentas;
    }
    
    public float ObtenerSaldoFinal() {
        String Query = "select dbo.fnObtenerSaldoFinalArqueo()";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            if (rs.next()) {
                this.setSaldoFinalSistema(rs.getFloat(1));
            }
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return this.SaldoFinalSistema;
    }
    
    public boolean InsertArqueo() {
        String Query = "EXECUTE spInsertArqueo ?, ?, ?, ?, ?, ?;";
        try (PreparedStatement ps = conec.getconec().prepareStatement(Query)) {
            ps.setInt(1, usuarioID);
            ps.setFloat(2, SaldoAnterior);
            ps.setFloat(3, SaldoFinalSistema);
            ps.setFloat(4, SaldoFinalUsuario);
            ps.setFloat(5, Diferencia);
            ps.setString(6, Estado);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return true;
    }
    
    public DefaultTableModel SelectModelArqueo() {
        DefaultTableModel model = new DefaultTableModel();
        String[] Columns = {"Usuario", "Fecha", "Saldo Inicial", "Saldo Final (Sistema)", "Saldo Final(Usuario)", "Diferencia"};
        model.setColumnIdentifiers(Columns);
        String Query = "SELECT * FROM ARQUEODETALLE";
        try (ResultSet rs = conec.getStatement().executeQuery(Query)) {
            while (rs.next()) {
                String[] row = {rs.getString("Usuario"), rs.getString("Fecha"), rs.getString("Saldo Inicial"), rs.getString("Saldo Final Sistema"), rs.getString("Saldo Final Usuario"), rs.getString("Diferencia")};
                model.addRow(row);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print("ERROR: " + ex.getMessage() + " Codigo: " + ex.getErrorCode());
        }
        return model;
    }

}
