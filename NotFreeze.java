package org.example;

import javax.swing.*;
import java.util.List;

public class NotFreeze extends JFrame {

    private final JLabel statusLabel;

    public NotFreeze() {
        setTitle("Not Freeze");
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton startButton = new JButton("Start");
        startButton.setBounds(100,20,100,30);

        statusLabel = new JLabel("Ready");
        statusLabel.setBounds(80,70,200,30);

        add(startButton);
        add(statusLabel);

        startButton.addActionListener(_ -> startTask());
    }

    private void startTask() {

        new SwingWorker<Void, String>() {

            @Override
            protected Void doInBackground() throws Exception {

                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    publish("Pracuję... " + (i + 1) + "s");
                }

                return null;
            }

            @Override
            protected void process(List<String> chunks) {

                String latest = chunks.getLast();
                statusLabel.setText(latest);
            }

            @Override
            protected void done() {
                statusLabel.setText("Zakończono pomyślnie!");
            }

        }.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NotFreeze().setVisible(true));
    }
}
