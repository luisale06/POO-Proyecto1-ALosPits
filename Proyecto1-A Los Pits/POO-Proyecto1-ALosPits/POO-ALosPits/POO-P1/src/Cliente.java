import javax.swing.*;
import java.io.*;

/**
 * Clase donde se lleva el registro de clientes del taller
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see Cliente
 */
public class Cliente {
    File file = new File("clientes.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;
    String[] id_array;

    /**
     * Metodo para añadir los datos de un cliente
     * @param id cedula del cliente
     * @param nombre nombre del cliente
     * @param tipo_id tipo de cedula del cliente
     * @param provincia provincia donde vive el cliente
     * @param canton canton donde vive el cliente
     * @param nacimiento fecha de nacimiento del cliente
     * @param telefono numero de telefono del cliente
     * @param correo correo electrónico del cliente
     * @throws IOException
     */
    public void add(String id, String nombre, String tipo_id, String provincia, String canton, String nacimiento, String telefono, String correo) throws IOException {
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
            pw.println(id + "," + nombre + "," + tipo_id + "," + provincia + "," + canton + "," + nacimiento + "," + telefono + "," + correo);
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null, nombre + " añadid@", "", 1);
        }
        else {
            JOptionPane.showMessageDialog(null, nombre + " previamente añadid@", "", 1);
        }
    }

    /**
     * Método que elimina el registro de un cliente por medio de su cédula
     * @param id cédula del cliente
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
     * Metodo para obtener todas las cedulas registradas
     * @return retorna las cedulas de los clientes
     */
    public String[] getIDs(){
        int cont = 0, csv_len = getCSVLen();
        boolean not_titulo = false;
        id_array = new String[csv_len - 1];
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                if (not_titulo){
                    String[] fila = lineas_archivo.split(",");
                    id_array[cont] = fila[0];
                    cont++;
                }
                else{
                    not_titulo = true;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return id_array;
    }

    /**
     * Metodo que cuenta la cantidad de filas en el csv
     * @return cantidad de filas en el csv
     */
    public int getCSVLen(){
        int csv_len = 0;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                csv_len++;
            }
        }catch(Exception e) {e.printStackTrace();}
        return csv_len;
    }

    /**
     * Metodo que retorna los datos de un cliente en forma de matriz
     * @param id cedula del cliente
     * @return matriz con los datos del cliente
     */
    public String[][] getCliente(String id){
        int row = 1, column = 8;
        String[][] info_cliente = new String[row][column];
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(id)){
                    int cont2 = 0;
                    while (cont2 != column) {
                        info_cliente[0][cont2] = fila[cont2];
                        cont2++;
                    }
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return info_cliente;
    }
}
