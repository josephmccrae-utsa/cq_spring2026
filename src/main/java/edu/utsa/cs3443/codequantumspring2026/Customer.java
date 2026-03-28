package edu.utsa.cs3443.codequantumspring2026;

import java.util.ArrayList;

public class Customer extends User{
    private ArrayList<Ticket> ticketsBought = new ArrayList<Ticket>();

    public Customer(String name, String username, String password) {
        super(name, username, password);
        this.ticketsBought = loadTickets();
    }

    public void addTicket(Ticket ticket) {
        ticketsBought.add(ticket);
    }


    private ArrayList<Ticket> loadTickets(){

        return null;
    }

    public void addTicketPrices(){
        double totalPrice = 0;
        for(Ticket ticket : ticketsBought){
            totalPrice += ticket.getSeatPrice();
        }
    }

}
