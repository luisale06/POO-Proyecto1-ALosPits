import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Ventana donde se consultan los servicios del taller por cedula, placa o estado
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see consultaServicioGUI
 */
public class consultaServicioGUI {
    //Frame
    private final JFrame frame = new JFrame("Servicios");
    public String[][] servicios_end_pint1;
    public String[][] servicios_end_pint2;
    public String[][] servicios_end_pint3;
    public String[][] servicios_mec_gen1;
    public String[][] servicios_mec_gen2;
    public String[][] servicios_mec_gen3;
    public String[][] servicios_final_ep;
    public String[][] servicios_final_mg;

    //Labels
    public JLabel nombre_tabla_mg = new JLabel();
    public JLabel nombre_tabla_ep = new JLabel();

    //Table
    public String[] columnas_servicios_mg = {"Cedula", "Placa", "Descripcion del Vehiculo", "Descripcion del Problema", "Costo", "Fecha Recibido", "Fecha Entrega", "Empleado", "Estado"};
    public String[] columnas_servicios_ep = {"Cedula", "Placa", "Descripcion del Vehiculo", "Partes a Enderezar", "Poliza", "Numero de Caso", "Costo", "Fecha Recibido", "Fecha Entrega", "Empleado", "Estado"};
    public JTable tabla_servicios_mg;
    public JTable tabla_servicios_ep;
    public JScrollPane scrollpane_mg;
    public JScrollPane scrollpane_ep;

    //Lectura CSVs
    EnderezadoPintura enderezadopintura = new EnderezadoPintura();
    MecanicaGeneral mecanicageneral = new MecanicaGeneral();

    /**
     * Metodo constructor donde se editan los objetos de la ventana
     * @param id cedula para el filtro
     * @param placa placa para el filtro
     * @param tipo_consulta si se filtra por cedula, estado, o placa
     */
    consultaServicioGUI(String id, String placa, String tipo_consulta){
        //Table
        if(tipo_consulta == "ID"){
            servicios_final_mg = mecanicageneral.get_serviciosID(id);

            servicios_final_ep = enderezadopintura.get_serviciosID(id);
        }
        else if(tipo_consulta == "Placa"){
            servicios_final_mg = mecanicageneral.get_serviciosPlaca(placa);

            servicios_final_ep = enderezadopintura.get_serviciosPlaca(placa);
        }
        else{
            servicios_end_pint1 = enderezadopintura.get_serviciosEstado("Espera");
            servicios_end_pint2 = enderezadopintura.get_serviciosEstado("Ejecucion");
            servicios_end_pint3 = enderezadopintura.get_serviciosEstado("Finalizado");
            servicios_final_ep = Stream.of(servicios_end_pint1, servicios_end_pint2, servicios_end_pint3).flatMap(Stream::of).toArray((String[][]::new));

            servicios_mec_gen1 = mecanicageneral.get_serviciosEstado("Espera");
            servicios_mec_gen2 = mecanicageneral.get_serviciosEstado("Ejecucion");
            servicios_mec_gen3 = mecanicageneral.get_serviciosEstado("Finalizado");
            servicios_final_mg = Stream.of(servicios_mec_gen1, servicios_mec_gen2, servicios_mec_gen3).flatMap(Stream::of).toArray(String[][]::new);
        }

        tabla_servicios_mg = new JTable(servicios_final_mg, columnas_servicios_mg);
        scrollpane_mg = new JScrollPane(tabla_servicios_mg);
        scrollpane_mg.setBounds(20,50,1700,150);

        tabla_servicios_ep = new JTable(servicios_final_ep, columnas_servicios_ep);
        scrollpane_ep = new JScrollPane(tabla_servicios_ep);
        scrollpane_ep.setBounds(20,300,1700,150);

        //Labels
        nombre_tabla_mg.setFont(new Font("", Font.PLAIN, 21));
        nombre_tabla_mg.setForeground(Color.blue);
        nombre_tabla_mg.setOpaque(true);
        nombre_tabla_mg.setText("Servicios de Mecanica General");
        nombre_tabla_mg.setBounds(20, 20, 400, 25);

        nombre_tabla_ep.setFont(new Font("", Font.PLAIN, 21));
        nombre_tabla_ep.setForeground(Color.blue);
        nombre_tabla_ep.setOpaque(true);
        nombre_tabla_ep.setText("Servicios de Enderezado y Pintura");
        nombre_tabla_ep.setBounds(20, 270, 400, 25);

        frame.add(scrollpane_mg);
        frame.add(scrollpane_ep);
        frame.add(nombre_tabla_mg);
        frame.add(nombre_tabla_ep);

        frame.setLayout(null);
        frame.setBounds(100, 100, 1800, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
