import javax.swing.*;
import java.awt.*;

public class Login {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnSignUp;
    private JButton btnLogin;
    private JPanel panel1;

    private JFrame frame;
    Login() {

        frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setResizable(false);

        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
