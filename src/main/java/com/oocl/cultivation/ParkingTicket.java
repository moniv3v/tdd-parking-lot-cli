package com.oocl.cultivation;

public class ParkingTicket {
    boolean isUsed;
    public ParkingTicket(){
        this.isUsed = false;
    };
    public boolean isUsed() {
        return isUsed;
    }
    public void setUsed(boolean used) {
        this.isUsed = used;
    }
}
