import java.io.*;

/**
 * Clase donde se registran los usuarios y contraseñas, contiene metodos necesarios para la validacion de estos.
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see BDusuarios
 */
public class BDusuarios {
    /**
     * Valida que la contraseña ingresada coincida con el nombre de usuario en el archivo csv correspondiente.
     * @param user     el usuario
     * @param password la contraseña
     * @return valar booleano
     */
    public static boolean validarUsuario(String user, String password) {
        try {
            FileReader fw = new FileReader("usuarios.csv");
            BufferedReader bw = new BufferedReader(fw);

            String line;
            while ((line = bw.readLine()) != null) {
                String[] values = line.split(",");
                String usuario = values[0];
                String pass = values[1];
                if (user.equals(usuario) && password.equals(pass)) {
                    return true;
                }
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Valida que un nombre de usuario solo este registrado una vez en el archivo csv correspondiente.
     *
     * @param user el usuario
     * @return valor booleano
     */
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

    /**
     * Añade un usuario al archivo csv correspondiente.
     *
     * @param user     el usuario
     * @param password la contraseña
     */
    public static void addUsuario(String user, String password) {
        try {
            File file = new File("usuarios.csv");
            FileWriter fw = new FileWriter(file, true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(user + "," + password);
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
