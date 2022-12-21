import javax.swing.*;
import java.awt.*;

public class modeloGUI {
    //Frame
    private final JFrame frame = new JFrame("Registro de Modelos");

    //Label
    static JLabel registro_modelo = new JLabel();
    static JLabel indicador_marca = new JLabel();
    static JLabel indicador_modelo = new JLabel();
    static JLabel indicador_asientos = new JLabel();
    static JLabel indicador_puertas = new JLabel();
    static JLabel indicador_combustible = new JLabel();
    static JLabel indicador_transmision = new JLabel();

    //Button
    public JButton aceptar_registro_modelo = new JButton();
    public JButton eliminar_registro_modelo = new JButton();

    //Textfield
    public JTextField entrada_modelo = new JTextField();

    //Combobox
    public String[] asientos_array = {"2","5","7"};
    public String[] puertas_array = {"2","4"};
    public String[] combustible_array = {"Diesel","Regular","Super"};
    public String[] transmision_array = {"Automatico","Manual"};
    public JComboBox combobox_marcas = new JComboBox();
    public JComboBox combobox_asientos = new JComboBox(asientos_array);
    public JComboBox combobox_puertas = new JComboBox(puertas_array);
    public JComboBox combobox_combustible = new JComboBox(combustible_array);
    public JComboBox combobox_transmision = new JComboBox(transmision_array);

    modeloGUI(){
        //Labels
        registro_modelo.setFont(new Font("", Font.PLAIN, 21));
        registro_modelo.setForeground(Color.blue);
        registro_modelo.setOpaque(true);
        registro_modelo.setText("Registro de Modelos");
        registro_modelo.setBounds(140, 20, 200, 25);

        indicador_marca.setFont(new Font("", Font.BOLD, 12));
        indicador_marca.setForeground(Color.blue);
        indicador_marca.setOpaque(true);
        indicador_marca.setText("Marca");
        indicador_marca.setBounds(110, 130, 185, 20);

        indicador_modelo.setFont(new Font("", Font.BOLD, 12));
        indicador_modelo.setForeground(Color.blue);
        indicador_modelo.setOpaque(true);
        indicador_modelo.setText("Modelo");
        indicador_modelo.setBounds(320, 130, 185, 20);

        indicador_asientos.setFont(new Font("", Font.BOLD, 12));
        indicador_asientos.setForeground(Color.blue);
        indicador_asientos.setOpaque(true);
        indicador_asientos.setText("Asientos");
        indicador_asientos.setBounds(105, 200, 185, 20);

        indicador_puertas.setFont(new Font("", Font.BOLD, 12));
        indicador_puertas.setForeground(Color.blue);
        indicador_puertas.setOpaque(true);
        indicador_puertas.setText("Puertas");
        indicador_puertas.setBounds(320, 200, 185, 20);

        indicador_combustible.setFont(new Font("", Font.BOLD, 12));
        indicador_combustible.setForeground(Color.blue);
        indicador_combustible.setOpaque(true);
        indicador_combustible.setText("Combustible");
        indicador_combustible.setBounds(95, 270, 185, 20);

        indicador_transmision.setFont(new Font("", Font.BOLD, 12));
        indicador_transmision.setForeground(Color.blue);
        indicador_transmision.setOpaque(true);
        indicador_transmision.setText("Transmision");
        indicador_transmision.setBounds(310, 270, 185, 20);

        //Combobox/TextField
        combobox_marcas.setBounds(40, 110, 185, 20);
        entrada_modelo.setBounds(250, 110, 185, 20);
        combobox_asientos.setBounds(40, 180, 185, 20);
        combobox_puertas.setBounds(250, 180, 185, 20);
        combobox_combustible.setBounds(40, 250, 185, 20);
        combobox_transmision.setBounds(250, 250, 185, 20);

        //Buttons
        aceptar_registro_modelo.setFont(new Font("", Font.BOLD, 12));
        aceptar_registro_modelo.setText("Registrar");
        aceptar_registro_modelo.setBounds(140, 270, 90, 20);
        eliminar_registro_modelo.setFont(new Font("", Font.BOLD, 12));
        eliminar_registro_modelo.setText("Eliminar");
        eliminar_registro_modelo.setBounds(230, 110, 90, 20);

        frame.add(registro_modelo);
        frame.add(combobox_marcas);
        frame.add(entrada_modelo);
        frame.add(combobox_asientos);
        frame.add(combobox_puertas);
        frame.add(combobox_combustible);
        frame.add(combobox_transmision);
        frame.add(indicador_marca);
        frame.add(indicador_modelo);
        frame.add(indicador_asientos);
        frame.add(indicador_puertas);
        frame.add(indicador_combustible);
        frame.add(indicador_transmision);

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
