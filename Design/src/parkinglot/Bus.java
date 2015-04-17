package parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 4/16/15.
 */
public class Bus extends Vehicle {
  public Bus(String plate) {
    this.plate = plate;
    this.spotNeeded = 5;
    this.type = VehicleType.LARGE;
    this.spots = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "B";
  }
}
