import java.util.ArrayList;
import java.io.File;

/*public class BDusuarios {
    String filepath = "usuarios.csv";
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public BDusuarios() {
        File tmpFile = new File(filepath);
        if(!tmpFile.exists())
            FileManager.writeFile(this, filepath);
    }

    public void guardarUsuario(String user, String psw, String nombre) {
        usuarios.add(new Usuario(user, psw, nombre));
    }

    public void guardar(){
        FileManager.writeFile(this, filepath);
    }

    public void restaurar(){
        BDusuarios bd = (BDusuarios) FileManager.readFile(filepath);
        usuarios = bd.usuarios;
    }

    public boolean buscarUsuario(String user, String psw){
        for (Usuario usuario : usuarios) {
            if (usuario.user.equals(user) && usuario.password.equals(psw))
                return true;
        }
        return false;
    }

    public boolean existeUsuario(String user) {
        for (Usuario usuario: usuarios) {
            if (usuario.user.equals(user))
                return true;
        }
        return false;
    }

}*/
