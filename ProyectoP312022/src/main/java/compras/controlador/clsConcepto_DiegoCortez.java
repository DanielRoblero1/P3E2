package compras.controlador;
import compras.vista.*;

public class clsConcepto_DiegoCortez {
 private int conid;   
 private String connombre;
 private Boolean conefecto;
private Boolean conestatus;

    public clsConcepto_DiegoCortez() {
    }

    public clsConcepto_DiegoCortez(int conid, String connombre, Boolean conefecto, Boolean conestatus) {
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

    public Boolean getConefecto() {
        return conefecto;
    }

    public void setConefecto(Boolean conefecto) {
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
