package edu.utsa.cs3443.codequantumspring2026;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SeatViewController {

    Stage stage;

    @FXML
    private RadioButton RadioButton00;

    @FXML
    private RadioButton RadioButton01;

    @FXML
    private RadioButton RadioButton02;

    @FXML
    private RadioButton RadioButton03;

    @FXML
    private RadioButton RadioButton04;

    @FXML
    private RadioButton RadioButton10;

    @FXML
    private RadioButton RadioButton11;

    @FXML
    private RadioButton RadioButton12;

    @FXML
    private RadioButton RadioButton13;

    @FXML
    private RadioButton RadioButton14;

    @FXML
    private RadioButton RadioButton20;

    @FXML
    private RadioButton RadioButton21;

    @FXML
    private RadioButton RadioButton22;

    @FXML
    private RadioButton RadioButton23;

    @FXML
    private RadioButton RadioButton24;

    @FXML
    private RadioButton RadioButton30;

    @FXML
    private RadioButton RadioButton31;

    @FXML
    private RadioButton RadioButton32;

    @FXML
    private RadioButton RadioButton33;

    @FXML
    private RadioButton RadioButton34;

    @FXML
    private RadioButton RadioButton40;

    @FXML
    private RadioButton RadioButton41;

    @FXML
    private RadioButton RadioButton42;

    @FXML
    private RadioButton RadioButton43;

    @FXML
    private RadioButton RadioButton44;

    @FXML
    private RadioButton RadioButton50;

    @FXML
    private RadioButton RadioButton51;

    @FXML
    private RadioButton RadioButton52;

    @FXML
    private RadioButton RadioButton53;

    @FXML
    private RadioButton RadioButton54;

    @FXML
    private GridPane areaC;

    @FXML
    private TextField ticketPriceTextField;

    @FXML
    void onLogoutButtonClicked(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("layouts/login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Aid Ship Application");
            stage.setScene(scene);
            stage.show();
            LoginController loginController = fxmlLoader.getController();
            loginController.setStage(stage);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void purchaseButtonClicked(ActionEvent event) {

    }

    void setStage(Stage stage){
        this.stage = stage;
    }
}
