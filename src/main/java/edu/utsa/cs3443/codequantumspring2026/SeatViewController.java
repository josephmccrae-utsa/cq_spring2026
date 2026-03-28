package edu.utsa.cs3443.codequantumspring2026;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SeatViewController {

    Stage stage;

    private Customer customer;

    private ArrayList<RadioButton> seatButtons = new ArrayList<>();

    private TicketManager ticketManager;
    private ArrayList<Ticket> buyingTickets = new ArrayList<Ticket>();

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
    public void initialize(){
        loadRadioButtons();
        ticketManager = new TicketManager();
        findSeatClicked();
    }

    @FXML
    void onLogoutButtonClicked(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("layouts/login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("F1 Seat Finder!");
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
        System.out.println("Tickets have been bought!");
        purchaseTickets();

    }

    public void purchaseTickets() {
        for (Ticket ticket : customer.getBuyingTickets()) {
            ticket.setOwner(customer.getName());
            ticket.setAvailable(false);
            ticketManager.updateFindTicket(ticket);
        }
        ticketManager.saveTickets();
    }

    @FXML
    void onCalculatePriceButtonClicked(ActionEvent event) {
        findUserClickedSeats();
        double priceTotal = 0;
        priceTotal = customer.addTicketPrices();
        ticketPriceTextField.setText("$" + Double.toString((priceTotal)));

    }

    void findUserClickedSeats() {
        int i = 0;
        for(Ticket ticket : ticketManager.getTicketList()) {
            if (ticket.isAvailable() && seatButtons.get(i).isSelected()) {
                customer.addBuyingTicket(ticket);
//                System.out.println("Buying ticket: " + ticket.getColumn() + " " + ticket.getRow());
            }
            i = i + 1;
        }
    }

    void findSeatClicked(){
        int i = 0;
        for(Ticket ticket : ticketManager.getTicketList()){
            if(!ticket.isAvailable()){
                seatButtons.get(i).setVisible(false);
                seatButtons.get(i).setSelected(true);
            }
            i = i + 1;
        }
    }

    void setStage(Stage stage){
        this.stage = stage;
    }

    void setCustomer(User user){
        UserManager userManager = new UserManager();
        for(User u : userManager.getUserList()){
            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                this.customer = new Customer(u.getName(), u.getUsername(), u.getPassword());
            }
        }
    }

    private void loadRadioButtons() {

        seatButtons.add(RadioButton00);
        seatButtons.add(RadioButton10);
        seatButtons.add(RadioButton20);
        seatButtons.add(RadioButton30);
        seatButtons.add(RadioButton40);
        seatButtons.add(RadioButton50);

        seatButtons.add(RadioButton01);
        seatButtons.add(RadioButton11);
        seatButtons.add(RadioButton21);
        seatButtons.add(RadioButton31);
        seatButtons.add(RadioButton41);
        seatButtons.add(RadioButton51);

        seatButtons.add(RadioButton02);
        seatButtons.add(RadioButton12);
        seatButtons.add(RadioButton22);
        seatButtons.add(RadioButton32);
        seatButtons.add(RadioButton42);
        seatButtons.add(RadioButton52);

        seatButtons.add(RadioButton03);
        seatButtons.add(RadioButton13);
        seatButtons.add(RadioButton23);
        seatButtons.add(RadioButton33);
        seatButtons.add(RadioButton43);
        seatButtons.add(RadioButton53);

        seatButtons.add(RadioButton04);
        seatButtons.add(RadioButton14);
        seatButtons.add(RadioButton24);
        seatButtons.add(RadioButton34);
        seatButtons.add(RadioButton44);
        seatButtons.add(RadioButton54);
    }
}
