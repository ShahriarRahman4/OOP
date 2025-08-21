package com.mycompany.lab_task_12;

public class EventBooking extends Booking {
    private String eventName;
    private int numOfGuests;

    public EventBooking(String bookingId, String customerName, String bookingDate,
                        String eventName, int numOfGuests) {
        super(bookingId, customerName, bookingDate);
        this.eventName = eventName;
        this.numOfGuests = numOfGuests;
    }

    public String getEventName() {
        return eventName;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public void confirmBooking() {
        System.out.println("Event booking confirmed for " + eventName +
                           " with " + numOfGuests + " guests for " + getCustomerName());
    }

    public void cancelBooking() {
        System.out.println("Event booking canceled for " + eventName);
    }
}
