import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Ventana donde se introducen los datos del modelo del vehículo
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see modeloGUI
 */
public class modeloGUI {
    //Frame
    private final JFrame frame = new JFrame("Registro de Modelos");

    //Label
    static JLabel fondo = new JLabel(new ImageIcon("fondo.jpg"));
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
    public String[] marcas_array;
    public String[] asientos_array = {"2","5","7"};
    public String[] puertas_array = {"2","4"};
    public String[] combustible_array = {"Diesel","Regular","Super"};
    public String[] transmision_array = {"Automatico","Manual"};
    public JComboBox combobox_marcas;
    public JComboBox combobox_asientos = new JComboBox(asientos_array);
    public JComboBox combobox_puertas = new JComboBox(puertas_array);
    public JComboBox combobox_combustible = new JComboBox(combustible_array);
    public JComboBox combobox_transmision = new JComboBox(transmision_array);

    //CSVs
    Marca marca = new Marca();
    Modelo modelo = new Modelo();
    vehiculoCliente vehiculocliente = new vehiculoCliente();

    /**
     * Metodo constructor donde se editan los objetos de la ventana
     */
    modeloGUI(){
        //Labels
        registro_modelo.setFont(new Font("", Font.PLAIN, 21));
        registro_modelo.setForeground(Color.blue);
        registro_modelo.setBackground(Color.white);
        registro_modelo.setOpaque(true);
        registro_modelo.setText("Registro de Modelos");
        registro_modelo.setBounds(140, 20, 200, 25);

        indicador_marca.setFont(new Font("", Font.BOLD, 12));
        indicador_marca.setForeground(Color.blue);
        indicador_marca.setBackground(Color.white);
        indicador_marca.setOpaque(true);
        indicador_marca.setText("Marca");
        indicador_marca.setBounds(110, 130, 185, 20);

        indicador_modelo.setFont(new Font("", Font.BOLD, 12));
        indicador_modelo.setForeground(Color.blue);
        indicador_modelo.setBackground(Color.white);
        indicador_modelo.setOpaque(true);
        indicador_modelo.setText("Modelo");
        indicador_modelo.setBounds(320, 130, 185, 20);

        indicador_asientos.setFont(new Font("", Font.BOLD, 12));
        indicador_asientos.setForeground(Color.blue);
        indicador_asientos.setBackground(Color.white);
        indicador_asientos.setOpaque(true);
        indicador_asientos.setText("Asientos");
        indicador_asientos.setBounds(105, 200, 185, 20);

        indicador_puertas.setFont(new Font("", Font.BOLD, 12));
        indicador_puertas.setForeground(Color.blue);
        indicador_puertas.setBackground(Color.white);
        indicador_puertas.setOpaque(true);
        indicador_puertas.setText("Puertas");
        indicador_puertas.setBounds(320, 200, 185, 20);

        indicador_combustible.setFont(new Font("", Font.BOLD, 12));
        indicador_combustible.setForeground(Color.blue);
        indicador_combustible.setBackground(Color.white);
        indicador_combustible.setOpaque(true);
        indicador_combustible.setText("Combustible");
        indicador_combustible.setBounds(95, 270, 185, 20);

        indicador_transmision.setFont(new Font("", Font.BOLD, 12));
        indicador_transmision.setForeground(Color.blue);
        indicador_transmision.setBackground(Color.white);
        indicador_transmision.setOpaque(true);
        indicador_transmision.setText("Transmision");
        indicador_transmision.setBounds(310, 270, 185, 20);

        fondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        //Combobox / TextField
        marcas_array = marca.getMarcaTipo();
        combobox_marcas = new JComboBox(marcas_array);
        combobox_marcas.setBounds(40, 110, 185, 20);
        combobox_marcas.setBackground(Color.white);
        combobox_asientos.setBounds(40, 180, 185, 20);
        combobox_asientos.setBackground(Color.white);
        combobox_puertas.setBounds(250, 180, 185, 20);
        combobox_puertas.setBackground(Color.white);
        combobox_combustible.setBounds(40, 250, 185, 20);
        combobox_combustible.setBackground(Color.white);
        combobox_transmision.setBounds(250, 250, 185, 20);
        combobox_transmision.setBackground(Color.white);

        entrada_modelo.setFont(new Font("", Font.BOLD, 12));
        entrada_modelo.setBounds(250, 110, 185, 20);

        //Buttons
        aceptar_registro_modelo.setFont(new Font("", Font.BOLD, 12));
        aceptar_registro_modelo.setText("Registrar");
        aceptar_registro_modelo.setBackground(Color.white);
        aceptar_registro_modelo.setBounds(140, 320, 90, 20);

        eliminar_registro_modelo.setFont(new Font("", Font.BOLD, 12));
        eliminar_registro_modelo.setText("Eliminar");
        eliminar_registro_modelo.setBackground(Color.white);
        eliminar_registro_modelo.setBounds(230, 320, 90, 20);

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 400);

        fondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());

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
        frame.add(aceptar_registro_modelo);
        frame.add(eliminar_registro_modelo);
        frame.add(fondo);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        /**
         * Accion asociada a los botones para registrar y eliminar modelos específicos
         */
        aceptar_registro_modelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] marca_registro_array = String.valueOf(combobox_marcas.getSelectedItem()).split(",");
                String marca_registro, tipo_registro, modelo_registro, asientos_registro, puertas_registro, combustible_registro, transmision_registro;
                marca_registro = marca_registro_array[0];
                tipo_registro = marca_registro_array[1];
                modelo_registro = entrada_modelo.getText();
                asientos_registro = String.valueOf(combobox_asientos.getSelectedItem());
                puertas_registro = String.valueOf(combobox_puertas.getSelectedItem());
                combustible_registro = String.valueOf(combobox_combustible.getSelectedItem());
                transmision_registro = String.valueOf(combobox_transmision.getSelectedItem());

                try {
                    modelo.add(marca_registro, tipo_registro, modelo_registro, asientos_registro, puertas_registro, combustible_registro, transmision_registro);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        eliminar_registro_modelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] marca_registro_array = String.valueOf(combobox_marcas.getSelectedItem()).split(",");
                String marca_registro, tipo_registro, modelo_registro, asientos_registro, puertas_registro, combustible_registro, transmision_registro;

                marca_registro = marca_registro_array[0];
                tipo_registro = marca_registro_array[1];
                modelo_registro = entrada_modelo.getText();
                asientos_registro = String.valueOf(combobox_asientos.getSelectedItem());
                puertas_registro = String.valueOf(combobox_puertas.getSelectedItem());
                combustible_registro = String.valueOf(combobox_combustible.getSelectedItem());
                transmision_registro = String.valueOf(combobox_transmision.getSelectedItem());

                try {
                    if(vehiculocliente.verificaModelo(marca_registro, modelo_registro)) {
                        JOptionPane.showMessageDialog(null, "Marca y modelo asociados a un vehículo", "No se pudo eliminar", 1);
                    }
                    else{
                        modelo.delete(marca_registro, tipo_registro, modelo_registro, asientos_registro, puertas_registro, combustible_registro, transmision_registro);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
