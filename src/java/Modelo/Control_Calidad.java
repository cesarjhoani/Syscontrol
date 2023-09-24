package Modelo;

import java.util.Date;

/**
 *
 * @author Juan David
 */
public class Control_Calidad {

    private int idControl_Calidad;
    private Date fecha ;
    private String lote ;
    private int num_tanque;
    private double valor_1;
    private double valor_2;
    private double valor_3;
    private double valor_4;
    private double valor_5;
    
    // <editor-fold defaultstate="collapsed" desc="Metodo Get y Set"> 

    public int getIdControl_Calidad() {
        return idControl_Calidad;
    }

    public void setIdControl_Calidad(int idControl_Calidad) {
        this.idControl_Calidad = idControl_Calidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getNum_tanque() {
        return num_tanque;
    }

    public void setNum_tanque(int num_tanque) {
        this.num_tanque = num_tanque;
    }

    public double getValor_1() {
        return valor_1;
    }

    public void setValor_1(double valor_1) {
        this.valor_1 = valor_1;
    }

    public double getValor_2() {
        return valor_2;
    }

    public void setValor_2(double valor_2) {
        this.valor_2 = valor_2;
    }

    public double getValor_3() {
        return valor_3;
    }

    public void setValor_3(double valor_3) {
        this.valor_3 = valor_3;
    }

    public double getValor_4() {
        return valor_4;
    }

    public void setValor_4(double valor_4) {
        this.valor_4 = valor_4;
    }

    public double getValor_5() {
        return valor_5;
    }

    public void setValor_5(double valor_5) {
        this.valor_5 = valor_5;
    }

    public double getValor_6() {
        return Valor_6;
    }

    public void setValor_6(double Valor_6) {
        this.Valor_6 = Valor_6;
    }

    public int getProductos_idProductos() {
        return Productos_idProductos;
    }

    public void setProductos_idProductos(int Productos_idProductos) {
        this.Productos_idProductos = Productos_idProductos;
    }

    public int getVariables_Calidad_idVariables_Calidad() {
        return Variables_Calidad_idVariables_Calidad;
    }

    public void setVariables_Calidad_idVariables_Calidad(int Variables_Calidad_idVariables_Calidad) {
        this.Variables_Calidad_idVariables_Calidad = Variables_Calidad_idVariables_Calidad;
    }

    public int getUsuarios_idUsuarios() {
        return Usuarios_idUsuarios;
    }

    public void setUsuarios_idUsuarios(int Usuarios_idUsuarios) {
        this.Usuarios_idUsuarios = Usuarios_idUsuarios;
    }
    private double Valor_6;
    private int Productos_idProductos;
    private int Variables_Calidad_idVariables_Calidad;
    private int Usuarios_idUsuarios;
    
    // </editor-fold>

}
