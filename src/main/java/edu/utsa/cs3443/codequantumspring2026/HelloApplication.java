package edu.utsa.cs3443.codequantumspring2026;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("layouts/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("F1 Seat Finder Login!");
        stage.setScene(scene);
        LoginController loginController = fxmlLoader.getController();
        loginController.setStage(stage);
        stage.show();
    }
}
