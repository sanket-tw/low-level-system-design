package com.parkingworld.parker.parkingstrategy;

import com.parkingworld.parker.parkinglot.parkingspot.ParkingSpot;
import com.parkingworld.parker.vehicle.Vehicle;

public interface ParkingAllotment {
  ParkingSpot allotParkingSpot(Vehicle vehicle);

}
