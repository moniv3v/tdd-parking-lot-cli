package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy{
    private String lastErrorMessage;

    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    public ParkingLot selectLargerAvailablePositionRate(){
        double largerAvailablePositionRate = 0;
        ParkingLot largerRateParkingLot = null;
        for (ParkingLot parkingLot : parkingLots){
            if(parkingLot.getPositionRate() > largerAvailablePositionRate){
                largerAvailablePositionRate = parkingLot.getPositionRate();
                largerRateParkingLot = parkingLot;
            }
        }
        return largerRateParkingLot;
    }

    @Override
    public ParkingTicket park(Car car){
        ParkingLot parkingLot = selectLargerAvailablePositionRate();
        ParkingTicket parkingTicket = parkingLot.park(car);
        return parkingTicket;
    }
}
