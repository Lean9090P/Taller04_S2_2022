package gui;

import modelo.JugadorNoEncontradoException;
import modelo.Jugador;
import modelo.Seleccion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_Seleccion extends Ventana implements ActionListener {
    private Seleccion seleccion1;

    private JButton nuevoJugadorBtn;
    private JButton buscarBtn;
    private JComboBox numeroJugador;

    private JLabel nombre;
    private JLabel posicion;

    public Ventana_Seleccion(Seleccion seleccion1) {
        this.seleccion1 = seleccion1;

        this.setTitle("Selecciones");

        generarImagen();

        this.generarEtiqueta("Seleccion Chilena: ", 20, 20, 200, 20);
        this.generarEtiqueta("Busqueda por numero: ", 20, 40, 200, 20);

        this.generarEtiqueta("Nombre: ", 20, 100, 80, 20);
        this.generarEtiqueta("Posición: ", 20, 150, 80, 20);

        nuevoJugadorBtn = this.generarBoton("Nuevo Jugador", 200, 200, 150, 30);
        nuevoJugadorBtn.addActionListener(this);

        buscarBtn = this.generarBoton("Buscar Jugador", 20, 200, 150, 30);
        buscarBtn.addActionListener(this);

        nombre = this.generarEtiqueta("", 100, 100, 300, 20);
        posicion = this.generarEtiqueta("", 100, 150, 300, 20);

        numeroJugador = this.generarComboBox(this.seleccion1.getJugadores(), 20, 70, 200, 20);
    }

    public void mostrarDatosJugador() throws JugadorNoEncontradoException {
        Jugador e = seleccion1.buscarJugadorPorNumero(numeroJugador.getSelectedItem().toString());
        nombre.setText(e.getNombre());
        posicion.setText(e.getPosicion());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nuevoJugadorBtn) {
            new Ventana_AgregarJugadores(this.seleccion1);
            this.dispose();
        } else if(e.getSource() == buscarBtn) {
            try {
                mostrarDatosJugador();
            } catch (JugadorNoEncontradoException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void generarImagen() {
        JLabel labelUser = new JLabel(new ImageIcon("datos/chi.png"));
        labelUser.setBounds(300, 40, 70, 45);
        super.add(labelUser);
    }



}
