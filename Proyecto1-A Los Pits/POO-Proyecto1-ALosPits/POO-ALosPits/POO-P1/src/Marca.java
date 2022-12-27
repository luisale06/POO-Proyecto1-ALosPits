import java.io.*;
import java.util.Arrays;

public class Marca {

    File file = new File("marcas.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    String[] marca_tipo_array;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;

    public void add(String marca, String tipo) throws IOException {
        boolean ismarca = true;
        try{
            lector = new BufferedReader(new FileReader(file));

            while ((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(marca) && fila[1].equals(tipo)) {
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
            pw.println(marca + "," + tipo);
            pw.flush();
            pw.close();
            System.out.println(marca + "," + tipo + " Añadida");
        }
        else {
            System.out.println(marca + "," + tipo + " NO añadida");
        }
    }

    public void delete(String marca, String tipo) throws IOException {
        try{
            fw = new FileWriter(temp_file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            boolean isdeleted = false;

            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null){
                String[] columnas = lineas_archivo.split(",");
                if (!columnas[0].equals(marca) || !columnas[1].equals(tipo)) {
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
                System.out.println(marca + "," + tipo + " Eliminada");
            }
            else{
                System.out.println(marca + "," + tipo + " NO Eliminada");
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}
    }

    public String[] getMarcaTipo() {
        int cont = 0, csv_len = getCSVLen();
        boolean not_titulo = false;
        marca_tipo_array = new String[csv_len - 1];
        try {
            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null) {
                if (not_titulo) {
                    marca_tipo_array[cont] = lineas_archivo;
                    cont++;
                } else {
                    not_titulo = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sort_string_array();
        return marca_tipo_array;
    }

    public void sort_string_array(){
        int size = marca_tipo_array.length;

        for(int i = 0; i<size-1; i++) {
            for (int j = i+1; j<marca_tipo_array.length; j++) {
                if(marca_tipo_array[i].compareTo(marca_tipo_array[j])>0) {
                    String temp = marca_tipo_array[i];
                    marca_tipo_array[i] = marca_tipo_array[j];
                    marca_tipo_array[j] = temp;
                }
            }
        }
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
