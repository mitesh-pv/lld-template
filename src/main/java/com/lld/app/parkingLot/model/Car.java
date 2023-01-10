package com.lld.app.parkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Car {
    private String regNo;
    private String color;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(regNo, car.regNo) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo, color);
    }
}
