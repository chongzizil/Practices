package parkinglot;

import java.util.Arrays;

/**
 * Created by youlongli on 4/16/15.
 */
public class Level {
  ParkingSpot[][] spots;
  int availableSpots;
  int floor;

  public Level(int floor, int row, int col) {
    this.floor = floor;
    spots = new ParkingSpot[row][col];

    // TODO: Initial each spot
    for (int i = 0; i < row; i++) {
      int rowMod = i % 4;
      for (int j = 0; j < col; j++) {
        switch (rowMod) {
          case 0: spots[i][j] = new ParkingSpot(this, VehicleType.LARGE, i, j); break;
          case 1: spots[i][j] = new ParkingSpot(this, VehicleType.MOTORCYCLE, i, j); break;
          default: spots[i][j] = new ParkingSpot(this, VehicleType.COMPACT, i, j); break;
        }
      }
    }
  }

  public boolean parkVehicle(Vehicle vehicle) {
    ParkingSpot startSpot = findAvailableSpot(vehicle);
    if (startSpot == null) {
      return false;
    }

    return parkVehicle(vehicle, startSpot);
  }

  public ParkingSpot findAvailableSpot(Vehicle vehicle) {
    int spotsNeed = vehicle.getSpotNeeded();
    int spotsFound = 0;

    for (int i = 0; i < spots.length; i++) {
      spotsFound = 0;

      for (int j = 0; j < spots[i].length; j++) {
        if (spots[i][j].canPark(vehicle)) {
          spotsFound++;
        } else {
          spotsFound = 0;
        }

        if (spotsFound == spotsNeed) {
          return spots[i][j - spotsNeed + 1];
        }
      }
    }

    return null;
  }

  public boolean parkVehicle(Vehicle vehicle, ParkingSpot startSpot) {
    int row = startSpot.getRow();
    int col = startSpot.getCol();

    for (int i = col; i < col + vehicle.getSpotNeeded(); i++) {
      spots[row][i].park(vehicle);
    }

    return true;
  }

  public void spotFreed() {
    availableSpots++;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Level " + floor + ":\n");
    for (int i = 0; i < spots.length; i++) {
      sb.append("row " + i + ": ");
      for (int j = 0; j < spots[0].length; j++) {
        sb.append(spots[i][j].toString());
      }
      sb.append("\n");
    }

    return sb.toString();
  }
}
