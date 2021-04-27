package com.parkingworld.parker.parkinglot;

import com.parkingworld.parker.items.Receipt;
import com.parkingworld.parker.items.Ticket;
import com.parkingworld.parker.parkinglot.exception.NoParkingAvailableException;
import com.parkingworld.parker.parkinglot.parkingspot.ParkingSpot;
import com.parkingworld.parker.parkingstrategy.ParkingAllotment;
import com.parkingworld.parker.payment.PaymentProcessor;
import com.parkingworld.parker.payment.PaymentStatus;
import com.parkingworld.parker.vehicle.Vehicle;

import java.util.Map;

public class ParkingLot {
  //make it singleton
  private static ParkingLot parkingLot = null;

  private ParkingLot() {
  }

  public static ParkingLot getInstance() {
    if (parkingLot == null) {
      parkingLot = new ParkingLot();
    }
    return parkingLot;
  }

  private int id;
  private String name;
  //can be address class for multiple level address (mostly value object)
  private String address;
  private ParkingRate parkingRate;
  //why not here and why interface? parking strategy can differ based on geo/with time, parking lot need not care, its up to this interface to implement logic
  private ParkingAllotment parkingAllotment;
  private ParkingStatus parkingStatus;
  //why Map, why not list or array? They can grow or shrink. They need an identifier to access, for fast fetch, guarantees no 2 with same name/id
  private Map<String, ParkingFloor> parkingFloorList;
  private Map<String, EntrancePanel> entrancePanels;
  private Map<String, ExitPanel> exitPanels;


  private Map<String, Ticket> activeTickets;

  public synchronized Ticket getParkingTicket(Vehicle vehicle) throws NoParkingAvailableException {
    if (parkingStatus.isFull(vehicle.getVehicleType()))
      throw new NoParkingAvailableException();

    ParkingSpot parkingSpot = parkingAllotment.allotParkingSpot(vehicle);
    parkingStatus.increment(vehicle.getVehicleType());

    Ticket ticket = Ticket.withParkingSpot(parkingSpot);
    vehicle.assignTicket(ticket);
    this.activeTickets.put(ticket.getId(), ticket);
    return ticket;
  }

  public Map<String, ParkingFloor> getParkingFloorList() {
    return parkingFloorList;
  }

  public void addParkingFloor() {

  }

  void removeParkingFloor() {

  }

  void addEntrancePanel() {

  }

  void addExitPanel() {

  }

  void modifyParkingRate() {

  }

}
