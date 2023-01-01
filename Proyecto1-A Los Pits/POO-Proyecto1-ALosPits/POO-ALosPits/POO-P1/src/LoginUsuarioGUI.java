import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginUsuarioGUI {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnSignUp;
    private JButton btnLogin;
    private JPanel panel1;

    private JFrame frame;
    LoginUsuarioGUI() {

        frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setResizable(false);

        frame.add(panel1);

        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BDusuarios.validarUsuario(txtUsuario.getText(), txtPassword.getText())) {
//                    JOptionPane.showMessageDialog(null, "Login successful!");

                    menuGUI ventanaMenu = new menuGUI();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No existe ese usuario.", "Usuario Inexistente", 1);
                    txtUsuario.setText("");
                    txtPassword.setText("");
                }
            }
        });

        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BDusuarios.usuarioUnico(txtUsuario.getText())) {
                    BDusuarios.addUsuario(txtUsuario.getText(), txtPassword.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario existente - INTENTE DE NUEVO.", "Usuario Existente", 1);
                    txtUsuario.setText("");
                    txtPassword.setText("");
                }
            }
        });
    }
}
