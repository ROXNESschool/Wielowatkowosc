package org.example;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            UserModel model = new UserModel();
            View view = new View();
            new Controller(model, view);

            view.setVisible(true);

        });
    }
}
