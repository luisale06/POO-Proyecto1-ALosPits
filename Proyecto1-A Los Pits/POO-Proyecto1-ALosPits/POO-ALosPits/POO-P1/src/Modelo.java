import java.io.*;
import java.util.Arrays;

public class Modelo {
    File file = new File("modelos.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    String[] marca_modelo_array;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;

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
            System.out.println(modelo + " Añadido");
        }
        else {
            System.out.println(modelo + " NO añadido");
        }
    }

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
                System.out.println(modelo + " Eliminado");
            }
            else{
                System.out.println(modelo + " NO Eliminado");
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}
    }

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
