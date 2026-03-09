package org.example;

import javax.swing.*;

public class Freeze extends JFrame {

    private final JLabel statusLabel;

    public Freeze() {
        setTitle("Freeze Example");
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton startButton = new JButton("Start");
        startButton.setBounds(100,20,100,30);

        statusLabel = new JLabel("Ready");
        statusLabel.setBounds(100,70,200,30);

        add(startButton);
        add(statusLabel);

        startButton.addActionListener(_ -> {

            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    statusLabel.setText("Pracuję... " + (i + 1) + "s");
                }

                statusLabel.setText("Zakończono blokadę.");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Freeze().setVisible(true);
        });
    }
}
