package Practico4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminar extends JFrame implements ActionListener {

    private JButton borrar = new JButton("Borrar");
    private Lista l = new Lista<>();
    private int posicionAEliminar = -1;
    private JTextField campoTexto = new JTextField();

    public VentanaEliminar (){
        setTitle("Practico4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
        añadirComponentes();
        setVisible(true);

    }

    private void añadirComponentes() {

        this.setLayout(null);
        borrar.addActionListener(this);

        campoTexto.setBounds(150,100, 100,30);
        borrar.setBounds(150,150,100,30);

        this.add(campoTexto);
        this.add(borrar);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(borrar)){
            posicionAEliminar= Integer.parseInt(campoTexto.getText());
            this.dispose();
        }
    }

    public int getPosicionAEliminar() {
        return posicionAEliminar;
    }

    public void setPosicionAEliminar(int posicionAEliminar) {
        this.posicionAEliminar = posicionAEliminar;
    }
}
