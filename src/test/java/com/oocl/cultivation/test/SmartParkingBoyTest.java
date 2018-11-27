package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {

    @Test
    void should_park_to_a_parking_lot_contains_more_empty_positions(){
        int morePosition = 3;
        int lessPosition = 1;
        ParkingLot morePositionParkingLot = new ParkingLot(morePosition);
        ParkingLot lessPositionParkingLot = new ParkingLot(lessPosition);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(lessPositionParkingLot,morePositionParkingLot);
        Car car = new Car();
        int expectAvailableParkingPosition = morePositionParkingLot.getAvailableParkingPosition();
        assertEquals(3,expectAvailableParkingPosition);
        ParkingTicket ticket = smartParkingBoy.park(car);
        expectAvailableParkingPosition = morePositionParkingLot.getAvailableParkingPosition();
        assertEquals(2,expectAvailableParkingPosition);
    }
}
