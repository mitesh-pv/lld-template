package com.lld.app.parkinglot;

import com.lld.app.parkinglot.model.Car;
import com.lld.app.parkinglot.model.ParkingLot;
import com.lld.app.parkinglot.model.ParkingSpot;
import com.lld.app.parkinglot.service.ParkingLotService;
import com.lld.app.parkinglot.strategy.NextClosestParkingStrategy;

/**
 * Low level design for Parking lot
 */
public class ParkingLotApplication {
    private ParkingLotService parkingLotService;

    public void mainApplication() {
        this.parkingLotService = new ParkingLotService(new ParkingLot(3), new NextClosestParkingStrategy());

        Car car = new Car("KA12", "Red");
        parkingLotService.parkCar(car);

        System.out.println("-");
        parkingLotService.printAllParkedCars();
        System.out.println("-");

        Car car2 = new Car("KA13", "Blue");
        parkingLotService.parkCar(car2);

        System.out.println("-");
        parkingLotService.printAllParkedCars();
        System.out.println("-");

        Car car3 = new Car("KA14", "Green");
        parkingLotService.parkCar(car3);
        System.out.println("-");
        parkingLotService.printAllParkedCars();
        System.out.println("-");



    }
}
