import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuGUI {

    private JFrame frame = new JFrame("Menú Principal");

    //Labels
    static JLabel titulo = new JLabel();
    static JLabel nombre_taller = new JLabel();

    //Buttons
    public JButton boton_registro_marca = new JButton();
    public JButton boton_registro_modelo = new JButton();
    public JButton boton_registro_cliente = new JButton();
    public JButton boton_registro_vehiculo = new JButton();
    public JButton boton_registro_servicio = new JButton();
    public JButton boton_consulta_servicios = new JButton();

    menuGUI(){
        //Labels
        titulo.setFont(new Font("", Font.PLAIN, 21));
        titulo.setForeground(Color.blue);
        titulo.setOpaque(true);
        titulo.setText("Taller Mecánico y Pintura");
        titulo.setBounds(120, 20, 300, 25);

        nombre_taller.setFont(new Font("", Font.PLAIN, 21));
        nombre_taller.setForeground(Color.blue);
        nombre_taller.setOpaque(true);
        nombre_taller.setText("A los Pits");
        nombre_taller.setBounds(190, 50, 190, 25);

        //Buttons
        boton_registro_marca.setFont(new Font("", Font.BOLD, 15));
        boton_registro_marca.setText("Registro de Marca");
        boton_registro_marca.setBackground(Color.white);
        boton_registro_marca.setBounds(40, 110, 185, 25);

        boton_registro_modelo.setFont(new Font("", Font.BOLD, 15));
        boton_registro_modelo.setText("Registro de Modelo");
        boton_registro_modelo.setBackground(Color.white);
        boton_registro_modelo.setBounds(250, 110, 185, 25);

        boton_registro_cliente.setFont(new Font("", Font.BOLD, 15));
        boton_registro_cliente.setText("Registro de Cliente");
        boton_registro_cliente.setBackground(Color.white);
        boton_registro_cliente.setBounds(40, 180, 185, 25);

        boton_registro_vehiculo.setFont(new Font("", Font.BOLD, 15));
        boton_registro_vehiculo.setText("Registro de Vehiculo");
        boton_registro_vehiculo.setBackground(Color.white);
        boton_registro_vehiculo.setBounds(250, 180, 185, 25);

        boton_registro_servicio.setFont(new Font("", Font.BOLD, 15));
        boton_registro_servicio.setText("Registro de Servicio");
        boton_registro_servicio.setBackground(Color.white);
        boton_registro_servicio.setBounds(40, 250, 185, 25);

        boton_consulta_servicios.setFont(new Font("", Font.BOLD, 15));
        boton_consulta_servicios.setText("Consulta de Servicio");
        boton_consulta_servicios.setBackground(Color.white);
        boton_consulta_servicios.setBounds(250, 250, 185, 25);

        //Frame
        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(titulo);
        frame.add(nombre_taller);
        frame.add(boton_registro_marca);
        frame.add(boton_registro_modelo);
        frame.add(boton_registro_cliente);
        frame.add(boton_registro_vehiculo);
        frame.add(boton_registro_servicio);
        frame.add(boton_consulta_servicios);
        frame.setResizable(false);
        frame.setVisible(true);

        boton_registro_marca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcaGUI ventana_marca = new marcaGUI();
            }
        });
        boton_registro_modelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloGUI ventana_modelo = new modeloGUI();
            }
        });
        boton_registro_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteGUI ventana_cliente = new clienteGUI();
            }
        });
    }
}
