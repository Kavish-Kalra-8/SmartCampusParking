package com.campus.parking.model;

public abstract class Vehicle {
    private String plateNo;
    private String type;

    public Vehicle(String plateNo, String type) {
        this.plateNo = plateNo;
        this.type = type;
    }


    public String getplateNo() {
        return plateNo;
    }

    public String getType() {
        return type;
    }


    public void setplateNo(String plateNo) {
        this.plateNo = plateNo;
    }
    
    @Override
    public String toString() {
        return type + " [" + plateNo + "]";
    }
}