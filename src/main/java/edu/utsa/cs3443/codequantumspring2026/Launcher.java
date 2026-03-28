package edu.utsa.cs3443.codequantumspring2026;

import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Commiting change from Dominic in the branch");
        System.out.println(System.getProperty("user.dir"));
        Application.launch(HelloApplication.class, args);
    }
}
