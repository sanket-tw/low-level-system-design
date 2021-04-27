package com.parkingworld.parker.account;

import com.parkingworld.parker.parkinglot.ParkingFloor;
import com.parkingworld.parker.parkinglot.ParkingLot;
import com.parkingworld.parker.parkinglot.parkingspot.ParkingSpot;

public class Admin extends Account {

  void addParkingFloor(ParkingLot parkingLot){
    parkingLot.addParkingFloor();
  }

  void addParkingSpot(ParkingLot parkingLot, String parkingFloorId, ParkingSpot parkingSpot){
    parkingLot.getParkingFloorList().get(parkingFloorId).addParkingSpot(parkingSpot);
  }

  //and so on, depending on what admin can do

}
