package data;

public class Cliente {

    private int id;
    private String nombre;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
        this.nombre = "alfredo";
    }

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + this.nombre
                + " id: " + this.id;
    }
    
}
