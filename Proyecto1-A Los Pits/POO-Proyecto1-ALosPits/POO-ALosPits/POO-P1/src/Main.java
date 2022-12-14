import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Login();
        Marca marca = new Marca();
        Usuario usuario = new Usuario();

        //marca.add("Jeep", "Pickup");

        marca.delete("Jeep", "Pickup");

        //usuario.add("Fabian", "abc123");
    }
}