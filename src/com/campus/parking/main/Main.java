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

        System.out.println("VIT Bhopal Smart Campus Parking System : ");

        while (true) {
            System.out.println("MAIN MENU - ");
            System.out.println("1. Park a Vehicle (Create)");
            System.out.println("2. Unpark & Bill (Delete)");
            System.out.println("3. Search Vehicle (Read)");
            System.out.println("4. Edit License Plate (Update)");
            System.out.println("5. View Dashboard (Read All)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = 0;
            try {
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
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
                    System.out.print("Enter License Plate to find: ");
                    String searchPlate = scanner.nextLine();
                    System.out.println(parkingService.searchVehicle(searchPlate));
                    break;
                case 4:
                    
                    System.out.print("Enter Ticket ID to edit: ");
                    try {
                        int updateId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter New License Plate: ");
                        String newPlate = scanner.nextLine();
                        
                        if(parkingService.updateplateNo(updateId, newPlate)) {
                            System.out.println("SUCCESS: License plate updated.");
                        } else {
                            System.out.println("ERROR: Ticket ID not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Ticket ID.");
                    }
                    break;
                case 5:
                    showDashboard(parkingService);
                    break;
                case 6:
                    System.out.println("Exiting system. Data saved.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
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
                System.out.println("Wrong input. Only Car/Bike supported.");
                return;
            }

            Ticket ticket = service.parkVehicle(vehicle);
            System.out.println("SUCCESS: Parked at Slot " + ticket.getSlotId() + " (Ticket #" + ticket.getTicketId() + ")");

        } catch (ParkingLotFullException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void handleUnparking(Scanner scanner, ParkingService service) {
        try {
            System.out.print("Enter Ticket ID to unpark: ");
            int ticketId = Integer.parseInt(scanner.nextLine());
            double fee = service.unparkVehicle(ticketId);
            System.out.println("SUCCESS: Vehicle Unparked. Total Fee: $" + fee);
        } catch (InvalidTicketException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid Ticket ID.");
        }
    }

    private static void showDashboard(ParkingService service) {
        System.out.println("\n[ ADMIN DASHBOARD ]");
        System.out.println("Slots Available: " + service.getAvailableSlotsCount());
        List<Ticket> activeTickets = service.getActiveTickets();
        if (activeTickets.isEmpty()) {
            System.out.println("No vehicles currently parked.");
        } else {
            for (Ticket t : activeTickets) {
                System.out.println(t);
            }
        }
    }
}