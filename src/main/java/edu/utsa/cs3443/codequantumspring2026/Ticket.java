package edu.utsa.cs3443.codequantumspring2026;

public class Ticket {
    private int column;
    private int row;
    private double seatPrice;
    private boolean available;
    private String owner;

    public Ticket(int column, int row, double seatPrice, boolean available) {
        this.column = column;
        this.row = row;
        this.seatPrice = seatPrice;
        this.available = available;
    }

    public Ticket(int column, int row, double seatPrice, boolean available, String owner) {
        this.column = column;
        this.row = row;
        this.seatPrice = seatPrice;
        this.available = available;
        this.owner = owner;
    }

    public Ticket(int column, int row) {
        this.column = column;
        this.row = row;
        this.seatPrice = 0.0;
        this.available = false;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
