package com.lld.app.parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@ToString
@AllArgsConstructor
@Data
public class ParkingSpot {
    private Car parkedCar;
    private int spotNumber;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isSpotFree() {
        return parkedCar == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return spotNumber == that.spotNumber && Objects.equals(parkedCar, that.parkedCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkedCar, spotNumber);
    }
}
