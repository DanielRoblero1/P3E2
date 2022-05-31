package compras.controlador;

import compras.vista.*;
import java.util.Date;

public class clsOrdenesCompras {
 private int ordid; 
 private int ordcdetalleid;  
 private String ordfecha;
 private int ordcantidad;
 private int ordcosto;
 private int provid;
 private int prodid;
 
 

    public clsOrdenesCompras() {
    }

    public clsOrdenesCompras(int ordid, int ordcdetalleid, String ordfecha, int ordcantidad, int ordcosto, int provid, int prodid) {
        this.ordid = ordid;
        this.ordcdetalleid = ordcdetalleid;
        this.ordfecha = ordfecha;
        this.ordcantidad = ordcantidad;
        this.ordcosto = ordcosto;
        this.provid = provid;
        this.prodid = prodid;
    }

    public int getordid() {
        return ordid;
    }

    public void setordid(int ordid) {
        this.ordid = ordid;
    }
 

    public String getordfecha() {
        return ordfecha;
    }

    public void setordfecha(String ordfecha) {
        this.ordfecha = ordfecha;
    }

    public int getordcantidad() {
        return ordcantidad;
    }

    public void setordcantidad(int ordcantidad) {
        this.ordcantidad = ordcantidad;
    }

    public int getordcosto() {
        return ordcosto;
    }

    public void setordcosto(int ordcosto) {
        this.ordcosto = ordcosto;
    }
    public int getprovid() {
        return provid;
    }

    public void setprovid(int provid) {
        this.provid = provid;
    }

    public int getprodid() {
        return prodid;
    }

    public void setprodid(int prodid) {
        this.prodid = prodid;
    }

    public int getOrdcdetalleid() {
        return ordcdetalleid;
    }

    public void setOrdcdetalleid(int ordcdetalleid) {
        this.ordcdetalleid = ordcdetalleid;
    }

    @Override
    public String toString() {
        return "clsProducto{" + "ordid=" + ordid + "ordcdetalleid=" + ordcdetalleid + ", ordfecha=" + ordfecha + ", provid=" + provid + ", prodid=" + prodid + ", ordcantidad=" + ordcantidad + ", ordcosto=" + ordcosto  + '}';
    }
    

    


 
    
}
