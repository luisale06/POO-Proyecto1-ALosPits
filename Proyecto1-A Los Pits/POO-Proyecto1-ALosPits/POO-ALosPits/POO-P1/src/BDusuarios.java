import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class BDusuarios {
    public static boolean validarUsuario(String user, String password) {
        try {
            FileReader fw = new FileReader("usuarios.csv");
            BufferedReader bw = new BufferedReader(fw);

            String line;
            while ((line = bw.readLine()) != null) {
                String[] values = line.split(",");
                String usuario = values[0];
                String pass = values[1];
                if (user.equals(usuario) && String.valueOf(password).equals(pass)) {
                    return true;
                }
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean usuarioUnico(String user) {
        try {
            FileReader fw = new FileReader("usuarios.csv");
            BufferedReader bw = new BufferedReader(fw);

            String line;
            while ((line = bw.readLine()) != null) {
                String[] values = line.split(",");
                String usuario = values[0];
                if (user.equals(usuario)) {
                    return false;
                }
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
