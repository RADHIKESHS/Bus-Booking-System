package com.masai;

import java.util.ArrayList;
import java.util.Scanner;

public class Passenger {
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNo;
    private String username;
    private String password;
    private ArrayList<Booking> bookingHistory;

    public Passenger(String firstName, String lastName, String address, String mobileNo, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNo = mobileNo;
        this.username = username;
        this.password = password;
        this.bookingHistory = new ArrayList<Booking>();
    }
    
    
    
    public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public ArrayList<Booking> getBookingHistory() {
		return bookingHistory;
	}



	public void setBookingHistory(ArrayList<Booking> bookingHistory) {
		this.bookingHistory = bookingHistory;
	}

//  Method to sign-up
    public static Passenger signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Enter mobile number: ");
        String mobileNo = scanner.nextLine();
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        return new Passenger(firstName, lastName, address, mobileNo, username, password);
    }

//	 Method to view list of all buses
    public void viewAllBuses(ArrayList<Bus> busList) {
        for (Bus bus : busList) {
            System.out.println("Bus No: " + bus.getBusNo() + " | Bus Name: " + bus.getBusName()
                    + " | Source: " + bus.getSource() + " | Destination: " + bus.getDestination()
                    + " | Departure Time: " + bus.getDepartureTime() + " | Arrival Time: " + bus.getArrivalTime()
                    + " | Bus Type: " + bus.getBusType() + " | Total Seats: " + bus.getTotalSeats());
        }
    }

//   Method to book ticket by selecting bus number
    public void bookTicket(ArrayList<Bus> busList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter bus number: ");
        int busNo = input.nextInt();
        System.out.println("Enter number of seats: ");
        int numSeats = input.nextInt();

        for (Bus bus : busList) {
            if (bus.getBusNo() == busNo) {
                if (bus.getTotalSeats() - bus.getBookedSeats() >= numSeats) {
                    bus.bookSeats(numSeats);
                    Booking booking = new Booking(bus.getBusName(),bus.getSource(),bus.getBusType(),bus.getDestination(),bus.getAvailableSeats());
                    bookingHistory.add(booking);
                    System.out.println("Booking successful!");
                } else {
                    System.out.println("Sorry, seats not available.");
                }
                return;
            }
        }
        System.out.println("Invalid bus number!");
    }

    // Method to cancel ticket
    public void cancelTicket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter booking ID: ");
        int bookingID = input.nextInt();

        for (Booking booking : bookingHistory) {
            if (booking.getBookingID() == bookingID) {
                bookingHistory.remove(booking);
                System.out.println("Ticket cancelled successfully!");
                return;
            }
        }
        System.out.println("Invalid booking ID!");
    }

    
    public void changePassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter current password: ");
        String currentPassword = input.nextLine();
        if (currentPassword.equals(password)) {
            System.out.println("Enter new password: ");
            String newPassword = input.nextLine();
            password = newPassword;
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Incorrect password!");
        }
    }

    // Method to delete account
    public void deleteAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure you want to delete your account? (Y/N)");
        String choice = input.nextLine();
        if (choice.equals("Y")) {
            System.out.println("Account deleted successfully!");
        }
    }
    // Method to view booking history
    public void viewBookingHistory() {
        if (bookingHistory.size() == 0) {
            System.out.println("No bookings found!");
        } else {
            System.out.println("Booking History:");
            for (Booking booking : bookingHistory) {
                System.out.println("Booking ID: " + booking.getBookingID());
                System.out.println("Bus Name: " + booking.getBusName());
                System.out.println("Source: " + booking.getSource());
                System.out.println("Destination: " + booking.getDestination());
                System.out.println("Number of Seats: " + booking.getNumSeats());
                System.out.println("Date of Booking: " + booking.getDateOfBooking());
                System.out.println("-----------------------");
            }
        }
    }



    public void updatePersonalDetails(String firstName, String lastName, String address, String mobileNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNo = mobileNo;
        System.out.println("Personal details updated successfully!");
    }

 // Method to add a booking to the booking history
    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
        System.out.println("Booking added to history!");
    }

    // Method to cancel a booking
    public void cancelBooking(Booking booking) {
        if (bookingHistory.contains(booking)) {
            bookingHistory.remove(booking);
            System.out.println("Booking cancelled successfully!");
        } else {
            System.out.println("Booking not found!");
        }
    }



	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", mobileNo="
				+ mobileNo + ", username=" + username + ", password=" + password + ", bookingHistory=" + bookingHistory
				+ "]";
	}

    
    
}

