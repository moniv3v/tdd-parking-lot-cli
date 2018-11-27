package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public double getPositionRate(){
        return (double) getAvailableParkingPosition() / (double) capacity ;
    }

    public int getAvailableParkingPosition() {
        return capacity-cars.size();
    }
    public int tmpFunction(){
        return this.cars.size();
    }

    public Map<ParkingTicket, Car> getCars() {
        return cars;
    }

    public Car fetch(ParkingTicket ticket) {
        if(cars.containsKey(ticket)){
            return cars.remove(ticket);
        }
        return null;
    }

    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket();
        cars.put(parkingTicket, car);

        return parkingTicket;
    }
}
