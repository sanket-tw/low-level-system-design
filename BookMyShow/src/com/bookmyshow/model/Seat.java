package com.bookmyshow.model;

public class Seat {

    enum SeatType {
        LUXURY, VIP, DELUXE, OTHER
    }

    enum SeatStatus {
        AVAILABLE, RESERVED, BOOKED, NOT_AVAILABLE
    }

    private String seatId;

    private SeatType seatType;

    private SeatStatus seatStatus;

    private int seatNumber;

    private double price;
}
