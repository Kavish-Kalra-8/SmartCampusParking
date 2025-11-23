package com.campus.parking.service;

import com.campus.parking.model.*;
import com.campus.parking.exception.*;
import com.campus.parking.util.FileHandler; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingServiceImpl implements ParkingService {
    private List<ParkingSlot> slots;
    private Map<Integer, Ticket> activeTickets;
    private static final int MAX_SLOTS = 10;

    public ParkingServiceImpl() {
        this.slots = new ArrayList<>();
        this.activeTickets = new HashMap<>();
        
        
        for (int i = 1; i <= MAX_SLOTS; i++) {
            slots.add(new ParkingSlot(i));
        }

        
        List<Ticket> loadedData = FileHandler.loadTickets();
        for (Ticket t : loadedData) {
            activeTickets.put(t.getTicketId(), t);
            if (t.getSlotId() <= MAX_SLOTS) {
                slots.get(t.getSlotId() - 1).park(t.getVehicle());
            }
        }
    }

    @Override
    public Ticket parkVehicle(Vehicle vehicle) throws ParkingLotFullException {
        
        for(Ticket t : activeTickets.values()) {
            if(t.getVehicle().getplateNo().equalsIgnoreCase(vehicle.getplateNo())) {
                throw new ParkingLotFullException("Vehicle " + vehicle.getplateNo() + " is already parked!");
            }
        }

        ParkingSlot availableSlot = null;
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                availableSlot = slot;
                break;
            }
        }

        if (availableSlot == null) {
            throw new ParkingLotFullException("Parking lot is full!");
        }

        availableSlot.park(vehicle);
        Ticket ticket = new Ticket(vehicle, availableSlot.getSlotId());
        activeTickets.put(ticket.getTicketId(), ticket);
        
        FileHandler.saveTickets(new ArrayList<>(activeTickets.values()));

        return ticket;
    }

    @Override
    public double unparkVehicle(int ticketId) throws InvalidTicketException {
        if (!activeTickets.containsKey(ticketId)) {
            throw new InvalidTicketException("Ticket ID not found: " + ticketId);
        }

        Ticket ticket = activeTickets.get(ticketId);
        double fee = BillCalculator.calculateBill(ticket);
        
        ParkingSlot slot = slots.get(ticket.getSlotId() - 1); 
        slot.removeVehicle();
        activeTickets.remove(ticketId);

        FileHandler.saveTickets(new ArrayList<>(activeTickets.values()));
        FileHandler.logTransaction("Ticket #" + ticketId + " | Plate: " + ticket.getVehicle().getplateNo() + " | Paid: $" + fee);

        return fee;
    }

    @Override
    public String searchVehicle(String plateNo) {
        for (Ticket t : activeTickets.values()) {
            if (t.getVehicle().getplateNo().equalsIgnoreCase(plateNo)) {
                return "Found! Vehicle " + plateNo + " is in Slot " + t.getSlotId() + " (Ticket #" + t.getTicketId() + ")";
            }
        }
        return "Vehicle " + plateNo + " not found.";
    }

    
    @Override
    public boolean updateplateNo(int ticketId, String newPlate) {
        if (!activeTickets.containsKey(ticketId)) {
            return false; 
        }

        Ticket ticket = activeTickets.get(ticketId);
        ticket.getVehicle().setplateNo(newPlate);

        FileHandler.saveTickets(new ArrayList<>(activeTickets.values()));
        return true;
    }

    @Override
    public int getAvailableSlotsCount() {
        int count = 0;
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) count++;
        }
        return count;
    }
    
    @Override
    public List<Ticket> getActiveTickets() {
        return new ArrayList<>(activeTickets.values());
    }
}
