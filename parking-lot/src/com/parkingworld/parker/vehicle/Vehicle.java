package com.parkingworld.parker.vehicle;

import com.parkingworld.parker.items.Ticket;

public abstract class Vehicle {

  public void assignTicket(Ticket ticket) {
    this.parkingTicket = ticket;
  }

  public Vehicle(Type vehicleType) {
    this.vehicleType = vehicleType;
  }

  public enum Type {
    CAR, TRUCK, ELECTRIC, VAN, MOTORBIKE
  }

  private int id;
  private String registrationNumber;
  private final Type vehicleType;
  private Ticket parkingTicket;

  public Type getVehicleType() {
    return vehicleType;
  }

  public Ticket getParkingTicket() {
    return parkingTicket;
  }
}
