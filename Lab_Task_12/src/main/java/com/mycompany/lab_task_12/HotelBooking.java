package com.mycompany.lab_task_12;

public class HotelBooking extends Booking {
    private String hotelName;
    private int numOfRooms;

    public HotelBooking(String bookingId, String customerName, String bookingDate,
                        String hotelName, int numOfRooms) {
        super(bookingId, customerName, bookingDate);
        this.hotelName = hotelName;
        this.numOfRooms = numOfRooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void confirmBooking() {
        System.out.println(numOfRooms + " rooms booked at " + hotelName +
                           " for " + getCustomerName());
    }

    public void cancelBooking() {
        System.out.println("Hotel booking canceled at " + hotelName);
    }
}
