package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Map;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private ParkingLot[] parkingLots;
    private String lastErrorMessage;
    private int parkingLotNumber;

    public ParkingBoy(ParkingLot parkingLot) {
        parkingLotNumber=1;
        parkingLots = new ParkingLot[parkingLotNumber];
        parkingLots[parkingLotNumber-1] = parkingLot;

    }

    public ParkingBoy(ParkingLot[] parkingLots){
        this.parkingLotNumber = parkingLots.length;
        this.parkingLots = new ParkingLot[parkingLotNumber];
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method
        for (int index = 0; index < parkingLotNumber; index++) {
            if (parkingLots[index].getAvailableParkingPosition() >= 1) {
                ParkingTicket parkingTicket = new ParkingTicket();
                parkingLots[index].getCars().put(parkingTicket, car);
                lastErrorMessage = null;
                return parkingTicket;
            } else {
                if (index >= parkingLotNumber-1) {
                    lastErrorMessage = "The parking lot is full.";

                }
            }
        }
        return null;
    }

    public Car fetch(ParkingTicket ticket) {
        // TODO: Please implement the method
        for(int index = 0; index < parkingLotNumber; index++) {
            if (ticket != null) {
                if (parkingLots[index].getCars().containsKey(ticket)) {
                    Car fetchCar = parkingLots[index].getCars().get(ticket);
                    parkingLots[index].getCars().remove(ticket);
                    ticket.setUsed(true);
                    lastErrorMessage = null;
                    return fetchCar;
                } else {
                    if (index >= parkingLotNumber - 1) {
                        lastErrorMessage = "Unrecognized parking ticket.";
                        return null;
                    }
                }

            }else{
                lastErrorMessage = "Please provide your parking ticket.";
            }
        }
        return null;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
