package parkinglot;

import java.util.ArrayList;

/**
 * Created by youlongli on 4/16/15.
 */
public class Motorcycle extends Vehicle {
  public Motorcycle(String plate) {
    this.plate = plate;
    this.spotNeeded = 1;
    this.type = VehicleType.MOTORCYCLE;
    this.spots = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "M";
  }
}
