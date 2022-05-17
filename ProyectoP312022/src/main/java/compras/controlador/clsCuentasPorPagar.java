package compras.controlador;
import compras.vista.*;

public class clsCuentasPorPagar {
 private int cuentapagarid;   
 private int conid; 
 private int comid;
 private int provid;
 private int cuentadoc;
 private int cuentasaldo;
 private int cuentavalor;
 private int cuentareferencia;

    public clsCuentasPorPagar() {
    }

    public clsCuentasPorPagar(int cuentapagarid, int conid, int cuentadoc, int cuentasaldo, int cuentavalor, int cuentareferencia) {
        this.cuentapagarid = cuentapagarid;
        this.conid = conid;
        this.comid = comid;
        this.provid = provid;
        this.cuentadoc = cuentadoc;
        this.cuentasaldo = cuentasaldo;
        this.cuentavalor = cuentavalor;
        this.cuentareferencia = cuentareferencia;
    }

    public int getCuentapagarid() {
        return cuentapagarid;
    }

    public void setCuentapagarid(int cuentapagarid) {
        this.cuentapagarid = cuentapagarid;
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

    public int getCuentasaldo() {
        return cuentasaldo;
    }

    public void setCuentasaldo(int cuentasaldo) {
        this.cuentasaldo = cuentasaldo;
    }

    public int getCuentavalor() {
        return cuentavalor;
    }

    public void setCuentavalor(int cuentavalor) {
        this.cuentavalor = cuentavalor;
    }

    public int getCuentareferencia() {
        return cuentareferencia;
    }

    public void setCuentareferencia(int cuentareferencia) {
        this.cuentareferencia = cuentareferencia;
    }
    
    @Override
    public String toString() {
        return "clsCuentasPorPagar{" + "cuentapagarid=" + cuentapagarid + "conid=" + conid + ", comid=" + comid + ", provid=" + provid + ", cuentadoc=" + cuentadoc + ", cuentasaldo=" + cuentasaldo + ", cuentavalor=" + cuentavalor + ", cuentareferencia=" + cuentareferencia + '}';
    }
}
