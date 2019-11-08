package data;

import java.io.Serializable;

public class Cliente implements Serializable {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String formaPago;
    private int precioPago;
    private int nSerieCelular;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String formaPago, int precioPago, int nSerieCelular) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
        this.precioPago = precioPago;
        this.nSerieCelular = nSerieCelular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + this.nombre
                + " id: " + this.idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public int getPrecioPago() {
        return precioPago;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setPrecioPago(int precioPago) {
        this.precioPago = precioPago;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public int getnSerieCelular() {
        return nSerieCelular;
    }

    public void setnSerieCelular(int nSerieCelular) {
        this.nSerieCelular = nSerieCelular;
    }

}
