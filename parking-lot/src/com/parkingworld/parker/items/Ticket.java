package com.parkingworld.parker.items;

import com.parkingworld.parker.parkinglot.parkingspot.ParkingSpot;
import com.parkingworld.parker.vehicle.Vehicle;

import java.time.ZonedDateTime;
import java.util.UUID;


public class Ticket {

  private Ticket(ParkingSpot parkingSpot) {
    this.id = UUID.randomUUID().toString();
    this.status = Status.ACTIVE;
    this.issueTime = ZonedDateTime.now();
    this.parkingSpot = parkingSpot;
  }

  public Vehicle getVehicle() {
    return assignedVehicle;
  }

  private enum Status {
    ACTIVE, PAID, LOST
  }


  private String id;
  private ZonedDateTime issueTime;
  private Status status;
  private ParkingSpot parkingSpot;
  private ZonedDateTime paidAtTime;
  private Vehicle assignedVehicle;

  public ParkingSpot getParkingSpot() {
    return parkingSpot;
  }

  public static Ticket withParkingSpot(ParkingSpot parkingSpot) {
    return new Ticket(parkingSpot);
  }

  public String getId() {
    return id;
  }

  public ZonedDateTime getIssueTime() {
    return issueTime;
  }

  void lost() {
    this.status = Status.LOST;
  }

  void ticketPaid() {
    this.status = Status.PAID;
    this.paidAtTime = ZonedDateTime.now();
  }
}
