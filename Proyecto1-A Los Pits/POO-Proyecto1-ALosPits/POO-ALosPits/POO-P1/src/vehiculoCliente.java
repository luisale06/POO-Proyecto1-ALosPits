import javax.swing.*;
import java.io.*;

/**
 * Clase donde se registran los vehiculos a un cliente en específico
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see vehiculoCliente
 */
public class vehiculoCliente {
    File file = new File("vehiculoclientes.csv");

    File temp_file = new File("temp.csv");
    String lineas_archivo;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;
    String[] placas_array;

    /**
     * Método que agrega un nuevo vehiculo al csv ligado a una cédula en específico
     * @param id cédula del cliente
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param year año del vehículo
     * @param placa placa del vehículo
     * @throws IOException
     */
    public void add(String id, String marca, String modelo, String year, String placa) throws IOException {
        boolean ismarca = true;
        try{
            lector = new BufferedReader(new FileReader(file));

            while ((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[4].equals(placa)) {
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
            pw.println(id + "," + marca + "," + modelo + "," + year + "," + placa);
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null,  marca + "," + modelo + " de " + id + " añadido", "", 1);
        }
        else {
            JOptionPane.showMessageDialog(null,  marca + "," + modelo + " de " + id + " previamente añadido", "", 1);
        }
    }

    /**
     * Método que elimina el registro de un vehículo por medio de su placa
     * @param placa placa del vehículo
     * @throws IOException
     */
    public void delete(String placa) throws IOException {
        try{
            fw = new FileWriter(temp_file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            boolean isdeleted = false;

            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null){
                String[] columnas = lineas_archivo.split(",");
                if (!columnas[4].equals(placa)) {
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
                JOptionPane.showMessageDialog(null, "Vehículo de placa: " + placa + " eliminado", "", 1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Vehículo de placa: " + placa + " previamente eliminado", "", 1);
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}
    }

    /**
     * Metodo que retorna un arreglo de placas asociadas a una misma cédula
     * @param identificacion cédula del cliente
     * @return arreglo con las placas de una misma cédula
     */
    public String[] getIDPlacas(String identificacion){
        int cont = 0, id_len = getIDlen(identificacion);
        placas_array = new String[id_len];
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(identificacion)){
                    placas_array[cont] = fila[4];
                    cont++;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return placas_array;
    }

    /**
     * Metodo que retorna la cantidad de placas asociadas a una misma cédula
     * @param identificacion cédula del cliente
     * @return entero con la cantidad de placas
     */
    public int getIDlen(String identificacion){
        int id_len = 0;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(identificacion)) {
                    id_len++;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return id_len;
    }

    /**
     * Metodo que retorna un arreglo con todas las placas registradas
     * @return arreglo con las placas registradas
     */
    public String[] getPlacas(){
        int cont = 0, csv_len = getCSVLen();
        boolean not_titulo = false;
        placas_array = new String[csv_len - 1];
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                if (not_titulo){
                    String[] fila = lineas_archivo.split(",");
                    placas_array[cont] = fila[4];
                    cont++;
                }
                else{
                    not_titulo = true;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return placas_array;
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

    /**
     * Metodo que retorna los datos de un vehiculo en forma de matriz
     * @param placa placa del vehículo
     * @return matriz con los datos del vehículo
     */
    public String[][] getVehiculo(String placa){
        int row = 1, column = 5;
        String[][] info_vehiculo = new String[row][column];
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[4].equals(placa)){
                    int cont2 = 0;
                    while (cont2 != column) {
                        info_vehiculo[0][cont2] = fila[cont2];
                        cont2++;
                    }
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return info_vehiculo;
    }

    public boolean verificaModelo(String marca, String modelo){
        boolean verifica = false;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] filas = lineas_archivo.split(",");
                if (filas[1].equals(marca) && filas[2].equals(modelo)){
                    verifica = true;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return verifica;
    }

    public boolean verificaCliente(String id){
        boolean verifica = false;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] filas = lineas_archivo.split(",");
                if (filas[0].equals(id)){
                    verifica = true;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return verifica;
    }
}
