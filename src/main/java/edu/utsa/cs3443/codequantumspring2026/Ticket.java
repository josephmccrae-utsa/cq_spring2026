package edu.utsa.cs3443.codequantumspring2026;

public class Ticket {
    private int xPosition;
    private int yPosition;
    private double seatPrice;
    private boolean available;

    public Ticket(int xPosition, int yPosition, double seatPrice, boolean available) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.seatPrice = seatPrice;
        this.available = available;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
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
