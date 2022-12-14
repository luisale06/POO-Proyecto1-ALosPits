import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
//    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static void writeFile(String user, String passw, String path) throws IOException {
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(user+","+passw);
        bw.newLine();
    }

    public static Object readFile(String path) {

    }

}
