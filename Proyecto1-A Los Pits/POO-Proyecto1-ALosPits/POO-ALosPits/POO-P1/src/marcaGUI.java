import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

public class marcaGUI {
    //Frame
    private JFrame frame = new JFrame("Registro de Marcas");

    //Labels
    static JLabel registro_marca = new JLabel();
    static JLabel registro_modelo = new JLabel();
    static JLabel registro_cliente = new JLabel();
    static JLabel registro_vehiculo_cliente = new JLabel();
    static JLabel registro_servicio = new JLabel();
    static JLabel indicador_marca = new JLabel();
    static JLabel indicador_tipo_marca = new JLabel();

    //TextField
    static JTextField entrada_marca = new JTextField();
    static JTextField entrada_tipo_marca = new JTextField();


    //Buttons
    public JButton aceptar_registro_marca = new JButton();
    public JButton eliminar_registro_marca = new JButton();
    public JButton aceptar_registro_modelo = new JButton();
    public JButton eliminar_registro_modelo = new JButton();
    public JButton aceptar_registro_cliente = new JButton();
    public JButton aceptar_registro_vehiculo_cliente = new JButton();
    public JButton aceptar_registro_servicio = new JButton();

    //ComboBox
    public String[] tipos_marca_array = {"4x4", "SUV", "Pickup", "Sedan"};
    public String[] marcas_array;
    public JComboBox combobox_tipos_marca;
    public JComboBox combobox_marcas;


    //Control CSVs
    Marca marca = new Marca();
    Modelo modelo = new Modelo();
    Cliente cliente = new Cliente();

    marcaGUI() {
        tipos_marca_array = sortArrays();
        combobox_tipos_marca = new JComboBox(tipos_marca_array);

        //Marcas
        registro_marca.setFont(new Font("", Font.PLAIN, 21));
        registro_marca.setForeground(Color.blue);
        registro_marca.setOpaque(true);
        registro_marca.setText("Registro de Marcas");
        registro_marca.setBounds(140, 20, 190, 25);

        indicador_marca.setFont(new Font("", Font.PLAIN, 12));
        indicador_marca.setForeground(Color.blue);
        indicador_marca.setOpaque(true);
        indicador_marca.setText("Marca");
        indicador_marca.setBounds(275, 50, 40, 20);

        indicador_tipo_marca.setFont(new Font("", Font.PLAIN, 12));
        indicador_tipo_marca.setForeground(Color.blue);
        indicador_tipo_marca.setOpaque(true);
        indicador_tipo_marca.setText("Tipo");
        indicador_tipo_marca.setBounds(275, 80, 40, 20);

        entrada_marca.setBounds(140, 50, 130, 20);
        combobox_tipos_marca.setBounds(140, 80, 130, 20);

        aceptar_registro_marca.setFont(new Font("", Font.BOLD, 12));
        aceptar_registro_marca.setText("Registrar");
        aceptar_registro_marca.setBounds(140, 110, 90, 20);
        eliminar_registro_marca.setFont(new Font("", Font.BOLD, 12));
        eliminar_registro_marca.setText("Eliminar");
        eliminar_registro_marca.setBounds(230, 110, 90, 20);

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(registro_marca);
        frame.add(entrada_marca);
        frame.add(combobox_tipos_marca);
        frame.add(aceptar_registro_marca);
        frame.add(eliminar_registro_marca);
        frame.add(indicador_marca);
        frame.add(indicador_tipo_marca);
        frame.setResizable(false);
        frame.setVisible(true);

        //Button actions
        aceptar_registro_marca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    marca.add(entrada_marca.getText(), String.valueOf(combobox_tipos_marca.getSelectedItem()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public String[] sortArrays() {
        String[] myArray = tipos_marca_array;
        int size = myArray.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < myArray.length; j++) {
                if (myArray[i].compareTo(myArray[j]) > 0) {
                    String temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(myArray));
        return myArray;
    }
}
