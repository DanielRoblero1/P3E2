package compras.controlador;

import compras.vista.*;

public class clsCompras {
 private int comid;   
 private int provid;
 private int comserie;
 private int ordid;
 private int prodid;
 private int ordcantidad;
 private int ordcosto;
 private String comfechaemi;
 private String comfechavenci;

    public clsCompras() {
    }

    public clsCompras(int comid, int provid, int comserie, int ordid, int prodid, int ordcantidad, int ordcosto, String comfechaemi, String comfechavenci) {
        this.comid = comid;
        this.provid = provid;
        this.comserie = comserie;
        this.ordid = ordid;
        this.prodid = prodid;
        this.ordcantidad = ordcantidad;
        this.ordcosto = ordcosto;
        this.comfechaemi = comfechaemi;
        this.comfechavenci = comfechavenci;
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

    public void setProvid(int provid) {
        this.provid = provid;
    }

    public int getComserie() {
        return comserie;
    }

    public void setComserie(int comserie) {
        this.comserie = comserie;
    }

    public int getOrdid() {
        return ordid;
    }

    public void setOrdid(int ordid) {
        this.ordid = ordid;
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public int getOrdcantidad() {
        return ordcantidad;
    }

    public void setOrdcantidad(int ordcantidad) {
        this.ordcantidad = ordcantidad;
    }

    public int getOrdcosto() {
        return ordcosto;
    }

    public void setOrdcosto(int ordcosto) {
        this.ordcosto = ordcosto;
    }

    public String getComfechaemi() {
        return comfechaemi;
    }

    public void setComfechaemi(String comfechaemi) {
        this.comfechaemi = comfechaemi;
    }

    public String getComfechavenci() {
        return comfechavenci;
    }

    public void setComfechavenci(String comfechavenci) {
        this.comfechavenci = comfechavenci;
    }

    @Override
    public String toString() {
        return "clsCompras{" + "comid=" + comid + ", provid=" + provid + ", comserie=" + comserie + ", ordid=" + ordid + ", prodid=" + prodid + ", ordcantidad=" + ordcantidad + ", ordcosto=" + ordcosto + ", comfechaemi=" + comfechaemi + ", comfechavenci=" + comfechavenci + '}';
    }
 
 
 
 

    


 
    
}
