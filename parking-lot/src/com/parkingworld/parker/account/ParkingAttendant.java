package com.parkingworld.parker.account;

import com.parkingworld.parker.items.Ticket;
import com.parkingworld.parker.parkinglot.ParkingLot;
import com.parkingworld.parker.parkinglot.exception.NoParkingAvailableException;
import com.parkingworld.parker.vehicle.Vehicle;

public class ParkingAttendant extends Account {

  private ParkingLot parkingLot = ParkingLot.getInstance();

  public Ticket generateTicket(Vehicle vehicle) throws NoParkingAvailableException {
    return parkingLot.getParkingTicket(vehicle);
  }
}
