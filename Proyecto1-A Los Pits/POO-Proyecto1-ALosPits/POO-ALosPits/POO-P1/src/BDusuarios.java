import java.io.*;

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
