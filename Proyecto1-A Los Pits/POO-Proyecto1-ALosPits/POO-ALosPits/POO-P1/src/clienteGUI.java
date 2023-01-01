import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Ventana donde se introducen los datos de los clientes
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see clienteGUI
 */
public class clienteGUI {

    private final JFrame frame = new JFrame("Registro de Clientes");

    //Label
    static JLabel registro_cliente = new JLabel();
    static JLabel indicador_ID = new JLabel();
    static JLabel indicador_nombre = new JLabel();
    static JLabel indicador_tipo_ID = new JLabel();
    static JLabel indicador_provincia = new JLabel();
    static JLabel indicador_canton = new JLabel();
    static JLabel indicador_fecha_nacimiento = new JLabel();
    static JLabel indicador_telefono = new JLabel();
    static JLabel indicador_correo = new JLabel();

    //Button
    public JButton aceptar_registro_cliente = new JButton();

    //Textfield
    public JTextField entrada_ID = new JTextField();
    public JTextField entrada_nombre = new JTextField();
    public JTextField entrada_fecha_nacimiento = new JTextField();
    public JTextField entrada_telefono = new JTextField();
    public JTextField entrada_correo = new JTextField();

    //Combobox
    public String[] tipo_ID_array = {"Cedula fisica", "DIMEX", "DIDI", "NITE", "Cedula juridica"};
    public String[] provincia_array = {"San Jose", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limon"};
    public String[] canton_array = {"San Jose", "Escazu", "Desamparados", "Puriscal", "Tarrazu", "Aserri", "Mora", "Goicoechea", "Santa Ana", "Alajuelita", "Coronado", "Acosta", "Tibas", "Moravia", "Montes de Oca", "Turrubares", "Dota", "Curridabat", "Perez Zeledon",
    "Alajuela", "San Ramon", "Grecia", "San Mateo", "Atenas", "Naranjo", "Palmares", "Poas", "Orotina","San Carlos", "Alfaro", "Valverde Vega",
    "Cartago", "Paraiso", "La Union", "Jimenez", "Turrialba", "Alvarado", "Oreamuno", "El Guarco",
    "Heredia", "Barva", "Santo Domingo", "Santa Barbara", "San Rafael", "San Isidro", "Belen", "Flores",
    "Liberia", "Nicoya", "Santa Cruz", "Bagaces", "Carrillo", "Canas", "Abangares", "Tilaran",
    "Puntarenas", "Esparza", "Buenos Aires", "Montes de Oro", "Osa", "Aguirre", "Golfito",
    "Limon", "Pococi", "Siquirres"};

    public JComboBox combobox_tipo_ID = new JComboBox(tipo_ID_array);
    public JComboBox combobox_provincia = new JComboBox(provincia_array);
    public JComboBox combobox_canton = new JComboBox(canton_array);

    //CSVs
    Cliente cliente = new Cliente();

    /**
     * Metodo constructor donde se editan los objetos de la ventana
     */
    clienteGUI(){
        //Labels
        registro_cliente.setFont(new Font("", Font.PLAIN, 21));
        registro_cliente.setForeground(Color.blue);
        registro_cliente.setOpaque(true);
        registro_cliente.setText("Registro de Clientes");
        registro_cliente.setBounds(140, 20, 200, 25);

        indicador_ID.setFont(new Font("", Font.BOLD, 12));
        indicador_ID.setForeground(Color.blue);
        indicador_ID.setOpaque(true);
        indicador_ID.setText("Identificacion");
        indicador_ID.setBounds(90, 130, 185, 20);

        indicador_nombre.setFont(new Font("", Font.BOLD, 12));
        indicador_nombre.setForeground(Color.blue);
        indicador_nombre.setOpaque(true);
        indicador_nombre.setText("Nombre Completo");
        indicador_nombre.setBounds(300, 130, 185, 20);

        indicador_tipo_ID.setFont(new Font("", Font.BOLD, 12));
        indicador_tipo_ID.setForeground(Color.blue);
        indicador_tipo_ID.setOpaque(true);
        indicador_tipo_ID.setText("Tipo Identificacion");
        indicador_tipo_ID.setBounds(90, 200, 185, 20);

        indicador_provincia.setFont(new Font("", Font.BOLD, 12));
        indicador_provincia.setForeground(Color.blue);
        indicador_provincia.setOpaque(true);
        indicador_provincia.setText("Provincia");
        indicador_provincia.setBounds(310, 200, 185, 20);

        indicador_canton.setFont(new Font("", Font.BOLD, 12));
        indicador_canton.setForeground(Color.blue);
        indicador_canton.setOpaque(true);
        indicador_canton.setText("Canton");
        indicador_canton.setBounds(110, 270, 175, 20);

        indicador_fecha_nacimiento.setFont(new Font("", Font.BOLD, 12));
        indicador_fecha_nacimiento.setForeground(Color.blue);
        indicador_fecha_nacimiento.setOpaque(true);
        indicador_fecha_nacimiento.setText("Fecha de Nacimiento");
        indicador_fecha_nacimiento.setBounds(290, 270, 185, 20);

        indicador_telefono.setFont(new Font("", Font.BOLD, 12));
        indicador_telefono.setForeground(Color.blue);
        indicador_telefono.setOpaque(true);
        indicador_telefono.setText("Numero de Telefono");
        indicador_telefono.setBounds(80, 340, 185, 20);

        indicador_correo.setFont(new Font("", Font.BOLD, 12));
        indicador_correo.setForeground(Color.blue);
        indicador_correo.setOpaque(true);
        indicador_correo.setText("Correo Electronico");
        indicador_correo.setBounds(290, 340, 185, 20);

        //Combobox
        combobox_tipo_ID.setBounds(40, 180, 185, 20);

        combobox_provincia.setBounds(250, 180, 185, 20);

        combobox_canton.setBounds(40, 250, 185, 20);

        //TextField
        entrada_ID.setFont(new Font("", Font.BOLD, 12));
        entrada_ID.setBounds(40, 110, 185, 20);

        entrada_nombre.setFont(new Font("", Font.BOLD, 12));
        entrada_nombre.setBounds(250, 110, 185, 20);

        entrada_fecha_nacimiento.setFont(new Font("", Font.BOLD, 12));
        entrada_fecha_nacimiento.setBounds(250, 250, 185, 20);

        entrada_telefono.setFont(new Font("", Font.BOLD, 12));
        entrada_telefono.setBounds(40, 320, 185, 20);

        entrada_correo.setFont(new Font("", Font.BOLD, 12));
        entrada_correo.setBounds(250, 320, 185, 20);

        //Buttons
        aceptar_registro_cliente.setFont(new Font("", Font.BOLD, 12));
        aceptar_registro_cliente.setText("Registrar");
        aceptar_registro_cliente.setBounds(185, 400, 90, 20);

        frame.add(registro_cliente);
        frame.add(entrada_ID);
        frame.add(entrada_nombre);
        frame.add(combobox_tipo_ID);
        frame.add(combobox_provincia);
        frame.add(combobox_canton);
        frame.add(entrada_fecha_nacimiento);
        frame.add(entrada_telefono);
        frame.add(entrada_correo);
        frame.add(indicador_ID);
        frame.add(indicador_nombre);
        frame.add(indicador_tipo_ID);
        frame.add(indicador_provincia);
        frame.add(indicador_canton);
        frame.add(indicador_fecha_nacimiento);
        frame.add(indicador_telefono);
        frame.add(indicador_correo);
        frame.add(aceptar_registro_cliente);

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        /**
         * Accion asociada al boton para registrar al cliente
         */

        aceptar_registro_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String registro_ID, registro_nombre, registro_tipo_ID, registro_provincia, registro_canton, registro_fecha_nacimiento, registro_telefono, registro_correo;

                registro_ID = entrada_ID.getText();
                registro_nombre = entrada_nombre.getText();
                registro_tipo_ID = String.valueOf(combobox_tipo_ID.getSelectedItem());
                registro_provincia = String.valueOf(combobox_provincia.getSelectedItem());
                registro_canton = String.valueOf(combobox_canton.getSelectedItem());
                registro_fecha_nacimiento = entrada_fecha_nacimiento.getText();
                registro_telefono = entrada_telefono.getText();
                registro_correo = entrada_correo.getText();

                try {
                    cliente.add(registro_ID, registro_nombre, registro_tipo_ID, registro_provincia, registro_canton, registro_fecha_nacimiento, registro_telefono, registro_correo);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
