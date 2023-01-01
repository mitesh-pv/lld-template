package com.lld.app.parkingLot.strategy;

public interface ParkingStrategy {

    /**
     * Add Spot to the list to make it available for parking
     * @param spotNumber
     */
    void addEmptySpot(Integer spotNumber);

    /**
     * Remove spot from parking to make it unavailable for parking
     * @param spotNumber
     */
    void removeFilledSpot(Integer spotNumber);

    /**
     * Get next free available spot for parking
     * @return
     */
    Integer getNextEmptySpot();
}
