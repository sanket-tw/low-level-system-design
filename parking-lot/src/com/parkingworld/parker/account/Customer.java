package com.parkingworld.parker.account;

import com.parkingworld.parker.items.Receipt;
import com.parkingworld.parker.items.Ticket;
import com.parkingworld.parker.parkinglot.ExitPanel;
import com.parkingworld.parker.parkinglot.ParkingLot;
import com.parkingworld.parker.parkinglot.exception.NoParkingAvailableException;
import com.parkingworld.parker.payment.CreditCard;
import com.parkingworld.parker.vehicle.Vehicle;

public class Customer {

  private Ticket ticket;

  private Vehicle vehicle;

  private ParkingLot parkingLot;

  public void acceptTicket(Vehicle vehicle) throws NoParkingAvailableException {
    this.ticket = parkingLot.getParkingTicket(vehicle);
  }

  public Receipt scanTicket(Ticket ticket, ExitPanel exitPanel) {
    //who to call?
    return exitPanel.scanTicket(ticket);
  }

  public Receipt payTicket(Receipt receipt, String cash, ExitPanel exitPanel) {
    return exitPanel.processPayment(receipt, cash);
  }

  public Receipt payTicket(Receipt receipt, CreditCard creditCard, ExitPanel exitPanel) {
    return exitPanel.processPayment(receipt, creditCard);
  }
}
