package edu.utsa.cs3443.codequantumspring2026;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketManager{
    ArrayList<Ticket> ticketList;

    public TicketManager() {
        ticketList = new ArrayList<Ticket>();
        loadTickets();
    }


    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
    }

    private void loadTickets() {
        Scanner input = null;
        ticketList.clear();
        try {
            String line;
            Ticket ticket;
            File inputFile = new File("data/seats.txt");
            input = new Scanner(inputFile);

//            input.nextLine();   // Skips header
            while (input.hasNextLine()) {
                line = input.nextLine();
                ticket = convertLineToTicket(line);
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

    public void saveTickets() {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter("data/users.txt"));

            for (Ticket ticket : ticketList) {
                output.write(convertTicketToLine(ticket));
                output.newLine();
            }
            output.close();
        } catch (IOException e) {
            System.out.println("ERROR: Writing to data file: " + e.getMessage());
        }
    }

    private Ticket convertLineToTicket(String line) {
        String[] fields = line.split(",");
        if(fields.length > 5) {
            return null;
        }
        if(fields.length == 5) {
            return new Ticket(Integer.parseInt(fields[0]),Integer.parseInt(fields[1]),Double.parseDouble(fields[2]), Boolean.parseBoolean(fields[3]), fields[4]);
        }
        return new Ticket(Integer.parseInt(fields[0]),Integer.parseInt(fields[1]),Double.parseDouble(fields[2]), Boolean.parseBoolean(fields[3]));
    }

    private String convertTicketToLine(Ticket ticket) {
        if (ticket.getOwner() != null) {
            return ticket.getColumn() + "," + ticket.getRow() + "," + ticket.getSeatPrice() + "," + ticket.isAvailable() + "," + ticket.getOwner();
        }
        return ticket.getColumn() + "," + ticket.getRow() + "," + ticket.getSeatPrice() + "," + ticket.isAvailable();
    }

    public Ticket findTicket(int col, int row) {
        for (Ticket ticket : ticketList) {
            if (ticket.getColumn() == col && ticket.getRow() == row) {
                return ticket;
            }
        }
        return null;
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }
}
