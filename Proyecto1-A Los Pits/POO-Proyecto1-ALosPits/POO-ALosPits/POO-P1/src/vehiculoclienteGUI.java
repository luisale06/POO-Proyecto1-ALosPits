import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Ventana donde se introducen los datos del vehículo y del dueño
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see vehiculoclienteGUI
 */
public class vehiculoclienteGUI {
    private final JFrame frame = new JFrame("Registro de Vehiculos");

    //Label
    static JLabel registro_vehiculos = new JLabel();
    static JLabel indicador_id = new JLabel();
    static JLabel indicador_marca_modelo = new JLabel();
    static JLabel indicador_year = new JLabel();
    static JLabel indicador_placa = new JLabel();

    //Button
    public JButton aceptar_registro_vehiculo = new JButton();

    //Textfield
    public JTextField entrada_year = new JTextField();
    public JTextField entrada_placa = new JTextField();

    //Combobox
    public String[] id_array, marca_modelo_array;
    public JComboBox combobox_id, combobox_marca_modelo;

    vehiculoCliente vehiculocliente = new vehiculoCliente();
    Modelo modelo = new Modelo();
    Cliente cliente = new Cliente();

    /**
     * Metodo constructor donde se editan los objetos de la ventana
     */
    vehiculoclienteGUI() {
        //Labels
        registro_vehiculos.setFont(new Font("", Font.PLAIN, 21));
        registro_vehiculos.setForeground(Color.blue);
        registro_vehiculos.setOpaque(true);
        registro_vehiculos.setText("Registro de Vehiculos");
        registro_vehiculos.setBounds(140, 20, 210, 25);

        indicador_id.setFont(new Font("", Font.BOLD, 12));
        indicador_id.setForeground(Color.blue);
        indicador_id.setOpaque(true);
        indicador_id.setText("Identificacion");
        indicador_id.setBounds(90, 130, 185, 20);

        indicador_marca_modelo.setFont(new Font("", Font.BOLD, 12));
        indicador_marca_modelo.setForeground(Color.blue);
        indicador_marca_modelo.setOpaque(true);
        indicador_marca_modelo.setText("Marca y Modelo");
        indicador_marca_modelo.setBounds(300, 130, 185, 20);

        indicador_year.setFont(new Font("", Font.BOLD, 12));
        indicador_year.setForeground(Color.blue);
        indicador_year.setOpaque(true);
        indicador_year.setText("Año");
        indicador_year.setBounds(110, 200, 185, 20);

        indicador_placa.setFont(new Font("", Font.BOLD, 12));
        indicador_placa.setForeground(Color.blue);
        indicador_placa.setOpaque(true);
        indicador_placa.setText("Placa");
        indicador_placa.setBounds(330, 200, 185, 20);

        //Combobox / Textfield
        id_array = cliente.getIDs();
        marca_modelo_array = modelo.getMarcaModelo();
        combobox_id = new JComboBox(id_array);
        combobox_marca_modelo = new JComboBox(marca_modelo_array);
        combobox_id.setBounds(40, 110, 185, 20);
        combobox_marca_modelo.setBounds(250, 110, 185, 20);

        entrada_year.setFont(new Font("", Font.BOLD, 12));
        entrada_year.setBounds(40, 180, 185, 20);
        entrada_placa.setFont(new Font("", Font.BOLD, 12));
        entrada_placa.setBounds(250, 180, 185, 20);

        //Buttons
        aceptar_registro_vehiculo.setFont(new Font("", Font.BOLD, 12));
        aceptar_registro_vehiculo.setText("Registrar");
        aceptar_registro_vehiculo.setBounds(190, 235, 90, 20);

        frame.add(registro_vehiculos);
        frame.add(indicador_id);
        frame.add(indicador_marca_modelo);
        frame.add(indicador_year);
        frame.add(indicador_placa);
        frame.add(combobox_id);
        frame.add(combobox_marca_modelo);
        frame.add(entrada_year);
        frame.add(entrada_placa);
        frame.add(aceptar_registro_vehiculo);

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        /**
         * Accion asociada a los botones para registrar vehículos a un cliente en específico
         */
        aceptar_registro_vehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] marca_modelo_array = String.valueOf(combobox_marca_modelo.getSelectedItem()).split(",");
                String id_registro, marca_registro, modelo_registro, year_registro, placa_registro;

                id_registro = String.valueOf(combobox_id.getSelectedItem());
                marca_registro = marca_modelo_array[0];
                modelo_registro = marca_modelo_array[1];
                year_registro = entrada_year.getText();
                placa_registro = entrada_placa.getText();

                try {
                    vehiculocliente.add(id_registro, marca_registro, modelo_registro, year_registro, placa_registro);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
