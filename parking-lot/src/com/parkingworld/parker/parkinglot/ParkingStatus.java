package com.parkingworld.parker.parkinglot;

import com.parkingworld.parker.vehicle.Vehicle;

import java.util.Map;

public class ParkingStatus {

  private Map<Vehicle.Type, Integer> parkingMap;
  private Map<Vehicle.Type, Integer> maxAllotmentMap;

  void addParkingType(Vehicle.Type type, int maxAllotment) {
    maxAllotmentMap.put(type, maxAllotment);
  }

  public void increment(Vehicle.Type type) {
    parkingMap.put(type, parkingMap.get(type) + 1);
  }

  void decrement(Vehicle.Type type) {
    parkingMap.put(type, parkingMap.get(type) - 1);
  }

  public boolean isFull(Vehicle.Type vehicleType) {
    return parkingMap.get(vehicleType) >= maxAllotmentMap.get(vehicleType);
  }
}
