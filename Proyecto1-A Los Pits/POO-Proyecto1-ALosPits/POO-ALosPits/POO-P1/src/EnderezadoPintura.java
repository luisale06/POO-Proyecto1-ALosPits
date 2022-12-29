import java.io.*;

public class EnderezadoPintura {

    File file = new File("enderezadopintura.csv");
    String lineas_archivo;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    BufferedReader lector;

    public void add(String id, String placa, String descripcion_vehiculo, String partes_enderezar_pintar, String costo, String poliza, String numero_caso, String fecha_recibido, String fecha_entrega, String empleado, String estado) throws IOException {
        boolean ismarca = true;
        try{
            lector = new BufferedReader(new FileReader(file));

            while ((lineas_archivo = lector.readLine()) != null){
                String[] fila = lineas_archivo.split(",");
                if (fila[0].equals(id) && fila[1].equals(placa) && fila[2].equals(descripcion_vehiculo) && fila[3].equals(partes_enderezar_pintar) && fila[4].equals(costo)
                        && fila[5].equals(poliza) && fila[6].equals(numero_caso) && fila[7].equals(fecha_recibido) && fila[8].equals(fecha_entrega) && fila[9].equals(empleado) && fila[10].equals(estado)) {
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
            pw.println(id + "," + placa + "," + descripcion_vehiculo + "," + partes_enderezar_pintar + "," + costo + "," + poliza + "," + numero_caso + "," + fecha_recibido + "," + fecha_entrega + "," + empleado + "," + estado);
            pw.flush();
            pw.close();
            System.out.println("Servicio Añadido");
        }
        else {
            System.out.println("Servicio NO añadido");
        }
    }

    public int getCasos(){
        int casos = 0;
        try{
            lector = new BufferedReader(new FileReader(file));
            while((lineas_archivo = lector.readLine()) != null){
                casos++;
            }
        }catch(Exception e) {e.printStackTrace();}
        return casos;
    }

    public String[][] get_serviciosEstado(String estado){
        String[][] servicios;
        int cont = 0, column = 11, csv_len = getCSVEstadoLen(estado);
        servicios = new String[csv_len][column];
        try {
            lector = new BufferedReader(new FileReader(file));
            while ((lineas_archivo = lector.readLine()) != null) {
                String[] fila = lineas_archivo.split(",");
                if (fila[10].equals(estado)) {
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
                if(fila[10].equals(estado)){
                    csv_len++;
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return csv_len;
    }
}
