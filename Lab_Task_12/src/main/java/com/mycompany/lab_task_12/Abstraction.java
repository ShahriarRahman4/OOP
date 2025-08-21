
package com.mycompany.lab_task_12;



import java.util.*;

public class Abstraction {

    public static void main(String[] args) {
        List<Booking> bookings = new ArrayList<>();

        FlightBooking flightBooking = new FlightBooking(
                "FL001", "John Doe", "25-05-203", "ABC123", "New York"
        );
        bookings.add(flightBooking);

        HotelBooking hotelBooking = new HotelBooking(
                "HB001", "Jane Smith", "25-05-203", "Hilton", 2
        );
        bookings.add(hotelBooking);

        EventBooking eventBooking = new EventBooking(
                "EB001", "Alice Brown", "25-05-203", "Music Concert", 100
        );
        bookings.add(eventBooking);

        for (Booking booking : bookings) {
            booking.confirmBooking();
            booking.cancelBooking();
            System.out.println("----------------------");
        }
    }
}