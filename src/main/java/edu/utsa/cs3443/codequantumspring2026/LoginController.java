package edu.utsa.cs3443.codequantumspring2026;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController {

    Stage stage;

    private UserManager users;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField usernameTextField;


    @FXML
    void onLoginButtonClicked(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        User user = new User("", username, password);
        if (users.isUser(user)) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("layouts/seat-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("F1 Seat Finder!");
                stage.setScene(scene);
                stage.show();
                SeatViewController seatViewController = fxmlLoader.getController();
                seatViewController.setStage(stage);
                seatViewController.setCustomer(user);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        else {
            errorLabel.setText("Username or Password is incorrect.");
        }

    }

    @FXML
    void onSignUpButtonClicked(ActionEvent event) {

    }

    public void initialize() {
        users = new UserManager();
    }

    void setStage(Stage stage){
        this.stage = stage;
    }
}
