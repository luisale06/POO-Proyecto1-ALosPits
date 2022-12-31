import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Ventana donde se introduce el estado de los servicios ofrecidos para su modificacion
 * @authors Luis Barreda, Fabian Miranda, Franco Rojas
 * @see actualizarEstadoGUI
 */
public class actualizarEstadoGUI {
    //Frame
    private final JFrame frame = new JFrame("Actualizar Servicios");

    //Label
    static JLabel titulo_servicios_mg = new JLabel();
    static JLabel titulo_servicios_ep = new JLabel();

    //Combobox
    public String[] servicios_mg_array;
    public String[] servicios_ep_array;
    public String[] estados_array = {"Espera", "Ejecucion", "Finalizado"};
    public JComboBox combobox_servicios_mg;
    public JComboBox combobox_servicios_ep;
    public JComboBox combobox_estados = new JComboBox(estados_array);

    //Buttons
    public JButton actualizar_estado_mg = new JButton();
    public JButton actualizar_estado_ep = new JButton();

    //Servicios
    EnderezadoPintura enderezado_pintura = new EnderezadoPintura();
    MecanicaGeneral mecanica_general = new MecanicaGeneral();

    /**
     * Metodo constructor donde se editan los objetos de la ventana
     */

    actualizarEstadoGUI(){

        //Labels
        titulo_servicios_mg.setFont(new Font("", Font.PLAIN, 21));
        titulo_servicios_mg.setForeground(Color.blue);
        titulo_servicios_mg.setOpaque(true);
        titulo_servicios_mg.setText("Servicios Mecanica General");
        titulo_servicios_mg.setBounds(20, 20, 350, 25);

        titulo_servicios_ep.setFont(new Font("", Font.PLAIN, 21));
        titulo_servicios_ep.setForeground(Color.blue);
        titulo_servicios_ep.setOpaque(true);
        titulo_servicios_ep.setText("Servicios Enderezado / Pintura");
        titulo_servicios_ep.setBounds(20, 130, 350, 25);

        //Combobox
        servicios_mg_array = mecanica_general.getServicios();
        servicios_ep_array = enderezado_pintura.getServicios();

        combobox_servicios_mg = new JComboBox(servicios_mg_array);
        combobox_servicios_ep = new JComboBox(servicios_ep_array);

        combobox_servicios_mg.setBounds(20, 60, 760, 20);
        combobox_servicios_ep.setBounds(20, 160, 760, 20);
        combobox_estados.setBounds(700, 0,85,20);

        actualizar_estado_mg.setFont(new Font("", Font.BOLD, 12));
        actualizar_estado_mg.setText("Actualizar Estado");
        actualizar_estado_mg.setBounds(20, 90, 170, 20);
        actualizar_estado_ep.setFont(new Font("", Font.BOLD, 12));
        actualizar_estado_ep.setText("Actualizar Estado");
        actualizar_estado_ep.setBounds(20, 190, 170, 20);

        frame.add(titulo_servicios_mg);
        frame.add(titulo_servicios_ep);
        frame.add(combobox_servicios_mg);
        frame.add(combobox_servicios_ep);
        frame.add(combobox_estados);
        frame.add(actualizar_estado_mg);
        frame.add(actualizar_estado_ep);

        frame.setLayout(null);
        frame.setBounds(100, 100, 800, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        /**
         * Acciones asociadas a los botones para editar los estados de los servicios
         */

        actualizar_estado_mg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicion = combobox_servicios_mg.getSelectedIndex();
                posicion++;

                String servicio_a_cambiar = String.valueOf(combobox_servicios_mg.getSelectedItem());
                String estado = String.valueOf(combobox_estados.getSelectedItem());
                try {
                    mecanica_general.deleteEstado(posicion);
                    mecanica_general.setEstado(servicio_a_cambiar, estado);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        actualizar_estado_ep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicion = combobox_servicios_ep.getSelectedIndex();
                posicion++;

                String servicio_a_cambiar = String.valueOf(combobox_servicios_ep.getSelectedItem());
                String estado = String.valueOf(combobox_estados.getSelectedItem());
                try {
                    enderezado_pintura.deleteEstado(posicion);
                    enderezado_pintura.setEstado(servicio_a_cambiar, estado);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
