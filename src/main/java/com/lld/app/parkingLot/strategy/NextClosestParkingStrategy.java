package com.lld.app.parkingLot.strategy;

import com.lld.app.parkingLot.exception.ParkingFullException;

import java.util.TreeSet;

public class NextClosestParkingStrategy implements ParkingStrategy {
    private TreeSet<Integer> parkingSpots;

    public NextClosestParkingStrategy() {
        this.parkingSpots = new TreeSet<>();
    }

    @Override
    public void addEmptySpot(Integer spotNumber) {
        this.parkingSpots.add(spotNumber);
    }

    @Override
    public void removeFilledSpot(Integer spotNumber) {
        this.parkingSpots.remove(spotNumber);
    }

    @Override
    public Integer getNextEmptySpot() {
        if (this.parkingSpots.isEmpty()) {
            throw new ParkingFullException("No free parking spots available");
        }
        return this.parkingSpots.first();
    }
}
