import javax.swing.*;
import java.awt.*;

/**
 * Ventana donde se visualizan los datos del cliente del vehículo de un servicio en específico
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see servicioEspecificoGUI
 */
public class servicioEspecificoGUI {
    //Frame
    private final JFrame frame = new JFrame("Servicios");

    //Labels
    static JLabel fondo = new JLabel(new ImageIcon("fondo.jpg"));
    public JLabel datos_servicio = new JLabel();
    public JLabel datos_cliente = new JLabel();
    public JLabel datos_vehiculo = new JLabel();

    //Table
    public String[][] servicio_array;
    public String[][] cliente_array;
    public String[][] vehiculo_array;
    public String[] columnas_servicio;
    public String[] columnas_cliente = {"Cedula", "Nombre", "Tipo de Identificacion", "Provincia", "Canton", "Fecha de Nacimiento", "Teléfono", "Correo"};
    public String[] columnas_vehiculo = {"Cedula", "Marca", "Modelo", "Año", "Placa"};
    public JTable tabla_servicio;
    public JTable tabla_cliente;
    public JTable tabla_vehiculo;

    public JScrollPane scrollpane_servicio;
    public JScrollPane scrollpane_cliente;
    public JScrollPane scrollpane_vehiculo;

    Cliente cliente = new Cliente();
    vehiculoCliente vehiculocliente = new vehiculoCliente();

    /**
     * Metodo constructor donde se editan los objetos de la ventana
     * @param id cédula del cliente
     * @param placa placa del vehículo
     * @param servicio servicio consultado
     * @param tipo tipo de servicio consultado
     */
    servicioEspecificoGUI(String id, String placa, String[] servicio, String tipo){
        if(tipo == "MG"){
            columnas_servicio = new String[] {"Cedula", "Placa", "Descripcion del Vehiculo", "Descripcion del Problema", "Costo", "Fecha Recibido", "Fecha Entrega", "Empleado", "Estado"};
        }
        else if(tipo == "EP"){
            columnas_servicio = new String[] {"Cedula", "Placa", "Descripcion del Vehiculo", "Partes a Enderezar", "Poliza", "Numero de Caso", "Costo", "Fecha Recibido", "Fecha Entrega", "Empleado", "Estado"};
        }

        //Labels
        datos_servicio.setFont(new Font("", Font.PLAIN, 21));
        datos_servicio.setForeground(Color.blue);
        datos_servicio.setBackground(Color.white);
        datos_servicio.setOpaque(true);
        datos_servicio.setText("Datos del Servicio");
        datos_servicio.setBounds(20, 20, 400, 25);

        datos_cliente.setFont(new Font("", Font.PLAIN, 21));
        datos_cliente.setForeground(Color.blue);
        datos_cliente.setBackground(Color.white);
        datos_cliente.setOpaque(true);
        datos_cliente.setText("Datos del Cliente");
        datos_cliente.setBounds(20, 100, 400, 25);

        datos_vehiculo.setFont(new Font("", Font.PLAIN, 21));
        datos_vehiculo.setForeground(Color.blue);
        datos_vehiculo.setBackground(Color.white);
        datos_vehiculo.setOpaque(true);
        datos_vehiculo.setText("Datos del Vehiculo");
        datos_vehiculo.setBounds(20, 180, 400, 25);

        //Table
        servicio_array = new String[][]{servicio};
        cliente_array = cliente.getCliente(id);
        vehiculo_array = vehiculocliente.getVehiculo(placa);

        tabla_servicio = new JTable(servicio_array, columnas_servicio);
        scrollpane_servicio = new JScrollPane(tabla_servicio);
        scrollpane_servicio.setBounds(20, 50, 1700, 40);

        tabla_cliente = new JTable(cliente_array, columnas_cliente);
        scrollpane_cliente = new JScrollPane(tabla_cliente);
        scrollpane_cliente.setBounds(20, 130, 1700, 40);

        tabla_vehiculo = new JTable(vehiculo_array, columnas_vehiculo);
        scrollpane_vehiculo = new JScrollPane(tabla_vehiculo);
        scrollpane_vehiculo.setBounds(20, 210, 1700, 40);

        frame.setLayout(null);
        frame.setBounds(100, 100, 1800, 300);

        fondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        frame.add(datos_servicio);
        frame.add(datos_cliente);
        frame.add(datos_vehiculo);
        frame.add(scrollpane_servicio);
        frame.add(scrollpane_cliente);
        frame.add(scrollpane_vehiculo);
        frame.add(fondo);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }
}
