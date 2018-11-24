package com.oocl.cultivation;

import java.util.Map;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method
        if(parkingLot.getAvailableParkingPosition()>=1){
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingLot.getCars().put(parkingTicket,car);
            lastErrorMessage = null;
            return parkingTicket;
        }else{
            lastErrorMessage = "The parking lot is full.";
            return null;
        }

    }

    public Car fetch(ParkingTicket ticket) {
        // TODO: Please implement the method
        if (ticket != null) {
            if (parkingLot.getCars().containsKey(ticket)) {
                Car fetchCar = parkingLot.getCars().get(ticket);
                parkingLot.getCars().remove(ticket);
                ticket.setUsed(true);
                lastErrorMessage = null;
                return fetchCar;
            } else{
                lastErrorMessage = "Unrecognized parking ticket.";
                return null;
            }
        }
        else{
            lastErrorMessage = "Please provide your parking ticket.";
            return null;
        }
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
