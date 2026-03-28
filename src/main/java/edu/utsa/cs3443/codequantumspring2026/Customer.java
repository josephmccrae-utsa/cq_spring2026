package edu.utsa.cs3443.codequantumspring2026;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{
    private ArrayList<Ticket> ticketsBought = new ArrayList<Ticket>();

    public Customer(String name, String username, String password) {
        super(name, username, password);
        loadUserTickets();
    }


    public void addTicket(Ticket ticket) {
        ticketsBought.add(ticket);
    }

    private void loadUserTickets() {
        Scanner input = null;
        ticketsBought.clear();
        try {
            String line;
            Ticket ticket;
            File inputFile = new File("data/userTickets.txt");
            input = new Scanner(inputFile);

            while (input.hasNextLine()) {
                line = input.nextLine();
                ticket = checkUserTicket(line);
                if (ticket != null) {
                    addTicket(ticket);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Reading data file: " + e.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }


//    public void saveTickets() {
//        try {
//            BufferedWriter output = new BufferedWriter(new FileWriter("data/users.txt"));
//
//            for (Ticket ticket : ticketList) {
//                output.write(convertTicketToLine(ticket));
//                output.newLine();
//            }
//            output.close();
//        } catch (IOException e) {
//            System.out.println("ERROR: Writing to data file: " + e.getMessage());
//        }
//    }

    private Ticket checkUserTicket(String line) {
        String[] fields = line.split(",");
//        if(fields.length != 3) {
//            return null;
//        }
        if (fields[0].compareTo(getName()) == 0) {
            return new Ticket(Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
        }
        else return null;
    }

    public double addTicketPrices(){
        double totalPrice = 0;
        for(Ticket ticket : ticketsBought){
            totalPrice += ticket.getSeatPrice();
        }
        return totalPrice;
    }

}
