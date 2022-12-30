import java.io.*;
import java.util.Arrays;

public class MecanicaGeneral {

    File file = new File("mecanicageneral.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    String[][] servicios;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;

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
            System.out.println("Servicio añadido");
        }
        else {
            System.out.println("Servicio NO añadido");
        }
    }

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

    public void deleteEstado(int posicion) throws IOException {
        try{
            fw = new FileWriter(temp_file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            boolean isdeleted = false;
            int cont = 0;

            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null){
                if (cont != posicion) {
                    pw.println(lineas_archivo);
                }
                else {
                    isdeleted = true;
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

            if (isdeleted == true){
                System.out.println("Estado Eliminado");
            }
            else{
                System.out.println("Estado no Eliminado");
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}
    }

    public void setEstado(String linea_editar, String estado) throws IOException {
        String[] fila = linea_editar.split(",");
        fw = new FileWriter(file, true);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        pw.println(fila[0] + "," + fila[1] + "," + fila[2] + "," + fila[3] + "," + fila[4] + "," + fila[5] + "," + fila[6] + "," + fila[7] + "," + estado);
        pw.flush();
        pw.close();
    }
}
