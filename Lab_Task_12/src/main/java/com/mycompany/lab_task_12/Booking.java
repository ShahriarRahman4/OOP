package com.mycompany.lab_task_12;

public abstract class Booking {
    private String bookingId;
    private String customerName;
    private String bookingDate;

    public Booking(String bookingId, String customerName, String bookingDate) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.bookingDate = bookingDate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public abstract void confirmBooking();
    public abstract void cancelBooking();
}
