package com.campus.parking.service;

import com.campus.parking.model.Ticket;
import com.campus.parking.model.Vehicle;
import com.campus.parking.exception.ParkingLotFullException;
import com.campus.parking.exception.InvalidTicketException;
import java.util.List;

public interface ParkingService {
    Ticket parkVehicle(Vehicle vehicle) throws ParkingLotFullException;
    double unparkVehicle(int ticketId) throws InvalidTicketException;
    int getAvailableSlotsCount();
    List<Ticket> getActiveTickets();
}
