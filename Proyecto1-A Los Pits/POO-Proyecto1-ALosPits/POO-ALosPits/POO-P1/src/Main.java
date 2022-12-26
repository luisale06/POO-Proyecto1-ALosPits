import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new LoginUsuarioGUI();
        EnderezadoPintura end = new EnderezadoPintura();
        System.out.println(end.getCasos());
    }
}