package compras.controlador;
//revert
public class clsProveedorDanielRoblero {
    private int provid;
    private String provnombre;
    private int provsaldo;
    private Boolean provestado;
    private int provtelefono;
    private String provdireccion;

    public clsProveedorDanielRoblero() {
    }

    public clsProveedorDanielRoblero(int provid) {
        this.provid = provid;
    }
    
    public clsProveedorDanielRoblero(String provnombre, Boolean provestado) {
        this.provnombre = provnombre;
        this.provestado = provestado;
    }
    
    public clsProveedorDanielRoblero(int provid, String provnombre, Boolean provestado) {
        this.provid = provid;
        this.provnombre = provnombre;
        this.provestado = provestado;
    }
    

    public int getprovid() {
        return provid;
    }

    public void setprovid(int provid) {
        this.provid = provid;
    }

    public String getprovnombre() {
        return provnombre;
    }

    public void setprovnombre(String provnombre) {
        this.provnombre = provnombre;
    }

    public Boolean getprovestado() {
        return provestado;
    }

    public void setprovestado(Boolean provestado) {
        this.provestado = provestado;
    }
    
    public int getprovtelefono() {
        return provtelefono;
    }

    public void setprovtelefono(int provtelefono) {
        this.provtelefono = provtelefono;
    }

    public String getprovtdireccion() {
        return provdireccion;
    }

    public void setprovtdireccion(String provdireccion) {
        this.provdireccion = provdireccion;
    }
    public int getprovsaldo() {
        return provsaldo;
    }

    public void setprovsaldo(int provsaldo) {
        this.provsaldo = provsaldo;
    }
    @Override
    public String toString() {
        return "tbl_proveedor{" + "provid=" + provid + ", provnombre=" + provnombre + ", provsaldo=" + provsaldo + ", provestado=" + provestado + ", provtelefono=" + provtelefono + ", provdireccion" + provdireccion + '}';
    }
    
    
}
