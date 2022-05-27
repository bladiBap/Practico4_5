package Practico4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminar extends JFrame implements ActionListener {

    private JButton borrar = new JButton("Borrar");
    private DefaultTableModel mTabla;
    private Lista <Persona> l ;
    private int posicionAEliminar = 0;
    private JTextField campoTexto = new JTextField();

    public VentanaEliminar (Lista <Persona> l, DefaultTableModel m){

        this.l = l;
        this.mTabla = m;
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
            l.eliminar(posicionAEliminar-1);
            mTabla.removeRow(posicionAEliminar-1);
            System.out.println("Nuevo tamaño: "+ l.tamano());;
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
