package com.campus.parking.service;

import com.campus.parking.model.*;
import com.campus.parking.exception.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingServiceImpl implements ParkingService {
    private List<ParkingSlot> slots;
    private Map<Integer, Ticket> activeTickets; // Maps Ticket ID to Ticket Object
    private static final int MAX_SLOTS = 10; // Small size for testing

    public ParkingServiceImpl() {
        this.slots = new ArrayList<>();
        this.activeTickets = new HashMap<>();
        
        // Initialize slots
        for (int i = 1; i <= MAX_SLOTS; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    @Override
    public Ticket parkVehicle(Vehicle vehicle) throws ParkingLotFullException {
        // 1. Find first available slot
        ParkingSlot availableSlot = null;
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                availableSlot = slot;
                break;
            }
        }

        if (availableSlot == null) {
            throw new ParkingLotFullException("Sorry, the parking lot is full!");
        }

        // 2. Occupy the slot
        availableSlot.park(vehicle);

        // 3. Generate Ticket
        Ticket ticket = new Ticket(vehicle, availableSlot.getSlotId());
        activeTickets.put(ticket.getTicketId(), ticket);
        
        System.out.println("Vehicle Parked! Slot: " + availableSlot.getSlotId());
        return ticket;
    }

    @Override
    public double unparkVehicle(int ticketId) throws InvalidTicketException {
        if (!activeTickets.containsKey(ticketId)) {
            throw new InvalidTicketException("Ticket ID not found: " + ticketId);
        }

        // 1. Retrieve ticket
        Ticket ticket = activeTickets.get(ticketId);
        
        // 2. Calculate Fee
        double fee = BillCalculator.calculateBill(ticket);
        
        // 3. Free up the slot
        // Since list index is 0-based but slot IDs are 1-based
        ParkingSlot slot = slots.get(ticket.getSlotId() - 1); 
        slot.removeVehicle();

        // 4. Remove from active tickets
        activeTickets.remove(ticketId);

        return fee;
    }

    @Override
    public int getAvailableSlotsCount() {
        int count = 0;
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                count++;
            }
        }
        return count;
    }
    
    @Override
    public List<Ticket> getActiveTickets() {
        return new ArrayList<>(activeTickets.values());
    }
}
