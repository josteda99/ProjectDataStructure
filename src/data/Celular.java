package data;

import java.io.Serializable;

public class Celular implements Serializable {

    private static final int id_celular = 1;
    private int nSerie;
    private String marca;
    private int precio;
    private int imei;

    public Celular() {
    }

    public Celular(int nSerie) {
        this.nSerie = nSerie;
        this.marca = "Samsung";
    }

    public Celular(int nSerie, String marca) {
        this.nSerie = nSerie;
        this.marca = marca;
    }

    public Celular(int nSerie, String marca, int precio) {
        this.nSerie = nSerie;
        this.marca = marca;
        this.precio = precio;
    }

    public Celular(int nSerie, String marca, int precio, int imei) {
        this.nSerie = nSerie;
        this.marca = marca;
        this.precio = precio;
        this.imei = imei;
    }

    public int getImei() {
        return imei;
    }

    public static int getId_celular() {
        return id_celular;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public int getnSerie() {
        return nSerie;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setnSerie(int nSerie) {
        this.nSerie = nSerie;
    }

    @Override
    public String toString() {
        return " marca: " + this.marca + this.nSerie;
    }

}
