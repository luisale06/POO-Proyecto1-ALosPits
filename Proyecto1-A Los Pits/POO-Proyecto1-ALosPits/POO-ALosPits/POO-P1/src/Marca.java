import java.io.*;


public class Marca {

    String file = "marcas.csv", tipo = "4x4";
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;

    public void add(String marca) {
        try{
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(marca + "," + tipo);
            pw.flush();
            pw.close();
            System.out.println(marca + " Añadida");
        }
        catch(Exception e) {e.printStackTrace();}
    }

    public void delete(String marca) {
        System.out.println(marca + " Eliminada");
    }
}
