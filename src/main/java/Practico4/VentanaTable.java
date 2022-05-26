package Practico4;


import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VentanaTable extends JFrame {
    private JTable tabla ;

    private int posicion = -1;
    private Lista listaPersonas = new Lista<>();
    private static final org.apache.log4j.Logger logger = Logger.getRootLogger();
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    public VentanaTable(){
        setTitle("Practico4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,800);
        setLocationRelativeTo(null);
        añadirComponentes();
        setVisible(true);

    }


    public void añadirComponentes (){

        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Edad");
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(0, 0, 10,60);
        add(scroll);
        this.pack();
        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);

        JMenu menu = new JMenu("Buscador");
        JMenu menu2 = new JMenu("Borrar");
        bar.add(menu);
        bar.add(menu2);

        JMenuItem item = new JMenuItem("Cargar TEXTO");
        JMenuItem itemBorrar = new JMenuItem("Eliminar");

        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                menuArchivo_cargarImagen();
            }
        });

        itemBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaEliminar v = new VentanaEliminar();
                posicion = v.getPosicionAEliminar();
                if(posicion > 0){
                    listaPersonas.eliminar(posicion);
                    System.out.println("Nuevo tamaño: "+listaPersonas.tamano());
                }

            }
        });

        menu2.add(itemBorrar);
        menu.add(item);
    }

    protected void menuArchivo_cargarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        int respuesta = fileChooser.showOpenDialog(null);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            String expresionReg = "^[A-z]+\\s+[A-z]+\\s+[0-9]{2}$";
            try {
                File Archivo = new File(fileChooser.getSelectedFile().getPath());
                Scanner lector = new Scanner(Archivo);
                while (lector.hasNext()){
                    String letras = lector.nextLine();
                    letras.trim();
                    if (letras.matches(expresionReg)){
                        String[] split = letras.split(" ");
                        Persona personaX = new Persona(split [0],split [1],Integer.parseInt(split [2]));
                        listaPersonas.adicionar(personaX);
                        modeloTabla.addRow(split);
                        System.out.println(letras);
                        System.out.println("Tamaño: " + listaPersonas.tamano());
                    }else {
                        logger.info("No se escribio :  "+letras);
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public Lista getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(Lista listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
}
