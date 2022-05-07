package compras.controlador;
import compras.vista.*;

public class clsCuentasPorPagar {
 private int conid; 
 private int comid;
 private int provid;
 private int cuentadoc;
 private Boolean cuentasaldo;
 private Boolean cuentavalor;
 private Boolean cuentareferencia;

    public clsCuentasPorPagar() {
    }

    public clsCuentasPorPagar(int conid, int cuentadoc, Boolean cuentasaldo, Boolean cuentavalor, Boolean cuentareferencia) {
        this.conid = conid;
        this.comid = comid;
        this.provid = provid;
        this.cuentadoc = cuentadoc;
        this.cuentasaldo = cuentasaldo;
        this.cuentavalor = cuentavalor;
        this.cuentareferencia = cuentareferencia;
    }

    public int getConid() {
        return conid;
    }

    public void setConid(int conid) {
        this.conid = conid;
    }
    
    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }

    public int getProvid() {
        return provid;
    }

    public void setProvid(int Provid) {
        this.provid = provid;
    }
    
    public int getCuentadoc() {
        return cuentadoc;
    }

    public void setCuentadoc(int cuentadoc) {
        this.cuentadoc = cuentadoc;
    }

    public Boolean getCuentasaldo() {
        return cuentasaldo;
    }

    public void setCuentasaldo(Boolean cuentasaldo) {
        this.cuentasaldo = cuentasaldo;
    }

    public Boolean getCuentavalor() {
        return cuentavalor;
    }

    public void setCuentavalor(Boolean cuentavalor) {
        this.cuentavalor = cuentavalor;
    }

    public Boolean getCuentareferencia() {
        return cuentareferencia;
    }

    public void setCuentareferencia(Boolean cuentareferencia) {
        this.cuentareferencia = cuentareferencia;
    }
    
    @Override
    public String toString() {
        return "clsCuentasPorPagar{" + "conid=" + conid + ", comid=" + comid + ", provid=" + provid + ", cuentadoc=" + cuentadoc + ", cuentasaldo=" + cuentasaldo + ", cuentavalor=" + cuentavalor + ", cuentareferencia=" + cuentareferencia + '}';
    }
}
