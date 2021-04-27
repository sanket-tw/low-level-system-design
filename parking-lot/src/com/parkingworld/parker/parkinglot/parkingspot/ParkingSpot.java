package com.parkingworld.parker.parkinglot.parkingspot;

import com.parkingworld.parker.vehicle.Vehicle;

public abstract class ParkingSpot {

  private int id;
  private String spotNumber;
  private Vehicle vehicle;
  private final ParkingType parkingType;
  private STATUS status;

  protected ParkingSpot(ParkingType parkingType) {
    this.parkingType = parkingType;
  }

  public boolean isAvailable() {
    return STATUS.AVAILABLE.equals(status);
  }

  public void assignVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public void removeVehicle() {
    this.vehicle = null;
  }

  public int getId() {
    return id;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  enum STATUS {
    AVAILABLE, BOOKED, RESERVED
  }

  enum ParkingType {
    HANDICAPPED, COMPACT, LARGE, MOTORCYCLE, ELECTRIC
  }
}
