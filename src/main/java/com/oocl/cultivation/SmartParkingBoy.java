package com.oocl.cultivation;

import com.oocl.cultivation.ParkingBoy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    private String lastErrorMessage;

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    public ParkingLot selectMaxAvailableParkingLot(){
        int maxAvailableParkingPosition = 0;
        ParkingLot maxAvailableParkingLot = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailableParkingPosition()>maxAvailableParkingPosition) {
                maxAvailableParkingPosition = parkingLot.getAvailableParkingPosition();
                maxAvailableParkingLot = parkingLot;
            }
        }
        return maxAvailableParkingLot;
    }

    @Override
    public ParkingTicket park(Car car) {
        // TODO: Please implement the method
        ParkingTicket ticket = null;
        ParkingLot maxAvailableParkingLot = selectMaxAvailableParkingLot();
        ticket = maxAvailableParkingLot.park(car);
        lastErrorMessage = null;

        if (ticket == null) {
            lastErrorMessage = "The parking lot is full.";
        }
        return ticket;
    }
}
