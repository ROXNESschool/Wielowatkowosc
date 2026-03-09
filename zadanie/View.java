package org.example;

import javax.swing.*;

public class View extends JFrame {

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JLabel statusLabel;

    public View() {

        setTitle("System Logowania");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Login:");
        userLabel.setBounds(30,20,80,25);

        usernameField = new JTextField();
        usernameField.setBounds(120,20,120,25);

        JLabel passLabel = new JLabel("Hasło:");
        passLabel.setBounds(30,60,80,25);

        passwordField = new JPasswordField();
        passwordField.setBounds(120,60,120,25);

        loginButton = new JButton("Zaloguj");
        loginButton.setBounds(90,100,100,30);

        statusLabel = new JLabel(" ");
        statusLabel.setBounds(60,140,200,25);

        add(userLabel);
        add(usernameField);
        add(passLabel);
        add(passwordField);
        add(loginButton);
        add(statusLabel);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setStatus(String text) {
        statusLabel.setText(text);
    }

    public void setLoginEnabled(boolean value) {
        loginButton.setEnabled(value);
    }
}
