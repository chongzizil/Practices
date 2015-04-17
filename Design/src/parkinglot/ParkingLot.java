package parkinglot;

import java.util.Arrays;

/**
 * Created by youlongli on 4/16/15.
 */
public class ParkingLot {
  Level[] levels;

  public ParkingLot(int levelNum) {
    this.levels = new Level[levelNum];

    for (int i = 0; i < levelNum; i++) {
      levels[i] = new Level(/*level*/ i, /*row*/ 4, /*col*/ 10);
    }
  }

  public boolean parkVehicle(Vehicle vehicle) {
    for (int i = 0; i < levels.length; i++) {
      if (levels[i].parkVehicle(vehicle)) {
        return true;
      }
    }

    return false;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Parking lot ( " + levels.length + " Level):\n");
    for (int i = 0; i < levels.length; i++) {
      sb.append(levels[i].toString());
    }

    return sb.toString();
  }
}
