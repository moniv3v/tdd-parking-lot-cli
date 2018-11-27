package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SuperSmartParkingBoyTest {
    @Test
    void should_park_to_a_parking_lot_contains_larger_available_position_rate(){
        int morePosition = 10;
        int lessPosition = 5;
        Car car = new Car();
        ParkingLot morePositionParkingLot = new ParkingLot(morePosition);
        ParkingLot lessPositionParkingLot = new ParkingLot(lessPosition);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(morePositionParkingLot,lessPositionParkingLot);
        superSmartParkingBoy.park(car);
        double actualPositionRate = morePositionParkingLot.getPositionRate();
        assertEquals(0.9,actualPositionRate);

    }

}
