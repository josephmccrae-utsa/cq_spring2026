package edu.utsa.cs3443.codequantumspring2026;

import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        UserManager users = new UserManager();
        User currUser = users.getUserList().get(0);
        System.out.println(currUser.getName());

        User newUser = new User("chalk", "chalky", "chalkisgreat");
        users.addUser(newUser);
        users.saveUsers();
        User lastUser = users.getUserList().getLast();
        System.out.println(lastUser.getName());

//        Application.launch(HelloApplication.class, args);
    }
}
