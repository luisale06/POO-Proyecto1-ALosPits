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
}
