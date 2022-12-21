import java.io.*;

public class Usuario {

//    String user;
//    String password;
//    String nombre;
//
//    public Usuario(String user, String password, String nombre) {
//        this.user = user;
//        this.password = password;
//        this.nombre = nombre;
//    }

    File file = new File("usuarios.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;

    public void add(String usuario, String password) throws IOException {
        boolean isusuario = true;
        try{
            lector = new BufferedReader(new FileReader(file));

            while ((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(usuario) && fila[1].equals(password)) {
                    isusuario = false;
                    break;
                }
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}

        if (isusuario){
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(usuario + "," + password);
            pw.flush();
            pw.close();
            System.out.println(usuario + "," + password + " Añadida");
        }
        else {
            System.out.println(usuario + "," + password + " NO añadida");
        }
    }

    public void delete(String usuario, String password) throws IOException {
        try{
            fw = new FileWriter(temp_file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            boolean isdeleted = false;

            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null){
                String[] columnas = lineas_archivo.split(",");
                if (!columnas[0].equals(usuario) || !columnas[1].equals(password)) {
                    pw.println(lineas_archivo);
                }
                else {
                    isdeleted = true;
                }
            }

            pw.flush();
            pw.close();

            FileInputStream in = new FileInputStream(temp_file);
            FileOutputStream out = new FileOutputStream(file);
            try{
                int n;

                while ((n = in.read()) != -1){
                    out.write(n);
                }
            }finally{
                if (in != null){
                    in.close();
                }
                if (out != null){
                    out.close();
                }
            }
            temp_file.delete();

            if (isdeleted == true){
                System.out.println(usuario + "," + password + " Eliminada");
            }
            else{
                System.out.println(usuario + "," + password + " NO Eliminada");
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}
    }
}