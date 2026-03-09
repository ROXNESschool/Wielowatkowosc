package org.example;

public class UserModel {

    public boolean validateLogin(String user, String pass) {

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return user.equals("admin") && pass.equals("haslo123");
    }
}
