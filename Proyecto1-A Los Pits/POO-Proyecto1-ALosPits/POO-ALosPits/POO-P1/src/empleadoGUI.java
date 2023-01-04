import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Ventana donde se introducen los datos de los empleados
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see empleadoGUI
 */
public class empleadoGUI {

    private final JFrame frame = new JFrame("Registro de Clientes");

    //Label
    static JLabel fondo = new JLabel(new ImageIcon("fondo.jpg"));
    static JLabel registro_cliente = new JLabel();
    static JLabel indicador_ID = new JLabel();
    static JLabel indicador_nombre = new JLabel();
    static JLabel indicador_tipo_ID = new JLabel();
    static JLabel indicador_rol = new JLabel();
    static JLabel indicador_fecha_ingreso = new JLabel();
    static JLabel indicador_telefono = new JLabel();
    static JLabel indicador_correo = new JLabel();
    static JLabel indicador_username = new JLabel();
    static JLabel indicador_password = new JLabel();
    static JLabel indicador_confirmacion = new JLabel();

    //Button
    public JButton aceptar_registro_cliente = new JButton();
    public JButton eliminar_registro_cliente = new JButton();

    //Textfield
    public JTextField entrada_ID = new JTextField();
    public JTextField entrada_nombre = new JTextField();
    public JTextField entrada_rol = new JTextField();
    public JTextField entrada_fecha_ingreso = new JTextField();
    public JTextField entrada_telefono = new JTextField();
    public JTextField entrada_correo = new JTextField();
    public JTextField entrada_username = new JTextField();
    public JTextField entrada_password = new JTextField();
    public JTextField entrada_confirmacion = new JTextField();


    //Combobox
    public String[] tipo_ID_array = {"Cedula fisica", "DIMEX", "DIDI", "NITE", "Cedula juridica"};

    public JComboBox combobox_tipo_ID = new JComboBox(tipo_ID_array);

    //CSVs
    Empleado empleado = new Empleado();

    /**
     * Metodo constructor donde se editan los objetos de la ventana
     */
    empleadoGUI(){
        //Labels
        registro_cliente.setFont(new Font("", Font.PLAIN, 21));
        registro_cliente.setForeground(Color.blue);
        registro_cliente.setBackground(Color.white);
        registro_cliente.setOpaque(true);
        registro_cliente.setText("Registro de Empleados");
        registro_cliente.setBounds(140, 20, 220, 25);

        indicador_ID.setFont(new Font("", Font.BOLD, 12));
        indicador_ID.setForeground(Color.blue);
        indicador_ID.setBackground(Color.white);
        indicador_ID.setOpaque(true);
        indicador_ID.setText("Identificacion");
        indicador_ID.setBounds(90, 130, 185, 20);

        indicador_nombre.setFont(new Font("", Font.BOLD, 12));
        indicador_nombre.setForeground(Color.blue);
        indicador_nombre.setBackground(Color.white);
        indicador_nombre.setOpaque(true);
        indicador_nombre.setText("Nombre Completo");
        indicador_nombre.setBounds(300, 130, 185, 20);

        indicador_tipo_ID.setFont(new Font("", Font.BOLD, 12));
        indicador_tipo_ID.setForeground(Color.blue);
        indicador_tipo_ID.setBackground(Color.white);
        indicador_tipo_ID.setOpaque(true);
        indicador_tipo_ID.setText("Tipo Identificacion");
        indicador_tipo_ID.setBounds(80, 200, 185, 20);

        indicador_rol.setFont(new Font("", Font.BOLD, 12));
        indicador_rol.setForeground(Color.blue);
        indicador_rol.setBackground(Color.white);
        indicador_rol.setOpaque(true);
        indicador_rol.setText("Rol");
        indicador_rol.setBounds(330, 200, 80, 20);

        indicador_fecha_ingreso.setFont(new Font("", Font.BOLD, 12));
        indicador_fecha_ingreso.setForeground(Color.blue);
        indicador_fecha_ingreso.setBackground(Color.white);
        indicador_fecha_ingreso.setOpaque(true);
        indicador_fecha_ingreso.setText("Fecha de Ingreso");
        indicador_fecha_ingreso.setBounds(90, 270, 175, 20);

        indicador_telefono.setFont(new Font("", Font.BOLD, 12));
        indicador_telefono.setForeground(Color.blue);
        indicador_telefono.setBackground(Color.white);
        indicador_telefono.setOpaque(true);
        indicador_telefono.setText("Numero de Telefono");
        indicador_telefono.setBounds(290, 270, 185, 20);

        indicador_correo.setFont(new Font("", Font.BOLD, 12));
        indicador_correo.setForeground(Color.blue);
        indicador_correo.setBackground(Color.white);
        indicador_correo.setOpaque(true);
        indicador_correo.setText("Correo Electronico");
        indicador_correo.setBounds(80, 340, 185, 20);

        indicador_username.setFont(new Font("", Font.BOLD, 12));
        indicador_username.setForeground(Color.blue);
        indicador_username.setBackground(Color.white);
        indicador_username.setOpaque(true);
        indicador_username.setText("Username");
        indicador_username.setBounds(310, 340, 185, 20);

        indicador_password.setFont(new Font("", Font.BOLD, 12));
        indicador_password.setForeground(Color.blue);
        indicador_password.setBackground(Color.white);
        indicador_password.setOpaque(true);
        indicador_password.setText("Password");
        indicador_password.setBounds(100, 410, 150, 20);

        indicador_confirmacion.setFont(new Font("", Font.BOLD, 12));
        indicador_confirmacion.setForeground(Color.blue);
        indicador_confirmacion.setBackground(Color.white);
        indicador_confirmacion.setOpaque(true);
        indicador_confirmacion.setText("Confirm Password");
        indicador_confirmacion.setBounds(300, 410, 150, 20);

        //Combobox
        combobox_tipo_ID.setBounds(40, 180, 185, 20);
        combobox_tipo_ID.setBackground(Color.white);

        //TextField
        entrada_ID.setFont(new Font("", Font.BOLD, 12));
        entrada_ID.setBounds(40, 110, 185, 20);

        entrada_nombre.setFont(new Font("", Font.BOLD, 12));
        entrada_nombre.setBounds(250, 110, 185, 20);

        entrada_rol.setFont(new Font("", Font.BOLD, 12));
        entrada_rol.setBounds(250, 180, 185, 20);

        entrada_fecha_ingreso.setFont(new Font("", Font.BOLD, 12));
        entrada_fecha_ingreso.setBounds(40, 250, 185, 20);

        entrada_telefono.setFont(new Font("", Font.BOLD, 12));
        entrada_telefono.setBounds(250, 250, 185, 20);

        entrada_correo.setFont(new Font("", Font.BOLD, 12));
        entrada_correo.setBounds(40, 320, 185, 20);

        entrada_username.setFont(new Font("", Font.BOLD, 12));
        entrada_username.setBounds(250, 320, 185, 20);

        entrada_password.setFont(new Font("", Font.BOLD, 12));
        entrada_password.setBounds(40, 390, 185, 20);

        entrada_confirmacion.setFont(new Font("", Font.BOLD, 12));
        entrada_confirmacion.setBounds(250, 390, 185, 20);

        //Buttons
        aceptar_registro_cliente.setFont(new Font("", Font.BOLD, 12));
        aceptar_registro_cliente.setText("Registrar");
        aceptar_registro_cliente.setBackground(Color.white);
        aceptar_registro_cliente.setBounds(185, 460, 90, 20);

        eliminar_registro_cliente.setFont(new Font("", Font.BOLD, 12));
        eliminar_registro_cliente.setText("Eliminar");
        eliminar_registro_cliente.setBackground(Color.white);
        eliminar_registro_cliente.setBounds(185, 480, 90, 20);

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 540);

        fondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        frame.add(registro_cliente);
        frame.add(entrada_ID);
        frame.add(entrada_nombre);
        frame.add(combobox_tipo_ID);
        frame.add(entrada_rol);
        frame.add(entrada_fecha_ingreso);
        frame.add(entrada_telefono);
        frame.add(entrada_correo);
        frame.add(entrada_username);
        frame.add(entrada_password);
        frame.add(entrada_confirmacion);

        frame.add(indicador_ID);
        frame.add(indicador_nombre);
        frame.add(indicador_tipo_ID);
        frame.add(indicador_rol);
        frame.add(indicador_fecha_ingreso);
        frame.add(indicador_telefono);
        frame.add(indicador_correo);
        frame.add(indicador_username);
        frame.add(indicador_password);
        frame.add(indicador_confirmacion);

        frame.add(aceptar_registro_cliente);
        frame.add(eliminar_registro_cliente);
        frame.add(fondo);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        /**
         * Accion asociada al boton para registrar al empleado
         */

        aceptar_registro_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String registro_ID, registro_nombre, registro_tipo_ID, registro_rol, registro_fecha_ingreso, registro_telefono, registro_correo, registro_username, registro_password, registro_confirmacion;

                registro_ID = entrada_ID.getText();
                registro_nombre = entrada_nombre.getText();
                registro_tipo_ID = String.valueOf(combobox_tipo_ID.getSelectedItem());
                registro_rol = entrada_rol.getText();
                registro_fecha_ingreso = entrada_fecha_ingreso.getText();
                registro_telefono = entrada_telefono.getText();
                registro_correo = entrada_correo.getText();
                registro_username = entrada_username.getText();
                registro_password = entrada_password.getText();
                registro_confirmacion = entrada_confirmacion.getText();

                try {
                    if (registro_password.equals(registro_confirmacion)){
                        empleado.add(registro_ID, registro_nombre, registro_tipo_ID, registro_rol, registro_fecha_ingreso, registro_telefono, registro_correo, registro_username, registro_password);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Empleado no agregado", 1);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        eliminar_registro_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String registro_ID;
                registro_ID = entrada_ID.getText();

                try{
                    empleado.delete(registro_ID);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
