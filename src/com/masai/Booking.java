package com.masai;

import java.time.LocalDate;

public class Booking {
    private static int bookingCounter = 1001;
    private int bookingID;
    private String passengerUsername;
    private String busName;
    private String source;
    private String destination;
    private int numSeats;
    private LocalDate dateOfBooking;

    public Booking(String passengerUsername, String busName, String source, String destination, int numSeats) {
        this.bookingID = bookingCounter++;
        this.passengerUsername = passengerUsername;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.numSeats = numSeats;
        this.dateOfBooking = LocalDate.now();
    }

    public int getBookingID() {
        return bookingID;
    }

    public String getPassengerUsername() {
        return passengerUsername;
    }

    public String getBusName() {
        return busName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public LocalDate getDateOfBooking() {
        return dateOfBooking;
    }
    
    public void cancelBooking(Bus bus, Passenger loggedInPassenger, int bookingId) {
        for (Booking booking : loggedInPassenger.getBookingHistory()) {
            if (booking.getBookingID() == bookingId) {
                bus.cancelBooking(booking);
                loggedInPassenger.cancelBooking(booking);
                System.out.println("Booking cancelled successfully!");
                break;
            }
        }
    }

	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", passengerUsername=" + passengerUsername + ", busName=" + busName
				+ ", source=" + source + ", destination=" + destination + ", numSeats=" + numSeats + ", dateOfBooking="
				+ dateOfBooking + "]";
	}

    	
}

