import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Ventana donde se accede al sistema con usuario y contraseña
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see loginGUI
 */
public class loginGUI{
    //Frame
    private JFrame frame = new JFrame("Inicio de Sesion");

    //Labels
    static JLabel fondo = new JLabel(new ImageIcon("fondo.jpg"));
    static JLabel inicio_sesion = new JLabel();
    static JLabel indicador_username = new JLabel();
    static JLabel indicador_password = new JLabel();

    //Buttons
    public JButton iniciar_sesion = new JButton();
    public JButton crear_cuenta = new JButton();

    //TextFields
    public JTextField entrada_username = new JTextField();
    public JTextField entrada_password = new JTextField();

    //Control CSVs
    Empleado empleado = new Empleado();

    /**
     * Metodo constructor donde se editan los objetos de la ventana
     */
    loginGUI() {

        //Labels
        inicio_sesion.setFont(new Font("", Font.PLAIN, 21));
        inicio_sesion.setForeground(Color.blue);
        inicio_sesion.setBackground(Color.white);
        inicio_sesion.setOpaque(true);
        inicio_sesion.setText("Inicio de Sesion");
        inicio_sesion.setBounds(140, 20, 190, 25);

        indicador_username.setFont(new Font("", Font.PLAIN, 12));
        indicador_username.setForeground(Color.blue);
        indicador_username.setBackground(Color.white);
        indicador_username.setOpaque(true);
        indicador_username.setText("Username");
        indicador_username.setBounds(275, 50, 40, 20);

        indicador_password.setFont(new Font("", Font.PLAIN, 12));
        indicador_password.setForeground(Color.blue);
        indicador_password.setBackground(Color.white);
        indicador_password.setOpaque(true);
        indicador_password.setText("Password");
        indicador_password.setBounds(275, 80, 40, 20);

        //Combobox
        entrada_username.setFont(new Font("", Font.BOLD, 12));
        entrada_username.setBounds(140, 50, 130, 20);

        entrada_password.setFont(new Font("", Font.BOLD, 12));
        entrada_password.setBounds(140, 80, 130, 20);

        //Buttons
        iniciar_sesion.setFont(new Font("", Font.BOLD, 12));
        iniciar_sesion.setText("Iniciar Sesion");
        iniciar_sesion.setBackground(Color.white);
        iniciar_sesion.setBounds(140, 110, 90, 20);

        crear_cuenta.setFont(new Font("", Font.BOLD, 12));
        crear_cuenta.setText("Crear Cuenta");
        crear_cuenta.setBackground(Color.white);
        crear_cuenta.setBounds(230, 110, 90, 20);

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        frame.add(inicio_sesion);
        frame.add(entrada_username);
        frame.add(entrada_password);
        frame.add(iniciar_sesion);
        frame.add(crear_cuenta);
        frame.add(indicador_username);
        frame.add(indicador_password);
        frame.add(fondo);
        frame.setResizable(false);
        frame.setVisible(true);

        /**
         * Accion asociada a los botones para iniciar sesión o registrar y eliminar empleados
         */
        iniciar_sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username, password;
                boolean login;
                username = entrada_username.getText();
                password = entrada_password.getText();
                login = empleado.loginEmpleado(username, password);

                if(login){
                    menuGUI ventana_menu = new menuGUI();
                }
            }
        });
        crear_cuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empleadoGUI ventana_empleado = new empleadoGUI();
            }
        });
    }
}
