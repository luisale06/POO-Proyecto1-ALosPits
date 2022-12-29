import java.io.*;
import java.util.Arrays;

public class Cliente {
    File file = new File("clientes.csv");
    File temp_file = new File("temp.csv");
    String lineas_archivo;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;
    String[] id_array;

    public void add(String id, String nombre, String tipo_id, String provincia, String canton, String nacimiento, String telefono, String correo) throws IOException {
        boolean ismarca = true;
        try{
            lector = new BufferedReader(new FileReader(file));

            while ((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(id) && fila[1].equals(nombre) && fila[2].equals(tipo_id) && fila[3].equals(provincia)
                        && fila[4].equals(canton) && fila[5].equals(nacimiento) && fila[6].equals(telefono) && fila[7].equals(correo)) {
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
            System.out.println(nombre + " Añadid@");
        }
        else {
            System.out.println(nombre + " NO añadid@");
        }
    }

    public void delete(String id, String nombre, String tipo_id, String provincia, String canton, String nacimiento, String telefono, String correo) throws IOException {
        try{
            fw = new FileWriter(temp_file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            boolean isdeleted = false;

            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null){
                String[] columnas = lineas_archivo.split(",");
                if (!columnas[0].equals(id) || !columnas[1].equals(nombre) || !columnas[2].equals(tipo_id) || !columnas[3].equals(provincia)
                        || !columnas[4].equals(canton) || !columnas[5].equals(nacimiento) || !columnas[6].equals(telefono) || !columnas[7].equals(correo)) {
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
                System.out.println(nombre + " Eliminad@");
            }
            else{
                System.out.println(nombre + " NO Eliminad@");
            }
        }
        catch(Exception e) {e.printStackTrace();}
        finally {lector.close();}
    }

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
