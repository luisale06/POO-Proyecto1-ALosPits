import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana donde se escoge el tipo de servicio que se va a consultar y los diferentes filtros
 * @author Luis Barreda, Fabian Miranda, Franco Rojas
 * @see tipoconsultaGUI
 */
public class tipoconsultaGUI {
    //Frame
    private JFrame frame = new JFrame("Tipo de Consulta");
    //Label
    static JLabel titulo_servicios_generales = new JLabel();
    static JLabel titulo_servicios_especificos = new JLabel();

    static JLabel fondo = new JLabel(new ImageIcon("fondo.jpg"));

    //Combobox
    public String[] id_array;
    public String[] placa_array;
    public String[] servicios_mg_array;
    public String[] servicios_ep_array;
    public JComboBox combobox_id;
    public JComboBox combobox_placa;
    public JComboBox combobox_servicios_mg;
    public JComboBox combobox_servicios_ep;

    //Buttons
    public JButton busqueda_id = new JButton();
    public JButton busqueda_placa = new JButton();
    public JButton busqueda_estado = new JButton();
    public JButton busqueda_datos_mg = new JButton();
    public JButton busqueda_datos_ep = new JButton();

    Cliente cliente = new Cliente();
    vehiculoCliente vehiculocliente = new vehiculoCliente();
    EnderezadoPintura enderezado_pintura = new EnderezadoPintura();
    MecanicaGeneral mecanica_general = new MecanicaGeneral();

    /**
     * Metodo constructor donde se editan los objetos de la ventana
     */
    tipoconsultaGUI(){
        //Labels
        titulo_servicios_generales.setFont(new Font("", Font.PLAIN, 21));
        titulo_servicios_generales.setForeground(Color.blue);
        titulo_servicios_generales.setBackground(Color.white);
        titulo_servicios_generales.setOpaque(true);
        titulo_servicios_generales.setText("Consulta de Servicios Generales");
        titulo_servicios_generales.setBounds(20, 20, 350, 25);

        titulo_servicios_especificos.setFont(new Font("", Font.PLAIN, 21));
        titulo_servicios_especificos.setForeground(Color.blue);
        titulo_servicios_especificos.setBackground(Color.white);
        titulo_servicios_especificos.setOpaque(true);
        titulo_servicios_especificos.setText("Consulta de Servicios Especificos");
        titulo_servicios_especificos.setBounds(20, 160, 350, 25);

        //Combobox
        id_array = cliente.getIDs();
        placa_array = vehiculocliente.getPlacas();
        servicios_mg_array = mecanica_general.getServicios();
        servicios_ep_array = enderezado_pintura.getServicios();

        combobox_id = new JComboBox(id_array);
        combobox_placa = new JComboBox(placa_array);
        combobox_servicios_mg = new JComboBox(servicios_mg_array);
        combobox_servicios_ep = new JComboBox(servicios_ep_array);

        combobox_id.setBounds(20, 50, 130, 20);
        combobox_id.setBackground(Color.white);
        combobox_placa.setBounds(20, 80, 130, 20);
        combobox_placa.setBackground(Color.white);
        combobox_servicios_mg.setBounds(20, 200, 760, 20);
        combobox_servicios_mg.setBackground(Color.white);
        combobox_servicios_ep.setBounds(20, 300, 760, 20);
        combobox_servicios_ep.setBackground(Color.white);

        //Buttons
        busqueda_id.setFont(new Font("", Font.BOLD, 12));
        busqueda_id.setText("Filtro por Cedula");
        busqueda_id.setBackground(Color.white);
        busqueda_id.setBounds(155, 50, 150, 20);

        busqueda_placa.setFont(new Font("", Font.BOLD, 12));
        busqueda_placa.setText("Filtro por Placa");
        busqueda_placa.setBackground(Color.white);
        busqueda_placa.setBounds(155, 80, 150, 20);

        busqueda_estado.setFont(new Font("", Font.BOLD, 12));
        busqueda_estado.setText("Busqueda por Estado");
        busqueda_estado.setBackground(Color.white);
        busqueda_estado.setBounds(20, 110, 170, 20);

        busqueda_datos_mg.setFont(new Font("", Font.BOLD, 12));
        busqueda_datos_mg.setText("Busqueda de Servicio");
        busqueda_datos_mg.setBackground(Color.white);
        busqueda_datos_mg.setBounds(20, 230, 170, 20);

        busqueda_datos_ep.setFont(new Font("", Font.BOLD, 12));
        busqueda_datos_ep.setText("Busqueda de Servicio");
        busqueda_datos_ep.setBackground(Color.white);
        busqueda_datos_ep.setBounds(20, 330, 170, 20);

        //Frame
        frame.setLayout(null);
        frame.setBounds(100, 100, 800, 400);

        fondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        frame.add(titulo_servicios_generales);
        frame.add(titulo_servicios_especificos);
        frame.add(combobox_id);
        frame.add(combobox_placa);
        frame.add(combobox_servicios_mg);
        frame.add(combobox_servicios_ep);
        frame.add(busqueda_id);
        frame.add(busqueda_placa);
        frame.add(busqueda_estado);
        frame.add(busqueda_datos_mg);
        frame.add(busqueda_datos_ep);
        frame.add(fondo);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        /**
         * Acciones asociadas a los botones que filtran por cédula, placa, estado o despliegan servicios específicos
         */
        busqueda_id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = String.valueOf(combobox_id.getSelectedItem());
                String placa = String.valueOf(combobox_placa.getSelectedItem());

                consultaServicioGUI ventana = new consultaServicioGUI(id, placa, "ID");
            }
        });

        busqueda_placa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = String.valueOf(combobox_id.getSelectedItem());
                String placa = String.valueOf(combobox_placa.getSelectedItem());

                consultaServicioGUI ventana = new consultaServicioGUI(id, placa, "Placa");
            }
        });

        busqueda_estado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = String.valueOf(combobox_id.getSelectedItem());
                String placa = String.valueOf(combobox_placa.getSelectedItem());

                consultaServicioGUI ventana = new consultaServicioGUI(id, placa, "Estado");
            }
        });

        busqueda_datos_mg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id, placa;

                String[] fila = String.valueOf(combobox_servicios_mg.getSelectedItem()).split(",");
                id = fila[0];
                placa = fila[1];

                servicioEspecificoGUI ventana_servicio = new servicioEspecificoGUI(id, placa, fila, "MG");


            }
        });

        busqueda_datos_ep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id, placa;

                String[] fila = String.valueOf(combobox_servicios_ep.getSelectedItem()).split(",");
                id = fila[0];
                placa = fila[1];

                servicioEspecificoGUI ventana_servicio = new servicioEspecificoGUI(id, placa, fila, "EP");
            }
        });
    }
}
