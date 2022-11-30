package modelo;

import utils.DigitoVerificador;

import java.util.ArrayList;
import java.util.List;
import modelo.Jugador;

public class Seleccion {
    private List<Jugador> jugadores;

    public Seleccion() {
        this.jugadores = new ArrayList<>();
    }

    public boolean agregarJugador(Jugador jugador) {
        String numero = jugador.getNumero();

        if(!jugadorExiste(numero) && DigitoVerificador.validarRut(numero)) {
            jugadores.add(jugador);
            return true;
        }

        return false;
    }

    public boolean jugadorExiste(String numero) {
        for (Jugador e: this.jugadores) {
            if(e.getNumero().equals(numero)) {
                return true;
            }
        }

        return false;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Jugador buscarJugadorPorNumero(String numero) throws JugadorNoEncontradoException {
        for (Jugador e: this.jugadores) {
            if(e.getNumero().equals(numero)) {
                return e;
            }
        }

        throw new JugadorNoEncontradoException();
    }
}
