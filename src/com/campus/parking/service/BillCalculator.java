package com.campus.parking.service;

import com.campus.parking.model.Ticket;
import java.time.Duration;
import java.time.LocalDateTime;

public class BillCalculator {
    
    // Rates
    private static final double BIKE_RATE_PER_HOUR = 10.0;
    private static final double CAR_RATE_PER_HOUR = 20.0;

    public static double calculateBill(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        
        // For testing: If entry and exit are same second, assume 1 hour minimum
        long hours = Duration.between(entryTime, exitTime).toHours();
        if (hours == 0) hours = 1; 

        double rate = 0;
        String type = ticket.getVehicle().getType();

        if (type.equalsIgnoreCase("Bike")) {
            rate = BIKE_RATE_PER_HOUR;
        } else if (type.equalsIgnoreCase("Car")) {
            rate = CAR_RATE_PER_HOUR;
        }

        return hours * rate;
    }
}