package com.parkingworld.parker.parkinglot.exception;

import com.parkingworld.parker.parkinglot.ParkingStatus;
import com.parkingworld.parker.vehicle.Vehicle;

public class ParkingDisplayBoard {

  private int id;

  void extractStats(ParkingStatus parkingStatus){
    if(parkingStatus.isFull(Vehicle.Type.CAR))
      showMessage("Parking full for car");
    //and so on
  }

  void showMessage(String message) {
    System.out.println(message);
  }
}
