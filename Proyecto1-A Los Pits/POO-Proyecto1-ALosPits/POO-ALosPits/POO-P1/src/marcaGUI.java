import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

public class marcaGUI {
    //Frame
    private JFrame frame = new JFrame("Registro de Marcas");

    //Labels
    static JLabel registro_marca = new JLabel();
    static JLabel indicador_marca = new JLabel();
    static JLabel indicador_tipo_marca = new JLabel();

    //Buttons
    public JButton aceptar_registro_marca = new JButton();
    public JButton eliminar_registro_marca = new JButton();

    //ComboBox
    public String[] tipos_marca_array = {"4x4", "Pickup", "SUV", "Sedan"};
    public String[] marcas_array = {"Abarth","Alfa Romeo","Aston Martin","Audi","Bentley","BMW","Cadillac","Caterham","Chevrolet","Citroen",
            "Dacia","Ferrari","Fiat","Ford","Honda","Infiniti","Isuzu","Iveco","Jaguar","Jeep","Kia","KTM","Lada","Lamborghini","Lancia",
            "Land Rove","Lexus","Lotus","Maserati","Mazda","Mercedes Benz","Mini","Mitsubishi","Morgan","Nissan","Opel","Peugeot","Piaggio",
            "Porsche","Renault","Rolls Royce","Seat","Skoda","Smart","SsangYong","Subaru","Suzuki","Tata","Tesla","Toyota","Volkswagen","Volvo"};
    public JComboBox combobox_tipos_marca = new JComboBox(tipos_marca_array);
    public JComboBox combobox_marcas = new JComboBox(marcas_array);


    //Control CSVs
    Marca marca = new Marca();

    marcaGUI() {

        //Labels
        registro_marca.setFont(new Font("", Font.PLAIN, 21));
        registro_marca.setForeground(Color.blue);
        registro_marca.setOpaque(true);
        registro_marca.setText("Registro de Marcas");
        registro_marca.setBounds(140, 20, 190, 25);

        indicador_marca.setFont(new Font("", Font.PLAIN, 12));
        indicador_marca.setForeground(Color.blue);
        indicador_marca.setOpaque(true);
        indicador_marca.setText("Marca");
        indicador_marca.setBounds(275, 50, 40, 20);

        indicador_tipo_marca.setFont(new Font("", Font.PLAIN, 12));
        indicador_tipo_marca.setForeground(Color.blue);
        indicador_tipo_marca.setOpaque(true);
        indicador_tipo_marca.setText("Tipo");
        indicador_tipo_marca.setBounds(275, 80, 40, 20);

        //Combobox
        combobox_marcas.setBounds(140, 50, 130, 20);
        combobox_tipos_marca.setBounds(140, 80, 130, 20);

        //Buttons
        aceptar_registro_marca.setFont(new Font("", Font.BOLD, 12));
        aceptar_registro_marca.setText("Registrar");
        aceptar_registro_marca.setBounds(140, 110, 90, 20);
        eliminar_registro_marca.setFont(new Font("", Font.BOLD, 12));
        eliminar_registro_marca.setText("Eliminar");
        eliminar_registro_marca.setBounds(230, 110, 90, 20);

        frame.setLayout(null);
        frame.setBounds(500, 200, 500, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.add(registro_marca);
        frame.add(combobox_marcas);
        frame.add(combobox_tipos_marca);
        frame.add(aceptar_registro_marca);
        frame.add(eliminar_registro_marca);
        frame.add(indicador_marca);
        frame.add(indicador_tipo_marca);
        frame.setResizable(false);
        frame.setVisible(true);

        //Button actions
        aceptar_registro_marca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    marca.add(String.valueOf(combobox_marcas.getSelectedItem()), String.valueOf(combobox_tipos_marca.getSelectedItem()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        eliminar_registro_marca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    marca.delete(String.valueOf(combobox_marcas.getSelectedItem()), String.valueOf(combobox_tipos_marca.getSelectedItem()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
