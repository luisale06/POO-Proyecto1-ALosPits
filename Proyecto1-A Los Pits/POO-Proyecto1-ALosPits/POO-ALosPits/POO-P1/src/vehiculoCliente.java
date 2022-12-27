import java.io.*;
import java.util.Arrays;

public class vehiculoCliente {
    File file = new File("vehiculoclientes.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;
    String[] placas_array;

    public void add(String id, String marca, String modelo, String year, String placa) throws IOException {
        boolean ismarca = true;
        try{
            lector = new BufferedReader(new FileReader(file));

            while ((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(id) && fila[1].equals(marca) && fila[2].equals(modelo) && fila[3].equals(year) && fila[4].equals(placa)) {
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
            System.out.println(marca + "," + modelo + " de " + id + " Añadido");
        }
        else {
            System.out.println(marca + "," + modelo + " de " + id + " No Añadido");
        }
    }

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
}
