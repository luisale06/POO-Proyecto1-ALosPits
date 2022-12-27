import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class enderezado_pinturaGUI {
    private final JFrame frame = new JFrame("Mecanica General");

    //Label
    static JLabel registro_enderezado_pintura = new JLabel();
    static JLabel indicador_ID = new JLabel();
    static JLabel indicador_placa = new JLabel();
    static JLabel indicador_descripcion_vehiculo = new JLabel();
    static JLabel indicador_partes_enderezar = new JLabel();
    static JLabel indicador_costo = new JLabel();
    static JLabel indicador_fecha_recibido = new JLabel();
    static JLabel indicador_fecha_entrega = new JLabel();
    static JLabel indicador_empleado = new JLabel();
    static JLabel indicador_estado = new JLabel();
    static JLabel indicador_poliza = new JLabel();
    static JLabel indicador_caso = new JLabel();

    //Button
    public JButton aceptar_registro_servicio = new JButton();

    //Textfield
    public JTextField entrada_ID = new JTextField();
    public JTextField entrada_descripcion_vehiculo = new JTextField();
    public JTextField entrada_partes_enderezar = new JTextField();
    public JTextField entrada_costo = new JTextField();
    public JTextField entrada_fecha_recibido = new JTextField();
    public JTextField entrada_fecha_entrega = new JTextField();
    public JTextField entrada_empleado = new JTextField();
    public JTextField entrada_caso = new JTextField();

    //Combobox
    public String[] placas_array;
    public String[] estado_array = {"Espera", "Ejecucion", "Finalizado"};
    public String[] poliza_array = {"Si", "No"};
    public JComboBox combobox_estado = new JComboBox(estado_array);
    public JComboBox combobox_poliza = new JComboBox(poliza_array);

    public JComboBox combobox_placa;

    EnderezadoPintura servicio = new EnderezadoPintura();
    vehiculoCliente vehiculo_cliente = new vehiculoCliente();

    enderezado_pinturaGUI(String identificacion){
        //Labels
        registro_enderezado_pintura.setFont(new Font("", Font.PLAIN, 21));
        registro_enderezado_pintura.setForeground(Color.blue);
        registro_enderezado_pintura.setOpaque(true);
        registro_enderezado_pintura.setText("Enderezado/Pintura");
        registro_enderezado_pintura.setBounds(140, 20, 200, 25);

        indicador_ID.setFont(new Font("", Font.BOLD, 12));
        indicador_ID.setForeground(Color.blue);
        indicador_ID.setOpaque(true);
        indicador_ID.setText("Identificacion");
        indicador_ID.setBounds(90, 130, 185, 20);

        indicador_placa.setFont(new Font("", Font.BOLD, 12));
        indicador_placa.setForeground(Color.blue);
        indicador_placa.setOpaque(true);
        indicador_placa.setText("Placa");
        indicador_placa.setBounds(320, 130, 185, 20);

        indicador_descripcion_vehiculo.setFont(new Font("", Font.BOLD, 12));
        indicador_descripcion_vehiculo.setForeground(Color.blue);
        indicador_descripcion_vehiculo.setOpaque(true);
        indicador_descripcion_vehiculo.setText("Descripcion Vehiculo");
        indicador_descripcion_vehiculo.setBounds(80, 200, 185, 20);

        indicador_partes_enderezar.setFont(new Font("", Font.BOLD, 12));
        indicador_partes_enderezar.setForeground(Color.blue);
        indicador_partes_enderezar.setOpaque(true);
        indicador_partes_enderezar.setText("Partes a Enderezar");
        indicador_partes_enderezar.setBounds(290, 200, 185, 20);

        indicador_costo.setFont(new Font("", Font.BOLD, 12));
        indicador_costo.setForeground(Color.blue);
        indicador_costo.setOpaque(true);
        indicador_costo.setText("Costo");
        indicador_costo.setBounds(110, 270, 175, 20);

        indicador_fecha_recibido.setFont(new Font("", Font.BOLD, 12));
        indicador_fecha_recibido.setForeground(Color.blue);
        indicador_fecha_recibido.setOpaque(true);
        indicador_fecha_recibido.setText("Fecha Recibido");
        indicador_fecha_recibido.setBounds(300, 270, 185, 20);

        indicador_fecha_entrega.setFont(new Font("", Font.BOLD, 12));
        indicador_fecha_entrega.setForeground(Color.blue);
        indicador_fecha_entrega.setOpaque(true);
        indicador_fecha_entrega.setText("Fecha Entrega");
        indicador_fecha_entrega.setBounds(90, 340, 185, 20);

        indicador_empleado.setFont(new Font("", Font.BOLD, 12));
        indicador_empleado.setForeground(Color.blue);
        indicador_empleado.setOpaque(true);
        indicador_empleado.setText("Empleado");
        indicador_empleado.setBounds(310, 340, 185, 20);

        indicador_estado.setFont(new Font("", Font.BOLD, 12));
        indicador_estado.setForeground(Color.blue);
        indicador_estado.setOpaque(true);
        indicador_estado.setText("Estado");
        indicador_estado.setBounds(110, 410, 185, 20);

        indicador_poliza.setFont(new Font("", Font.BOLD, 12));
        indicador_poliza.setForeground(Color.blue);
        indicador_poliza.setOpaque(true);
        indicador_poliza.setText("Poliza");
        indicador_poliza.setBounds(320, 410, 185, 20);

        indicador_caso.setFont(new Font("", Font.BOLD, 12));
        indicador_caso.setForeground(Color.blue);
        indicador_caso.setOpaque(true);
        indicador_caso.setText("Caso");
        indicador_caso.setBounds(220, 480, 185, 20);

        //TextFields/Combobox
        entrada_ID.setText(identificacion);
        entrada_ID.setEditable(false);
        entrada_ID.setFont(new Font("", Font.BOLD, 12));
        entrada_ID.setBounds(40, 110, 185, 20);
        entrada_descripcion_vehiculo.setFont(new Font("", Font.BOLD, 12));
        entrada_descripcion_vehiculo.setBounds(40, 180, 185, 20);
        entrada_partes_enderezar.setFont(new Font("", Font.BOLD, 12));
        entrada_partes_enderezar.setBounds(250, 180, 185, 20);
        entrada_costo.setFont(new Font("", Font.BOLD, 12));
        entrada_costo.setBounds(40, 250, 185, 20);
        entrada_fecha_recibido.setFont(new Font("", Font.BOLD, 12));
        entrada_fecha_recibido.setBounds(250, 250, 185, 20);
        entrada_fecha_entrega.setFont(new Font("", Font.BOLD, 12));
        entrada_fecha_entrega.setBounds(40, 320, 185, 20);
        entrada_empleado.setFont(new Font("", Font.BOLD, 12));
        entrada_empleado.setBounds(250, 320, 185, 20);
        entrada_caso.setText(String.valueOf(servicio.getCasos()));
        entrada_caso.setEditable(false);
        entrada_caso.setFont(new Font("", Font.BOLD, 12));
        entrada_caso.setBounds(150, 460, 185, 20);

        placas_array = vehiculo_cliente.getIDPlacas(identificacion);
        combobox_placa = new JComboBox(placas_array);
        combobox_placa.setBounds(250, 110, 185, 20);
        combobox_estado.setBounds(40, 390, 185, 20);
        combobox_poliza.setBounds(250, 390,185,20);

        //Buttons
        aceptar_registro_servicio.setFont(new Font("", Font.BOLD, 12));
        aceptar_registro_servicio.setText("Registrar");
        aceptar_registro_servicio.setBounds(185, 520, 90, 20);

        frame.add(registro_enderezado_pintura);
        frame.add(indicador_ID);
        frame.add(indicador_placa);
        frame.add(indicador_descripcion_vehiculo);
        frame.add(indicador_partes_enderezar);
        frame.add(indicador_costo);
        frame.add(indicador_fecha_recibido);
        frame.add(indicador_fecha_entrega);
        frame.add(indicador_empleado);
        frame.add(indicador_estado);
        frame.add(indicador_poliza);
        frame.add(indicador_caso);
        frame.add(entrada_ID);
        frame.add(combobox_placa);
        frame.add(entrada_descripcion_vehiculo);
        frame.add(entrada_partes_enderezar);
        frame.add(entrada_costo);
        frame.add(entrada_fecha_recibido);
        frame.add(entrada_fecha_entrega);
        frame.add(entrada_empleado);
        frame.add(entrada_caso);
        frame.add(combobox_estado);
        frame.add(combobox_poliza);
        frame.add(aceptar_registro_servicio);

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        aceptar_registro_servicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_registro, placa_registro, descripcion_vehiculo_registro, partes_enderezar_registro, costo_registro,
                        fecha_recibido_registro, fecha_entrega_registro, empleado_registro, estado_registro, poliza_registro, caso_registro;
                id_registro = entrada_ID.getText();
                placa_registro = String.valueOf(combobox_placa.getSelectedItem());
                descripcion_vehiculo_registro = entrada_descripcion_vehiculo.getText();
                partes_enderezar_registro = entrada_partes_enderezar.getText();
                costo_registro = entrada_costo.getText();
                fecha_recibido_registro = entrada_fecha_recibido.getText();
                fecha_entrega_registro = entrada_fecha_entrega.getText();
                empleado_registro = entrada_empleado.getText();
                estado_registro = String.valueOf(combobox_estado.getSelectedItem());
                poliza_registro = String.valueOf(combobox_poliza.getSelectedItem());
                caso_registro = entrada_caso.getText();

                try {
                    servicio.add(id_registro, placa_registro, descripcion_vehiculo_registro, partes_enderezar_registro, poliza_registro, caso_registro,
                            costo_registro, fecha_recibido_registro, fecha_entrega_registro, empleado_registro, estado_registro);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
