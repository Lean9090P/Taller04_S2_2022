package modelo;

public class Jugador {

    private String numero;
    private String nombre;
    private String posicion;

    public Jugador(String numero, String nombre, String posicion) {
        this.numero = numero;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public String toString() {
        return (this.numero + ";" + this.nombre + ";" + this.posicion);
    }

}
