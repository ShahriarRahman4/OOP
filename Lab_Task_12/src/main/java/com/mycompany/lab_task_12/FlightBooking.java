package com.mycompany.lab_task_12;

public class FlightBooking extends Booking {
    private String flightNumber;
    private String destination;

    public FlightBooking(String bookingId, String customerName, String bookingDate,
                         String flightNumber, String destination) {
        super(bookingId, customerName, bookingDate);
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void confirmBooking() {
        System.out.println("Flight booking confirmed for " + getCustomerName() +
                           " on flight " + flightNumber + " to " + destination);
    }

    public void cancelBooking() {
        System.out.println("Flight booking canceled for flight " + flightNumber +
                           " to " + destination);
    }
}
