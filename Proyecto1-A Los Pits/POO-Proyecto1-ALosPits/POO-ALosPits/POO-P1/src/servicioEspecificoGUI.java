import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class servicioEspecificoGUI {
    //Frame
    private final JFrame frame = new JFrame("Servicios");

    //Labels
    public JLabel datos_servicio = new JLabel();
    public JLabel datos_cliente = new JLabel();
    public JLabel datos_vehiculo = new JLabel();

    //Table
    public String[][] servicio_array;
    public String[][] cliente_array;
    public String[][] vehiculo_array;
    public String[] columnas_servicio;
    public String[] columnas_cliente = {"Cedula", "Nombre", "Tipo de Identificacion", "Provincia", "Canton", "Fecha de Nacimiento", "Correo"};
    public String[] columnas_vehiculo = {"Cedula", "Marca", "Modelo", "Año", "Placa"};
    public JTable tabla_servicio;
    public JTable tabla_cliente;
    public JTable tabla_vehiculo;

    public JScrollPane scrollpane_servicio;
    public JScrollPane scrollpane_cliente;
    public JScrollPane scrollpane_vehiculo;

    Cliente cliente = new Cliente();
    vehiculoCliente vehiculocliente = new vehiculoCliente();

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
        datos_servicio.setOpaque(true);
        datos_servicio.setText("Datos del Servicio");
        datos_servicio.setBounds(20, 20, 400, 25);

        datos_cliente.setFont(new Font("", Font.PLAIN, 21));
        datos_cliente.setForeground(Color.blue);
        datos_cliente.setOpaque(true);
        datos_cliente.setText("Datos del Cliente");
        datos_cliente.setBounds(20, 100, 400, 25);

        datos_vehiculo.setFont(new Font("", Font.PLAIN, 21));
        datos_vehiculo.setForeground(Color.blue);
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

        frame.add(datos_servicio);
        frame.add(datos_cliente);
        frame.add(datos_vehiculo);
        frame.add(scrollpane_servicio);
        frame.add(scrollpane_cliente);
        frame.add(scrollpane_vehiculo);

        frame.setLayout(null);
        frame.setBounds(100, 100, 1800, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
