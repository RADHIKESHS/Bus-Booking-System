package com.masai;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class BusBookingSystem {

    // List to store all the buses
    static List<Bus> busList = new ArrayList<>();

    // List to store all the bookings
     static List<Booking> bookingList = new ArrayList<>();

    // Method for user login
    public boolean login(String username, String password) {
        // Check if the username and password match with the admin credentials
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }

    // Method to add a bus
    public void addBus(String busName, int busNo, String source, String destination, String busType,
            LocalTime departureTime, LocalTime arrivalTime, int totalSeats)  {
        // Create a new bus object
        Bus bus = new Bus(busName, busNo, source, destination, busType, departureTime, arrivalTime, totalSeats);
        // Add the bus to the bus list

        busList.add(bus);
        System.out.println("Bus added successfully!");
    }

    // Method to update a bus
    public void updateBus(String busName,int busNo, String newBusName, String newBusType, int newTotalSeats) {
        // Loop through the bus list to find the bus with the specified name
        for (Bus bus : busList) {
            if (bus.getBusNo()==busNo  && bus.getBusName().equals(busName)) {
                // Update the bus details
                bus.setBusName(newBusName);
                bus.setBusType(newBusType);
                bus.setTotalSeats(newTotalSeats);
                System.out.println("Bus details updated successfully!");
                return;
            }
        }
        System.out.println("Bus not found!");
    }

    // Method to delete a bus
    public void deleteBus(String busName,int busNo) {
        // Loop through the bus list to find the bus with the specified name
        for (int i = 0; i < busList.size(); i++) {
            if (busList.get(i).getBusName().equals(busName) && busList.get(i).getBusNo()==busNo) {
                // Remove the bus from the bus list
                busList.remove(i);
                System.out.println("Bus deleted successfully!");
                return;
            }
        }
        System.out.println("Bus not found!");
    }

    // Method to view all bookings
    public void viewAllBookings() {
        // Loop through the booking list and print the details
        for (Booking booking : bookingList) {
            System.out.println("Booking ID: " + booking.getBookingID() 
            				+ " | Bus Name: " + booking.getBusName()
                    		+ " | User Name: " + booking.getPassengerUsername()
                    		+ " | Booking Date: " + booking.getDateOfBooking()
                    		+ " | Number of Seats: " + booking.getNumSeats());
        }
    }

    // Method to view bookings for a date range
    public void viewBookingsByDate(ChronoLocalDate startDate, ChronoLocalDate endDate) {
        // Loop through the booking list and print the details for the specified date range
        for (Booking booking : bookingList) {
            if (booking.getDateOfBooking().compareTo(startDate) >= 0 && booking.getDateOfBooking().compareTo(endDate) <= 0) {
                System.out.println("Booking ID: " + booking.getBookingID()
                        + " | Bus Name: " + booking.getBusName()
                        + " | User Name: " + booking.getPassengerUsername()
                        + " | Booking Date: " + booking.getDateOfBooking()
                        + " | Number of Seats: " + booking.getNumSeats());
            }
        }
    }

    // Method to view bookings by bus name
    public void viewBookingsByBusName(String busName) {
        // Loop through the booking list and print the details for the specified bus name
        for (Booking booking : bookingList) {
            if (booking.getBusName().equals(busName)) {
                System.out.println("Booking ID: " + booking.getBookingID()
                        + " | Bus Name: " + booking.getBusName()
                        + " | User Name: " + booking.getPassengerUsername()
                        + " | Booking Date: " + booking.getDateOfBooking()
                        + " | Number of Seats: " + booking.getNumSeats());
            }
        }
    }

    // Method to view bookings by user name
    public void viewBookingsByUserName(String userName) {
        // Loop through the booking list and print the details for the specified user name
        for (Booking booking : bookingList) {
            if (booking.getPassengerUsername().equals(userName)) {
                System.out.println("Booking ID: " + booking.getBookingID()
                        + " | Bus Name: " + booking.getBusName()
                        + " | User Name: " + booking.getPassengerUsername()
                        + " | Booking Date: " + booking.getDateOfBooking()
                        + " | Number of Seats: " + booking.getNumSeats());
            }
        }
    }
}




       

