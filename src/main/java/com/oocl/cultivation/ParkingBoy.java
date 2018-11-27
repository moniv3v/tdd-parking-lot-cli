package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots = new ArrayList<>();
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public ParkingLot selectParkingLog(){
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailableParkingPosition() >= 1) {
                return parkingLot;
            }
        }
        return null;
    }

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method
        ParkingTicket ticket = null;
        ParkingLot parkingLot = selectParkingLog();
        if(parkingLot!=null){
            lastErrorMessage = null;
            ticket = parkingLot.park(car);
        }
        if (ticket == null) {
            lastErrorMessage = "The parking lot is full.";
        }
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        // TODO: Please implement the method
        if(ticket == null){
            lastErrorMessage = "Please provide your parking ticket.";
            return null;
        }
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCars().containsKey(ticket)) {
                car = parkingLot.fetch(ticket);
            }
        }
        if(car == null){
            lastErrorMessage = "Unrecognized parking ticket.";
        }
        return car;
    }


    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
