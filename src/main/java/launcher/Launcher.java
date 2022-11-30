package launcher;

import dato.DatosJugadores;
import gui.Ventana_Seleccion;
import modelo.Seleccion;

public class Launcher {
    public static void main(String [] args) {

        Seleccion seleccion = new Seleccion();
        DatosJugadores.leerArchivoJugadores(seleccion, "datos/chi.txt");
        /*
        DatosJugadores.leerArchivoJugadores(seleccion, "datos/aus.txt");
        DatosJugadores.leerArchivoJugadores(seleccion, "datos/cmr.txt");
        DatosJugadores.leerArchivoJugadores(seleccion, "datos/ger.txt");
        * */

        new Ventana_Seleccion(seleccion);

    }
}
