import javax.swing.*;
import java.io.*;
/**
 * Clase donde se registran los servicios de mecanica general
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see MecanicaGeneral
 */
public class MecanicaGeneral {

    File file = new File("mecanicageneral.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    String[][] servicios;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;
    /**
     * Metodo que registra los datos de un nuevo servicio
     * @param id cedula del cliente
     * @param placa placa del vehiculo
     * @param descripcion_vehiculo detalles del vehiculo
     * @param descripcion_problema detalles del problema
     * @param costo costo del servicio
     * @param fecha_recibido fecha de recibido el vehiculo
     * @param fecha_entrega fecha de entregado el vehiculo
     * @param empleado empleado a cargo del servicio
     * @param estado estado del servicio
     * @throws IOException
     */
    public void add(String id, String placa, String descripcion_vehiculo, String descripcion_problema, String costo, String fecha_recibido, String fecha_entrega, String empleado, String estado) throws IOException {
        boolean ismarca = true;
        try{
            lector = new BufferedReader(new FileReader(file));

            while ((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(id) && fila[1].equals(placa) && fila[2].equals(descripcion_vehiculo) && fila[3].equals(descripcion_problema) && fila[4].equals(costo)
                        && fila[5].equals(fecha_recibido) && fila[6].equals(fecha_entrega) && fila[7].equals(empleado) && fila[8].equals(estado)) {
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
            pw.println(id + "," + placa + "," + descripcion_vehiculo + "," + descripcion_problema + "," + costo + "," + fecha_recibido + "," + fecha_entrega + "," + empleado + "," + estado);
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null,  "Servicio añadido a mecánica general", "", 1);
        }
        else {
            JOptionPane.showMessageDialog(null, "Servicio previamente añadido a mecánica general", "", 1);
        }
    }

    /**
     * Metodo que concatena los datos del servicio en una matriz
     * @param estado estado del servicio que se va a buscar
     * @return retorna una matriz con los servicios por estado
     */
    public String[][] get_serviciosEstado(String estado){
        int cont = 0, column = 9, csv_len = getCSVEstadoLen(estado);
        servicios = new String[csv_len][column];
        try {
            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null) {
                String[] fila = lineas_archivo.split(",");
                if (fila[8].equals(estado)) {
                    int cont2 = 0;
                    while (cont2 != column) {
                        servicios[cont][cont2] = fila[cont2];
                        cont2++;
                    }
                    cont++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servicios;
    }

    /**
     * Metodo que calcula la cantidad de servicios por estado que están registrados
     * @param estado estado a filtrar
     * @return entero con la cantidad de servicios por estado
     */
    public int getCSVEstadoLen(String estado){
        int csv_len = 0;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if(fila[8].equals(estado)){
                    csv_len++;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return csv_len;
    }

    /**
     * Metodo que concatena los servicios de una misma cédula en una matriz
     * @param id cédula a buscar
     * @return retorna una matriz con los servicios por cédula
     */
    public String[][] get_serviciosID(String id){
        String[][] servicios;
        int cont = 0, column = 9, csv_len = getCSVIDLen(id);
        servicios = new String[csv_len][column];
        try {
            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null) {
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(id)) {
                    int cont2 = 0;
                    while (cont2 != column) {
                        servicios[cont][cont2] = fila[cont2];
                        cont2++;
                    }
                    cont++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servicios;
    }

    /**
     * Metodo que calcula la cantidad de registros para una misma cédula
     * @param id cédula a buscar
     * @return entero con la cantidad de servicios
     */
    public int getCSVIDLen(String id){
        int csv_len = 0;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if(fila[0].equals(id)){
                    csv_len++;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return csv_len;
    }

    /**
     * Metodo que concatena los servicios de una misma placa en una matriz
     * @param placa placa a buscar
     * @return retorna una matriz con los servicios por placa
     */

    public String[][] get_serviciosPlaca(String placa){
        String[][] servicios;
        int cont = 0, column = 9, csv_len = getCSVPlacaLen(placa);
        servicios = new String[csv_len][column];
        try {
            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null) {
                String[] fila = lineas_archivo.split(",");
                if (fila[1].equals(placa)) {
                    int cont2 = 0;
                    while (cont2 != column) {
                        servicios[cont][cont2] = fila[cont2];
                        cont2++;
                    }
                    cont++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servicios;
    }

    /**
     * Metodo que calcula la cantidad de registros para una misma placa
     * @param placa placa a buscar
     * @return entero con la cantidad de servicios
     */

    public int getCSVPlacaLen(String placa){
        int csv_len = 0;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if(fila[1].equals(placa)){
                    csv_len++;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return csv_len;
    }

    /**
     * Metodo que retorna los servicios en un vector
     * @return vector con los servicios completos
     */

    public String[] getServicios(){
        String[] servicios;
        int cont = 0, csv_len = getCSVLen();
        servicios = new String[csv_len - 1];
        boolean not_titulo = false;
        try{
            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null) {
                if (not_titulo) {
                    servicios[cont] = lineas_archivo;
                    cont++;
                } else {
                    not_titulo = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servicios;
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
     * Metodo que elimina un servicio específico para agregarlo de nuevo con el nuevo estado
     * @param posicion posicion del servicio en el csv
     * @throws IOException
     * */
    public void delete(int posicion) throws IOException {
        try{
            fw = new FileWriter(temp_file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            int cont = 0;

            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null){
                if (cont != posicion) {
                    pw.println(lineas_archivo);
                }
                cont++;
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
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}
    }

    /**
     * Metodo que agrega el servicio nuevamente con el estado actualizado
     * @param linea_editar datos del servicio en string
     * @param estado estado a agregar/actualizar
     * @throws IOException
     */
    public void setEstado(String linea_editar, String estado) throws IOException {
        String[] fila = linea_editar.split(",");
        fw = new FileWriter(file, true);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        pw.println(fila[0] + "," + fila[1] + "," + fila[2] + "," + fila[3] + "," + fila[4] + "," + fila[5] + "," + fila[6] + "," + fila[7] + "," + estado);
        pw.flush();
        pw.close();
    }

    public boolean verificaPlaca(String placa){
        boolean verifica = false;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                String[] filas = lineas_archivo.split(",");
                if (filas[1].equals(placa)){
                    verifica = true;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return verifica;
    }
}
