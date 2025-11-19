package com.campus.parking.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private static int idCounter = 100; // Auto-increment ID
    private int ticketId;
    private Vehicle vehicle;
    private int slotId;
    private LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, int slotId) {
        this.ticketId = ++idCounter;
        this.vehicle = vehicle;
        this.slotId = slotId;
        this.entryTime = LocalDateTime.now();
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSlotId() {
        return slotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Ticket #" + ticketId + " | Slot: " + slotId + " | Time: " + entryTime.format(fmt);
    }
}