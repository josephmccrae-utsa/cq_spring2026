package edu.utsa.cs3443.codequantumspring2026;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class LoginController {

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
            // move screen
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

}
