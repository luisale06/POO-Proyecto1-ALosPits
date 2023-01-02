import javax.swing.*;
import java.io.*;

/**
 * Clase donde se registran los modelos de vehiculos automoviles
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see Modelo
 */
public class Modelo {
    File file = new File("modelos.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    String[] marca_modelo_array;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;

    /**
     * Método que agrega un nuevo modelo al csv
     * @param marca marca del vehículo
     * @param tipo tipo de vehículo
     * @param modelo modelo del vehículo
     * @param asientos cantidad asientos del vehículo
     * @param puertas cantidad de puertas
     * @param combustible tipo de combustible
     * @param transmision tipo de transmisión
     * @throws IOException
     */

    public void add(String marca, String tipo, String modelo, String asientos, String puertas, String combustible, String transmision) throws IOException {
        boolean ismarca = true;
        try{
            lector = new BufferedReader(new FileReader(file));

            while ((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(marca) && fila[1].equals(tipo) && fila[2].equals(modelo) && fila[3].equals(asientos)
                        && fila[4].equals(puertas) && fila[5].equals(combustible) && fila[6].equals(transmision)) {
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
            pw.println(marca + "," + tipo + "," + modelo + "," + asientos + "," + puertas + "," + combustible + "," + transmision);
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null, modelo + " añadido", "", 1);
        }
        else {
            JOptionPane.showMessageDialog(null, modelo + " previamente añadido", "", 1);
        }
    }

    /**
     * Método que elimina un modelo del csv
     * @param marca marca del vehículo
     * @param tipo tipo de vehículo
     * @param modelo modelo del vehículo
     * @param asientos cantidad asientos del vehículo
     * @param puertas cantidad de puertas
     * @param combustible tipo de combustible
     * @param transmision tipo de transmisión
     * @throws IOException
     */
    public void delete(String marca, String tipo, String modelo, String asientos, String puertas, String combustible, String transmision) throws IOException {
        try{
            fw = new FileWriter(temp_file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            boolean isdeleted = false;

            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null){
                String[] columnas = lineas_archivo.split(",");
                if (!columnas[0].equals(marca) || !columnas[1].equals(tipo) || !columnas[2].equals(modelo) || !columnas[3].equals(asientos)
                        || !columnas[4].equals(puertas) || !columnas[5].equals(combustible) || !columnas[6].equals(transmision)) {
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
                JOptionPane.showMessageDialog(null, modelo + " eliminado", "", 1);
            }
            else{
                JOptionPane.showMessageDialog(null, modelo + " previamente eliminado", "", 1);
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}
    }

    /**
     * Método que retorna los modelos y marcas en forma de arreglo
     * @return retorna un arreglo con las marcas y modelos
     */
    public String[] getMarcaModelo(){
        int cont = 0, csv_len = getCSVLen();
        boolean not_titulo = false;
        marca_modelo_array = new String[csv_len - 1];
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                if (not_titulo){
                    String[] fila = lineas_archivo.split(",");
                    marca_modelo_array[cont] = fila[0] + "," + fila[2];
                    cont++;
                }
                else{
                    not_titulo = true;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return marca_modelo_array;
    }

    /**
     * Metodo que calcula la cantidad de filas que existen en el csv
     * @return entero con la cantidad de filas
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
    public boolean verificaMarca(String marca, String tipo){
        boolean verifica = false;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] filas = lineas_archivo.split(",");
                if (filas[0].equals(marca) && filas[1].equals(tipo)){
                    verifica = true;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return verifica;
    }
}
