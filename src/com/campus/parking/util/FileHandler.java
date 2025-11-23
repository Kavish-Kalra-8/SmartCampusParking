package com.campus.parking.util;

import com.campus.parking.model.Ticket;
import com.campus.parking.model.Vehicle;
import com.campus.parking.model.Car;
import com.campus.parking.model.Bike;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    
    private static final String DATA_FILE = "active_tickets.txt";
    private static final String LOG_FILE = "transaction_history.txt";


    public static void saveTickets(List<Ticket> tickets) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Ticket t : tickets) {

                String line = String.format("%d,%d,%s,%s,%s",
                        t.getTicketId(),
                        t.getSlotId(),
                        t.getVehicle().getplateNo(),
                        t.getVehicle().getType(),
                        t.getEntryTime().toString());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    
    public static List<Ticket> loadTickets() {
        List<Ticket> tickets = new ArrayList<>();
        File file = new File(DATA_FILE);
        
        if (!file.exists()) return tickets; 

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                int ticketId = Integer.parseInt(parts[0]);
                int slotId = Integer.parseInt(parts[1]);
                String plate = parts[2];
                String type = parts[3];
                LocalDateTime entryTime = LocalDateTime.parse(parts[4]);

                Vehicle v = type.equalsIgnoreCase("Car") ? new Car(plate) : new Bike(plate);
                
                
                Ticket t = new Ticket(ticketId, v, slotId, entryTime);
                tickets.add(t);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return tickets;
    }


    public static void logTransaction(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(LocalDateTime.now() + ": " + message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Could not write to log.");
        }
    }
}
