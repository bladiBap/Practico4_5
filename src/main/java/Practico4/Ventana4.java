package Practico4;

import Practico5.Imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana4 extends JFrame {
    private JTable tabla = new JTable(10,6);
    public Ventana4 (){
        setTitle("Practico4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,800);
        setLocationRelativeTo(null);
        añadirComponentes();
        setVisible(true);

    }

    public void añadirComponentes (){
        this.add(new JScrollPane(tabla),BorderLayout.CENTER);
        this.add(tabla);
        tabla.setValueAt("aaa",2,2);
        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);

        JMenu menu = new JMenu("Buscador");
        bar.add(menu);

        JMenuItem item = new JMenuItem("Cargar Imagen");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menuArchivo_cargarImagen();
            }
        });
        menu.add(item);
    }

    protected void menuArchivo_cargarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        int respuesta = fileChooser.showOpenDialog(null);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //this.modelo = new Imagen(fileChooser.getSelectedFile().getPath());
            //panelImg.setMiImagen(modelo);
        }


    }

}
