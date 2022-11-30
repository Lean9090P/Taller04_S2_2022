package gui;

import dato.DatosJugadores;
import modelo.Jugador;
import modelo.Seleccion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_AgregarJugadores extends Ventana implements ActionListener {
    Seleccion seleccion1;

    private JButton agregarBtn;
    private JButton cancelarBtn;

    private JTextField nombreField;
    private JTextField posicionField;
    private JTextField numeroField;

    public Ventana_AgregarJugadores(Seleccion seleccion1) {
        this.seleccion1 = seleccion1;

        this.setTitle("Editar Jugador");


        this.generarEtiqueta("Numero: ", 50, 50, 100, 20);
        this.generarEtiqueta("Nombre: ", 50, 100, 100, 20);
        this.generarEtiqueta("Posicion: ", 50, 150, 100, 20);


        agregarBtn = this.generarBoton("Editar", 50, 200, 125, 30);
        cancelarBtn = this.generarBoton("Cancelar", 225, 200, 125, 30);

        agregarBtn.addActionListener(this);
        cancelarBtn.addActionListener(this);

        numeroField = this.generarCampoDeTexto(150, 50, 200, 20);
        nombreField = this.generarCampoDeTexto(150, 100, 200, 20);
        posicionField = this.generarCampoDeTexto(150, 150, 200, 20);
    }

    public void agregarJugador() {
        Jugador jugador = new Jugador(numeroField.getText(), nombreField.getText(), posicionField.getText());

        if(!camposVacios() && seleccion1.agregarJugador(jugador)) {
            DatosJugadores.registrarDatos(jugador, "datos/chi.txt");

            JOptionPane.showMessageDialog(this, "¡El Jugador ha sido registrado exitósamente!",
                    "Jugadores", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "El Jugador no se ha podido editar",
                    "Jugadores", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public boolean camposVacios() {
        return numeroField.getText().equals("") || nombreField.getText().equals("") ||
                posicionField.getText().equals("");
    }

    public void limpiarTextField() {
        nombreField.setText("");
        numeroField.setText("");
        posicionField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelarBtn) {
            new Ventana_Seleccion(this.seleccion1);
            this.dispose();
        } else if(e.getSource() == agregarBtn) {
            agregarJugador();
            limpiarTextField();
        }
    }
}
