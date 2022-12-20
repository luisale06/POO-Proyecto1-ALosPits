import javax.swing.*;
import java.awt.*;

public class menuGUI {

    private JFrame frame = new JFrame("Menú Principal");

    //Labels
    static JLabel titulo = new JLabel();
    static JLabel nombre_taller = new JLabel();

    //Buttons
    public JButton boton_registro_marca = new JButton();
    public JButton boton_registro_modelo = new JButton();
    public JButton boton_registro_cliente = new JButton();
    public JButton boton_registro_vehiculo_cliente = new JButton();
    public JButton boton_registro_servicio = new JButton();
    public JButton boton_consulta_servicios = new JButton();

    menuGUI(){
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

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(titulo);
        frame.add(nombre_taller);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
