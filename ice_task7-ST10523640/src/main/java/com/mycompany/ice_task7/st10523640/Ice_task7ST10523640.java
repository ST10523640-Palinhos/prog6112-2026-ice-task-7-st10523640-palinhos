
package com.mycompany.ice_task7.st10523640;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Ice_task7ST10523640 extends JFrame {

    private final JTextField firstField = new JTextField();
    private final JTextField secondField = new JTextField();
    private final JLabel resultLabel = new JLabel("Result: ", SwingConstants.LEFT);

    public Ice_task7ST10523640() {
        // 1. Frame setup
        setTitle("Sum Calculator");
        setSize(360, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   // centre on screen
        setResizable(false);           // fixed layout, so keep size fixed
        setLayout(null);               // manual positioning

        // 2. Labels and text fields
        JLabel firstLabel = new JLabel("First number:");
        firstLabel.setBounds(30, 30, 100, 25);
        add(firstLabel);

        firstField.setBounds(140, 30, 170, 25);
        add(firstField);

        JLabel secondLabel = new JLabel("Second number:");
        secondLabel.setBounds(30, 70, 100, 25);
        add(secondLabel);

        secondField.setBounds(140, 70, 170, 25);
        add(secondField);

        // 3. Button and result label
        JButton addButton = new JButton("Add");
        addButton.setBounds(140, 115, 100, 30);
        add(addButton);

        resultLabel.setBounds(30, 165, 300, 30);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(resultLabel);

        // 4. ActionListener
        addButton.addActionListener(e -> calculateSum());
        getRootPane().setDefaultButton(addButton); // Enter key also triggers Add
    }

    private void calculateSum() {
        try {
            double a = Double.parseDouble(firstField.getText().trim());
            double b = Double.parseDouble(secondField.getText().trim());
            double sum = a + b;

            resultLabel.setForeground(Color.BLACK);
            resultLabel.setText(format(a) + " + " + format(b) + " = " + format(sum));
        } catch (NumberFormatException ex) {
            // 5. Graceful error handling
            resultLabel.setForeground(Color.RED);
            resultLabel.setText("Error: please enter valid numbers");
        }
    }

    // Show 20 instead of 20.0 when the value is a whole number
    private String format(double value) {
        if (value == Math.rint(value) && !Double.isInfinite(value)) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ice_task7ST10523640().setVisible(true));
    }
}