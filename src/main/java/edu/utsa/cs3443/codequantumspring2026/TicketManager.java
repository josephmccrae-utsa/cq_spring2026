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
        if(fields.length != 3) {
            return null;
        }
        return new Ticket(fields[0], Double.parseDouble(fields[1]), Boolean.parseBoolean(fields[2]));
    }

    private String convertTicketToLine(Ticket ticket) {
        return ticket.getSeatNumber() + "," + ticket.getSeatPrice() + "," + ticket.isAvailable();
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }
}
