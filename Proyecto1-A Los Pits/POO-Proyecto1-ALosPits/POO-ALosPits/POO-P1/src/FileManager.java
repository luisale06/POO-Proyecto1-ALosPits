import java.io.*;
import java.util.ArrayList;

public class FileManager {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static void writeFile(String user, String passw, String path) throws IOException {
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(user+","+passw);
        bw.newLine();
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

}
