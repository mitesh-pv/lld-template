package com.lld.app.parkinglot.service;

import com.lld.app.parkinglot.model.Car;
import com.lld.app.parkinglot.model.ParkingLot;
import com.lld.app.parkinglot.model.ParkingSpot;
import com.lld.app.parkinglot.strategy.ParkingStrategy;
import lombok.Data;

import java.util.Map;
import java.util.stream.IntStream;

@Data
public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public ParkingLotService(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;

        IntStream.range(1, parkingLot.getCapacity() + 1)
                .forEach(parkingSpotNumber -> this.parkingStrategy.addEmptySpot(parkingSpotNumber));
    }

    /**
     * API to park a new car, returns spot number at which car should be parked
     * @param car
     * @return {@link Integer}
     */
    public Integer parkCar(Car car) {
        int freeSpot = parkingStrategy.getNextEmptySpot();
        parkingLot.parkCar(car, freeSpot);
        parkingStrategy.removeFilledSpot(freeSpot);
        return freeSpot;
    }

    /**
     * API to remve parked car from the parked spot.
     * @param parkingSpotNumber
     */
    public void removeParkedCar(Car car) {
        parkingLot.removeParkedCar(car);
        parkingStrategy.addEmptySpot(car);
    }

    public void printAllParkedCars() {
        Map<Integer, ParkingSpot> spots = parkingLot.getParkingSpots();
        for(Map.Entry<Integer, ParkingSpot> spot : spots.entrySet()) {
            System.out.println(spot.getValue());
        }
    }

}
