package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private final UserModel model;
    private final View view;

    public Controller(UserModel model, View view) {
        this.model = model;
        this.view = view;

        view.getLoginButton().addActionListener(new LoginAction());
    }

    class LoginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String user = view.getUsername();
            String pass = view.getPassword();

            view.setLoginEnabled(false);
            view.setStatus("Trwa weryfikacja danych...");

            new SwingWorker<Boolean, Void>() {

                @Override
                protected Boolean doInBackground() {
                    return model.validateLogin(user, pass);
                }

                @Override
                protected void done() {

                    try {
                        boolean success = get();

                        if (success) {
                            view.setStatus("Logowanie pomyślne!");
                        } else {
                            view.setStatus("Błędny login lub hasło!");
                        }

                    } catch (Exception ex) {
                        view.setStatus("Błąd: " + ex.getMessage());
                    }

                    view.setLoginEnabled(true);
                }

            }.execute();
        }
    }
}
