package com.lld.app.parkinglot.model;

import com.lld.app.parkinglot.exception.InvalidCapacityException;
import com.lld.app.parkinglot.exception.InvalidParkingSpotNumberException;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ParkingLot {
    private static final Integer MAX_CAPACITY = 10;
    private Integer capacity;
    private Map<Integer, ParkingSpot> parkingSpots;

    public ParkingLot(int capacity) {
        if (capacity > MAX_CAPACITY || capacity <= 0) {
            throw new InvalidCapacityException("Capacity cannot exceed MAX_CAPACITY of " + MAX_CAPACITY);
        }
        this.capacity = capacity;
        parkingSpots = new HashMap<>();
    }

    /**
     * getParkingSpot returns free available parkingSpot object to park the car
     * @param parkingSpotNumber
     * @return
     */
    private ParkingSpot getParkingSpot(int parkingSpotNumber) {
        if (parkingSpotNumber > MAX_CAPACITY || parkingSpotNumber <= 0) {
            throw new InvalidParkingSpotNumberException("Parking spot ranges from 1 to " + MAX_CAPACITY);
        }

        if (!this.parkingSpots.containsKey(parkingSpotNumber)) {
            this.parkingSpots.put(parkingSpotNumber, new ParkingSpot(parkingSpotNumber));
        }
        return this.getParkingSpots().get(parkingSpotNumber);
    }

    /**
     * Park Car to the next free slot
     * @param car
     * @param parkingSpotNumber
     * @return {@link ParkingSpot }
     */
    public ParkingSpot parkCar(Car car, int parkingSpotNumber) {
        final ParkingSpot parkingSpot = getParkingSpot(parkingSpotNumber);
        if (parkingSpot.getParkedCar() != null) {
            throw new InvalidParkingSpotNumberException("Parking spot already filled");
        }
        parkingSpot.setParkedCar(car);
        return parkingSpot;
    }

    /**
     * Remove parked car from the parkingSot
     * @param parkingSpotNumber
     * @return {@link ParkingSpot}
     */
    public ParkingSpot removeParkedCar(int parkingSpotNumber) {
        final ParkingSpot parkingSpot = getParkingSpot(parkingSpotNumber);
        parkingSpot.setParkedCar(null);
        return parkingSpot;
    }

    /**
     * Get ParkingSpot for a given Car
     * @param car
     * @return {@link ParkingSpot}
     */
    public ParkingSpot getSpotForParkedCar(Car car) {
        for (Map.Entry<Integer, ParkingSpot> parkingSpot : this.parkingSpots.entrySet()) {
            if (parkingSpot.getValue().equals(car)) {
                return parkingSpot.getValue();
            }
        }
        return null;
    }
}
