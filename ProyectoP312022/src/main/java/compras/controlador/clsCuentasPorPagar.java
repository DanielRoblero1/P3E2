package compras.controlador;
import compras.vista.*;

public class clsCuentasPorPagar {
 private int conid;   
 private String connombre;
 private String conefecto;
private Boolean conestatus;

    public clsCuentasPorPagar() {
    }

    public clsCuentasPorPagar(int conid, String connombre, String conefecto, Boolean conestatus) {
        this.conid = conid;
        this.connombre = connombre;
        this.conefecto = conefecto;
        this.conestatus = conestatus;
    }

    public int getConid() {
        return conid;
    }

    public void setConid(int conid) {
        this.conid = conid;
    }

    public String getConnombre() {
        return connombre;
    }

    public void setConnombre(String connombre) {
        this.connombre = connombre;
    }

    public String getConefecto() {
        return conefecto;
    }

    public void setConefecto(String conefecto) {
        this.conefecto = conefecto;
    }

    public Boolean getConestatus() {
        return conestatus;
    }

    public void setConestatus(Boolean conestatus) {
        this.conestatus = conestatus;
    }

    @Override
    public String toString() {
        return "clsConcepto{" + "conid=" + conid + ", connombre=" + connombre + ", conefecto=" + conefecto + ", conestatus=" + conestatus + '}';
    }
}
