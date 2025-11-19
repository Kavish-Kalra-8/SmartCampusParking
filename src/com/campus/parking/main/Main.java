package com.campus.parking.main;

import com.campus.parking.service.ParkingService;
import com.campus.parking.service.ParkingServiceImpl;
import com.campus.parking.model.Vehicle;
import com.campus.parking.model.Car;
import com.campus.parking.model.Bike;
import com.campus.parking.model.Ticket;
import com.campus.parking.exception.ParkingLotFullException;
import com.campus.parking.exception.InvalidTicketException;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingService parkingService = new ParkingServiceImpl();

        System.out.println("=== SMART CAMPUS PARKING SYSTEM ===");
        System.out.println("Initializing system with 10 slots...");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Park a Vehicle");
            System.out.println("2. Unpark & Calculate Bill");
            System.out.println("3. View Admin Dashboard");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    handleParking(scanner, parkingService);
                    break;
                case 2:
                    handleUnparking(scanner, parkingService);
                    break;
                case 3:
                    showDashboard(parkingService);
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void handleParking(Scanner scanner, ParkingService service) {
        try {
            System.out.print("Enter License Plate: ");
            String plate = scanner.nextLine();
            
            System.out.print("Enter Vehicle Type (Car/Bike): ");
            String type = scanner.nextLine();

            Vehicle vehicle;
            if (type.equalsIgnoreCase("Car")) {
                vehicle = new Car(plate);
            } else if (type.equalsIgnoreCase("Bike")) {
                vehicle = new Bike(plate);
            } else {
                System.out.println("Error: Invalid vehicle type. Only Car or Bike allowed.");
                return;
            }

            Ticket ticket = service.parkVehicle(vehicle);
            System.out.println("---------------------------------");
            System.out.println("SUCCESS: Vehicle Parked.");
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("Slot Number: " + ticket.getSlotId());
            System.out.println("---------------------------------");

        } catch (ParkingLotFullException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void handleUnparking(Scanner scanner, ParkingService service) {
        try {
            System.out.print("Enter Ticket ID to unpark: ");
            String input = scanner.nextLine();
            int ticketId = Integer.parseInt(input);

            double fee = service.unparkVehicle(ticketId);
            
            System.out.println("---------------------------------");
            System.out.println("SUCCESS: Vehicle Unparked.");
            System.out.println("Total Fee to Pay: $" + fee);
            System.out.println("---------------------------------");

        } catch (InvalidTicketException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Please enter a valid numeric Ticket ID.");
        }
    }

    private static void showDashboard(ParkingService service) {
        System.out.println("\n[ ADMIN DASHBOARD ]");
        System.out.println("Available Slots: " + service.getAvailableSlotsCount());
        
        List<Ticket> activeTickets = service.getActiveTickets();
        System.out.println("Currently Parked Vehicles: " + activeTickets.size());
        
        if (activeTickets.isEmpty()) {
            System.out.println(" - No vehicles in the lot.");
        } else {
            for (Ticket t : activeTickets) {
                System.out.println(" - " + t.toString() + " [" + t.getVehicle().toString() + "]");
            }
        }
    }
}
