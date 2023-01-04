import javax.swing.*;
import java.io.*;

/**
 * Clase donde se lleva el registro de empleados del taller
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see Empleado
 */
public class Empleado {
    File file = new File("usuarios.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;

    /**
     * Metodo para añadir los datos de un empleado
     * @param id cedula del empleado
     * @param nombre nombre del empleado
     * @param tipo_id tipo de identificación
     * @param rol rol del empleado
     * @param fechaingreso fecha ingreso del empleado
     * @param telefono telefono del empleado
     * @param correo correo del empleado
     * @param username usuario del empleado
     * @param password contraseña del empleado
     * @throws IOException
     */
    public void add(String id, String nombre, String tipo_id, String rol, String fechaingreso, String telefono, String correo, String username, String password) throws IOException {
        boolean ismarca = true;
        try{
            lector = new BufferedReader(new FileReader(file));

            while ((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(id)) {
                    ismarca = false;
                    break;
                }
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}

        if (ismarca){
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(id + "," + nombre + "," + tipo_id + "," + rol + "," + fechaingreso + "," + telefono + "," + correo + "," + username + "," + password);
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null, nombre + " añadid@", "", 1);
        }
        else {
            JOptionPane.showMessageDialog(null, nombre + " previamente añadid@", "", 1);
        }
    }

    /**
     * Método que elimina el registro de un empleado por medio de su cédula
     * @param id cédula del empleado
     * @throws IOException
     */
    public void delete(String id) throws IOException {
        try{
            fw = new FileWriter(temp_file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            boolean isdeleted = false;

            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null){
                String[] columnas = lineas_archivo.split(",");
                if (!columnas[0].equals(id)) {
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
                JOptionPane.showMessageDialog(null, id + " eliminado", "", 1);
            }
            else{
                JOptionPane.showMessageDialog(null, id + " previamente eliminado", "", 1);
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}
    }

    /**
     * Metodo que indica si un username y password coinciden
     * @return boolean si el username y password son correctos
     */
    public boolean loginEmpleado(String username, String password){
        boolean login = false;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] filas = lineas_archivo.split(",");
                if (filas[7].equals(username) && filas[8].equals(password)){
                    login = true;
                    break;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return login;
    }
}