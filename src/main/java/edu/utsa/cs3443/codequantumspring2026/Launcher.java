package edu.utsa.cs3443.codequantumspring2026;


import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        /*UserManager users = new UserManager();
        User currUser = users.getUserList().get(0);
        System.out.println(currUser.getName());*/

//
//        TicketManager tickets = new TicketManager();
//        Ticket currTicket = tickets.getTicketList().get(0);
//        System.out.println(currTicket.getSeatNumber());
//
//        Ticket newTicket = new Ticket("801", 199.00, true);
//        tickets.addTicket(newTicket);
//        Ticket lastTicket = tickets.getTicketList().getLast();
//        System.out.println(lastTicket.getSeatNumber());



        Application.launch(HelloApplication.class, args);
    }
}
