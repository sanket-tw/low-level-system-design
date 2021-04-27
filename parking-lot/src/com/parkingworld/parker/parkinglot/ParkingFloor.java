package com.parkingworld.parker.parkinglot;

import com.parkingworld.parker.parkinglot.exception.ParkingDisplayBoard;
import com.parkingworld.parker.items.Ticket;
import com.parkingworld.parker.parkinglot.parkingspot.CompactParkingSpot;
import com.parkingworld.parker.parkinglot.parkingspot.ParkingSpot;
import com.parkingworld.parker.vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;

public class ParkingFloor {

  private int id;

  private String name;

  private final HashMap<Integer, CompactParkingSpot> compactSpots = new HashMap<>();
  //and so on
  private ParkingDisplayBoard displayBoard;
  List<ParkingSpot> parkingSpotList;

  void displayMessage() {
  }

  public void addParkingSpot(ParkingSpot parkingSpot) {
    if (parkingSpot instanceof CompactParkingSpot)
      compactSpots.put(parkingSpot.getId(), (CompactParkingSpot) parkingSpot);
  }

  ParkingSpot assignSpot(Vehicle vehicle) {
    if (vehicle.getVehicleType().equals(Vehicle.Type.CAR)) {
      Integer spotId = compactSpots.keySet().stream().findAny().get();
      CompactParkingSpot parkingSpot = compactSpots.get(spotId);
      compactSpots.remove(spotId);
      return parkingSpot;
    }
    //and so on, basically depends on strategy used
    return null;
  }

  //is similar to add spot but can be done by Ticket
  void freeSport(Ticket ticket) {
    ParkingSpot parkingSpot = ticket.getParkingSpot();
    if (parkingSpot instanceof CompactParkingSpot)
      compactSpots.put(parkingSpot.getId(), (CompactParkingSpot) parkingSpot);
  }
}
