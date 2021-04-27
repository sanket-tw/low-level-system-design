package com.parkingworld.parker.payment;

import com.parkingworld.parker.items.Receipt;
import com.parkingworld.parker.items.Ticket;
import com.parkingworld.parker.parkinglot.ParkingRate;
import com.parkingworld.parker.vehicle.Vehicle;

import java.time.Duration;
import java.time.ZonedDateTime;

public class PaymentProcessor {

  private ParkingRate parkingRate;

  private Receipt receipt;

  public PaymentProcessor(ParkingRate parkingRate) {
    this.parkingRate = parkingRate;
  }

  void updateParkingRate(ParkingRate parkingRate) {
    this.parkingRate = parkingRate;
  }

  public Receipt process(Ticket ticket) {
    Vehicle vehicle = ticket.getVehicle();
    Duration duration = getDuration(ticket.getIssueTime());
    String cost = parkingRate.calculateCost(duration, vehicle.getVehicleType());
    return new Receipt(cost);
  }

  private Duration getDuration(ZonedDateTime dateOfIssue) {
    return Duration.ofHours(2);
  }

  public Receipt processPayment(Receipt receipt, String cash) {
    //update receipt status and cash
    return receipt.updatePayment(cash);
  }
}
