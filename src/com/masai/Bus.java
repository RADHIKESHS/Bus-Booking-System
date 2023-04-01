package com.masai;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bus {
    private String busName;
    private int busNo;
    private String source;
    private String destination;
    private String busType;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int totalSeats;
    private int availableSeats;

    public Bus(String busName, int busNo, String source, String destination, String busType,
               LocalTime departureTime, LocalTime arrivalTime, int totalSeats) {
        this.busName = busName;
        this.busNo = busNo;
        this.source = source;
        this.destination = destination;
        this.busType = busType;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }


	public String getBusName() {
		return busName;
	}


	public void setBusName(String busName) {
		this.busName = busName;
	}


	public int getBusNo() {
		return busNo;
	}


	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getBusType() {
		return busType;
	}


	public void setBusType(String busType) {
		this.busType = busType;
	}


	public LocalTime getDepartureTime() {
		return departureTime;
	}


	// @Override
	// public String toString() {
	// 	return "Bus [busName=" + busName + ", busNo=" + busNo + ", source=" + source + ", destination=" + destination
	// 			+ ", busType=" + busType + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
	// 			+ ", totalSeats=" + totalSeats + ", availableSeats=" + availableSeats + "]";
	// }


	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}


	public LocalTime getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public int getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


	public boolean checkAvailability(int numSeats) {
        return numSeats <= availableSeats;
    }

    public void updateBusDetails(String busName, String busType, int totalSeats) {
        this.busName = busName;
        this.busType = busType;
        int oldTotalSeats = this.totalSeats;
        this.totalSeats = totalSeats;
        this.availableSeats += totalSeats - oldTotalSeats;
    }

    // public void bookSeats(int numSeats) {
    //     if (numSeats > availableSeats) {
    //         throw new IllegalArgumentException("Not enough available seats!");
    //     }
    //     availableSeats -= numSeats;
    // }

    public void cancelBooking(Booking booking) {
        int numSeats = booking.getNumSeats();
        if (numSeats > totalSeats - availableSeats) {
            throw new IllegalArgumentException("Invalid number of seats to cancel!");
        }
        availableSeats += numSeats;
    }


    public int getBookedSeats() {
    	// TODO Auto-generated method stub
    	return totalSeats-availableSeats;
    	
    }
    
    
    public double calculateFare(String source2, String destination2) {
        double fare = 0.0;
        // Calculate fare based on distance between source and destination
        int distance = 100;
        if (busType.equals("AC-Sleeper")) {
            fare = distance * 10.0;
        } else if (busType.equals("Non-AC-Sleeper")) {
            fare = distance * 8.0;
        } else if (busType.equals("AC")) {
            fare = distance * 6.0;
        } else if (busType.equals("Non-AC")) {
            fare = distance * 5.0;
        }
        return fare;
    }




}




