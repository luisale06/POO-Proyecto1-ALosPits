import javax.swing.*;
import java.awt.*;

public class tipoconsultaGUI {
    //Frame
    private JFrame frame = new JFrame("Tipo de Consulta");
    //Label
    static JLabel titulo = new JLabel();

    //Combobox
    public String[] id_array;
    public String[] placa_array;
    public JComboBox combobox_id;
    public JComboBox combobox_placa;

    //Buttons
    public JButton busqueda_id = new JButton();
    public JButton busqueda_placa = new JButton();
    public JButton busqueda_estado = new JButton();

    Cliente cliente = new Cliente();
    vehiculoCliente vehiculocliente = new vehiculoCliente();

    tipoconsultaGUI(){
        //Labels
        titulo.setFont(new Font("", Font.PLAIN, 21));
        titulo.setForeground(Color.blue);
        titulo.setOpaque(true);
        titulo.setText("Consulta de Servicios");
        titulo.setBounds(140, 20, 250, 25);

        //Combobox
        id_array = cliente.getIDs();
        placa_array = vehiculocliente.getPlacas();
        combobox_id = new JComboBox(id_array);
        combobox_placa = new JComboBox(placa_array);

        combobox_id.setBounds(140, 50, 130, 20);
        combobox_placa.setBounds(140, 80, 130, 20);

        //Buttons
        busqueda_id.setFont(new Font("", Font.BOLD, 12));
        busqueda_id.setText("Filtro por Cedula");
        busqueda_id.setBounds(275, 50, 150, 20);
        busqueda_placa.setFont(new Font("", Font.BOLD, 12));
        busqueda_placa.setText("Filtro por Placa");
        busqueda_placa.setBounds(275, 80, 150, 20);
        busqueda_estado.setFont(new Font("", Font.BOLD, 12));
        busqueda_estado.setText("Busqueda por Estado");
        busqueda_estado.setBounds(140, 110, 170, 20);

        //Frame
        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(titulo);
        frame.add(combobox_id);
        frame.add(combobox_placa);
        frame.add(busqueda_id);
        frame.add(busqueda_placa);
        frame.add(busqueda_estado);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
