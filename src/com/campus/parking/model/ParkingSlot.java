package com.campus.parking.model;

public class ParkingSlot {
    private int slotId;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSlot(int slotId) {
        this.slotId = slotId;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public void park(Vehicle v) {
        this.parkedVehicle = v;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getSlotId() {
        return slotId;
    }
    
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
