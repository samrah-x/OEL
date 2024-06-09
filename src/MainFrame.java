import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Times New Roman", Font.BOLD, 18);
    JTextField tfcelsius, tffahrenheit;
    JLabel lbConverter;
    double tempFahr;

    public void initialize() {

        // Form Panel
        JLabel lbCelsius = new JLabel("Celsius");
        lbCelsius.setFont(mainFont);

        tfcelsius = new JTextField();
        tfcelsius.setFont(mainFont);

        JLabel lbFahrenheit = new JLabel("Fahrenheit: ");
        lbFahrenheit.setFont(mainFont);

        tffahrenheit = new JTextField();
        tffahrenheit.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2, 5, 5));
        formPanel.add(lbCelsius);
        formPanel.add(tfcelsius);
        formPanel.add(lbFahrenheit);
        formPanel.add(tffahrenheit);

        // Welcome Panel
        lbConverter = new JLabel();
        lbConverter.setFont(mainFont);

        // Button Panel
        JButton btnConvert = new JButton("CONVERT");
        btnConvert.setFont(mainFont);
        btnConvert.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                double inputC = Double.parseDouble(tfcelsius.getText());
                tempFahr = (inputC * 1.8 + 32);
                tffahrenheit.setText(tempFahr + " ");
            }

        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 1, 5, 5));
        buttonsPanel.add(btnConvert);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(93, 135, 135));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbConverter, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH) ;

        add(mainPanel);

        setTitle("Welcome to Library Managemenet System!");
        setSize(500, 175);
        setMinimumSize(new Dimension(425, 100));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}
