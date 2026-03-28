package edu.utsa.cs3443.codequantumspring2026;

public class Ticket {
    private String seatNumber;
    private double seatPrice;
    private boolean available;

    public Ticket(String seatNumber, double seatPrice, boolean available) {
        this.seatNumber = seatNumber;
        this.seatPrice = seatPrice;
        this.available = available;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
