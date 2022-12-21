import java.io.*;
import java.util.ArrayList;

/*public class FileManager {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static void writeFile(Integer modo, String user, String passw, String path) throws IOException {
        File file = null;

        switch (modo) {
            case 1 -> file = new File("usuarios.csv");
            case 2 -> file = new File("modelos.csv");
            case 3 -> file = new File("marcas.csv");
            case 4 -> file = new File("clientes.csv");
        }

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

    }

    public static <Usuario> void writeFile_usuarios(ArrayList<Usuario> arreglo, String path) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Usuario u : arreglo) {
                bw.write(u. + "," + usuario.password + "," + usuario.nombre);
            }

            for (int i = 0; i < usuarios.size(); i++) {
                usuarios.get(i)
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object readFile(String path) {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                usuarios.add(new Usuario(values[0], values[1], values[2]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}*/